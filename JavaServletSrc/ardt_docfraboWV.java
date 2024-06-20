public class ardt_docfraboWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_NUMPROG;
  public String w_CONNESCLI;
  public String w_TIPODOC;
  public String w_NUMDOCUM;
  public java.sql.Date w_DATARILASC;
  public String w_AUTRILASC;
  public java.sql.Date w_DATAVALI;
  public String w_DOMICILIO;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CAP;
  public String w_PAESE;
  public String w_xRagSocDoc;
  public String w_dessta;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
  public String[] work_children = new String[]{};
  public String opk_CONNESCLI;
}
