// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_abbina_602_202501BO extends arpg_abbina_602_202501BL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_abbina_602_202501BO (CPContext p_ContextObject) {
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
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gFlgCMod",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gFlgCMod"),w_gFlgCMod)) {
        m_Ctx.SetGlobalString("gFlgCMod",w_gFlgCMod);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
