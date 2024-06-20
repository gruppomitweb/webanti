public class MemoryCursorRow_qbe_tb00016_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_tb00016_vqr() {
  }
  public MemoryCursorRow_qbe_tb00016_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_tb00016_vqr toBuild = new MemoryCursor_qbe_tb00016_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_tb00016_vqr toBuild = new MemoryCursor_qbe_tb00016_vqr();
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
  void Copy(MemoryCursorRow_qbe_tb00016_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_tb00016_vqr.this.COD = copyAndCast(p_row.COD);
      MemoryCursorRow_qbe_tb00016_vqr.this.DESCRI = copyAndCast(p_row.DESCRI);
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
