public class MemoryCursorRow_tbstgru extends CPMemoryCursorRow {
  public MemoryCursorRow_tbstgru() {
  }
  public MemoryCursorRow_tbstgru(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbstgru toBuild = new MemoryCursor_tbstgru(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbstgru toBuild = new MemoryCursor_tbstgru();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SOTGRU = "";
  String DESCRI = "";
  String TIPOSOT = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SOTGRU))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOSOT))) {
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
  void Copy(MemoryCursorRow_tbstgru p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbstgru.this.SOTGRU = copyAndCast(p_row.SOTGRU);
      MemoryCursorRow_tbstgru.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tbstgru.this.TIPOSOT = copyAndCast(p_row.TIPOSOT);
      MemoryCursorRow_tbstgru.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_tbstgru.this.DATAFINE = copyAndCast(p_row.DATAFINE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SOTGRU","DESCRI","TIPOSOT","DATAINI","DATAFINE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Tipo","Data inizio Validità","Data Fine Validità"};
    return l_names;
  }
}
