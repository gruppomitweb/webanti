public class spadministration_usersWV extends CallerBRImpl {
  /*  Dichiarazione delle variabili di lavoro: riflettono gli interventi dell'utente
                              o di una procedura nell'applicazione. Vengono utilizzate per aggiornare e
                              interrogare il database collegato.
                            */
  public double w_code;
  public String w_fullname;
  public String w_name;
  public boolean w_accesstype_human;
  public boolean w_accesstype_service;
  public boolean w_accesstype_machine;
  public double w_pwdcomplexity;
  public boolean w_forcepwdchange;
  public String w_enabled;
  public String w_language;
  public String w_decimalseparator;
  public String w_thousandseparator;
  public String w_datepattern;
  public String w_datetimepattern;
  public double w_pwddaysduration;
  public double w_pwdciclicity;
  public double w_captchalevel;
  public java.sql.Date w_datestart;
  public java.sql.Date w_datestop;
  public double w_failedlogins;
  public java.sql.Timestamp w_lastfailedlogin;
  public java.sql.Timestamp w_lastsuccessfullogin;
  public java.sql.Timestamp w_pwdcreate;
  public String w_printserver;
  public java.sql.Timestamp w_createdwhen;
  public String w_usesiarlicense;
  public String w_companies;
  public double w_modifyPassword;
  public String w_pwd1;
  public double w_calcomplex;
  public String w_pwdratecause;
  public String w_pwd2;
  public double w_pwdcomplexity_group;
  public double w_pwdcomplexity_reqired;
  public String w_language_name;
  public double w_pwddaysduration_group;
  public double w_pwdciclicity_groups;
  public double w_pwdcaptchalevel_group;
  public double w_pwddaysduration_applied;
  public double w_pwdciclicity_applied;
  public double w_pwdcaptchalevel_applied;
  public double w_init_code;
  public boolean w_pwd_modified;
  public boolean w_IAR_LICENSE_VALID;
  public double w_IAR_LICENSES;
  public double w_IAR_USED;
  public double w_IAR_AVAILABLE;
  public double w_selected_group;
  public String w_g_OTPisActive;
  public String w_otp;
  public String w_UFENABLEAZI;
  public boolean w_pwd1_view;
  public boolean w_pwd2_view;
  // variabili che puntano ai figli
  public spadministration_usersgroupsBO spadministration_usersgroups;
  public String m_cWv_spadministration_usersgroups;
  public spadministration_ssomap_childBO spadministration_ssomap_child;
  public String m_cWv_spadministration_ssomap_child;
  public spadministration_historypwdBO spadministration_historypwd;
  public String m_cWv_spadministration_historypwd;
  public spadministration_usercompaniesBO spadministration_usercompanies;
  public String m_cWv_spadministration_usercompanies;
  public CPMNTChild[] m_MNTs = new CPMNTChild[]{};
  // variabili per DependsOn
  public double o_code;
  public double o_modifyPassword;
  public String o_pwd1;
  public String o_pwd2;
  public double o_pwddaysduration_group;
  public double o_pwddaysduration;
  public double o_pwdciclicity_groups;
  public double o_pwdciclicity;
  public double o_pwdcaptchalevel_group;
  public double o_captchalevel;
  public double o_selected_group;
  public String o_companies;
  public String o_UFENABLEAZI;
  // variabile contenente i valori per i campi aggiunti e le proprietà dei rispettivi campi
  public XDCFieldValue[] extendedFields = new XDCFieldValue[]{};
}
