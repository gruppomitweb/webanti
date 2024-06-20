public class spadministration_mobapppermissionsWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_pecodice;
  public double w_pe__tipo;
  public double w_pecodute;
  public double w_pecodgrp;
  public double w_CPROWNUM;
  public String w_descrizione;
  public String w_descriGruppo;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
}
