public class armt_mtstatiWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODSTA;
  //   variabile per il progressivo
  public String op_CODSTA;
  public String w_DESCRI;
  public String w_SIGLA;
  public String w_xDESCRI;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
