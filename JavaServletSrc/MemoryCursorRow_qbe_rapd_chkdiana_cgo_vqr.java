public class MemoryCursorRow_qbe_rapd_chkdiana_cgo_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rapd_chkdiana_cgo_vqr() {
  }
  public MemoryCursorRow_qbe_rapd_chkdiana_cgo_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rapd_chkdiana_cgo_vqr toBuild = new MemoryCursor_qbe_rapd_chkdiana_cgo_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rapd_chkdiana_cgo_vqr toBuild = new MemoryCursor_qbe_rapd_chkdiana_cgo_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINTER = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINTER))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rapd_chkdiana_cgo_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rapd_chkdiana_cgo_vqr.this.CODINTER = copyAndCast(p_row.CODINTER);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINTER"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Intestatario (Non Intermediario)"};
    return l_names;
  }
}
