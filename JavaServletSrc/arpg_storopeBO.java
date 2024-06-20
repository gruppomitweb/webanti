// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_storopeBO extends arpg_storopeBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_storopeBO (CPContext p_ContextObject) {
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
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gUrlApp",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gUrlApp"),w_gUrlApp)) {
        m_Ctx.SetGlobalString("gUrlApp",w_gUrlApp);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gAzienda",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gAzienda"),w_gAzienda)) {
        m_Ctx.SetGlobalString("gAzienda",w_gAzienda);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalDate("gDatDel",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalDate("gDatDel"),w_gDatDel)) {
        m_Ctx.SetGlobalDate("gDatDel",w_gDatDel);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalDate("gDatTra",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalDate("gDatTra"),w_gDatTra)) {
        m_Ctx.SetGlobalDate("gDatTra",w_gDatTra);
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
