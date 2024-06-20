// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_import_wuib_erroriBO extends arpg_import_wuib_erroriBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_import_wuib_erroriBO (CPContext p_ContextObject) {
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
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gPathApp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gPathApp"),w_gPathApp)) {
        m_Ctx.SetGlobalString("gPathApp",w_gPathApp);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gBrowser",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gBrowser"),w_gBrowser)) {
        m_Ctx.SetGlobalString("gBrowser",w_gBrowser);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gUrlApp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gUrlApp"),w_gUrlApp)) {
        m_Ctx.SetGlobalString("gUrlApp",w_gUrlApp);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,azzera_messaggi,
  public static final String i_InvokedRoutines = ",azzera_messaggi,";
}
