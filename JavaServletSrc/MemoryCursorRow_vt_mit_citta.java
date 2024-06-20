public class MemoryCursorRow_vt_mit_citta extends CPMemoryCursorRow {
  public MemoryCursorRow_vt_mit_citta() {
  }
  public MemoryCursorRow_vt_mit_citta(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_vt_mit_citta toBuild = new MemoryCursor_vt_mit_citta(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_vt_mit_citta toBuild = new MemoryCursor_vt_mit_citta();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String cab = "";
  String citta = "";
  String prov = "";
  String cap = "";
  String pktbstati = "";
  String sigla = "";
  String pref = "";
  double cod_ciudad_sitrop = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(cab))) {
      return false;
    }
    if ( ! (CPLib.Empty(citta))) {
      return false;
    }
    if ( ! (CPLib.Empty(prov))) {
      return false;
    }
    if ( ! (CPLib.Empty(cap))) {
      return false;
    }
    if ( ! (CPLib.Empty(pktbstati))) {
      return false;
    }
    if ( ! (CPLib.Empty(sigla))) {
      return false;
    }
    if ( ! (CPLib.Empty(pref))) {
      return false;
    }
    if ( ! (CPLib.Empty(cod_ciudad_sitrop))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_vt_mit_citta p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_vt_mit_citta.this.cab = copyAndCast(p_row.cab);
      MemoryCursorRow_vt_mit_citta.this.citta = copyAndCast(p_row.citta);
      MemoryCursorRow_vt_mit_citta.this.prov = copyAndCast(p_row.prov);
      MemoryCursorRow_vt_mit_citta.this.cap = copyAndCast(p_row.cap);
      MemoryCursorRow_vt_mit_citta.this.pktbstati = copyAndCast(p_row.pktbstati);
      MemoryCursorRow_vt_mit_citta.this.sigla = copyAndCast(p_row.sigla);
      MemoryCursorRow_vt_mit_citta.this.pref = copyAndCast(p_row.pref);
      MemoryCursorRow_vt_mit_citta.this.cod_ciudad_sitrop = copyAndCast(p_row.cod_ciudad_sitrop);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"cab","citta","prov","cap","pktbstati","sigla","pref","cod_ciudad_sitrop"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","",""};
    return l_names;
  }
}
