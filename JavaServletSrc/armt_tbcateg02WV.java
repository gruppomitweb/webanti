public class armt_tbcateg02WV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_C2CODTAB;
  public String w_C2CODICE;
  public String w_C2DESCRI;
  public String w_IDBASE;
  // variabili che puntano ai figli
  public ardt_categrisBO ardt_categris;
  public String m_cWv_ardt_categris;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
