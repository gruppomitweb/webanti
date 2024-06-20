public class armt_basea7WV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_ANNO;
  public String w_SEMESTRE;
  public String w_FLGINVIATO;
  // variabili che puntano ai figli
  public ardt_dettaglioa7BO ardt_dettaglioa7;
  public String m_cWv_ardt_dettaglioa7;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
