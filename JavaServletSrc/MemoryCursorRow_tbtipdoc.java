public class MemoryCursorRow_tbtipdoc extends CPMemoryCursorRow {
  public MemoryCursorRow_tbtipdoc() {
  }
  public MemoryCursorRow_tbtipdoc(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbtipdoc toBuild = new MemoryCursor_tbtipdoc(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbtipdoc toBuild = new MemoryCursor_tbtipdoc();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPDOC = "";
  String DESCRI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPDOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbtipdoc p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbtipdoc.this.TIPDOC = copyAndCast(p_row.TIPDOC);
      MemoryCursorRow_tbtipdoc.this.DESCRI = copyAndCast(p_row.DESCRI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPDOC","DESCRI"};
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
