public class MemoryCursorRow_fiduciabo extends CPMemoryCursorRow {
  public MemoryCursorRow_fiduciabo() {
  }
  public MemoryCursorRow_fiduciabo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_fiduciabo toBuild = new MemoryCursor_fiduciabo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_fiduciabo toBuild = new MemoryCursor_fiduciabo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDFILEBO = "";
  String CODSOG = "";
  String TIPOFILE = "";
  String NUMCOL = "";
  String LEGAME = "";
  String RAPCOL = "";
  String UCODE = "";
  String IDBASE = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDFILEBO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMCOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(LEGAME))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPCOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_fiduciabo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_fiduciabo.this.IDFILEBO = copyAndCast(p_row.IDFILEBO);
      MemoryCursorRow_fiduciabo.this.CODSOG = copyAndCast(p_row.CODSOG);
      MemoryCursorRow_fiduciabo.this.TIPOFILE = copyAndCast(p_row.TIPOFILE);
      MemoryCursorRow_fiduciabo.this.NUMCOL = copyAndCast(p_row.NUMCOL);
      MemoryCursorRow_fiduciabo.this.LEGAME = copyAndCast(p_row.LEGAME);
      MemoryCursorRow_fiduciabo.this.RAPCOL = copyAndCast(p_row.RAPCOL);
      MemoryCursorRow_fiduciabo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_fiduciabo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_fiduciabo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDFILEBO","CODSOG","TIPOFILE","NUMCOL","LEGAME","RAPCOL","UCODE","IDBASE","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","Codice Soggetto","Tipo FIle","Codice Operazione","Tipo Legame","Codice rapporto Collegato","Codice Univoco","Identificativo riga","Mark Importazione"};
    return l_names;
  }
}
