public class MemoryCursorRow_storico_import extends CPMemoryCursorRow {
  public MemoryCursorRow_storico_import() {
  }
  public MemoryCursorRow_storico_import(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_storico_import toBuild = new MemoryCursor_storico_import(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_storico_import toBuild = new MemoryCursor_storico_import();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  String TABELLE = "";
  java.sql.Timestamp ELIM_IMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TABELLE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ELIM_IMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_storico_import p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_storico_import.this.NUMIMP = copyAndCast(p_row.NUMIMP);
      MemoryCursorRow_storico_import.this.TABELLE = copyAndCast(p_row.TABELLE);
      MemoryCursorRow_storico_import.this.ELIM_IMP = copyAndCast(p_row.ELIM_IMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMIMP","TABELLE","ELIM_IMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"T","M","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"TimeStamp di Importazione","Elenco Tabelle Importate","Timestamp annullamento Import"};
    return l_names;
  }
}
