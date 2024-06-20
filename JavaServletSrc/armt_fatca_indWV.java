public class armt_fatca_indWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CONNES;
  public String w_IDBASE;
  public String w_COUNTRYCOD;
  public String w_ADDRESSTYP;
  public String w_STREET;
  public String w_BUILDINGID;
  public String w_SUITEIDENT;
  public String w_FLOORIDENT;
  public String w_DISTRICTNA;
  public String w_POB;
  public String w_POSTCODE;
  public String w_CITY;
  public String w_COUNTRYSUB;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
