public class armt_cgo_infbachecaWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_IBCODICE;
  //   variabile per il progressivo
  public double op_IBCODICE;
  public String w_IBCODCAT;
  public String w_IBINFATT;
  public String w_IBTITOLO;
  public String w_IBDESCRI;
  public java.sql.Date w_IBDATSCA;
  public java.sql.Date w_IBDATINS;
  // variabili che puntano ai figli
  public ardt_cgo_infbacheca_docBO ardt_cgo_infbacheca_doc;
  public String m_cWv_ardt_cgo_infbacheca_doc;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  public String op_codazi;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
