public class MemoryCursorRow_tbcondotta_p extends CPMemoryCursorRow {
  public MemoryCursorRow_tbcondotta_p() {
  }
  public MemoryCursorRow_tbcondotta_p(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbcondotta_p toBuild = new MemoryCursor_tbcondotta_p(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbcondotta_p toBuild = new MemoryCursor_tbcondotta_p();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICE = "";
  double RISCHIO = 0;
  String FLGPERS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISCHIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGPERS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbcondotta_p p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbcondotta_p.this.CODICE = copyAndCast(p_row.CODICE);
      MemoryCursorRow_tbcondotta_p.this.RISCHIO = copyAndCast(p_row.RISCHIO);
      MemoryCursorRow_tbcondotta_p.this.FLGPERS = copyAndCast(p_row.FLGPERS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICE","RISCHIO","FLGPERS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Indice Rischio","Valore Personalizzato"};
    return l_names;
  }
}
