public class MemoryCursorRow_qbe_rtra_aua_3_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_rtra_aua_3_vqr() {
  }
  public MemoryCursorRow_qbe_rtra_aua_3_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_rtra_aua_3_vqr toBuild = new MemoryCursor_qbe_rtra_aua_3_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_rtra_aua_3_vqr toBuild = new MemoryCursor_qbe_rtra_aua_3_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODFISC = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_rtra_aua_3_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_rtra_aua_3_vqr.this.CODFISC = copyAndCast(p_row.CODFISC);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODFISC"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Fiscale"};
    return l_names;
  }
}
