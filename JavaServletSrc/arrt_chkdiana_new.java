import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_chkdiana_new extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*WHAMLAQQKN*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codinter;
    public String w_codinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipinter;
    public String w_tipinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaData;
    public java.sql.Date w_DaData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AData;
    public java.sql.Date w_AData;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipoarch;
    public String w_tipoarch;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codage;
    public String w_codage;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgope;
    public String w_flgope;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgfrz;
    public String w_flgfrz;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgint;
    public String w_flgint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgrae;
    public String w_flgrae;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgrap;
    public String w_flgrap;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tiprap;
    public String w_tiprap;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_codcli;
    public String w_codcli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ragben;
    public String w_ragben;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgsto;
    public String w_flgsto;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgchk;
    public String w_flgchk;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_flgdel;
    public String w_flgdel;
    public String gPathApp;
    public String gIntemediario;
    public String gUrlApp;
    public String gAzienda;
    public double gNumRec;
    public double gNumReg;
    public String gMsgImp;
    public String gMsgProc;
    public String gFlgWU;
    public String w_codcab;
    public String w_cabcod;
    public String w_desccit;
    public String w_citdesc;
    public String w_provin;
    public String w_provind;
    public String w_coddipe;
    public String _note;
    public String fhand;
    public String _nomefile;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public double nTotRec;
    public double nTotReg;
    public double nNumRec;
    public double _avanza;
    public String _codrif;
    public String w_cdadata;
    public String w_c_adata;
    public String w_cdadata_rap;
    public String w_c_adata_rap;
    public double _ctotale;
    public double _conta;
    public double _max;
    public double _min;
    public double _top;
    public double _bottom;
    public double _cicli;
    public double _contacilci;
    public String _flagrap;
    public double _ciclo;
    public String _ramate;
    public String _numsto;
    public double _oldrighe;
    public double _continua;
    public String _oldrap;
    public String _idereg;
    public String xStato;
    public double _conta1;
    public double _conta2;
    public double _conta4;
    public double _conta5;
    public double _conta6;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_codinter = source.Has("w_codinter");
      if (m_bpassedw_codinter) {
        w_codinter = source.GetParameter("w_codinter",source.GetParameter("codinter",""));
      } else {
        if (source.IsForwarded()) {
          w_codinter = source.GetCaller().GetString("codinter","C",11,0);
          m_bpassedw_codinter = true;
        } else {
          w_codinter = source.GetParameter("codinter",source.GetParameter("w_codinter",""));
        }
      }
      m_bpassedw_tipinter = source.Has("w_tipinter");
      if (m_bpassedw_tipinter) {
        w_tipinter = source.GetParameter("w_tipinter",source.GetParameter("tipinter",""));
      } else {
        if (source.IsForwarded()) {
          w_tipinter = source.GetCaller().GetString("tipinter","C",2,0);
          m_bpassedw_tipinter = true;
        } else {
          w_tipinter = source.GetParameter("tipinter",source.GetParameter("w_tipinter",""));
        }
      }
      m_bpassedw_DaData = source.Has("w_DaData");
      if (m_bpassedw_DaData) {
        w_DaData = source.GetParameter("w_DaData",source.GetParameter("DaData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaData = source.GetCaller().GetDate("DaData","D",8,0);
          m_bpassedw_DaData = true;
        } else {
          w_DaData = source.GetParameter("DaData",source.GetParameter("w_DaData",CPLib.NullDate()));
        }
      }
      m_bpassedw_AData = source.Has("w_AData");
      if (m_bpassedw_AData) {
        w_AData = source.GetParameter("w_AData",source.GetParameter("AData",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_AData = source.GetCaller().GetDate("AData","D",8,0);
          m_bpassedw_AData = true;
        } else {
          w_AData = source.GetParameter("AData",source.GetParameter("w_AData",CPLib.NullDate()));
        }
      }
      m_bpassedw_tipoarch = source.Has("w_tipoarch");
      if (m_bpassedw_tipoarch) {
        w_tipoarch = source.GetParameter("w_tipoarch",source.GetParameter("tipoarch",""));
      } else {
        if (source.IsForwarded()) {
          w_tipoarch = source.GetCaller().GetString("tipoarch","C",1,0);
          m_bpassedw_tipoarch = true;
        } else {
          w_tipoarch = source.GetParameter("tipoarch",source.GetParameter("w_tipoarch",""));
        }
      }
      m_bpassedw_codage = source.Has("w_codage");
      if (m_bpassedw_codage) {
        w_codage = source.GetParameter("w_codage",source.GetParameter("codage",""));
      } else {
        if (source.IsForwarded()) {
          w_codage = source.GetCaller().GetString("codage","C",6,0);
          m_bpassedw_codage = true;
        } else {
          w_codage = source.GetParameter("codage",source.GetParameter("w_codage",""));
        }
      }
      m_bpassedw_flgope = source.Has("w_flgope");
      if (m_bpassedw_flgope) {
        w_flgope = source.GetParameter("w_flgope",source.GetParameter("flgope",""));
      } else {
        if (source.IsForwarded()) {
          w_flgope = source.GetCaller().GetString("flgope","C",1,0);
          m_bpassedw_flgope = true;
        } else {
          w_flgope = source.GetParameter("flgope",source.GetParameter("w_flgope",""));
        }
      }
      m_bpassedw_flgfrz = source.Has("w_flgfrz");
      if (m_bpassedw_flgfrz) {
        w_flgfrz = source.GetParameter("w_flgfrz",source.GetParameter("flgfrz",""));
      } else {
        if (source.IsForwarded()) {
          w_flgfrz = source.GetCaller().GetString("flgfrz","C",1,0);
          m_bpassedw_flgfrz = true;
        } else {
          w_flgfrz = source.GetParameter("flgfrz",source.GetParameter("w_flgfrz",""));
        }
      }
      m_bpassedw_flgint = source.Has("w_flgint");
      if (m_bpassedw_flgint) {
        w_flgint = source.GetParameter("w_flgint",source.GetParameter("flgint",""));
      } else {
        if (source.IsForwarded()) {
          w_flgint = source.GetCaller().GetString("flgint","C",1,0);
          m_bpassedw_flgint = true;
        } else {
          w_flgint = source.GetParameter("flgint",source.GetParameter("w_flgint",""));
        }
      }
      m_bpassedw_flgrae = source.Has("w_flgrae");
      if (m_bpassedw_flgrae) {
        w_flgrae = source.GetParameter("w_flgrae",source.GetParameter("flgrae",""));
      } else {
        if (source.IsForwarded()) {
          w_flgrae = source.GetCaller().GetString("flgrae","C",1,0);
          m_bpassedw_flgrae = true;
        } else {
          w_flgrae = source.GetParameter("flgrae",source.GetParameter("w_flgrae",""));
        }
      }
      m_bpassedw_flgrap = source.Has("w_flgrap");
      if (m_bpassedw_flgrap) {
        w_flgrap = source.GetParameter("w_flgrap",source.GetParameter("flgrap",""));
      } else {
        if (source.IsForwarded()) {
          w_flgrap = source.GetCaller().GetString("flgrap","C",1,0);
          m_bpassedw_flgrap = true;
        } else {
          w_flgrap = source.GetParameter("flgrap",source.GetParameter("w_flgrap",""));
        }
      }
      m_bpassedw_tiprap = source.Has("w_tiprap");
      if (m_bpassedw_tiprap) {
        w_tiprap = source.GetParameter("w_tiprap",source.GetParameter("tiprap",""));
      } else {
        if (source.IsForwarded()) {
          w_tiprap = source.GetCaller().GetString("tiprap","C",1,0);
          m_bpassedw_tiprap = true;
        } else {
          w_tiprap = source.GetParameter("tiprap",source.GetParameter("w_tiprap",""));
        }
      }
      m_bpassedw_codcli = source.Has("w_codcli");
      if (m_bpassedw_codcli) {
        w_codcli = source.GetParameter("w_codcli",source.GetParameter("codcli",""));
      } else {
        if (source.IsForwarded()) {
          w_codcli = source.GetCaller().GetString("codcli","C",10,0);
          m_bpassedw_codcli = true;
        } else {
          w_codcli = source.GetParameter("codcli",source.GetParameter("w_codcli",""));
        }
      }
      m_bpassedw_ragben = source.Has("w_ragben");
      if (m_bpassedw_ragben) {
        w_ragben = source.GetParameter("w_ragben",source.GetParameter("ragben",""));
      } else {
        if (source.IsForwarded()) {
          w_ragben = source.GetCaller().GetString("ragben","C",70,0);
          m_bpassedw_ragben = true;
        } else {
          w_ragben = source.GetParameter("ragben",source.GetParameter("w_ragben",""));
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
      m_bpassedw_flgchk = source.Has("w_flgchk");
      if (m_bpassedw_flgchk) {
        w_flgchk = source.GetParameter("w_flgchk",source.GetParameter("flgchk",""));
      } else {
        if (source.IsForwarded()) {
          w_flgchk = source.GetCaller().GetString("flgchk","C",1,0);
          m_bpassedw_flgchk = true;
        } else {
          w_flgchk = source.GetParameter("flgchk",source.GetParameter("w_flgchk",""));
        }
      }
      m_bpassedw_flgdel = source.Has("w_flgdel");
      if (m_bpassedw_flgdel) {
        w_flgdel = source.GetParameter("w_flgdel",source.GetParameter("flgdel",""));
      } else {
        if (source.IsForwarded()) {
          w_flgdel = source.GetCaller().GetString("flgdel","C",1,0);
          m_bpassedw_flgdel = true;
        } else {
          w_flgdel = source.GetParameter("flgdel",source.GetParameter("w_flgdel",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_chkdiana_new";
    l_eg.hasProgressItem = false;
    l_eg.isPublic = false;
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
    return  ! (status.m_bpassedw_flgdel) ||  ! (status.m_bpassedw_flgchk) ||  ! (status.m_bpassedw_flgsto) ||  ! (status.m_bpassedw_ragben) ||  ! (status.m_bpassedw_codcli) ||  ! (status.m_bpassedw_tiprap) ||  ! (status.m_bpassedw_flgrap) ||  ! (status.m_bpassedw_flgrae) ||  ! (status.m_bpassedw_flgint) ||  ! (status.m_bpassedw_flgfrz) ||  ! (status.m_bpassedw_flgope) ||  ! (status.m_bpassedw_codage) ||  ! (status.m_bpassedw_tipoarch) ||  ! (status.m_bpassedw_AData) ||  ! (status.m_bpassedw_DaData) ||  ! (status.m_bpassedw_tipinter) ||  ! (status.m_bpassedw_codinter);
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
    if ( ! (status.m_bpassedw_codinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codinter',"+SPLib.ToJSValue(status.w_codinter,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codinter,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codinter',l_cV);");
    if ( ! (status.m_bpassedw_tipinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipinter',"+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipinter,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipinter',l_cV);");
    if ( ! (status.m_bpassedw_DaData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaData',"+SPLib.ToJSValue(status.w_DaData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaData',l_cV);");
    if ( ! (status.m_bpassedw_AData)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_AData',"+SPLib.ToJSValue(status.w_AData,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AData,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_AData',l_cV);");
    if ( ! (status.m_bpassedw_tipoarch)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipoarch',"+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipoarch,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipoarch',l_cV);");
    if ( ! (status.m_bpassedw_codage)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codage',"+SPLib.ToJSValue(status.w_codage,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codage,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codage',l_cV);");
    if ( ! (status.m_bpassedw_flgope)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgope',"+SPLib.ToJSValue(status.w_flgope,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgope,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgope',l_cV);");
    if ( ! (status.m_bpassedw_flgfrz)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgfrz',"+SPLib.ToJSValue(status.w_flgfrz,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgfrz,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgfrz',l_cV);");
    if ( ! (status.m_bpassedw_flgint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgint',"+SPLib.ToJSValue(status.w_flgint,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgint,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgint',l_cV);");
    if ( ! (status.m_bpassedw_flgrae)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgrae',"+SPLib.ToJSValue(status.w_flgrae,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgrae,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgrae',l_cV);");
    if ( ! (status.m_bpassedw_flgrap)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgrap',"+SPLib.ToJSValue(status.w_flgrap,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgrap,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgrap',l_cV);");
    if ( ! (status.m_bpassedw_tiprap)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tiprap',"+SPLib.ToJSValue(status.w_tiprap,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tiprap,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tiprap',l_cV);");
    if ( ! (status.m_bpassedw_codcli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_codcli',"+SPLib.ToJSValue(status.w_codcli,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_codcli,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_codcli',l_cV);");
    if ( ! (status.m_bpassedw_ragben)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ragben',"+SPLib.ToJSValue(status.w_ragben,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragben,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ragben',l_cV);");
    if ( ! (status.m_bpassedw_flgsto)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgsto',"+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgsto,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgsto',l_cV);");
    if ( ! (status.m_bpassedw_flgchk)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgchk',"+SPLib.ToJSValue(status.w_flgchk,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgchk,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgchk',l_cV);");
    if ( ! (status.m_bpassedw_flgdel)) {
      status.out.println("l_cV=WtA(l_oWnd('w_flgdel',"+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_flgdel,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_flgdel',l_cV);");
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
    arrt_chkdiana_newR Rcalled;
    Rcalled = new arrt_chkdiana_newR(status.context,status);
    if (CPLib.ne(status.m_cAction,"executeAsync")) {
      ExecuteWorkflowStartingScript(status,Rcalled);
      status.forwardedto = Rcalled.Run();
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
    return new arrt_chkdiana_newR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_chkdiana_newR Rcalled) throws IOException {
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
      status.out.println("Function return value:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(CPLib.ToProperties(Rcalled.RunAsync()))+"");
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
          ts = new CPTokenSource(status.context.Translate(Rcalled.m_cLastMsgError),"\n");
          while (ts.HasMoreTokens()) {
            status.out.println("Error message:"+ts.NextToken()+"");
          }
        }
        if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_chkdiana_new"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+status.m_cFaultTrace+"");
          }
        }
        status.out.println("js:w_codinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codinter),"?",0,0)+"");
        status.out.println("js:w_tipinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipinter),"?",0,0)+"");
        status.out.println("js:w_DaData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaData),"?",0,0)+"");
        status.out.println("js:w_AData="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AData),"?",0,0)+"");
        status.out.println("js:w_tipoarch="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipoarch),"?",0,0)+"");
        status.out.println("js:w_codage="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codage),"?",0,0)+"");
        status.out.println("js:w_flgope="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgope),"?",0,0)+"");
        status.out.println("js:w_flgfrz="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgfrz),"?",0,0)+"");
        status.out.println("js:w_flgint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgint),"?",0,0)+"");
        status.out.println("js:w_flgrae="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgrae),"?",0,0)+"");
        status.out.println("js:w_flgrap="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgrap),"?",0,0)+"");
        status.out.println("js:w_tiprap="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tiprap),"?",0,0)+"");
        status.out.println("js:w_codcli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_codcli),"?",0,0)+"");
        status.out.println("js:w_ragben="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ragben),"?",0,0)+"");
        status.out.println("js:w_flgsto="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgsto),"?",0,0)+"");
        status.out.println("js:w_flgchk="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgchk),"?",0,0)+"");
        status.out.println("js:w_flgdel="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_flgdel),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_codinter,null)) {");
        status.out.println("window[f].w_codinter="+SPLib.ToJSValue(status.w_codinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipinter,null)) {");
        status.out.println("window[f].w_tipinter="+SPLib.ToJSValue(status.w_tipinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DaData,null)) {");
        status.out.println(" window[f].w_DaData.setTime(Date.parse("+SPLib.ToJSValue(status.w_DaData,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AData,null)) {");
        status.out.println(" window[f].w_AData.setTime(Date.parse("+SPLib.ToJSValue(status.w_AData,"D",0,0)+"))");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipoarch,null)) {");
        status.out.println("window[f].w_tipoarch="+SPLib.ToJSValue(status.w_tipoarch,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codage,null)) {");
        status.out.println("window[f].w_codage="+SPLib.ToJSValue(status.w_codage,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgope,null)) {");
        status.out.println("window[f].w_flgope="+SPLib.ToJSValue(status.w_flgope,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgfrz,null)) {");
        status.out.println("window[f].w_flgfrz="+SPLib.ToJSValue(status.w_flgfrz,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgint,null)) {");
        status.out.println("window[f].w_flgint="+SPLib.ToJSValue(status.w_flgint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgrae,null)) {");
        status.out.println("window[f].w_flgrae="+SPLib.ToJSValue(status.w_flgrae,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgrap,null)) {");
        status.out.println("window[f].w_flgrap="+SPLib.ToJSValue(status.w_flgrap,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tiprap,null)) {");
        status.out.println("window[f].w_tiprap="+SPLib.ToJSValue(status.w_tiprap,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_codcli,null)) {");
        status.out.println("window[f].w_codcli="+SPLib.ToJSValue(status.w_codcli,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ragben,null)) {");
        status.out.println("window[f].w_ragben="+SPLib.ToJSValue(status.w_ragben,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgsto,null)) {");
        status.out.println("window[f].w_flgsto="+SPLib.ToJSValue(status.w_flgsto,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgchk,null)) {");
        status.out.println("window[f].w_flgchk="+SPLib.ToJSValue(status.w_flgchk,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_flgdel,null)) {");
        status.out.println("window[f].w_flgdel="+SPLib.ToJSValue(status.w_flgdel,"C",0,0)+";");
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
      arrt_chkdiana_newR Rcalled;
      Rcalled = new arrt_chkdiana_newR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_chkdiana_new");
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
