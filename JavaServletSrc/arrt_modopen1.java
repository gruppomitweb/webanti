import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_modopen1 extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3591d403*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ragione;
    public String w_ragione;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_datarett;
    public java.sql.Date w_datarett;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_newdate;
    public java.sql.Date w_newdate;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_newdatec;
    public java.sql.Date w_newdatec;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_newintest;
    public String w_newintest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_olddata;
    public java.sql.Date w_olddata;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_olddatac;
    public java.sql.Date w_olddatac;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldfile;
    public String w_oldfile;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldidbase;
    public String w_oldidbase;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldintest;
    public String w_oldintest;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldprog;
    public String w_oldprog;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldrappo;
    public String w_oldrappo;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_oldnumrig;
    public double w_oldnumrig;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_tipochg;
    public String w_tipochg;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xcap;
    public String w_xcap;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xcfestero;
    public double w_xcfestero;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xcodfisc;
    public String w_xcodfisc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xcognome;
    public String w_xcognome;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdatnasc;
    public java.sql.Date w_xdatnasc;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdesccit;
    public String w_xdesccit;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xdessta;
    public String w_xdessta;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xnascomun;
    public String w_xnascomun;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xnasstato;
    public String w_xnasstato;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xnome;
    public String w_xnome;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xpaese;
    public String w_xpaese;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xprovincia;
    public String w_xprovincia;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xragnew;
    public String w_xragnew;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xragold;
    public String w_xragold;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xsesso;
    public String w_xsesso;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtipinter;
    public String w_xtipinter;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_xtipopers;
    public String w_xtipopers;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_idesito;
    public String w_idesito;
    public String _coint;
    public String _tipage;
    public String _rifana;
    public String _salva;
    public String _aprog;
    public String _cprog;
    public double _all;
    public String cProg;
    public String cIDBase;
    public String gAzienda;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_ragione = source.Has("w_ragione");
      if (m_bpassedw_ragione) {
        w_ragione = source.GetParameter("w_ragione",source.GetParameter("ragione",""));
      } else {
        if (source.IsForwarded()) {
          w_ragione = source.GetCaller().GetString("ragione","C",1,0);
          m_bpassedw_ragione = true;
        } else {
          w_ragione = source.GetParameter("ragione",source.GetParameter("w_ragione",""));
        }
      }
      m_bpassedw_datarett = source.Has("w_datarett");
      if (m_bpassedw_datarett) {
        w_datarett = source.GetParameter("w_datarett",source.GetParameter("datarett",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_datarett = source.GetCaller().GetDate("datarett","D",8,0);
          m_bpassedw_datarett = true;
        } else {
          w_datarett = source.GetParameter("datarett",source.GetParameter("w_datarett",CPLib.NullDate()));
        }
      }
      m_bpassedw_newdate = source.Has("w_newdate");
      if (m_bpassedw_newdate) {
        w_newdate = source.GetParameter("w_newdate",source.GetParameter("newdate",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_newdate = source.GetCaller().GetDate("newdate","D",8,0);
          m_bpassedw_newdate = true;
        } else {
          w_newdate = source.GetParameter("newdate",source.GetParameter("w_newdate",CPLib.NullDate()));
        }
      }
      m_bpassedw_newdatec = source.Has("w_newdatec");
      if (m_bpassedw_newdatec) {
        w_newdatec = source.GetParameter("w_newdatec",source.GetParameter("newdatec",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_newdatec = source.GetCaller().GetDate("newdatec","D",8,0);
          m_bpassedw_newdatec = true;
        } else {
          w_newdatec = source.GetParameter("newdatec",source.GetParameter("w_newdatec",CPLib.NullDate()));
        }
      }
      m_bpassedw_newintest = source.Has("w_newintest");
      if (m_bpassedw_newintest) {
        w_newintest = source.GetParameter("w_newintest",source.GetParameter("newintest",""));
      } else {
        if (source.IsForwarded()) {
          w_newintest = source.GetCaller().GetString("newintest","C",16,0);
          m_bpassedw_newintest = true;
        } else {
          w_newintest = source.GetParameter("newintest",source.GetParameter("w_newintest",""));
        }
      }
      m_bpassedw_olddata = source.Has("w_olddata");
      if (m_bpassedw_olddata) {
        w_olddata = source.GetParameter("w_olddata",source.GetParameter("olddata",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_olddata = source.GetCaller().GetDate("olddata","D",8,0);
          m_bpassedw_olddata = true;
        } else {
          w_olddata = source.GetParameter("olddata",source.GetParameter("w_olddata",CPLib.NullDate()));
        }
      }
      m_bpassedw_olddatac = source.Has("w_olddatac");
      if (m_bpassedw_olddatac) {
        w_olddatac = source.GetParameter("w_olddatac",source.GetParameter("olddatac",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_olddatac = source.GetCaller().GetDate("olddatac","D",8,0);
          m_bpassedw_olddatac = true;
        } else {
          w_olddatac = source.GetParameter("olddatac",source.GetParameter("w_olddatac",CPLib.NullDate()));
        }
      }
      m_bpassedw_oldfile = source.Has("w_oldfile");
      if (m_bpassedw_oldfile) {
        w_oldfile = source.GetParameter("w_oldfile",source.GetParameter("oldfile",""));
      } else {
        if (source.IsForwarded()) {
          w_oldfile = source.GetCaller().GetString("oldfile","C",15,0);
          m_bpassedw_oldfile = true;
        } else {
          w_oldfile = source.GetParameter("oldfile",source.GetParameter("w_oldfile",""));
        }
      }
      m_bpassedw_oldidbase = source.Has("w_oldidbase");
      if (m_bpassedw_oldidbase) {
        w_oldidbase = source.GetParameter("w_oldidbase",source.GetParameter("oldidbase",""));
      } else {
        if (source.IsForwarded()) {
          w_oldidbase = source.GetCaller().GetString("oldidbase","C",10,0);
          m_bpassedw_oldidbase = true;
        } else {
          w_oldidbase = source.GetParameter("oldidbase",source.GetParameter("w_oldidbase",""));
        }
      }
      m_bpassedw_oldintest = source.Has("w_oldintest");
      if (m_bpassedw_oldintest) {
        w_oldintest = source.GetParameter("w_oldintest",source.GetParameter("oldintest",""));
      } else {
        if (source.IsForwarded()) {
          w_oldintest = source.GetCaller().GetString("oldintest","C",16,0);
          m_bpassedw_oldintest = true;
        } else {
          w_oldintest = source.GetParameter("oldintest",source.GetParameter("w_oldintest",""));
        }
      }
      m_bpassedw_oldprog = source.Has("w_oldprog");
      if (m_bpassedw_oldprog) {
        w_oldprog = source.GetParameter("w_oldprog",source.GetParameter("oldprog",""));
      } else {
        if (source.IsForwarded()) {
          w_oldprog = source.GetCaller().GetString("oldprog","C",15,0);
          m_bpassedw_oldprog = true;
        } else {
          w_oldprog = source.GetParameter("oldprog",source.GetParameter("w_oldprog",""));
        }
      }
      m_bpassedw_oldrappo = source.Has("w_oldrappo");
      if (m_bpassedw_oldrappo) {
        w_oldrappo = source.GetParameter("w_oldrappo",source.GetParameter("oldrappo",""));
      } else {
        if (source.IsForwarded()) {
          w_oldrappo = source.GetCaller().GetString("oldrappo","C",25,0);
          m_bpassedw_oldrappo = true;
        } else {
          w_oldrappo = source.GetParameter("oldrappo",source.GetParameter("w_oldrappo",""));
        }
      }
      m_bpassedw_oldnumrig = source.Has("w_oldnumrig");
      if (m_bpassedw_oldnumrig) {
        w_oldnumrig = source.GetParameter("w_oldnumrig",source.GetParameter("oldnumrig",0));
      } else {
        if (source.IsForwarded()) {
          w_oldnumrig = source.GetCaller().GetNumber("oldnumrig","N",10,0);
          m_bpassedw_oldnumrig = true;
        } else {
          w_oldnumrig = source.GetParameter("oldnumrig",source.GetParameter("w_oldnumrig",0));
        }
      }
      m_bpassedw_tipochg = source.Has("w_tipochg");
      if (m_bpassedw_tipochg) {
        w_tipochg = source.GetParameter("w_tipochg",source.GetParameter("tipochg",""));
      } else {
        if (source.IsForwarded()) {
          w_tipochg = source.GetCaller().GetString("tipochg","C",1,0);
          m_bpassedw_tipochg = true;
        } else {
          w_tipochg = source.GetParameter("tipochg",source.GetParameter("w_tipochg",""));
        }
      }
      m_bpassedw_xcap = source.Has("w_xcap");
      if (m_bpassedw_xcap) {
        w_xcap = source.GetParameter("w_xcap",source.GetParameter("xcap",""));
      } else {
        if (source.IsForwarded()) {
          w_xcap = source.GetCaller().GetString("xcap","C",9,0);
          m_bpassedw_xcap = true;
        } else {
          w_xcap = source.GetParameter("xcap",source.GetParameter("w_xcap",""));
        }
      }
      m_bpassedw_xcfestero = source.Has("w_xcfestero");
      if (m_bpassedw_xcfestero) {
        w_xcfestero = source.GetParameter("w_xcfestero",source.GetParameter("xcfestero",0));
      } else {
        if (source.IsForwarded()) {
          w_xcfestero = source.GetCaller().GetNumber("xcfestero","N",1,0);
          m_bpassedw_xcfestero = true;
        } else {
          w_xcfestero = source.GetParameter("xcfestero",source.GetParameter("w_xcfestero",0));
        }
      }
      m_bpassedw_xcodfisc = source.Has("w_xcodfisc");
      if (m_bpassedw_xcodfisc) {
        w_xcodfisc = source.GetParameter("w_xcodfisc",source.GetParameter("xcodfisc",""));
      } else {
        if (source.IsForwarded()) {
          w_xcodfisc = source.GetCaller().GetString("xcodfisc","C",16,0);
          m_bpassedw_xcodfisc = true;
        } else {
          w_xcodfisc = source.GetParameter("xcodfisc",source.GetParameter("w_xcodfisc",""));
        }
      }
      m_bpassedw_xcognome = source.Has("w_xcognome");
      if (m_bpassedw_xcognome) {
        w_xcognome = source.GetParameter("w_xcognome",source.GetParameter("xcognome",""));
      } else {
        if (source.IsForwarded()) {
          w_xcognome = source.GetCaller().GetString("xcognome","C",26,0);
          m_bpassedw_xcognome = true;
        } else {
          w_xcognome = source.GetParameter("xcognome",source.GetParameter("w_xcognome",""));
        }
      }
      m_bpassedw_xdatnasc = source.Has("w_xdatnasc");
      if (m_bpassedw_xdatnasc) {
        w_xdatnasc = source.GetParameter("w_xdatnasc",source.GetParameter("xdatnasc",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_xdatnasc = source.GetCaller().GetDate("xdatnasc","D",8,0);
          m_bpassedw_xdatnasc = true;
        } else {
          w_xdatnasc = source.GetParameter("xdatnasc",source.GetParameter("w_xdatnasc",CPLib.NullDate()));
        }
      }
      m_bpassedw_xdesccit = source.Has("w_xdesccit");
      if (m_bpassedw_xdesccit) {
        w_xdesccit = source.GetParameter("w_xdesccit",source.GetParameter("xdesccit",""));
      } else {
        if (source.IsForwarded()) {
          w_xdesccit = source.GetCaller().GetString("xdesccit","C",40,0);
          m_bpassedw_xdesccit = true;
        } else {
          w_xdesccit = source.GetParameter("xdesccit",source.GetParameter("w_xdesccit",""));
        }
      }
      m_bpassedw_xdessta = source.Has("w_xdessta");
      if (m_bpassedw_xdessta) {
        w_xdessta = source.GetParameter("w_xdessta",source.GetParameter("xdessta",""));
      } else {
        if (source.IsForwarded()) {
          w_xdessta = source.GetCaller().GetString("xdessta","C",40,0);
          m_bpassedw_xdessta = true;
        } else {
          w_xdessta = source.GetParameter("xdessta",source.GetParameter("w_xdessta",""));
        }
      }
      m_bpassedw_xnascomun = source.Has("w_xnascomun");
      if (m_bpassedw_xnascomun) {
        w_xnascomun = source.GetParameter("w_xnascomun",source.GetParameter("xnascomun",""));
      } else {
        if (source.IsForwarded()) {
          w_xnascomun = source.GetCaller().GetString("xnascomun","C",40,0);
          m_bpassedw_xnascomun = true;
        } else {
          w_xnascomun = source.GetParameter("xnascomun",source.GetParameter("w_xnascomun",""));
        }
      }
      m_bpassedw_xnasstato = source.Has("w_xnasstato");
      if (m_bpassedw_xnasstato) {
        w_xnasstato = source.GetParameter("w_xnasstato",source.GetParameter("xnasstato",""));
      } else {
        if (source.IsForwarded()) {
          w_xnasstato = source.GetCaller().GetString("xnasstato","C",40,0);
          m_bpassedw_xnasstato = true;
        } else {
          w_xnasstato = source.GetParameter("xnasstato",source.GetParameter("w_xnasstato",""));
        }
      }
      m_bpassedw_xnome = source.Has("w_xnome");
      if (m_bpassedw_xnome) {
        w_xnome = source.GetParameter("w_xnome",source.GetParameter("xnome",""));
      } else {
        if (source.IsForwarded()) {
          w_xnome = source.GetCaller().GetString("xnome","C",25,0);
          m_bpassedw_xnome = true;
        } else {
          w_xnome = source.GetParameter("xnome",source.GetParameter("w_xnome",""));
        }
      }
      m_bpassedw_xpaese = source.Has("w_xpaese");
      if (m_bpassedw_xpaese) {
        w_xpaese = source.GetParameter("w_xpaese",source.GetParameter("xpaese",""));
      } else {
        if (source.IsForwarded()) {
          w_xpaese = source.GetCaller().GetString("xpaese","C",3,0);
          m_bpassedw_xpaese = true;
        } else {
          w_xpaese = source.GetParameter("xpaese",source.GetParameter("w_xpaese",""));
        }
      }
      m_bpassedw_xprovincia = source.Has("w_xprovincia");
      if (m_bpassedw_xprovincia) {
        w_xprovincia = source.GetParameter("w_xprovincia",source.GetParameter("xprovincia",""));
      } else {
        if (source.IsForwarded()) {
          w_xprovincia = source.GetCaller().GetString("xprovincia","C",2,0);
          m_bpassedw_xprovincia = true;
        } else {
          w_xprovincia = source.GetParameter("xprovincia",source.GetParameter("w_xprovincia",""));
        }
      }
      m_bpassedw_xragnew = source.Has("w_xragnew");
      if (m_bpassedw_xragnew) {
        w_xragnew = source.GetParameter("w_xragnew",source.GetParameter("xragnew",""));
      } else {
        if (source.IsForwarded()) {
          w_xragnew = source.GetCaller().GetString("xragnew","C",70,0);
          m_bpassedw_xragnew = true;
        } else {
          w_xragnew = source.GetParameter("xragnew",source.GetParameter("w_xragnew",""));
        }
      }
      m_bpassedw_xragold = source.Has("w_xragold");
      if (m_bpassedw_xragold) {
        w_xragold = source.GetParameter("w_xragold",source.GetParameter("xragold",""));
      } else {
        if (source.IsForwarded()) {
          w_xragold = source.GetCaller().GetString("xragold","C",70,0);
          m_bpassedw_xragold = true;
        } else {
          w_xragold = source.GetParameter("xragold",source.GetParameter("w_xragold",""));
        }
      }
      m_bpassedw_xsesso = source.Has("w_xsesso");
      if (m_bpassedw_xsesso) {
        w_xsesso = source.GetParameter("w_xsesso",source.GetParameter("xsesso",""));
      } else {
        if (source.IsForwarded()) {
          w_xsesso = source.GetCaller().GetString("xsesso","C",1,0);
          m_bpassedw_xsesso = true;
        } else {
          w_xsesso = source.GetParameter("xsesso",source.GetParameter("w_xsesso",""));
        }
      }
      m_bpassedw_xtipinter = source.Has("w_xtipinter");
      if (m_bpassedw_xtipinter) {
        w_xtipinter = source.GetParameter("w_xtipinter",source.GetParameter("xtipinter",""));
      } else {
        if (source.IsForwarded()) {
          w_xtipinter = source.GetCaller().GetString("xtipinter","C",2,0);
          m_bpassedw_xtipinter = true;
        } else {
          w_xtipinter = source.GetParameter("xtipinter",source.GetParameter("w_xtipinter",""));
        }
      }
      m_bpassedw_xtipopers = source.Has("w_xtipopers");
      if (m_bpassedw_xtipopers) {
        w_xtipopers = source.GetParameter("w_xtipopers",source.GetParameter("xtipopers",""));
      } else {
        if (source.IsForwarded()) {
          w_xtipopers = source.GetCaller().GetString("xtipopers","C",1,0);
          m_bpassedw_xtipopers = true;
        } else {
          w_xtipopers = source.GetParameter("xtipopers",source.GetParameter("w_xtipopers",""));
        }
      }
      m_bpassedw_idesito = source.Has("w_idesito");
      if (m_bpassedw_idesito) {
        w_idesito = source.GetParameter("w_idesito",source.GetParameter("idesito",""));
      } else {
        if (source.IsForwarded()) {
          w_idesito = source.GetCaller().GetString("idesito","C",8,0);
          m_bpassedw_idesito = true;
        } else {
          w_idesito = source.GetParameter("idesito",source.GetParameter("w_idesito",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_modopen1";
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
    return  ! (status.m_bpassedw_idesito) ||  ! (status.m_bpassedw_xtipopers) ||  ! (status.m_bpassedw_xtipinter) ||  ! (status.m_bpassedw_xsesso) ||  ! (status.m_bpassedw_xragold) ||  ! (status.m_bpassedw_xragnew) ||  ! (status.m_bpassedw_xprovincia) ||  ! (status.m_bpassedw_xpaese) ||  ! (status.m_bpassedw_xnome) ||  ! (status.m_bpassedw_xnasstato) ||  ! (status.m_bpassedw_xnascomun) ||  ! (status.m_bpassedw_xdessta) ||  ! (status.m_bpassedw_xdesccit) ||  ! (status.m_bpassedw_xdatnasc) ||  ! (status.m_bpassedw_xcognome) ||  ! (status.m_bpassedw_xcodfisc) ||  ! (status.m_bpassedw_xcfestero) ||  ! (status.m_bpassedw_xcap) ||  ! (status.m_bpassedw_tipochg) ||  ! (status.m_bpassedw_oldnumrig) ||  ! (status.m_bpassedw_oldrappo) ||  ! (status.m_bpassedw_oldprog) ||  ! (status.m_bpassedw_oldintest) ||  ! (status.m_bpassedw_oldidbase) ||  ! (status.m_bpassedw_oldfile) ||  ! (status.m_bpassedw_olddatac) ||  ! (status.m_bpassedw_olddata) ||  ! (status.m_bpassedw_newintest) ||  ! (status.m_bpassedw_newdatec) ||  ! (status.m_bpassedw_newdate) ||  ! (status.m_bpassedw_datarett) ||  ! (status.m_bpassedw_ragione);
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
    if ( ! (status.m_bpassedw_ragione)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ragione',"+SPLib.ToJSValue(status.w_ragione,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ragione,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ragione',l_cV);");
    if ( ! (status.m_bpassedw_datarett)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_datarett',"+SPLib.ToJSValue(status.w_datarett,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_datarett,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_datarett',l_cV);");
    if ( ! (status.m_bpassedw_newdate)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_newdate',"+SPLib.ToJSValue(status.w_newdate,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_newdate,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_newdate',l_cV);");
    if ( ! (status.m_bpassedw_newdatec)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_newdatec',"+SPLib.ToJSValue(status.w_newdatec,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_newdatec,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_newdatec',l_cV);");
    if ( ! (status.m_bpassedw_newintest)) {
      status.out.println("l_cV=WtA(l_oWnd('w_newintest',"+SPLib.ToJSValue(status.w_newintest,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_newintest,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_newintest',l_cV);");
    if ( ! (status.m_bpassedw_olddata)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_olddata',"+SPLib.ToJSValue(status.w_olddata,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_olddata,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_olddata',l_cV);");
    if ( ! (status.m_bpassedw_olddatac)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_olddatac',"+SPLib.ToJSValue(status.w_olddatac,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_olddatac,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_olddatac',l_cV);");
    if ( ! (status.m_bpassedw_oldfile)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldfile',"+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldfile,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldfile',l_cV);");
    if ( ! (status.m_bpassedw_oldidbase)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldidbase',"+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldidbase,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldidbase',l_cV);");
    if ( ! (status.m_bpassedw_oldintest)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldintest',"+SPLib.ToJSValue(status.w_oldintest,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldintest,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldintest',l_cV);");
    if ( ! (status.m_bpassedw_oldprog)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldprog',"+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldprog,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldprog',l_cV);");
    if ( ! (status.m_bpassedw_oldrappo)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldrappo',"+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldrappo,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_oldrappo',l_cV);");
    if ( ! (status.m_bpassedw_oldnumrig)) {
      status.out.println("l_cV=WtA(l_oWnd('w_oldnumrig',"+SPLib.ToJSValue(status.w_oldnumrig,"N",10,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_oldnumrig,"N",10,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_oldnumrig',l_cV);");
    if ( ! (status.m_bpassedw_tipochg)) {
      status.out.println("l_cV=WtA(l_oWnd('w_tipochg',"+SPLib.ToJSValue(status.w_tipochg,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_tipochg,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_tipochg',l_cV);");
    if ( ! (status.m_bpassedw_xcap)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xcap',"+SPLib.ToJSValue(status.w_xcap,"C",9,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xcap,"C",9,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xcap',l_cV);");
    if ( ! (status.m_bpassedw_xcfestero)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xcfestero',"+SPLib.ToJSValue(status.w_xcfestero,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xcfestero,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_xcfestero',l_cV);");
    if ( ! (status.m_bpassedw_xcodfisc)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xcodfisc',"+SPLib.ToJSValue(status.w_xcodfisc,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xcodfisc,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xcodfisc',l_cV);");
    if ( ! (status.m_bpassedw_xcognome)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xcognome',"+SPLib.ToJSValue(status.w_xcognome,"C",26,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xcognome,"C",26,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xcognome',l_cV);");
    if ( ! (status.m_bpassedw_xdatnasc)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_xdatnasc',"+SPLib.ToJSValue(status.w_xdatnasc,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdatnasc,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_xdatnasc',l_cV);");
    if ( ! (status.m_bpassedw_xdesccit)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdesccit',"+SPLib.ToJSValue(status.w_xdesccit,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdesccit,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdesccit',l_cV);");
    if ( ! (status.m_bpassedw_xdessta)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xdessta',"+SPLib.ToJSValue(status.w_xdessta,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xdessta,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xdessta',l_cV);");
    if ( ! (status.m_bpassedw_xnascomun)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xnascomun',"+SPLib.ToJSValue(status.w_xnascomun,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xnascomun,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xnascomun',l_cV);");
    if ( ! (status.m_bpassedw_xnasstato)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xnasstato',"+SPLib.ToJSValue(status.w_xnasstato,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xnasstato,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xnasstato',l_cV);");
    if ( ! (status.m_bpassedw_xnome)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xnome',"+SPLib.ToJSValue(status.w_xnome,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xnome,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xnome',l_cV);");
    if ( ! (status.m_bpassedw_xpaese)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xpaese',"+SPLib.ToJSValue(status.w_xpaese,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xpaese,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xpaese',l_cV);");
    if ( ! (status.m_bpassedw_xprovincia)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xprovincia',"+SPLib.ToJSValue(status.w_xprovincia,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xprovincia,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xprovincia',l_cV);");
    if ( ! (status.m_bpassedw_xragnew)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xragnew',"+SPLib.ToJSValue(status.w_xragnew,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xragnew,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xragnew',l_cV);");
    if ( ! (status.m_bpassedw_xragold)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xragold',"+SPLib.ToJSValue(status.w_xragold,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xragold,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xragold',l_cV);");
    if ( ! (status.m_bpassedw_xsesso)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xsesso',"+SPLib.ToJSValue(status.w_xsesso,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xsesso,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xsesso',l_cV);");
    if ( ! (status.m_bpassedw_xtipinter)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtipinter',"+SPLib.ToJSValue(status.w_xtipinter,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtipinter,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtipinter',l_cV);");
    if ( ! (status.m_bpassedw_xtipopers)) {
      status.out.println("l_cV=WtA(l_oWnd('w_xtipopers',"+SPLib.ToJSValue(status.w_xtipopers,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_xtipopers,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_xtipopers',l_cV);");
    if ( ! (status.m_bpassedw_idesito)) {
      status.out.println("l_cV=WtA(l_oWnd('w_idesito',"+SPLib.ToJSValue(status.w_idesito,"C",8,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_idesito,"C",8,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_idesito',l_cV);");
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
    arrt_modopen1R Rcalled;
    Rcalled = new arrt_modopen1R(status.context,status);
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
    return new arrt_modopen1R(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_modopen1R Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_modopen1"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_ragione="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ragione),"?",0,0)+"");
        status.out.println("js:w_datarett="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_datarett),"?",0,0)+"");
        status.out.println("js:w_newdate="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_newdate),"?",0,0)+"");
        status.out.println("js:w_newdatec="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_newdatec),"?",0,0)+"");
        status.out.println("js:w_newintest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_newintest),"?",0,0)+"");
        status.out.println("js:w_olddata="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_olddata),"?",0,0)+"");
        status.out.println("js:w_olddatac="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_olddatac),"?",0,0)+"");
        status.out.println("js:w_oldfile="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldfile),"?",0,0)+"");
        status.out.println("js:w_oldidbase="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldidbase),"?",0,0)+"");
        status.out.println("js:w_oldintest="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldintest),"?",0,0)+"");
        status.out.println("js:w_oldprog="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldprog),"?",0,0)+"");
        status.out.println("js:w_oldrappo="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldrappo),"?",0,0)+"");
        status.out.println("js:w_oldnumrig="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_oldnumrig),"?",0,0)+"");
        status.out.println("js:w_tipochg="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_tipochg),"?",0,0)+"");
        status.out.println("js:w_xcap="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xcap),"?",0,0)+"");
        status.out.println("js:w_xcfestero="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xcfestero),"?",0,0)+"");
        status.out.println("js:w_xcodfisc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xcodfisc),"?",0,0)+"");
        status.out.println("js:w_xcognome="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xcognome),"?",0,0)+"");
        status.out.println("js:w_xdatnasc="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdatnasc),"?",0,0)+"");
        status.out.println("js:w_xdesccit="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdesccit),"?",0,0)+"");
        status.out.println("js:w_xdessta="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xdessta),"?",0,0)+"");
        status.out.println("js:w_xnascomun="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xnascomun),"?",0,0)+"");
        status.out.println("js:w_xnasstato="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xnasstato),"?",0,0)+"");
        status.out.println("js:w_xnome="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xnome),"?",0,0)+"");
        status.out.println("js:w_xpaese="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xpaese),"?",0,0)+"");
        status.out.println("js:w_xprovincia="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xprovincia),"?",0,0)+"");
        status.out.println("js:w_xragnew="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xragnew),"?",0,0)+"");
        status.out.println("js:w_xragold="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xragold),"?",0,0)+"");
        status.out.println("js:w_xsesso="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xsesso),"?",0,0)+"");
        status.out.println("js:w_xtipinter="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtipinter),"?",0,0)+"");
        status.out.println("js:w_xtipopers="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_xtipopers),"?",0,0)+"");
        status.out.println("js:w_idesito="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_idesito),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_ragione,null)) {");
        status.out.println("window[f].w_ragione="+SPLib.ToJSValue(status.w_ragione,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_datarett,null)) {");
        status.out.println(" window[f].w_datarett.setTime(("+SPLib.ToJSValue(status.w_datarett,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_newdate,null)) {");
        status.out.println(" window[f].w_newdate.setTime(("+SPLib.ToJSValue(status.w_newdate,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_newdatec,null)) {");
        status.out.println(" window[f].w_newdatec.setTime(("+SPLib.ToJSValue(status.w_newdatec,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_newintest,null)) {");
        status.out.println("window[f].w_newintest="+SPLib.ToJSValue(status.w_newintest,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_olddata,null)) {");
        status.out.println(" window[f].w_olddata.setTime(("+SPLib.ToJSValue(status.w_olddata,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_olddatac,null)) {");
        status.out.println(" window[f].w_olddatac.setTime(("+SPLib.ToJSValue(status.w_olddatac,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldfile,null)) {");
        status.out.println("window[f].w_oldfile="+SPLib.ToJSValue(status.w_oldfile,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldidbase,null)) {");
        status.out.println("window[f].w_oldidbase="+SPLib.ToJSValue(status.w_oldidbase,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldintest,null)) {");
        status.out.println("window[f].w_oldintest="+SPLib.ToJSValue(status.w_oldintest,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldprog,null)) {");
        status.out.println("window[f].w_oldprog="+SPLib.ToJSValue(status.w_oldprog,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldrappo,null)) {");
        status.out.println("window[f].w_oldrappo="+SPLib.ToJSValue(status.w_oldrappo,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_oldnumrig,null)) {");
        status.out.println("window[f].w_oldnumrig="+SPLib.ToJSValue(status.w_oldnumrig,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_tipochg,null)) {");
        status.out.println("window[f].w_tipochg="+SPLib.ToJSValue(status.w_tipochg,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xcap,null)) {");
        status.out.println("window[f].w_xcap="+SPLib.ToJSValue(status.w_xcap,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xcfestero,null)) {");
        status.out.println("window[f].w_xcfestero="+SPLib.ToJSValue(status.w_xcfestero,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xcodfisc,null)) {");
        status.out.println("window[f].w_xcodfisc="+SPLib.ToJSValue(status.w_xcodfisc,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xcognome,null)) {");
        status.out.println("window[f].w_xcognome="+SPLib.ToJSValue(status.w_xcognome,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdatnasc,null)) {");
        status.out.println(" window[f].w_xdatnasc.setTime(("+SPLib.ToJSValue(status.w_xdatnasc,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdesccit,null)) {");
        status.out.println("window[f].w_xdesccit="+SPLib.ToJSValue(status.w_xdesccit,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xdessta,null)) {");
        status.out.println("window[f].w_xdessta="+SPLib.ToJSValue(status.w_xdessta,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xnascomun,null)) {");
        status.out.println("window[f].w_xnascomun="+SPLib.ToJSValue(status.w_xnascomun,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xnasstato,null)) {");
        status.out.println("window[f].w_xnasstato="+SPLib.ToJSValue(status.w_xnasstato,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xnome,null)) {");
        status.out.println("window[f].w_xnome="+SPLib.ToJSValue(status.w_xnome,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xpaese,null)) {");
        status.out.println("window[f].w_xpaese="+SPLib.ToJSValue(status.w_xpaese,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xprovincia,null)) {");
        status.out.println("window[f].w_xprovincia="+SPLib.ToJSValue(status.w_xprovincia,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xragnew,null)) {");
        status.out.println("window[f].w_xragnew="+SPLib.ToJSValue(status.w_xragnew,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xragold,null)) {");
        status.out.println("window[f].w_xragold="+SPLib.ToJSValue(status.w_xragold,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xsesso,null)) {");
        status.out.println("window[f].w_xsesso="+SPLib.ToJSValue(status.w_xsesso,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtipinter,null)) {");
        status.out.println("window[f].w_xtipinter="+SPLib.ToJSValue(status.w_xtipinter,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_xtipopers,null)) {");
        status.out.println("window[f].w_xtipopers="+SPLib.ToJSValue(status.w_xtipopers,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_idesito,null)) {");
        status.out.println("window[f].w_idesito="+SPLib.ToJSValue(status.w_idesito,"C",0,0)+";");
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
      arrt_modopen1R Rcalled;
      Rcalled = new arrt_modopen1R(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_modopen1");
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
