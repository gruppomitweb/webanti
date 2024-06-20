public class armt_ae_anarapWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_RAPPORTO;
  public String w_DESCRAP;
  public String w_TIPORAP;
  public String w_TIPOAG;
  public String w_ISOAGE;
  public String w_FLAGLIRE;
  public String w_VALUTA;
  public double w_PRGIMPRAP;
  //   variabile per il progressivo
  public double op_PRGIMPRAP;
  public String w_CODDIP;
  public double w_NOPROT;
  public String w_gTelepass;
  public String w_gCodDip;
  public String w_gBrowser;
  public String w_gTipInter;
  public String w_descval;
  public double w_daticoll;
  public String w_titolo;
  public String w_mess;
  // variabili che puntano ai figli
  public ardt_ae_delegaboBO ardt_ae_delegabo;
  public String m_cWv_ardt_ae_delegabo;
  public ardt_saldioroBO ardt_saldioro;
  public String m_cWv_ardt_saldioro;
  public ardt_jarantboBO ardt_jarantbo;
  public String m_cWv_ardt_jarantbo;
  public ardt_ae_saldianno_rapBO ardt_ae_saldianno_rap;
  public String m_cWv_ardt_ae_saldianno_rap;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_TIPOAG;
  public String o_FLAGLIRE;
  public String o_VALUTA;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
