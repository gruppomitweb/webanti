// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_storrapBO extends arpg_storrapBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_storrapBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalDate("gDatDel",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalDate("gDatDel"),w_gDatDel)) {
        m_Ctx.SetGlobalDate("gDatDel",w_gDatDel);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalDate("gDatTra",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalDate("gDatTra"),w_gDatTra)) {
        m_Ctx.SetGlobalDate("gDatTra",w_gDatTra);
      }
    }
    return l_bResult;
  }
  public void Query(com.zucchetti.sitepainter.VQRBufferedReaderFactory factory) {
    int l_nCnt;
    boolean l_bEof;
    l_nCnt = 0;
    l_bEof = false;
    m_oTrs.clear();
    CPResultSet rs=null;
    rs = null;
    if (m_bQuery) {
      if (rs!=null)
        rs.Close();
      rs = new VQRHolder(m_cQueryName,factory,this,false).GetResultSet(m_Ctx);
    }
    if (m_bQuery) {
      while ( ! (l_bEof) &&  ! (m_bExitRow)) {
        if ( ! (rs.Eof())) {
        } else {
          l_bEof = true;
        }
        if ( ! (l_bEof) &&  ! (m_bExitRow)) {
          // Riempie le variabili della query a partire dal record corrente
          c_RAPPORTO = rs.GetString("RAPPORTO");
          c_DESCRAP = rs.GetString("DESCRAP");
          c_TIPORAP = rs.GetString("TIPORAP");
          c_FLAGLIRE = rs.GetString("FLAGLIRE");
          c_VALUTA = rs.GetString("VALUTA");
          AddTrsRow();
          rs.Next();
          l_nCnt = l_nCnt+1;
        }
      }
    }
    if (m_bQuery) {
      rs.Close();
    }
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,arfn_chkdatper,
  public static final String i_InvokedRoutines = ",arfn_chkdatper,";
}
