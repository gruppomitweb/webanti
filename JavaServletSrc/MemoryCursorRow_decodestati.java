public class MemoryCursorRow_decodestati extends CPMemoryCursorRow {
  public MemoryCursorRow_decodestati() {
  }
  public MemoryCursorRow_decodestati(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_decodestati toBuild = new MemoryCursor_decodestati(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_decodestati toBuild = new MemoryCursor_decodestati();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String account = "";
  String CODSTA = "";
  String DESCRI = "";
  String SIGLA = "";
  String ISO = "";
  String ISO2 = "";
  String IDTBLS = "";
  String IDBASE = "";
  double id = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(account))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODSTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISO))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDTBLS))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(id))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_decodestati p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_decodestati.this.account = copyAndCast(p_row.account);
      MemoryCursorRow_decodestati.this.CODSTA = copyAndCast(p_row.CODSTA);
      MemoryCursorRow_decodestati.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_decodestati.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_decodestati.this.ISO = copyAndCast(p_row.ISO);
      MemoryCursorRow_decodestati.this.ISO2 = copyAndCast(p_row.ISO2);
      MemoryCursorRow_decodestati.this.IDTBLS = copyAndCast(p_row.IDTBLS);
      MemoryCursorRow_decodestati.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_decodestati.this.id = copyAndCast(p_row.id);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"account","CODSTA","DESCRI","SIGLA","ISO","ISO2","IDTBLS","IDBASE","id"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Nome Nazione","Codice UIF","","","","","","","Autonumber"};
    return l_names;
  }
}
