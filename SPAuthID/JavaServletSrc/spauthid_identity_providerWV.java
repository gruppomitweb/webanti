public class spauthid_identity_providerWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_code;
  //   variabile per il progressivo
  public String op_code;
  public String w_autologin;
  public String w_idp_name;
  public String w_protocol;
  public String w_client_id;
  public String w_client_secret;
  public String w_redirect_uri;
  public String w_scope;
  public String w_auth_uri;
  public String w_token_uri;
  public String w_jwks_uri;
  public String w_mutual_jwks;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
