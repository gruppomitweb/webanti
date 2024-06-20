public class spauthid_scopeWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_name;
  public String w_description;
  public String w_protocol;
  // variabili che puntano ai figli
  public spauthid_scope_mapperBO spauthid_scope_mapper;
  public String m_cWv_spauthid_scope_mapper;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
