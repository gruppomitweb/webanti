public class MemoryCursorRow_qbe_stgru_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_stgru_vqr() {
  }
  public MemoryCursorRow_qbe_stgru_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_stgru_vqr toBuild = new MemoryCursor_qbe_stgru_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_stgru_vqr toBuild = new MemoryCursor_qbe_stgru_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SOTGRU = "";
  String DESCRI = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SOTGRU))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFINE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_stgru_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_stgru_vqr.this.SOTGRU = copyAndCast(p_row.SOTGRU);
      MemoryCursorRow_qbe_stgru_vqr.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_qbe_stgru_vqr.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_qbe_stgru_vqr.this.DATAFINE = copyAndCast(p_row.DATAFINE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SOTGRU","DESCRI","DATAINI","DATAFINE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Data inizio Validità","Data Fine Validità"};
    return l_names;
  }
}
