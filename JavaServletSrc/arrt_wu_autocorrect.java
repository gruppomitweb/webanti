import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_wu_autocorrect extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*a1625509*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODPRG;
    public double w_TRXCODPRG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCOGNOM;
    public String w_TRXCOGNOM;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNOME;
    public String w_TRXNOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXLUONAS;
    public String w_TRXLUONAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATNAS;
    public java.sql.Date w_TRXDATNAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXSESSO;
    public String w_TRXSESSO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXTIPDOC;
    public String w_TRXTIPDOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNUMDOC;
    public String w_TRXNUMDOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODFIS;
    public String w_TRXCODFIS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLGDATIOLD;
    public String w_FLGDATIOLD;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGFOR;
    public String w_TRXFLGFOR;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATOPE;
    public java.sql.Date w_TRXDATOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNASSTATO;
    public String w_TRXNASSTATO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNASCOMUN;
    public String w_TRXNASCOMUN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATRIL;
    public java.sql.Date w_TRXDATRIL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_finalized;
    public String w_finalized;
    public String gAzienda;
    public double nProg;
    public String _luonas;
    public String _tipodoc;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_TRXCODPRG = source.Has("w_TRXCODPRG");
      if (m_bpassedw_TRXCODPRG) {
        w_TRXCODPRG = source.GetParameter("w_TRXCODPRG",source.GetParameter("TRXCODPRG",0));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODPRG = source.GetCaller().GetNumber("TRXCODPRG","N",15,0);
          m_bpassedw_TRXCODPRG = true;
        } else {
          w_TRXCODPRG = source.GetParameter("TRXCODPRG",source.GetParameter("w_TRXCODPRG",0));
        }
      }
      m_bpassedw_TRXCOGNOM = source.Has("w_TRXCOGNOM");
      if (m_bpassedw_TRXCOGNOM) {
        w_TRXCOGNOM = source.GetParameter("w_TRXCOGNOM",source.GetParameter("TRXCOGNOM",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCOGNOM = source.GetCaller().GetString("TRXCOGNOM","C",50,0);
          m_bpassedw_TRXCOGNOM = true;
        } else {
          w_TRXCOGNOM = source.GetParameter("TRXCOGNOM",source.GetParameter("w_TRXCOGNOM",""));
        }
      }
      m_bpassedw_TRXNOME = source.Has("w_TRXNOME");
      if (m_bpassedw_TRXNOME) {
        w_TRXNOME = source.GetParameter("w_TRXNOME",source.GetParameter("TRXNOME",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNOME = source.GetCaller().GetString("TRXNOME","C",50,0);
          m_bpassedw_TRXNOME = true;
        } else {
          w_TRXNOME = source.GetParameter("TRXNOME",source.GetParameter("w_TRXNOME",""));
        }
      }
      m_bpassedw_TRXLUONAS = source.Has("w_TRXLUONAS");
      if (m_bpassedw_TRXLUONAS) {
        w_TRXLUONAS = source.GetParameter("w_TRXLUONAS",source.GetParameter("TRXLUONAS",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXLUONAS = source.GetCaller().GetString("TRXLUONAS","C",50,0);
          m_bpassedw_TRXLUONAS = true;
        } else {
          w_TRXLUONAS = source.GetParameter("TRXLUONAS",source.GetParameter("w_TRXLUONAS",""));
        }
      }
      m_bpassedw_TRXDATNAS = source.Has("w_TRXDATNAS");
      if (m_bpassedw_TRXDATNAS) {
        w_TRXDATNAS = source.GetParameter("w_TRXDATNAS",source.GetParameter("TRXDATNAS",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRXDATNAS = source.GetCaller().GetDate("TRXDATNAS","D",8,0);
          m_bpassedw_TRXDATNAS = true;
        } else {
          w_TRXDATNAS = source.GetParameter("TRXDATNAS",source.GetParameter("w_TRXDATNAS",CPLib.NullDate()));
        }
      }
      m_bpassedw_TRXSESSO = source.Has("w_TRXSESSO");
      if (m_bpassedw_TRXSESSO) {
        w_TRXSESSO = source.GetParameter("w_TRXSESSO",source.GetParameter("TRXSESSO",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXSESSO = source.GetCaller().GetString("TRXSESSO","C",1,0);
          m_bpassedw_TRXSESSO = true;
        } else {
          w_TRXSESSO = source.GetParameter("TRXSESSO",source.GetParameter("w_TRXSESSO",""));
        }
      }
      m_bpassedw_TRXTIPDOC = source.Has("w_TRXTIPDOC");
      if (m_bpassedw_TRXTIPDOC) {
        w_TRXTIPDOC = source.GetParameter("w_TRXTIPDOC",source.GetParameter("TRXTIPDOC",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXTIPDOC = source.GetCaller().GetString("TRXTIPDOC","C",2,0);
          m_bpassedw_TRXTIPDOC = true;
        } else {
          w_TRXTIPDOC = source.GetParameter("TRXTIPDOC",source.GetParameter("w_TRXTIPDOC",""));
        }
      }
      m_bpassedw_TRXNUMDOC = source.Has("w_TRXNUMDOC");
      if (m_bpassedw_TRXNUMDOC) {
        w_TRXNUMDOC = source.GetParameter("w_TRXNUMDOC",source.GetParameter("TRXNUMDOC",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNUMDOC = source.GetCaller().GetString("TRXNUMDOC","C",30,0);
          m_bpassedw_TRXNUMDOC = true;
        } else {
          w_TRXNUMDOC = source.GetParameter("TRXNUMDOC",source.GetParameter("w_TRXNUMDOC",""));
        }
      }
      m_bpassedw_TRXCODFIS = source.Has("w_TRXCODFIS");
      if (m_bpassedw_TRXCODFIS) {
        w_TRXCODFIS = source.GetParameter("w_TRXCODFIS",source.GetParameter("TRXCODFIS",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODFIS = source.GetCaller().GetString("TRXCODFIS","C",16,0);
          m_bpassedw_TRXCODFIS = true;
        } else {
          w_TRXCODFIS = source.GetParameter("TRXCODFIS",source.GetParameter("w_TRXCODFIS",""));
        }
      }
      m_bpassedw_FLGDATIOLD = source.Has("w_FLGDATIOLD");
      if (m_bpassedw_FLGDATIOLD) {
        w_FLGDATIOLD = source.GetParameter("w_FLGDATIOLD",source.GetParameter("FLGDATIOLD",""));
      } else {
        if (source.IsForwarded()) {
          w_FLGDATIOLD = source.GetCaller().GetString("FLGDATIOLD","C",1,0);
          m_bpassedw_FLGDATIOLD = true;
        } else {
          w_FLGDATIOLD = source.GetParameter("FLGDATIOLD",source.GetParameter("w_FLGDATIOLD",""));
        }
      }
      m_bpassedw_TRXFLGFOR = source.Has("w_TRXFLGFOR");
      if (m_bpassedw_TRXFLGFOR) {
        w_TRXFLGFOR = source.GetParameter("w_TRXFLGFOR",source.GetParameter("TRXFLGFOR",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXFLGFOR = source.GetCaller().GetString("TRXFLGFOR","C",1,0);
          m_bpassedw_TRXFLGFOR = true;
        } else {
          w_TRXFLGFOR = source.GetParameter("TRXFLGFOR",source.GetParameter("w_TRXFLGFOR",""));
        }
      }
      m_bpassedw_TRXDATOPE = source.Has("w_TRXDATOPE");
      if (m_bpassedw_TRXDATOPE) {
        w_TRXDATOPE = source.GetParameter("w_TRXDATOPE",source.GetParameter("TRXDATOPE",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRXDATOPE = source.GetCaller().GetDate("TRXDATOPE","D",8,0);
          m_bpassedw_TRXDATOPE = true;
        } else {
          w_TRXDATOPE = source.GetParameter("TRXDATOPE",source.GetParameter("w_TRXDATOPE",CPLib.NullDate()));
        }
      }
      m_bpassedw_TRXNASSTATO = source.Has("w_TRXNASSTATO");
      if (m_bpassedw_TRXNASSTATO) {
        w_TRXNASSTATO = source.GetParameter("w_TRXNASSTATO",source.GetParameter("TRXNASSTATO",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNASSTATO = source.GetCaller().GetString("TRXNASSTATO","C",40,0);
          m_bpassedw_TRXNASSTATO = true;
        } else {
          w_TRXNASSTATO = source.GetParameter("TRXNASSTATO",source.GetParameter("w_TRXNASSTATO",""));
        }
      }
      m_bpassedw_TRXNASCOMUN = source.Has("w_TRXNASCOMUN");
      if (m_bpassedw_TRXNASCOMUN) {
        w_TRXNASCOMUN = source.GetParameter("w_TRXNASCOMUN",source.GetParameter("TRXNASCOMUN",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNASCOMUN = source.GetCaller().GetString("TRXNASCOMUN","C",40,0);
          m_bpassedw_TRXNASCOMUN = true;
        } else {
          w_TRXNASCOMUN = source.GetParameter("TRXNASCOMUN",source.GetParameter("w_TRXNASCOMUN",""));
        }
      }
      m_bpassedw_TRXDATRIL = source.Has("w_TRXDATRIL");
      if (m_bpassedw_TRXDATRIL) {
        w_TRXDATRIL = source.GetParameter("w_TRXDATRIL",source.GetParameter("TRXDATRIL",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRXDATRIL = source.GetCaller().GetDate("TRXDATRIL","D",8,0);
          m_bpassedw_TRXDATRIL = true;
        } else {
          w_TRXDATRIL = source.GetParameter("TRXDATRIL",source.GetParameter("w_TRXDATRIL",CPLib.NullDate()));
        }
      }
      m_bpassedw_finalized = source.Has("w_finalized");
      if (m_bpassedw_finalized) {
        w_finalized = source.GetParameter("w_finalized",source.GetParameter("finalized",""));
      } else {
        if (source.IsForwarded()) {
          w_finalized = source.GetCaller().GetString("finalized","C",1,0);
          m_bpassedw_finalized = true;
        } else {
          w_finalized = source.GetParameter("finalized",source.GetParameter("w_finalized",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_wu_autocorrect";
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
    return  ! (status.m_bpassedw_finalized) ||  ! (status.m_bpassedw_TRXDATRIL) ||  ! (status.m_bpassedw_TRXNASCOMUN) ||  ! (status.m_bpassedw_TRXNASSTATO) ||  ! (status.m_bpassedw_TRXDATOPE) ||  ! (status.m_bpassedw_TRXFLGFOR) ||  ! (status.m_bpassedw_FLGDATIOLD) ||  ! (status.m_bpassedw_TRXCODFIS) ||  ! (status.m_bpassedw_TRXNUMDOC) ||  ! (status.m_bpassedw_TRXTIPDOC) ||  ! (status.m_bpassedw_TRXSESSO) ||  ! (status.m_bpassedw_TRXDATNAS) ||  ! (status.m_bpassedw_TRXLUONAS) ||  ! (status.m_bpassedw_TRXNOME) ||  ! (status.m_bpassedw_TRXCOGNOM) ||  ! (status.m_bpassedw_TRXCODPRG);
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
    if ( ! (status.m_bpassedw_TRXCODPRG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODPRG',"+SPLib.ToJSValue(status.w_TRXCODPRG,"N",15,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODPRG,"N",15,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODPRG',l_cV);");
    if ( ! (status.m_bpassedw_TRXCOGNOM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCOGNOM',"+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCOGNOM',l_cV);");
    if ( ! (status.m_bpassedw_TRXNOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNOME',"+SPLib.ToJSValue(status.w_TRXNOME,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNOME,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNOME',l_cV);");
    if ( ! (status.m_bpassedw_TRXLUONAS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXLUONAS',"+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXLUONAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATNAS)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATNAS',"+SPLib.ToJSValue(status.w_TRXDATNAS,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATNAS,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATNAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXSESSO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXSESSO',"+SPLib.ToJSValue(status.w_TRXSESSO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXSESSO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXSESSO',l_cV);");
    if ( ! (status.m_bpassedw_TRXTIPDOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXTIPDOC',"+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXTIPDOC',l_cV);");
    if ( ! (status.m_bpassedw_TRXNUMDOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNUMDOC',"+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNUMDOC',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODFIS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODFIS',"+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODFIS',l_cV);");
    if ( ! (status.m_bpassedw_FLGDATIOLD)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLGDATIOLD',"+SPLib.ToJSValue(status.w_FLGDATIOLD,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLGDATIOLD,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLGDATIOLD',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGFOR)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGFOR',"+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGFOR',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATOPE)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATOPE',"+SPLib.ToJSValue(status.w_TRXDATOPE,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATOPE,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATOPE',l_cV);");
    if ( ! (status.m_bpassedw_TRXNASSTATO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNASSTATO',"+SPLib.ToJSValue(status.w_TRXNASSTATO,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNASSTATO,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNASSTATO',l_cV);");
    if ( ! (status.m_bpassedw_TRXNASCOMUN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNASCOMUN',"+SPLib.ToJSValue(status.w_TRXNASCOMUN,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNASCOMUN,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNASCOMUN',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATRIL)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATRIL',"+SPLib.ToJSValue(status.w_TRXDATRIL,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATRIL,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATRIL',l_cV);");
    if ( ! (status.m_bpassedw_finalized)) {
      status.out.println("l_cV=WtA(l_oWnd('w_finalized',"+SPLib.ToJSValue(status.w_finalized,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_finalized,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_finalized',l_cV);");
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
    arrt_wu_autocorrectR Rcalled;
    Rcalled = new arrt_wu_autocorrectR(status.context,status);
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
    return new arrt_wu_autocorrectR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_wu_autocorrectR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_wu_autocorrect"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_TRXCODPRG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODPRG),"?",0,0)+"");
        status.out.println("js:w_TRXCOGNOM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCOGNOM),"?",0,0)+"");
        status.out.println("js:w_TRXNOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNOME),"?",0,0)+"");
        status.out.println("js:w_TRXLUONAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXLUONAS),"?",0,0)+"");
        status.out.println("js:w_TRXDATNAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATNAS),"?",0,0)+"");
        status.out.println("js:w_TRXSESSO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXSESSO),"?",0,0)+"");
        status.out.println("js:w_TRXTIPDOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXTIPDOC),"?",0,0)+"");
        status.out.println("js:w_TRXNUMDOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNUMDOC),"?",0,0)+"");
        status.out.println("js:w_TRXCODFIS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODFIS),"?",0,0)+"");
        status.out.println("js:w_FLGDATIOLD="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLGDATIOLD),"?",0,0)+"");
        status.out.println("js:w_TRXFLGFOR="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGFOR),"?",0,0)+"");
        status.out.println("js:w_TRXDATOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATOPE),"?",0,0)+"");
        status.out.println("js:w_TRXNASSTATO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNASSTATO),"?",0,0)+"");
        status.out.println("js:w_TRXNASCOMUN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNASCOMUN),"?",0,0)+"");
        status.out.println("js:w_TRXDATRIL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATRIL),"?",0,0)+"");
        status.out.println("js:w_finalized="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_finalized),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_TRXCODPRG,null)) {");
        status.out.println("window[f].w_TRXCODPRG="+SPLib.ToJSValue(status.w_TRXCODPRG,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCOGNOM,null)) {");
        status.out.println("window[f].w_TRXCOGNOM="+SPLib.ToJSValue(status.w_TRXCOGNOM,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNOME,null)) {");
        status.out.println("window[f].w_TRXNOME="+SPLib.ToJSValue(status.w_TRXNOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXLUONAS,null)) {");
        status.out.println("window[f].w_TRXLUONAS="+SPLib.ToJSValue(status.w_TRXLUONAS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATNAS,null)) {");
        status.out.println(" window[f].w_TRXDATNAS.setTime(("+SPLib.ToJSValue(status.w_TRXDATNAS,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXSESSO,null)) {");
        status.out.println("window[f].w_TRXSESSO="+SPLib.ToJSValue(status.w_TRXSESSO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXTIPDOC,null)) {");
        status.out.println("window[f].w_TRXTIPDOC="+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNUMDOC,null)) {");
        status.out.println("window[f].w_TRXNUMDOC="+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODFIS,null)) {");
        status.out.println("window[f].w_TRXCODFIS="+SPLib.ToJSValue(status.w_TRXCODFIS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLGDATIOLD,null)) {");
        status.out.println("window[f].w_FLGDATIOLD="+SPLib.ToJSValue(status.w_FLGDATIOLD,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGFOR,null)) {");
        status.out.println("window[f].w_TRXFLGFOR="+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATOPE,null)) {");
        status.out.println(" window[f].w_TRXDATOPE.setTime(("+SPLib.ToJSValue(status.w_TRXDATOPE,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNASSTATO,null)) {");
        status.out.println("window[f].w_TRXNASSTATO="+SPLib.ToJSValue(status.w_TRXNASSTATO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNASCOMUN,null)) {");
        status.out.println("window[f].w_TRXNASCOMUN="+SPLib.ToJSValue(status.w_TRXNASCOMUN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATRIL,null)) {");
        status.out.println(" window[f].w_TRXDATRIL.setTime(("+SPLib.ToJSValue(status.w_TRXDATRIL,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_finalized,null)) {");
        status.out.println("window[f].w_finalized="+SPLib.ToJSValue(status.w_finalized,"C",0,0)+";");
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
      arrt_wu_autocorrectR Rcalled;
      Rcalled = new arrt_wu_autocorrectR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_wu_autocorrect");
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
