import java.util.*;

public class spadministration_changepasswordBL extends spadministration_changepasswordWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che mantiene il vecchio timestamp
  public String m_cOldCPCCCHK;
  public java.util.List<String> m_oParameters;
  protected String m_cPassword;
  protected String m_cOTP;
  //  Variabile che indica il tipo dell'ultimo
  //  errore, o messaggio da comunicare all'interfaccia,
  //  che si è verificato impostando una variabile di work.
  //  I valori ammessi sono:
  //  - 1     : errore di campo obbligatorio
  //  - 2     : errore di check
  //  - 3     : valore non ammesso nel link
  //  - 4     : richiesta password
  //  - 5     : richiesto otp
  public int m_nLastError;
  public String m_cLastMsgError;
  public String m_cLastWorkVarError;
  // m_bCalculating==true la Calculate e' in esecuzione
  public boolean m_bCalculating = false;
  public static final String i_EntityName = "spadministration_changepassword";
  public static final String i_EntityType = "dialog";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {""};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'old_password':old_password,'new_password':new_password,'confirm_password':confirm_password}";
  public static final String i_CompleteStateStructure = "{'old_password':old_password,'new_password':new_password,'confirm_password':confirm_password,'errormessage':errormessage,'calcomplex':calcomplex,'pwdcomplexity':pwdcomplexity,'pwddaysduration':pwddaysduration,'cachekey':cachekey,'root_m_cURL_servlet':root_m_cURL_servlet,'pwdciclicity':pwdciclicity,'pwdcaptchalevel_applied':pwdcaptchalevel_applied,'pwdratecause':pwdratecause,'changeReason':changeReason,'m_cAtExit':m_cAtExit,'pwd1_view':pwd1_view,'pwd2_view':pwd2_view,'pwd3_view':pwd3_view}";
  public static final String i_ItemSequence = "old_password,new_password,confirm_password";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),"",new String[][]{new String[]{"old_password","MSG_OLD_PASSWORD","C","20","0","variabile","nokey","false","false"},new String[]{"new_password","MSG_NEW_PASSWORD","C","20","0","variabile","nokey","false","false"},new String[]{"confirm_password","MSG_CONFIRM_PASSWORD","C","20","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public spadministration_changepasswordBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_old_password = "";
    w_new_password = "";
    w_confirm_password = "";
    w_errormessage = "";
    w_cachekey = "";
    w_root_m_cURL_servlet = "";
    w_changeReason = "";
    w_m_cAtExit = "";
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public void SaveDependsOn() {
    o_new_password = w_new_password;
  }
  public void NotifyEvent(String p_cEvent) {
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_old_password(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_old_password = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_new_password(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_new_password = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_confirm_password(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_confirm_password = p_workVariableValue;
    // 
    l_bResult = CPLib.eq(w_confirm_password,w_new_password);
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "MSG_PASSWORD_CONFIRM_DIFFERENT";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_confirm_password = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getVisible_calcomplex() {
    return true;
  }
  public boolean getVisible_pwdcomplexity() {
    return true;
  }
  public boolean getVisible_pwddaysduration() {
    return true;
  }
  public boolean getVisible_pwdciclicity() {
    return true;
  }
  public boolean getVisible_pwdcaptchalevel_applied() {
    return true;
  }
  public boolean Set_Password(String p_pwd) {
    m_cPassword = p_pwd;
    return true;
  }
  public boolean Set_OTP(String p_otp) {
    m_cOTP = p_otp;
    return true;
  }
  public boolean Calculate() {
    boolean l_bTmpRes;
    l_bTmpRes = true;
    boolean l_bResult;
    l_bResult = true;
    m_bCalculating = true;
    w_calcomplex = UserAdmin.Make(m_Ctx).GetPasswordRating(w_new_password);
    w_pwdratecause = UserAdmin.Make(m_Ctx).GetPasswordRatingExplaination(w_new_password);
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    m_bCalculating = false;
    return l_bResult;
  }
  boolean Check_WKDURBIBSO(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
      l_bResult = UserAdmin.Make(m_Ctx).CheckPasswordStrength(w_new_password,w_pwdcomplexity);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "MSG_WEAKY_PASSWORD";
      } else {
        l_bResult = CPLib.ne(w_new_password,w_old_password);
        if ( ! (l_bResult)) {
          m_cLastMsgError = "MSG_PASSWORD_MUST_DIFFERENT";
        } else {
          l_bResult = CPLib.eq(w_new_password,w_confirm_password);
          if ( ! (l_bResult)) {
            m_cLastMsgError = "MSG_PASSWORD_CONFIRM_DIFFERENT";
          }
        }
      }
    }
    return l_bResult;
  }
  protected void BlankStatusVariables() {
    m_bUpdated = false;
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("spadministration_changepassword","",m_KeyColumns,m_Ctx);
    return l_cFilter;
  }
  public void SetFromContext(String s) {
    SetFromContext(s,null);
  }
  public void SetFromContext(java.util.Properties p) {
    SetFromContext("_dummy_",p);
  }
  public void SetFromContext(String s,java.util.Properties p) {
    BlankStatusVariables();
    w_old_password = "";
    w_new_password = "";
    w_confirm_password = "";
    w_errormessage = "";
    w_calcomplex = 0;
    w_pwdcomplexity = 0;
    w_pwddaysduration = 0;
    w_cachekey = "";
    w_root_m_cURL_servlet = "";
    w_pwdciclicity = 0;
    w_pwdcaptchalevel_applied = 0;
    w_pwdratecause = "";
    w_changeReason = "";
    w_m_cAtExit = "";
    w_pwd1_view = false;
    w_pwd2_view = false;
    w_pwd3_view = false;
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_old_password = CPLib.GetProperty(p,"old_password",w_old_password,0);
      w_new_password = CPLib.GetProperty(p,"new_password",w_new_password,0);
      w_confirm_password = CPLib.GetProperty(p,"confirm_password",w_confirm_password,0);
      w_errormessage = CPLib.GetProperty(p,"errormessage",w_errormessage,0);
      w_calcomplex = CPLib.GetProperty(p,"calcomplex",w_calcomplex,0);
      w_pwdcomplexity = CPLib.GetProperty(p,"pwdcomplexity",w_pwdcomplexity,0);
      w_pwddaysduration = CPLib.GetProperty(p,"pwddaysduration",w_pwddaysduration,0);
      w_cachekey = CPLib.GetProperty(p,"cachekey",w_cachekey,0);
      w_root_m_cURL_servlet = CPLib.GetProperty(p,"root_m_cURL_servlet",w_root_m_cURL_servlet,0);
      w_pwdciclicity = CPLib.GetProperty(p,"pwdciclicity",w_pwdciclicity,0);
      w_pwdcaptchalevel_applied = CPLib.GetProperty(p,"pwdcaptchalevel_applied",w_pwdcaptchalevel_applied,0);
      w_pwdratecause = CPLib.GetProperty(p,"pwdratecause",w_pwdratecause,0);
      w_changeReason = CPLib.GetProperty(p,"changeReason",w_changeReason,0);
      w_m_cAtExit = CPLib.GetProperty(p,"m_cAtExit",w_m_cAtExit,0);
      w_pwd1_view = CPLib.GetProperty(p,"pwd1_view",w_pwd1_view,0);
      w_pwd2_view = CPLib.GetProperty(p,"pwd2_view",w_pwd2_view,0);
      w_pwd3_view = CPLib.GetProperty(p,"pwd3_view",w_pwd3_view,0);
      SetUpdated();
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
  }
  public String EntityStatus() {
    return "D";
  }
  public String LastErrorMessage() {
    return m_cLastMsgError;
  }
  static void GetLinkDef0(Map<String,List<Map<String,String[]>>> tables) {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    return tables;
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
