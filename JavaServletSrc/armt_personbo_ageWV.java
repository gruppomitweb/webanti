public class armt_personbo_ageWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_TIPOPERS;
  public String w_COGNOME;
  public String w_NOME;
  public double w_CFESTERO;
  public String w_RAGSOC;
  public String w_PAESE;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_idcitta;
  public String w_CAP;
  public String w_CODCAB;
  public String w_DOMICILIO;
  public String w_IDENT;
  public String w_IDNASCOMUN;
  public String w_NASCOMUN;
  public String w_TIPINTER;
  public String w_IDNASSTATO;
  public String w_NASSTATO;
  public String w_SESSO;
  public java.sql.Date w_DATANASC;
  public String w_TIPODOC;
  public String w_NUMDOCUM;
  public java.sql.Date w_DATARILASC;
  public java.sql.Date w_DATAVALI;
  public String w_AUTRILASC;
  public String w_CODFISC;
  public String w_PARTIVA;
  public String w_CONTO;
  public String w_SOTGRUP;
  public String w_RAMOGRUP;
  public String w_ATTIV;
  public String w_SETTSINT;
  public String w_CONNES;
  public double w_NOTIT;
  public String w_PEP;
  public String w_CRIME;
  public double w_PROGIMPORT;
  //   variabile per il progressivo
  public double op_PROGIMPORT;
  public String w_NOTE;
  public String w_OLDSETSIN;
  public String w_NOSARA;
  public java.sql.Date w_CRIMEDATE;
  public java.sql.Date w_PEPDATE;
  public String w_gSeekAos;
  public java.sql.Date w_gDataVaria;
  public String w_gFlgDoc;
  public String w_gTipInter;
  public String w_gIntemediario;
  public String w_gVerSim;
  public String w_gFlgWU;
  public String w_nascomunid;
  public String w_nasstatoid;
  public java.sql.Date w_dataoggi;
  public String w_tipsot;
  public String w_flgaggfam;
  public String w_DESCSGRU;
  public String w_DESCRAMGRU;
  public String w_DESCUIC;
  public String w_dessta;
  public java.sql.Date w_DATARETT;
  public String w_STATOREG;
  public String w_NUMPROG;
  public String w_DESCRI;
  public String w_xdescareag;
  public String w_xdescnatgiu;
  public String w_xdesctipatt;
  public String w_xdesccomp;
  public String w_xstatonas;
  public java.sql.Date w_finesae;
  public java.sql.Date w_finesint;
  public String w_xFLGVALIDO;
  public String w_xFLGANAVAL;
  public String w_CONADD;
  public String w_xDSETSIN;
  public String w_xITFLGPEP;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_gIntemediario;
  public String o_COGNOME;
  public String o_NOME;
  public String o_PAESE;
  public String o_DESCCIT;
  public String o_idcitta;
  public String o_IDNASCOMUN;
  public String o_IDNASSTATO;
  public String o_NASSTATO;
  public java.sql.Date o_DATANASC;
  public String o_TIPODOC;
  public String o_NUMDOCUM;
  public java.sql.Date o_DATARILASC;
  public java.sql.Date o_DATAVALI;
  public String o_SOTGRUP;
  public String o_RAMOGRUP;
  public String o_ATTIV;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le propriet� dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}