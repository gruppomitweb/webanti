// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_trasffra_age_oldBO extends arpg_trasffra_age_oldBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_trasffra_age_oldBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean Save() {
    boolean l_bResult = true;
    if (IsUpdated()) {
      l_bResult = new CallerBRImpl(this,"w_").BRCanSave();
    }
    if (l_bResult && IsUpdated()) {
      int l_nRow;
      l_nRow = 0;
      while (CPLib.lt(l_nRow,Rows())) {
        SetRow(l_nRow);
        l_bResult = SaveDetailRow() && l_bResult;
        l_nRow = l_nRow+1;
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
          c_NUMPROG = rs.GetString("NUMPROG");
          c_DATAOPE = rs.GetDate("DATAOPE");
          c_RAPPORTO = rs.GetString("RAPPORTO");
          c_CONNESCLI = rs.GetString("CONNESCLI");
          c_TOTLIRE = rs.GetDouble("TOTLIRE");
          c_TOTCONT = rs.GetDouble("TOTCONT");
          c_VALUTA = rs.GetString("VALUTA");
          c_IDBASE = rs.GetString("IDBASE");
          c_CODDIP = rs.GetString("CODDIP");
          // Esegue il link per gli item di tipo campo per riportare il valore letto dal record linkato
          Link_BBVZXDYMJX(c_NUMPROG);
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
  public boolean SaveDetailRow() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bTrsOk;
    String l_cSql;
    double l_nUpdatedRows;
    l_bTrsOk = true;
    if (CPLib.eq(m_nRowStatus,1)) {
      if (CPLib.ne(w_FLGSEL,t_FLGSEL)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_trasfope+" set FLGSEL="+CPLib.ToSQL(w_FLGSEL,"C",1,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where NUMPROG="+CPLib.ToSQL(k_FLGSEL_NUMPROG,"C",11,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_trasfope,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_trasfope+" (FLGSEL,NUMPROG,CPCCCHK) values ("+CPLib.ToSQL(w_FLGSEL,"C",1,0)+", "+CPLib.ToSQL(k_FLGSEL_NUMPROG,"C",11,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_trasfope,l_cSql);
        }
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          l_bResult = false;
        }
        l_bTrsOk = m_Sql.EndTransaction();
      }
    }
    return l_bResult;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
}
