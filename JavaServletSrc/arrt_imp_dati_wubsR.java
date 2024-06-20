// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_wubs
import java.io.File; 
import java.util.Date; 
import java.lang.Double;
import jxl.*; 
import jxl.CellReferenceHelper;
import jxl.CellView;
import jxl.HeaderFooter;
import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.PageOrder;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Blank;
import jxl.write.Boolean;
import jxl.write.DateFormat;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
// * --- Fine Area Manuale
public class arrt_imp_dati_wubsR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_mtimport;
  public String m_cServer_mtimport;
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_tmp_impwu;
  public String m_cServer_tmp_impwu;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
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
  public String w_tipodest;
  public MemoryCursor_mcrowserrori_mcrdef mcErrori;
  public String _numprog;
  public String nomeesito;
  public String nomefilexls;
  public String filexls;
  public String fhand;
  public double nProg;
  public String nomefileimport;
  public String xConnes;
  public double conta;
  public double _nerrori;
  public String _tdest;
  public double _i;
  public String cOpeProg1;
  public String cOpeProg2;
  public double nProgImp;
  public String xData;
  public String _tiporap;
  public double nVal;
  public double ndVal;
  public double nChVal;
  public String cVal;
  public String cTVal;
  public String cCVal;
  public double nIntest;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public double _esito;
  public String _idbase;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _intertip;
  public String _ccab;
  public String _cprov;
  public String _ccap;
  public String _csta;
  public String _crag;
  public String _cbanca;
  public String _btipo;
  public String _bragsoc;
  public String _bcodcab;
  public String _bcitta;
  public String _bstato;
  public String _bprov;
  public String _cauana;
  public String _causin;
  public String _segno;
  public String _tipope;
  public String _rappd;
  public String _legrap;
  public String _idb2;
  public String _errore;
  public double nResult;
  public double _sogliamax;
  public java.sql.Date _limite20;
  public double _limitesoglia;
  public String _validstato;
  public double _nocf;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  public double righe;
  public String filenome;
  public String cell01;
  public String cell02;
  public String cell03;
  public String cell04;
  public String cell05;
  public String cell06;
  public String cell07;
  public String cell08;
  public double cell09;
  public double cell09c;
  public String cell10;
  public double cell11;
  public double cell11c;
  public String cell12;
  public String cell13;
  public String cell14;
  public String cell15;
  public String cell16;
  public String cell17;
  public String cell18;
  public String cell19;
  public String cell20;
  public String cell21;
  public String cell22;
  public String cell23;
  public String cell24;
  public String cell25;
  public String cell26;
  public String cell27;
  public String cell28;
  public String cell29;
  public String cell30;
  public String cell31;
  public String cell32;
  public String cell33;
  public String cell34;
  public String cell35;
  public String cell36;
  public String cell37;
  public String cell38;
  public String cell39;
  public String _rapporto;
  public double _contadel;
  public String _ragsoc;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_wubs
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int riga;
  // * --- Fine Area Manuale
  public arrt_imp_dati_wubsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_wubs",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    if (m_cPhName_wucodes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wucodes = m_cPhName_wucodes+" "+m_Ctx.GetWritePhName("wucodes");
    }
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_mtimport = p_ContextObject.GetPhName("mtimport");
    if (m_cPhName_mtimport.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimport = m_cPhName_mtimport+" "+m_Ctx.GetWritePhName("mtimport");
    }
    m_cServer_mtimport = p_ContextObject.GetServer("mtimport");
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
      m_cPhName_tmp_impwu = p_ContextObject.GetPhName("tmp_impwu");
      if (m_cPhName_tmp_impwu.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_impwu = m_cPhName_tmp_impwu+" "+m_Ctx.GetWritePhName("tmp_impwu");
      }
      m_cServer_tmp_impwu = p_ContextObject.GetServer("tmp_impwu");
    }
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      return _nerrori;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      return nVal;
    }
    if (CPLib.eqr("ndVal",p_cVarName)) {
      return ndVal;
    }
    if (CPLib.eqr("nChVal",p_cVarName)) {
      return nChVal;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      return nIntest;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      return cNumInv;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("nResult",p_cVarName)) {
      return nResult;
    }
    if (CPLib.eqr("_sogliamax",p_cVarName)) {
      return _sogliamax;
    }
    if (CPLib.eqr("_limitesoglia",p_cVarName)) {
      return _limitesoglia;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      return _nocf;
    }
    if (CPLib.eqr("righe",p_cVarName)) {
      return righe;
    }
    if (CPLib.eqr("cell09",p_cVarName)) {
      return cell09;
    }
    if (CPLib.eqr("cell09c",p_cVarName)) {
      return cell09c;
    }
    if (CPLib.eqr("cell11",p_cVarName)) {
      return cell11;
    }
    if (CPLib.eqr("cell11c",p_cVarName)) {
      return cell11c;
    }
    if (CPLib.eqr("_contadel",p_cVarName)) {
      return _contadel;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_wubs";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      return nomeesito;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      return nomefilexls;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      return filexls;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("cVal",p_cVarName)) {
      return cVal;
    }
    if (CPLib.eqr("cTVal",p_cVarName)) {
      return cTVal;
    }
    if (CPLib.eqr("cCVal",p_cVarName)) {
      return cCVal;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      return xDIP;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      return xDIPx;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
    }
    if (CPLib.eqr("_ccab",p_cVarName)) {
      return _ccab;
    }
    if (CPLib.eqr("_cprov",p_cVarName)) {
      return _cprov;
    }
    if (CPLib.eqr("_ccap",p_cVarName)) {
      return _ccap;
    }
    if (CPLib.eqr("_csta",p_cVarName)) {
      return _csta;
    }
    if (CPLib.eqr("_crag",p_cVarName)) {
      return _crag;
    }
    if (CPLib.eqr("_cbanca",p_cVarName)) {
      return _cbanca;
    }
    if (CPLib.eqr("_btipo",p_cVarName)) {
      return _btipo;
    }
    if (CPLib.eqr("_bragsoc",p_cVarName)) {
      return _bragsoc;
    }
    if (CPLib.eqr("_bcodcab",p_cVarName)) {
      return _bcodcab;
    }
    if (CPLib.eqr("_bcitta",p_cVarName)) {
      return _bcitta;
    }
    if (CPLib.eqr("_bstato",p_cVarName)) {
      return _bstato;
    }
    if (CPLib.eqr("_bprov",p_cVarName)) {
      return _bprov;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      return _cauana;
    }
    if (CPLib.eqr("_causin",p_cVarName)) {
      return _causin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_rappd",p_cVarName)) {
      return _rappd;
    }
    if (CPLib.eqr("_legrap",p_cVarName)) {
      return _legrap;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_validstato",p_cVarName)) {
      return _validstato;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      return filenome;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      return cell01;
    }
    if (CPLib.eqr("cell02",p_cVarName)) {
      return cell02;
    }
    if (CPLib.eqr("cell03",p_cVarName)) {
      return cell03;
    }
    if (CPLib.eqr("cell04",p_cVarName)) {
      return cell04;
    }
    if (CPLib.eqr("cell05",p_cVarName)) {
      return cell05;
    }
    if (CPLib.eqr("cell06",p_cVarName)) {
      return cell06;
    }
    if (CPLib.eqr("cell07",p_cVarName)) {
      return cell07;
    }
    if (CPLib.eqr("cell08",p_cVarName)) {
      return cell08;
    }
    if (CPLib.eqr("cell10",p_cVarName)) {
      return cell10;
    }
    if (CPLib.eqr("cell12",p_cVarName)) {
      return cell12;
    }
    if (CPLib.eqr("cell13",p_cVarName)) {
      return cell13;
    }
    if (CPLib.eqr("cell14",p_cVarName)) {
      return cell14;
    }
    if (CPLib.eqr("cell15",p_cVarName)) {
      return cell15;
    }
    if (CPLib.eqr("cell16",p_cVarName)) {
      return cell16;
    }
    if (CPLib.eqr("cell17",p_cVarName)) {
      return cell17;
    }
    if (CPLib.eqr("cell18",p_cVarName)) {
      return cell18;
    }
    if (CPLib.eqr("cell19",p_cVarName)) {
      return cell19;
    }
    if (CPLib.eqr("cell20",p_cVarName)) {
      return cell20;
    }
    if (CPLib.eqr("cell21",p_cVarName)) {
      return cell21;
    }
    if (CPLib.eqr("cell22",p_cVarName)) {
      return cell22;
    }
    if (CPLib.eqr("cell23",p_cVarName)) {
      return cell23;
    }
    if (CPLib.eqr("cell24",p_cVarName)) {
      return cell24;
    }
    if (CPLib.eqr("cell25",p_cVarName)) {
      return cell25;
    }
    if (CPLib.eqr("cell26",p_cVarName)) {
      return cell26;
    }
    if (CPLib.eqr("cell27",p_cVarName)) {
      return cell27;
    }
    if (CPLib.eqr("cell28",p_cVarName)) {
      return cell28;
    }
    if (CPLib.eqr("cell29",p_cVarName)) {
      return cell29;
    }
    if (CPLib.eqr("cell30",p_cVarName)) {
      return cell30;
    }
    if (CPLib.eqr("cell31",p_cVarName)) {
      return cell31;
    }
    if (CPLib.eqr("cell32",p_cVarName)) {
      return cell32;
    }
    if (CPLib.eqr("cell33",p_cVarName)) {
      return cell33;
    }
    if (CPLib.eqr("cell34",p_cVarName)) {
      return cell34;
    }
    if (CPLib.eqr("cell35",p_cVarName)) {
      return cell35;
    }
    if (CPLib.eqr("cell36",p_cVarName)) {
      return cell36;
    }
    if (CPLib.eqr("cell37",p_cVarName)) {
      return cell37;
    }
    if (CPLib.eqr("cell38",p_cVarName)) {
      return cell38;
    }
    if (CPLib.eqr("cell39",p_cVarName)) {
      return cell39;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_limite20",p_cVarName)) {
      return _limite20;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
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
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      _nerrori = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nVal",p_cVarName)) {
      nVal = value;
      return;
    }
    if (CPLib.eqr("ndVal",p_cVarName)) {
      ndVal = value;
      return;
    }
    if (CPLib.eqr("nChVal",p_cVarName)) {
      nChVal = value;
      return;
    }
    if (CPLib.eqr("nIntest",p_cVarName)) {
      nIntest = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      cNumInv = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("nResult",p_cVarName)) {
      nResult = value;
      return;
    }
    if (CPLib.eqr("_sogliamax",p_cVarName)) {
      _sogliamax = value;
      return;
    }
    if (CPLib.eqr("_limitesoglia",p_cVarName)) {
      _limitesoglia = value;
      return;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      _nocf = value;
      return;
    }
    if (CPLib.eqr("righe",p_cVarName)) {
      righe = value;
      return;
    }
    if (CPLib.eqr("cell09",p_cVarName)) {
      cell09 = value;
      return;
    }
    if (CPLib.eqr("cell09c",p_cVarName)) {
      cell09c = value;
      return;
    }
    if (CPLib.eqr("cell11",p_cVarName)) {
      cell11 = value;
      return;
    }
    if (CPLib.eqr("cell11c",p_cVarName)) {
      cell11c = value;
      return;
    }
    if (CPLib.eqr("_contadel",p_cVarName)) {
      _contadel = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      nomeesito = value;
      return;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      nomefilexls = value;
      return;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      filexls = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("cVal",p_cVarName)) {
      cVal = value;
      return;
    }
    if (CPLib.eqr("cTVal",p_cVarName)) {
      cTVal = value;
      return;
    }
    if (CPLib.eqr("cCVal",p_cVarName)) {
      cCVal = value;
      return;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
      return;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      xDIP = value;
      return;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      xDIPx = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
      return;
    }
    if (CPLib.eqr("_ccab",p_cVarName)) {
      _ccab = value;
      return;
    }
    if (CPLib.eqr("_cprov",p_cVarName)) {
      _cprov = value;
      return;
    }
    if (CPLib.eqr("_ccap",p_cVarName)) {
      _ccap = value;
      return;
    }
    if (CPLib.eqr("_csta",p_cVarName)) {
      _csta = value;
      return;
    }
    if (CPLib.eqr("_crag",p_cVarName)) {
      _crag = value;
      return;
    }
    if (CPLib.eqr("_cbanca",p_cVarName)) {
      _cbanca = value;
      return;
    }
    if (CPLib.eqr("_btipo",p_cVarName)) {
      _btipo = value;
      return;
    }
    if (CPLib.eqr("_bragsoc",p_cVarName)) {
      _bragsoc = value;
      return;
    }
    if (CPLib.eqr("_bcodcab",p_cVarName)) {
      _bcodcab = value;
      return;
    }
    if (CPLib.eqr("_bcitta",p_cVarName)) {
      _bcitta = value;
      return;
    }
    if (CPLib.eqr("_bstato",p_cVarName)) {
      _bstato = value;
      return;
    }
    if (CPLib.eqr("_bprov",p_cVarName)) {
      _bprov = value;
      return;
    }
    if (CPLib.eqr("_cauana",p_cVarName)) {
      _cauana = value;
      return;
    }
    if (CPLib.eqr("_causin",p_cVarName)) {
      _causin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_rappd",p_cVarName)) {
      _rappd = value;
      return;
    }
    if (CPLib.eqr("_legrap",p_cVarName)) {
      _legrap = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_validstato",p_cVarName)) {
      _validstato = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      filenome = value;
      return;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      cell01 = value;
      return;
    }
    if (CPLib.eqr("cell02",p_cVarName)) {
      cell02 = value;
      return;
    }
    if (CPLib.eqr("cell03",p_cVarName)) {
      cell03 = value;
      return;
    }
    if (CPLib.eqr("cell04",p_cVarName)) {
      cell04 = value;
      return;
    }
    if (CPLib.eqr("cell05",p_cVarName)) {
      cell05 = value;
      return;
    }
    if (CPLib.eqr("cell06",p_cVarName)) {
      cell06 = value;
      return;
    }
    if (CPLib.eqr("cell07",p_cVarName)) {
      cell07 = value;
      return;
    }
    if (CPLib.eqr("cell08",p_cVarName)) {
      cell08 = value;
      return;
    }
    if (CPLib.eqr("cell10",p_cVarName)) {
      cell10 = value;
      return;
    }
    if (CPLib.eqr("cell12",p_cVarName)) {
      cell12 = value;
      return;
    }
    if (CPLib.eqr("cell13",p_cVarName)) {
      cell13 = value;
      return;
    }
    if (CPLib.eqr("cell14",p_cVarName)) {
      cell14 = value;
      return;
    }
    if (CPLib.eqr("cell15",p_cVarName)) {
      cell15 = value;
      return;
    }
    if (CPLib.eqr("cell16",p_cVarName)) {
      cell16 = value;
      return;
    }
    if (CPLib.eqr("cell17",p_cVarName)) {
      cell17 = value;
      return;
    }
    if (CPLib.eqr("cell18",p_cVarName)) {
      cell18 = value;
      return;
    }
    if (CPLib.eqr("cell19",p_cVarName)) {
      cell19 = value;
      return;
    }
    if (CPLib.eqr("cell20",p_cVarName)) {
      cell20 = value;
      return;
    }
    if (CPLib.eqr("cell21",p_cVarName)) {
      cell21 = value;
      return;
    }
    if (CPLib.eqr("cell22",p_cVarName)) {
      cell22 = value;
      return;
    }
    if (CPLib.eqr("cell23",p_cVarName)) {
      cell23 = value;
      return;
    }
    if (CPLib.eqr("cell24",p_cVarName)) {
      cell24 = value;
      return;
    }
    if (CPLib.eqr("cell25",p_cVarName)) {
      cell25 = value;
      return;
    }
    if (CPLib.eqr("cell26",p_cVarName)) {
      cell26 = value;
      return;
    }
    if (CPLib.eqr("cell27",p_cVarName)) {
      cell27 = value;
      return;
    }
    if (CPLib.eqr("cell28",p_cVarName)) {
      cell28 = value;
      return;
    }
    if (CPLib.eqr("cell29",p_cVarName)) {
      cell29 = value;
      return;
    }
    if (CPLib.eqr("cell30",p_cVarName)) {
      cell30 = value;
      return;
    }
    if (CPLib.eqr("cell31",p_cVarName)) {
      cell31 = value;
      return;
    }
    if (CPLib.eqr("cell32",p_cVarName)) {
      cell32 = value;
      return;
    }
    if (CPLib.eqr("cell33",p_cVarName)) {
      cell33 = value;
      return;
    }
    if (CPLib.eqr("cell34",p_cVarName)) {
      cell34 = value;
      return;
    }
    if (CPLib.eqr("cell35",p_cVarName)) {
      cell35 = value;
      return;
    }
    if (CPLib.eqr("cell36",p_cVarName)) {
      cell36 = value;
      return;
    }
    if (CPLib.eqr("cell37",p_cVarName)) {
      cell37 = value;
      return;
    }
    if (CPLib.eqr("cell38",p_cVarName)) {
      cell38 = value;
      return;
    }
    if (CPLib.eqr("cell39",p_cVarName)) {
      cell39 = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_limite20",p_cVarName)) {
      _limite20 = value;
      return;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcrowserrori_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_tipodest Char(1) */
      /* mcErrori MemoryCursor(mcRowsErrori.MCRDef) */
      /* _numprog Char(11) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* filexls Char(128) */
      /* fhand Char(1) */
      /* nProg Numeric(10, 0) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* conta Numeric(10, 0) */
      /* _nerrori Numeric(10, 0) */
      /* _tdest Char(1) */
      /* _i Numeric(1, 0) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* xData Char(8) */
      /* _tiporap Char(1) */
      /* nVal Numeric(15, 0) */
      /* ndVal Numeric(15, 2) */
      /* nChVal Numeric(9, 4) */
      /* cVal Char(15) */
      /* cTVal Char(1) */
      /* cCVal Char(3) */
      /* nIntest Numeric(3, 0) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* _esito Numeric(1, 0) */
      /* _idbase Char(10) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _intertip Char(2) */
      /* _ccab Char(6) */
      /* _cprov Char(2) */
      /* _ccap Char(9) */
      /* _csta Char(3) */
      /* _crag Char(70) */
      /* _cbanca Char(11) */
      /* _btipo Char(2) */
      /* _bragsoc Char(70) */
      /* _bcodcab Char(6) */
      /* _bcitta Char(30) */
      /* _bstato Char(3) */
      /* _bprov Char(2) */
      /* _cauana Char(4) */
      /* _causin Char(2) */
      /* _segno Char(1) */
      /* _tipope Char(2) */
      /* _rappd Char(1) */
      /* _legrap Char(16) */
      /* _idb2 Char(10) */
      /* _errore Memo */
      /* nResult Numeric(1, 0) */
      /* _sogliamax Numeric(12, 2) */
      /* _limite20 Date */
      /* _limitesoglia Numeric(12, 2) */
      /* _validstato Char(3) */
      /* _nocf Numeric(1, 0) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* righe Numeric(10, 0) */
      /* filenome Char(100) */
      /* cell01 Char(100) */
      /* cell02 Char(100) */
      /* cell03 Char(100) */
      /* cell04 Char(100) */
      /* cell05 Char(100) */
      /* cell06 Char(100) */
      /* cell07 Char(100) */
      /* cell08 Char(100) */
      /* cell09 Numeric(15, 10) */
      /* cell09c Numeric(30, 0) */
      /* cell10 Char(100) */
      /* cell11 Numeric(15, 4) */
      /* cell11c Numeric(30, 0) */
      /* cell12 Char(100) */
      /* cell13 Char(100) */
      /* cell14 Char(100) */
      /* cell15 Char(100) */
      /* cell16 Char(100) */
      /* cell17 Char(100) */
      /* cell18 Char(100) */
      /* cell19 Char(100) */
      /* cell20 Char(100) */
      /* cell21 Char(100) */
      /* cell22 Char(100) */
      /* cell23 Char(100) */
      /* cell24 Char(100) */
      /* cell25 Char(100) */
      /* cell26 Char(100) */
      /* cell27 Char(100) */
      /* cell28 Char(100) */
      /* cell29 Char(100) */
      /* cell30 Char(100) */
      /* cell31 Char(100) */
      /* cell32 Char(100) */
      /* cell33 Char(100) */
      /* cell34 Char(100) */
      /* cell35 Char(100) */
      /* cell36 Char(100) */
      /* cell37 Char(100) */
      /* cell38 Char(100) */
      /* cell39 Char(0) */
      /* _rapporto Char(25) */
      /* _contadel Numeric(3, 0) */
      /* _ragsoc Char(70) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gUrlApp Char(80) // URL Applicazione */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      // * --- Drop temporary table tmp_impwu
      if (m_Ctx.IsSharedTemp("tmp_impwu")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
          m_cServer = m_Ctx.GetServer("tmp_impwu");
          m_cPhName = m_Ctx.GetPhName("tmp_impwu");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impwu");
      }
      // * --- Create temporary table tmp_impwu
      if (m_Ctx.IsSharedTemp("tmp_impwu")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
          m_cServer = m_Ctx.GetServer("tmp_impwu");
          m_cPhName = m_Ctx.GetPhName("tmp_impwu");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impwu");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_impwu");
      if ( ! (m_Ctx.IsSharedTemp("tmp_impwu"))) {
        m_cServer = m_Ctx.GetServer("tmp_impwu");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_impwu",m_cServer,"proto")),m_cPhName,"tmp_impwu",m_Ctx,new String[]{"WUNOMEFILE,WURIFEMTCN"});
      }
      m_cPhName_tmp_impwu = m_cPhName;
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
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _intercod := intermbo->CODINTER */
        _intercod = Cursor_intermbo.GetString("CODINTER");
        /* _intercit := intermbo->DESCCIT */
        _intercit = Cursor_intermbo.GetString("DESCCIT");
        /* _intercab := intermbo->CODCAB */
        _intercab = Cursor_intermbo.GetString("CODCAB");
        /* _interprv := intermbo->PROVINCIA */
        _interprv = Cursor_intermbo.GetString("PROVINCIA");
        /* _intertip := intermbo->TIPINTER */
        _intertip = Cursor_intermbo.GetString("TIPINTER");
        /* _sogliamax := intermbo->SOGLIAMAX */
        _sogliamax = CPLib.Round(Cursor_intermbo.GetDouble("SOGLIAMAX"),2);
        /* _limite20 := iif(Empty(intermbo->LIMITE20),CharToDate('20201231'),intermbo->LIMITE20) */
        _limite20 = (CPLib.Empty(Cursor_intermbo.GetDate("LIMITE20"))?CPLib.CharToDate("20201231"):Cursor_intermbo.GetDate("LIMITE20"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000096status;
      nTry00000096status = m_Sql.GetTransactionStatus();
      String cTry00000096msg;
      cTry00000096msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
          nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* Exec "Elabora il file WUBS XLS" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Delete from tmp_list_imprich
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000009B")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* If mcErrori.RecCount() > 0 */
        if (CPLib.gt(mcErrori.RecCount(),0)) {
          /* Exec "Scrive Foglio Excel Errori" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgImp := 'Rilevati Errori da Correggere. Prelevare il file' // Messaggio Import */
          gMsgImp = "Rilevati Errori da Correggere. Prelevare il file";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* nResult := 1 */
          nResult = CPLib.Round(1,0);
        } else { // Else
          /* nResult := 0 */
          nResult = CPLib.Round(0,0);
          /* gMsgImp := 'Importazione dati terminata con successo.' // Messaggio Import */
          gMsgImp = "Importazione dati terminata con successo.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := "Importazione dati terminata con errori. Ricreare il file e rieseguire l'import" // Messaggio Import */
        gMsgImp = "Importazione dati terminata con errori. Ricreare il file e rieseguire l'import";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* nResult := 2 */
        nResult = CPLib.Round(2,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000096status,0)) {
          m_Sql.SetTransactionStatus(nTry00000096status,cTry00000096msg);
        }
      }
      /* Return nResult */
      throw new Stop(nResult);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    try {
      /* Setta il nome del file */
      /* filenome := LRTrim(gPathApp)+'/appo/'+LRTrim(gAzienda)+"/"+LRTrim(nomefileimport) */
      filenome = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport);
      // Legge il worksheet
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(filenome))); 
      nfogli = workbook.getNumberOfSheets();
      Cell[] row = null;
      NumberCell nc = null;
      for (int foglio = 0 ; foglio < nfogli ; foglio++) {
        Sheet sheet = workbook.getSheet(foglio); 
        righe=0;
      /* gMsgProc := gMsgProc + 'Elaborazione File: '+LRTrim(nomefileimport)+ ' - Foglio N. :'+LRTrim(Str(foglio,5,0)) + NL */
      gMsgProc = gMsgProc+"Elaborazione File: "+CPLib.LRTrim(nomefileimport)+" - Foglio N. :"+CPLib.LRTrim(CPLib.Str(foglio,5,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Legge le righe del foglio
        for (int riga = 1 ; riga < sheet.getRows() ; riga++) {
          row = sheet.getRow(riga);          
          if (row.length > 0 && CPLib.LRTrim(row[0].getContents()) != "" ) {
            cell01=row[0].getContents();
            cell02=row[1].getContents();
            cell03=row[2].getContents();
            cell04=row[3].getContents();
            cell05=row[4].getContents();
            cell06=row[5].getContents();
            cell07=row[6].getContents();
            cell08=row[7].getContents();
            nc = (NumberCell) row[8];
            cell09=nc.getValue();
            cell10=row[9].getContents();
            nc = (NumberCell) row[10];
            cell11=nc.getValue();
            cell12=row[11].getContents();
            cell13=row[12].getContents();
            cell14=row[13].getContents();
            cell15=row[14].getContents();  
            cell16=row[15].getContents();
            cell17=row[16].getContents();
            cell18=row[17].getContents();
            cell19=row[18].getContents();
            cell20=row[19].getContents();
            cell21=row[20].getContents();
            cell22=row[21].getContents();
            cell23=row[22].getContents();
            cell24=row[23].getContents();
            cell25=row[24].getContents();
            cell26=row[25].getContents();
            cell27=row[26].getContents();
            cell28=row[27].getContents();
            cell29=row[28].getContents();
            cell30=row[29].getContents();
            cell31=row[30].getContents();
            cell32=row[31].getContents();
            cell33=row[32].getContents();
            cell34=row[33].getContents();
            cell35=row[34].getContents();
            cell36=row[35].getContents();
            cell37=row[36].getContents();
            cell38=row[37].getContents();
            cell39=row[38].getContents();
            righe++;
      /* If cell39='I' */
      if (CPLib.eqr(cell39,"I")) {
        /* _errore := '' */
        _errore = "";
        /* _rapporto := '' */
        _rapporto = "";
        /* _cauana := '' */
        _cauana = "";
        /* _causin := '' */
        _causin = "";
        /* gMsgProc := gMsgProc + 'Inserimento operazione N. '+LRTrim(cell06)+" del Customer ID "+LRTrim(cell04) + NL */
        gMsgProc = gMsgProc+"Inserimento operazione N. "+CPLib.LRTrim(cell06)+" del Customer ID "+CPLib.LRTrim(cell04)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Inserimento operazione N. '+LRTrim(cell06)+" del Customer ID "+LRTrim(cell04) // Messaggio Import */
        gMsgImp = "Inserimento operazione N. "+CPLib.LRTrim(cell06)+" del Customer ID "+CPLib.LRTrim(cell04);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If ((Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Left(cell06,3) = 'TCP') */
        if (((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.eqr(CPLib.Left(cell06,3),"TCP"))) {
          /* xData := Strtran(LRTrim(cell02),"-","") */
          xData = CPLib.Strtran(CPLib.LRTrim(cell02),"-","");
          /* If Left(LRTrim(cell23),3)='086' */
          if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(cell23),3),"086")) {
            /* _cauana := '48' */
            _cauana = "48";
            /* _btipo := '02' */
            _btipo = "02";
          } else { // Else
            /* _cauana := 'AA' */
            _cauana = "AA";
            /* _btipo := '12' */
            _btipo = "12";
          } // End If
          /* If _intertip='02' */
          if (CPLib.eqr(_intertip,"02")) {
            /* _causin := '2B' */
            _causin = "2B";
          } else { // Else
            /* _causin := '4M' */
            _causin = "4M";
          } // End If
          /* _segno := 'A' */
          _segno = "A";
          /* _tipope := '12' */
          _tipope = "12";
          /* ElseIf ((Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Left(cell06,3) <> 'TCP') */
        } else if (((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.ne(CPLib.Left(cell06,3),"TCP"))) {
          /* xData := Strtran(LRTrim(cell02),"-","") */
          xData = CPLib.Strtran(CPLib.LRTrim(cell02),"-","");
          /* If Left(LRTrim(cell33),3)='086' */
          if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(cell33),3),"086")) {
            /* _cauana := '48' */
            _cauana = "48";
            /* _btipo := '02' */
            _btipo = "02";
          } else { // Else
            /* _cauana := 'AA' */
            _cauana = "AA";
            /* _btipo := '12' */
            _btipo = "12";
          } // End If
          /* If _intertip='02' */
          if (CPLib.eqr(_intertip,"02")) {
            /* _causin := '2B' */
            _causin = "2B";
          } else { // Else
            /* _causin := '4M' */
            _causin = "4M";
          } // End If
          /* _segno := 'A' */
          _segno = "A";
          /* _tipope := '12' */
          _tipope = "12";
        } else { // Else
          /* xData := Strtran(LRTrim(cell03),"-","") */
          xData = CPLib.Strtran(CPLib.LRTrim(cell03),"-","");
          /* If Left(LRTrim(cell23),3)='086' */
          if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(cell23),3),"086")) {
            /* _cauana := '26' */
            _cauana = "26";
            /* _btipo := '02' */
            _btipo = "02";
          } else { // Else
            /* _cauana := 'AA' */
            _cauana = "AA";
            /* _btipo := '12' */
            _btipo = "12";
          } // End If
          /* If _intertip='02' */
          if (CPLib.eqr(_intertip,"02")) {
            /* _causin := '1B' */
            _causin = "1B";
          } else { // Else
            /* _causin := '3M' */
            _causin = "3M";
          } // End If
          /* _segno := 'D' */
          _segno = "D";
          /* _tipope := '11' */
          _tipope = "11";
        } // End If
        /* _limitesoglia := iif(CharToDate(xData) > _limite20,500000,1500000) */
        _limitesoglia = CPLib.Round((CPLib.gt(CPLib.CharToDate(xData),_limite20)?500000:1500000),2);
        /* cCVal := '' */
        cCVal = "";
        /* ndVal := (cell11 * cell09) */
        ndVal = CPLib.Round((cell11*cell09),2);
        /* nVal := ndVal * 100 */
        nVal = CPLib.Round(ndVal*100,0);
        /* If nVal >= _limitesoglia */
        if (CPLib.ge(nVal,_limitesoglia)) {
          /* nChVal := cell09 */
          nChVal = CPLib.Round(cell09,4);
          /* If LRTrim(cell08)='EUR' */
          if (CPLib.eqr(CPLib.LRTrim(cell08),"EUR")) {
            /* cTVal := '3' */
            cTVal = "3";
            /* cCVal := '242' */
            cCVal = "242";
          } else { // Else
            /* cTVal := '4' */
            cTVal = "4";
            /* cCVal := '' */
            cCVal = "";
            // * --- Read from tbvalute
            m_cServer = m_Ctx.GetServer("tbvalute");
            m_cPhName = m_Ctx.GetPhName("tbvalute");
            m_cSql = "";
            m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell08),3),"C",3,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(cell08),3));
            if (m_Ctx.IsSharedTemp("tbvalute")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODVAL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              cCVal = Read_Cursor.GetString("CODVAL");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbvalute into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              cCVal = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(LRTrim(cCVal)) */
          if (CPLib.Empty(CPLib.LRTrim(cCVal))) {
            /* _errore := _errore + "* Codice valuta assente o errato " + NL */
            _errore = _errore+"* Codice valuta assente o errato "+"\n";
          } // End If
          /* _rappd := 'D' */
          _rappd = "D";
          /* _tiporap := '' */
          _tiporap = "";
          /* _rapporto := '' */
          _rapporto = "";
          /* _legrap := '' */
          _legrap = "";
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"SPLITCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell04),"C",15,0,m_cServer),m_cServer,CPLib.LRTrim(cell04));
          if (m_Ctx.IsSharedTemp("anarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICELR",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            _tiporap = Read_Cursor.GetString("TIPORAP");
            _legrap = Read_Cursor.GetString("CODICELR");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            _tiporap = "";
            _legrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_rapporto)) */
          if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
            // * --- Read from xnarapbo
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"SPLITCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell04),"C",15,0,m_cServer),m_cServer,CPLib.LRTrim(cell04));
            if (m_Ctx.IsSharedTemp("xnarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPORAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODICELR",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              _tiporap = Read_Cursor.GetString("TIPORAP");
              _legrap = Read_Cursor.GetString("CODICELR");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xnarapbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _rapporto = "";
              _tiporap = "";
              _legrap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _rappd := 'P' */
            _rappd = "P";
          } // End If
          /* If Empty(LRTrim(_rapporto)) */
          if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
            /* _errore := _errore + "* Customer ID non presente in AUI " + NL */
            _errore = _errore+"* Customer ID non presente in AUI "+"\n";
          } // End If
          /* If not(Empty(LRTrim(_rapporto))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_rapporto)))) {
            /* If Empty(LRTrim(_legrap)) */
            if (CPLib.Empty(CPLib.LRTrim(_legrap))) {
              /* _errore := _errore + "* Manca NDG legale rappresentante " + NL */
              _errore = _errore+"* Manca NDG legale rappresentante "+"\n";
              /* _contadel := 0 */
              _contadel = CPLib.Round(0,0);
              /* If _rappd='D' */
              if (CPLib.eqr(_rappd,"D")) {
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  /* _contadel := _contadel + 1 */
                  _contadel = CPLib.Round(_contadel+1,0);
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
                /* ElseIf _rappd='P' */
              } else if (CPLib.eqr(_rappd,"P")) {
                // * --- Select from xelegabo
                m_cServer = m_Ctx.GetServer("xelegabo");
                m_cPhName = m_Ctx.GetPhName("xelegabo");
                if (Cursor_xelegabo!=null)
                  Cursor_xelegabo.Close();
                Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_xelegabo.Eof())) {
                  /* _contadel := _contadel + 1 */
                  _contadel = CPLib.Round(_contadel+1,0);
                  Cursor_xelegabo.Next();
                }
                m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
                Cursor_xelegabo.Close();
                // * --- End Select
              } // End If
              /* If _contadel = 0 */
              if (CPLib.eqr(_contadel,0)) {
                /* _errore := _errore + "* Mancano i delegati per il rapporto" + NL */
                _errore = _errore+"* Mancano i delegati per il rapporto"+"\n";
              } // End If
            } // End If
            /* If _rappd='D' */
            if (CPLib.eqr(_rappd,"D")) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If not(arfn_chksogg(intestbo->CODINTER,'7')) */
                if ( ! (arfn_chksoggR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),"7"))) {
                  /* _errore := _errore + "* Mancano alcuni dati anagrafici soggetto" + NL */
                  _errore = _errore+"* Mancano alcuni dati anagrafici soggetto"+"\n";
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
              /* ElseIf _rappd='P' */
            } else if (CPLib.eqr(_rappd,"P")) {
              // * --- Select from xntestbo
              m_cServer = m_Ctx.GetServer("xntestbo");
              m_cPhName = m_Ctx.GetPhName("xntestbo");
              if (Cursor_xntestbo!=null)
                Cursor_xntestbo.Close();
              Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xntestbo.Eof())) {
                /* If not(arfn_chksogg(xntestbo->CODINTER,'7')) */
                if ( ! (arfn_chksoggR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),"7"))) {
                  /* _errore := _errore + "* Mancano alcuni dati anagrafici soggetto" + NL */
                  _errore = _errore+"* Mancano alcuni dati anagrafici soggetto"+"\n";
                } // End If
                Cursor_xntestbo.Next();
              }
              m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
              Cursor_xntestbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If not(Empty(LRTrim(cell18))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(cell18)))) {
            /* _validstato := '' */
            _validstato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)),"C",3,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _validstato = Read_Cursor.GetString("CODSTA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _validstato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_validstato)) */
            if (CPLib.Empty(CPLib.LRTrim(_validstato))) {
              /* _errore := _errore + "* Stato Controparte Errato" + NL */
              _errore = _errore+"* Stato Controparte Errato"+"\n";
            } // End If
          } // End If
          /* If ((Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Left(cell06,3) = 'TCP') */
          if (((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.eqr(CPLib.Left(cell06,3),"TCP"))) {
            /* If not(Empty(LRTrim(cell23))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(cell23)))) {
              /* _validstato := '' */
              _validstato = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)),"C",3,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _validstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _validstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_validstato)) */
              if (CPLib.Empty(CPLib.LRTrim(_validstato))) {
                /* _errore := _errore + "* Stato Intermediario Controparte Errato" + NL */
                _errore = _errore+"* Stato Intermediario Controparte Errato"+"\n";
              } // End If
            } // End If
          } else { // Else
            /* If not(Empty(LRTrim(cell23))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(cell23)))) {
              /* _validstato := '' */
              _validstato = "";
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)),"C",3,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _validstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _validstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_validstato)) */
              if (CPLib.Empty(CPLib.LRTrim(_validstato))) {
                /* _errore := _errore + "* Stato Intermediario Controparte Errato" + NL */
                _errore = _errore+"* Stato Intermediario Controparte Errato"+"\n";
              } // End If
            } // End If
          } // End If
          /* If not(Empty(LRTrim(cell37))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(cell37)))) {
            /* If _rappd='D' */
            if (CPLib.eqr(_rappd,"D")) {
              // * --- Select from delegabo
              m_cServer = m_Ctx.GetServer("delegabo");
              m_cPhName = m_Ctx.GetPhName("delegabo");
              if (Cursor_delegabo!=null)
                Cursor_delegabo.Close();
              Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_delegabo.Eof())) {
                /* If Empty(delegabo->DATAFINE) */
                if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) {
                  /* _ragsoc := '' */
                  _ragsoc = "";
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _ragsoc = Read_Cursor.GetString("RAGSOC");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _ragsoc = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Upper(cell37) = Upper(_ragsoc) */
                  if (CPLib.eqr(CPLib.Upper(cell37),CPLib.Upper(_ragsoc))) {
                    /* _legrap := delegabo->CODINTER */
                    _legrap = Cursor_delegabo.GetString("CODINTER");
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End If
                Cursor_delegabo.Next();
              }
              m_cConnectivityError = Cursor_delegabo.ErrorMessage();
              Cursor_delegabo.Close();
              // * --- End Select
              /* ElseIf _rappd='P' */
            } else if (CPLib.eqr(_rappd,"P")) {
              // * --- Select from xelegabo
              m_cServer = m_Ctx.GetServer("xelegabo");
              m_cPhName = m_Ctx.GetPhName("xelegabo");
              if (Cursor_xelegabo!=null)
                Cursor_xelegabo.Close();
              Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xelegabo.Eof())) {
                /* If Empty(xelegabo->DATAFINE) */
                if (CPLib.Empty(Cursor_xelegabo.GetDate("DATAFINE"))) {
                  /* _ragsoc := '' */
                  _ragsoc = "";
                  // * --- Read from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"));
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _ragsoc = Read_Cursor.GetString("RAGSOC");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _ragsoc = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Upper(cell37) = Upper(_ragsoc) */
                  if (CPLib.eqr(CPLib.Upper(cell37),CPLib.Upper(_ragsoc))) {
                    /* _legrap := xelegabo->CODINTER */
                    _legrap = Cursor_xelegabo.GetString("CODINTER");
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End If
                Cursor_xelegabo.Next();
              }
              m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
              Cursor_xelegabo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* _cbanca := '' */
          _cbanca = "";
          /* _bragsoc := '' */
          _bragsoc = "";
          /* _bcodcab := '' */
          _bcodcab = "";
          /* _bcitta := '' */
          _bcitta = "";
          /* _bprov := '' */
          _bprov = "";
          /* _bstato := '' */
          _bstato = "";
          /* If ((Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Left(cell06,3) = 'TCP') */
          if (((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.eqr(CPLib.Left(cell06,3),"TCP"))) {
            /* If Upper(Left(LRTrim(cell23),3))='086' */
            if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)),"086")) {
              /* If Len(LRTrim(cell26))=10 */
              if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(cell26)),10)) {
                /* _cbanca := Left(cell26,5)+"-"+Right(cell26,5) */
                _cbanca = CPLib.Left(cell26,5)+"-"+CPLib.Right(cell26,5);
              } else { // Else
                /* _cbanca := Substr(cell26,6,5)+"-"+Substr(cell26,11,5) */
                _cbanca = CPLib.Substr(cell26,6,5)+"-"+CPLib.Substr(cell26,11,5);
              } // End If
              /* _bstato := '086' */
              _bstato = "086";
              // * --- Read from inter2bo
              m_cServer = m_Ctx.GetServer("inter2bo");
              m_cPhName = m_Ctx.GetPhName("inter2bo");
              m_cSql = "";
              m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cbanca,"C",11,0,m_cServer),m_cServer,_cbanca);
              if (m_Ctx.IsSharedTemp("inter2bo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _bragsoc = Read_Cursor.GetString("RAGSOC");
                _bcodcab = Read_Cursor.GetString("CODCAB");
                _bcitta = Read_Cursor.GetString("DESCCIT");
                _bprov = Read_Cursor.GetString("PROVINCIA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _bragsoc = "";
                _bcodcab = "";
                _bcitta = "";
                _bprov = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_bragsoc)) */
              if (CPLib.Empty(CPLib.LRTrim(_bragsoc))) {
                /* _errore := _errore + "* Mancano Dati Intermediario Controparte Italiano " + NL */
                _errore = _errore+"* Mancano Dati Intermediario Controparte Italiano "+"\n";
              } // End If
            } else { // Else
              /* _cbanca := Left(LRTrim(cell25),11) */
              _cbanca = CPLib.Left(CPLib.LRTrim(cell25),11);
              /* _bragsoc := Left(LRTrim(cell20),70) */
              _bragsoc = CPLib.Left(CPLib.LRTrim(cell20),70);
              /* _bcitta := Left(LRTrim(cell22),30) */
              _bcitta = CPLib.Left(CPLib.LRTrim(cell22),30);
              /* _bprov := 'EE' */
              _bprov = "EE";
              /* _bstato := Left(LRTrim(cell23),3) */
              _bstato = CPLib.Left(CPLib.LRTrim(cell23),3);
              /* If Empty(LRTrim(_bragsoc)) or Empty(LRTrim(_bstato)) */
              if (CPLib.Empty(CPLib.LRTrim(_bragsoc)) || CPLib.Empty(CPLib.LRTrim(_bstato))) {
                /* _errore := _errore + "* Mancano Dati Intermediario Controparte Estero " + NL */
                _errore = _errore+"* Mancano Dati Intermediario Controparte Estero "+"\n";
              } // End If
            } // End If
          } else { // Else
            /* If (Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') */
            if ((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0"))) {
              /* If Upper(Left(LRTrim(cell23),3))='086' */
              if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)),"086")) {
                /* _cbanca := Substr(cell36,6,5)+"-"+Substr(cell36,11,5) */
                _cbanca = CPLib.Substr(cell36,6,5)+"-"+CPLib.Substr(cell36,11,5);
                /* _bstato := '086' */
                _bstato = "086";
                // * --- Read from inter2bo
                m_cServer = m_Ctx.GetServer("inter2bo");
                m_cPhName = m_Ctx.GetPhName("inter2bo");
                m_cSql = "";
                m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cbanca,"C",11,0,m_cServer),m_cServer,_cbanca);
                if (m_Ctx.IsSharedTemp("inter2bo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _bragsoc = Read_Cursor.GetString("RAGSOC");
                  _bcodcab = Read_Cursor.GetString("CODCAB");
                  _bcitta = Read_Cursor.GetString("DESCCIT");
                  _bprov = Read_Cursor.GetString("PROVINCIA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _bragsoc = "";
                  _bcodcab = "";
                  _bcitta = "";
                  _bprov = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_bragsoc)) */
                if (CPLib.Empty(CPLib.LRTrim(_bragsoc))) {
                  /* _errore := _errore + "* Mancano Dati Intermediario Controparte Italiano " + NL */
                  _errore = _errore+"* Mancano Dati Intermediario Controparte Italiano "+"\n";
                } // End If
              } else { // Else
                /* _cbanca := Left(LRTrim(cell32),11) */
                _cbanca = CPLib.Left(CPLib.LRTrim(cell32),11);
                /* _bragsoc := Left(LRTrim(cell35),70) */
                _bragsoc = CPLib.Left(CPLib.LRTrim(cell35),70);
                /* _bcitta := '' */
                _bcitta = "";
                /* _bprov := 'EE' */
                _bprov = "EE";
                /* _bstato := Left(LRTrim(cell23),3) */
                _bstato = CPLib.Left(CPLib.LRTrim(cell23),3);
                /* If Empty(LRTrim(_bragsoc)) or Empty(LRTrim(_bstato)) */
                if (CPLib.Empty(CPLib.LRTrim(_bragsoc)) || CPLib.Empty(CPLib.LRTrim(_bstato))) {
                  /* _errore := _errore + "* Mancano Dati Intermediario Controparte Estero " + NL */
                  _errore = _errore+"* Mancano Dati Intermediario Controparte Estero "+"\n";
                } // End If
              } // End If
            } else { // Else
              /* If Upper(Left(LRTrim(cell23),3))='086' */
              if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell23),3)),"086")) {
                /* _cbanca := Substr(cell26,6,5)+"-"+Substr(cell26,11,5) */
                _cbanca = CPLib.Substr(cell26,6,5)+"-"+CPLib.Substr(cell26,11,5);
                /* _bstato := '086' */
                _bstato = "086";
                // * --- Read from inter2bo
                m_cServer = m_Ctx.GetServer("inter2bo");
                m_cPhName = m_Ctx.GetPhName("inter2bo");
                m_cSql = "";
                m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cbanca,"C",11,0,m_cServer),m_cServer,_cbanca);
                if (m_Ctx.IsSharedTemp("inter2bo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _bragsoc = Read_Cursor.GetString("RAGSOC");
                  _bcodcab = Read_Cursor.GetString("CODCAB");
                  _bcitta = Read_Cursor.GetString("DESCCIT");
                  _bprov = Read_Cursor.GetString("PROVINCIA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _bragsoc = "";
                  _bcodcab = "";
                  _bcitta = "";
                  _bprov = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_bragsoc)) */
                if (CPLib.Empty(CPLib.LRTrim(_bragsoc))) {
                  /* _errore := _errore + "* Mancano Dati Intermediario Controparte Italiano " + NL */
                  _errore = _errore+"* Mancano Dati Intermediario Controparte Italiano "+"\n";
                } // End If
              } else { // Else
                /* _cbanca := Left(LRTrim(cell25),11) */
                _cbanca = CPLib.Left(CPLib.LRTrim(cell25),11);
                /* _bragsoc := Left(LRTrim(cell20),70) */
                _bragsoc = CPLib.Left(CPLib.LRTrim(cell20),70);
                /* _bcitta := '' */
                _bcitta = "";
                /* _bprov := 'EE' */
                _bprov = "EE";
                /* _bstato := Left(LRTrim(cell23),3) */
                _bstato = CPLib.Left(CPLib.LRTrim(cell23),3);
                /* If Empty(LRTrim(_bragsoc)) or Empty(LRTrim(_bstato)) */
                if (CPLib.Empty(CPLib.LRTrim(_bragsoc)) || CPLib.Empty(CPLib.LRTrim(_bstato))) {
                  /* _errore := _errore + "* Mancano Dati Intermediario Controparte Estero " + NL */
                  _errore = _errore+"* Mancano Dati Intermediario Controparte Estero "+"\n";
                } // End If
              } // End If
            } // End If
          } // End If
          /* _numprog := '' */
          _numprog = "";
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"RIFIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell06),"C",15,0,m_cServer),m_cServer,CPLib.LRTrim(cell06));
          m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
          m_cSql = m_cSql+" and TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(nVal,"N",15,0,m_cServer),m_cServer,nVal);
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _numprog = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _numprog = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_numprog) */
          if (CPLib.Empty(_numprog)) {
            // * --- Read from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"RIFIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell06),"C",28,0,m_cServer),m_cServer,CPLib.LRTrim(cell06));
            m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
            m_cSql = m_cSql+" and TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(nVal,"N",15,0,m_cServer),m_cServer,nVal);
            if (m_Ctx.IsSharedTemp("fraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _numprog = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _numprog = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(_numprog) */
          if (CPLib.Empty(_numprog)) {
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"RIFIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell06),"C",15,0,m_cServer),m_cServer,CPLib.LRTrim(cell06));
            m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
            m_cSql = m_cSql+" and TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(nVal,"N",15,0,m_cServer),m_cServer,nVal);
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _numprog = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _numprog = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(_numprog) */
          if (CPLib.Empty(_numprog)) {
            // * --- Read from xraziobo
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_cSql = "";
            m_cSql = m_cSql+"RIFIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell06),"C",28,0,m_cServer),m_cServer,CPLib.LRTrim(cell06));
            m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
            m_cSql = m_cSql+" and TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(nVal,"N",15,0,m_cServer),m_cServer,nVal);
            if (m_Ctx.IsSharedTemp("xraziobo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _numprog = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _numprog = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If not(Empty(_numprog)) */
          if ( ! (CPLib.Empty(_numprog))) {
            /* _errore := _errore + "* Operazione già presente in AUI " + NL */
            _errore = _errore+"* Operazione già presente in AUI "+"\n";
          } // End If
          /* If ((Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Left(cell06,3) = 'TCP') or (Lower(LRTrim(cell07))='true' or Lower(LRTrim(cell07))='true' or Lower(LRTrim(cell07))='1') */
          if (((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.eqr(CPLib.Left(cell06,3),"TCP")) || (CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"true") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"true") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"1"))) {
            /* If Empty(LRTrim(cell18)) */
            if (CPLib.Empty(CPLib.LRTrim(cell18))) {
              /* _errore := _errore + "* Mancano Dati Controparte" + NL */
              _errore = _errore+"* Mancano Dati Controparte"+"\n";
            } else { // Else
              /* If LRTrim(cell18)='086' */
              if (CPLib.eqr(CPLib.LRTrim(cell18),"086")) {
                /* If Empty(LRTrim(cell13)) */
                if (CPLib.Empty(CPLib.LRTrim(cell13))) {
                  /* _errore := _errore + "* Mancano Dati Controparte Italia" + NL */
                  _errore = _errore+"* Mancano Dati Controparte Italia"+"\n";
                } // End If
              } else { // Else
                /* If Empty(LRTrim(cell13)) */
                if (CPLib.Empty(CPLib.LRTrim(cell13))) {
                  /* _errore := _errore + "* Mancano Dati Controparte Estero" + NL */
                  _errore = _errore+"* Mancano Dati Controparte Estero"+"\n";
                } // End If
              } // End If
            } // End If
          } // End If
          /* If (nVal / 100) > _sogliamax */
          if (CPLib.gt((nVal/100),_sogliamax)) {
            /* _errore := _errore + "* Importo Elevato. Verificare" + NL */
            _errore = _errore+"* Importo Elevato. Verificare"+"\n";
          } // End If
          /* If Empty(_errore) */
          if (CPLib.Empty(_errore)) {
            /* _idb2 := LibreriaMit.UniqueId() */
            _idb2 = LibreriaMit.UniqueId();
            /* If nVal < _limitesoglia */
            if (CPLib.lt(nVal,_limitesoglia)) {
              /* Exec "Scrittura Frazionate" Page 4:WriteFrazionate */
              WriteFrazionate();
            } else { // Else
              /* Exec "Scrittura Operazioni" Page 5:WriteOperazioni */
              WriteOperazioni();
            } // End If
          } else { // Else
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.colonna01 := cell01 */
            mcErrori.row.colonna01 = cell01;
            /* mcErrori.colonna02 := cell02 */
            mcErrori.row.colonna02 = cell02;
            /* mcErrori.colonna03 := cell03 */
            mcErrori.row.colonna03 = cell03;
            /* mcErrori.colonna04 := cell04 */
            mcErrori.row.colonna04 = cell04;
            /* mcErrori.colonna05 := cell05 */
            mcErrori.row.colonna05 = cell05;
            /* mcErrori.colonna06 := cell06 */
            mcErrori.row.colonna06 = cell06;
            /* mcErrori.colonna07 := cell07 */
            mcErrori.row.colonna07 = cell07;
            /* mcErrori.colonna08 := cell08 */
            mcErrori.row.colonna08 = cell08;
            /* mcErrori.colonna09 := cell09 */
            mcErrori.row.colonna09 = cell09;
            /* mcErrori.colonna10 := cell10 */
            mcErrori.row.colonna10 = cell10;
            /* mcErrori.colonna11 := cell11 */
            mcErrori.row.colonna11 = cell11;
            /* mcErrori.colonna12 := cell12 */
            mcErrori.row.colonna12 = cell12;
            /* mcErrori.colonna13 := cell13 */
            mcErrori.row.colonna13 = cell13;
            /* mcErrori.colonna14 := cell14 */
            mcErrori.row.colonna14 = cell14;
            /* mcErrori.colonna15 := cell15 */
            mcErrori.row.colonna15 = cell15;
            /* mcErrori.colonna16 := cell16 */
            mcErrori.row.colonna16 = cell16;
            /* mcErrori.colonna17 := cell17 */
            mcErrori.row.colonna17 = cell17;
            /* mcErrori.colonna18 := cell18 */
            mcErrori.row.colonna18 = cell18;
            /* mcErrori.colonna19 := cell19 */
            mcErrori.row.colonna19 = cell19;
            /* mcErrori.colonna20 := cell20 */
            mcErrori.row.colonna20 = cell20;
            /* mcErrori.colonna21 := cell21 */
            mcErrori.row.colonna21 = cell21;
            /* mcErrori.colonna22 := cell22 */
            mcErrori.row.colonna22 = cell22;
            /* mcErrori.colonna23 := cell23 */
            mcErrori.row.colonna23 = cell23;
            /* mcErrori.colonna24 := cell24 */
            mcErrori.row.colonna24 = cell24;
            /* mcErrori.colonna25 := cell25 */
            mcErrori.row.colonna25 = cell25;
            /* mcErrori.colonna26 := cell26 */
            mcErrori.row.colonna26 = cell26;
            /* mcErrori.colonna27 := cell27 */
            mcErrori.row.colonna27 = cell27;
            /* mcErrori.colonna28 := cell28 */
            mcErrori.row.colonna28 = cell28;
            /* mcErrori.colonna29 := cell29 */
            mcErrori.row.colonna29 = cell29;
            /* mcErrori.colonna30 := cell30 */
            mcErrori.row.colonna30 = cell30;
            /* mcErrori.colonna31 := cell31 */
            mcErrori.row.colonna31 = cell31;
            /* mcErrori.colonna32 := cell32 */
            mcErrori.row.colonna32 = cell32;
            /* mcErrori.colonna33 := cell33 */
            mcErrori.row.colonna33 = cell33;
            /* mcErrori.colonna34 := cell34 */
            mcErrori.row.colonna34 = cell34;
            /* mcErrori.colonna35 := cell35 */
            mcErrori.row.colonna35 = cell35;
            /* mcErrori.colonna36 := cell36 */
            mcErrori.row.colonna36 = cell36;
            /* mcErrori.colonna37 := cell37 */
            mcErrori.row.colonna37 = cell37;
            /* mcErrori.colonna38 := cell38 */
            mcErrori.row.colonna38 = cell38;
            /* mcErrori.colonna39 := cell39 */
            mcErrori.row.colonna39 = cell39;
            /* mcErrori.flgforza := 'N' */
            mcErrori.row.flgforza = "N";
            /* mcErrori.Errore := _errore */
            mcErrori.row.Errore = _errore;
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
        } // End If
        /* ElseIf cell39='D' */
      } else if (CPLib.eqr(cell39,"D")) {
        /* gMsgProc := gMsgProc + 'Cancello operazione N. '+LRTrim(cell06)+" del Customer ID "+LRTrim(cell04) + NL */
        gMsgProc = gMsgProc+"Cancello operazione N. "+CPLib.LRTrim(cell06)+" del Customer ID "+CPLib.LRTrim(cell04)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Cancellazione operazione N. '+LRTrim(cell06)+" del Customer ID "+LRTrim(cell04) // Messaggio Import */
        gMsgImp = "Cancellazione operazione N. "+CPLib.LRTrim(cell06)+" del Customer ID "+CPLib.LRTrim(cell04);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _numprog := '' */
        _numprog = "";
        // * --- Read from operazbo
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_cSql = "";
        m_cSql = m_cSql+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(cell06,"C",30,0,m_cServer),m_cServer,cell06);
        if (m_Ctx.IsSharedTemp("operazbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _numprog = Read_Cursor.GetString("NUMPROG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _numprog = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_numprog)) */
        if ( ! (CPLib.Empty(_numprog))) {
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001A2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
          m_cSql = m_cSql+" and STATOREG >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("0","?",0,0,m_cServer),m_cServer,"0")+"";
          m_cSql = m_cSql+" and STATOREG <= "+CPSql.SQLValueAdapter(CPLib.ToSQL("1","?",0,0,m_cServer),m_cServer,"1")+"";
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
        } else { // Else
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(cell06,"C",30,0,m_cServer),m_cServer,cell06);
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _numprog = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _numprog = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_numprog)) */
          if ( ! (CPLib.Empty(_numprog))) {
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
            m_cSql = m_cSql+" and STATOREG >= "+CPSql.SQLValueAdapter(CPLib.ToSQL("0","?",0,0,m_cServer),m_cServer,"0")+"";
            m_cSql = m_cSql+" and STATOREG <= "+CPSql.SQLValueAdapter(CPLib.ToSQL("1","?",0,0,m_cServer),m_cServer,"1")+"";
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
          } else { // Else
            // * --- Read from xperazbo
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_cSql = "";
            m_cSql = m_cSql+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(cell06,"C",30,0,m_cServer),m_cServer,cell06);
            if (m_Ctx.IsSharedTemp("xperazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _numprog = Read_Cursor.GetString("NUMPROG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _numprog = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(_numprog)) */
            if ( ! (CPLib.Empty(_numprog))) {
              // * --- Delete from xperazbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001A8")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
            } else { // Else
              // * --- Read from xraziobo
              m_cServer = m_Ctx.GetServer("xraziobo");
              m_cPhName = m_Ctx.GetPhName("xraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(cell06,"C",30,0,m_cServer),m_cServer,cell06);
              if (m_Ctx.IsSharedTemp("xraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _numprog = Read_Cursor.GetString("NUMPROG");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on xraziobo into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _numprog = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If not(Empty(_numprog)) */
              if ( ! (CPLib.Empty(_numprog))) {
                // * --- Delete from xraziobo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001AB")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
              } else { // Else
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.colonna01 := cell01 */
                mcErrori.row.colonna01 = cell01;
                /* mcErrori.colonna02 := cell02 */
                mcErrori.row.colonna02 = cell02;
                /* mcErrori.colonna03 := cell03 */
                mcErrori.row.colonna03 = cell03;
                /* mcErrori.colonna04 := cell04 */
                mcErrori.row.colonna04 = cell04;
                /* mcErrori.colonna05 := cell05 */
                mcErrori.row.colonna05 = cell05;
                /* mcErrori.colonna06 := cell06 */
                mcErrori.row.colonna06 = cell06;
                /* mcErrori.colonna07 := cell07 */
                mcErrori.row.colonna07 = cell07;
                /* mcErrori.colonna08 := cell08 */
                mcErrori.row.colonna08 = cell08;
                /* mcErrori.colonna09 := cell09 */
                mcErrori.row.colonna09 = cell09;
                /* mcErrori.colonna10 := cell10 */
                mcErrori.row.colonna10 = cell10;
                /* mcErrori.colonna11 := cell11 */
                mcErrori.row.colonna11 = cell11;
                /* mcErrori.colonna12 := cell12 */
                mcErrori.row.colonna12 = cell12;
                /* mcErrori.colonna13 := cell13 */
                mcErrori.row.colonna13 = cell13;
                /* mcErrori.colonna14 := cell14 */
                mcErrori.row.colonna14 = cell14;
                /* mcErrori.colonna15 := cell15 */
                mcErrori.row.colonna15 = cell15;
                /* mcErrori.colonna16 := cell16 */
                mcErrori.row.colonna16 = cell16;
                /* mcErrori.colonna17 := cell17 */
                mcErrori.row.colonna17 = cell17;
                /* mcErrori.colonna18 := cell18 */
                mcErrori.row.colonna18 = cell18;
                /* mcErrori.colonna19 := cell19 */
                mcErrori.row.colonna19 = cell19;
                /* mcErrori.colonna20 := cell20 */
                mcErrori.row.colonna20 = cell20;
                /* mcErrori.colonna21 := cell21 */
                mcErrori.row.colonna21 = cell21;
                /* mcErrori.colonna22 := cell22 */
                mcErrori.row.colonna22 = cell22;
                /* mcErrori.colonna23 := cell23 */
                mcErrori.row.colonna23 = cell23;
                /* mcErrori.colonna24 := cell24 */
                mcErrori.row.colonna24 = cell24;
                /* mcErrori.colonna25 := cell25 */
                mcErrori.row.colonna25 = cell25;
                /* mcErrori.colonna26 := cell26 */
                mcErrori.row.colonna26 = cell26;
                /* mcErrori.colonna27 := cell27 */
                mcErrori.row.colonna27 = cell27;
                /* mcErrori.colonna28 := cell28 */
                mcErrori.row.colonna28 = cell28;
                /* mcErrori.colonna29 := cell29 */
                mcErrori.row.colonna29 = cell29;
                /* mcErrori.colonna30 := cell30 */
                mcErrori.row.colonna30 = cell30;
                /* mcErrori.colonna31 := cell31 */
                mcErrori.row.colonna31 = cell31;
                /* mcErrori.colonna32 := cell32 */
                mcErrori.row.colonna32 = cell32;
                /* mcErrori.colonna33 := cell33 */
                mcErrori.row.colonna33 = cell33;
                /* mcErrori.colonna34 := cell34 */
                mcErrori.row.colonna34 = cell34;
                /* mcErrori.colonna35 := cell35 */
                mcErrori.row.colonna35 = cell35;
                /* mcErrori.colonna36 := cell36 */
                mcErrori.row.colonna36 = cell36;
                /* mcErrori.colonna37 := cell37 */
                mcErrori.row.colonna37 = cell37;
                /* mcErrori.colonna38 := cell38 */
                mcErrori.row.colonna38 = cell38;
                /* mcErrori.colonna39 := cell39 */
                mcErrori.row.colonna39 = cell39;
                /* mcErrori.flgforza := 'N' */
                mcErrori.row.flgforza = "N";
                /* mcErrori.Errore := "Non trovata operazione corrispondente da cancellare" */
                mcErrori.row.Errore = "Non trovata operazione corrispondente da cancellare";
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
            } // End If
          } // End If
        } // End If
      } else { // Else
      } // End If
      //
          }
        }
      /* gMsgProc := gMsgProc + 'Righe Elaborate: '+LRTrim(Str(righe,6,0)) + NL */
      gMsgProc = gMsgProc+"Righe Elaborate: "+CPLib.LRTrim(CPLib.Str(righe,6,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      //
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    /* Scrive il foglio Excel */
    /* nomeesito := 'Operazioni_Scartate_'+DateTimeToChar(DateTime())+".xls" */
    nomeesito = "Operazioni_Scartate_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
    /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
    nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
    //base
    riga = 1;
    WorkbookSettings ws = new WorkbookSettings();
    WritableWorkbook file = Workbook.createWorkbook(new File(nomefilexls), ws);
    WritableSheet foglio = file.createSheet("Elenco",0);
    WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
    WritableCellFormat arial11format = new WritableCellFormat (arial11font);
    NumberFormat decimalNo = new NumberFormat("##########0.00000000000"); 
    WritableCellFormat decNum = new WritableCellFormat(decimalNo);
    WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
    WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
    Label stringa = new Label(0,0,"Branch Code",arial11format);
    foglio.addCell(stringa); 
    stringa = new Label(1,0,"Received Date",arial11format);
    foglio.addCell(stringa); 
    stringa = new Label(2,0,"Released Date",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(3,0,"Entity ID",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(4,0,"Order ID",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(5,0,"Payment ID",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(6,0,"Is Payment Outgoing",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(7,0,"Payment Currency",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(8,0,"Trade Rate To Customer ",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(9,0,"Amount In Payment Currency",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(10,0,"Amount Excluding Fees In Payment Currency",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(11,0,"Fee Amount In Settlement Currency",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(12,0,"Recipient Name",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(13,0,"Recipient Address1",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(14,0,"Recipient Address2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(15,0,"Recipient Address3",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(16,0,"Recipient City",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(17,0,"Recipient Country Code",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(18,0,"Recipient Postal Code",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(19,0,"Recipient Bank",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(20,0,"Recipient Bank Address",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(21,0,"Recipient Bank City",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(22,0,"Recipient Bank Country",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(23,0,"Recipient Bank Postal Code",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(24,0,"Recipient Bank SWIFT Code",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(25,0,"Recipient Bank Account IBAN",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(26,0,"Bank Entity Name Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(27,0,"Address Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(28,0,"City Value",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(29,0,"Country Code Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(30,0,"Postal Zip Code Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(31,0,"SWIFTCode Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(32,0,"Account IBAN Value2",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(33,0,"Deal Number",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(34,0,"Settlement Bank Account",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(35,0,"Settlement Bank Account Number",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(36,0,"Authorized User",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(37,0,"XXX",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(38,0,"Action",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(39,0,"FORZA INSERIMENTO",arial11format);
    foglio.addCell(stringa);
    stringa = new Label(40,0,"ERRORI",arial11format);
    foglio.addCell(stringa);
    
    for (MemoryCursorRow_mcrowserrori_mcrdef rwErrori : mcErrori._iterable_()) {
      // Scrive le righe degli errori
      stringa = new Label(0,riga,rwErrori.colonna01);
      foglio.addCell(stringa);
      stringa = new Label(1,riga,rwErrori.colonna02);
      foglio.addCell(stringa);
      stringa = new Label(2,riga,rwErrori.colonna03);
      foglio.addCell(stringa);
      stringa = new Label(3,riga,rwErrori.colonna04);
      foglio.addCell(stringa);
      stringa = new Label(4,riga,rwErrori.colonna05);
      foglio.addCell(stringa);
      stringa = new Label(5,riga,rwErrori.colonna06);
      foglio.addCell(stringa);
      stringa = new Label(6,riga,rwErrori.colonna07);
      foglio.addCell(stringa);
      stringa = new Label(7,riga,rwErrori.colonna08);
      foglio.addCell(stringa);
      Number num1 = new Number(8,riga,rwErrori.colonna09,decNum);
      foglio.addCell(num1);
      stringa = new Label(9,riga,rwErrori.colonna10);
      foglio.addCell(stringa);
      num1 = new Number(10,riga,rwErrori.colonna11,dblNum);
      foglio.addCell(num1);
      stringa = new Label(11,riga,rwErrori.colonna12);
      foglio.addCell(stringa);
      stringa = new Label(12,riga,rwErrori.colonna13);
      foglio.addCell(stringa);
      stringa = new Label(13,riga,rwErrori.colonna14);
      foglio.addCell(stringa);
      stringa = new Label(14,riga,rwErrori.colonna15);
      foglio.addCell(stringa);
      stringa = new Label(15,riga,rwErrori.colonna16);
      foglio.addCell(stringa);
      stringa = new Label(16,riga,rwErrori.colonna17);
      foglio.addCell(stringa);
      stringa = new Label(17,riga,rwErrori.colonna18);
      foglio.addCell(stringa);
      stringa = new Label(18,riga,rwErrori.colonna19);
      foglio.addCell(stringa);
      stringa = new Label(19,riga,rwErrori.colonna20);
      foglio.addCell(stringa);
      stringa = new Label(20,riga,rwErrori.colonna21);
      foglio.addCell(stringa);
      stringa = new Label(21,riga,rwErrori.colonna22);
      foglio.addCell(stringa);
      stringa = new Label(22,riga,rwErrori.colonna23);
      foglio.addCell(stringa);
      stringa = new Label(23,riga,rwErrori.colonna24);
      foglio.addCell(stringa);
      stringa = new Label(24,riga,rwErrori.colonna25);
      foglio.addCell(stringa);
      stringa = new Label(25,riga,rwErrori.colonna26);
      foglio.addCell(stringa);
      stringa = new Label(26,riga,rwErrori.colonna27);
      foglio.addCell(stringa);
      stringa = new Label(27,riga,rwErrori.colonna28);
      foglio.addCell(stringa);
      stringa = new Label(28,riga,rwErrori.colonna29);
      foglio.addCell(stringa);
      stringa = new Label(29,riga,rwErrori.colonna30);
      foglio.addCell(stringa);
      stringa = new Label(30,riga,rwErrori.colonna31);
      foglio.addCell(stringa);
      stringa = new Label(31,riga,rwErrori.colonna32);
      foglio.addCell(stringa);
      stringa = new Label(32,riga,rwErrori.colonna33);
      foglio.addCell(stringa);
      stringa = new Label(33,riga,rwErrori.colonna34);
      foglio.addCell(stringa);
      stringa = new Label(34,riga,rwErrori.colonna35);
      foglio.addCell(stringa);
      stringa = new Label(35,riga,rwErrori.colonna36);
      foglio.addCell(stringa);
      stringa = new Label(36,riga,rwErrori.colonna37);
      foglio.addCell(stringa);
      stringa = new Label(37,riga,rwErrori.colonna38);
      foglio.addCell(stringa);
      stringa = new Label(38,riga,rwErrori.colonna39);
      foglio.addCell(stringa);
      stringa = new Label(39,riga,rwErrori.flgforza);
      foglio.addCell(stringa);
      stringa = new Label(40,riga,rwErrori.Errore);
      foglio.addCell(stringa);
      riga = riga +1;
    }
    //Aggiusta le colonne
    CellView cf = new CellView();
    cf.setAutosize(true);
    foglio.setColumnView(0, cf);
    foglio.setColumnView(1, cf);
    foglio.setColumnView(2, cf);
    foglio.setColumnView(3, cf);
    foglio.setColumnView(4, cf);
    foglio.setColumnView(5, cf);
    foglio.setColumnView(6, cf);
    foglio.setColumnView(7, cf);
    foglio.setColumnView(8, cf);
    foglio.setColumnView(9, cf);
    foglio.setColumnView(10, cf);
    foglio.setColumnView(11, cf);
    foglio.setColumnView(12, cf);
    foglio.setColumnView(13, cf);
    foglio.setColumnView(14, cf);
    foglio.setColumnView(15, cf);
    foglio.setColumnView(16, cf);
    foglio.setColumnView(17, cf);
    foglio.setColumnView(18, cf);
    foglio.setColumnView(19, cf);
    foglio.setColumnView(20, cf);
    foglio.setColumnView(21, cf);
    foglio.setColumnView(22, cf);
    foglio.setColumnView(23, cf);
    foglio.setColumnView(24, cf);
    foglio.setColumnView(25, cf);
    foglio.setColumnView(26, cf);
    foglio.setColumnView(27, cf);
    foglio.setColumnView(28, cf);
    foglio.setColumnView(29, cf);
    foglio.setColumnView(30, cf);
    foglio.setColumnView(31, cf);
    foglio.setColumnView(32, cf);
    foglio.setColumnView(33, cf);
    foglio.setColumnView(34, cf);
    foglio.setColumnView(35, cf);
    foglio.setColumnView(36, cf);
    foglio.setColumnView(37, cf);
    foglio.setColumnView(38, cf);
    foglio.setColumnView(39, cf);
    foglio.setColumnView(40, cf);
    file.write();
    file.close();
    // * --- Insert into tmp_listafile from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_listafile");
    m_cPhName = m_Ctx.GetPhName("tmp_listafile");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000001E3(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(nomeesito,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito,"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
  }
  void WriteFrazionate() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        // * --- Insert into xraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xraziobo");
        m_cPhName = m_Ctx.GetPhName("xraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001EA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000001EA(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcodcab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cbanca,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcitta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bragsoc,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bstato,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bprov,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_btipo,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
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
        /* If _rappd = 'D' */
        if (CPLib.eqr(_rappd,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into xraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xraziobo");
              m_cPhName = m_Ctx.GetPhName("xraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001EE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into xlientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientifrz");
              m_cPhName = m_Ctx.GetPhName("xlientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001EF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientifrz",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* ElseIf _rappd = 'P' */
        } else if (CPLib.eqr(_rappd,"P")) {
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into xraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xraziobo");
              m_cPhName = m_Ctx.GetPhName("xraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001F3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into xlientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientifrz");
              m_cPhName = m_Ctx.GetPhName("xlientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001F4(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientifrz",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
        } // End If
        /* If (Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Upper(Left(cell06,3)) <> 'TCP' */
        if ((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.ne(CPLib.Upper(CPLib.Left(cell06,3)),"TCP")) {
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          /* If _rappd='D' */
          if (CPLib.eqr(_rappd,"D")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If nIntest=1 */
                if (CPLib.eqr(nIntest,1)) {
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001FC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
                } else { // Else
                  // * --- Insert into xeneficfrz from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xeneficfrz");
                  m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000001FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001FD(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficfrz",true);
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
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* ElseIf _rappd='P' */
          } else if (CPLib.eqr(_rappd,"P")) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If nIntest=1 */
                if (CPLib.eqr(nIntest,1)) {
                  // * --- Write into xraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xraziobo");
                  m_cPhName = m_Ctx.GetPhName("xraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000202")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
                } else { // Else
                  // * --- Insert into xeneficfrz from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xeneficfrz");
                  m_cPhName = m_Ctx.GetPhName("xeneficfrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000203")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000203(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficfrz",true);
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
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
        } else { // Else
          /* _ccab := '' */
          _ccab = "";
          /* _cprov := '' */
          _cprov = "";
          /* _ccap := '' */
          _ccap = "";
          /* _csta := '' */
          _csta = "";
          /* _crag := Left(LRTrim(cell13),70) */
          _crag = CPLib.Left(CPLib.LRTrim(cell13),70);
          /* If Upper(Left(LRTrim(cell18),3))='086' */
          if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)),"086")) {
            /* _csta := '086' */
            _csta = "086";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),40),"C",60,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(cell17),40));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _ccab = Read_Cursor.GetString("CAB");
              _cprov = Read_Cursor.GetString("PROV");
              _ccap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ccab = "";
              _cprov = "";
              _ccap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* _cprov := 'EE' */
            _cprov = "EE";
            /* _csta := Left(LRTrim(cell18),3) */
            _csta = CPLib.Left(CPLib.LRTrim(cell18),3);
          } // End If
          // * --- Write into xraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000020F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_crag,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_csta,"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_cprov,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell14),35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_ccap,"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_ccab,"C",6,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
        /* If LRTrim(cell01)='554' */
        if (CPLib.eqr(CPLib.LRTrim(cell01),"554")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Insert into xraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000215")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000215(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D6":"D7"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"3S":"4S"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06)+"-"+(CPLib.eqr(_segno,"A")?"D7":"D6"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D":"A"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
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
          /* If _rappd = 'D' */
          if (CPLib.eqr(_rappd,"D")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into xraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000219")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into xlientifrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xlientifrz");
                m_cPhName = m_Ctx.GetPhName("xlientifrz");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000021A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000021A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientifrz",true);
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
              } // End If
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* ElseIf _rappd = 'P' */
          } else if (CPLib.eqr(_rappd,"P")) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into xraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xraziobo");
                m_cPhName = m_Ctx.GetPhName("xraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000021E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into xlientifrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xlientifrz");
                m_cPhName = m_Ctx.GetPhName("xlientifrz");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000021F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000021F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientifrz",true);
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
              } // End If
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
        } // End If
      } else { // Else
        /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        // * --- Insert into fraziobo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000225")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000225(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bragsoc,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcitta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcodcab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bprov,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bstato,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_btipo,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cbanca,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If nIntest=1 */
          if (CPLib.eqr(nIntest,1)) {
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000228")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
          } else { // Else
            // * --- Insert into clientifrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000229")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000229(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientifrz",true);
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
          } // End If
          /* nIntest := nIntest + 1 */
          nIntest = CPLib.Round(nIntest+1,0);
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If (Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Upper(Left(cell06,3)) <> 'TCP' */
        if ((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.ne(CPLib.Upper(CPLib.Left(cell06,3)),"TCP")) {
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000230")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into beneficfrz from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("beneficfrz");
                m_cPhName = m_Ctx.GetPhName("beneficfrz");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000231")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000231(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficfrz",true);
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
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } else { // Else
          /* _ccab := '' */
          _ccab = "";
          /* _cprov := '' */
          _cprov = "";
          /* _ccap := '' */
          _ccap = "";
          /* _csta := '' */
          _csta = "";
          /* _crag := Left(LRTrim(cell13),70) */
          _crag = CPLib.Left(CPLib.LRTrim(cell13),70);
          /* If Upper(Left(LRTrim(cell18),3))='086' */
          if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)),"086")) {
            /* _csta := '086' */
            _csta = "086";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),40),"C",60,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(cell17),40));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _ccab = Read_Cursor.GetString("CAB");
              _cprov = Read_Cursor.GetString("PROV");
              _ccap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ccab = "";
              _cprov = "";
              _ccap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* _cprov := 'EE' */
            _cprov = "EE";
            /* _csta := Left(LRTrim(cell18),3) */
            _csta = CPLib.Left(CPLib.LRTrim(cell18),3);
          } // End If
          // * --- Write into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000023D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_crag,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_csta,"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_cprov,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell14),35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_ccap,"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_ccab,"C",6,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
        /* If LRTrim(cell01)='554' */
        if (CPLib.eqr(CPLib.LRTrim(cell01),"554")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Insert into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000243")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000243(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D6":"D7"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"3S":"4S"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06)+"-"+(CPLib.eqr(_segno,"A")?"D7":"D6"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D":"A"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000246")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into clientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000247")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000247(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientifrz",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  void WriteOperazioni() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        // * --- Insert into xperazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000024F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000024F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcitta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcodcab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bprov,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bstato,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_btipo,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cbanca,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bragsoc,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
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
        /* If _rappd = 'D' */
        if (CPLib.eqr(_rappd,"D")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into xperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000253")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into xlientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientiope");
              m_cPhName = m_Ctx.GetPhName("xlientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000254")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000254(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientiope",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* ElseIf _rappd = 'P' */
        } else if (CPLib.eqr(_rappd,"P")) {
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into xperazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xperazbo");
              m_cPhName = m_Ctx.GetPhName("xperazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000258")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into xlientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("xlientiope");
              m_cPhName = m_Ctx.GetPhName("xlientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000259")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000259(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientiope",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
        } // End If
        /* If (Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Upper(Left(cell06,3)) <> 'TCP' */
        if ((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.ne(CPLib.Upper(CPLib.Left(cell06,3)),"TCP")) {
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          /* If _rappd='D' */
          if (CPLib.eqr(_rappd,"D")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If nIntest=1 */
                if (CPLib.eqr(nIntest,1)) {
                  // * --- Write into xperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000261")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
                } else { // Else
                  // * --- Insert into xeneficope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xeneficope");
                  m_cPhName = m_Ctx.GetPhName("xeneficope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000262")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000262(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficope",true);
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
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* ElseIf _rappd='P' */
          } else if (CPLib.eqr(_rappd,"P")) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If nIntest=1 */
                if (CPLib.eqr(nIntest,1)) {
                  // * --- Write into xperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xperazbo");
                  m_cPhName = m_Ctx.GetPhName("xperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000267")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
                } else { // Else
                  // * --- Insert into xeneficope from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xeneficope");
                  m_cPhName = m_Ctx.GetPhName("xeneficope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000268")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000268(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xeneficope",true);
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
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
        } else { // Else
          /* _ccab := '' */
          _ccab = "";
          /* _cprov := '' */
          _cprov = "";
          /* _ccap := '' */
          _ccap = "";
          /* _csta := '' */
          _csta = "";
          /* _crag := Left(LRTrim(cell13),70) */
          _crag = CPLib.Left(CPLib.LRTrim(cell13),70);
          /* If Upper(Left(LRTrim(cell18),3))='086' */
          if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)),"086")) {
            /* _csta := '086' */
            _csta = "086";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),40),"C",60,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(cell17),40));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _ccab = Read_Cursor.GetString("CAB");
              _cprov = Read_Cursor.GetString("PROV");
              _ccap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ccab = "";
              _cprov = "";
              _ccap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* _cprov := 'EE' */
            _cprov = "EE";
            /* _csta := Left(LRTrim(cell18),3) */
            _csta = CPLib.Left(CPLib.LRTrim(cell18),3);
          } // End If
          // * --- Write into xperazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000274")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_crag,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_csta,"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_cprov,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell14),35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_ccap,"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_ccab,"C",6,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
        /* If LRTrim(cell01)='554' */
        if (CPLib.eqr(CPLib.LRTrim(cell01),"554")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Insert into xperazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000027A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000027A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D6":"D7"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"3S":"4S"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06)+"-"+(CPLib.eqr(_segno,"A")?"D7":"D6"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D":"A"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
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
          /* If _rappd = 'D' */
          if (CPLib.eqr(_rappd,"D")) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into xperazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000027E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into xlientiope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xlientiope");
                m_cPhName = m_Ctx.GetPhName("xlientiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000027F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000027F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientiope",true);
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
              } // End If
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            /* ElseIf _rappd = 'P' */
          } else if (CPLib.eqr(_rappd,"P")) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into xperazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xperazbo");
                m_cPhName = m_Ctx.GetPhName("xperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000283")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into xlientiope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("xlientiope");
                m_cPhName = m_Ctx.GetPhName("xlientiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000284")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000284(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xlientiope",true);
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
              } // End If
              /* nIntest := nIntest + 1 */
              nIntest = CPLib.Round(nIntest+1,0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
        } // End If
      } else { // Else
        /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
        cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
        cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* nIntest := 1 */
        nIntest = CPLib.Round(1,0);
        // * --- Insert into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000028A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000028A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_btipo,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bprov,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bstato,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_bragsoc,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcitta,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_causin,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cbanca,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_bcodcab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cauana,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If nIntest=1 */
          if (CPLib.eqr(nIntest,1)) {
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000028D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
          } else { // Else
            // * --- Insert into clientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"0000028E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000028E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
          } // End If
          /* nIntest := nIntest + 1 */
          nIntest = CPLib.Round(nIntest+1,0);
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If (Lower(LRTrim(cell07))='false' or Lower(LRTrim(cell07))='falso' or Lower(LRTrim(cell07))='0') and Upper(Left(cell06,3)) <> 'TCP' */
        if ((CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"false") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"falso") || CPLib.eqr(CPLib.Lower(CPLib.LRTrim(cell07)),"0")) && CPLib.ne(CPLib.Upper(CPLib.Left(cell06,3)),"TCP")) {
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* If nIntest=1 */
              if (CPLib.eqr(nIntest,1)) {
                // * --- Write into operazbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000295")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
              } else { // Else
                // * --- Insert into beneficope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("beneficope");
                m_cPhName = m_Ctx.GetPhName("beneficope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"00000296")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000296(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nIntest-1,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"beneficope",true);
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
              } // End If
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } else { // Else
          /* _ccab := '' */
          _ccab = "";
          /* _cprov := '' */
          _cprov = "";
          /* _ccap := '' */
          _ccap = "";
          /* _csta := '' */
          _csta = "";
          /* _crag := Left(LRTrim(cell13),70) */
          _crag = CPLib.Left(CPLib.LRTrim(cell13),70);
          /* If Upper(Left(LRTrim(cell18),3))='086' */
          if (CPLib.eqr(CPLib.Upper(CPLib.Left(CPLib.LRTrim(cell18),3)),"086")) {
            /* _csta := '086' */
            _csta = "086";
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),40),"C",60,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(cell17),40));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _ccab = Read_Cursor.GetString("CAB");
              _cprov = Read_Cursor.GetString("PROV");
              _ccap = Read_Cursor.GetString("CAP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wubs returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _ccab = "";
              _cprov = "";
              _ccap = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* _cprov := 'EE' */
            _cprov = "EE";
            /* _csta := Left(LRTrim(cell18),3) */
            _csta = CPLib.Left(CPLib.LRTrim(cell18),3);
          } // End If
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000002A2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(_crag,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_csta,"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell17),30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(_cprov,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(cell14),35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(_ccap,"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(_ccab,"C",6,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
        /* If LRTrim(cell01)='554' */
        if (CPLib.eqr(CPLib.LRTrim(cell01),"554")) {
          /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* nIntest := 1 */
          nIntest = CPLib.Round(1,0);
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000002A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002A8(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(CPLib.CharToDate(xData)),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nChVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(xData,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D6":"D7"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"3S":"4S"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_legrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(xData),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cTVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tiporap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cell06)+"-"+(CPLib.eqr(_segno,"A")?"D7":"D6"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_segno,"A")?"D":"A"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nVal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cCVal,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If nIntest=1 */
            if (CPLib.eqr(nIntest,1)) {
              // * --- Write into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000002AB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer),m_cServer,cOpeProg1)+"";
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
            } else { // Else
              // * --- Insert into clientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wubs",872,"000002AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002AC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"clientiope",true);
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
            } // End If
            /* nIntest := nIntest + 1 */
            nIntest = CPLib.Round(nIntest+1,0);
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
  public String RunAsync(String p_w_tipodest) {
    w_tipodest = p_w_tipodest;
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
  public double Run(String p_w_tipodest) {
    w_tipodest = p_w_tipodest;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_imp_dati_wubsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_wubsR(p_Ctx, p_Caller);
  }
  public static arrt_imp_dati_wubsR Make(CPContext p_Ctx) {
    return new arrt_imp_dati_wubsR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipodest = CPLib.Space(1);
    mcErrori = new MemoryCursor_mcrowserrori_mcrdef();
    _numprog = CPLib.Space(11);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    filexls = CPLib.Space(128);
    fhand = CPLib.Space(1);
    nProg = 0;
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    conta = 0;
    _nerrori = 0;
    _tdest = CPLib.Space(1);
    _i = 0;
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    nProgImp = 0;
    xData = CPLib.Space(8);
    _tiporap = CPLib.Space(1);
    nVal = 0;
    ndVal = 0;
    nChVal = 0;
    cVal = CPLib.Space(15);
    cTVal = CPLib.Space(1);
    cCVal = CPLib.Space(3);
    nIntest = 0;
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    _esito = 0;
    _idbase = CPLib.Space(10);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _ccab = CPLib.Space(6);
    _cprov = CPLib.Space(2);
    _ccap = CPLib.Space(9);
    _csta = CPLib.Space(3);
    _crag = CPLib.Space(70);
    _cbanca = CPLib.Space(11);
    _btipo = CPLib.Space(2);
    _bragsoc = CPLib.Space(70);
    _bcodcab = CPLib.Space(6);
    _bcitta = CPLib.Space(30);
    _bstato = CPLib.Space(3);
    _bprov = CPLib.Space(2);
    _cauana = CPLib.Space(4);
    _causin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _tipope = CPLib.Space(2);
    _rappd = CPLib.Space(1);
    _legrap = CPLib.Space(16);
    _idb2 = CPLib.Space(10);
    _errore = "";
    nResult = 0;
    _sogliamax = 0;
    _limite20 = CPLib.NullDate();
    _limitesoglia = 0;
    _validstato = CPLib.Space(3);
    _nocf = 0;
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    righe = 0;
    filenome = CPLib.Space(100);
    cell01 = CPLib.Space(100);
    cell02 = CPLib.Space(100);
    cell03 = CPLib.Space(100);
    cell04 = CPLib.Space(100);
    cell05 = CPLib.Space(100);
    cell06 = CPLib.Space(100);
    cell07 = CPLib.Space(100);
    cell08 = CPLib.Space(100);
    cell09 = 0;
    cell09c = 0;
    cell10 = CPLib.Space(100);
    cell11 = 0;
    cell11c = 0;
    cell12 = CPLib.Space(100);
    cell13 = CPLib.Space(100);
    cell14 = CPLib.Space(100);
    cell15 = CPLib.Space(100);
    cell16 = CPLib.Space(100);
    cell17 = CPLib.Space(100);
    cell18 = CPLib.Space(100);
    cell19 = CPLib.Space(100);
    cell20 = CPLib.Space(100);
    cell21 = CPLib.Space(100);
    cell22 = CPLib.Space(100);
    cell23 = CPLib.Space(100);
    cell24 = CPLib.Space(100);
    cell25 = CPLib.Space(100);
    cell26 = CPLib.Space(100);
    cell27 = CPLib.Space(100);
    cell28 = CPLib.Space(100);
    cell29 = CPLib.Space(100);
    cell30 = CPLib.Space(100);
    cell31 = CPLib.Space(100);
    cell32 = CPLib.Space(100);
    cell33 = CPLib.Space(100);
    cell34 = CPLib.Space(100);
    cell35 = CPLib.Space(100);
    cell36 = CPLib.Space(100);
    cell37 = CPLib.Space(100);
    cell38 = CPLib.Space(100);
    cell39 = CPLib.Space(0);
    _rapporto = CPLib.Space(25);
    _contadel = 0;
    _ragsoc = CPLib.Space(70);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chksogg,arfn_fdatetime,arrt_imp_dati_wubs,
  public static final String i_InvokedRoutines = ",arfn_chksogg,arfn_fdatetime,arrt_imp_dati_wubs,";
  public static String[] m_cRunParameterNames={"w_tipodest"};
  protected static String GetFieldsName_000001E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000203(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000215(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000225(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000229(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000231(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000243(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000247(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000254(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000259(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000262(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000268(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xeneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000284(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000296(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"beneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"clientiope",true);
    return p_cSql;
  }
}
