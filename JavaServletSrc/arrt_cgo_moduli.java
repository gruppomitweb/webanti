import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arrt_cgo_moduli extends SPRoutineServlet implements SPInvokable {
  public static String m_cEntityUid = "!*87f48b18*!";
  public class ServletStatus extends SPRoutineServletStatus {
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_STATOREG;
    public String w_STATOREG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IDBASE;
    public String w_IDBASE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NUMPROG;
    public String w_NUMPROG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCRI;
    public String w_DESCRI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CITINT;
    public String w_CITINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CITDIP;
    public String w_CITDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVDIP;
    public String w_PROVDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CABDIP;
    public String w_CABDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVINT;
    public String w_PROVINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CABINT;
    public String w_CABINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPOPERS;
    public String w_TIPOPERS;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MEZPAGAM;
    public String w_MEZPAGAM;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IBAN;
    public String w_IBAN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CFESTERO;
    public double w_CFESTERO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODFISC;
    public String w_CODFISC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_COGNOME;
    public String w_COGNOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NOME;
    public String w_NOME;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAGSOC;
    public String w_RAGSOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCCIT;
    public String w_DESCCIT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVINCIA;
    public String w_PROVINCIA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAP;
    public String w_CAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODCAB;
    public String w_CODCAB;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DOMICILIO;
    public String w_DOMICILIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PAESE;
    public String w_PAESE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NASCOMUN;
    public String w_NASCOMUN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPINTER;
    public String w_TIPINTER;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SESSO;
    public String w_SESSO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NASSTATO;
    public String w_NASSTATO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATANASC;
    public java.sql.Date w_DATANASC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPODOC;
    public String w_TIPODOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NUMDOCUM;
    public String w_NUMDOCUM;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATARILASC;
    public java.sql.Date w_DATARILASC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATAVALI;
    public java.sql.Date w_DATAVALI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_AUTRILASC;
    public String w_AUTRILASC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SOTGRUP;
    public String w_SOTGRUP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RAMOGRUP;
    public String w_RAMOGRUP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SETTSINT;
    public String w_SETTSINT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PEP;
    public String w_PEP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SNAINUMOPE;
    public String w_SNAINUMOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATAOPE;
    public java.sql.Date w_DATAOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DATAREG;
    public java.sql.Date w_DATAREG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLAGCONT;
    public String w_FLAGCONT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPOOPRAP;
    public String w_TIPOOPRAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODANA;
    public String w_CODANA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODVOC;
    public String w_CODVOC;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_VALUTA;
    public String w_VALUTA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAMBIO;
    public double w_CAMBIO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNESCLI;
    public String w_CONNESCLI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CONNESBEN;
    public String w_CONNESBEN;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_RAG;
    public String w_C_RAG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CTA;
    public String w_C_CTA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_PRV;
    public String w_C_PRV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CAP;
    public String w_C_CAP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_CAB;
    public String w_C_CAB;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_IND;
    public String w_C_IND;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_C_STA;
    public String w_C_STA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODINTER;
    public String w_CODINTER;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODDIPE;
    public String w_CODDIPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCCITDIP;
    public String w_DESCCITDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_SEGNO;
    public String w_SEGNO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLAGFRAZ;
    public String w_FLAGFRAZ;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_COLLEG;
    public String w_COLLEG;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVINCIADIP;
    public String w_PROVINCIADIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODCABDIP;
    public String w_CODCABDIP;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TOTLIRE;
    public double w_TOTLIRE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TOTCONT;
    public double w_TOTCONT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CACODICE;
    public double w_CACODICE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAIDBIGLIETTO;
    public String w_CAIDBIGLIETTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAFLGOPE;
    public String w_CAFLGOPE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ATTIV;
    public String w_ATTIV;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MIDBIGLIETTO;
    public String w_MIDBIGLIETTO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MIDBIGLIETTO1;
    public String w_MIDBIGLIETTO1;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MIDBIGLIETTO2;
    public String w_MIDBIGLIETTO2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MIDBIGLIETTO3;
    public String w_MIDBIGLIETTO3;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_MIDBIGLIETTO4;
    public String w_MIDBIGLIETTO4;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_ASSEGNO;
    public String w_ASSEGNO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_VLTPLAT;
    public String w_VLTPLAT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CC4CIFRE;
    public String w_CC4CIFRE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CCDATSCA;
    public String w_CCDATSCA;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_NUMTEL;
    public String w_NUMTEL;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_TIPOGIOCO;
    public String w_TIPOGIOCO;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RDCODAUT;
    public String w_RDCODAUT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_RDLOCAUT;
    public String w_RDLOCAUT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CGOFLGVLT;
    public String w_CGOFLGVLT;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PEPDESCRI;
    public String w_PEPDESCRI;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLGDOM;
    public String w_FLGDOM;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PAESE2;
    public String w_PAESE2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DOMICILIO2;
    public String w_DOMICILIO2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROVINCIA2;
    public String w_PROVINCIA2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_DESCCIT2;
    public String w_DESCCIT2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CAP2;
    public String w_CAP2;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_PROFESSIONE;
    public String w_PROFESSIONE;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_IMPWALLET;
    public double w_IMPWALLET;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODWALLET;
    public String w_CODWALLET;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_FLAGWALLET;
    public String w_FLAGWALLET;
    // Segnala se e' stata passata con la start della servlet
    public boolean m_bpassedw_CODTRANSZ;
    public String w_CODTRANSZ;
    public String cProg;
    public ReportLibrary _report;
    public boolean bReport;
    public String _ra1;
    public String _ra2;
    public String filename;
    public String filepdf;
    public String stringa;
    public String _flgstpd;
    public String _urldef;
    public String _pagam;
    public String _mpagam;
    public String _tipgio;
    public String _desaut;
    public String _modello;
    public String _concessione;
    public String gUrlApp;
    public String gPathApp;
    public String gAzienda;
    public String gIPC;
    public String gIPS;
    public String gIPSP;
    public String gCodDip;
    public void GetNonLocals(SPParameterSource source) {
      m_bpassedw_STATOREG = source.Has("w_STATOREG");
      if (m_bpassedw_STATOREG) {
        w_STATOREG = source.GetParameter("w_STATOREG",source.GetParameter("STATOREG",""));
      } else {
        if (source.IsForwarded()) {
          w_STATOREG = source.GetCaller().GetString("STATOREG","C",1,0);
          m_bpassedw_STATOREG = true;
        } else {
          w_STATOREG = source.GetParameter("STATOREG",source.GetParameter("w_STATOREG",""));
        }
      }
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
      m_bpassedw_NUMPROG = source.Has("w_NUMPROG");
      if (m_bpassedw_NUMPROG) {
        w_NUMPROG = source.GetParameter("w_NUMPROG",source.GetParameter("NUMPROG",""));
      } else {
        if (source.IsForwarded()) {
          w_NUMPROG = source.GetCaller().GetString("NUMPROG","C",7,0);
          m_bpassedw_NUMPROG = true;
        } else {
          w_NUMPROG = source.GetParameter("NUMPROG",source.GetParameter("w_NUMPROG",""));
        }
      }
      m_bpassedw_DESCRI = source.Has("w_DESCRI");
      if (m_bpassedw_DESCRI) {
        w_DESCRI = source.GetParameter("w_DESCRI",source.GetParameter("DESCRI",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCRI = source.GetCaller().GetString("DESCRI","C",30,0);
          m_bpassedw_DESCRI = true;
        } else {
          w_DESCRI = source.GetParameter("DESCRI",source.GetParameter("w_DESCRI",""));
        }
      }
      m_bpassedw_CITINT = source.Has("w_CITINT");
      if (m_bpassedw_CITINT) {
        w_CITINT = source.GetParameter("w_CITINT",source.GetParameter("CITINT",""));
      } else {
        if (source.IsForwarded()) {
          w_CITINT = source.GetCaller().GetString("CITINT","C",30,0);
          m_bpassedw_CITINT = true;
        } else {
          w_CITINT = source.GetParameter("CITINT",source.GetParameter("w_CITINT",""));
        }
      }
      m_bpassedw_CITDIP = source.Has("w_CITDIP");
      if (m_bpassedw_CITDIP) {
        w_CITDIP = source.GetParameter("w_CITDIP",source.GetParameter("CITDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_CITDIP = source.GetCaller().GetString("CITDIP","C",30,0);
          m_bpassedw_CITDIP = true;
        } else {
          w_CITDIP = source.GetParameter("CITDIP",source.GetParameter("w_CITDIP",""));
        }
      }
      m_bpassedw_PROVDIP = source.Has("w_PROVDIP");
      if (m_bpassedw_PROVDIP) {
        w_PROVDIP = source.GetParameter("w_PROVDIP",source.GetParameter("PROVDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVDIP = source.GetCaller().GetString("PROVDIP","C",2,0);
          m_bpassedw_PROVDIP = true;
        } else {
          w_PROVDIP = source.GetParameter("PROVDIP",source.GetParameter("w_PROVDIP",""));
        }
      }
      m_bpassedw_CABDIP = source.Has("w_CABDIP");
      if (m_bpassedw_CABDIP) {
        w_CABDIP = source.GetParameter("w_CABDIP",source.GetParameter("CABDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_CABDIP = source.GetCaller().GetString("CABDIP","C",6,0);
          m_bpassedw_CABDIP = true;
        } else {
          w_CABDIP = source.GetParameter("CABDIP",source.GetParameter("w_CABDIP",""));
        }
      }
      m_bpassedw_PROVINT = source.Has("w_PROVINT");
      if (m_bpassedw_PROVINT) {
        w_PROVINT = source.GetParameter("w_PROVINT",source.GetParameter("PROVINT",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVINT = source.GetCaller().GetString("PROVINT","C",2,0);
          m_bpassedw_PROVINT = true;
        } else {
          w_PROVINT = source.GetParameter("PROVINT",source.GetParameter("w_PROVINT",""));
        }
      }
      m_bpassedw_CABINT = source.Has("w_CABINT");
      if (m_bpassedw_CABINT) {
        w_CABINT = source.GetParameter("w_CABINT",source.GetParameter("CABINT",""));
      } else {
        if (source.IsForwarded()) {
          w_CABINT = source.GetCaller().GetString("CABINT","C",6,0);
          m_bpassedw_CABINT = true;
        } else {
          w_CABINT = source.GetParameter("CABINT",source.GetParameter("w_CABINT",""));
        }
      }
      m_bpassedw_TIPOPERS = source.Has("w_TIPOPERS");
      if (m_bpassedw_TIPOPERS) {
        w_TIPOPERS = source.GetParameter("w_TIPOPERS",source.GetParameter("TIPOPERS",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPOPERS = source.GetCaller().GetString("TIPOPERS","C",1,0);
          m_bpassedw_TIPOPERS = true;
        } else {
          w_TIPOPERS = source.GetParameter("TIPOPERS",source.GetParameter("w_TIPOPERS",""));
        }
      }
      m_bpassedw_MEZPAGAM = source.Has("w_MEZPAGAM");
      if (m_bpassedw_MEZPAGAM) {
        w_MEZPAGAM = source.GetParameter("w_MEZPAGAM",source.GetParameter("MEZPAGAM",""));
      } else {
        if (source.IsForwarded()) {
          w_MEZPAGAM = source.GetCaller().GetString("MEZPAGAM","C",1,0);
          m_bpassedw_MEZPAGAM = true;
        } else {
          w_MEZPAGAM = source.GetParameter("MEZPAGAM",source.GetParameter("w_MEZPAGAM",""));
        }
      }
      m_bpassedw_IBAN = source.Has("w_IBAN");
      if (m_bpassedw_IBAN) {
        w_IBAN = source.GetParameter("w_IBAN",source.GetParameter("IBAN",""));
      } else {
        if (source.IsForwarded()) {
          w_IBAN = source.GetCaller().GetString("IBAN","C",27,0);
          m_bpassedw_IBAN = true;
        } else {
          w_IBAN = source.GetParameter("IBAN",source.GetParameter("w_IBAN",""));
        }
      }
      m_bpassedw_CFESTERO = source.Has("w_CFESTERO");
      if (m_bpassedw_CFESTERO) {
        w_CFESTERO = source.GetParameter("w_CFESTERO",source.GetParameter("CFESTERO",0));
      } else {
        if (source.IsForwarded()) {
          w_CFESTERO = source.GetCaller().GetNumber("CFESTERO","N",1,0);
          m_bpassedw_CFESTERO = true;
        } else {
          w_CFESTERO = source.GetParameter("CFESTERO",source.GetParameter("w_CFESTERO",0));
        }
      }
      m_bpassedw_CODFISC = source.Has("w_CODFISC");
      if (m_bpassedw_CODFISC) {
        w_CODFISC = source.GetParameter("w_CODFISC",source.GetParameter("CODFISC",""));
      } else {
        if (source.IsForwarded()) {
          w_CODFISC = source.GetCaller().GetString("CODFISC","C",16,0);
          m_bpassedw_CODFISC = true;
        } else {
          w_CODFISC = source.GetParameter("CODFISC",source.GetParameter("w_CODFISC",""));
        }
      }
      m_bpassedw_COGNOME = source.Has("w_COGNOME");
      if (m_bpassedw_COGNOME) {
        w_COGNOME = source.GetParameter("w_COGNOME",source.GetParameter("COGNOME",""));
      } else {
        if (source.IsForwarded()) {
          w_COGNOME = source.GetCaller().GetString("COGNOME","C",26,0);
          m_bpassedw_COGNOME = true;
        } else {
          w_COGNOME = source.GetParameter("COGNOME",source.GetParameter("w_COGNOME",""));
        }
      }
      m_bpassedw_NOME = source.Has("w_NOME");
      if (m_bpassedw_NOME) {
        w_NOME = source.GetParameter("w_NOME",source.GetParameter("NOME",""));
      } else {
        if (source.IsForwarded()) {
          w_NOME = source.GetCaller().GetString("NOME","C",25,0);
          m_bpassedw_NOME = true;
        } else {
          w_NOME = source.GetParameter("NOME",source.GetParameter("w_NOME",""));
        }
      }
      m_bpassedw_RAGSOC = source.Has("w_RAGSOC");
      if (m_bpassedw_RAGSOC) {
        w_RAGSOC = source.GetParameter("w_RAGSOC",source.GetParameter("RAGSOC",""));
      } else {
        if (source.IsForwarded()) {
          w_RAGSOC = source.GetCaller().GetString("RAGSOC","C",70,0);
          m_bpassedw_RAGSOC = true;
        } else {
          w_RAGSOC = source.GetParameter("RAGSOC",source.GetParameter("w_RAGSOC",""));
        }
      }
      m_bpassedw_DESCCIT = source.Has("w_DESCCIT");
      if (m_bpassedw_DESCCIT) {
        w_DESCCIT = source.GetParameter("w_DESCCIT",source.GetParameter("DESCCIT",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCCIT = source.GetCaller().GetString("DESCCIT","C",40,0);
          m_bpassedw_DESCCIT = true;
        } else {
          w_DESCCIT = source.GetParameter("DESCCIT",source.GetParameter("w_DESCCIT",""));
        }
      }
      m_bpassedw_PROVINCIA = source.Has("w_PROVINCIA");
      if (m_bpassedw_PROVINCIA) {
        w_PROVINCIA = source.GetParameter("w_PROVINCIA",source.GetParameter("PROVINCIA",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVINCIA = source.GetCaller().GetString("PROVINCIA","C",2,0);
          m_bpassedw_PROVINCIA = true;
        } else {
          w_PROVINCIA = source.GetParameter("PROVINCIA",source.GetParameter("w_PROVINCIA",""));
        }
      }
      m_bpassedw_CAP = source.Has("w_CAP");
      if (m_bpassedw_CAP) {
        w_CAP = source.GetParameter("w_CAP",source.GetParameter("CAP",""));
      } else {
        if (source.IsForwarded()) {
          w_CAP = source.GetCaller().GetString("CAP","C",9,0);
          m_bpassedw_CAP = true;
        } else {
          w_CAP = source.GetParameter("CAP",source.GetParameter("w_CAP",""));
        }
      }
      m_bpassedw_CODCAB = source.Has("w_CODCAB");
      if (m_bpassedw_CODCAB) {
        w_CODCAB = source.GetParameter("w_CODCAB",source.GetParameter("CODCAB",""));
      } else {
        if (source.IsForwarded()) {
          w_CODCAB = source.GetCaller().GetString("CODCAB","C",6,0);
          m_bpassedw_CODCAB = true;
        } else {
          w_CODCAB = source.GetParameter("CODCAB",source.GetParameter("w_CODCAB",""));
        }
      }
      m_bpassedw_DOMICILIO = source.Has("w_DOMICILIO");
      if (m_bpassedw_DOMICILIO) {
        w_DOMICILIO = source.GetParameter("w_DOMICILIO",source.GetParameter("DOMICILIO",""));
      } else {
        if (source.IsForwarded()) {
          w_DOMICILIO = source.GetCaller().GetString("DOMICILIO","C",35,0);
          m_bpassedw_DOMICILIO = true;
        } else {
          w_DOMICILIO = source.GetParameter("DOMICILIO",source.GetParameter("w_DOMICILIO",""));
        }
      }
      m_bpassedw_PAESE = source.Has("w_PAESE");
      if (m_bpassedw_PAESE) {
        w_PAESE = source.GetParameter("w_PAESE",source.GetParameter("PAESE",""));
      } else {
        if (source.IsForwarded()) {
          w_PAESE = source.GetCaller().GetString("PAESE","C",3,0);
          m_bpassedw_PAESE = true;
        } else {
          w_PAESE = source.GetParameter("PAESE",source.GetParameter("w_PAESE",""));
        }
      }
      m_bpassedw_NASCOMUN = source.Has("w_NASCOMUN");
      if (m_bpassedw_NASCOMUN) {
        w_NASCOMUN = source.GetParameter("w_NASCOMUN",source.GetParameter("NASCOMUN",""));
      } else {
        if (source.IsForwarded()) {
          w_NASCOMUN = source.GetCaller().GetString("NASCOMUN","C",30,0);
          m_bpassedw_NASCOMUN = true;
        } else {
          w_NASCOMUN = source.GetParameter("NASCOMUN",source.GetParameter("w_NASCOMUN",""));
        }
      }
      m_bpassedw_TIPINTER = source.Has("w_TIPINTER");
      if (m_bpassedw_TIPINTER) {
        w_TIPINTER = source.GetParameter("w_TIPINTER",source.GetParameter("TIPINTER",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPINTER = source.GetCaller().GetString("TIPINTER","C",2,0);
          m_bpassedw_TIPINTER = true;
        } else {
          w_TIPINTER = source.GetParameter("TIPINTER",source.GetParameter("w_TIPINTER",""));
        }
      }
      m_bpassedw_SESSO = source.Has("w_SESSO");
      if (m_bpassedw_SESSO) {
        w_SESSO = source.GetParameter("w_SESSO",source.GetParameter("SESSO",""));
      } else {
        if (source.IsForwarded()) {
          w_SESSO = source.GetCaller().GetString("SESSO","C",1,0);
          m_bpassedw_SESSO = true;
        } else {
          w_SESSO = source.GetParameter("SESSO",source.GetParameter("w_SESSO",""));
        }
      }
      m_bpassedw_NASSTATO = source.Has("w_NASSTATO");
      if (m_bpassedw_NASSTATO) {
        w_NASSTATO = source.GetParameter("w_NASSTATO",source.GetParameter("NASSTATO",""));
      } else {
        if (source.IsForwarded()) {
          w_NASSTATO = source.GetCaller().GetString("NASSTATO","C",30,0);
          m_bpassedw_NASSTATO = true;
        } else {
          w_NASSTATO = source.GetParameter("NASSTATO",source.GetParameter("w_NASSTATO",""));
        }
      }
      m_bpassedw_DATANASC = source.Has("w_DATANASC");
      if (m_bpassedw_DATANASC) {
        w_DATANASC = source.GetParameter("w_DATANASC",source.GetParameter("DATANASC",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATANASC = source.GetCaller().GetDate("DATANASC","D",8,0);
          m_bpassedw_DATANASC = true;
        } else {
          w_DATANASC = source.GetParameter("DATANASC",source.GetParameter("w_DATANASC",CPLib.NullDate()));
        }
      }
      m_bpassedw_TIPODOC = source.Has("w_TIPODOC");
      if (m_bpassedw_TIPODOC) {
        w_TIPODOC = source.GetParameter("w_TIPODOC",source.GetParameter("TIPODOC",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPODOC = source.GetCaller().GetString("TIPODOC","C",2,0);
          m_bpassedw_TIPODOC = true;
        } else {
          w_TIPODOC = source.GetParameter("TIPODOC",source.GetParameter("w_TIPODOC",""));
        }
      }
      m_bpassedw_NUMDOCUM = source.Has("w_NUMDOCUM");
      if (m_bpassedw_NUMDOCUM) {
        w_NUMDOCUM = source.GetParameter("w_NUMDOCUM",source.GetParameter("NUMDOCUM",""));
      } else {
        if (source.IsForwarded()) {
          w_NUMDOCUM = source.GetCaller().GetString("NUMDOCUM","C",15,0);
          m_bpassedw_NUMDOCUM = true;
        } else {
          w_NUMDOCUM = source.GetParameter("NUMDOCUM",source.GetParameter("w_NUMDOCUM",""));
        }
      }
      m_bpassedw_DATARILASC = source.Has("w_DATARILASC");
      if (m_bpassedw_DATARILASC) {
        w_DATARILASC = source.GetParameter("w_DATARILASC",source.GetParameter("DATARILASC",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATARILASC = source.GetCaller().GetDate("DATARILASC","D",8,0);
          m_bpassedw_DATARILASC = true;
        } else {
          w_DATARILASC = source.GetParameter("DATARILASC",source.GetParameter("w_DATARILASC",CPLib.NullDate()));
        }
      }
      m_bpassedw_DATAVALI = source.Has("w_DATAVALI");
      if (m_bpassedw_DATAVALI) {
        w_DATAVALI = source.GetParameter("w_DATAVALI",source.GetParameter("DATAVALI",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATAVALI = source.GetCaller().GetDate("DATAVALI","D",8,0);
          m_bpassedw_DATAVALI = true;
        } else {
          w_DATAVALI = source.GetParameter("DATAVALI",source.GetParameter("w_DATAVALI",CPLib.NullDate()));
        }
      }
      m_bpassedw_AUTRILASC = source.Has("w_AUTRILASC");
      if (m_bpassedw_AUTRILASC) {
        w_AUTRILASC = source.GetParameter("w_AUTRILASC",source.GetParameter("AUTRILASC",""));
      } else {
        if (source.IsForwarded()) {
          w_AUTRILASC = source.GetCaller().GetString("AUTRILASC","C",30,0);
          m_bpassedw_AUTRILASC = true;
        } else {
          w_AUTRILASC = source.GetParameter("AUTRILASC",source.GetParameter("w_AUTRILASC",""));
        }
      }
      m_bpassedw_SOTGRUP = source.Has("w_SOTGRUP");
      if (m_bpassedw_SOTGRUP) {
        w_SOTGRUP = source.GetParameter("w_SOTGRUP",source.GetParameter("SOTGRUP",""));
      } else {
        if (source.IsForwarded()) {
          w_SOTGRUP = source.GetCaller().GetString("SOTGRUP","C",3,0);
          m_bpassedw_SOTGRUP = true;
        } else {
          w_SOTGRUP = source.GetParameter("SOTGRUP",source.GetParameter("w_SOTGRUP",""));
        }
      }
      m_bpassedw_RAMOGRUP = source.Has("w_RAMOGRUP");
      if (m_bpassedw_RAMOGRUP) {
        w_RAMOGRUP = source.GetParameter("w_RAMOGRUP",source.GetParameter("RAMOGRUP",""));
      } else {
        if (source.IsForwarded()) {
          w_RAMOGRUP = source.GetCaller().GetString("RAMOGRUP","C",3,0);
          m_bpassedw_RAMOGRUP = true;
        } else {
          w_RAMOGRUP = source.GetParameter("RAMOGRUP",source.GetParameter("w_RAMOGRUP",""));
        }
      }
      m_bpassedw_SETTSINT = source.Has("w_SETTSINT");
      if (m_bpassedw_SETTSINT) {
        w_SETTSINT = source.GetParameter("w_SETTSINT",source.GetParameter("SETTSINT",""));
      } else {
        if (source.IsForwarded()) {
          w_SETTSINT = source.GetCaller().GetString("SETTSINT","C",3,0);
          m_bpassedw_SETTSINT = true;
        } else {
          w_SETTSINT = source.GetParameter("SETTSINT",source.GetParameter("w_SETTSINT",""));
        }
      }
      m_bpassedw_PEP = source.Has("w_PEP");
      if (m_bpassedw_PEP) {
        w_PEP = source.GetParameter("w_PEP",source.GetParameter("PEP",""));
      } else {
        if (source.IsForwarded()) {
          w_PEP = source.GetCaller().GetString("PEP","C",1,0);
          m_bpassedw_PEP = true;
        } else {
          w_PEP = source.GetParameter("PEP",source.GetParameter("w_PEP",""));
        }
      }
      m_bpassedw_SNAINUMOPE = source.Has("w_SNAINUMOPE");
      if (m_bpassedw_SNAINUMOPE) {
        w_SNAINUMOPE = source.GetParameter("w_SNAINUMOPE",source.GetParameter("SNAINUMOPE",""));
      } else {
        if (source.IsForwarded()) {
          w_SNAINUMOPE = source.GetCaller().GetString("SNAINUMOPE","C",15,0);
          m_bpassedw_SNAINUMOPE = true;
        } else {
          w_SNAINUMOPE = source.GetParameter("SNAINUMOPE",source.GetParameter("w_SNAINUMOPE",""));
        }
      }
      m_bpassedw_DATAOPE = source.Has("w_DATAOPE");
      if (m_bpassedw_DATAOPE) {
        w_DATAOPE = source.GetParameter("w_DATAOPE",source.GetParameter("DATAOPE",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATAOPE = source.GetCaller().GetDate("DATAOPE","D",8,0);
          m_bpassedw_DATAOPE = true;
        } else {
          w_DATAOPE = source.GetParameter("DATAOPE",source.GetParameter("w_DATAOPE",CPLib.NullDate()));
        }
      }
      m_bpassedw_DATAREG = source.Has("w_DATAREG");
      if (m_bpassedw_DATAREG) {
        w_DATAREG = source.GetParameter("w_DATAREG",source.GetParameter("DATAREG",CPLib.NullDate()));
      } else {
        if (source.IsForwarded()) {
          w_DATAREG = source.GetCaller().GetDate("DATAREG","D",8,0);
          m_bpassedw_DATAREG = true;
        } else {
          w_DATAREG = source.GetParameter("DATAREG",source.GetParameter("w_DATAREG",CPLib.NullDate()));
        }
      }
      m_bpassedw_FLAGCONT = source.Has("w_FLAGCONT");
      if (m_bpassedw_FLAGCONT) {
        w_FLAGCONT = source.GetParameter("w_FLAGCONT",source.GetParameter("FLAGCONT",""));
      } else {
        if (source.IsForwarded()) {
          w_FLAGCONT = source.GetCaller().GetString("FLAGCONT","C",1,0);
          m_bpassedw_FLAGCONT = true;
        } else {
          w_FLAGCONT = source.GetParameter("FLAGCONT",source.GetParameter("w_FLAGCONT",""));
        }
      }
      m_bpassedw_TIPOOPRAP = source.Has("w_TIPOOPRAP");
      if (m_bpassedw_TIPOOPRAP) {
        w_TIPOOPRAP = source.GetParameter("w_TIPOOPRAP",source.GetParameter("TIPOOPRAP",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPOOPRAP = source.GetCaller().GetString("TIPOOPRAP","C",2,0);
          m_bpassedw_TIPOOPRAP = true;
        } else {
          w_TIPOOPRAP = source.GetParameter("TIPOOPRAP",source.GetParameter("w_TIPOOPRAP",""));
        }
      }
      m_bpassedw_CODANA = source.Has("w_CODANA");
      if (m_bpassedw_CODANA) {
        w_CODANA = source.GetParameter("w_CODANA",source.GetParameter("CODANA",""));
      } else {
        if (source.IsForwarded()) {
          w_CODANA = source.GetCaller().GetString("CODANA","C",4,0);
          m_bpassedw_CODANA = true;
        } else {
          w_CODANA = source.GetParameter("CODANA",source.GetParameter("w_CODANA",""));
        }
      }
      m_bpassedw_CODVOC = source.Has("w_CODVOC");
      if (m_bpassedw_CODVOC) {
        w_CODVOC = source.GetParameter("w_CODVOC",source.GetParameter("CODVOC",""));
      } else {
        if (source.IsForwarded()) {
          w_CODVOC = source.GetCaller().GetString("CODVOC","C",2,0);
          m_bpassedw_CODVOC = true;
        } else {
          w_CODVOC = source.GetParameter("CODVOC",source.GetParameter("w_CODVOC",""));
        }
      }
      m_bpassedw_VALUTA = source.Has("w_VALUTA");
      if (m_bpassedw_VALUTA) {
        w_VALUTA = source.GetParameter("w_VALUTA",source.GetParameter("VALUTA",""));
      } else {
        if (source.IsForwarded()) {
          w_VALUTA = source.GetCaller().GetString("VALUTA","C",3,0);
          m_bpassedw_VALUTA = true;
        } else {
          w_VALUTA = source.GetParameter("VALUTA",source.GetParameter("w_VALUTA",""));
        }
      }
      m_bpassedw_CAMBIO = source.Has("w_CAMBIO");
      if (m_bpassedw_CAMBIO) {
        w_CAMBIO = source.GetParameter("w_CAMBIO",source.GetParameter("CAMBIO",0));
      } else {
        if (source.IsForwarded()) {
          w_CAMBIO = source.GetCaller().GetNumber("CAMBIO","N",9,4);
          m_bpassedw_CAMBIO = true;
        } else {
          w_CAMBIO = source.GetParameter("CAMBIO",source.GetParameter("w_CAMBIO",0));
        }
      }
      m_bpassedw_CONNESCLI = source.Has("w_CONNESCLI");
      if (m_bpassedw_CONNESCLI) {
        w_CONNESCLI = source.GetParameter("w_CONNESCLI",source.GetParameter("CONNESCLI",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNESCLI = source.GetCaller().GetString("CONNESCLI","C",16,0);
          m_bpassedw_CONNESCLI = true;
        } else {
          w_CONNESCLI = source.GetParameter("CONNESCLI",source.GetParameter("w_CONNESCLI",""));
        }
      }
      m_bpassedw_CONNESBEN = source.Has("w_CONNESBEN");
      if (m_bpassedw_CONNESBEN) {
        w_CONNESBEN = source.GetParameter("w_CONNESBEN",source.GetParameter("CONNESBEN",""));
      } else {
        if (source.IsForwarded()) {
          w_CONNESBEN = source.GetCaller().GetString("CONNESBEN","C",16,0);
          m_bpassedw_CONNESBEN = true;
        } else {
          w_CONNESBEN = source.GetParameter("CONNESBEN",source.GetParameter("w_CONNESBEN",""));
        }
      }
      m_bpassedw_C_RAG = source.Has("w_C_RAG");
      if (m_bpassedw_C_RAG) {
        w_C_RAG = source.GetParameter("w_C_RAG",source.GetParameter("C_RAG",""));
      } else {
        if (source.IsForwarded()) {
          w_C_RAG = source.GetCaller().GetString("C_RAG","C",70,0);
          m_bpassedw_C_RAG = true;
        } else {
          w_C_RAG = source.GetParameter("C_RAG",source.GetParameter("w_C_RAG",""));
        }
      }
      m_bpassedw_C_CTA = source.Has("w_C_CTA");
      if (m_bpassedw_C_CTA) {
        w_C_CTA = source.GetParameter("w_C_CTA",source.GetParameter("C_CTA",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CTA = source.GetCaller().GetString("C_CTA","C",30,0);
          m_bpassedw_C_CTA = true;
        } else {
          w_C_CTA = source.GetParameter("C_CTA",source.GetParameter("w_C_CTA",""));
        }
      }
      m_bpassedw_C_PRV = source.Has("w_C_PRV");
      if (m_bpassedw_C_PRV) {
        w_C_PRV = source.GetParameter("w_C_PRV",source.GetParameter("C_PRV",""));
      } else {
        if (source.IsForwarded()) {
          w_C_PRV = source.GetCaller().GetString("C_PRV","C",2,0);
          m_bpassedw_C_PRV = true;
        } else {
          w_C_PRV = source.GetParameter("C_PRV",source.GetParameter("w_C_PRV",""));
        }
      }
      m_bpassedw_C_CAP = source.Has("w_C_CAP");
      if (m_bpassedw_C_CAP) {
        w_C_CAP = source.GetParameter("w_C_CAP",source.GetParameter("C_CAP",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CAP = source.GetCaller().GetString("C_CAP","C",5,0);
          m_bpassedw_C_CAP = true;
        } else {
          w_C_CAP = source.GetParameter("C_CAP",source.GetParameter("w_C_CAP",""));
        }
      }
      m_bpassedw_C_CAB = source.Has("w_C_CAB");
      if (m_bpassedw_C_CAB) {
        w_C_CAB = source.GetParameter("w_C_CAB",source.GetParameter("C_CAB",""));
      } else {
        if (source.IsForwarded()) {
          w_C_CAB = source.GetCaller().GetString("C_CAB","C",6,0);
          m_bpassedw_C_CAB = true;
        } else {
          w_C_CAB = source.GetParameter("C_CAB",source.GetParameter("w_C_CAB",""));
        }
      }
      m_bpassedw_C_IND = source.Has("w_C_IND");
      if (m_bpassedw_C_IND) {
        w_C_IND = source.GetParameter("w_C_IND",source.GetParameter("C_IND",""));
      } else {
        if (source.IsForwarded()) {
          w_C_IND = source.GetCaller().GetString("C_IND","C",35,0);
          m_bpassedw_C_IND = true;
        } else {
          w_C_IND = source.GetParameter("C_IND",source.GetParameter("w_C_IND",""));
        }
      }
      m_bpassedw_C_STA = source.Has("w_C_STA");
      if (m_bpassedw_C_STA) {
        w_C_STA = source.GetParameter("w_C_STA",source.GetParameter("C_STA",""));
      } else {
        if (source.IsForwarded()) {
          w_C_STA = source.GetCaller().GetString("C_STA","C",3,0);
          m_bpassedw_C_STA = true;
        } else {
          w_C_STA = source.GetParameter("C_STA",source.GetParameter("w_C_STA",""));
        }
      }
      m_bpassedw_CODINTER = source.Has("w_CODINTER");
      if (m_bpassedw_CODINTER) {
        w_CODINTER = source.GetParameter("w_CODINTER",source.GetParameter("CODINTER",""));
      } else {
        if (source.IsForwarded()) {
          w_CODINTER = source.GetCaller().GetString("CODINTER","C",11,0);
          m_bpassedw_CODINTER = true;
        } else {
          w_CODINTER = source.GetParameter("CODINTER",source.GetParameter("w_CODINTER",""));
        }
      }
      m_bpassedw_CODDIPE = source.Has("w_CODDIPE");
      if (m_bpassedw_CODDIPE) {
        w_CODDIPE = source.GetParameter("w_CODDIPE",source.GetParameter("CODDIPE",""));
      } else {
        if (source.IsForwarded()) {
          w_CODDIPE = source.GetCaller().GetString("CODDIPE","C",6,0);
          m_bpassedw_CODDIPE = true;
        } else {
          w_CODDIPE = source.GetParameter("CODDIPE",source.GetParameter("w_CODDIPE",""));
        }
      }
      m_bpassedw_DESCCITDIP = source.Has("w_DESCCITDIP");
      if (m_bpassedw_DESCCITDIP) {
        w_DESCCITDIP = source.GetParameter("w_DESCCITDIP",source.GetParameter("DESCCITDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCCITDIP = source.GetCaller().GetString("DESCCITDIP","C",30,0);
          m_bpassedw_DESCCITDIP = true;
        } else {
          w_DESCCITDIP = source.GetParameter("DESCCITDIP",source.GetParameter("w_DESCCITDIP",""));
        }
      }
      m_bpassedw_SEGNO = source.Has("w_SEGNO");
      if (m_bpassedw_SEGNO) {
        w_SEGNO = source.GetParameter("w_SEGNO",source.GetParameter("SEGNO",""));
      } else {
        if (source.IsForwarded()) {
          w_SEGNO = source.GetCaller().GetString("SEGNO","C",1,0);
          m_bpassedw_SEGNO = true;
        } else {
          w_SEGNO = source.GetParameter("SEGNO",source.GetParameter("w_SEGNO",""));
        }
      }
      m_bpassedw_FLAGFRAZ = source.Has("w_FLAGFRAZ");
      if (m_bpassedw_FLAGFRAZ) {
        w_FLAGFRAZ = source.GetParameter("w_FLAGFRAZ",source.GetParameter("FLAGFRAZ",""));
      } else {
        if (source.IsForwarded()) {
          w_FLAGFRAZ = source.GetCaller().GetString("FLAGFRAZ","C",1,0);
          m_bpassedw_FLAGFRAZ = true;
        } else {
          w_FLAGFRAZ = source.GetParameter("FLAGFRAZ",source.GetParameter("w_FLAGFRAZ",""));
        }
      }
      m_bpassedw_COLLEG = source.Has("w_COLLEG");
      if (m_bpassedw_COLLEG) {
        w_COLLEG = source.GetParameter("w_COLLEG",source.GetParameter("COLLEG",""));
      } else {
        if (source.IsForwarded()) {
          w_COLLEG = source.GetCaller().GetString("COLLEG","C",11,0);
          m_bpassedw_COLLEG = true;
        } else {
          w_COLLEG = source.GetParameter("COLLEG",source.GetParameter("w_COLLEG",""));
        }
      }
      m_bpassedw_PROVINCIADIP = source.Has("w_PROVINCIADIP");
      if (m_bpassedw_PROVINCIADIP) {
        w_PROVINCIADIP = source.GetParameter("w_PROVINCIADIP",source.GetParameter("PROVINCIADIP",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVINCIADIP = source.GetCaller().GetString("PROVINCIADIP","C",2,0);
          m_bpassedw_PROVINCIADIP = true;
        } else {
          w_PROVINCIADIP = source.GetParameter("PROVINCIADIP",source.GetParameter("w_PROVINCIADIP",""));
        }
      }
      m_bpassedw_CODCABDIP = source.Has("w_CODCABDIP");
      if (m_bpassedw_CODCABDIP) {
        w_CODCABDIP = source.GetParameter("w_CODCABDIP",source.GetParameter("CODCABDIP",""));
      } else {
        if (source.IsForwarded()) {
          w_CODCABDIP = source.GetCaller().GetString("CODCABDIP","C",6,0);
          m_bpassedw_CODCABDIP = true;
        } else {
          w_CODCABDIP = source.GetParameter("CODCABDIP",source.GetParameter("w_CODCABDIP",""));
        }
      }
      m_bpassedw_TOTLIRE = source.Has("w_TOTLIRE");
      if (m_bpassedw_TOTLIRE) {
        w_TOTLIRE = source.GetParameter("w_TOTLIRE",source.GetParameter("TOTLIRE",0));
      } else {
        if (source.IsForwarded()) {
          w_TOTLIRE = source.GetCaller().GetNumber("TOTLIRE","N",15,2);
          m_bpassedw_TOTLIRE = true;
        } else {
          w_TOTLIRE = source.GetParameter("TOTLIRE",source.GetParameter("w_TOTLIRE",0));
        }
      }
      m_bpassedw_TOTCONT = source.Has("w_TOTCONT");
      if (m_bpassedw_TOTCONT) {
        w_TOTCONT = source.GetParameter("w_TOTCONT",source.GetParameter("TOTCONT",0));
      } else {
        if (source.IsForwarded()) {
          w_TOTCONT = source.GetCaller().GetNumber("TOTCONT","N",15,2);
          m_bpassedw_TOTCONT = true;
        } else {
          w_TOTCONT = source.GetParameter("TOTCONT",source.GetParameter("w_TOTCONT",0));
        }
      }
      m_bpassedw_CACODICE = source.Has("w_CACODICE");
      if (m_bpassedw_CACODICE) {
        w_CACODICE = source.GetParameter("w_CACODICE",source.GetParameter("CACODICE",0));
      } else {
        if (source.IsForwarded()) {
          w_CACODICE = source.GetCaller().GetNumber("CACODICE","N",5,0);
          m_bpassedw_CACODICE = true;
        } else {
          w_CACODICE = source.GetParameter("CACODICE",source.GetParameter("w_CACODICE",0));
        }
      }
      m_bpassedw_CAIDBIGLIETTO = source.Has("w_CAIDBIGLIETTO");
      if (m_bpassedw_CAIDBIGLIETTO) {
        w_CAIDBIGLIETTO = source.GetParameter("w_CAIDBIGLIETTO",source.GetParameter("CAIDBIGLIETTO",""));
      } else {
        if (source.IsForwarded()) {
          w_CAIDBIGLIETTO = source.GetCaller().GetString("CAIDBIGLIETTO","C",30,0);
          m_bpassedw_CAIDBIGLIETTO = true;
        } else {
          w_CAIDBIGLIETTO = source.GetParameter("CAIDBIGLIETTO",source.GetParameter("w_CAIDBIGLIETTO",""));
        }
      }
      m_bpassedw_CAFLGOPE = source.Has("w_CAFLGOPE");
      if (m_bpassedw_CAFLGOPE) {
        w_CAFLGOPE = source.GetParameter("w_CAFLGOPE",source.GetParameter("CAFLGOPE",""));
      } else {
        if (source.IsForwarded()) {
          w_CAFLGOPE = source.GetCaller().GetString("CAFLGOPE","C",1,0);
          m_bpassedw_CAFLGOPE = true;
        } else {
          w_CAFLGOPE = source.GetParameter("CAFLGOPE",source.GetParameter("w_CAFLGOPE",""));
        }
      }
      m_bpassedw_ATTIV = source.Has("w_ATTIV");
      if (m_bpassedw_ATTIV) {
        w_ATTIV = source.GetParameter("w_ATTIV",source.GetParameter("ATTIV",""));
      } else {
        if (source.IsForwarded()) {
          w_ATTIV = source.GetCaller().GetString("ATTIV","C",10,0);
          m_bpassedw_ATTIV = true;
        } else {
          w_ATTIV = source.GetParameter("ATTIV",source.GetParameter("w_ATTIV",""));
        }
      }
      m_bpassedw_MIDBIGLIETTO = source.Has("w_MIDBIGLIETTO");
      if (m_bpassedw_MIDBIGLIETTO) {
        w_MIDBIGLIETTO = source.GetParameter("w_MIDBIGLIETTO",source.GetParameter("MIDBIGLIETTO",""));
      } else {
        if (source.IsForwarded()) {
          w_MIDBIGLIETTO = source.GetCaller().GetString("MIDBIGLIETTO","M",10,0);
          m_bpassedw_MIDBIGLIETTO = true;
        } else {
          w_MIDBIGLIETTO = source.GetParameter("MIDBIGLIETTO",source.GetParameter("w_MIDBIGLIETTO",""));
        }
      }
      m_bpassedw_MIDBIGLIETTO1 = source.Has("w_MIDBIGLIETTO1");
      if (m_bpassedw_MIDBIGLIETTO1) {
        w_MIDBIGLIETTO1 = source.GetParameter("w_MIDBIGLIETTO1",source.GetParameter("MIDBIGLIETTO1",""));
      } else {
        if (source.IsForwarded()) {
          w_MIDBIGLIETTO1 = source.GetCaller().GetString("MIDBIGLIETTO1","M",10,0);
          m_bpassedw_MIDBIGLIETTO1 = true;
        } else {
          w_MIDBIGLIETTO1 = source.GetParameter("MIDBIGLIETTO1",source.GetParameter("w_MIDBIGLIETTO1",""));
        }
      }
      m_bpassedw_MIDBIGLIETTO2 = source.Has("w_MIDBIGLIETTO2");
      if (m_bpassedw_MIDBIGLIETTO2) {
        w_MIDBIGLIETTO2 = source.GetParameter("w_MIDBIGLIETTO2",source.GetParameter("MIDBIGLIETTO2",""));
      } else {
        if (source.IsForwarded()) {
          w_MIDBIGLIETTO2 = source.GetCaller().GetString("MIDBIGLIETTO2","M",10,0);
          m_bpassedw_MIDBIGLIETTO2 = true;
        } else {
          w_MIDBIGLIETTO2 = source.GetParameter("MIDBIGLIETTO2",source.GetParameter("w_MIDBIGLIETTO2",""));
        }
      }
      m_bpassedw_MIDBIGLIETTO3 = source.Has("w_MIDBIGLIETTO3");
      if (m_bpassedw_MIDBIGLIETTO3) {
        w_MIDBIGLIETTO3 = source.GetParameter("w_MIDBIGLIETTO3",source.GetParameter("MIDBIGLIETTO3",""));
      } else {
        if (source.IsForwarded()) {
          w_MIDBIGLIETTO3 = source.GetCaller().GetString("MIDBIGLIETTO3","M",10,0);
          m_bpassedw_MIDBIGLIETTO3 = true;
        } else {
          w_MIDBIGLIETTO3 = source.GetParameter("MIDBIGLIETTO3",source.GetParameter("w_MIDBIGLIETTO3",""));
        }
      }
      m_bpassedw_MIDBIGLIETTO4 = source.Has("w_MIDBIGLIETTO4");
      if (m_bpassedw_MIDBIGLIETTO4) {
        w_MIDBIGLIETTO4 = source.GetParameter("w_MIDBIGLIETTO4",source.GetParameter("MIDBIGLIETTO4",""));
      } else {
        if (source.IsForwarded()) {
          w_MIDBIGLIETTO4 = source.GetCaller().GetString("MIDBIGLIETTO4","M",10,0);
          m_bpassedw_MIDBIGLIETTO4 = true;
        } else {
          w_MIDBIGLIETTO4 = source.GetParameter("MIDBIGLIETTO4",source.GetParameter("w_MIDBIGLIETTO4",""));
        }
      }
      m_bpassedw_ASSEGNO = source.Has("w_ASSEGNO");
      if (m_bpassedw_ASSEGNO) {
        w_ASSEGNO = source.GetParameter("w_ASSEGNO",source.GetParameter("ASSEGNO",""));
      } else {
        if (source.IsForwarded()) {
          w_ASSEGNO = source.GetCaller().GetString("ASSEGNO","C",25,0);
          m_bpassedw_ASSEGNO = true;
        } else {
          w_ASSEGNO = source.GetParameter("ASSEGNO",source.GetParameter("w_ASSEGNO",""));
        }
      }
      m_bpassedw_VLTPLAT = source.Has("w_VLTPLAT");
      if (m_bpassedw_VLTPLAT) {
        w_VLTPLAT = source.GetParameter("w_VLTPLAT",source.GetParameter("VLTPLAT",""));
      } else {
        if (source.IsForwarded()) {
          w_VLTPLAT = source.GetCaller().GetString("VLTPLAT","C",2,0);
          m_bpassedw_VLTPLAT = true;
        } else {
          w_VLTPLAT = source.GetParameter("VLTPLAT",source.GetParameter("w_VLTPLAT",""));
        }
      }
      m_bpassedw_CC4CIFRE = source.Has("w_CC4CIFRE");
      if (m_bpassedw_CC4CIFRE) {
        w_CC4CIFRE = source.GetParameter("w_CC4CIFRE",source.GetParameter("CC4CIFRE",""));
      } else {
        if (source.IsForwarded()) {
          w_CC4CIFRE = source.GetCaller().GetString("CC4CIFRE","C",4,0);
          m_bpassedw_CC4CIFRE = true;
        } else {
          w_CC4CIFRE = source.GetParameter("CC4CIFRE",source.GetParameter("w_CC4CIFRE",""));
        }
      }
      m_bpassedw_CCDATSCA = source.Has("w_CCDATSCA");
      if (m_bpassedw_CCDATSCA) {
        w_CCDATSCA = source.GetParameter("w_CCDATSCA",source.GetParameter("CCDATSCA",""));
      } else {
        if (source.IsForwarded()) {
          w_CCDATSCA = source.GetCaller().GetString("CCDATSCA","C",7,0);
          m_bpassedw_CCDATSCA = true;
        } else {
          w_CCDATSCA = source.GetParameter("CCDATSCA",source.GetParameter("w_CCDATSCA",""));
        }
      }
      m_bpassedw_NUMTEL = source.Has("w_NUMTEL");
      if (m_bpassedw_NUMTEL) {
        w_NUMTEL = source.GetParameter("w_NUMTEL",source.GetParameter("NUMTEL",""));
      } else {
        if (source.IsForwarded()) {
          w_NUMTEL = source.GetCaller().GetString("NUMTEL","C",20,0);
          m_bpassedw_NUMTEL = true;
        } else {
          w_NUMTEL = source.GetParameter("NUMTEL",source.GetParameter("w_NUMTEL",""));
        }
      }
      m_bpassedw_TIPOGIOCO = source.Has("w_TIPOGIOCO");
      if (m_bpassedw_TIPOGIOCO) {
        w_TIPOGIOCO = source.GetParameter("w_TIPOGIOCO",source.GetParameter("TIPOGIOCO",""));
      } else {
        if (source.IsForwarded()) {
          w_TIPOGIOCO = source.GetCaller().GetString("TIPOGIOCO","C",3,0);
          m_bpassedw_TIPOGIOCO = true;
        } else {
          w_TIPOGIOCO = source.GetParameter("TIPOGIOCO",source.GetParameter("w_TIPOGIOCO",""));
        }
      }
      m_bpassedw_RDCODAUT = source.Has("w_RDCODAUT");
      if (m_bpassedw_RDCODAUT) {
        w_RDCODAUT = source.GetParameter("w_RDCODAUT",source.GetParameter("RDCODAUT",""));
      } else {
        if (source.IsForwarded()) {
          w_RDCODAUT = source.GetCaller().GetString("RDCODAUT","C",2,0);
          m_bpassedw_RDCODAUT = true;
        } else {
          w_RDCODAUT = source.GetParameter("RDCODAUT",source.GetParameter("w_RDCODAUT",""));
        }
      }
      m_bpassedw_RDLOCAUT = source.Has("w_RDLOCAUT");
      if (m_bpassedw_RDLOCAUT) {
        w_RDLOCAUT = source.GetParameter("w_RDLOCAUT",source.GetParameter("RDLOCAUT",""));
      } else {
        if (source.IsForwarded()) {
          w_RDLOCAUT = source.GetCaller().GetString("RDLOCAUT","C",20,0);
          m_bpassedw_RDLOCAUT = true;
        } else {
          w_RDLOCAUT = source.GetParameter("RDLOCAUT",source.GetParameter("w_RDLOCAUT",""));
        }
      }
      m_bpassedw_CGOFLGVLT = source.Has("w_CGOFLGVLT");
      if (m_bpassedw_CGOFLGVLT) {
        w_CGOFLGVLT = source.GetParameter("w_CGOFLGVLT",source.GetParameter("CGOFLGVLT",""));
      } else {
        if (source.IsForwarded()) {
          w_CGOFLGVLT = source.GetCaller().GetString("CGOFLGVLT","C",1,0);
          m_bpassedw_CGOFLGVLT = true;
        } else {
          w_CGOFLGVLT = source.GetParameter("CGOFLGVLT",source.GetParameter("w_CGOFLGVLT",""));
        }
      }
      m_bpassedw_PEPDESCRI = source.Has("w_PEPDESCRI");
      if (m_bpassedw_PEPDESCRI) {
        w_PEPDESCRI = source.GetParameter("w_PEPDESCRI",source.GetParameter("PEPDESCRI",""));
      } else {
        if (source.IsForwarded()) {
          w_PEPDESCRI = source.GetCaller().GetString("PEPDESCRI","C",80,0);
          m_bpassedw_PEPDESCRI = true;
        } else {
          w_PEPDESCRI = source.GetParameter("PEPDESCRI",source.GetParameter("w_PEPDESCRI",""));
        }
      }
      m_bpassedw_FLGDOM = source.Has("w_FLGDOM");
      if (m_bpassedw_FLGDOM) {
        w_FLGDOM = source.GetParameter("w_FLGDOM",source.GetParameter("FLGDOM",""));
      } else {
        if (source.IsForwarded()) {
          w_FLGDOM = source.GetCaller().GetString("FLGDOM","C",1,0);
          m_bpassedw_FLGDOM = true;
        } else {
          w_FLGDOM = source.GetParameter("FLGDOM",source.GetParameter("w_FLGDOM",""));
        }
      }
      m_bpassedw_PAESE2 = source.Has("w_PAESE2");
      if (m_bpassedw_PAESE2) {
        w_PAESE2 = source.GetParameter("w_PAESE2",source.GetParameter("PAESE2",""));
      } else {
        if (source.IsForwarded()) {
          w_PAESE2 = source.GetCaller().GetString("PAESE2","C",3,0);
          m_bpassedw_PAESE2 = true;
        } else {
          w_PAESE2 = source.GetParameter("PAESE2",source.GetParameter("w_PAESE2",""));
        }
      }
      m_bpassedw_DOMICILIO2 = source.Has("w_DOMICILIO2");
      if (m_bpassedw_DOMICILIO2) {
        w_DOMICILIO2 = source.GetParameter("w_DOMICILIO2",source.GetParameter("DOMICILIO2",""));
      } else {
        if (source.IsForwarded()) {
          w_DOMICILIO2 = source.GetCaller().GetString("DOMICILIO2","C",35,0);
          m_bpassedw_DOMICILIO2 = true;
        } else {
          w_DOMICILIO2 = source.GetParameter("DOMICILIO2",source.GetParameter("w_DOMICILIO2",""));
        }
      }
      m_bpassedw_PROVINCIA2 = source.Has("w_PROVINCIA2");
      if (m_bpassedw_PROVINCIA2) {
        w_PROVINCIA2 = source.GetParameter("w_PROVINCIA2",source.GetParameter("PROVINCIA2",""));
      } else {
        if (source.IsForwarded()) {
          w_PROVINCIA2 = source.GetCaller().GetString("PROVINCIA2","C",2,0);
          m_bpassedw_PROVINCIA2 = true;
        } else {
          w_PROVINCIA2 = source.GetParameter("PROVINCIA2",source.GetParameter("w_PROVINCIA2",""));
        }
      }
      m_bpassedw_DESCCIT2 = source.Has("w_DESCCIT2");
      if (m_bpassedw_DESCCIT2) {
        w_DESCCIT2 = source.GetParameter("w_DESCCIT2",source.GetParameter("DESCCIT2",""));
      } else {
        if (source.IsForwarded()) {
          w_DESCCIT2 = source.GetCaller().GetString("DESCCIT2","C",40,0);
          m_bpassedw_DESCCIT2 = true;
        } else {
          w_DESCCIT2 = source.GetParameter("DESCCIT2",source.GetParameter("w_DESCCIT2",""));
        }
      }
      m_bpassedw_CAP2 = source.Has("w_CAP2");
      if (m_bpassedw_CAP2) {
        w_CAP2 = source.GetParameter("w_CAP2",source.GetParameter("CAP2",""));
      } else {
        if (source.IsForwarded()) {
          w_CAP2 = source.GetCaller().GetString("CAP2","C",9,0);
          m_bpassedw_CAP2 = true;
        } else {
          w_CAP2 = source.GetParameter("CAP2",source.GetParameter("w_CAP2",""));
        }
      }
      m_bpassedw_PROFESSIONE = source.Has("w_PROFESSIONE");
      if (m_bpassedw_PROFESSIONE) {
        w_PROFESSIONE = source.GetParameter("w_PROFESSIONE",source.GetParameter("PROFESSIONE",""));
      } else {
        if (source.IsForwarded()) {
          w_PROFESSIONE = source.GetCaller().GetString("PROFESSIONE","C",10,0);
          m_bpassedw_PROFESSIONE = true;
        } else {
          w_PROFESSIONE = source.GetParameter("PROFESSIONE",source.GetParameter("w_PROFESSIONE",""));
        }
      }
      m_bpassedw_IMPWALLET = source.Has("w_IMPWALLET");
      if (m_bpassedw_IMPWALLET) {
        w_IMPWALLET = source.GetParameter("w_IMPWALLET",source.GetParameter("IMPWALLET",0));
      } else {
        if (source.IsForwarded()) {
          w_IMPWALLET = source.GetCaller().GetNumber("IMPWALLET","N",12,2);
          m_bpassedw_IMPWALLET = true;
        } else {
          w_IMPWALLET = source.GetParameter("IMPWALLET",source.GetParameter("w_IMPWALLET",0));
        }
      }
      m_bpassedw_CODWALLET = source.Has("w_CODWALLET");
      if (m_bpassedw_CODWALLET) {
        w_CODWALLET = source.GetParameter("w_CODWALLET",source.GetParameter("CODWALLET",""));
      } else {
        if (source.IsForwarded()) {
          w_CODWALLET = source.GetCaller().GetString("CODWALLET","C",14,0);
          m_bpassedw_CODWALLET = true;
        } else {
          w_CODWALLET = source.GetParameter("CODWALLET",source.GetParameter("w_CODWALLET",""));
        }
      }
      m_bpassedw_FLAGWALLET = source.Has("w_FLAGWALLET");
      if (m_bpassedw_FLAGWALLET) {
        w_FLAGWALLET = source.GetParameter("w_FLAGWALLET",source.GetParameter("FLAGWALLET",""));
      } else {
        if (source.IsForwarded()) {
          w_FLAGWALLET = source.GetCaller().GetString("FLAGWALLET","C",1,0);
          m_bpassedw_FLAGWALLET = true;
        } else {
          w_FLAGWALLET = source.GetParameter("FLAGWALLET",source.GetParameter("w_FLAGWALLET",""));
        }
      }
      m_bpassedw_CODTRANSZ = source.Has("w_CODTRANSZ");
      if (m_bpassedw_CODTRANSZ) {
        w_CODTRANSZ = source.GetParameter("w_CODTRANSZ",source.GetParameter("CODTRANSZ",""));
      } else {
        if (source.IsForwarded()) {
          w_CODTRANSZ = source.GetCaller().GetString("CODTRANSZ","C",1,0);
          m_bpassedw_CODTRANSZ = true;
        } else {
          w_CODTRANSZ = source.GetParameter("CODTRANSZ",source.GetParameter("w_CODTRANSZ",""));
        }
      }
    }
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPRoutineGlobals l_eg;
    l_eg = new SPRoutineGlobals();
    l_eg.name = "arrt_cgo_moduli";
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
    return  ! (status.m_bpassedw_CODTRANSZ) ||  ! (status.m_bpassedw_FLAGWALLET) ||  ! (status.m_bpassedw_CODWALLET) ||  ! (status.m_bpassedw_IMPWALLET) ||  ! (status.m_bpassedw_PROFESSIONE) ||  ! (status.m_bpassedw_CAP2) ||  ! (status.m_bpassedw_DESCCIT2) ||  ! (status.m_bpassedw_PROVINCIA2) ||  ! (status.m_bpassedw_DOMICILIO2) ||  ! (status.m_bpassedw_PAESE2) ||  ! (status.m_bpassedw_FLGDOM) ||  ! (status.m_bpassedw_PEPDESCRI) ||  ! (status.m_bpassedw_CGOFLGVLT) ||  ! (status.m_bpassedw_RDLOCAUT) ||  ! (status.m_bpassedw_RDCODAUT) ||  ! (status.m_bpassedw_TIPOGIOCO) ||  ! (status.m_bpassedw_NUMTEL) ||  ! (status.m_bpassedw_CCDATSCA) ||  ! (status.m_bpassedw_CC4CIFRE) ||  ! (status.m_bpassedw_VLTPLAT) ||  ! (status.m_bpassedw_ASSEGNO) ||  ! (status.m_bpassedw_MIDBIGLIETTO4) ||  ! (status.m_bpassedw_MIDBIGLIETTO3) ||  ! (status.m_bpassedw_MIDBIGLIETTO2) ||  ! (status.m_bpassedw_MIDBIGLIETTO1) ||  ! (status.m_bpassedw_MIDBIGLIETTO) ||  ! (status.m_bpassedw_ATTIV) ||  ! (status.m_bpassedw_CAFLGOPE) ||  ! (status.m_bpassedw_CAIDBIGLIETTO) ||  ! (status.m_bpassedw_CACODICE) ||  ! (status.m_bpassedw_TOTCONT) ||  ! (status.m_bpassedw_TOTLIRE) ||  ! (status.m_bpassedw_CODCABDIP) ||  ! (status.m_bpassedw_PROVINCIADIP) ||  ! (status.m_bpassedw_COLLEG) ||  ! (status.m_bpassedw_FLAGFRAZ) ||  ! (status.m_bpassedw_SEGNO) ||  ! (status.m_bpassedw_DESCCITDIP) ||  ! (status.m_bpassedw_CODDIPE) ||  ! (status.m_bpassedw_CODINTER) ||  ! (status.m_bpassedw_C_STA) ||  ! (status.m_bpassedw_C_IND) ||  ! (status.m_bpassedw_C_CAB) ||  ! (status.m_bpassedw_C_CAP) ||  ! (status.m_bpassedw_C_PRV) ||  ! (status.m_bpassedw_C_CTA) ||  ! (status.m_bpassedw_C_RAG) ||  ! (status.m_bpassedw_CONNESBEN) ||  ! (status.m_bpassedw_CONNESCLI) ||  ! (status.m_bpassedw_CAMBIO) ||  ! (status.m_bpassedw_VALUTA) ||  ! (status.m_bpassedw_CODVOC) ||  ! (status.m_bpassedw_CODANA) ||  ! (status.m_bpassedw_TIPOOPRAP) ||  ! (status.m_bpassedw_FLAGCONT) ||  ! (status.m_bpassedw_DATAREG) ||  ! (status.m_bpassedw_DATAOPE) ||  ! (status.m_bpassedw_SNAINUMOPE) ||  ! (status.m_bpassedw_PEP) ||  ! (status.m_bpassedw_SETTSINT) ||  ! (status.m_bpassedw_RAMOGRUP) ||  ! (status.m_bpassedw_SOTGRUP) ||  ! (status.m_bpassedw_AUTRILASC) ||  ! (status.m_bpassedw_DATAVALI) ||  ! (status.m_bpassedw_DATARILASC) ||  ! (status.m_bpassedw_NUMDOCUM) ||  ! (status.m_bpassedw_TIPODOC) ||  ! (status.m_bpassedw_DATANASC) ||  ! (status.m_bpassedw_NASSTATO) ||  ! (status.m_bpassedw_SESSO) ||  ! (status.m_bpassedw_TIPINTER) ||  ! (status.m_bpassedw_NASCOMUN) ||  ! (status.m_bpassedw_PAESE) ||  ! (status.m_bpassedw_DOMICILIO) ||  ! (status.m_bpassedw_CODCAB) ||  ! (status.m_bpassedw_CAP) ||  ! (status.m_bpassedw_PROVINCIA) ||  ! (status.m_bpassedw_DESCCIT) ||  ! (status.m_bpassedw_RAGSOC) ||  ! (status.m_bpassedw_NOME) ||  ! (status.m_bpassedw_COGNOME) ||  ! (status.m_bpassedw_CODFISC) ||  ! (status.m_bpassedw_CFESTERO) ||  ! (status.m_bpassedw_IBAN) ||  ! (status.m_bpassedw_MEZPAGAM) ||  ! (status.m_bpassedw_TIPOPERS) ||  ! (status.m_bpassedw_CABINT) ||  ! (status.m_bpassedw_PROVINT) ||  ! (status.m_bpassedw_CABDIP) ||  ! (status.m_bpassedw_PROVDIP) ||  ! (status.m_bpassedw_CITDIP) ||  ! (status.m_bpassedw_CITINT) ||  ! (status.m_bpassedw_DESCRI) ||  ! (status.m_bpassedw_NUMPROG) ||  ! (status.m_bpassedw_IDBASE) ||  ! (status.m_bpassedw_STATOREG);
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
    if ( ! (status.m_bpassedw_STATOREG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_STATOREG',"+SPLib.ToJSValue(status.w_STATOREG,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_STATOREG,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_STATOREG',l_cV);");
    if ( ! (status.m_bpassedw_IDBASE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IDBASE',"+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IDBASE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IDBASE',l_cV);");
    if ( ! (status.m_bpassedw_NUMPROG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NUMPROG',"+SPLib.ToJSValue(status.w_NUMPROG,"C",7,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NUMPROG,"C",7,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NUMPROG',l_cV);");
    if ( ! (status.m_bpassedw_DESCRI)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCRI',"+SPLib.ToJSValue(status.w_DESCRI,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCRI,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCRI',l_cV);");
    if ( ! (status.m_bpassedw_CITINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CITINT',"+SPLib.ToJSValue(status.w_CITINT,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CITINT,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CITINT',l_cV);");
    if ( ! (status.m_bpassedw_CITDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CITDIP',"+SPLib.ToJSValue(status.w_CITDIP,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CITDIP,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CITDIP',l_cV);");
    if ( ! (status.m_bpassedw_PROVDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVDIP',"+SPLib.ToJSValue(status.w_PROVDIP,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVDIP,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVDIP',l_cV);");
    if ( ! (status.m_bpassedw_CABDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CABDIP',"+SPLib.ToJSValue(status.w_CABDIP,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CABDIP,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CABDIP',l_cV);");
    if ( ! (status.m_bpassedw_PROVINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVINT',"+SPLib.ToJSValue(status.w_PROVINT,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVINT,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVINT',l_cV);");
    if ( ! (status.m_bpassedw_CABINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CABINT',"+SPLib.ToJSValue(status.w_CABINT,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CABINT,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CABINT',l_cV);");
    if ( ! (status.m_bpassedw_TIPOPERS)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPOPERS',"+SPLib.ToJSValue(status.w_TIPOPERS,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPOPERS,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPOPERS',l_cV);");
    if ( ! (status.m_bpassedw_MEZPAGAM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MEZPAGAM',"+SPLib.ToJSValue(status.w_MEZPAGAM,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MEZPAGAM,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_MEZPAGAM',l_cV);");
    if ( ! (status.m_bpassedw_IBAN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IBAN',"+SPLib.ToJSValue(status.w_IBAN,"C",27,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IBAN,"C",27,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_IBAN',l_cV);");
    if ( ! (status.m_bpassedw_CFESTERO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CFESTERO',"+SPLib.ToJSValue(status.w_CFESTERO,"N",1,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CFESTERO,"N",1,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_CFESTERO',l_cV);");
    if ( ! (status.m_bpassedw_CODFISC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODFISC',"+SPLib.ToJSValue(status.w_CODFISC,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODFISC,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODFISC',l_cV);");
    if ( ! (status.m_bpassedw_COGNOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_COGNOME',"+SPLib.ToJSValue(status.w_COGNOME,"C",26,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_COGNOME,"C",26,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_COGNOME',l_cV);");
    if ( ! (status.m_bpassedw_NOME)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NOME',"+SPLib.ToJSValue(status.w_NOME,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NOME,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NOME',l_cV);");
    if ( ! (status.m_bpassedw_RAGSOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAGSOC',"+SPLib.ToJSValue(status.w_RAGSOC,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAGSOC,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAGSOC',l_cV);");
    if ( ! (status.m_bpassedw_DESCCIT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCCIT',"+SPLib.ToJSValue(status.w_DESCCIT,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCCIT,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCCIT',l_cV);");
    if ( ! (status.m_bpassedw_PROVINCIA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVINCIA',"+SPLib.ToJSValue(status.w_PROVINCIA,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVINCIA,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVINCIA',l_cV);");
    if ( ! (status.m_bpassedw_CAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAP',"+SPLib.ToJSValue(status.w_CAP,"C",9,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAP,"C",9,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CAP',l_cV);");
    if ( ! (status.m_bpassedw_CODCAB)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODCAB',"+SPLib.ToJSValue(status.w_CODCAB,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODCAB,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODCAB',l_cV);");
    if ( ! (status.m_bpassedw_DOMICILIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DOMICILIO',"+SPLib.ToJSValue(status.w_DOMICILIO,"C",35,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DOMICILIO,"C",35,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DOMICILIO',l_cV);");
    if ( ! (status.m_bpassedw_PAESE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PAESE',"+SPLib.ToJSValue(status.w_PAESE,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PAESE,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PAESE',l_cV);");
    if ( ! (status.m_bpassedw_NASCOMUN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NASCOMUN',"+SPLib.ToJSValue(status.w_NASCOMUN,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NASCOMUN,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NASCOMUN',l_cV);");
    if ( ! (status.m_bpassedw_TIPINTER)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPINTER',"+SPLib.ToJSValue(status.w_TIPINTER,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPINTER,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPINTER',l_cV);");
    if ( ! (status.m_bpassedw_SESSO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SESSO',"+SPLib.ToJSValue(status.w_SESSO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SESSO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SESSO',l_cV);");
    if ( ! (status.m_bpassedw_NASSTATO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NASSTATO',"+SPLib.ToJSValue(status.w_NASSTATO,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NASSTATO,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NASSTATO',l_cV);");
    if ( ! (status.m_bpassedw_DATANASC)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATANASC',"+SPLib.ToJSValue(status.w_DATANASC,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATANASC,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATANASC',l_cV);");
    if ( ! (status.m_bpassedw_TIPODOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPODOC',"+SPLib.ToJSValue(status.w_TIPODOC,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPODOC,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPODOC',l_cV);");
    if ( ! (status.m_bpassedw_NUMDOCUM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NUMDOCUM',"+SPLib.ToJSValue(status.w_NUMDOCUM,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NUMDOCUM,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NUMDOCUM',l_cV);");
    if ( ! (status.m_bpassedw_DATARILASC)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATARILASC',"+SPLib.ToJSValue(status.w_DATARILASC,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATARILASC,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATARILASC',l_cV);");
    if ( ! (status.m_bpassedw_DATAVALI)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATAVALI',"+SPLib.ToJSValue(status.w_DATAVALI,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATAVALI,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATAVALI',l_cV);");
    if ( ! (status.m_bpassedw_AUTRILASC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_AUTRILASC',"+SPLib.ToJSValue(status.w_AUTRILASC,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_AUTRILASC,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_AUTRILASC',l_cV);");
    if ( ! (status.m_bpassedw_SOTGRUP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SOTGRUP',"+SPLib.ToJSValue(status.w_SOTGRUP,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SOTGRUP,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SOTGRUP',l_cV);");
    if ( ! (status.m_bpassedw_RAMOGRUP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RAMOGRUP',"+SPLib.ToJSValue(status.w_RAMOGRUP,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RAMOGRUP,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RAMOGRUP',l_cV);");
    if ( ! (status.m_bpassedw_SETTSINT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SETTSINT',"+SPLib.ToJSValue(status.w_SETTSINT,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SETTSINT,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SETTSINT',l_cV);");
    if ( ! (status.m_bpassedw_PEP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PEP',"+SPLib.ToJSValue(status.w_PEP,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PEP,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PEP',l_cV);");
    if ( ! (status.m_bpassedw_SNAINUMOPE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SNAINUMOPE',"+SPLib.ToJSValue(status.w_SNAINUMOPE,"C",15,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SNAINUMOPE,"C",15,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SNAINUMOPE',l_cV);");
    if ( ! (status.m_bpassedw_DATAOPE)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATAOPE',"+SPLib.ToJSValue(status.w_DATAOPE,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATAOPE,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATAOPE',l_cV);");
    if ( ! (status.m_bpassedw_DATAREG)) {
      status.out.println("l_cV=WtA(FetchDate(l_oWnd('w_DATAREG',"+SPLib.ToJSValue(status.w_DATAREG,"D",8,0)+")),'D');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DATAREG,"D",8,0)+",'D');");
    }
    status.out.println("l_oWv.setValue('w_DATAREG',l_cV);");
    if ( ! (status.m_bpassedw_FLAGCONT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLAGCONT',"+SPLib.ToJSValue(status.w_FLAGCONT,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLAGCONT,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLAGCONT',l_cV);");
    if ( ! (status.m_bpassedw_TIPOOPRAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPOOPRAP',"+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPOOPRAP',l_cV);");
    if ( ! (status.m_bpassedw_CODANA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODANA',"+SPLib.ToJSValue(status.w_CODANA,"C",4,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODANA,"C",4,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODANA',l_cV);");
    if ( ! (status.m_bpassedw_CODVOC)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODVOC',"+SPLib.ToJSValue(status.w_CODVOC,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODVOC,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODVOC',l_cV);");
    if ( ! (status.m_bpassedw_VALUTA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_VALUTA',"+SPLib.ToJSValue(status.w_VALUTA,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_VALUTA,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_VALUTA',l_cV);");
    if ( ! (status.m_bpassedw_CAMBIO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAMBIO',"+SPLib.ToJSValue(status.w_CAMBIO,"N",9,4)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAMBIO,"N",9,4)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_CAMBIO',l_cV);");
    if ( ! (status.m_bpassedw_CONNESCLI)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNESCLI',"+SPLib.ToJSValue(status.w_CONNESCLI,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNESCLI,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNESCLI',l_cV);");
    if ( ! (status.m_bpassedw_CONNESBEN)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CONNESBEN',"+SPLib.ToJSValue(status.w_CONNESBEN,"C",16,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CONNESBEN,"C",16,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CONNESBEN',l_cV);");
    if ( ! (status.m_bpassedw_C_RAG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_RAG',"+SPLib.ToJSValue(status.w_C_RAG,"C",70,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_RAG,"C",70,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_RAG',l_cV);");
    if ( ! (status.m_bpassedw_C_CTA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CTA',"+SPLib.ToJSValue(status.w_C_CTA,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CTA,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CTA',l_cV);");
    if ( ! (status.m_bpassedw_C_PRV)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_PRV',"+SPLib.ToJSValue(status.w_C_PRV,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_PRV,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_PRV',l_cV);");
    if ( ! (status.m_bpassedw_C_CAP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CAP',"+SPLib.ToJSValue(status.w_C_CAP,"C",5,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CAP,"C",5,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CAP',l_cV);");
    if ( ! (status.m_bpassedw_C_CAB)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_CAB',"+SPLib.ToJSValue(status.w_C_CAB,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_CAB,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_CAB',l_cV);");
    if ( ! (status.m_bpassedw_C_IND)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_IND',"+SPLib.ToJSValue(status.w_C_IND,"C",35,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_IND,"C",35,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_IND',l_cV);");
    if ( ! (status.m_bpassedw_C_STA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_C_STA',"+SPLib.ToJSValue(status.w_C_STA,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_C_STA,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_C_STA',l_cV);");
    if ( ! (status.m_bpassedw_CODINTER)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODINTER',"+SPLib.ToJSValue(status.w_CODINTER,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODINTER,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODINTER',l_cV);");
    if ( ! (status.m_bpassedw_CODDIPE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODDIPE',"+SPLib.ToJSValue(status.w_CODDIPE,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODDIPE,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODDIPE',l_cV);");
    if ( ! (status.m_bpassedw_DESCCITDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCCITDIP',"+SPLib.ToJSValue(status.w_DESCCITDIP,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCCITDIP,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCCITDIP',l_cV);");
    if ( ! (status.m_bpassedw_SEGNO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_SEGNO',"+SPLib.ToJSValue(status.w_SEGNO,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_SEGNO,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_SEGNO',l_cV);");
    if ( ! (status.m_bpassedw_FLAGFRAZ)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLAGFRAZ',"+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLAGFRAZ',l_cV);");
    if ( ! (status.m_bpassedw_COLLEG)) {
      status.out.println("l_cV=WtA(l_oWnd('w_COLLEG',"+SPLib.ToJSValue(status.w_COLLEG,"C",11,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_COLLEG,"C",11,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_COLLEG',l_cV);");
    if ( ! (status.m_bpassedw_PROVINCIADIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVINCIADIP',"+SPLib.ToJSValue(status.w_PROVINCIADIP,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVINCIADIP,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVINCIADIP',l_cV);");
    if ( ! (status.m_bpassedw_CODCABDIP)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODCABDIP',"+SPLib.ToJSValue(status.w_CODCABDIP,"C",6,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODCABDIP,"C",6,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODCABDIP',l_cV);");
    if ( ! (status.m_bpassedw_TOTLIRE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TOTLIRE',"+SPLib.ToJSValue(status.w_TOTLIRE,"N",15,2)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TOTLIRE,"N",15,2)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_TOTLIRE',l_cV);");
    if ( ! (status.m_bpassedw_TOTCONT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TOTCONT',"+SPLib.ToJSValue(status.w_TOTCONT,"N",15,2)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TOTCONT,"N",15,2)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_TOTCONT',l_cV);");
    if ( ! (status.m_bpassedw_CACODICE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CACODICE',"+SPLib.ToJSValue(status.w_CACODICE,"N",5,0)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CACODICE,"N",5,0)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_CACODICE',l_cV);");
    if ( ! (status.m_bpassedw_CAIDBIGLIETTO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAIDBIGLIETTO',"+SPLib.ToJSValue(status.w_CAIDBIGLIETTO,"C",30,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAIDBIGLIETTO,"C",30,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CAIDBIGLIETTO',l_cV);");
    if ( ! (status.m_bpassedw_CAFLGOPE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAFLGOPE',"+SPLib.ToJSValue(status.w_CAFLGOPE,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAFLGOPE,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CAFLGOPE',l_cV);");
    if ( ! (status.m_bpassedw_ATTIV)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ATTIV',"+SPLib.ToJSValue(status.w_ATTIV,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ATTIV,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ATTIV',l_cV);");
    if ( ! (status.m_bpassedw_MIDBIGLIETTO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MIDBIGLIETTO',"+SPLib.ToJSValue(status.w_MIDBIGLIETTO,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MIDBIGLIETTO,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_MIDBIGLIETTO',l_cV);");
    if ( ! (status.m_bpassedw_MIDBIGLIETTO1)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MIDBIGLIETTO1',"+SPLib.ToJSValue(status.w_MIDBIGLIETTO1,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MIDBIGLIETTO1,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_MIDBIGLIETTO1',l_cV);");
    if ( ! (status.m_bpassedw_MIDBIGLIETTO2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MIDBIGLIETTO2',"+SPLib.ToJSValue(status.w_MIDBIGLIETTO2,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MIDBIGLIETTO2,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_MIDBIGLIETTO2',l_cV);");
    if ( ! (status.m_bpassedw_MIDBIGLIETTO3)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MIDBIGLIETTO3',"+SPLib.ToJSValue(status.w_MIDBIGLIETTO3,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MIDBIGLIETTO3,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_MIDBIGLIETTO3',l_cV);");
    if ( ! (status.m_bpassedw_MIDBIGLIETTO4)) {
      status.out.println("l_cV=WtA(l_oWnd('w_MIDBIGLIETTO4',"+SPLib.ToJSValue(status.w_MIDBIGLIETTO4,"M",10,0)+"),'M');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_MIDBIGLIETTO4,"M",10,0)+",'M');");
    }
    status.out.println("l_oWv.setValue('w_MIDBIGLIETTO4',l_cV);");
    if ( ! (status.m_bpassedw_ASSEGNO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_ASSEGNO',"+SPLib.ToJSValue(status.w_ASSEGNO,"C",25,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_ASSEGNO,"C",25,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_ASSEGNO',l_cV);");
    if ( ! (status.m_bpassedw_VLTPLAT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_VLTPLAT',"+SPLib.ToJSValue(status.w_VLTPLAT,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_VLTPLAT,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_VLTPLAT',l_cV);");
    if ( ! (status.m_bpassedw_CC4CIFRE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CC4CIFRE',"+SPLib.ToJSValue(status.w_CC4CIFRE,"C",4,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CC4CIFRE,"C",4,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CC4CIFRE',l_cV);");
    if ( ! (status.m_bpassedw_CCDATSCA)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CCDATSCA',"+SPLib.ToJSValue(status.w_CCDATSCA,"C",7,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CCDATSCA,"C",7,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CCDATSCA',l_cV);");
    if ( ! (status.m_bpassedw_NUMTEL)) {
      status.out.println("l_cV=WtA(l_oWnd('w_NUMTEL',"+SPLib.ToJSValue(status.w_NUMTEL,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_NUMTEL,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_NUMTEL',l_cV);");
    if ( ! (status.m_bpassedw_TIPOGIOCO)) {
      status.out.println("l_cV=WtA(l_oWnd('w_TIPOGIOCO',"+SPLib.ToJSValue(status.w_TIPOGIOCO,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_TIPOGIOCO,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_TIPOGIOCO',l_cV);");
    if ( ! (status.m_bpassedw_RDCODAUT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RDCODAUT',"+SPLib.ToJSValue(status.w_RDCODAUT,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RDCODAUT,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RDCODAUT',l_cV);");
    if ( ! (status.m_bpassedw_RDLOCAUT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_RDLOCAUT',"+SPLib.ToJSValue(status.w_RDLOCAUT,"C",20,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_RDLOCAUT,"C",20,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_RDLOCAUT',l_cV);");
    if ( ! (status.m_bpassedw_CGOFLGVLT)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CGOFLGVLT',"+SPLib.ToJSValue(status.w_CGOFLGVLT,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CGOFLGVLT,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CGOFLGVLT',l_cV);");
    if ( ! (status.m_bpassedw_PEPDESCRI)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PEPDESCRI',"+SPLib.ToJSValue(status.w_PEPDESCRI,"C",80,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PEPDESCRI,"C",80,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PEPDESCRI',l_cV);");
    if ( ! (status.m_bpassedw_FLGDOM)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLGDOM',"+SPLib.ToJSValue(status.w_FLGDOM,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLGDOM,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLGDOM',l_cV);");
    if ( ! (status.m_bpassedw_PAESE2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PAESE2',"+SPLib.ToJSValue(status.w_PAESE2,"C",3,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PAESE2,"C",3,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PAESE2',l_cV);");
    if ( ! (status.m_bpassedw_DOMICILIO2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DOMICILIO2',"+SPLib.ToJSValue(status.w_DOMICILIO2,"C",35,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DOMICILIO2,"C",35,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DOMICILIO2',l_cV);");
    if ( ! (status.m_bpassedw_PROVINCIA2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROVINCIA2',"+SPLib.ToJSValue(status.w_PROVINCIA2,"C",2,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROVINCIA2,"C",2,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROVINCIA2',l_cV);");
    if ( ! (status.m_bpassedw_DESCCIT2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_DESCCIT2',"+SPLib.ToJSValue(status.w_DESCCIT2,"C",40,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_DESCCIT2,"C",40,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_DESCCIT2',l_cV);");
    if ( ! (status.m_bpassedw_CAP2)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CAP2',"+SPLib.ToJSValue(status.w_CAP2,"C",9,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CAP2,"C",9,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CAP2',l_cV);");
    if ( ! (status.m_bpassedw_PROFESSIONE)) {
      status.out.println("l_cV=WtA(l_oWnd('w_PROFESSIONE',"+SPLib.ToJSValue(status.w_PROFESSIONE,"C",10,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_PROFESSIONE,"C",10,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_PROFESSIONE',l_cV);");
    if ( ! (status.m_bpassedw_IMPWALLET)) {
      status.out.println("l_cV=WtA(l_oWnd('w_IMPWALLET',"+SPLib.ToJSValue(status.w_IMPWALLET,"N",12,2)+"),'N');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_IMPWALLET,"N",12,2)+",'N');");
    }
    status.out.println("l_oWv.setValue('w_IMPWALLET',l_cV);");
    if ( ! (status.m_bpassedw_CODWALLET)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODWALLET',"+SPLib.ToJSValue(status.w_CODWALLET,"C",14,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODWALLET,"C",14,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODWALLET',l_cV);");
    if ( ! (status.m_bpassedw_FLAGWALLET)) {
      status.out.println("l_cV=WtA(l_oWnd('w_FLAGWALLET',"+SPLib.ToJSValue(status.w_FLAGWALLET,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_FLAGWALLET,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_FLAGWALLET',l_cV);");
    if ( ! (status.m_bpassedw_CODTRANSZ)) {
      status.out.println("l_cV=WtA(l_oWnd('w_CODTRANSZ',"+SPLib.ToJSValue(status.w_CODTRANSZ,"C",1,0)+"),'C');");
    } else {
      status.out.println("l_cV=WtA("+SPLib.ToJSValue(status.w_CODTRANSZ,"C",1,0)+",'C');");
    }
    status.out.println("l_oWv.setValue('w_CODTRANSZ',l_cV);");
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
    arrt_cgo_moduliR Rcalled;
    Rcalled = new arrt_cgo_moduliR(status.context,status);
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
    return new arrt_cgo_moduliR(status.context,dataFromClient);
  }
  protected void BringBackPage(ServletStatus status,arrt_cgo_moduliR Rcalled) throws IOException {
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
          status.out.println("Fault:["+SPLib.ToJSValue(status.context.Translate("MSG_ROUTINE_FAULTED","arrt_cgo_moduli"),"C",0,0)+","+SPLib.ToJSValue(status.m_cFaultTrace,"C",0,0)+"]");
          if (CPLib.Empty(Rcalled.m_cLastMsgError) &&  ! (status.m_bApplet)) {
            status.out.println("Error message:"+com.zucchetti.sitepainter.Library.ToHTMLEuro(status.m_cFaultTrace)+"");
          }
        }
        status.out.println("js:w_STATOREG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_STATOREG),"?",0,0)+"");
        status.out.println("js:w_IDBASE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IDBASE),"?",0,0)+"");
        status.out.println("js:w_NUMPROG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NUMPROG),"?",0,0)+"");
        status.out.println("js:w_DESCRI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCRI),"?",0,0)+"");
        status.out.println("js:w_CITINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CITINT),"?",0,0)+"");
        status.out.println("js:w_CITDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CITDIP),"?",0,0)+"");
        status.out.println("js:w_PROVDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVDIP),"?",0,0)+"");
        status.out.println("js:w_CABDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CABDIP),"?",0,0)+"");
        status.out.println("js:w_PROVINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVINT),"?",0,0)+"");
        status.out.println("js:w_CABINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CABINT),"?",0,0)+"");
        status.out.println("js:w_TIPOPERS="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPOPERS),"?",0,0)+"");
        status.out.println("js:w_MEZPAGAM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MEZPAGAM),"?",0,0)+"");
        status.out.println("js:w_IBAN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IBAN),"?",0,0)+"");
        status.out.println("js:w_CFESTERO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CFESTERO),"?",0,0)+"");
        status.out.println("js:w_CODFISC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODFISC),"?",0,0)+"");
        status.out.println("js:w_COGNOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_COGNOME),"?",0,0)+"");
        status.out.println("js:w_NOME="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NOME),"?",0,0)+"");
        status.out.println("js:w_RAGSOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAGSOC),"?",0,0)+"");
        status.out.println("js:w_DESCCIT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCCIT),"?",0,0)+"");
        status.out.println("js:w_PROVINCIA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVINCIA),"?",0,0)+"");
        status.out.println("js:w_CAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAP),"?",0,0)+"");
        status.out.println("js:w_CODCAB="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODCAB),"?",0,0)+"");
        status.out.println("js:w_DOMICILIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DOMICILIO),"?",0,0)+"");
        status.out.println("js:w_PAESE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PAESE),"?",0,0)+"");
        status.out.println("js:w_NASCOMUN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NASCOMUN),"?",0,0)+"");
        status.out.println("js:w_TIPINTER="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPINTER),"?",0,0)+"");
        status.out.println("js:w_SESSO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SESSO),"?",0,0)+"");
        status.out.println("js:w_NASSTATO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NASSTATO),"?",0,0)+"");
        status.out.println("js:w_DATANASC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATANASC),"?",0,0)+"");
        status.out.println("js:w_TIPODOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPODOC),"?",0,0)+"");
        status.out.println("js:w_NUMDOCUM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NUMDOCUM),"?",0,0)+"");
        status.out.println("js:w_DATARILASC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATARILASC),"?",0,0)+"");
        status.out.println("js:w_DATAVALI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATAVALI),"?",0,0)+"");
        status.out.println("js:w_AUTRILASC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_AUTRILASC),"?",0,0)+"");
        status.out.println("js:w_SOTGRUP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SOTGRUP),"?",0,0)+"");
        status.out.println("js:w_RAMOGRUP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RAMOGRUP),"?",0,0)+"");
        status.out.println("js:w_SETTSINT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SETTSINT),"?",0,0)+"");
        status.out.println("js:w_PEP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PEP),"?",0,0)+"");
        status.out.println("js:w_SNAINUMOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SNAINUMOPE),"?",0,0)+"");
        status.out.println("js:w_DATAOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATAOPE),"?",0,0)+"");
        status.out.println("js:w_DATAREG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DATAREG),"?",0,0)+"");
        status.out.println("js:w_FLAGCONT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLAGCONT),"?",0,0)+"");
        status.out.println("js:w_TIPOOPRAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPOOPRAP),"?",0,0)+"");
        status.out.println("js:w_CODANA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODANA),"?",0,0)+"");
        status.out.println("js:w_CODVOC="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODVOC),"?",0,0)+"");
        status.out.println("js:w_VALUTA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_VALUTA),"?",0,0)+"");
        status.out.println("js:w_CAMBIO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAMBIO),"?",0,0)+"");
        status.out.println("js:w_CONNESCLI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNESCLI),"?",0,0)+"");
        status.out.println("js:w_CONNESBEN="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CONNESBEN),"?",0,0)+"");
        status.out.println("js:w_C_RAG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_RAG),"?",0,0)+"");
        status.out.println("js:w_C_CTA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CTA),"?",0,0)+"");
        status.out.println("js:w_C_PRV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_PRV),"?",0,0)+"");
        status.out.println("js:w_C_CAP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CAP),"?",0,0)+"");
        status.out.println("js:w_C_CAB="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_CAB),"?",0,0)+"");
        status.out.println("js:w_C_IND="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_IND),"?",0,0)+"");
        status.out.println("js:w_C_STA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_C_STA),"?",0,0)+"");
        status.out.println("js:w_CODINTER="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODINTER),"?",0,0)+"");
        status.out.println("js:w_CODDIPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODDIPE),"?",0,0)+"");
        status.out.println("js:w_DESCCITDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCCITDIP),"?",0,0)+"");
        status.out.println("js:w_SEGNO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_SEGNO),"?",0,0)+"");
        status.out.println("js:w_FLAGFRAZ="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLAGFRAZ),"?",0,0)+"");
        status.out.println("js:w_COLLEG="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_COLLEG),"?",0,0)+"");
        status.out.println("js:w_PROVINCIADIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVINCIADIP),"?",0,0)+"");
        status.out.println("js:w_CODCABDIP="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODCABDIP),"?",0,0)+"");
        status.out.println("js:w_TOTLIRE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TOTLIRE),"?",0,0)+"");
        status.out.println("js:w_TOTCONT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TOTCONT),"?",0,0)+"");
        status.out.println("js:w_CACODICE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CACODICE),"?",0,0)+"");
        status.out.println("js:w_CAIDBIGLIETTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAIDBIGLIETTO),"?",0,0)+"");
        status.out.println("js:w_CAFLGOPE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAFLGOPE),"?",0,0)+"");
        status.out.println("js:w_ATTIV="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ATTIV),"?",0,0)+"");
        status.out.println("js:w_MIDBIGLIETTO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MIDBIGLIETTO),"?",0,0)+"");
        status.out.println("js:w_MIDBIGLIETTO1="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MIDBIGLIETTO1),"?",0,0)+"");
        status.out.println("js:w_MIDBIGLIETTO2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MIDBIGLIETTO2),"?",0,0)+"");
        status.out.println("js:w_MIDBIGLIETTO3="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MIDBIGLIETTO3),"?",0,0)+"");
        status.out.println("js:w_MIDBIGLIETTO4="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_MIDBIGLIETTO4),"?",0,0)+"");
        status.out.println("js:w_ASSEGNO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_ASSEGNO),"?",0,0)+"");
        status.out.println("js:w_VLTPLAT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_VLTPLAT),"?",0,0)+"");
        status.out.println("js:w_CC4CIFRE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CC4CIFRE),"?",0,0)+"");
        status.out.println("js:w_CCDATSCA="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CCDATSCA),"?",0,0)+"");
        status.out.println("js:w_NUMTEL="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_NUMTEL),"?",0,0)+"");
        status.out.println("js:w_TIPOGIOCO="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_TIPOGIOCO),"?",0,0)+"");
        status.out.println("js:w_RDCODAUT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RDCODAUT),"?",0,0)+"");
        status.out.println("js:w_RDLOCAUT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_RDLOCAUT),"?",0,0)+"");
        status.out.println("js:w_CGOFLGVLT="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CGOFLGVLT),"?",0,0)+"");
        status.out.println("js:w_PEPDESCRI="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PEPDESCRI),"?",0,0)+"");
        status.out.println("js:w_FLGDOM="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLGDOM),"?",0,0)+"");
        status.out.println("js:w_PAESE2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PAESE2),"?",0,0)+"");
        status.out.println("js:w_DOMICILIO2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DOMICILIO2),"?",0,0)+"");
        status.out.println("js:w_PROVINCIA2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROVINCIA2),"?",0,0)+"");
        status.out.println("js:w_DESCCIT2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_DESCCIT2),"?",0,0)+"");
        status.out.println("js:w_CAP2="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CAP2),"?",0,0)+"");
        status.out.println("js:w_PROFESSIONE="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_PROFESSIONE),"?",0,0)+"");
        status.out.println("js:w_IMPWALLET="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_IMPWALLET),"?",0,0)+"");
        status.out.println("js:w_CODWALLET="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODWALLET),"?",0,0)+"");
        status.out.println("js:w_FLAGWALLET="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_FLAGWALLET),"?",0,0)+"");
        status.out.println("js:w_CODTRANSZ="+SPLib.ToJSValue(CPLib.ToProperties(Rcalled.w_CODTRANSZ),"?",0,0)+"");
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
        status.out.println("if (Ne(window[f].w_STATOREG,null)) {");
        status.out.println("window[f].w_STATOREG="+SPLib.ToJSValue(status.w_STATOREG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_IDBASE,null)) {");
        status.out.println("window[f].w_IDBASE="+SPLib.ToJSValue(status.w_IDBASE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NUMPROG,null)) {");
        status.out.println("window[f].w_NUMPROG="+SPLib.ToJSValue(status.w_NUMPROG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCRI,null)) {");
        status.out.println("window[f].w_DESCRI="+SPLib.ToJSValue(status.w_DESCRI,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CITINT,null)) {");
        status.out.println("window[f].w_CITINT="+SPLib.ToJSValue(status.w_CITINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CITDIP,null)) {");
        status.out.println("window[f].w_CITDIP="+SPLib.ToJSValue(status.w_CITDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVDIP,null)) {");
        status.out.println("window[f].w_PROVDIP="+SPLib.ToJSValue(status.w_PROVDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CABDIP,null)) {");
        status.out.println("window[f].w_CABDIP="+SPLib.ToJSValue(status.w_CABDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVINT,null)) {");
        status.out.println("window[f].w_PROVINT="+SPLib.ToJSValue(status.w_PROVINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CABINT,null)) {");
        status.out.println("window[f].w_CABINT="+SPLib.ToJSValue(status.w_CABINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPOPERS,null)) {");
        status.out.println("window[f].w_TIPOPERS="+SPLib.ToJSValue(status.w_TIPOPERS,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MEZPAGAM,null)) {");
        status.out.println("window[f].w_MEZPAGAM="+SPLib.ToJSValue(status.w_MEZPAGAM,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_IBAN,null)) {");
        status.out.println("window[f].w_IBAN="+SPLib.ToJSValue(status.w_IBAN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CFESTERO,null)) {");
        status.out.println("window[f].w_CFESTERO="+SPLib.ToJSValue(status.w_CFESTERO,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODFISC,null)) {");
        status.out.println("window[f].w_CODFISC="+SPLib.ToJSValue(status.w_CODFISC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_COGNOME,null)) {");
        status.out.println("window[f].w_COGNOME="+SPLib.ToJSValue(status.w_COGNOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NOME,null)) {");
        status.out.println("window[f].w_NOME="+SPLib.ToJSValue(status.w_NOME,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAGSOC,null)) {");
        status.out.println("window[f].w_RAGSOC="+SPLib.ToJSValue(status.w_RAGSOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCCIT,null)) {");
        status.out.println("window[f].w_DESCCIT="+SPLib.ToJSValue(status.w_DESCCIT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVINCIA,null)) {");
        status.out.println("window[f].w_PROVINCIA="+SPLib.ToJSValue(status.w_PROVINCIA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAP,null)) {");
        status.out.println("window[f].w_CAP="+SPLib.ToJSValue(status.w_CAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODCAB,null)) {");
        status.out.println("window[f].w_CODCAB="+SPLib.ToJSValue(status.w_CODCAB,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DOMICILIO,null)) {");
        status.out.println("window[f].w_DOMICILIO="+SPLib.ToJSValue(status.w_DOMICILIO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PAESE,null)) {");
        status.out.println("window[f].w_PAESE="+SPLib.ToJSValue(status.w_PAESE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NASCOMUN,null)) {");
        status.out.println("window[f].w_NASCOMUN="+SPLib.ToJSValue(status.w_NASCOMUN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPINTER,null)) {");
        status.out.println("window[f].w_TIPINTER="+SPLib.ToJSValue(status.w_TIPINTER,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SESSO,null)) {");
        status.out.println("window[f].w_SESSO="+SPLib.ToJSValue(status.w_SESSO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NASSTATO,null)) {");
        status.out.println("window[f].w_NASSTATO="+SPLib.ToJSValue(status.w_NASSTATO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATANASC,null)) {");
        status.out.println(" window[f].w_DATANASC.setTime(("+SPLib.ToJSValue(status.w_DATANASC,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPODOC,null)) {");
        status.out.println("window[f].w_TIPODOC="+SPLib.ToJSValue(status.w_TIPODOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NUMDOCUM,null)) {");
        status.out.println("window[f].w_NUMDOCUM="+SPLib.ToJSValue(status.w_NUMDOCUM,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATARILASC,null)) {");
        status.out.println(" window[f].w_DATARILASC.setTime(("+SPLib.ToJSValue(status.w_DATARILASC,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATAVALI,null)) {");
        status.out.println(" window[f].w_DATAVALI.setTime(("+SPLib.ToJSValue(status.w_DATAVALI,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_AUTRILASC,null)) {");
        status.out.println("window[f].w_AUTRILASC="+SPLib.ToJSValue(status.w_AUTRILASC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SOTGRUP,null)) {");
        status.out.println("window[f].w_SOTGRUP="+SPLib.ToJSValue(status.w_SOTGRUP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RAMOGRUP,null)) {");
        status.out.println("window[f].w_RAMOGRUP="+SPLib.ToJSValue(status.w_RAMOGRUP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SETTSINT,null)) {");
        status.out.println("window[f].w_SETTSINT="+SPLib.ToJSValue(status.w_SETTSINT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PEP,null)) {");
        status.out.println("window[f].w_PEP="+SPLib.ToJSValue(status.w_PEP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SNAINUMOPE,null)) {");
        status.out.println("window[f].w_SNAINUMOPE="+SPLib.ToJSValue(status.w_SNAINUMOPE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATAOPE,null)) {");
        status.out.println(" window[f].w_DATAOPE.setTime(("+SPLib.ToJSValue(status.w_DATAOPE,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DATAREG,null)) {");
        status.out.println(" window[f].w_DATAREG.setTime(("+SPLib.ToJSValue(status.w_DATAREG,"D",0,0)+").getTime())");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLAGCONT,null)) {");
        status.out.println("window[f].w_FLAGCONT="+SPLib.ToJSValue(status.w_FLAGCONT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPOOPRAP,null)) {");
        status.out.println("window[f].w_TIPOOPRAP="+SPLib.ToJSValue(status.w_TIPOOPRAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODANA,null)) {");
        status.out.println("window[f].w_CODANA="+SPLib.ToJSValue(status.w_CODANA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODVOC,null)) {");
        status.out.println("window[f].w_CODVOC="+SPLib.ToJSValue(status.w_CODVOC,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_VALUTA,null)) {");
        status.out.println("window[f].w_VALUTA="+SPLib.ToJSValue(status.w_VALUTA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAMBIO,null)) {");
        status.out.println("window[f].w_CAMBIO="+SPLib.ToJSValue(status.w_CAMBIO,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNESCLI,null)) {");
        status.out.println("window[f].w_CONNESCLI="+SPLib.ToJSValue(status.w_CONNESCLI,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CONNESBEN,null)) {");
        status.out.println("window[f].w_CONNESBEN="+SPLib.ToJSValue(status.w_CONNESBEN,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_RAG,null)) {");
        status.out.println("window[f].w_C_RAG="+SPLib.ToJSValue(status.w_C_RAG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CTA,null)) {");
        status.out.println("window[f].w_C_CTA="+SPLib.ToJSValue(status.w_C_CTA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_PRV,null)) {");
        status.out.println("window[f].w_C_PRV="+SPLib.ToJSValue(status.w_C_PRV,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CAP,null)) {");
        status.out.println("window[f].w_C_CAP="+SPLib.ToJSValue(status.w_C_CAP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_CAB,null)) {");
        status.out.println("window[f].w_C_CAB="+SPLib.ToJSValue(status.w_C_CAB,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_IND,null)) {");
        status.out.println("window[f].w_C_IND="+SPLib.ToJSValue(status.w_C_IND,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_C_STA,null)) {");
        status.out.println("window[f].w_C_STA="+SPLib.ToJSValue(status.w_C_STA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODINTER,null)) {");
        status.out.println("window[f].w_CODINTER="+SPLib.ToJSValue(status.w_CODINTER,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODDIPE,null)) {");
        status.out.println("window[f].w_CODDIPE="+SPLib.ToJSValue(status.w_CODDIPE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCCITDIP,null)) {");
        status.out.println("window[f].w_DESCCITDIP="+SPLib.ToJSValue(status.w_DESCCITDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_SEGNO,null)) {");
        status.out.println("window[f].w_SEGNO="+SPLib.ToJSValue(status.w_SEGNO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLAGFRAZ,null)) {");
        status.out.println("window[f].w_FLAGFRAZ="+SPLib.ToJSValue(status.w_FLAGFRAZ,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_COLLEG,null)) {");
        status.out.println("window[f].w_COLLEG="+SPLib.ToJSValue(status.w_COLLEG,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVINCIADIP,null)) {");
        status.out.println("window[f].w_PROVINCIADIP="+SPLib.ToJSValue(status.w_PROVINCIADIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODCABDIP,null)) {");
        status.out.println("window[f].w_CODCABDIP="+SPLib.ToJSValue(status.w_CODCABDIP,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TOTLIRE,null)) {");
        status.out.println("window[f].w_TOTLIRE="+SPLib.ToJSValue(status.w_TOTLIRE,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TOTCONT,null)) {");
        status.out.println("window[f].w_TOTCONT="+SPLib.ToJSValue(status.w_TOTCONT,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CACODICE,null)) {");
        status.out.println("window[f].w_CACODICE="+SPLib.ToJSValue(status.w_CACODICE,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAIDBIGLIETTO,null)) {");
        status.out.println("window[f].w_CAIDBIGLIETTO="+SPLib.ToJSValue(status.w_CAIDBIGLIETTO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAFLGOPE,null)) {");
        status.out.println("window[f].w_CAFLGOPE="+SPLib.ToJSValue(status.w_CAFLGOPE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ATTIV,null)) {");
        status.out.println("window[f].w_ATTIV="+SPLib.ToJSValue(status.w_ATTIV,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MIDBIGLIETTO,null)) {");
        status.out.println("window[f].w_MIDBIGLIETTO="+SPLib.ToJSValue(status.w_MIDBIGLIETTO,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MIDBIGLIETTO1,null)) {");
        status.out.println("window[f].w_MIDBIGLIETTO1="+SPLib.ToJSValue(status.w_MIDBIGLIETTO1,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MIDBIGLIETTO2,null)) {");
        status.out.println("window[f].w_MIDBIGLIETTO2="+SPLib.ToJSValue(status.w_MIDBIGLIETTO2,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MIDBIGLIETTO3,null)) {");
        status.out.println("window[f].w_MIDBIGLIETTO3="+SPLib.ToJSValue(status.w_MIDBIGLIETTO3,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_MIDBIGLIETTO4,null)) {");
        status.out.println("window[f].w_MIDBIGLIETTO4="+SPLib.ToJSValue(status.w_MIDBIGLIETTO4,"M",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_ASSEGNO,null)) {");
        status.out.println("window[f].w_ASSEGNO="+SPLib.ToJSValue(status.w_ASSEGNO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_VLTPLAT,null)) {");
        status.out.println("window[f].w_VLTPLAT="+SPLib.ToJSValue(status.w_VLTPLAT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CC4CIFRE,null)) {");
        status.out.println("window[f].w_CC4CIFRE="+SPLib.ToJSValue(status.w_CC4CIFRE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CCDATSCA,null)) {");
        status.out.println("window[f].w_CCDATSCA="+SPLib.ToJSValue(status.w_CCDATSCA,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_NUMTEL,null)) {");
        status.out.println("window[f].w_NUMTEL="+SPLib.ToJSValue(status.w_NUMTEL,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_TIPOGIOCO,null)) {");
        status.out.println("window[f].w_TIPOGIOCO="+SPLib.ToJSValue(status.w_TIPOGIOCO,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RDCODAUT,null)) {");
        status.out.println("window[f].w_RDCODAUT="+SPLib.ToJSValue(status.w_RDCODAUT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_RDLOCAUT,null)) {");
        status.out.println("window[f].w_RDLOCAUT="+SPLib.ToJSValue(status.w_RDLOCAUT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CGOFLGVLT,null)) {");
        status.out.println("window[f].w_CGOFLGVLT="+SPLib.ToJSValue(status.w_CGOFLGVLT,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PEPDESCRI,null)) {");
        status.out.println("window[f].w_PEPDESCRI="+SPLib.ToJSValue(status.w_PEPDESCRI,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLGDOM,null)) {");
        status.out.println("window[f].w_FLGDOM="+SPLib.ToJSValue(status.w_FLGDOM,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PAESE2,null)) {");
        status.out.println("window[f].w_PAESE2="+SPLib.ToJSValue(status.w_PAESE2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DOMICILIO2,null)) {");
        status.out.println("window[f].w_DOMICILIO2="+SPLib.ToJSValue(status.w_DOMICILIO2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROVINCIA2,null)) {");
        status.out.println("window[f].w_PROVINCIA2="+SPLib.ToJSValue(status.w_PROVINCIA2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_DESCCIT2,null)) {");
        status.out.println("window[f].w_DESCCIT2="+SPLib.ToJSValue(status.w_DESCCIT2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CAP2,null)) {");
        status.out.println("window[f].w_CAP2="+SPLib.ToJSValue(status.w_CAP2,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_PROFESSIONE,null)) {");
        status.out.println("window[f].w_PROFESSIONE="+SPLib.ToJSValue(status.w_PROFESSIONE,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_IMPWALLET,null)) {");
        status.out.println("window[f].w_IMPWALLET="+SPLib.ToJSValue(status.w_IMPWALLET,"N",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODWALLET,null)) {");
        status.out.println("window[f].w_CODWALLET="+SPLib.ToJSValue(status.w_CODWALLET,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_FLAGWALLET,null)) {");
        status.out.println("window[f].w_FLAGWALLET="+SPLib.ToJSValue(status.w_FLAGWALLET,"C",0,0)+";");
        status.out.println("}");
        status.out.println("if (Ne(window[f].w_CODTRANSZ,null)) {");
        status.out.println("window[f].w_CODTRANSZ="+SPLib.ToJSValue(status.w_CODTRANSZ,"C",0,0)+";");
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
      arrt_cgo_moduliR Rcalled;
      Rcalled = new arrt_cgo_moduliR(status.context,status);
      com.zucchetti.sitepainter.Logger l = com.zucchetti.sitepainter.Logger.getWarningLogger();
      Rcalled.m_cLastMsgError = status.context.Translate("MSG_WRONG_ROUTINE_ACTION",status.m_cAction,"arrt_cgo_moduli");
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
