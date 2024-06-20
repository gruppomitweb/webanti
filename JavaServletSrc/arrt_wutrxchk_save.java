import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_wutrxchk_save extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b4f0e5f3*!";
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
    public boolean m_bpassedw_TRXDOMICI;
    public String w_TRXDOMICI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGCF;
    public String w_TRXFLGCF;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODFIS;
    public String w_TRXCODFIS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXLUONAS;
    public String w_TRXLUONAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNUMDOC;
    public String w_TRXNUMDOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATSCA;
    public java.sql.Date w_TRXDATSCA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATRIL;
    public java.sql.Date w_TRXDATRIL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXAUTRIL;
    public String w_TRXAUTRIL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNAZRES;
    public String w_TRXNAZRES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCITRES;
    public String w_TRXCITRES;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXTIPDOC;
    public String w_TRXTIPDOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATOPE;
    public java.sql.Date w_TRXDATOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGCON;
    public String w_TRXFLGCON;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRSSEGNO;
    public String w_TRSSEGNO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXIMPORTO;
    public double w_TRXIMPORTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCONTAN;
    public double w_TRXCONTAN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXUNIQUE;
    public String w_TRXUNIQUE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODDIP;
    public String w_TRXCODDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCOGCON;
    public String w_TRXCOGCON;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXNOMCON;
    public String w_TRXNOMCON;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDESTIN;
    public String w_TRXDESTIN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXMTCN;
    public String w_TRXMTCN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXDATNAS;
    public java.sql.Date w_TRXDATNAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXSESSO;
    public String w_TRXSESSO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODCAS;
    public String w_TRXCODCAS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXRECTYPE;
    public String w_TRXRECTYPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODMAG;
    public String w_TRXCODMAG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXCODUNI;
    public String w_TRXCODUNI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGFOR;
    public String w_TRXFLGFOR;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXTFINLAV;
    public java.sql.Timestamp w_TRXTFINLAV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRDFINLAV;
    public java.sql.Date w_TRDFINLAV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRFLGINLAV;
    public String w_TRFLGINLAV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXFLGAUA;
    public String w_TRXFLGAUA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TRXESITO;
    public String w_TRXESITO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_finalized;
    public String w_finalized;
    public String _trxcognom;
    public String _trxnome;
    public String _trxluonas;
    public String _trxnumdoc;
    public String _trxtipdoc;
    public java.sql.Date _trxdatnas;
    public String _trxsesso;
    public java.sql.Timestamp _trxtinixlav;
    public java.sql.Date _trxdinixlav;
    public double _trxuser;
    public String gAzienda;
    public String gPathApp;
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
      m_bpassedw_TRXDOMICI = source.Has("w_TRXDOMICI");
      if (m_bpassedw_TRXDOMICI) {
        w_TRXDOMICI = source.GetParameter("w_TRXDOMICI",source.GetParameter("TRXDOMICI",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXDOMICI = source.GetCaller().GetString("TRXDOMICI","C",100,0);
          m_bpassedw_TRXDOMICI = true;
        } else {
          w_TRXDOMICI = source.GetParameter("TRXDOMICI",source.GetParameter("w_TRXDOMICI",""));
        }
      }
      m_bpassedw_TRXFLGCF = source.Has("w_TRXFLGCF");
      if (m_bpassedw_TRXFLGCF) {
        w_TRXFLGCF = source.GetParameter("w_TRXFLGCF",source.GetParameter("TRXFLGCF",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXFLGCF = source.GetCaller().GetString("TRXFLGCF","C",1,0);
          m_bpassedw_TRXFLGCF = true;
        } else {
          w_TRXFLGCF = source.GetParameter("TRXFLGCF",source.GetParameter("w_TRXFLGCF",""));
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
      m_bpassedw_TRXDATSCA = source.Has("w_TRXDATSCA");
      if (m_bpassedw_TRXDATSCA) {
        w_TRXDATSCA = source.GetParameter("w_TRXDATSCA",source.GetParameter("TRXDATSCA",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRXDATSCA = source.GetCaller().GetDate("TRXDATSCA","D",8,0);
          m_bpassedw_TRXDATSCA = true;
        } else {
          w_TRXDATSCA = source.GetParameter("TRXDATSCA",source.GetParameter("w_TRXDATSCA",CPLib.NullDate()));
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
      m_bpassedw_TRXAUTRIL = source.Has("w_TRXAUTRIL");
      if (m_bpassedw_TRXAUTRIL) {
        w_TRXAUTRIL = source.GetParameter("w_TRXAUTRIL",source.GetParameter("TRXAUTRIL",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXAUTRIL = source.GetCaller().GetString("TRXAUTRIL","C",50,0);
          m_bpassedw_TRXAUTRIL = true;
        } else {
          w_TRXAUTRIL = source.GetParameter("TRXAUTRIL",source.GetParameter("w_TRXAUTRIL",""));
        }
      }
      m_bpassedw_TRXNAZRES = source.Has("w_TRXNAZRES");
      if (m_bpassedw_TRXNAZRES) {
        w_TRXNAZRES = source.GetParameter("w_TRXNAZRES",source.GetParameter("TRXNAZRES",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNAZRES = source.GetCaller().GetString("TRXNAZRES","C",50,0);
          m_bpassedw_TRXNAZRES = true;
        } else {
          w_TRXNAZRES = source.GetParameter("TRXNAZRES",source.GetParameter("w_TRXNAZRES",""));
        }
      }
      m_bpassedw_TRXCITRES = source.Has("w_TRXCITRES");
      if (m_bpassedw_TRXCITRES) {
        w_TRXCITRES = source.GetParameter("w_TRXCITRES",source.GetParameter("TRXCITRES",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCITRES = source.GetCaller().GetString("TRXCITRES","C",50,0);
          m_bpassedw_TRXCITRES = true;
        } else {
          w_TRXCITRES = source.GetParameter("TRXCITRES",source.GetParameter("w_TRXCITRES",""));
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
      m_bpassedw_TRXFLGCON = source.Has("w_TRXFLGCON");
      if (m_bpassedw_TRXFLGCON) {
        w_TRXFLGCON = source.GetParameter("w_TRXFLGCON",source.GetParameter("TRXFLGCON",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXFLGCON = source.GetCaller().GetString("TRXFLGCON","C",1,0);
          m_bpassedw_TRXFLGCON = true;
        } else {
          w_TRXFLGCON = source.GetParameter("TRXFLGCON",source.GetParameter("w_TRXFLGCON",""));
        }
      }
      m_bpassedw_TRSSEGNO = source.Has("w_TRSSEGNO");
      if (m_bpassedw_TRSSEGNO) {
        w_TRSSEGNO = source.GetParameter("w_TRSSEGNO",source.GetParameter("TRSSEGNO",""));
      } else {
        if (source.IsForwarded()) {
          w_TRSSEGNO = source.GetCaller().GetString("TRSSEGNO","C",1,0);
          m_bpassedw_TRSSEGNO = true;
        } else {
          w_TRSSEGNO = source.GetParameter("TRSSEGNO",source.GetParameter("w_TRSSEGNO",""));
        }
      }
      m_bpassedw_TRXIMPORTO = source.Has("w_TRXIMPORTO");
      if (m_bpassedw_TRXIMPORTO) {
        w_TRXIMPORTO = source.GetParameter("w_TRXIMPORTO",source.GetParameter("TRXIMPORTO",0));
      } else {
        if (source.IsForwarded()) {
          w_TRXIMPORTO = source.GetCaller().GetNumber("TRXIMPORTO","N",15,2);
          m_bpassedw_TRXIMPORTO = true;
        } else {
          w_TRXIMPORTO = source.GetParameter("TRXIMPORTO",source.GetParameter("w_TRXIMPORTO",0));
        }
      }
      m_bpassedw_TRXCONTAN = source.Has("w_TRXCONTAN");
      if (m_bpassedw_TRXCONTAN) {
        w_TRXCONTAN = source.GetParameter("w_TRXCONTAN",source.GetParameter("TRXCONTAN",0));
      } else {
        if (source.IsForwarded()) {
          w_TRXCONTAN = source.GetCaller().GetNumber("TRXCONTAN","N",15,2);
          m_bpassedw_TRXCONTAN = true;
        } else {
          w_TRXCONTAN = source.GetParameter("TRXCONTAN",source.GetParameter("w_TRXCONTAN",0));
        }
      }
      m_bpassedw_TRXUNIQUE = source.Has("w_TRXUNIQUE");
      if (m_bpassedw_TRXUNIQUE) {
        w_TRXUNIQUE = source.GetParameter("w_TRXUNIQUE",source.GetParameter("TRXUNIQUE",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXUNIQUE = source.GetCaller().GetString("TRXUNIQUE","C",10,0);
          m_bpassedw_TRXUNIQUE = true;
        } else {
          w_TRXUNIQUE = source.GetParameter("TRXUNIQUE",source.GetParameter("w_TRXUNIQUE",""));
        }
      }
      m_bpassedw_TRXCODDIP = source.Has("w_TRXCODDIP");
      if (m_bpassedw_TRXCODDIP) {
        w_TRXCODDIP = source.GetParameter("w_TRXCODDIP",source.GetParameter("TRXCODDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODDIP = source.GetCaller().GetString("TRXCODDIP","C",10,0);
          m_bpassedw_TRXCODDIP = true;
        } else {
          w_TRXCODDIP = source.GetParameter("TRXCODDIP",source.GetParameter("w_TRXCODDIP",""));
        }
      }
      m_bpassedw_TRXCOGCON = source.Has("w_TRXCOGCON");
      if (m_bpassedw_TRXCOGCON) {
        w_TRXCOGCON = source.GetParameter("w_TRXCOGCON",source.GetParameter("TRXCOGCON",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCOGCON = source.GetCaller().GetString("TRXCOGCON","C",100,0);
          m_bpassedw_TRXCOGCON = true;
        } else {
          w_TRXCOGCON = source.GetParameter("TRXCOGCON",source.GetParameter("w_TRXCOGCON",""));
        }
      }
      m_bpassedw_TRXNOMCON = source.Has("w_TRXNOMCON");
      if (m_bpassedw_TRXNOMCON) {
        w_TRXNOMCON = source.GetParameter("w_TRXNOMCON",source.GetParameter("TRXNOMCON",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXNOMCON = source.GetCaller().GetString("TRXNOMCON","C",100,0);
          m_bpassedw_TRXNOMCON = true;
        } else {
          w_TRXNOMCON = source.GetParameter("TRXNOMCON",source.GetParameter("w_TRXNOMCON",""));
        }
      }
      m_bpassedw_TRXDESTIN = source.Has("w_TRXDESTIN");
      if (m_bpassedw_TRXDESTIN) {
        w_TRXDESTIN = source.GetParameter("w_TRXDESTIN",source.GetParameter("TRXDESTIN",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXDESTIN = source.GetCaller().GetString("TRXDESTIN","C",100,0);
          m_bpassedw_TRXDESTIN = true;
        } else {
          w_TRXDESTIN = source.GetParameter("TRXDESTIN",source.GetParameter("w_TRXDESTIN",""));
        }
      }
      m_bpassedw_TRXMTCN = source.Has("w_TRXMTCN");
      if (m_bpassedw_TRXMTCN) {
        w_TRXMTCN = source.GetParameter("w_TRXMTCN",source.GetParameter("TRXMTCN",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXMTCN = source.GetCaller().GetString("TRXMTCN","C",10,0);
          m_bpassedw_TRXMTCN = true;
        } else {
          w_TRXMTCN = source.GetParameter("TRXMTCN",source.GetParameter("w_TRXMTCN",""));
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
      m_bpassedw_TRXCODCAS = source.Has("w_TRXCODCAS");
      if (m_bpassedw_TRXCODCAS) {
        w_TRXCODCAS = source.GetParameter("w_TRXCODCAS",source.GetParameter("TRXCODCAS",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODCAS = source.GetCaller().GetString("TRXCODCAS","C",4,0);
          m_bpassedw_TRXCODCAS = true;
        } else {
          w_TRXCODCAS = source.GetParameter("TRXCODCAS",source.GetParameter("w_TRXCODCAS",""));
        }
      }
      m_bpassedw_TRXRECTYPE = source.Has("w_TRXRECTYPE");
      if (m_bpassedw_TRXRECTYPE) {
        w_TRXRECTYPE = source.GetParameter("w_TRXRECTYPE",source.GetParameter("TRXRECTYPE",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXRECTYPE = source.GetCaller().GetString("TRXRECTYPE","C",1,0);
          m_bpassedw_TRXRECTYPE = true;
        } else {
          w_TRXRECTYPE = source.GetParameter("TRXRECTYPE",source.GetParameter("w_TRXRECTYPE",""));
        }
      }
      m_bpassedw_TRXCODMAG = source.Has("w_TRXCODMAG");
      if (m_bpassedw_TRXCODMAG) {
        w_TRXCODMAG = source.GetParameter("w_TRXCODMAG",source.GetParameter("TRXCODMAG",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODMAG = source.GetCaller().GetString("TRXCODMAG","C",5,0);
          m_bpassedw_TRXCODMAG = true;
        } else {
          w_TRXCODMAG = source.GetParameter("TRXCODMAG",source.GetParameter("w_TRXCODMAG",""));
        }
      }
      m_bpassedw_TRXCODUNI = source.Has("w_TRXCODUNI");
      if (m_bpassedw_TRXCODUNI) {
        w_TRXCODUNI = source.GetParameter("w_TRXCODUNI",source.GetParameter("TRXCODUNI",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXCODUNI = source.GetCaller().GetString("TRXCODUNI","C",18,0);
          m_bpassedw_TRXCODUNI = true;
        } else {
          w_TRXCODUNI = source.GetParameter("TRXCODUNI",source.GetParameter("w_TRXCODUNI",""));
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
      m_bpassedw_TRXTFINLAV = source.Has("w_TRXTFINLAV");
      if (m_bpassedw_TRXTFINLAV) {
        w_TRXTFINLAV = source.GetParameter("w_TRXTFINLAV",source.GetParameter("TRXTFINLAV",CPLib.NullDateTime()));
      } else {
        if (source.IsForwarded()) {
          w_TRXTFINLAV = source.GetCaller().GetDateTime("TRXTFINLAV","T",14,0);
          m_bpassedw_TRXTFINLAV = true;
        } else {
          w_TRXTFINLAV = source.GetParameter("TRXTFINLAV",source.GetParameter("w_TRXTFINLAV",CPLib.NullDateTime()));
        }
      }
      m_bpassedw_TRDFINLAV = source.Has("w_TRDFINLAV");
      if (m_bpassedw_TRDFINLAV) {
        w_TRDFINLAV = source.GetParameter("w_TRDFINLAV",source.GetParameter("TRDFINLAV",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_TRDFINLAV = source.GetCaller().GetDate("TRDFINLAV","D",8,0);
          m_bpassedw_TRDFINLAV = true;
        } else {
          w_TRDFINLAV = source.GetParameter("TRDFINLAV",source.GetParameter("w_TRDFINLAV",CPLib.NullDate()));
        }
      }
      m_bpassedw_TRFLGINLAV = source.Has("w_TRFLGINLAV");
      if (m_bpassedw_TRFLGINLAV) {
        w_TRFLGINLAV = source.GetParameter("w_TRFLGINLAV",source.GetParameter("TRFLGINLAV",""));
      } else {
        if (source.IsForwarded()) {
          w_TRFLGINLAV = source.GetCaller().GetString("TRFLGINLAV","C",1,0);
          m_bpassedw_TRFLGINLAV = true;
        } else {
          w_TRFLGINLAV = source.GetParameter("TRFLGINLAV",source.GetParameter("w_TRFLGINLAV",""));
        }
      }
      m_bpassedw_TRXFLGAUA = source.Has("w_TRXFLGAUA");
      if (m_bpassedw_TRXFLGAUA) {
        w_TRXFLGAUA = source.GetParameter("w_TRXFLGAUA",source.GetParameter("TRXFLGAUA",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXFLGAUA = source.GetCaller().GetString("TRXFLGAUA","C",1,0);
          m_bpassedw_TRXFLGAUA = true;
        } else {
          w_TRXFLGAUA = source.GetParameter("TRXFLGAUA",source.GetParameter("w_TRXFLGAUA",""));
        }
      }
      m_bpassedw_TRXESITO = source.Has("w_TRXESITO");
      if (m_bpassedw_TRXESITO) {
        w_TRXESITO = source.GetParameter("w_TRXESITO",source.GetParameter("TRXESITO",""));
      } else {
        if (source.IsForwarded()) {
          w_TRXESITO = source.GetCaller().GetString("TRXESITO","C",1,0);
          m_bpassedw_TRXESITO = true;
        } else {
          w_TRXESITO = source.GetParameter("TRXESITO",source.GetParameter("w_TRXESITO",""));
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
    l_eg.name = "arrt_wutrxchk_save";
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
    return  ! (status.m_bpassedw_finalized) ||  ! (status.m_bpassedw_TRXESITO) ||  ! (status.m_bpassedw_TRXFLGAUA) ||  ! (status.m_bpassedw_TRFLGINLAV) ||  ! (status.m_bpassedw_TRDFINLAV) ||  ! (status.m_bpassedw_TRXTFINLAV) ||  ! (status.m_bpassedw_TRXFLGFOR) ||  ! (status.m_bpassedw_TRXCODUNI) ||  ! (status.m_bpassedw_TRXCODMAG) ||  ! (status.m_bpassedw_TRXRECTYPE) ||  ! (status.m_bpassedw_TRXCODCAS) ||  ! (status.m_bpassedw_TRXSESSO) ||  ! (status.m_bpassedw_TRXDATNAS) ||  ! (status.m_bpassedw_TRXMTCN) ||  ! (status.m_bpassedw_TRXDESTIN) ||  ! (status.m_bpassedw_TRXNOMCON) ||  ! (status.m_bpassedw_TRXCOGCON) ||  ! (status.m_bpassedw_TRXCODDIP) ||  ! (status.m_bpassedw_TRXUNIQUE) ||  ! (status.m_bpassedw_TRXCONTAN) ||  ! (status.m_bpassedw_TRXIMPORTO) ||  ! (status.m_bpassedw_TRSSEGNO) ||  ! (status.m_bpassedw_TRXFLGCON) ||  ! (status.m_bpassedw_TRXDATOPE) ||  ! (status.m_bpassedw_TRXTIPDOC) ||  ! (status.m_bpassedw_TRXCITRES) ||  ! (status.m_bpassedw_TRXNAZRES) ||  ! (status.m_bpassedw_TRXAUTRIL) ||  ! (status.m_bpassedw_TRXDATRIL) ||  ! (status.m_bpassedw_TRXDATSCA) ||  ! (status.m_bpassedw_TRXNUMDOC) ||  ! (status.m_bpassedw_TRXLUONAS) ||  ! (status.m_bpassedw_TRXCODFIS) ||  ! (status.m_bpassedw_TRXFLGCF) ||  ! (status.m_bpassedw_TRXDOMICI) ||  ! (status.m_bpassedw_TRXNOME) ||  ! (status.m_bpassedw_TRXCOGNOM) ||  ! (status.m_bpassedw_TRXCODPRG);
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
    if ( ! (status.m_bpassedw_TRXDOMICI)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXDOMICI',"+SPLib.ToJSValue(status.w_TRXDOMICI,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDOMICI,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXDOMICI',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGCF)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGCF',"+SPLib.ToJSValue(status.w_TRXFLGCF,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGCF,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGCF',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODFIS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODFIS',"+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODFIS,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODFIS',l_cV);");
    if ( ! (status.m_bpassedw_TRXLUONAS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXLUONAS',"+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXLUONAS,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXLUONAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXNUMDOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNUMDOC',"+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNUMDOC',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATSCA)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATSCA',"+SPLib.ToJSValue(status.w_TRXDATSCA,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATSCA,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATSCA',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATRIL)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATRIL',"+SPLib.ToJSValue(status.w_TRXDATRIL,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATRIL,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATRIL',l_cV);");
    if ( ! (status.m_bpassedw_TRXAUTRIL)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXAUTRIL',"+SPLib.ToJSValue(status.w_TRXAUTRIL,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXAUTRIL,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXAUTRIL',l_cV);");
    if ( ! (status.m_bpassedw_TRXNAZRES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNAZRES',"+SPLib.ToJSValue(status.w_TRXNAZRES,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNAZRES,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNAZRES',l_cV);");
    if ( ! (status.m_bpassedw_TRXCITRES)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCITRES',"+SPLib.ToJSValue(status.w_TRXCITRES,"C",50,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCITRES,"C",50,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCITRES',l_cV);");
    if ( ! (status.m_bpassedw_TRXTIPDOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXTIPDOC',"+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXTIPDOC',l_cV);");
    if ( ! (status.m_bpassedw_TRXDATOPE)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRXDATOPE',"+SPLib.ToJSValue(status.w_TRXDATOPE,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDATOPE,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRXDATOPE',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGCON)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGCON',"+SPLib.ToJSValue(status.w_TRXFLGCON,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGCON,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGCON',l_cV);");
    if ( ! (status.m_bpassedw_TRSSEGNO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRSSEGNO',"+SPLib.ToJSValue(status.w_TRSSEGNO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRSSEGNO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRSSEGNO',l_cV);");
    if ( ! (status.m_bpassedw_TRXIMPORTO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXIMPORTO',"+SPLib.ToJSValue(status.w_TRXIMPORTO,"N",15,2)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXIMPORTO,"N",15,2)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_TRXIMPORTO',l_cV);");
    if ( ! (status.m_bpassedw_TRXCONTAN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCONTAN',"+SPLib.ToJSValue(status.w_TRXCONTAN,"N",15,2)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCONTAN,"N",15,2)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_TRXCONTAN',l_cV);");
    if ( ! (status.m_bpassedw_TRXUNIQUE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXUNIQUE',"+SPLib.ToJSValue(status.w_TRXUNIQUE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXUNIQUE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXUNIQUE',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODDIP',"+SPLib.ToJSValue(status.w_TRXCODDIP,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODDIP,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODDIP',l_cV);");
    if ( ! (status.m_bpassedw_TRXCOGCON)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCOGCON',"+SPLib.ToJSValue(status.w_TRXCOGCON,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCOGCON,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCOGCON',l_cV);");
    if ( ! (status.m_bpassedw_TRXNOMCON)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXNOMCON',"+SPLib.ToJSValue(status.w_TRXNOMCON,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXNOMCON,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXNOMCON',l_cV);");
    if ( ! (status.m_bpassedw_TRXDESTIN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXDESTIN',"+SPLib.ToJSValue(status.w_TRXDESTIN,"C",100,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXDESTIN,"C",100,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXDESTIN',l_cV);");
    if ( ! (status.m_bpassedw_TRXMTCN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXMTCN',"+SPLib.ToJSValue(status.w_TRXMTCN,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXMTCN,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXMTCN',l_cV);");
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
    if ( ! (status.m_bpassedw_TRXCODCAS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODCAS',"+SPLib.ToJSValue(status.w_TRXCODCAS,"C",4,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODCAS,"C",4,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODCAS',l_cV);");
    if ( ! (status.m_bpassedw_TRXRECTYPE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXRECTYPE',"+SPLib.ToJSValue(status.w_TRXRECTYPE,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXRECTYPE,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXRECTYPE',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODMAG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODMAG',"+SPLib.ToJSValue(status.w_TRXCODMAG,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODMAG,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODMAG',l_cV);");
    if ( ! (status.m_bpassedw_TRXCODUNI)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXCODUNI',"+SPLib.ToJSValue(status.w_TRXCODUNI,"C",18,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXCODUNI,"C",18,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXCODUNI',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGFOR)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGFOR',"+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGFOR',l_cV);");
    if ( ! (status.m_bpassedw_TRXTFINLAV)) {
      status.out.println("l_cV=WtA(FetchDateTime(l_oWnd('w_TRXTFINLAV',"+SPLib.ToJSValue(status.w_TRXTFINLAV,"T",14,0)+")),'T');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXTFINLAV,"T",14,0)+",'T');");
    }
    status.out.println("l_oWv.setValue('w_TRXTFINLAV',l_cV);");
    if ( ! (status.m_bpassedw_TRDFINLAV)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_TRDFINLAV',"+SPLib.ToJSValue(status.w_TRDFINLAV,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRDFINLAV,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_TRDFINLAV',l_cV);");
    if ( ! (status.m_bpassedw_TRFLGINLAV)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRFLGINLAV',"+SPLib.ToJSValue(status.w_TRFLGINLAV,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRFLGINLAV,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRFLGINLAV',l_cV);");
    if ( ! (status.m_bpassedw_TRXFLGAUA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXFLGAUA',"+SPLib.ToJSValue(status.w_TRXFLGAUA,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXFLGAUA,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXFLGAUA',l_cV);");
    if ( ! (status.m_bpassedw_TRXESITO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TRXESITO',"+SPLib.ToJSValue(status.w_TRXESITO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TRXESITO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TRXESITO',l_cV);");
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
    arrt_wutrxchk_saveR Rcalled;
    Rcalled = new arrt_wutrxchk_saveR(status.context,status);
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
    return new arrt_wutrxchk_saveR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_wutrxchk_saveR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_wutrxchk_save"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_TRXCODPRG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODPRG),"?",0,0)+"");
        status.out.println("js:w_TRXCOGNOM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCOGNOM),"?",0,0)+"");
        status.out.println("js:w_TRXNOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNOME),"?",0,0)+"");
        status.out.println("js:w_TRXDOMICI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDOMICI),"?",0,0)+"");
        status.out.println("js:w_TRXFLGCF="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGCF),"?",0,0)+"");
        status.out.println("js:w_TRXCODFIS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODFIS),"?",0,0)+"");
        status.out.println("js:w_TRXLUONAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXLUONAS),"?",0,0)+"");
        status.out.println("js:w_TRXNUMDOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNUMDOC),"?",0,0)+"");
        status.out.println("js:w_TRXDATSCA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATSCA),"?",0,0)+"");
        status.out.println("js:w_TRXDATRIL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATRIL),"?",0,0)+"");
        status.out.println("js:w_TRXAUTRIL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXAUTRIL),"?",0,0)+"");
        status.out.println("js:w_TRXNAZRES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNAZRES),"?",0,0)+"");
        status.out.println("js:w_TRXCITRES="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCITRES),"?",0,0)+"");
        status.out.println("js:w_TRXTIPDOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXTIPDOC),"?",0,0)+"");
        status.out.println("js:w_TRXDATOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATOPE),"?",0,0)+"");
        status.out.println("js:w_TRXFLGCON="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGCON),"?",0,0)+"");
        status.out.println("js:w_TRSSEGNO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRSSEGNO),"?",0,0)+"");
        status.out.println("js:w_TRXIMPORTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXIMPORTO),"?",0,0)+"");
        status.out.println("js:w_TRXCONTAN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCONTAN),"?",0,0)+"");
        status.out.println("js:w_TRXUNIQUE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXUNIQUE),"?",0,0)+"");
        status.out.println("js:w_TRXCODDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODDIP),"?",0,0)+"");
        status.out.println("js:w_TRXCOGCON="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCOGCON),"?",0,0)+"");
        status.out.println("js:w_TRXNOMCON="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXNOMCON),"?",0,0)+"");
        status.out.println("js:w_TRXDESTIN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDESTIN),"?",0,0)+"");
        status.out.println("js:w_TRXMTCN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXMTCN),"?",0,0)+"");
        status.out.println("js:w_TRXDATNAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXDATNAS),"?",0,0)+"");
        status.out.println("js:w_TRXSESSO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXSESSO),"?",0,0)+"");
        status.out.println("js:w_TRXCODCAS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODCAS),"?",0,0)+"");
        status.out.println("js:w_TRXRECTYPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXRECTYPE),"?",0,0)+"");
        status.out.println("js:w_TRXCODMAG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODMAG),"?",0,0)+"");
        status.out.println("js:w_TRXCODUNI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXCODUNI),"?",0,0)+"");
        status.out.println("js:w_TRXFLGFOR="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGFOR),"?",0,0)+"");
        status.out.println("js:w_TRXTFINLAV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXTFINLAV),"?",0,0)+"");
        status.out.println("js:w_TRDFINLAV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRDFINLAV),"?",0,0)+"");
        status.out.println("js:w_TRFLGINLAV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRFLGINLAV),"?",0,0)+"");
        status.out.println("js:w_TRXFLGAUA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXFLGAUA),"?",0,0)+"");
        status.out.println("js:w_TRXESITO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TRXESITO),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_TRXDOMICI,null)) {");
        status.out.println("window[f].w_TRXDOMICI="+SPLib.ToJSValue(status.w_TRXDOMICI,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGCF,null)) {");
        status.out.println("window[f].w_TRXFLGCF="+SPLib.ToJSValue(status.w_TRXFLGCF,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODFIS,null)) {");
        status.out.println("window[f].w_TRXCODFIS="+SPLib.ToJSValue(status.w_TRXCODFIS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXLUONAS,null)) {");
        status.out.println("window[f].w_TRXLUONAS="+SPLib.ToJSValue(status.w_TRXLUONAS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNUMDOC,null)) {");
        status.out.println("window[f].w_TRXNUMDOC="+SPLib.ToJSValue(status.w_TRXNUMDOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATSCA,null)) {");
        status.out.println(" window[f].w_TRXDATSCA.setTime(("+SPLib.ToJSValue(status.w_TRXDATSCA,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATRIL,null)) {");
        status.out.println(" window[f].w_TRXDATRIL.setTime(("+SPLib.ToJSValue(status.w_TRXDATRIL,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXAUTRIL,null)) {");
        status.out.println("window[f].w_TRXAUTRIL="+SPLib.ToJSValue(status.w_TRXAUTRIL,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNAZRES,null)) {");
        status.out.println("window[f].w_TRXNAZRES="+SPLib.ToJSValue(status.w_TRXNAZRES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCITRES,null)) {");
        status.out.println("window[f].w_TRXCITRES="+SPLib.ToJSValue(status.w_TRXCITRES,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXTIPDOC,null)) {");
        status.out.println("window[f].w_TRXTIPDOC="+SPLib.ToJSValue(status.w_TRXTIPDOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATOPE,null)) {");
        status.out.println(" window[f].w_TRXDATOPE.setTime(("+SPLib.ToJSValue(status.w_TRXDATOPE,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGCON,null)) {");
        status.out.println("window[f].w_TRXFLGCON="+SPLib.ToJSValue(status.w_TRXFLGCON,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRSSEGNO,null)) {");
        status.out.println("window[f].w_TRSSEGNO="+SPLib.ToJSValue(status.w_TRSSEGNO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXIMPORTO,null)) {");
        status.out.println("window[f].w_TRXIMPORTO="+SPLib.ToJSValue(status.w_TRXIMPORTO,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCONTAN,null)) {");
        status.out.println("window[f].w_TRXCONTAN="+SPLib.ToJSValue(status.w_TRXCONTAN,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXUNIQUE,null)) {");
        status.out.println("window[f].w_TRXUNIQUE="+SPLib.ToJSValue(status.w_TRXUNIQUE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODDIP,null)) {");
        status.out.println("window[f].w_TRXCODDIP="+SPLib.ToJSValue(status.w_TRXCODDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCOGCON,null)) {");
        status.out.println("window[f].w_TRXCOGCON="+SPLib.ToJSValue(status.w_TRXCOGCON,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXNOMCON,null)) {");
        status.out.println("window[f].w_TRXNOMCON="+SPLib.ToJSValue(status.w_TRXNOMCON,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDESTIN,null)) {");
        status.out.println("window[f].w_TRXDESTIN="+SPLib.ToJSValue(status.w_TRXDESTIN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXMTCN,null)) {");
        status.out.println("window[f].w_TRXMTCN="+SPLib.ToJSValue(status.w_TRXMTCN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXDATNAS,null)) {");
        status.out.println(" window[f].w_TRXDATNAS.setTime(("+SPLib.ToJSValue(status.w_TRXDATNAS,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXSESSO,null)) {");
        status.out.println("window[f].w_TRXSESSO="+SPLib.ToJSValue(status.w_TRXSESSO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODCAS,null)) {");
        status.out.println("window[f].w_TRXCODCAS="+SPLib.ToJSValue(status.w_TRXCODCAS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXRECTYPE,null)) {");
        status.out.println("window[f].w_TRXRECTYPE="+SPLib.ToJSValue(status.w_TRXRECTYPE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODMAG,null)) {");
        status.out.println("window[f].w_TRXCODMAG="+SPLib.ToJSValue(status.w_TRXCODMAG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXCODUNI,null)) {");
        status.out.println("window[f].w_TRXCODUNI="+SPLib.ToJSValue(status.w_TRXCODUNI,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGFOR,null)) {");
        status.out.println("window[f].w_TRXFLGFOR="+SPLib.ToJSValue(status.w_TRXFLGFOR,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXTFINLAV,null)) {");
        status.out.println(" window[f].w_TRXTFINLAV.setTime(("+SPLib.ToJSValue(status.w_TRXTFINLAV,"T",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRDFINLAV,null)) {");
        status.out.println(" window[f].w_TRDFINLAV.setTime(("+SPLib.ToJSValue(status.w_TRDFINLAV,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRFLGINLAV,null)) {");
        status.out.println("window[f].w_TRFLGINLAV="+SPLib.ToJSValue(status.w_TRFLGINLAV,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXFLGAUA,null)) {");
        status.out.println("window[f].w_TRXFLGAUA="+SPLib.ToJSValue(status.w_TRXFLGAUA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TRXESITO,null)) {");
        status.out.println("window[f].w_TRXESITO="+SPLib.ToJSValue(status.w_TRXESITO,"C",0,0)+";");
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
      arrt_wutrxchk_saveR Rcalled;
      Rcalled = new arrt_wutrxchk_saveR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_wutrxchk_save");
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
