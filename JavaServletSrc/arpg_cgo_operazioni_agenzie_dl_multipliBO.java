// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_cgo_operazioni_agenzie_dl_multipliBO extends arpg_cgo_operazioni_agenzie_dl_multipliBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_cgo_operazioni_agenzie_dl_multipliBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gCodDip",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gCodDip"),w_gCodDip)) {
        m_Ctx.SetGlobalString("gCodDip",w_gCodDip);
      }
      if (CPLib.GetGlobalDefaults().CanSetGlobalString("gStpDwn",m_Ctx) || CPLib.ne(m_Ctx.GetGlobalString("gStpDwn"),w_gStpDwn)) {
        m_Ctx.SetGlobalString("gStpDwn",w_gStpDwn);
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
      while ( ! (rs.Eof()) && CPLib.lt(l_nCnt,m_nStartRow-1)) {
        rs.Next();
        l_nCnt = l_nCnt+1;
      }
      l_nCnt = 0;
    }
    if (m_bQuery) {
      while ( ! (l_bEof) &&  ! (m_bExitRow)) {
        if ( ! (rs.Eof())) {
          if (CPLib.ge(l_nCnt,20)) {
            m_bExitRow = true;
          }
        } else {
          l_bEof = true;
        }
        if ( ! (l_bEof) &&  ! (m_bExitRow)) {
          // Riempie le variabili della query a partire dal record corrente
          c_DATAOPE = rs.GetDate("DATAOPE");
          c_CACODICE = rs.GetDouble("CACODICE");
          c_CADESCRI = rs.GetString("CADESCRI");
          c_SNAINUMOPE = rs.GetString("SNAINUMOPE");
          c_TOTLIRE = rs.GetDouble("TOTLIRE");
          c_SEGNO = rs.GetString("SEGNO");
          c_CAIDBIGLIETTO = rs.GetString("CAIDBIGLIETTO");
          c_COGNOME = rs.GetString("COGNOME");
          c_NOME = rs.GetString("NOME");
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
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
