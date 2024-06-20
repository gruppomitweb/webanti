public class armt_anarapWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODDIP;
  public String w_RAPPORTO;
  public String w_DESCRAP;
  public String w_TIPORAP;
  public String w_TIPOAG;
  public String w_ISOAGE;
  public double w_NOPROT;
  public String w_FLAGLIRE;
  public String w_VALUTA;
  public double w_PRGIMPRAP;
  //   variabile per il progressivo
  public double op_PRGIMPRAP;
  public String w_IBAN;
  public String w_CODOGG;
  public String w_NATURA;
  public String w_SCOPO;
  public String w_DURAT;
  public double w_RFREQ;
  public String w_AMMONT;
  public double w_RIMP;
  public String w_AREAGEO;
  public double w_RAREA;
  public String w_MODSVOL;
  public double w_RCOMP;
  public String w_RAGIO;
  public double w_RRAGIO;
  public String w_TIPO;
  public double w_RTIPO;
  public String w_CODDIPE;
  public String w_RISGLOB;
  public java.sql.Date w_DATAPROF;
  public java.sql.Date w_DATAREVPROF;
  public double w_MITIG;
  public String w_MITGDOC;
  public String w_CATEG01;
  public String w_CATEG02;
  public String w_CATEG03;
  public String w_CATEG04;
  public String w_CATEG05;
  public String w_CATEGORIA;
  public double w_NOCANC;
  public String w_MACODICE;
  public String w_SPLITCODE;
  public String w_CODICELR;
  public String w_gTipInter;
  public String w_gBrowser;
  public String w_gTelepass;
  public String w_gCodDip;
  public String w_descval;
  public double w_daticoll;
  public String w_xdescmodsvo;
  public String w_xdescareag;
  public String w_xdescplauso;
  public String w_xdesctipor;
  public String w_xdescfreq;
  public String w_xdescammo;
  public String w_xDESDIPE;
  public String w_xMADESCRI;
  public String w_xRAGLEG;
  public String w_mess;
  public String w_xC1DESCRI;
  public String w_xC2DESCRI;
  public String w_xC3DESCRI;
  public String w_xC4DESCRI;
  public String w_xC5DESCRI;
  public String w_titolo;
  // variabili che puntano ai figli
  public ardt_garantboBO ardt_garantbo;
  public String m_cWv_ardt_garantbo;
  public ardt_ae_saldianno_rapBO ardt_ae_saldianno_rap;
  public String m_cWv_ardt_ae_saldianno_rap;
  public ardt_saldi_idpBO ardt_saldi_idp;
  public String m_cWv_ardt_saldi_idp;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_TIPOAG;
  public String o_FLAGLIRE;
  public String o_VALUTA;
  public String o_DURAT;
  public String o_AMMONT;
  public String o_AREAGEO;
  public String o_MODSVOL;
  public String o_RAGIO;
  public String o_TIPO;
  public String o_CATEG01;
  public String o_CATEG02;
  public String o_CATEG03;
  public String o_CATEG04;
  public String o_CATEG05;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
