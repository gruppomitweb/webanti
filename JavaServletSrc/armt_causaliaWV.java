public class armt_causaliaWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODCAU;
  public String w_DESCRI;
  public String w_SEGNO;
  public String w_CAUSINT;
  public String w_idbase;
  public String w_VALPERINT;
  public java.sql.Date w_DATINI;
  public java.sql.Date w_DATAVALI;
  public String w_FLGINTER;
  public String w_NOSARA;
  public String w_descau;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
