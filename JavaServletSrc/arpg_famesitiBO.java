// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_famesitiBO extends arpg_famesitiBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_famesitiBO (CPContext p_ContextObject) {
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
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gDescAzi",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gDescAzi"),w_gDescAzi)) {
        m_Ctx.SetGlobalString("gDescAzi",w_gDescAzi);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gFlgIPMT",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gFlgIPMT"),w_gFlgIPMT)) {
        m_Ctx.SetGlobalString("gFlgIPMT",w_gFlgIPMT);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,azzera_messaggi,
  public static final String i_InvokedRoutines = ",azzera_messaggi,";
}
