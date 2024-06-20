public class ardt_ope_contanteWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_IDOPE;
  public String w_TIPATT;
  public String w_TIPOATTIV;
  public String w_CODICEGLN;
  public String w_CODCLICON;
  public String w_ATECO_CON;
  public String w_CODCOMCON;
  public String w_ABIINTER;
  public String w_ABIPROPR;
  public String w_GLNALTROSOG;
  public String w_GLNALTRASC;
  public double w_BILLSRIT;
  public double w_BILLSSOV;
  public double w_TAGLIO;
  public double w_NBANCONOTE;
  public String w_xDESATECO;
  public String w_xDESCITTA;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public double opk_TAGLIO;
}
