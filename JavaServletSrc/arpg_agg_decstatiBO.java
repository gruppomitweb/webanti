// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_agg_decstatiBO extends arpg_agg_decstatiBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_agg_decstatiBO (CPContext p_ContextObject) {
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
          if (CPLib.ge(l_nCnt,15)) {
            m_bExitRow = true;
          }
        } else {
          l_bEof = true;
        }
        if ( ! (l_bEof) &&  ! (m_bExitRow)) {
          // Riempie le variabili della query a partire dal record corrente
          c_id = rs.GetDouble("id");
          c_account = rs.GetString("account");
          c_CODSTA = rs.GetString("CODSTA");
          c_DESCRI = rs.GetString("DESCRI");
          c_SIGLA = rs.GetString("SIGLA");
          c_ISO = rs.GetString("ISO");
          c_ISO2 = rs.GetString("ISO2");
          c_IDTBLS = rs.GetString("IDTBLS");
          c_IDBASE = rs.GetString("IDBASE");
          // Esegue il link per gli item di tipo campo per riportare il valore letto dal record linkato
          Link_ORJCJRTXVX(c_id);
          Link_PQMVBJOFUR(c_id);
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
      if (CPLib.ne(w_CODSTA,t_CODSTA)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_decode_stati+" set CODSTA="+CPLib.ToSQL(w_CODSTA,"C",3,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where id="+CPLib.ToSQL(k_CODSTA_id,"N",10,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_decode_stati,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_decode_stati+" (CODSTA,id,CPCCCHK) values ("+CPLib.ToSQL(w_CODSTA,"C",3,0)+", "+CPLib.ToSQL(k_CODSTA_id,"N",10,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_decode_stati,l_cSql);
        }
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          l_bResult = false;
        }
        l_bTrsOk = m_Sql.EndTransaction();
      }
      if (CPLib.ne(w_IDTBLS,t_IDTBLS)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_decode_stati+" set IDTBLS="+CPLib.ToSQL(w_IDTBLS,"C",1,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where id="+CPLib.ToSQL(k_IDTBLS_id,"N",10,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_decode_stati,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_decode_stati+" (IDTBLS,id,CPCCCHK) values ("+CPLib.ToSQL(w_IDTBLS,"C",1,0)+", "+CPLib.ToSQL(k_IDTBLS_id,"N",10,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_decode_stati,l_cSql);
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
