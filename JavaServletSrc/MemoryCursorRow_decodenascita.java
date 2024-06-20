public class MemoryCursorRow_decodenascita extends CPMemoryCursorRow {
  public MemoryCursorRow_decodenascita() {
  }
  public MemoryCursorRow_decodenascita(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_decodenascita toBuild = new MemoryCursor_decodenascita(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_decodenascita toBuild = new MemoryCursor_decodenascita();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double id = 0;
  String account = "";
  String SIGLA = "";
  String DESCRI = "";
  java.sql.Date DATINI = CPLib.NullDate();
  java.sql.Date DATFIN = CPLib.NullDate();
  String PROVINCIA = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(id))) {
      return false;
    }
    if ( ! (CPLib.Empty(account))) {
      return false;
    }
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
  void Copy(MemoryCursorRow_decodenascita p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_decodenascita.this.id = copyAndCast(p_row.id);
      MemoryCursorRow_decodenascita.this.account = copyAndCast(p_row.account);
      MemoryCursorRow_decodenascita.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_decodenascita.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_decodenascita.this.DATINI = copyAndCast(p_row.DATINI);
      MemoryCursorRow_decodenascita.this.DATFIN = copyAndCast(p_row.DATFIN);
      MemoryCursorRow_decodenascita.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"id","account","SIGLA","DESCRI","DATINI","DATFIN","PROVINCIA"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C","D","D","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Autonumber","Nome Nazione","Sigla","Descrizione","Data Inizio Validità","Data Fine Validità","Provincia"};
    return l_names;
  }
}
