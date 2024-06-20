public class armt_tblimconWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_LCCODICE;
  //   variabile per il progressivo
  public String op_LCCODICE;
  public java.sql.Date w_LCDATINI;
  public java.sql.Date w_LCDATFIN;
  public double w_LCIMPMAX;
  public String w_LCVALPER;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
