public class armt_ae_opextrboWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_COLLEG;
  public String w_ANNO;
  public String w_CONNESOPER;
  public double w_SALDO;
  public double w_QUANTITA;
  public String w_VALUTA;
  public String w_UNIQUER;
  public String w_OLDINTER;
  public double w_INVIATO;
  public java.sql.Date w_DATAINVIO;
  public java.sql.Date w_DATAMODI;
  public double w_ANNULLA;
  public java.sql.Date w_DATAANNU;
  public String w_IDESITO;
  public double w_INVSALDO;
  public java.sql.Date w_DTSALDO;
  public java.sql.Date w_DATAOPE;
  public String w_CFESTERO;
  public String w_NATURA;
  public String w_xRAGSOC;
  public String w_xRAGSOC2;
  // variabili che puntano ai figli
  public ardt_delegaopBO ardt_delegaop;
  public String m_cWv_ardt_delegaop;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
