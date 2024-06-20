// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_dlgspecificiBO extends arpg_dlgspecificiBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_dlgspecificiBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gIntemediario",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gIntemediario"),w_gIntemediario)) {
        m_Ctx.SetGlobalString("gIntemediario",w_gIntemediario);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gTipInter",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gTipInter"),w_gTipInter)) {
        m_Ctx.SetGlobalString("gTipInter",w_gTipInter);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_readnumeri,
  public static final String i_InvokedRoutines = ",arfn_readnumeri,";
}
