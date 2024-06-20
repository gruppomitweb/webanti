public class MemoryCursorRow_mcstringa_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcstringa_mcrdef() {
  }
  public MemoryCursorRow_mcstringa_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcstringa_mcrdef toBuild = new MemoryCursor_mcstringa_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcstringa_mcrdef toBuild = new MemoryCursor_mcstringa_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICE = "";
  String ps_rowstatus = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ps_rowstatus))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcstringa_mcrdef p_row) {
    MemoryCursorRow_mcstringa_mcrdef l_row = new MemoryCursorRow_mcstringa_mcrdef();
    CopyOperation<MemoryCursorRow_mcstringa_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcstringa_mcrdef.this.CODICE = l_row.CODICE;
      MemoryCursorRow_mcstringa_mcrdef.this.ps_rowstatus = l_row.ps_rowstatus;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcstringa_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcstringa_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcstringa_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcstringa_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcstringa_mcrdef p_From,MemoryCursorRow_mcstringa_mcrdef p_To) {
        p_To.CODICE = copyAndCast(p_From.CODICE);
        p_To.ps_rowstatus = copyAndCast(p_From.ps_rowstatus);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICE","ps_rowstatus"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice",""};
    return l_names;
  }
}
