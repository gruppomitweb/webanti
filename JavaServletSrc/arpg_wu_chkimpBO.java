// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_wu_chkimpBO extends arpg_wu_chkimpBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_wu_chkimpBO (CPContext p_ContextObject) {
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
          c_WUCODICE = rs.GetDouble("WUCODICE");
          c_WUNOMEFILE = rs.GetString("WUNOMEFILE");
          c_WURIFMTCN = rs.GetString("WURIFMTCN");
          c_WUTIPOPE = rs.GetString("WUTIPOPE");
          c_WUDATOPE = rs.GetString("WUDATOPE");
          c_WUNOMCLI = rs.GetString("WUNOMCLI");
          c_WUCOGCLI = rs.GetString("WUCOGCLI");
          c_WUCODMAGE = rs.GetString("WUCODMAGE");
          c_WUNOTE = rs.GetString("WUNOTE");
          c_WUCODDIP = rs.GetString("WUCODDIP");
          c_WUIMPORTO = rs.GetDouble("WUIMPORTO");
          c_WUSTADES = rs.GetString("WUSTADES");
          c_WUCITCLI = rs.GetString("WUCITCLI");
          c_WUCAPCLI = rs.GetString("WUCAPCLI");
          c_WUINDCLI = rs.GetString("WUINDCLI");
          c_WUNOMCON = rs.GetString("WUNOMCON");
          c_WUCOGCON = rs.GetString("WUCOGCON");
          c_WUBCITCLI = rs.GetString("WUBCITCLI");
          c_WUBSTACLI = rs.GetString("WUBSTACLI");
          c_WUDATNAS = rs.GetString("WUDATNAS");
          c_WUSEXCLI = rs.GetString("WUSEXCLI");
          c_WUCODFIS = rs.GetString("WUCODFIS");
          c_WUTDOCCLI = rs.GetString("WUTDOCCLI");
          c_WUNDOCCLI = rs.GetString("WUNDOCCLI");
          c_WUADOCRIL = rs.GetString("WUADOCRIL");
          c_WURDOCCLI = rs.GetString("WURDOCCLI");
          c_WUSDOCCLI = rs.GetString("WUSDOCCLI");
          c_WUPROVCLI = rs.GetString("WUPROVCLI");
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
