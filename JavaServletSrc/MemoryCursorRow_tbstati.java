public class MemoryCursorRow_tbstati extends CPMemoryCursorRow {
  public MemoryCursorRow_tbstati() {
  }
  public MemoryCursorRow_tbstati(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbstati toBuild = new MemoryCursor_tbstati(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbstati toBuild = new MemoryCursor_tbstati();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODSTA = "";
  String DESCRI = "";
  String SIGLA = "";
  String ISO = "";
  String ISO2 = "";
  String IDTBLS = "";
  String IDBASE = "";
  String FLGSAE = "";
  String ISON = "";
  public boolean IsEmpty() {
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
    if ( ! (CPLib.Empty(FLGSAE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ISON))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbstati p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbstati.this.CODSTA = copyAndCast(p_row.CODSTA);
      MemoryCursorRow_tbstati.this.DESCRI = copyAndCast(p_row.DESCRI);
      MemoryCursorRow_tbstati.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_tbstati.this.ISO = copyAndCast(p_row.ISO);
      MemoryCursorRow_tbstati.this.ISO2 = copyAndCast(p_row.ISO2);
      MemoryCursorRow_tbstati.this.IDTBLS = copyAndCast(p_row.IDTBLS);
      MemoryCursorRow_tbstati.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_tbstati.this.FLGSAE = copyAndCast(p_row.FLGSAE);
      MemoryCursorRow_tbstati.this.ISON = copyAndCast(p_row.ISON);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODSTA","DESCRI","SIGLA","ISO","ISO2","IDTBLS","IDBASE","FLGSAE","ISON"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Descrizione","Sigla","ISO 3","ISO 2","Fox","Fox","Corrispondenza stati con SAE","ISO 3 Numerico (OOM/SV)"};
    return l_names;
  }
}
