// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arpg_allinea_nome_cognomeBO extends arpg_allinea_nome_cognomeBL {
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    return l_bResult;
  }
  public arpg_allinea_nome_cognomeBO (CPContext p_ContextObject) {
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
          c_IDBASE = rs.GetString("IDBASE");
          c_CONNES = rs.GetString("CONNES");
          c_RAGSOC = rs.GetString("RAGSOC");
          c_CODFISC = rs.GetString("CODFISC");
          c_NOME = rs.GetString("NOME");
          c_COGNOME = rs.GetString("COGNOME");
          c_ALLINEAMENTO = rs.GetString("ALLINEAMENTO");
          // Esegue il link per gli item di tipo campo per riportare il valore letto dal record linkato
          Link_ULURFNZXUM(c_IDBASE);
          Link_QUYFYKVQUY(c_IDBASE);
          Link_MGZZLJDIWH(c_IDBASE);
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
      if (CPLib.ne(w_NOME,t_NOME)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_allin_anag+" set NOME="+CPLib.ToSQL(w_NOME,"C",25,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where IDBASE="+CPLib.ToSQL(k_NOME_IDBASE,"C",10,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_allin_anag+" (NOME,IDBASE,CPCCCHK) values ("+CPLib.ToSQL(w_NOME,"C",25,0)+", "+CPLib.ToSQL(k_NOME_IDBASE,"C",10,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
        }
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          l_bResult = false;
        }
        l_bTrsOk = m_Sql.EndTransaction();
      }
      if (CPLib.ne(w_COGNOME,t_COGNOME)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_allin_anag+" set COGNOME="+CPLib.ToSQL(w_COGNOME,"C",26,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where IDBASE="+CPLib.ToSQL(k_COGNOME_IDBASE,"C",10,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_allin_anag+" (COGNOME,IDBASE,CPCCCHK) values ("+CPLib.ToSQL(w_COGNOME,"C",26,0)+", "+CPLib.ToSQL(k_COGNOME_IDBASE,"C",10,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
        }
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          l_bResult = false;
        }
        l_bTrsOk = m_Sql.EndTransaction();
      }
      if (CPLib.ne(w_RAGSOC,t_RAGSOC)) {
        m_Sql.BeginTransaction();
        l_cSql = "Update "+m_cPhName_tmp_allin_anag+" set RAGSOC="+CPLib.ToSQL(w_RAGSOC,"C",70,0);
        l_cSql = l_cSql+", CPCCCHK="+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0);
        l_cSql = l_cSql+" where IDBASE="+CPLib.ToSQL(k_RAGSOC_IDBASE,"C",10,0);
        l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
        if (CPLib.eq(l_nUpdatedRows,0)) {
          // Aggiornamento fallito: si tenta un inserimento
          l_cSql = "Insert into "+m_cPhName_tmp_allin_anag+" (RAGSOC,IDBASE,CPCCCHK) values ("+CPLib.ToSQL(w_RAGSOC,"C",70,0)+", "+CPLib.ToSQL(k_RAGSOC_IDBASE,"C",10,0)+", "+CPLib.ToSQL(CPLib.NewCPCCCHK(),"C",10,0)+")";
          l_nUpdatedRows = m_Sql.Update(m_cServer_tmp_allin_anag,l_cSql);
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
  // ENTITY_BATCHES: ,arfn_verifica_cf_nome_cognome_numeric,
  public static final String i_InvokedRoutines = ",arfn_verifica_cf_nome_cognome_numeric,";
}
