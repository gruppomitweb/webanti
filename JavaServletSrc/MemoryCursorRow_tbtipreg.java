public class MemoryCursorRow_tbtipreg extends CPMemoryCursorRow {
  public MemoryCursorRow_tbtipreg() {
  }
  public MemoryCursorRow_tbtipreg(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbtipreg toBuild = new MemoryCursor_tbtipreg(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbtipreg toBuild = new MemoryCursor_tbtipreg();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICE = "";
  String DES1 = "";
  String DES2 = "";
  String TIPREG = "";
  String OPERAZIO = "";
  java.sql.Date DATAINI = CPLib.NullDate();
  java.sql.Date DATAFINE = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(DES1))) {
      return false;
    }
    if ( ! (CPLib.Empty(DES2))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPREG))) {
      return false;
    }
    if ( ! (CPLib.Empty(OPERAZIO))) {
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
  void Copy(MemoryCursorRow_tbtipreg p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbtipreg.this.CODICE = copyAndCast(p_row.CODICE);
      MemoryCursorRow_tbtipreg.this.DES1 = copyAndCast(p_row.DES1);
      MemoryCursorRow_tbtipreg.this.DES2 = copyAndCast(p_row.DES2);
      MemoryCursorRow_tbtipreg.this.TIPREG = copyAndCast(p_row.TIPREG);
      MemoryCursorRow_tbtipreg.this.OPERAZIO = copyAndCast(p_row.OPERAZIO);
      MemoryCursorRow_tbtipreg.this.DATAINI = copyAndCast(p_row.DATAINI);
      MemoryCursorRow_tbtipreg.this.DATAFINE = copyAndCast(p_row.DATAFINE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICE","DES1","DES2","TIPREG","OPERAZIO","DATAINI","DATAFINE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Descrizione 2","Tipo Registrazione","Operazione/Rapporto","Data Inizio Validità","Data Fine Validità"};
    return l_names;
  }
}
