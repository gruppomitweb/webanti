public class MemoryCursorRow_vt_mit_paises extends CPMemoryCursorRow {
  public MemoryCursorRow_vt_mit_paises() {
  }
  public MemoryCursorRow_vt_mit_paises(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_vt_mit_paises toBuild = new MemoryCursor_vt_mit_paises(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_vt_mit_paises toBuild = new MemoryCursor_vt_mit_paises();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double cod_pais = 0;
  String cod_comune = "";
  String cod_mit = "";
  String pais_q = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(cod_pais))) {
      return false;
    }
    if ( ! (CPLib.Empty(cod_comune))) {
      return false;
    }
    if ( ! (CPLib.Empty(cod_mit))) {
      return false;
    }
    if ( ! (CPLib.Empty(pais_q))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_vt_mit_paises p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_vt_mit_paises.this.cod_pais = copyAndCast(p_row.cod_pais);
      MemoryCursorRow_vt_mit_paises.this.cod_comune = copyAndCast(p_row.cod_comune);
      MemoryCursorRow_vt_mit_paises.this.cod_mit = copyAndCast(p_row.cod_mit);
      MemoryCursorRow_vt_mit_paises.this.pais_q = copyAndCast(p_row.pais_q);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"cod_pais","cod_comune","cod_mit","pais_q"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","",""};
    return l_names;
  }
}
