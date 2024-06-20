// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_esiti_delopeBO extends arpg_esiti_delopeBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_esiti_delopeBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gMsgImp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gMsgImp"),w_gMsgImp)) {
        m_Ctx.SetGlobalString("gMsgImp",w_gMsgImp);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_gokprintesiti,
  public static final String i_InvokedRoutines = ",arfn_gokprintesiti,";
}
