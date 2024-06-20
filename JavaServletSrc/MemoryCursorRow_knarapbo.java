public class MemoryCursorRow_knarapbo extends CPMemoryCursorRow {
  public MemoryCursorRow_knarapbo() {
  }
  public MemoryCursorRow_knarapbo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_knarapbo toBuild = new MemoryCursor_knarapbo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_knarapbo toBuild = new MemoryCursor_knarapbo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  String TIPORAP = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFIN = CPLib.NullDate();
  String FLAGRAP = "";
  String CODDIPE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPORAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAFIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGRAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_knarapbo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_knarapbo.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_knarapbo.this.DESCRAP = copyAndCast(p_row.DESCRAP);
      MemoryCursorRow_knarapbo.this.TIPORAP = copyAndCast(p_row.TIPORAP);
      MemoryCursorRow_knarapbo.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_knarapbo.this.DATAFIN = copyAndCast(p_row.DATAFIN);
      MemoryCursorRow_knarapbo.this.FLAGRAP = copyAndCast(p_row.FLAGRAP);
      MemoryCursorRow_knarapbo.this.CODDIPE = copyAndCast(p_row.CODDIPE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP","TIPORAP","DATAINI","DATAFIN","FLAGRAP","CODDIPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Descrizione","Provvisorio / Definitivo","Data Inizio Rapporto","Data Fine Raspporto","","Codice Dipendenza"};
    return l_names;
  }
}
