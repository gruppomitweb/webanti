public class armt_tbtipattWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODICE;
  public String w_DESCRI;
  public double w_RISCHIO;
  public double w_FLGALTO;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietÓ dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
