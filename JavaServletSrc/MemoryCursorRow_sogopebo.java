public class MemoryCursorRow_sogopebo extends CPMemoryCursorRow {
  public MemoryCursorRow_sogopebo() {
  }
  public MemoryCursorRow_sogopebo(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sogopebo toBuild = new MemoryCursor_sogopebo(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sogopebo toBuild = new MemoryCursor_sogopebo();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String IDFILEBO = "";
  double CPROWNUM = 0;
  String CODSOG = "";
  String LEGAME = "";
  String IDBASE = "";
  String NUMCOL = "";
  String TIPOFILE = "";
  String RAPCOL = "";
  String UCODE = "";
  java.sql.Timestamp NUMIMP = CPLib.NullDateTime();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(IDFILEBO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CPROWNUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODSOG))) {
      return false;
    }
    if ( ! (CPLib.Empty(LEGAME))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMCOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOFILE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPCOL))) {
      return false;
    }
    if ( ! (CPLib.Empty(UCODE))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sogopebo p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sogopebo.this.IDFILEBO = copyAndCast(p_row.IDFILEBO);
      MemoryCursorRow_sogopebo.this.CPROWNUM = copyAndCast(p_row.CPROWNUM);
      MemoryCursorRow_sogopebo.this.CODSOG = copyAndCast(p_row.CODSOG);
      MemoryCursorRow_sogopebo.this.LEGAME = copyAndCast(p_row.LEGAME);
      MemoryCursorRow_sogopebo.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_sogopebo.this.NUMCOL = copyAndCast(p_row.NUMCOL);
      MemoryCursorRow_sogopebo.this.TIPOFILE = copyAndCast(p_row.TIPOFILE);
      MemoryCursorRow_sogopebo.this.RAPCOL = copyAndCast(p_row.RAPCOL);
      MemoryCursorRow_sogopebo.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_sogopebo.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDFILEBO","CPROWNUM","CODSOG","LEGAME","IDBASE","NUMCOL","TIPOFILE","RAPCOL","UCODE","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","C","C","C","C","C","C","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Idbase di Operazbo","Numero Progressivo","Codice Soggetto","Tipo Legame","","","","","","Mark Importazione"};
    return l_names;
  }
}
