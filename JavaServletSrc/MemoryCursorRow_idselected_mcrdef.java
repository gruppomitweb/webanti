public class MemoryCursorRow_idselected_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_idselected_mcrdef() {
  }
  public MemoryCursorRow_idselected_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_idselected_mcrdef toBuild = new MemoryCursor_idselected_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_idselected_mcrdef toBuild = new MemoryCursor_idselected_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDBASE = "";
  String ps_rowstatus = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ps_rowstatus))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_idselected_mcrdef p_row) {
    MemoryCursorRow_idselected_mcrdef l_row = new MemoryCursorRow_idselected_mcrdef();
    CopyOperation<MemoryCursorRow_idselected_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_idselected_mcrdef.this.IDBASE = l_row.IDBASE;
      MemoryCursorRow_idselected_mcrdef.this.ps_rowstatus = l_row.ps_rowstatus;
    }
  }
  protected CopyOperation<MemoryCursorRow_idselected_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_idselected_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_idselected_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_idselected_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_idselected_mcrdef p_From,MemoryCursorRow_idselected_mcrdef p_To) {
        p_To.IDBASE = copyAndCast(p_From.IDBASE);
        p_To.ps_rowstatus = copyAndCast(p_From.ps_rowstatus);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDBASE","ps_rowstatus"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"",""};
    return l_names;
  }
}
