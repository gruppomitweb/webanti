public class opemt_tbcauintWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_CICODICE;
  //   variabile per il progressivo
  public double op_CICODICE;
  public String w_CICAUCOD;
  public String w_CIFINALIT;
  public double w_CIRISCHIO;
  public String w_gIntemediario;
  public String w_TIPOOPER;
  public String w_xdesccausale;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public String o_gIntemediario;
  public String o_CICAUCOD;
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
