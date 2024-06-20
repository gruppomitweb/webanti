import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_start_estrai_xls extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b5562baa*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_dadata;
    public java.sql.Date w_dadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_adata;
    public java.sql.Date w_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cdadata;
    public String w_cdadata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_c_adata;
    public String w_c_adata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cDIP;
    public String w_cDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdesdip;
    public String w_xdesdip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ragosc;
    public String w_ragosc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_citnas;
    public String w_citnas;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_stanas;
    public String w_stanas;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datnas;
    public java.sql.Date w_datnas;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cMTCN;
    public String w_cMTCN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_cCODFISC;
    public String w_cCODFISC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ragben;
    public String w_ragben;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_staben;
    public String w_staben;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codmag;
    public String w_codmag;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_connes;
    public String w_connes;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_nomefile;
    public String w_nomefile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipofile;
    public String w_tipofile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgsto;
    public String w_flgsto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoout;
    public String w_tipoout;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_opesel;
    public String w_opesel;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_frzsel;
    public String w_frzsel;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_attive;
    public String w_attive;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_destfold;
    public String w_destfold;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgmese;
    public String w_flgmese;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgncf;
    public String w_flgncf;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgsegno;
    public String w_flgsegno;
    public String gAzienda;
    public String gPathApp;
    public String gFileName;
    public String gUrlApp;
    public String gMsgImp;
    public String cProg;
    public String _filezip;
    public String pTipo;
    public void GetNonLocals(SPParameterSource source) {
      if (source instanceof SPRequestSource) {
       ((SPRequestSource)source).request.setAttribute("com.zucchetti.sitepainter.parameters.pTipo","pTipo");
      }        
      pTipo = source.GetParameter("pTipo","");
      m_bpassedw_dadata = source.Has("w_dadata");
      if (m_bpassedw_dadata) {
        w_dadata = source.GetParameter("w_dadata",source.GetParameter("dadata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_dadata = source.GetCaller().GetDate("dadata","D",8,0);
          m_bpassedw_dadata = true;
        } else {
          w_dadata = source.GetParameter("dadata",source.GetParameter("w_dadata",CPLib.NullDate()));
        }
      }
      m_bpassedw_adata = source.Has("w_adata");
      if (m_bpassedw_adata) {
        w_adata = source.GetParameter("w_adata",source.GetParameter("adata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_adata = source.GetCaller().GetDate("adata","D",8,0);
          m_bpassedw_adata = true;
        } else {
          w_adata = source.GetParameter("adata",source.GetParameter("w_adata",CPLib.NullDate()));
        }
      }
      m_bpassedw_cdadata = source.Has("w_cdadata");
      if (m_bpassedw_cdadata) {
        w_cdadata = source.GetParameter("w_cdadata",source.GetParameter("cdadata",""));
      } else {
        if (source.IsForwarded()) {
          w_cdadata = source.GetCaller().GetString("cdadata","C",8,0);
          m_bpassedw_cdadata = true;
        } else {
          w_cdadata = source.GetParameter("cdadata",source.GetParameter("w_cdadata",""));
        }
      }
      m_bpassedw_c_adata = source.Has("w_c_adata");
      if (m_bpassedw_c_adata) {
        w_c_adata = source.GetParameter("w_c_adata",source.GetParameter("c_adata",""));
      } else {
        if (source.IsForwarded()) {
          w_c_adata = source.GetCaller().GetString("c_adata","C",8,0);
          m_bpassedw_c_adata = true;
        } else {
          w_c_adata = source.GetParameter("c_adata",source.GetParameter("w_c_adata",""));
        }
      }
      m_bpassedw_cDIP = source.Has("w_cDIP");
      if (m_bpassedw_cDIP) {
        w_cDIP = source.GetParameter("w_cDIP",source.GetParameter("cDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_cDIP = source.GetCaller().GetString("cDIP","C",6,0);
          m_bpassedw_cDIP = true;
        } else {
          w_cDIP = source.GetParameter("cDIP",source.GetParameter("w_cDIP",""));
        }
      }
      m_bpassedw_xdesdip = source.Has("w_xdesdip");
      if (m_bpassedw_xdesdip) {
        w_xdesdip = source.GetParameter("w_xdesdip",source.GetParameter("xdesdip",""));
      } else {
        if (source.IsForwarded()) {
          w_xdesdip = source.GetCaller().GetString("xdesdip","C",30,0);
          m_bpassedw_xdesdip = true;
        } else {
          w_xdesdip = source.GetParameter("xdesdip",source.GetParameter("w_xdesdip",""));
        }
      }
      m_bpassedw_ragosc = source.Has("w_ragosc");
      if (m_bpassedw_ragosc) {
        w_ragosc = source.GetParameter("w_ragosc",source.GetParameter("ragosc",""));
      } else {
        if (source.IsForwarded()) {
          w_ragosc = source.GetCaller().GetString("ragosc","C",60,0);
          m_bpassedw_ragosc = true;
        } else {
          w_ragosc = source.GetParameter("ragosc",source.GetParameter("w_ragosc",""));
        }
      }
      m_bpassedw_citnas = source.Has("w_citnas");
      if (m_bpassedw_citnas) {
        w_citnas = source.GetParameter("w_citnas",source.GetParameter("citnas",""));
      } else {
        if (source.IsForwarded()) {
          w_citnas = source.GetCaller().GetString("citnas","C",40,0);
          m_bpassedw_citnas = true;
        } else {
          w_citnas = source.GetParameter("citnas",source.GetParameter("w_citnas",""));
        }
      }
      m_bpassedw_stanas = source.Has("w_stanas");
      if (m_bpassedw_stanas) {
        w_stanas = source.GetParameter("w_stanas",source.GetParameter("stanas",""));
      } else {
        if (source.IsForwarded()) {
          w_stanas = source.GetCaller().GetString("stanas","C",40,0);
          m_bpassedw_stanas = true;
        } else {
          w_stanas = source.GetParameter("stanas",source.GetParameter("w_stanas",""));
        }
      }
      m_bpassedw_datnas = source.Has("w_datnas");
      if (m_bpassedw_datnas) {
        w_datnas = source.GetParameter("w_datnas",source.GetParameter("datnas",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datnas = source.GetCaller().GetDate("datnas","D",8,0);
          m_bpassedw_datnas = true;
        } else {
          w_datnas = source.GetParameter("datnas",source.GetParameter("w_datnas",CPLib.NullDate()));
        }
      }
      m_bpassedw_cMTCN = source.Has("w_cMTCN");
      if (m_bpassedw_cMTCN) {
        w_cMTCN = source.GetParameter("w_cMTCN",source.GetParameter("cMTCN",""));
      } else {
        if (source.IsForwarded()) {
          w_cMTCN = source.GetCaller().GetString("cMTCN","C",10,0);
          m_bpassedw_cMTCN = true;
        } else {
          w_cMTCN = source.GetParameter("cMTCN",source.GetParameter("w_cMTCN",""));
        }
      }
      m_bpassedw_cCODFISC = source.Has("w_cCODFISC");
      if (m_bpassedw_cCODFISC) {
        w_cCODFISC = source.GetParameter("w_cCODFISC",source.GetParameter("cCODFISC",""));
      } else {
        if (source.IsForwarded()) {
          w_cCODFISC = source.GetCaller().GetString("cCODFISC","C",16,0);
          m_bpassedw_cCODFISC = true;
        } else {
          w_cCODFISC = source.GetParameter("cCODFISC",source.GetParameter("w_cCODFISC",""));
        }
      }
      m_bpassedw_ragben = source.Has("w_ragben");
      if (m_bpassedw_ragben) {
        w_ragben = source.GetParameter("w_ragben",source.GetParameter("ragben",""));
      } else {
        if (source.IsForwarded()) {
          w_ragben = source.GetCaller().GetString("ragben","C",60,0);
          m_bpassedw_ragben = true;
        } else {
          w_ragben = source.GetParameter("ragben",source.GetParameter("w_ragben",""));
        }
      }
      m_bpassedw_staben = source.Has("w_staben");
      if (m_bpassedw_staben) {
        w_staben = source.GetParameter("w_staben",source.GetParameter("staben",""));
      } else {
        if (source.IsForwarded()) {
          w_staben = source.GetCaller().GetString("staben","C",40,0);
          m_bpassedw_staben = true;
        } else {
          w_staben = source.GetParameter("staben",source.GetParameter("w_staben",""));
        }
      }
      m_bpassedw_codmag = source.Has("w_codmag");
      if (m_bpassedw_codmag) {
        w_codmag = source.GetParameter("w_codmag",source.GetParameter("codmag",""));
      } else {
        if (source.IsForwarded()) {
          w_codmag = source.GetCaller().GetString("codmag","C",5,0);
          m_bpassedw_codmag = true;
        } else {
          w_codmag = source.GetParameter("codmag",source.GetParameter("w_codmag",""));
        }
      }
      m_bpassedw_connes = source.Has("w_connes");
      if (m_bpassedw_connes) {
        w_connes = source.GetParameter("w_connes",source.GetParameter("connes",""));
      } else {
        if (source.IsForwarded()) {
          w_connes = source.GetCaller().GetString("connes","C",16,0);
          m_bpassedw_connes = true;
        } else {
          w_connes = source.GetParameter("connes",source.GetParameter("w_connes",""));
        }
      }
      m_bpassedw_nomefile = source.Has("w_nomefile");
      if (m_bpassedw_nomefile) {
        w_nomefile = source.GetParameter("w_nomefile",source.GetParameter("nomefile",""));
      } else {
        if (source.IsForwarded()) {
          w_nomefile = source.GetCaller().GetString("nomefile","C",60,0);
          m_bpassedw_nomefile = true;
        } else {
          w_nomefile = source.GetParameter("nomefile",source.GetParameter("w_nomefile",""));
        }
      }
      m_bpassedw_tipofile = source.Has("w_tipofile");
      if (m_bpassedw_tipofile) {
        w_tipofile = source.GetParameter("w_tipofile",source.GetParameter("tipofile",""));
      } else {
        if (source.IsForwarded()) {
          w_tipofile = source.GetCaller().GetString("tipofile","C",1,0);
          m_bpassedw_tipofile = true;
        } else {
          w_tipofile = source.GetParameter("tipofile",source.GetParameter("w_tipofile",""));
        }
      }
      m_bpassedw_flgsto = source.Has("w_flgsto");
      if (m_bpassedw_flgsto) {
        w_flgsto = source.GetParameter("w_flgsto",source.GetParameter("flgsto",""));
      } else {
        if (source.IsForwarded()) {
          w_flgsto = source.GetCaller().GetString("flgsto","C",1,0);
          m_bpassedw_flgsto = true;
        } else {
          w_flgsto = source.GetParameter("flgsto",source.GetParameter("w_flgsto",""));
        }
      }
      m_bpassedw_tipoout = source.Has("w_tipoout");
      if (m_bpassedw_tipoout) {
        w_tipoout = source.GetParameter("w_tipoout",source.GetParameter("tipoout",""));
      } else {
        if (source.IsForwarded()) {
          w_tipoout = source.GetCaller().GetString("tipoout","C",1,0);
          m_bpassedw_tipoout = true;
        } else {
          w_tipoout = source.GetParameter("tipoout",source.GetParameter("w_tipoout",""));
        }
      }
      m_bpassedw_opesel = source.Has("w_opesel");
      if (m_bpassedw_opesel) {
        w_opesel = source.GetParameter("w_opesel",source.GetParameter("opesel",""));
      } else {
        if (source.IsForwarded()) {
          w_opesel = source.GetCaller().GetString("opesel","C",1,0);
          m_bpassedw_opesel = true;
        } else {
          w_opesel = source.GetParameter("opesel",source.GetParameter("w_opesel",""));
        }
      }
      m_bpassedw_frzsel = source.Has("w_frzsel");
      if (m_bpassedw_frzsel) {
        w_frzsel = source.GetParameter("w_frzsel",source.GetParameter("frzsel",""));
      } else {
        if (source.IsForwarded()) {
          w_frzsel = source.GetCaller().GetString("frzsel","C",1,0);
          m_bpassedw_frzsel = true;
        } else {
          w_frzsel = source.GetParameter("frzsel",source.GetParameter("w_frzsel",""));
        }
      }
      m_bpassedw_attive = source.Has("w_attive");
      if (m_bpassedw_attive) {
        w_attive = source.GetParameter("w_attive",source.GetParameter("attive",""));
      } else {
        if (source.IsForwarded()) {
          w_attive = source.GetCaller().GetString("attive","C",1,0);
          m_bpassedw_attive = true;
        } else {
          w_attive = source.GetParameter("attive",source.GetParameter("w_attive",""));
        }
      }
      m_bpassedw_destfold = source.Has("w_destfold");
      if (m_bpassedw_destfold) {
        w_destfold = source.GetParameter("w_destfold",source.GetParameter("destfold",""));
      } else {
        if (source.IsForwarded()) {
          w_destfold = source.GetCaller().GetString("destfold","C",128,0);
          m_bpassedw_destfold = true;
        } else {
          w_destfold = source.GetParameter("destfold",source.GetParameter("w_destfold",""));
        }
      }
      m_bpassedw_flgmese = source.Has("w_flgmese");
      if (m_bpassedw_flgmese) {
        w_flgmese = source.GetParameter("w_flgmese",source.GetParameter("flgmese",""));
      } else {
        if (source.IsForwarded()) {
          w_flgmese = source.GetCaller().GetString("flgmese","C",1,0);
          m_bpassedw_flgmese = true;
        } else {
          w_flgmese = source.GetParameter("flgmese",source.GetParameter("w_flgmese",""));
        }
      }
      m_bpassedw_flgncf = source.Has("w_flgncf");
      if (m_bpassedw_flgncf) {
        w_flgncf = source.GetParameter("w_flgncf",source.GetParameter("flgncf",""));
      } else {
        if (source.IsForwarded()) {
          w_flgncf = source.GetCaller().GetString("flgncf","C",1,0);
          m_bpassedw_flgncf = true;
        } else {
          w_flgncf = source.GetParameter("flgncf",source.GetParameter("w_flgncf",""));
        }
      }
      m_bpassedw_flgsegno = source.Has("w_flgsegno");
      if (m_bpassedw_flgsegno) {
        w_flgsegno = source.GetParameter("w_flgsegno",source.GetParameter("flgsegno",""));
      } else {
        if (source.IsForwarded()) {
          w_flgsegno = source.GetCaller().GetString("flgsegno","C",1,0);
          m_bpassedw_flgsegno = true;
        } else {
          w_flgsegno = source.GetParameter("flgsegno",source.GetParameter("w_flgsegno",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_start_estrai_xls";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = true;
    return l_eg;
  }
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    // Inizializzazione delle variabili della classe globale di stato
    ServletStatus status;
    status = new ServletStatus();
    status.containing = this;
    SPParameterSource source;
    source = SPLib.GetSource(request);
    if ( ! (EnterServlet(status,source,request,response))) {
      return;
    }
    Begin(status);
  }
  boolean NeedsFetchPage(ServletStatus status) {
    return  ! (status.m_bpassedw_flgsegno) ||  ! (status.m_bpassedw_flgncf) ||  ! (status.m_bpassedw_flgmese) ||  ! (status.m_bpassedw_destfold) ||  ! (status.m_bpassedw_attive) ||  ! (status.m_bpassedw_frzsel) ||  ! (status.m_bpassedw_opesel) ||  ! (status.m_bpassedw_tipoout) ||  ! (status.m_bpassedw_flgsto) ||  ! (status.m_bpassedw_tipofile) ||  ! (status.m_bpassedw_nomefile) ||  ! (status.m_bpassedw_connes) ||  ! (status.m_bpassedw_codmag) ||  ! (status.m_bpassedw_staben) ||  ! (status.m_bpassedw_ragben) ||  ! (status.m_bpassedw_cCODFISC) ||  ! (status.m_bpassedw_cMTCN) ||  ! (status.m_bpassedw_datnas) ||  ! (status.m_bpassedw_stanas) ||  ! (status.m_bpassedw_citnas) ||  ! (status.m_bpassedw_ragosc) ||  ! (status.m_bpassedw_xdesdip) ||  ! (status.m_bpassedw_cDIP) ||  ! (status.m_bpassedw_c_adata) ||  ! (status.m_bpassedw_cdadata) ||  ! (status.m_bpassedw_adata) ||  ! (status.m_bpassedw_dadata);
  }
  private void FetchPage(ServletStatus status) throws IOException {
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<head>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    IncludeJS(status);
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    status.out.println(
     "</head>" +
    "");
    status.out.println(
     "<body>" +
    "");
    status.out.println(
     "<form name='RoutineParms' method='POST' action='"+status.m_cURL+"'>" +
    "");
    status.out.println(
     "<input name='m_cAction' type='hidden' value="+SPLib.ToHTMLValue("execute","C",0,0)+">" +
    "");
    status.out.println(
     "<input name='m_cAtExit' type='hidden' value="+SPLib.ToHTMLValue(status.m_cAtExit,"C",0,0)+">" +
    "");
    status.out.println(
     "<input name='m_cWv' type='hidden' value=''>" +
    "");
    status.out.println(
     "</form>" +
    "");
    status.out.println(
     "<p>" +
     ""+status.context.Translate("MSG_ROUTINE_WAIT")+"" +
     "</p>" +
    "");
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("AppletTag('Wv','Trs');");
    status.out.println("var l_oWv = InitWvApplet();");
    status.out.println("var l_oWnd;");
    status.out.println("var l_cV;");
    if (SPLib.HasRegionalSettings(status.context)) {
      status.out.println("SetWindowObject(false);");
    } else {
      status.out.println("SetWindowObject(true);");
    }
    if ( ! (status.m_bpassedw_dadata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_dadata',"+SPLib.ToJSValue(status.w_dadata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_dadata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_dadata',l_cV);");
    if ( ! (status.m_bpassedw_adata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_adata',"+SPLib.ToJSValue(status.w_adata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_adata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_adata',l_cV);");
    if ( ! (status.m_bpassedw_cdadata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cdadata',"+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cdadata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cdadata',l_cV);");
    if ( ! (status.m_bpassedw_c_adata)) {
      status.out.println("l_cV=WtA(l_oWnd('w_c_adata',"+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_c_adata,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_c_adata',l_cV);");
    if ( ! (status.m_bpassedw_cDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cDIP',"+SPLib.ToJSValue(status.w_cDIP,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cDIP,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cDIP',l_cV);");
    if ( ! (status.m_bpassedw_xdesdip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdesdip',"+SPLib.ToJSValue(status.w_xdesdip,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdesdip,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdesdip',l_cV);");
    if ( ! (status.m_bpassedw_ragosc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ragosc',"+SPLib.ToJSValue(status.w_ragosc,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragosc,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ragosc',l_cV);");
    if ( ! (status.m_bpassedw_citnas)) {
      status.out.println("l_cV=WtA(l_oWnd('w_citnas',"+SPLib.ToJSValue(status.w_citnas,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_citnas,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_citnas',l_cV);");
    if ( ! (status.m_bpassedw_stanas)) {
      status.out.println("l_cV=WtA(l_oWnd('w_stanas',"+SPLib.ToJSValue(status.w_stanas,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_stanas,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_stanas',l_cV);");
    if ( ! (status.m_bpassedw_datnas)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datnas',"+SPLib.ToJSValue(status.w_datnas,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datnas,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datnas',l_cV);");
    if ( ! (status.m_bpassedw_cMTCN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cMTCN',"+SPLib.ToJSValue(status.w_cMTCN,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cMTCN,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cMTCN',l_cV);");
    if ( ! (status.m_bpassedw_cCODFISC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_cCODFISC',"+SPLib.ToJSValue(status.w_cCODFISC,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_cCODFISC,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_cCODFISC',l_cV);");
    if ( ! (status.m_bpassedw_ragben)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ragben',"+SPLib.ToJSValue(status.w_ragben,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragben,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ragben',l_cV);");
    if ( ! (status.m_bpassedw_staben)) {
      status.out.println("l_cV=WtA(l_oWnd('w_staben',"+SPLib.ToJSValue(status.w_staben,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_staben,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_staben',l_cV);");
    if ( ! (status.m_bpassedw_codmag)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codmag',"+SPLib.ToJSValue(status.w_codmag,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codmag,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codmag',l_cV);");
    if ( ! (status.m_bpassedw_connes)) {
      status.out.println("l_cV=WtA(l_oWnd('w_connes',"+SPLib.ToJSValue(status.w_connes,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_connes,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_connes',l_cV);");
    if ( ! (status.m_bpassedw_nomefile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_nomefile',"+SPLib.ToJSValue(status.w_nomefile,"C",60,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_nomefile,"C",60,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_nomefile',l_cV);");
    if ( ! (status.m_bpassedw_tipofile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipofile',"+SPLib.ToJSValue(status.w_tipofile,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipofile,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipofile',l_cV);");
    if ( ! (status.m_bpassedw_flgsto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgsto',"+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgsto',l_cV);");
    if ( ! (status.m_bpassedw_tipoout)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoout',"+SPLib.ToJSValue(status.w_tipoout,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoout,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoout',l_cV);");
    if ( ! (status.m_bpassedw_opesel)) {
      status.out.println("l_cV=WtA(l_oWnd('w_opesel',"+SPLib.ToJSValue(status.w_opesel,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_opesel,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_opesel',l_cV);");
    if ( ! (status.m_bpassedw_frzsel)) {
      status.out.println("l_cV=WtA(l_oWnd('w_frzsel',"+SPLib.ToJSValue(status.w_frzsel,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_frzsel,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_frzsel',l_cV);");
    if ( ! (status.m_bpassedw_attive)) {
      status.out.println("l_cV=WtA(l_oWnd('w_attive',"+SPLib.ToJSValue(status.w_attive,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_attive,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_attive',l_cV);");
    if ( ! (status.m_bpassedw_destfold)) {
      status.out.println("l_cV=WtA(l_oWnd('w_destfold',"+SPLib.ToJSValue(status.w_destfold,"C",128,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_destfold,"C",128,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_destfold',l_cV);");
    if ( ! (status.m_bpassedw_flgmese)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgmese',"+SPLib.ToJSValue(status.w_flgmese,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgmese,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgmese',l_cV);");
    if ( ! (status.m_bpassedw_flgncf)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgncf',"+SPLib.ToJSValue(status.w_flgncf,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgncf,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgncf',l_cV);");
    if ( ! (status.m_bpassedw_flgsegno)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgsegno',"+SPLib.ToJSValue(status.w_flgsegno,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsegno,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgsegno',l_cV);");
    status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.pTipo,"C",1,0)+",'C');");
    status.out.println("l_oWv.setValue('pTipo',l_cV);");
    status.out.println("document.RoutineParms.m_cWv.value=WvApplet().asString();");
    status.out.println("document.RoutineParms.submit();");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void ExecuteRoutine(ServletStatus status) throws IOException {
    arrt_start_estrai_xlsR Rcalled;
    Rcalled = new arrt_start_estrai_xlsR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run(status.pTipo);
      if (Rcalled.m_bError) {
        status.m_bError = true;
        status.m_cErrMsg = Rcalled.m_cLastMsgError;
      } else if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
        status.m_bError = true;
        status.m_cErrMsg = status.m_cFaultTrace;
      }
      if (CPLib.eqr(CPLib.Left(status.m_cAtExit,8),"workflow")) {
        ExitToWorkflow(status);
      }
      if (Forward.IsForwarded(status.forwardedto)) {
        if (CPLib.IsNull(status.forwardedto.GetParameterString("m_cAtExit",null))) {
          status.forwardedto.SetParameter("m_cAtExit",status.m_cAtExit);
        }
        SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
        return;
      }
    }
    BringBackPage(status,Rcalled);
  }
  CallerWithObjs NewRoutine(SPServletStatus status,Caller dataFromClient) {
    return new arrt_start_estrai_xlsR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_start_estrai_xlsR Rcalled) throws IOException {
    String l_cErrMsg;
    String msg;
    msg = status.context.Translate("MSG_END_ROUTINE");
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<head>" +
    "");
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<link type='text/css' rel='STYLESHEET' href='../"+status.m_cTheme+"/formPage.css'>" +
    "");
    status.out.println(
     "</head>" +
    "");
    if (status.m_bError) {
      msg = status.context.Translate("MSG_END_ROUTINE_WITH_MSG");
      status.out.println(
       "<body onkeydown='window.ManageKeys(event,false,false)'>" +
      "");
    } else {
      status.out.println(
       "<body>" +
      "");
    }
    status.out.println(
     "<p class='TabLabel' style='margin:0'>" +
     ""+msg+"" +
     "</p>" +
    "");
    if (status.m_bError) {
      status.out.println(
       "<script type='text/javascript'>" +
      "");
      l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
      status.out.println("detailed_database_error="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
      status.out.println("m_cBrowser=" + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    if (CPLib.eqr(status.m_cAction,"executeAsync")) {
      status.out.println(
       "<!--" +
      "");
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync(status.pTipo)))+"");
      status.out.println(
       " -->" +
      "");
    } else {
      if (status.m_bApplet) {
        status.out.println(
         "<!--" +
        "");
        if ( ! (CPLib.Empty(Rcalled.m_cLastMsgError))) {
          CPTokenSource ts;
          ts = new CPTokenSource(status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(Rcalled.m_cLastMsgError)),"\n");
          while (ts.HasMoreTokens()) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(ts.NextToken())+"");
          }
        }
        if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_start_estrai_xls"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_dadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_dadata),"?",0,0)+"");
        status.out.println("js:w_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_adata),"?",0,0)+"");
        status.out.println("js:w_cdadata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cdadata),"?",0,0)+"");
        status.out.println("js:w_c_adata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_c_adata),"?",0,0)+"");
        status.out.println("js:w_cDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cDIP),"?",0,0)+"");
        status.out.println("js:w_xdesdip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdesdip),"?",0,0)+"");
        status.out.println("js:w_ragosc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ragosc),"?",0,0)+"");
        status.out.println("js:w_citnas="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_citnas),"?",0,0)+"");
        status.out.println("js:w_stanas="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_stanas),"?",0,0)+"");
        status.out.println("js:w_datnas="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datnas),"?",0,0)+"");
        status.out.println("js:w_cMTCN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cMTCN),"?",0,0)+"");
        status.out.println("js:w_cCODFISC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_cCODFISC),"?",0,0)+"");
        status.out.println("js:w_ragben="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ragben),"?",0,0)+"");
        status.out.println("js:w_staben="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_staben),"?",0,0)+"");
        status.out.println("js:w_codmag="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codmag),"?",0,0)+"");
        status.out.println("js:w_connes="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_connes),"?",0,0)+"");
        status.out.println("js:w_nomefile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_nomefile),"?",0,0)+"");
        status.out.println("js:w_tipofile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipofile),"?",0,0)+"");
        status.out.println("js:w_flgsto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgsto),"?",0,0)+"");
        status.out.println("js:w_tipoout="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoout),"?",0,0)+"");
        status.out.println("js:w_opesel="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_opesel),"?",0,0)+"");
        status.out.println("js:w_frzsel="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_frzsel),"?",0,0)+"");
        status.out.println("js:w_attive="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_attive),"?",0,0)+"");
        status.out.println("js:w_destfold="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_destfold),"?",0,0)+"");
        status.out.println("js:w_flgmese="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgmese),"?",0,0)+"");
        status.out.println("js:w_flgncf="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgncf),"?",0,0)+"");
        status.out.println("js:w_flgsegno="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgsegno),"?",0,0)+"");
        status.PrintMutableParameters();
        status.out.println(
         " -->" +
        "");
      } else {
        status.out.println(
         "<script type='text/javascript'>" +
        "");
        status.out.println("f=NameForCaller();");
        status.out.println("if (IsWndAccessible(window[f])) {");
        status.out.println("if (Ne(typeof(window[f].DisplayErrorMessage),'undefined') && Ne(typeof(window[f].CalledBatchEnd),'undefined')) {");
        status.out.println("if (Ne(window[f].w_dadata,null)) {");
        status.out.println(" window[f].w_dadata.setTime(("+SPLib.ToJSValue(status.w_dadata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_adata,null)) {");
        status.out.println(" window[f].w_adata.setTime(("+SPLib.ToJSValue(status.w_adata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cdadata,null)) {");
        status.out.println("window[f].w_cdadata="+SPLib.ToJSValue(status.w_cdadata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_c_adata,null)) {");
        status.out.println("window[f].w_c_adata="+SPLib.ToJSValue(status.w_c_adata,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cDIP,null)) {");
        status.out.println("window[f].w_cDIP="+SPLib.ToJSValue(status.w_cDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdesdip,null)) {");
        status.out.println("window[f].w_xdesdip="+SPLib.ToJSValue(status.w_xdesdip,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ragosc,null)) {");
        status.out.println("window[f].w_ragosc="+SPLib.ToJSValue(status.w_ragosc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_citnas,null)) {");
        status.out.println("window[f].w_citnas="+SPLib.ToJSValue(status.w_citnas,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_stanas,null)) {");
        status.out.println("window[f].w_stanas="+SPLib.ToJSValue(status.w_stanas,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datnas,null)) {");
        status.out.println(" window[f].w_datnas.setTime(("+SPLib.ToJSValue(status.w_datnas,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cMTCN,null)) {");
        status.out.println("window[f].w_cMTCN="+SPLib.ToJSValue(status.w_cMTCN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_cCODFISC,null)) {");
        status.out.println("window[f].w_cCODFISC="+SPLib.ToJSValue(status.w_cCODFISC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ragben,null)) {");
        status.out.println("window[f].w_ragben="+SPLib.ToJSValue(status.w_ragben,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_staben,null)) {");
        status.out.println("window[f].w_staben="+SPLib.ToJSValue(status.w_staben,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codmag,null)) {");
        status.out.println("window[f].w_codmag="+SPLib.ToJSValue(status.w_codmag,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_connes,null)) {");
        status.out.println("window[f].w_connes="+SPLib.ToJSValue(status.w_connes,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_nomefile,null)) {");
        status.out.println("window[f].w_nomefile="+SPLib.ToJSValue(status.w_nomefile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipofile,null)) {");
        status.out.println("window[f].w_tipofile="+SPLib.ToJSValue(status.w_tipofile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgsto,null)) {");
        status.out.println("window[f].w_flgsto="+SPLib.ToJSValue(status.w_flgsto,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipoout,null)) {");
        status.out.println("window[f].w_tipoout="+SPLib.ToJSValue(status.w_tipoout,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_opesel,null)) {");
        status.out.println("window[f].w_opesel="+SPLib.ToJSValue(status.w_opesel,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_frzsel,null)) {");
        status.out.println("window[f].w_frzsel="+SPLib.ToJSValue(status.w_frzsel,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_attive,null)) {");
        status.out.println("window[f].w_attive="+SPLib.ToJSValue(status.w_attive,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_destfold,null)) {");
        status.out.println("window[f].w_destfold="+SPLib.ToJSValue(status.w_destfold,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgmese,null)) {");
        status.out.println("window[f].w_flgmese="+SPLib.ToJSValue(status.w_flgmese,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgncf,null)) {");
        status.out.println("window[f].w_flgncf="+SPLib.ToJSValue(status.w_flgncf,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgsegno,null)) {");
        status.out.println("window[f].w_flgsegno="+SPLib.ToJSValue(status.w_flgsegno,"C",0,0)+";");
        status.out.println("}");
        if (status.m_bError) {
          l_cErrMsg = status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(status.m_cErrMsg));
          status.out.println("window[f].l_cErrorMsg="+SPLib.ToJSValue(l_cErrMsg,"C",0,0)+";");
          status.out.println("window[f].DisplayErrorMessage();");
        } else {
          status.out.println("window[f].CalledBatchEnd();");
        }
        status.out.println("}");
        status.out.println("CloseEnclosing();");
        status.out.println("}");
        status.out.println(
         "</script>" +
        "");
      }
    }
    status.out.println(
     "</body>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  private void Begin(ServletStatus status) throws IOException {
    if ( ! (CPLib.Empty(status.m_cBrowseName))) {
      JSResultSet(status);
    } else if ( ! (CPLib.Empty(status.m_cGlobalsToRead))) {
      JSGlobals(status);
    } else if (CPLib.eqr(status.m_cAction,"start") && NeedsFetchPage(status)) {
      FetchPage(status);
    } else if (CPLib.eqr(status.m_cAction,"execute") || CPLib.eqr(status.m_cAction,"start") || CPLib.eqr(status.m_cAction,"executeAsync")) {
      ExecuteRoutine(status);
    } else {
      arrt_start_estrai_xlsR Rcalled;
      Rcalled = new arrt_start_estrai_xlsR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_start_estrai_xls");
      if ( ! (CPLib.IsNull(l))) {
        l.log(Rcalled.m_cLastMsgError);
      }
      status.m_bError = true;
      status.m_cErrMsg = Rcalled.m_cLastMsgError;
      BringBackPage(status,Rcalled);
    }
  }
  void IncludeJS(ServletStatus status) {
    /* --- Area Manuale = UI - Include */
    /* --- Fine Area Manuale */
  }
  // m_CallableNames inizializzato dal primo accesso a GetCallableNames
  private static volatile String[] m_CallableNames;
  public static String[] GetCallableNames() {
    if (CPLib.IsNull(m_CallableNames)) {
      java.util.Set building = new java.util.HashSet();
      GetCallableNames(building);
      m_CallableNames = CPLib.SetOfStringsAsArray(building);
    }
    return (String[])m_CallableNames.clone();
  }
  public static void GetCallableNames(java.util.Set callable) {
  }
  String[] RoutineIDChain() {
    return GetCallableNames();
  }
}
