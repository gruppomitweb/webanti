// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_terne_saldiBO extends arpg_terne_saldiBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_terne_saldiBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gDescAzi",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gDescAzi"),w_gDescAzi)) {
        m_Ctx.SetGlobalString("gDescAzi",w_gDescAzi);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
