// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class uicpg_import_clientiBO extends uicpg_import_clientiBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public uicpg_import_clientiBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gAzienda",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gAzienda"),w_gAzienda)) {
        m_Ctx.SetGlobalString("gAzienda",w_gAzienda);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
