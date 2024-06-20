// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_import_errori_valutransBO extends arpg_import_errori_valutransBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_import_errori_valutransBO (CPContext p_ContextObject) {
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
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,azzera_messaggi,
  public static final String i_InvokedRoutines = ",azzera_messaggi,";
}
