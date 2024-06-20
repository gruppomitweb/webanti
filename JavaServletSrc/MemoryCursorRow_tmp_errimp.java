public class MemoryCursorRow_tmp_errimp extends CPMemoryCursorRow {
  public MemoryCursorRow_tmp_errimp() {
  }
  public MemoryCursorRow_tmp_errimp(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tmp_errimp toBuild = new MemoryCursor_tmp_errimp(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tmp_errimp toBuild = new MemoryCursor_tmp_errimp();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String nomearch = "";
  double numriga = 0;
  String errore = "";
  String txtini = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(nomearch))) {
      return false;
    }
    if ( ! (CPLib.Empty(numriga))) {
      return false;
    }
    if ( ! (CPLib.Empty(errore))) {
      return false;
    }
    if ( ! (CPLib.Empty(txtini))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tmp_errimp p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tmp_errimp.this.nomearch = copyAndCast(p_row.nomearch);
      MemoryCursorRow_tmp_errimp.this.numriga = copyAndCast(p_row.numriga);
      MemoryCursorRow_tmp_errimp.this.errore = copyAndCast(p_row.errore);
      MemoryCursorRow_tmp_errimp.this.txtini = copyAndCast(p_row.txtini);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"nomearch","numriga","errore","txtini"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","M","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Nome Archivio","N° Riga","Errore","Descrizione iniziale"};
    return l_names;
  }
}
