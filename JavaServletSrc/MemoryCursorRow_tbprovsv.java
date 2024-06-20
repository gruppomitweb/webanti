public class MemoryCursorRow_tbprovsv extends CPMemoryCursorRow {
  public MemoryCursorRow_tbprovsv() {
  }
  public MemoryCursorRow_tbprovsv(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbprovsv toBuild = new MemoryCursor_tbprovsv(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbprovsv toBuild = new MemoryCursor_tbprovsv();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SIGLA = "";
  String PROVINCIA = "";
  String SIGLASV = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SIGLASV))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbprovsv p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbprovsv.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_tbprovsv.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_tbprovsv.this.SIGLASV = copyAndCast(p_row.SIGLASV);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SIGLA","PROVINCIA","SIGLASV"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Sigla","Provincia","SIGLA SV"};
    return l_names;
  }
}
