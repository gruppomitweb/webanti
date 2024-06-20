public class MemoryCursorRow_tbluonas extends CPMemoryCursorRow {
  public MemoryCursorRow_tbluonas() {
  }
  public MemoryCursorRow_tbluonas(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbluonas toBuild = new MemoryCursor_tbluonas(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbluonas toBuild = new MemoryCursor_tbluonas();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SIGLA = "";
  String DESCRI = "";
  java.sql.Date DATINI = CPLib.NullDate();
  java.sql.Date DATFIN = CPLib.NullDate();
  String PROVINCIA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATFIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbluonas p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbluonas.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_tbluonas.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tbluonas.this.DATINI = copyAndCast(p_row.DATINI);
      MemoryCursorRow_tbluonas.this.DATFIN = copyAndCast(p_row.DATFIN);
      MemoryCursorRow_tbluonas.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SIGLA","DESCRI","DATINI","DATFIN","PROVINCIA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","D","D","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Sigla","Descrizione","Data Inizio Validità","Data Fine Validità","Provincia"};
    return l_names;
  }
}
