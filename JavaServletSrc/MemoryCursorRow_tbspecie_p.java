public class MemoryCursorRow_tbspecie_p extends CPMemoryCursorRow {
  public MemoryCursorRow_tbspecie_p() {
  }
  public MemoryCursorRow_tbspecie_p(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbspecie_p toBuild = new MemoryCursor_tbspecie_p(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbspecie_p toBuild = new MemoryCursor_tbspecie_p();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODSPE = "";
  double RISCHIO = 0;
  String FLGPERS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODSPE))) {
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
  void Copy(MemoryCursorRow_tbspecie_p p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbspecie_p.this.CODSPE = copyAndCast(p_row.CODSPE);
      MemoryCursorRow_tbspecie_p.this.RISCHIO = copyAndCast(p_row.RISCHIO);
      MemoryCursorRow_tbspecie_p.this.FLGPERS = copyAndCast(p_row.FLGPERS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODSPE","RISCHIO","FLGPERS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Indice di rischio","Valore Personalizzato"};
    return l_names;
  }
}
