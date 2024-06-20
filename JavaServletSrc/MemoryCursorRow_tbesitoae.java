public class MemoryCursorRow_tbesitoae extends CPMemoryCursorRow {
  public MemoryCursorRow_tbesitoae() {
  }
  public MemoryCursorRow_tbesitoae(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbesitoae toBuild = new MemoryCursor_tbesitoae(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbesitoae toBuild = new MemoryCursor_tbesitoae();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String CODICE = "";
  String DESCRI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbesitoae p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbesitoae.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_tbesitoae.this.CODICE = copyAndCast(p_row.CODICE);
      MemoryCursorRow_tbesitoae.this.DESCRI = copyAndCast(p_row.DESCRI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","CODICE","DESCRI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","M"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo","Codice","Descrizione"};
    return l_names;
  }
}
