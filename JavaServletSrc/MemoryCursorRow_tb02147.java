public class MemoryCursorRow_tb02147 extends CPMemoryCursorRow {
  public MemoryCursorRow_tb02147() {
  }
  public MemoryCursorRow_tb02147(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tb02147 toBuild = new MemoryCursor_tb02147(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tb02147 toBuild = new MemoryCursor_tb02147();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String COD = "";
  String DESCRI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tb02147 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tb02147.this.COD = copyAndCast(p_row.COD);
      MemoryCursorRow_tb02147.this.DESCRI = copyAndCast(p_row.DESCRI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"COD","DESCRI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione"};
    return l_names;
  }
}
