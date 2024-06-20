public class opemt_scarti_contanteWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_NUMPROG;
  public String w_TIPATT;
  public String w_TIPOATTIV;
  public String w_CODICEGLN;
  public double w_TOTBANKNOTE;
  public double w_TAGLIO;
  public double w_NBANCONOTE;
  public String w_ABIINTER;
  public String w_ABIPROPR;
  public String w_GLNALTROSOG;
  public String w_GLNALTRASC;
  public String w_CODCLICON;
  public String w_CODCOMCON;
  public String w_ATECO_CON;
  public String w_CODDIPE;
  public String w_IMPPROG;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
