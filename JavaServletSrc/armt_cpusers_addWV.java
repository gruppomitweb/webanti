public class armt_cpusers_addWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_CODE;
  public String w_CODDIP;
  public String w_NAME;
  public String w_SURNAME;
  public String w_EMAIL;
  public String w_EMPLOYEE;
  public String w_SUPERDIP;
  public java.sql.Date w_DATECREATE;
  public String w_xDESCRIZ;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
