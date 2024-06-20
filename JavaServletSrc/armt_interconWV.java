public class armt_interconWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_CODINTER;
  public String w_CODDIPE;
  public String w_RAGSOC;
  public String w_TIPINTER;
  public String w_PAESE;
  public String w_DESCCIT;
  public String w_DOMICILIO;
  public String w_CODFISC;
  public String w_CODCAB;
  public String w_PROVINCIA;
  public String w_CAP;
  public String w_PARTIVA;
  public String w_IDCITTA;
  public String w_xdescstat;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_IDCITTA;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
