public class MemoryCursorRow_vt_regiones extends CPMemoryCursorRow {
  public MemoryCursorRow_vt_regiones() {
  }
  public MemoryCursorRow_vt_regiones(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_vt_regiones toBuild = new MemoryCursor_vt_regiones(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_vt_regiones toBuild = new MemoryCursor_vt_regiones();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double id_region = 0;
  String region = "";
  double id_regional = 0;
  String codice_MIT = "";
  double cod_pais = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(id_region))) {
      return false;
    }
    if ( ! (CPLib.Empty(region))) {
      return false;
    }
    if ( ! (CPLib.Empty(id_regional))) {
      return false;
    }
    if ( ! (CPLib.Empty(codice_MIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(cod_pais))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_vt_regiones p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_vt_regiones.this.id_region = copyAndCast(p_row.id_region);
      MemoryCursorRow_vt_regiones.this.region = copyAndCast(p_row.region);
      MemoryCursorRow_vt_regiones.this.id_regional = copyAndCast(p_row.id_regional);
      MemoryCursorRow_vt_regiones.this.codice_MIT = copyAndCast(p_row.codice_MIT);
      MemoryCursorRow_vt_regiones.this.cod_pais = copyAndCast(p_row.cod_pais);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"id_region","region","id_regional","codice_MIT","cod_pais"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","N","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","",""};
    return l_names;
  }
}
