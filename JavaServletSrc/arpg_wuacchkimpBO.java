// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_wuacchkimpBO extends arpg_wuacchkimpBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_wuacchkimpBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gTelepass",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gTelepass"),w_gTelepass)) {
        m_Ctx.SetGlobalString("gTelepass",w_gTelepass);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
