// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_impdel_ipBO extends arpg_impdel_ipBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_impdel_ipBO (CPContext p_ContextObject) {
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
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gAzienda",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gAzienda"),w_gAzienda)) {
        m_Ctx.SetGlobalString("gAzienda",w_gAzienda);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gPathApp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gPathApp"),w_gPathApp)) {
        m_Ctx.SetGlobalString("gPathApp",w_gPathApp);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gMsgImp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gMsgImp"),w_gMsgImp)) {
        m_Ctx.SetGlobalString("gMsgImp",w_gMsgImp);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gMsgProc",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gMsgProc"),w_gMsgProc)) {
        m_Ctx.SetGlobalString("gMsgProc",w_gMsgProc);
      }
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
