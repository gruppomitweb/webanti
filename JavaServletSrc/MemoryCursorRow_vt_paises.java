public class MemoryCursorRow_vt_paises extends CPMemoryCursorRow {
  public MemoryCursorRow_vt_paises() {
  }
  public MemoryCursorRow_vt_paises(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_vt_paises toBuild = new MemoryCursor_vt_paises(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_vt_paises toBuild = new MemoryCursor_vt_paises();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double cod_pais = 0;
  String id_divisa = "";
  String nom_pais = "";
  java.sql.Date fec_alta = CPLib.NullDate();
  String status = "";
  java.sql.Date fec_baja = CPLib.NullDate();
  java.sql.Date fec_cambio = CPLib.NullDate();
  String nom_estado = "";
  double con_edocta = 0;
  double con_edocda = 0;
  double monto_sospechoso = 0;
  double periodo = 0;
  double long_telefono = 0;
  double long_min_tel = 0;
  double mon_min_sosp = 0;
  double modifica = 0;
  double aci_pais = 0;
  String bts_cve = "";
  double muestra_ben = 0;
  String obliga_ben = "";
  double pos = 0;
  String pais_q = "";
  double id_continente = 0;
  String nm_pai_italiano = "";
  String EN = "";
  String ES = "";
  String IT = "";
  String FR = "";
  double cod_pais_equiv = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(cod_pais))) {
      return false;
    }
    if ( ! (CPLib.Empty(id_divisa))) {
      return false;
    }
    if ( ! (CPLib.Empty(nom_pais))) {
      return false;
    }
    if ( ! (CPLib.Empty(fec_alta))) {
      return false;
    }
    if ( ! (CPLib.Empty(status))) {
      return false;
    }
    if ( ! (CPLib.Empty(fec_baja))) {
      return false;
    }
    if ( ! (CPLib.Empty(fec_cambio))) {
      return false;
    }
    if ( ! (CPLib.Empty(nom_estado))) {
      return false;
    }
    if ( ! (CPLib.Empty(con_edocta))) {
      return false;
    }
    if ( ! (CPLib.Empty(con_edocda))) {
      return false;
    }
    if ( ! (CPLib.Empty(monto_sospechoso))) {
      return false;
    }
    if ( ! (CPLib.Empty(periodo))) {
      return false;
    }
    if ( ! (CPLib.Empty(long_telefono))) {
      return false;
    }
    if ( ! (CPLib.Empty(long_min_tel))) {
      return false;
    }
    if ( ! (CPLib.Empty(mon_min_sosp))) {
      return false;
    }
    if ( ! (CPLib.Empty(modifica))) {
      return false;
    }
    if ( ! (CPLib.Empty(aci_pais))) {
      return false;
    }
    if ( ! (CPLib.Empty(bts_cve))) {
      return false;
    }
    if ( ! (CPLib.Empty(muestra_ben))) {
      return false;
    }
    if ( ! (CPLib.Empty(obliga_ben))) {
      return false;
    }
    if ( ! (CPLib.Empty(pos))) {
      return false;
    }
    if ( ! (CPLib.Empty(pais_q))) {
      return false;
    }
    if ( ! (CPLib.Empty(id_continente))) {
      return false;
    }
    if ( ! (CPLib.Empty(nm_pai_italiano))) {
      return false;
    }
    if ( ! (CPLib.Empty(EN))) {
      return false;
    }
    if ( ! (CPLib.Empty(ES))) {
      return false;
    }
    if ( ! (CPLib.Empty(IT))) {
      return false;
    }
    if ( ! (CPLib.Empty(FR))) {
      return false;
    }
    if ( ! (CPLib.Empty(cod_pais_equiv))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_vt_paises p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_vt_paises.this.cod_pais = copyAndCast(p_row.cod_pais);
      MemoryCursorRow_vt_paises.this.id_divisa = copyAndCast(p_row.id_divisa);
      MemoryCursorRow_vt_paises.this.nom_pais = copyAndCast(p_row.nom_pais);
      MemoryCursorRow_vt_paises.this.fec_alta = copyAndCast(p_row.fec_alta);
      MemoryCursorRow_vt_paises.this.status = copyAndCast(p_row.status);
      MemoryCursorRow_vt_paises.this.fec_baja = copyAndCast(p_row.fec_baja);
      MemoryCursorRow_vt_paises.this.fec_cambio = copyAndCast(p_row.fec_cambio);
      MemoryCursorRow_vt_paises.this.nom_estado = copyAndCast(p_row.nom_estado);
      MemoryCursorRow_vt_paises.this.con_edocta = copyAndCast(p_row.con_edocta);
      MemoryCursorRow_vt_paises.this.con_edocda = copyAndCast(p_row.con_edocda);
      MemoryCursorRow_vt_paises.this.monto_sospechoso = copyAndCast(p_row.monto_sospechoso);
      MemoryCursorRow_vt_paises.this.periodo = copyAndCast(p_row.periodo);
      MemoryCursorRow_vt_paises.this.long_telefono = copyAndCast(p_row.long_telefono);
      MemoryCursorRow_vt_paises.this.long_min_tel = copyAndCast(p_row.long_min_tel);
      MemoryCursorRow_vt_paises.this.mon_min_sosp = copyAndCast(p_row.mon_min_sosp);
      MemoryCursorRow_vt_paises.this.modifica = copyAndCast(p_row.modifica);
      MemoryCursorRow_vt_paises.this.aci_pais = copyAndCast(p_row.aci_pais);
      MemoryCursorRow_vt_paises.this.bts_cve = copyAndCast(p_row.bts_cve);
      MemoryCursorRow_vt_paises.this.muestra_ben = copyAndCast(p_row.muestra_ben);
      MemoryCursorRow_vt_paises.this.obliga_ben = copyAndCast(p_row.obliga_ben);
      MemoryCursorRow_vt_paises.this.pos = copyAndCast(p_row.pos);
      MemoryCursorRow_vt_paises.this.pais_q = copyAndCast(p_row.pais_q);
      MemoryCursorRow_vt_paises.this.id_continente = copyAndCast(p_row.id_continente);
      MemoryCursorRow_vt_paises.this.nm_pai_italiano = copyAndCast(p_row.nm_pai_italiano);
      MemoryCursorRow_vt_paises.this.EN = copyAndCast(p_row.EN);
      MemoryCursorRow_vt_paises.this.ES = copyAndCast(p_row.ES);
      MemoryCursorRow_vt_paises.this.IT = copyAndCast(p_row.IT);
      MemoryCursorRow_vt_paises.this.FR = copyAndCast(p_row.FR);
      MemoryCursorRow_vt_paises.this.cod_pais_equiv = copyAndCast(p_row.cod_pais_equiv);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"cod_pais","id_divisa","nom_pais","fec_alta","status","fec_baja","fec_cambio","nom_estado","con_edocta","con_edocda","monto_sospechoso","periodo","long_telefono","long_min_tel","mon_min_sosp","modifica","aci_pais","bts_cve","muestra_ben","obliga_ben","pos","pais_q","id_continente","nm_pai_italiano","EN","ES","IT","FR","cod_pais_equiv"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","D","C","D","D","C","N","N","N","N","N","N","N","N","N","C","N","C","N","C","N","C","C","C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    return l_names;
  }
}
