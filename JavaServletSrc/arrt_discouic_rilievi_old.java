import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_discouic_rilievi_old extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*c36ff2ef*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DaDatOpe;
    public java.sql.Date w_DaDatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ADatOpe;
    public java.sql.Date w_ADatOpe;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcoddip;
    public String w_rcoddip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rabicab;
    public String w_rabicab;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcabdip;
    public String w_rcabdip;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rpaecli;
    public String w_rpaecli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcabcli;
    public String w_rcabcli;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcodvoc;
    public String w_rcodvoc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rflglire;
    public String w_rflglire;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rsegno;
    public String w_rsegno;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rsetsin;
    public String w_rsetsin;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rpaecon;
    public String w_rpaecon;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcabcon;
    public String w_rcabcon;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rpaeint;
    public String w_rpaeint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_rcabint;
    public String w_rcabint;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TipoOper;
    public String w_TipoOper;
    public String gPathApp;
    public String gTipInter;
    public String gIntemediario;
    public String gAzienda;
    public String gDescAzi;
    public String gMsgImp;
    public String _tipcentro;
    public String _sottotipo;
    public String _codcentro;
    public String _settsint;
    public double _appconta;
    public double _totconta;
    public double _conta;
    public double _contaw;
    public double _contaop;
    public String _coddip;
    public String _abicab;
    public String _cabdip;
    public String _dipbase;
    public String _dipcab;
    public String _dipabicab;
    public String _paesecli;
    public String _cabcli;
    public String _paesecp;
    public String _cabcp;
    public String _paeseicp;
    public String _cabicp;
    public double _operaz;
    public double _ocont;
    public String _testo;
    public String _txtappo;
    public String _file;
    public String cdadata;
    public String c_adata;
    public java.sql.Date w_dadata;
    public java.sql.Date w_adata;
    public String _mesi;
    public String _mese;
    public String cNomeFile;
    public String cOnlyNomeFile;
    public String cNomeFileZip;
    public String cProg;
    public String fhand;
    public double _nita;
    public double _next;
    public double _nalt;
    public String _datafine;
    public String _txttot;
    public double _tope;
    public double _tcon;
    public String _dataprod;
    public String _oraprod;
    public String _cDataOra;
    public double _totimp;
    public double _totcon;
    public double _max;
    public double _min;
    public double _tot;
    public double _mono;
    public double _cicli;
    public double _contacilci;
    public double _bottom;
    public double _top;
    public String _cabint;
    public String _ita1;
    public String _ita2;
    public String _ext1;
    public String _ext2;
    public String _alt1;
    public String _alt2;
    public double _find;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_DaDatOpe = source.Has("w_DaDatOpe");
      if (m_bpassedw_DaDatOpe) {
        w_DaDatOpe = source.GetParameter("w_DaDatOpe",source.GetParameter("DaDatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DaDatOpe = source.GetCaller().GetDate("DaDatOpe","D",8,0);
          m_bpassedw_DaDatOpe = true;
        } else {
          w_DaDatOpe = source.GetParameter("DaDatOpe",source.GetParameter("w_DaDatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_ADatOpe = source.Has("w_ADatOpe");
      if (m_bpassedw_ADatOpe) {
        w_ADatOpe = source.GetParameter("w_ADatOpe",source.GetParameter("ADatOpe",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_ADatOpe = source.GetCaller().GetDate("ADatOpe","D",8,0);
          m_bpassedw_ADatOpe = true;
        } else {
          w_ADatOpe = source.GetParameter("ADatOpe",source.GetParameter("w_ADatOpe",CPLib.NullDate()));
        }
      }
      m_bpassedw_rcoddip = source.Has("w_rcoddip");
      if (m_bpassedw_rcoddip) {
        w_rcoddip = source.GetParameter("w_rcoddip",source.GetParameter("rcoddip",""));
      } else {
        if (source.IsForwarded()) {
          w_rcoddip = source.GetCaller().GetString("rcoddip","C",6,0);
          m_bpassedw_rcoddip = true;
        } else {
          w_rcoddip = source.GetParameter("rcoddip",source.GetParameter("w_rcoddip",""));
        }
      }
      m_bpassedw_rabicab = source.Has("w_rabicab");
      if (m_bpassedw_rabicab) {
        w_rabicab = source.GetParameter("w_rabicab",source.GetParameter("rabicab",""));
      } else {
        if (source.IsForwarded()) {
          w_rabicab = source.GetCaller().GetString("rabicab","C",10,0);
          m_bpassedw_rabicab = true;
        } else {
          w_rabicab = source.GetParameter("rabicab",source.GetParameter("w_rabicab",""));
        }
      }
      m_bpassedw_rcabdip = source.Has("w_rcabdip");
      if (m_bpassedw_rcabdip) {
        w_rcabdip = source.GetParameter("w_rcabdip",source.GetParameter("rcabdip",""));
      } else {
        if (source.IsForwarded()) {
          w_rcabdip = source.GetCaller().GetString("rcabdip","C",6,0);
          m_bpassedw_rcabdip = true;
        } else {
          w_rcabdip = source.GetParameter("rcabdip",source.GetParameter("w_rcabdip",""));
        }
      }
      m_bpassedw_rpaecli = source.Has("w_rpaecli");
      if (m_bpassedw_rpaecli) {
        w_rpaecli = source.GetParameter("w_rpaecli",source.GetParameter("rpaecli",""));
      } else {
        if (source.IsForwarded()) {
          w_rpaecli = source.GetCaller().GetString("rpaecli","C",3,0);
          m_bpassedw_rpaecli = true;
        } else {
          w_rpaecli = source.GetParameter("rpaecli",source.GetParameter("w_rpaecli",""));
        }
      }
      m_bpassedw_rcabcli = source.Has("w_rcabcli");
      if (m_bpassedw_rcabcli) {
        w_rcabcli = source.GetParameter("w_rcabcli",source.GetParameter("rcabcli",""));
      } else {
        if (source.IsForwarded()) {
          w_rcabcli = source.GetCaller().GetString("rcabcli","C",6,0);
          m_bpassedw_rcabcli = true;
        } else {
          w_rcabcli = source.GetParameter("rcabcli",source.GetParameter("w_rcabcli",""));
        }
      }
      m_bpassedw_rcodvoc = source.Has("w_rcodvoc");
      if (m_bpassedw_rcodvoc) {
        w_rcodvoc = source.GetParameter("w_rcodvoc",source.GetParameter("rcodvoc",""));
      } else {
        if (source.IsForwarded()) {
          w_rcodvoc = source.GetCaller().GetString("rcodvoc","C",2,0);
          m_bpassedw_rcodvoc = true;
        } else {
          w_rcodvoc = source.GetParameter("rcodvoc",source.GetParameter("w_rcodvoc",""));
        }
      }
      m_bpassedw_rflglire = source.Has("w_rflglire");
      if (m_bpassedw_rflglire) {
        w_rflglire = source.GetParameter("w_rflglire",source.GetParameter("rflglire",""));
      } else {
        if (source.IsForwarded()) {
          w_rflglire = source.GetCaller().GetString("rflglire","C",1,0);
          m_bpassedw_rflglire = true;
        } else {
          w_rflglire = source.GetParameter("rflglire",source.GetParameter("w_rflglire",""));
        }
      }
      m_bpassedw_rsegno = source.Has("w_rsegno");
      if (m_bpassedw_rsegno) {
        w_rsegno = source.GetParameter("w_rsegno",source.GetParameter("rsegno",""));
      } else {
        if (source.IsForwarded()) {
          w_rsegno = source.GetCaller().GetString("rsegno","C",1,0);
          m_bpassedw_rsegno = true;
        } else {
          w_rsegno = source.GetParameter("rsegno",source.GetParameter("w_rsegno",""));
        }
      }
      m_bpassedw_rsetsin = source.Has("w_rsetsin");
      if (m_bpassedw_rsetsin) {
        w_rsetsin = source.GetParameter("w_rsetsin",source.GetParameter("rsetsin",""));
      } else {
        if (source.IsForwarded()) {
          w_rsetsin = source.GetCaller().GetString("rsetsin","C",3,0);
          m_bpassedw_rsetsin = true;
        } else {
          w_rsetsin = source.GetParameter("rsetsin",source.GetParameter("w_rsetsin",""));
        }
      }
      m_bpassedw_rpaecon = source.Has("w_rpaecon");
      if (m_bpassedw_rpaecon) {
        w_rpaecon = source.GetParameter("w_rpaecon",source.GetParameter("rpaecon",""));
      } else {
        if (source.IsForwarded()) {
          w_rpaecon = source.GetCaller().GetString("rpaecon","C",3,0);
          m_bpassedw_rpaecon = true;
        } else {
          w_rpaecon = source.GetParameter("rpaecon",source.GetParameter("w_rpaecon",""));
        }
      }
      m_bpassedw_rcabcon = source.Has("w_rcabcon");
      if (m_bpassedw_rcabcon) {
        w_rcabcon = source.GetParameter("w_rcabcon",source.GetParameter("rcabcon",""));
      } else {
        if (source.IsForwarded()) {
          w_rcabcon = source.GetCaller().GetString("rcabcon","C",6,0);
          m_bpassedw_rcabcon = true;
        } else {
          w_rcabcon = source.GetParameter("rcabcon",source.GetParameter("w_rcabcon",""));
        }
      }
      m_bpassedw_rpaeint = source.Has("w_rpaeint");
      if (m_bpassedw_rpaeint) {
        w_rpaeint = source.GetParameter("w_rpaeint",source.GetParameter("rpaeint",""));
      } else {
        if (source.IsForwarded()) {
          w_rpaeint = source.GetCaller().GetString("rpaeint","C",3,0);
          m_bpassedw_rpaeint = true;
        } else {
          w_rpaeint = source.GetParameter("rpaeint",source.GetParameter("w_rpaeint",""));
        }
      }
      m_bpassedw_rcabint = source.Has("w_rcabint");
      if (m_bpassedw_rcabint) {
        w_rcabint = source.GetParameter("w_rcabint",source.GetParameter("rcabint",""));
      } else {
        if (source.IsForwarded()) {
          w_rcabint = source.GetCaller().GetString("rcabint","C",6,0);
          m_bpassedw_rcabint = true;
        } else {
          w_rcabint = source.GetParameter("rcabint",source.GetParameter("w_rcabint",""));
        }
      }
      m_bpassedw_TipoOper = source.Has("w_TipoOper");
      if (m_bpassedw_TipoOper) {
        w_TipoOper = source.GetParameter("w_TipoOper",source.GetParameter("TipoOper",""));
      } else {
        if (source.IsForwarded()) {
          w_TipoOper = source.GetCaller().GetString("TipoOper","C",2,0);
          m_bpassedw_TipoOper = true;
        } else {
          w_TipoOper = source.GetParameter("TipoOper",source.GetParameter("w_TipoOper",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_discouic_rilievi_old";
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
    return  ! (status.m_bpassedw_TipoOper) ||  ! (status.m_bpassedw_rcabint) ||  ! (status.m_bpassedw_rpaeint) ||  ! (status.m_bpassedw_rcabcon) ||  ! (status.m_bpassedw_rpaecon) ||  ! (status.m_bpassedw_rsetsin) ||  ! (status.m_bpassedw_rsegno) ||  ! (status.m_bpassedw_rflglire) ||  ! (status.m_bpassedw_rcodvoc) ||  ! (status.m_bpassedw_rcabcli) ||  ! (status.m_bpassedw_rpaecli) ||  ! (status.m_bpassedw_rcabdip) ||  ! (status.m_bpassedw_rabicab) ||  ! (status.m_bpassedw_rcoddip) ||  ! (status.m_bpassedw_ADatOpe) ||  ! (status.m_bpassedw_DaDatOpe);
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
    if ( ! (status.m_bpassedw_DaDatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DaDatOpe',"+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DaDatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DaDatOpe',l_cV);");
    if ( ! (status.m_bpassedw_ADatOpe)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_ADatOpe',"+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ADatOpe,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_ADatOpe',l_cV);");
    if ( ! (status.m_bpassedw_rcoddip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcoddip',"+SPLib.ToJSValue(status.w_rcoddip,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcoddip,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcoddip',l_cV);");
    if ( ! (status.m_bpassedw_rabicab)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rabicab',"+SPLib.ToJSValue(status.w_rabicab,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rabicab,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rabicab',l_cV);");
    if ( ! (status.m_bpassedw_rcabdip)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcabdip',"+SPLib.ToJSValue(status.w_rcabdip,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabdip,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcabdip',l_cV);");
    if ( ! (status.m_bpassedw_rpaecli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rpaecli',"+SPLib.ToJSValue(status.w_rpaecli,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaecli,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rpaecli',l_cV);");
    if ( ! (status.m_bpassedw_rcabcli)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcabcli',"+SPLib.ToJSValue(status.w_rcabcli,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabcli,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcabcli',l_cV);");
    if ( ! (status.m_bpassedw_rcodvoc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcodvoc',"+SPLib.ToJSValue(status.w_rcodvoc,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcodvoc,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcodvoc',l_cV);");
    if ( ! (status.m_bpassedw_rflglire)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rflglire',"+SPLib.ToJSValue(status.w_rflglire,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rflglire,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rflglire',l_cV);");
    if ( ! (status.m_bpassedw_rsegno)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rsegno',"+SPLib.ToJSValue(status.w_rsegno,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rsegno,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rsegno',l_cV);");
    if ( ! (status.m_bpassedw_rsetsin)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rsetsin',"+SPLib.ToJSValue(status.w_rsetsin,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rsetsin,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rsetsin',l_cV);");
    if ( ! (status.m_bpassedw_rpaecon)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rpaecon',"+SPLib.ToJSValue(status.w_rpaecon,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaecon,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rpaecon',l_cV);");
    if ( ! (status.m_bpassedw_rcabcon)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcabcon',"+SPLib.ToJSValue(status.w_rcabcon,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabcon,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcabcon',l_cV);");
    if ( ! (status.m_bpassedw_rpaeint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rpaeint',"+SPLib.ToJSValue(status.w_rpaeint,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rpaeint,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rpaeint',l_cV);");
    if ( ! (status.m_bpassedw_rcabint)) {
      status.out.println("l_cV=WtA(l_oWnd('w_rcabint',"+SPLib.ToJSValue(status.w_rcabint,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_rcabint,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_rcabint',l_cV);");
    if ( ! (status.m_bpassedw_TipoOper)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TipoOper',"+SPLib.ToJSValue(status.w_TipoOper,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TipoOper,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TipoOper',l_cV);");
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
    arrt_discouic_rilievi_oldR Rcalled;
    Rcalled = new arrt_discouic_rilievi_oldR(status.context,status);
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
    return new arrt_discouic_rilievi_oldR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_discouic_rilievi_oldR Rcalled) throws IOException {
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
          ts = new CPTokenSource(status.context.Translate(com.zucchetti.sitepainter.Library.explicativeErrorMessage(Rcalled.m_cLastMsgError)),"\n");
          while (ts.HasMoreTokens()) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(ts.NextToken())+"");
          }
        }
        if ( ! (CPLib.Empty(status.m_cFaultTrace))) {
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_discouic_rilievi_old"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_DaDatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DaDatOpe),"?",0,0)+"");
        status.out.println("js:w_ADatOpe="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ADatOpe),"?",0,0)+"");
        status.out.println("js:w_rcoddip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcoddip),"?",0,0)+"");
        status.out.println("js:w_rabicab="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rabicab),"?",0,0)+"");
        status.out.println("js:w_rcabdip="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcabdip),"?",0,0)+"");
        status.out.println("js:w_rpaecli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rpaecli),"?",0,0)+"");
        status.out.println("js:w_rcabcli="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcabcli),"?",0,0)+"");
        status.out.println("js:w_rcodvoc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcodvoc),"?",0,0)+"");
        status.out.println("js:w_rflglire="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rflglire),"?",0,0)+"");
        status.out.println("js:w_rsegno="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rsegno),"?",0,0)+"");
        status.out.println("js:w_rsetsin="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rsetsin),"?",0,0)+"");
        status.out.println("js:w_rpaecon="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rpaecon),"?",0,0)+"");
        status.out.println("js:w_rcabcon="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcabcon),"?",0,0)+"");
        status.out.println("js:w_rpaeint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rpaeint),"?",0,0)+"");
        status.out.println("js:w_rcabint="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_rcabint),"?",0,0)+"");
        status.out.println("js:w_TipoOper="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TipoOper),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_DaDatOpe,null)) {");
        status.out.println(" window[f].w_DaDatOpe.setTime(("+SPLib.ToJSValue(status.w_DaDatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ADatOpe,null)) {");
        status.out.println(" window[f].w_ADatOpe.setTime(("+SPLib.ToJSValue(status.w_ADatOpe,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcoddip,null)) {");
        status.out.println("window[f].w_rcoddip="+SPLib.ToJSValue(status.w_rcoddip,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rabicab,null)) {");
        status.out.println("window[f].w_rabicab="+SPLib.ToJSValue(status.w_rabicab,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcabdip,null)) {");
        status.out.println("window[f].w_rcabdip="+SPLib.ToJSValue(status.w_rcabdip,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rpaecli,null)) {");
        status.out.println("window[f].w_rpaecli="+SPLib.ToJSValue(status.w_rpaecli,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcabcli,null)) {");
        status.out.println("window[f].w_rcabcli="+SPLib.ToJSValue(status.w_rcabcli,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcodvoc,null)) {");
        status.out.println("window[f].w_rcodvoc="+SPLib.ToJSValue(status.w_rcodvoc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rflglire,null)) {");
        status.out.println("window[f].w_rflglire="+SPLib.ToJSValue(status.w_rflglire,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rsegno,null)) {");
        status.out.println("window[f].w_rsegno="+SPLib.ToJSValue(status.w_rsegno,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rsetsin,null)) {");
        status.out.println("window[f].w_rsetsin="+SPLib.ToJSValue(status.w_rsetsin,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rpaecon,null)) {");
        status.out.println("window[f].w_rpaecon="+SPLib.ToJSValue(status.w_rpaecon,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcabcon,null)) {");
        status.out.println("window[f].w_rcabcon="+SPLib.ToJSValue(status.w_rcabcon,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rpaeint,null)) {");
        status.out.println("window[f].w_rpaeint="+SPLib.ToJSValue(status.w_rpaeint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_rcabint,null)) {");
        status.out.println("window[f].w_rcabint="+SPLib.ToJSValue(status.w_rcabint,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TipoOper,null)) {");
        status.out.println("window[f].w_TipoOper="+SPLib.ToJSValue(status.w_TipoOper,"C",0,0)+";");
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
      arrt_discouic_rilievi_oldR Rcalled;
      Rcalled = new arrt_discouic_rilievi_oldR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_discouic_rilievi_old");
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
