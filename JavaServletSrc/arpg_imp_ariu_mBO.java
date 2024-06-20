// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_imp_ariu_mBO extends arpg_imp_ariu_mBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_imp_ariu_mBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gFlgWU",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gFlgWU"),w_gFlgWU)) {
        m_Ctx.SetGlobalString("gFlgWU",w_gFlgWU);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
