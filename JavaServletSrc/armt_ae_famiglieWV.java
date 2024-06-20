public class armt_ae_famiglieWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_RAPPORTO;
  public String w_TIPOAG;
  public String w_COINT;
  public String w_DESCRI;
  public String w_OLDINTER;
  public String w_VALUTA;
  public String w_CAB;
  public double w_INVIATO;
  public java.sql.Date w_DATAINVIO;
  public java.sql.Date w_DATAMODI;
  public double w_ANNULLA;
  public java.sql.Date w_DATAANNU;
  public String w_IDESITOFAM;
  public String w_UNIQUECODE;
  public double w_INVIATOC;
  public java.sql.Date w_DATAINVIOC;
  // variabili che puntano ai figli
  public ardt_ae_saldianno_rapBO ardt_ae_saldianno_rap;
  public String m_cWv_ardt_ae_saldianno_rap;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_TIPOAG;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
