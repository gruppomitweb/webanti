public class MemoryCursorRow_mcautocorrect_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcautocorrect_mcrdef() {
  }
  public MemoryCursorRow_mcautocorrect_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcautocorrect_mcrdef toBuild = new MemoryCursor_mcautocorrect_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcautocorrect_mcrdef toBuild = new MemoryCursor_mcautocorrect_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double IDPROG = 0;
  String psrowstatus = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(psrowstatus))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcautocorrect_mcrdef p_row) {
    MemoryCursorRow_mcautocorrect_mcrdef l_row = new MemoryCursorRow_mcautocorrect_mcrdef();
    CopyOperation<MemoryCursorRow_mcautocorrect_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcautocorrect_mcrdef.this.IDPROG = l_row.IDPROG;
      MemoryCursorRow_mcautocorrect_mcrdef.this.psrowstatus = l_row.psrowstatus;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcautocorrect_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcautocorrect_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcautocorrect_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcautocorrect_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcautocorrect_mcrdef p_From,MemoryCursorRow_mcautocorrect_mcrdef p_To) {
        p_To.IDPROG = copyAndCast(p_From.IDPROG);
        p_To.psrowstatus = copyAndCast(p_From.psrowstatus);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDPROG","psrowstatus"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Identificativo","Stato riga"};
    return l_names;
  }
}
