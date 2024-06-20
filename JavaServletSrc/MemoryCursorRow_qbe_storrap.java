public class MemoryCursorRow_qbe_storrap extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_storrap() {
  }
  public MemoryCursorRow_qbe_storrap(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_storrap toBuild = new MemoryCursor_qbe_storrap(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_storrap toBuild = new MemoryCursor_qbe_storrap();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  public boolean IsEmpty() {
    return true;
  }
  void Copy(MemoryCursorRow_qbe_storrap p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{};
    return l_names;
  }
}
