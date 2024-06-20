public class MemoryCursorRow_clientiope extends CPMemoryCursorRow {
  public MemoryCursorRow_clientiope() {
  }
  public MemoryCursorRow_clientiope(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_clientiope toBuild = new MemoryCursor_clientiope(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_clientiope toBuild = new MemoryCursor_clientiope();
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
  double PROQUOTA = 0;
  double IMPSARA = 0;
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
    if ( ! (CPLib.Empty(PROQUOTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPSARA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMIMP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_clientiope p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_clientiope.this.IDFILEBO = copyAndCast(p_row.IDFILEBO);
      MemoryCursorRow_clientiope.this.CODSOG = copyAndCast(p_row.CODSOG);
      MemoryCursorRow_clientiope.this.TIPOFILE = copyAndCast(p_row.TIPOFILE);
      MemoryCursorRow_clientiope.this.NUMCOL = copyAndCast(p_row.NUMCOL);
      MemoryCursorRow_clientiope.this.LEGAME = copyAndCast(p_row.LEGAME);
      MemoryCursorRow_clientiope.this.RAPCOL = copyAndCast(p_row.RAPCOL);
      MemoryCursorRow_clientiope.this.UCODE = copyAndCast(p_row.UCODE);
      MemoryCursorRow_clientiope.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_clientiope.this.PROQUOTA = copyAndCast(p_row.PROQUOTA);
      MemoryCursorRow_clientiope.this.IMPSARA = copyAndCast(p_row.IMPSARA);
      MemoryCursorRow_clientiope.this.NUMIMP = copyAndCast(p_row.NUMIMP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"IDFILEBO","CODSOG","TIPOFILE","NUMCOL","LEGAME","RAPCOL","UCODE","IDBASE","PROQUOTA","IMPSARA","NUMIMP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","N","N","T"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","Codice Soggetto","Tipo FIle","Codice Operazione","Tipo Legame","Codice rapporto Collegato","Codice Univoco","Identificativo riga","Pro Quota","Importo per Sara","Mark Importazione"};
    return l_names;
  }
}
