public class MemoryCursorRow_tb01217 extends CPMemoryCursorRow {
  public MemoryCursorRow_tb01217() {
  }
  public MemoryCursorRow_tb01217(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tb01217 toBuild = new MemoryCursor_tb01217(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tb01217 toBuild = new MemoryCursor_tb01217();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String COD = "";
  String DESCRI = "";
  String VOCE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(VOCE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tb01217 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tb01217.this.COD = copyAndCast(p_row.COD);
      MemoryCursorRow_tb01217.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tb01217.this.VOCE = copyAndCast(p_row.VOCE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"COD","DESCRI","VOCE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Valido per (Voce)"};
    return l_names;
  }
}
