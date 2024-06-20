// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_trasfinfoBO extends arpg_trasfinfoBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_trasfinfoBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalNumber("gFlgDTP",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalNumber("gFlgDTP"),w_gFlgDTP)) {
        m_Ctx.SetGlobalNumber("gFlgDTP",w_gFlgDTP);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,azzera_messaggi,
  public static final String i_InvokedRoutines = ",azzera_messaggi,";
}
