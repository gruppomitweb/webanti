public class MemoryCursorRow_tbsetsina extends CPMemoryCursorRow {
  public MemoryCursorRow_tbsetsina() {
  }
  public MemoryCursorRow_tbsetsina(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbsetsina toBuild = new MemoryCursor_tbsetsina(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbsetsina toBuild = new MemoryCursor_tbsetsina();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double IDSETSIN = 0;
  String SETSINT = "";
  String CODATECO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDSETSIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(SETSINT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODATECO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbsetsina p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbsetsina.this.IDSETSIN = copyAndCast(p_row.IDSETSIN);
      MemoryCursorRow_tbsetsina.this.SETSINT = copyAndCast(p_row.SETSINT);
      MemoryCursorRow_tbsetsina.this.CODATECO = copyAndCast(p_row.CODATECO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDSETSIN","SETSINT","CODATECO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"ID Settore Sintetico","Settore Sintetico","Codice ATECO (Primi Tre)"};
    return l_names;
  }
}
