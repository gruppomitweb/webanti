import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_modi_aggfraz extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*f8e3804b*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDBASE;
    public String w_IDBASE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DURAT;
    public String w_DURAT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RFREQ;
    public double w_RFREQ;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AMMONT;
    public String w_AMMONT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RIMP;
    public double w_RIMP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AREAGEO;
    public String w_AREAGEO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAREA;
    public double w_RAREA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MODSVOL;
    public String w_MODSVOL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RCOMP;
    public double w_RCOMP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAGIO;
    public String w_RAGIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RRAGIO;
    public double w_RRAGIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPO;
    public String w_TIPO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RTIPO;
    public double w_RTIPO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NOPROT;
    public double w_NOPROT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_OPERAG;
    public String w_OPERAG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RESPINS;
    public String w_RESPINS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SCOPO;
    public String w_SCOPO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NATURA;
    public String w_NATURA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_INFORM;
    public String w_INFORM;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_IDBASE = source.Has("w_IDBASE");
      if (m_bpassedw_IDBASE) {
        w_IDBASE = source.GetParameter("w_IDBASE",source.GetParameter("IDBASE",""));
      } else {
        if (source.IsForwarded()) {
          w_IDBASE = source.GetCaller().GetString("IDBASE","C",10,0);
          m_bpassedw_IDBASE = true;
        } else {
          w_IDBASE = source.GetParameter("IDBASE",source.GetParameter("w_IDBASE",""));
        }
      }
      m_bpassedw_DURAT = source.Has("w_DURAT");
      if (m_bpassedw_DURAT) {
        w_DURAT = source.GetParameter("w_DURAT",source.GetParameter("DURAT",""));
      } else {
        if (source.IsForwarded()) {
          w_DURAT = source.GetCaller().GetString("DURAT","C",5,0);
          m_bpassedw_DURAT = true;
        } else {
          w_DURAT = source.GetParameter("DURAT",source.GetParameter("w_DURAT",""));
        }
      }
      m_bpassedw_RFREQ = source.Has("w_RFREQ");
      if (m_bpassedw_RFREQ) {
        w_RFREQ = source.GetParameter("w_RFREQ",source.GetParameter("RFREQ",0));
      } else {
        if (source.IsForwarded()) {
          w_RFREQ = source.GetCaller().GetNumber("RFREQ","N",3,0);
          m_bpassedw_RFREQ = true;
        } else {
          w_RFREQ = source.GetParameter("RFREQ",source.GetParameter("w_RFREQ",0));
        }
      }
      m_bpassedw_AMMONT = source.Has("w_AMMONT");
      if (m_bpassedw_AMMONT) {
        w_AMMONT = source.GetParameter("w_AMMONT",source.GetParameter("AMMONT",""));
      } else {
        if (source.IsForwarded()) {
          w_AMMONT = source.GetCaller().GetString("AMMONT","C",5,0);
          m_bpassedw_AMMONT = true;
        } else {
          w_AMMONT = source.GetParameter("AMMONT",source.GetParameter("w_AMMONT",""));
        }
      }
      m_bpassedw_RIMP = source.Has("w_RIMP");
      if (m_bpassedw_RIMP) {
        w_RIMP = source.GetParameter("w_RIMP",source.GetParameter("RIMP",0));
      } else {
        if (source.IsForwarded()) {
          w_RIMP = source.GetCaller().GetNumber("RIMP","N",3,0);
          m_bpassedw_RIMP = true;
        } else {
          w_RIMP = source.GetParameter("RIMP",source.GetParameter("w_RIMP",0));
        }
      }
      m_bpassedw_AREAGEO = source.Has("w_AREAGEO");
      if (m_bpassedw_AREAGEO) {
        w_AREAGEO = source.GetParameter("w_AREAGEO",source.GetParameter("AREAGEO",""));
      } else {
        if (source.IsForwarded()) {
          w_AREAGEO = source.GetCaller().GetString("AREAGEO","C",5,0);
          m_bpassedw_AREAGEO = true;
        } else {
          w_AREAGEO = source.GetParameter("AREAGEO",source.GetParameter("w_AREAGEO",""));
        }
      }
      m_bpassedw_RAREA = source.Has("w_RAREA");
      if (m_bpassedw_RAREA) {
        w_RAREA = source.GetParameter("w_RAREA",source.GetParameter("RAREA",0));
      } else {
        if (source.IsForwarded()) {
          w_RAREA = source.GetCaller().GetNumber("RAREA","N",3,0);
          m_bpassedw_RAREA = true;
        } else {
          w_RAREA = source.GetParameter("RAREA",source.GetParameter("w_RAREA",0));
        }
      }
      m_bpassedw_MODSVOL = source.Has("w_MODSVOL");
      if (m_bpassedw_MODSVOL) {
        w_MODSVOL = source.GetParameter("w_MODSVOL",source.GetParameter("MODSVOL",""));
      } else {
        if (source.IsForwarded()) {
          w_MODSVOL = source.GetCaller().GetString("MODSVOL","C",5,0);
          m_bpassedw_MODSVOL = true;
        } else {
          w_MODSVOL = source.GetParameter("MODSVOL",source.GetParameter("w_MODSVOL",""));
        }
      }
      m_bpassedw_RCOMP = source.Has("w_RCOMP");
      if (m_bpassedw_RCOMP) {
        w_RCOMP = source.GetParameter("w_RCOMP",source.GetParameter("RCOMP",0));
      } else {
        if (source.IsForwarded()) {
          w_RCOMP = source.GetCaller().GetNumber("RCOMP","N",3,0);
          m_bpassedw_RCOMP = true;
        } else {
          w_RCOMP = source.GetParameter("RCOMP",source.GetParameter("w_RCOMP",0));
        }
      }
      m_bpassedw_RAGIO = source.Has("w_RAGIO");
      if (m_bpassedw_RAGIO) {
        w_RAGIO = source.GetParameter("w_RAGIO",source.GetParameter("RAGIO",""));
      } else {
        if (source.IsForwarded()) {
          w_RAGIO = source.GetCaller().GetString("RAGIO","C",5,0);
          m_bpassedw_RAGIO = true;
        } else {
          w_RAGIO = source.GetParameter("RAGIO",source.GetParameter("w_RAGIO",""));
        }
      }
      m_bpassedw_RRAGIO = source.Has("w_RRAGIO");
      if (m_bpassedw_RRAGIO) {
        w_RRAGIO = source.GetParameter("w_RRAGIO",source.GetParameter("RRAGIO",0));
      } else {
        if (source.IsForwarded()) {
          w_RRAGIO = source.GetCaller().GetNumber("RRAGIO","N",3,0);
          m_bpassedw_RRAGIO = true;
        } else {
          w_RRAGIO = source.GetParameter("RRAGIO",source.GetParameter("w_RRAGIO",0));
        }
      }
      m_bpassedw_TIPO = source.Has("w_TIPO");
      if (m_bpassedw_TIPO) {
        w_TIPO = source.GetParameter("w_TIPO",source.GetParameter("TIPO",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPO = source.GetCaller().GetString("TIPO","C",3,0);
          m_bpassedw_TIPO = true;
        } else {
          w_TIPO = source.GetParameter("TIPO",source.GetParameter("w_TIPO",""));
        }
      }
      m_bpassedw_RTIPO = source.Has("w_RTIPO");
      if (m_bpassedw_RTIPO) {
        w_RTIPO = source.GetParameter("w_RTIPO",source.GetParameter("RTIPO",0));
      } else {
        if (source.IsForwarded()) {
          w_RTIPO = source.GetCaller().GetNumber("RTIPO","N",3,0);
          m_bpassedw_RTIPO = true;
        } else {
          w_RTIPO = source.GetParameter("RTIPO",source.GetParameter("w_RTIPO",0));
        }
      }
      m_bpassedw_NOPROT = source.Has("w_NOPROT");
      if (m_bpassedw_NOPROT) {
        w_NOPROT = source.GetParameter("w_NOPROT",source.GetParameter("NOPROT",0));
      } else {
        if (source.IsForwarded()) {
          w_NOPROT = source.GetCaller().GetNumber("NOPROT","N",1,0);
          m_bpassedw_NOPROT = true;
        } else {
          w_NOPROT = source.GetParameter("NOPROT",source.GetParameter("w_NOPROT",0));
        }
      }
      m_bpassedw_OPERAG = source.Has("w_OPERAG");
      if (m_bpassedw_OPERAG) {
        w_OPERAG = source.GetParameter("w_OPERAG",source.GetParameter("OPERAG",""));
      } else {
        if (source.IsForwarded()) {
          w_OPERAG = source.GetCaller().GetString("OPERAG","C",3,0);
          m_bpassedw_OPERAG = true;
        } else {
          w_OPERAG = source.GetParameter("OPERAG",source.GetParameter("w_OPERAG",""));
        }
      }
      m_bpassedw_RESPINS = source.Has("w_RESPINS");
      if (m_bpassedw_RESPINS) {
        w_RESPINS = source.GetParameter("w_RESPINS",source.GetParameter("RESPINS",""));
      } else {
        if (source.IsForwarded()) {
          w_RESPINS = source.GetCaller().GetString("RESPINS","C",30,0);
          m_bpassedw_RESPINS = true;
        } else {
          w_RESPINS = source.GetParameter("RESPINS",source.GetParameter("w_RESPINS",""));
        }
      }
      m_bpassedw_SCOPO = source.Has("w_SCOPO");
      if (m_bpassedw_SCOPO) {
        w_SCOPO = source.GetParameter("w_SCOPO",source.GetParameter("SCOPO",""));
      } else {
        if (source.IsForwarded()) {
          w_SCOPO = source.GetCaller().GetString("SCOPO","C",50,0);
          m_bpassedw_SCOPO = true;
        } else {
          w_SCOPO = source.GetParameter("SCOPO",source.GetParameter("w_SCOPO",""));
        }
      }
      m_bpassedw_NATURA = source.Has("w_NATURA");
      if (m_bpassedw_NATURA) {
        w_NATURA = source.GetParameter("w_NATURA",source.GetParameter("NATURA",""));
      } else {
        if (source.IsForwarded()) {
          w_NATURA = source.GetCaller().GetString("NATURA","C",50,0);
          m_bpassedw_NATURA = true;
        } else {
          w_NATURA = source.GetParameter("NATURA",source.GetParameter("w_NATURA",""));
        }
      }
      m_bpassedw_INFORM = source.Has("w_INFORM");
      if (m_bpassedw_INFORM) {
        w_INFORM = source.GetParameter("w_INFORM",source.GetParameter("INFORM",""));
      } else {
        if (source.IsForwarded()) {
          w_INFORM = source.GetCaller().GetString("INFORM","C",30,0);
          m_bpassedw_INFORM = true;
        } else {
          w_INFORM = source.GetParameter("INFORM",source.GetParameter("w_INFORM",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_modi_aggfraz";
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
    return  ! (status.m_bpassedw_INFORM) ||  ! (status.m_bpassedw_NATURA) ||  ! (status.m_bpassedw_SCOPO) ||  ! (status.m_bpassedw_RESPINS) ||  ! (status.m_bpassedw_OPERAG) ||  ! (status.m_bpassedw_NOPROT) ||  ! (status.m_bpassedw_RTIPO) ||  ! (status.m_bpassedw_TIPO) ||  ! (status.m_bpassedw_RRAGIO) ||  ! (status.m_bpassedw_RAGIO) ||  ! (status.m_bpassedw_RCOMP) ||  ! (status.m_bpassedw_MODSVOL) ||  ! (status.m_bpassedw_RAREA) ||  ! (status.m_bpassedw_AREAGEO) ||  ! (status.m_bpassedw_RIMP) ||  ! (status.m_bpassedw_AMMONT) ||  ! (status.m_bpassedw_RFREQ) ||  ! (status.m_bpassedw_DURAT) ||  ! (status.m_bpassedw_IDBASE);
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
    if ( ! (status.m_bpassedw_IDBASE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDBASE',"+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDBASE',l_cV);");
    if ( ! (status.m_bpassedw_DURAT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DURAT',"+SPLib.ToJSValue(status.w_DURAT,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DURAT,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DURAT',l_cV);");
    if ( ! (status.m_bpassedw_RFREQ)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RFREQ',"+SPLib.ToJSValue(status.w_RFREQ,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RFREQ,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RFREQ',l_cV);");
    if ( ! (status.m_bpassedw_AMMONT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_AMMONT',"+SPLib.ToJSValue(status.w_AMMONT,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AMMONT,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_AMMONT',l_cV);");
    if ( ! (status.m_bpassedw_RIMP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RIMP',"+SPLib.ToJSValue(status.w_RIMP,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RIMP,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RIMP',l_cV);");
    if ( ! (status.m_bpassedw_AREAGEO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_AREAGEO',"+SPLib.ToJSValue(status.w_AREAGEO,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AREAGEO,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_AREAGEO',l_cV);");
    if ( ! (status.m_bpassedw_RAREA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAREA',"+SPLib.ToJSValue(status.w_RAREA,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAREA,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RAREA',l_cV);");
    if ( ! (status.m_bpassedw_MODSVOL)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MODSVOL',"+SPLib.ToJSValue(status.w_MODSVOL,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MODSVOL,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_MODSVOL',l_cV);");
    if ( ! (status.m_bpassedw_RCOMP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RCOMP',"+SPLib.ToJSValue(status.w_RCOMP,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RCOMP,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RCOMP',l_cV);");
    if ( ! (status.m_bpassedw_RAGIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAGIO',"+SPLib.ToJSValue(status.w_RAGIO,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAGIO,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAGIO',l_cV);");
    if ( ! (status.m_bpassedw_RRAGIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RRAGIO',"+SPLib.ToJSValue(status.w_RRAGIO,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RRAGIO,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RRAGIO',l_cV);");
    if ( ! (status.m_bpassedw_TIPO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPO',"+SPLib.ToJSValue(status.w_TIPO,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPO,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPO',l_cV);");
    if ( ! (status.m_bpassedw_RTIPO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RTIPO',"+SPLib.ToJSValue(status.w_RTIPO,"N",3,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RTIPO,"N",3,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_RTIPO',l_cV);");
    if ( ! (status.m_bpassedw_NOPROT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NOPROT',"+SPLib.ToJSValue(status.w_NOPROT,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NOPROT,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_NOPROT',l_cV);");
    if ( ! (status.m_bpassedw_OPERAG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_OPERAG',"+SPLib.ToJSValue(status.w_OPERAG,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_OPERAG,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_OPERAG',l_cV);");
    if ( ! (status.m_bpassedw_RESPINS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RESPINS',"+SPLib.ToJSValue(status.w_RESPINS,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RESPINS,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RESPINS',l_cV);");
    if ( ! (status.m_bpassedw_SCOPO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SCOPO',"+SPLib.ToJSValue(status.w_SCOPO,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SCOPO,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SCOPO',l_cV);");
    if ( ! (status.m_bpassedw_NATURA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NATURA',"+SPLib.ToJSValue(status.w_NATURA,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NATURA,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NATURA',l_cV);");
    if ( ! (status.m_bpassedw_INFORM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_INFORM',"+SPLib.ToJSValue(status.w_INFORM,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_INFORM,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_INFORM',l_cV);");
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
    arrt_modi_aggfrazR Rcalled;
    Rcalled = new arrt_modi_aggfrazR(status.context,status);
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
    return new arrt_modi_aggfrazR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_modi_aggfrazR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_modi_aggfraz"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_IDBASE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDBASE),"?",0,0)+"");
        status.out.println("js:w_DURAT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DURAT),"?",0,0)+"");
        status.out.println("js:w_RFREQ="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RFREQ),"?",0,0)+"");
        status.out.println("js:w_AMMONT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AMMONT),"?",0,0)+"");
        status.out.println("js:w_RIMP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RIMP),"?",0,0)+"");
        status.out.println("js:w_AREAGEO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AREAGEO),"?",0,0)+"");
        status.out.println("js:w_RAREA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAREA),"?",0,0)+"");
        status.out.println("js:w_MODSVOL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MODSVOL),"?",0,0)+"");
        status.out.println("js:w_RCOMP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RCOMP),"?",0,0)+"");
        status.out.println("js:w_RAGIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAGIO),"?",0,0)+"");
        status.out.println("js:w_RRAGIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RRAGIO),"?",0,0)+"");
        status.out.println("js:w_TIPO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPO),"?",0,0)+"");
        status.out.println("js:w_RTIPO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RTIPO),"?",0,0)+"");
        status.out.println("js:w_NOPROT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NOPROT),"?",0,0)+"");
        status.out.println("js:w_OPERAG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_OPERAG),"?",0,0)+"");
        status.out.println("js:w_RESPINS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RESPINS),"?",0,0)+"");
        status.out.println("js:w_SCOPO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SCOPO),"?",0,0)+"");
        status.out.println("js:w_NATURA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NATURA),"?",0,0)+"");
        status.out.println("js:w_INFORM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_INFORM),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_IDBASE,null)) {");
        status.out.println("window[f].w_IDBASE="+SPLib.ToJSValue(status.w_IDBASE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DURAT,null)) {");
        status.out.println("window[f].w_DURAT="+SPLib.ToJSValue(status.w_DURAT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RFREQ,null)) {");
        status.out.println("window[f].w_RFREQ="+SPLib.ToJSValue(status.w_RFREQ,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AMMONT,null)) {");
        status.out.println("window[f].w_AMMONT="+SPLib.ToJSValue(status.w_AMMONT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RIMP,null)) {");
        status.out.println("window[f].w_RIMP="+SPLib.ToJSValue(status.w_RIMP,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AREAGEO,null)) {");
        status.out.println("window[f].w_AREAGEO="+SPLib.ToJSValue(status.w_AREAGEO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAREA,null)) {");
        status.out.println("window[f].w_RAREA="+SPLib.ToJSValue(status.w_RAREA,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MODSVOL,null)) {");
        status.out.println("window[f].w_MODSVOL="+SPLib.ToJSValue(status.w_MODSVOL,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RCOMP,null)) {");
        status.out.println("window[f].w_RCOMP="+SPLib.ToJSValue(status.w_RCOMP,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAGIO,null)) {");
        status.out.println("window[f].w_RAGIO="+SPLib.ToJSValue(status.w_RAGIO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RRAGIO,null)) {");
        status.out.println("window[f].w_RRAGIO="+SPLib.ToJSValue(status.w_RRAGIO,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPO,null)) {");
        status.out.println("window[f].w_TIPO="+SPLib.ToJSValue(status.w_TIPO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RTIPO,null)) {");
        status.out.println("window[f].w_RTIPO="+SPLib.ToJSValue(status.w_RTIPO,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NOPROT,null)) {");
        status.out.println("window[f].w_NOPROT="+SPLib.ToJSValue(status.w_NOPROT,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_OPERAG,null)) {");
        status.out.println("window[f].w_OPERAG="+SPLib.ToJSValue(status.w_OPERAG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RESPINS,null)) {");
        status.out.println("window[f].w_RESPINS="+SPLib.ToJSValue(status.w_RESPINS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SCOPO,null)) {");
        status.out.println("window[f].w_SCOPO="+SPLib.ToJSValue(status.w_SCOPO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NATURA,null)) {");
        status.out.println("window[f].w_NATURA="+SPLib.ToJSValue(status.w_NATURA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_INFORM,null)) {");
        status.out.println("window[f].w_INFORM="+SPLib.ToJSValue(status.w_INFORM,"C",0,0)+";");
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
      arrt_modi_aggfrazR Rcalled;
      Rcalled = new arrt_modi_aggfrazR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_modi_aggfraz");
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
