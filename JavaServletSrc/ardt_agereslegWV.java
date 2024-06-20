public class ardt_agereslegWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODMAGE;
  public String w_COGNOME;
  public String w_NOME;
  public String w_CODFISC;
  public String w_IDBASE;
  public double w_CPROWNUM;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
