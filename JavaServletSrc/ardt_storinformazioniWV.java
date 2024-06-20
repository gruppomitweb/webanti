public class ardt_storinformazioniWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDBASE;
  public String w_CODINTER;
  public java.sql.Date w_DATAINI;
  public java.sql.Date w_DATAFINE;
  public String w_TIPOPERS;
  public String w_NUMPROG1;
  public String w_NUMPROG2;
  public String w_RAPPORTO;
  public double w_PRGIMPSOG;
  public String w_STATOREG;
  public String w_IDEREG;
  public String w_TIPORAP;
  public String w_xragsoci;
  public String w_tipreg;
  public double w_appoggio;
  public double w_tiporegr;
  public String w_DOMICILIO;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CAP;
  public String w_gAzienda;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
