public class armt_tbcateg01WV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_C1CODTAB;
  public String w_C1CODICE;
  public String w_C1DESCRI;
  public String w_IDBASE;
  // variabili che puntano ai figli
  public ardt_categrisBO ardt_categris;
  public String m_cWv_ardt_categris;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietÓ dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
