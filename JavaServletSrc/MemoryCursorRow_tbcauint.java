public class MemoryCursorRow_tbcauint extends CPMemoryCursorRow {
  public MemoryCursorRow_tbcauint() {
  }
  public MemoryCursorRow_tbcauint(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbcauint toBuild = new MemoryCursor_tbcauint(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbcauint toBuild = new MemoryCursor_tbcauint();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double CICODICE = 0;
  String CICAUCOD = "";
  String CIFINALIT = "";
  double CIRISCHIO = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CICODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CICAUCOD))) {
      return false;
    }
    if ( ! (CPLib.Empty(CIFINALIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CIRISCHIO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbcauint p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbcauint.this.CICODICE = copyAndCast(p_row.CICODICE);
      MemoryCursorRow_tbcauint.this.CICAUCOD = copyAndCast(p_row.CICAUCOD);
      MemoryCursorRow_tbcauint.this.CIFINALIT = copyAndCast(p_row.CIFINALIT);
      MemoryCursorRow_tbcauint.this.CIRISCHIO = copyAndCast(p_row.CIRISCHIO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CICODICE","CICAUCOD","CIFINALIT","CIRISCHIO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Causale","Finalità/Scopo","Indice di Rischio"};
    return l_names;
  }
}
