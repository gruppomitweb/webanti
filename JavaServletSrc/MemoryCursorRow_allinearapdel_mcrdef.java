public class MemoryCursorRow_allinearapdel_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_allinearapdel_mcrdef() {
  }
  public MemoryCursorRow_allinearapdel_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_allinearapdel_mcrdef toBuild = new MemoryCursor_allinearapdel_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_allinearapdel_mcrdef toBuild = new MemoryCursor_allinearapdel_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double NUMRIGA = 0;
  String ps_rowstatus = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMRIGA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ps_rowstatus))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_allinearapdel_mcrdef p_row) {
    MemoryCursorRow_allinearapdel_mcrdef l_row = new MemoryCursorRow_allinearapdel_mcrdef();
    CopyOperation<MemoryCursorRow_allinearapdel_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_allinearapdel_mcrdef.this.NUMRIGA = l_row.NUMRIGA;
      MemoryCursorRow_allinearapdel_mcrdef.this.ps_rowstatus = l_row.ps_rowstatus;
    }
  }
  protected CopyOperation<MemoryCursorRow_allinearapdel_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_allinearapdel_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_allinearapdel_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_allinearapdel_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_allinearapdel_mcrdef p_From,MemoryCursorRow_allinearapdel_mcrdef p_To) {
        p_To.NUMRIGA = copyAndCast(p_From.NUMRIGA);
        p_To.ps_rowstatus = copyAndCast(p_From.ps_rowstatus);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMRIGA","ps_rowstatus"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"N° Riga","Stato Riga"};
    return l_names;
  }
}
