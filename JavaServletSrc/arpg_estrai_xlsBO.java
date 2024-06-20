// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_estrai_xlsBO extends arpg_estrai_xlsBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_estrai_xlsBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gUrlApp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gUrlApp"),w_gUrlApp)) {
        m_Ctx.SetGlobalString("gUrlApp",w_gUrlApp);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gFileName",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gFileName"),w_gFileName)) {
        m_Ctx.SetGlobalString("gFileName",w_gFileName);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gFlgWU",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gFlgWU"),w_gFlgWU)) {
        m_Ctx.SetGlobalString("gFlgWU",w_gFlgWU);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gAzienda",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gAzienda"),w_gAzienda)) {
        m_Ctx.SetGlobalString("gAzienda",w_gAzienda);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,azzera_messaggi,
  public static final String i_InvokedRoutines = ",azzera_messaggi,";
}
