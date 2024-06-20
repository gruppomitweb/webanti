public class MemoryCursorRow_tb00016 extends CPMemoryCursorRow {
  public MemoryCursorRow_tb00016() {
  }
  public MemoryCursorRow_tb00016(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tb00016 toBuild = new MemoryCursor_tb00016(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tb00016 toBuild = new MemoryCursor_tb00016();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String COD = "";
  String DESCRI = "";
  String VALIDOPER = "";
  String CODICESV = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALIDOPER))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODICESV))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tb00016 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tb00016.this.COD = copyAndCast(p_row.COD);
      MemoryCursorRow_tb00016.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tb00016.this.VALIDOPER = copyAndCast(p_row.VALIDOPER);
      MemoryCursorRow_tb00016.this.CODICESV = copyAndCast(p_row.CODICESV);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"COD","DESCRI","VALIDOPER","CODICESV"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Estrazioni Valide","Codice NSV"};
    return l_names;
  }
}
