public class spadministration_mobappstoreWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public String w_oa__code;
  //   variabile per il progressivo
  public String op_oa__code;
  public double w_oaapppublished;
  public String w_oareserved;
  public String w_oaappmenu;
  public String w_oaapptitle;
  public String w_oadescri;
  public String w_oaapplogo;
  public String w_oaappfavico;
  public String w_oaapplanding;
  public String w_oaskinname;
  public String w_oaappvariantname;
  public String w_oaappheader;
  public String w_oaappdescrheader;
  public double w_oaapphideutilitygroup;
  public String w_oaapphomelink;
  public String w_oaappchecksum;
  public String w_OAAPPACCESSMODE;
  public String w_oaappdevtyp;
  public double w_oaappreqreg;
  public String w_oaappurlreg;
  public boolean w_changeSkin;
  public double w_combo_homelink;
  public String w_custom_homelink;
  public boolean w_forceCreateFile;
  public boolean w_ignoreFile;
  // variabili che puntano ai figli
  public spadministration_dmobapp_qkmBO spadministration_dmobapp_qkm;
  public String m_cWv_spadministration_dmobapp_qkm;
  public spadministration_mobapppermissionsBO spadministration_mobapppermissions;
  public String m_cWv_spadministration_mobapppermissions;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public double o_oaappreqreg;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
