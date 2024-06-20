public class MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef() {
  }
  public MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mc_app_stp_estr_trim2_mcrdef toBuild = new MemoryCursor_mc_app_stp_estr_trim2_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mc_app_stp_estr_trim2_mcrdef toBuild = new MemoryCursor_mc_app_stp_estr_trim2_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String ISTAT = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ISTAT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef p_row) {
    MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef l_row = new MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef();
    CopyOperation<MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef.this.ISTAT = l_row.ISTAT;
    }
  }
  protected CopyOperation<MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef p_From,MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef p_To) {
        p_To.ISTAT = copyAndCast(p_From.ISTAT);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ISTAT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ISTAT"};
    return l_names;
  }
}
