public class MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef() {
  }
  public MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef toBuild = new MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef toBuild = new MemoryCursor_mcparametri_pg_moneygram_allineamenti_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  java.sql.Date data_allienamento = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(data_allienamento))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef p_row) {
    MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef l_row = new MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef();
    CopyOperation<MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef.this.data_allienamento = l_row.data_allienamento;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef p_From,MemoryCursorRow_mcparametri_pg_moneygram_allineamenti_mcrdef p_To) {
        p_To.data_allienamento = copyAndCast(p_From.data_allienamento);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"data_allienamento"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"data allineamento modifche anagrafiche"};
    return l_names;
  }
}
