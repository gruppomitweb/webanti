public class MemoryCursorRow_tberrdge extends CPMemoryCursorRow {
  public MemoryCursorRow_tberrdge() {
  }
  public MemoryCursorRow_tberrdge(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tberrdge toBuild = new MemoryCursor_tberrdge(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tberrdge toBuild = new MemoryCursor_tberrdge();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String DGECODICE = "";
  String DGEDESCRI = "";
  String DGEAZIONE = "";
  String DGECONSEG = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(DGECODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DGEDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DGEAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DGECONSEG))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tberrdge p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tberrdge.this.DGECODICE = copyAndCast(p_row.DGECODICE);
      MemoryCursorRow_tberrdge.this.DGEDESCRI = copyAndCast(p_row.DGEDESCRI);
      MemoryCursorRow_tberrdge.this.DGEAZIONE = copyAndCast(p_row.DGEAZIONE);
      MemoryCursorRow_tberrdge.this.DGECONSEG = copyAndCast(p_row.DGECONSEG);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"DGECODICE","DGEDESCRI","DGEAZIONE","DGECONSEG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione Errore","Azione","Conseguenza"};
    return l_names;
  }
}
