public class MemoryCursorRow_tbcausin extends CPMemoryCursorRow {
  public MemoryCursorRow_tbcausin() {
  }
  public MemoryCursorRow_tbcausin(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbcausin toBuild = new MemoryCursor_tbcausin(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbcausin toBuild = new MemoryCursor_tbcausin();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODVOC = "";
  String DESCRIZ = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODVOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRIZ))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbcausin p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbcausin.this.CODVOC = copyAndCast(p_row.CODVOC);
      MemoryCursorRow_tbcausin.this.DESCRIZ = copyAndCast(p_row.DESCRIZ);
      MemoryCursorRow_tbcausin.this.DATAVALI = copyAndCast(p_row.DATAVALI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODVOC","DESCRIZ","DATAVALI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Data Fine Validità"};
    return l_names;
  }
}
