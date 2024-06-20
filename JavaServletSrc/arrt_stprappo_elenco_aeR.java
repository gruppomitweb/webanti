// * --- Area Manuale = BO - Header
// * --- arrt_stprappo_elenco_ae
import java.io.File; 
import java.lang.Double;

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
public class arrt_stprappo_elenco_aeR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stprapporti_ele;
  public String m_cServer_tmp_stprapporti_ele;
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
  public String w_daRappo;
  public String w_aRappo;
  public java.sql.Date w_DaDatIni;
  public java.sql.Date w_ADatIni;
  public java.sql.Date w_DaDatFin;
  public java.sql.Date w_ADatFin;
  public String w_tipo;
  public String gPathApp;
  public String gUrlApp;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stprappo_elenco_ae
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stprappo_elenco_aeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stprappo_elenco_ae",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
      m_cPhName_tmp_stprapporti_ele = p_ContextObject.GetPhName("tmp_stprapporti_ele");
      if (m_cPhName_tmp_stprapporti_ele.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stprapporti_ele = m_cPhName_tmp_stprapporti_ele+" "+m_Ctx.GetWritePhName("tmp_stprapporti_ele");
      }
      m_cServer_tmp_stprapporti_ele = p_ContextObject.GetServer("tmp_stprapporti_ele");
    }
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
      return "arrt_stprappo_elenco_ae";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      return w_daRappo;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      return w_aRappo;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatIni",p_cVarName)) {
      return w_DaDatIni;
    }
    if (CPLib.eqr("ADatIni",p_cVarName)) {
      return w_ADatIni;
    }
    if (CPLib.eqr("DaDatFin",p_cVarName)) {
      return w_DaDatFin;
    }
    if (CPLib.eqr("ADatFin",p_cVarName)) {
      return w_ADatFin;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("daRappo",p_cVarName)) {
      w_daRappo = value;
      return;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      w_aRappo = value;
      return;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      w_tipo = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatIni",p_cVarName)) {
      w_DaDatIni = value;
      return;
    }
    if (CPLib.eqr("ADatIni",p_cVarName)) {
      w_ADatIni = value;
      return;
    }
    if (CPLib.eqr("DaDatFin",p_cVarName)) {
      w_DaDatFin = value;
      return;
    }
    if (CPLib.eqr("ADatFin",p_cVarName)) {
      w_ADatFin = value;
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
    CPResultSet Cursor_qbe_allrapopebo_ele_ae=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Parametro della procedura */
      /* w_daRappo Char(25) */
      /* w_aRappo Char(25) */
      /* w_DaDatIni Date */
      /* w_ADatIni Date */
      /* w_DaDatFin Date */
      /* w_ADatFin Date */
      /* w_tipo Char(1) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* Lancio la stampa */
      // * --- Drop temporary table tmp_stprapporti_ele
      if (m_Ctx.IsSharedTemp("tmp_stprapporti_ele")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
          m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
          m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stprapporti_ele");
      }
      /* Case w_tipo='T' */
      if (CPLib.eqr(w_tipo,"T")) {
        // * --- Create temporary table tmp_stprapporti_ele
        if (m_Ctx.IsSharedTemp("tmp_stprapporti_ele")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
            m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_stprapporti_ele");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti_ele");
        new VQRHolder("qbe_allrapopebo_ele_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "tmp_stprapporti_ele",false);
        m_cPhName_tmp_stprapporti_ele = m_cPhName;
        /* Case w_tipo='A' */
      } else if (CPLib.eqr(w_tipo,"A")) {
        // * --- Create temporary table tmp_stprapporti_ele
        if (m_Ctx.IsSharedTemp("tmp_stprapporti_ele")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
            m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_stprapporti_ele");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti_ele");
        if ( ! (m_Ctx.IsSharedTemp("tmp_stprapporti_ele"))) {
          m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stprapporti_ele",m_cServer,"proto")),m_cPhName,"tmp_stprapporti_ele",m_Ctx,new String[]{"RAPPORTO","NUMPROG"});
        }
        m_cPhName_tmp_stprapporti_ele = m_cPhName;
        // * --- Select from qbe_allrapopebo_ele_ae
        SPBridge.HMCaller _h00000013;
        _h00000013 = new SPBridge.HMCaller();
        _h00000013.Set("m_cVQRList",m_cVQRList);
        _h00000013.Set("DaRappo",w_daRappo);
        _h00000013.Set("ARappo",w_aRappo);
        _h00000013.Set("DaDatIni",w_DaDatIni);
        _h00000013.Set("ADatIni",w_ADatIni);
        _h00000013.Set("DaDatFin",w_DaDatFin);
        _h00000013.Set("ADatFin",w_ADatFin);
        if (Cursor_qbe_allrapopebo_ele_ae!=null)
          Cursor_qbe_allrapopebo_ele_ae.Close();
        Cursor_qbe_allrapopebo_ele_ae = new VQRHolder("qbe_allrapopebo_ele_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000013,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_allrapopebo_ele_ae.Eof())) {
          /* If Empty(qbe_allrapopebo_ele_ae->DATAFINE) */
          if (CPLib.Empty(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAFINE"))) {
            // * --- Insert into tmp_stprapporti_ele from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti_ele",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_elenco_ae",77,"00000015")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000015(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti_ele",true);
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
          Cursor_qbe_allrapopebo_ele_ae.Next();
        }
        m_cConnectivityError = Cursor_qbe_allrapopebo_ele_ae.ErrorMessage();
        Cursor_qbe_allrapopebo_ele_ae.Close();
        // * --- End Select
        /* Case w_tipo='C' */
      } else if (CPLib.eqr(w_tipo,"C")) {
        // * --- Create temporary table tmp_stprapporti_ele
        if (m_Ctx.IsSharedTemp("tmp_stprapporti_ele")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
            m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_stprapporti_ele");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti_ele");
        if ( ! (m_Ctx.IsSharedTemp("tmp_stprapporti_ele"))) {
          m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stprapporti_ele",m_cServer,"proto")),m_cPhName,"tmp_stprapporti_ele",m_Ctx,new String[]{"RAPPORTO","NUMPROG"});
        }
        m_cPhName_tmp_stprapporti_ele = m_cPhName;
        // * --- Select from qbe_allrapopebo_ele_ae
        SPBridge.HMCaller _h00000017;
        _h00000017 = new SPBridge.HMCaller();
        _h00000017.Set("m_cVQRList",m_cVQRList);
        _h00000017.Set("DaRappo",w_daRappo);
        _h00000017.Set("ARappo",w_aRappo);
        _h00000017.Set("DaDatIni",w_DaDatIni);
        _h00000017.Set("ADatIni",w_ADatIni);
        _h00000017.Set("DaDatFin",w_DaDatFin);
        _h00000017.Set("ADatFin",w_ADatFin);
        if (Cursor_qbe_allrapopebo_ele_ae!=null)
          Cursor_qbe_allrapopebo_ele_ae.Close();
        Cursor_qbe_allrapopebo_ele_ae = new VQRHolder("qbe_allrapopebo_ele_ae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000017,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_allrapopebo_ele_ae.Eof())) {
          /* If not(Empty(qbe_allrapopebo_ele_ae->DATAFINE)) */
          if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAFINE")))) {
            // * --- Insert into tmp_stprapporti_ele from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
            m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stprapporti_ele",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stprappo_elenco_ae",77,"00000019")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000019(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAINI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetDate("DATAFINE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_ele_ae.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stprapporti_ele",true);
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
          Cursor_qbe_allrapopebo_ele_ae.Next();
        }
        m_cConnectivityError = Cursor_qbe_allrapopebo_ele_ae.ErrorMessage();
        Cursor_qbe_allrapopebo_ele_ae.Close();
        // * --- End Select
      } // End Case
      /* Stop Report */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_stprappo_elenco_ae");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("daRappo",w_daRappo);
      f.SetParameter("aRappo",w_aRappo);
      f.SetParameter("DaDatIni",w_DaDatIni);
      f.SetParameter("ADatIni",w_ADatIni);
      f.SetParameter("DaDatFin",w_DaDatFin);
      f.SetParameter("ADatFin",w_ADatFin);
      f.SetParameter("tipo",w_tipo);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"daRappo"+","+"aRappo"+","+"DaDatIni"+","+"ADatIni"+","+"DaDatFin"+","+"ADatFin"+","+"tipo"+","+"DescAzi");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_ele_ae!=null)
          Cursor_qbe_allrapopebo_ele_ae.Close();
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
      m_Caller.SetString("daRappo","C",25,0,w_daRappo);
      m_Caller.SetString("aRappo","C",25,0,w_aRappo);
      m_Caller.SetDate("DaDatIni","D",8,0,w_DaDatIni);
      m_Caller.SetDate("ADatIni","D",8,0,w_ADatIni);
      m_Caller.SetDate("DaDatFin","D",8,0,w_DaDatFin);
      m_Caller.SetDate("ADatFin","D",8,0,w_ADatFin);
      m_Caller.SetString("tipo","C",1,0,w_tipo);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stprappo_elenco_aeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stprappo_elenco_aeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daRappo = m_Caller.GetString("daRappo","C",25,0);
    w_aRappo = m_Caller.GetString("aRappo","C",25,0);
    w_DaDatIni = m_Caller.GetDate("DaDatIni","D",8,0);
    w_ADatIni = m_Caller.GetDate("ADatIni","D",8,0);
    w_DaDatFin = m_Caller.GetDate("DaDatFin","D",8,0);
    w_ADatFin = m_Caller.GetDate("ADatFin","D",8,0);
    w_tipo = m_Caller.GetString("tipo","C",1,0);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapopebo_ele_ae,qbe_allrapopebo_ele_ae,qbe_allrapopebo_ele_ae,
  public static final String m_cVQRList = ",qbe_allrapopebo_ele_ae,qbe_allrapopebo_ele_ae,qbe_allrapopebo_ele_ae,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000015(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti_ele",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000019(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stprapporti_ele",true);
    return p_cSql;
  }
}
