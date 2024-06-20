public class MemoryCursorRow_cgo_causali extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_causali() {
  }
  public MemoryCursorRow_cgo_causali(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_causali toBuild = new MemoryCursor_cgo_causali(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_causali toBuild = new MemoryCursor_cgo_causali();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double CACODICE = 0;
  String CADESCRI = "";
  String CACODANA = "";
  String CACODSIN = "";
  String CASEGNO = "";
  String CATIPOPE = "";
  String CAFLGOPE = "";
  String CAFLGDIP = "";
  String CAFLGAUI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CADESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CACODANA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CACODSIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(CASEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATIPOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAFLGOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAFLGDIP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAFLGAUI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_causali p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_causali.this.CACODICE = copyAndCast(p_row.CACODICE);
      MemoryCursorRow_cgo_causali.this.CADESCRI = copyAndCast(p_row.CADESCRI);
      MemoryCursorRow_cgo_causali.this.CACODANA = copyAndCast(p_row.CACODANA);
      MemoryCursorRow_cgo_causali.this.CACODSIN = copyAndCast(p_row.CACODSIN);
      MemoryCursorRow_cgo_causali.this.CASEGNO = copyAndCast(p_row.CASEGNO);
      MemoryCursorRow_cgo_causali.this.CATIPOPE = copyAndCast(p_row.CATIPOPE);
      MemoryCursorRow_cgo_causali.this.CAFLGOPE = copyAndCast(p_row.CAFLGOPE);
      MemoryCursorRow_cgo_causali.this.CAFLGDIP = copyAndCast(p_row.CAFLGDIP);
      MemoryCursorRow_cgo_causali.this.CAFLGAUI = copyAndCast(p_row.CAFLGAUI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CACODICE","CADESCRI","CACODANA","CACODSIN","CASEGNO","CATIPOPE","CAFLGOPE","CAFLGDIP","CAFLGAUI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Causale","Descrizione","Causale Analitica ","Causale Sintetica","Dare / Avere","Tipo Operazione","Tipologia causale V/G/P/R","Utilizzabile Dipendenze","Causale AUI (S/N)"};
    return l_names;
  }
}
