public class armt_storanarapWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_RAPPORTO;
  public String w_DESCRAP;
  public String w_TIPORAP;
  public String w_TIPOAG;
  public String w_FLAGLIRE;
  public String w_VALUTA;
  public double w_NOPROT;
  public String w_NATURA;
  public String w_SCOPO;
  public String w_AREAGEO;
  public String w_MODSVOL;
  public String w_RAGIO;
  public String w_TIPO;
  public double w_RFREQ;
  public double w_RIMP;
  public double w_RAREA;
  public double w_RCOMP;
  public double w_RRAGIO;
  public double w_RTIPO;
  public double w_PRGIMPRAP;
  //   variabile per il progressivo
  public double op_PRGIMPRAP;
  public String w_DURAT;
  public String w_AMMONT;
  public String w_SPLITCODE;
  public String w_MACODICE;
  public String w_CODDIP;
  public String w_descval;
  public double w_daticoll;
  public String w_xdescmodsvo;
  public String w_xdescareag;
  public String w_xdescplauso;
  public String w_xdesctipor;
  public String w_xdescfreq;
  public String w_xdescammo;
  public String w_gTelepass;
  public String w_xMADESCRI;
  public String w_mess;
  public String w_gBrowser;
  public String w_gCodDip;
  // variabili che puntano ai figli
  public ardt_delegaboBO ardt_delegabo;
  public String m_cWv_ardt_delegabo;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_FLAGLIRE;
  public String o_VALUTA;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
