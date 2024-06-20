public class MemoryCursorRow_tbvalute extends CPMemoryCursorRow {
  public MemoryCursorRow_tbvalute() {
  }
  public MemoryCursorRow_tbvalute(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbvalute toBuild = new MemoryCursor_tbvalute(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbvalute toBuild = new MemoryCursor_tbvalute();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODVAL = "";
  String DESCRI = "";
  String ISO = "";
  double CAMBIO = 0;
  double CAMBDAT = 0;
  double CAMBLIRA = 0;
  String IDTBLS = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODVAL))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBDAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAMBLIRA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDTBLS))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbvalute p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbvalute.this.CODVAL = copyAndCast(p_row.CODVAL);
      MemoryCursorRow_tbvalute.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tbvalute.this.ISO = copyAndCast(p_row.ISO);
      MemoryCursorRow_tbvalute.this.CAMBIO = copyAndCast(p_row.CAMBIO);
      MemoryCursorRow_tbvalute.this.CAMBDAT = copyAndCast(p_row.CAMBDAT);
      MemoryCursorRow_tbvalute.this.CAMBLIRA = copyAndCast(p_row.CAMBLIRA);
      MemoryCursorRow_tbvalute.this.IDTBLS = copyAndCast(p_row.IDTBLS);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODVAL","DESCRI","ISO","CAMBIO","CAMBDAT","CAMBLIRA","IDTBLS"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","","","","",""};
    return l_names;
  }
}
