// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class utpg_chgpwdBO extends utpg_chgpwdBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public utpg_chgpwdBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gUtente",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gUtente"),w_gUtente)) {
        m_Ctx.SetGlobalString("gUtente",w_gUtente);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalNumber("gUserCode",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalNumber("gUserCode"),w_gUserCode)) {
        m_Ctx.SetGlobalNumber("gUserCode",w_gUserCode);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
