public class ardt_opextrboWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_COLLEG;
  public String w_ANNO;
  public String w_IDBASE;
  public java.sql.Date w_DATAOPE;
  public String w_COINT;
  public String w_NOTE;
  public double w_SALDO;
  public double w_QUANTITA;
  public String w_VALUTA;
  public double w_PROGOPEX;
  public String w_xdesval;
  public String w_gAzienda;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_ANNO;
}
