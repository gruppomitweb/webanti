// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_cgo_operazioni_agenzie_adminBO extends arpg_cgo_operazioni_agenzie_adminBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_cgo_operazioni_agenzie_adminBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
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
          c_CODDIPE = rs.GetString("CODDIPE");
          c_IDDIP = rs.GetString("IDDIP");
          c_TIPOGIOCO = rs.GetString("TIPOGIOCO");
          c_GIORNI = rs.GetDouble("GIORNI");
          c_CGODATCON = rs.GetDate("CGODATCON");
          c_CGOESICON = rs.GetString("CGOESICON");
          c_CGONOTCON = rs.GetString("CGONOTCON");
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
  // ENTITY_BATCHES: ,arfn_esiticon,
  public static final String i_InvokedRoutines = ",arfn_esiticon,";
}
