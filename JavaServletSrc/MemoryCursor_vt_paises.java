// Definition generated from table vt_paises
public class MemoryCursor_vt_paises extends CPMemoryCursor {
  MemoryCursorRow_vt_paises row;
  MemoryCursorRow_vt_paises empty_row;
  public MemoryCursor_vt_paises() {
    empty_row = new MemoryCursorRow_vt_paises();
    row = empty_row;
  }
  public MemoryCursor_vt_paises(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_cod_pais;
    p_cod_pais = new java.util.Properties();
    java.util.Properties p_id_divisa;
    p_id_divisa = new java.util.Properties();
    java.util.Properties p_nom_pais;
    p_nom_pais = new java.util.Properties();
    java.util.Properties p_fec_alta;
    p_fec_alta = new java.util.Properties();
    java.util.Properties p_status;
    p_status = new java.util.Properties();
    java.util.Properties p_fec_baja;
    p_fec_baja = new java.util.Properties();
    java.util.Properties p_fec_cambio;
    p_fec_cambio = new java.util.Properties();
    java.util.Properties p_nom_estado;
    p_nom_estado = new java.util.Properties();
    java.util.Properties p_con_edocta;
    p_con_edocta = new java.util.Properties();
    java.util.Properties p_con_edocda;
    p_con_edocda = new java.util.Properties();
    java.util.Properties p_monto_sospechoso;
    p_monto_sospechoso = new java.util.Properties();
    java.util.Properties p_periodo;
    p_periodo = new java.util.Properties();
    java.util.Properties p_long_telefono;
    p_long_telefono = new java.util.Properties();
    java.util.Properties p_long_min_tel;
    p_long_min_tel = new java.util.Properties();
    java.util.Properties p_mon_min_sosp;
    p_mon_min_sosp = new java.util.Properties();
    java.util.Properties p_modifica;
    p_modifica = new java.util.Properties();
    java.util.Properties p_aci_pais;
    p_aci_pais = new java.util.Properties();
    java.util.Properties p_bts_cve;
    p_bts_cve = new java.util.Properties();
    java.util.Properties p_muestra_ben;
    p_muestra_ben = new java.util.Properties();
    java.util.Properties p_obliga_ben;
    p_obliga_ben = new java.util.Properties();
    java.util.Properties p_pos;
    p_pos = new java.util.Properties();
    java.util.Properties p_pais_q;
    p_pais_q = new java.util.Properties();
    java.util.Properties p_id_continente;
    p_id_continente = new java.util.Properties();
    java.util.Properties p_nm_pai_italiano;
    p_nm_pai_italiano = new java.util.Properties();
    java.util.Properties p_EN;
    p_EN = new java.util.Properties();
    java.util.Properties p_ES;
    p_ES = new java.util.Properties();
    java.util.Properties p_IT;
    p_IT = new java.util.Properties();
    java.util.Properties p_FR;
    p_FR = new java.util.Properties();
    java.util.Properties p_cod_pais_equiv;
    p_cod_pais_equiv = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cod_pais".equalsIgnoreCase(key)) {
        p_cod_pais = CPLib.GetProperties(p.getProperty(key));
      }
      if ("id_divisa".equalsIgnoreCase(key)) {
        p_id_divisa = CPLib.GetProperties(p.getProperty(key));
      }
      if ("nom_pais".equalsIgnoreCase(key)) {
        p_nom_pais = CPLib.GetProperties(p.getProperty(key));
      }
      if ("fec_alta".equalsIgnoreCase(key)) {
        p_fec_alta = CPLib.GetProperties(p.getProperty(key));
      }
      if ("status".equalsIgnoreCase(key)) {
        p_status = CPLib.GetProperties(p.getProperty(key));
      }
      if ("fec_baja".equalsIgnoreCase(key)) {
        p_fec_baja = CPLib.GetProperties(p.getProperty(key));
      }
      if ("fec_cambio".equalsIgnoreCase(key)) {
        p_fec_cambio = CPLib.GetProperties(p.getProperty(key));
      }
      if ("nom_estado".equalsIgnoreCase(key)) {
        p_nom_estado = CPLib.GetProperties(p.getProperty(key));
      }
      if ("con_edocta".equalsIgnoreCase(key)) {
        p_con_edocta = CPLib.GetProperties(p.getProperty(key));
      }
      if ("con_edocda".equalsIgnoreCase(key)) {
        p_con_edocda = CPLib.GetProperties(p.getProperty(key));
      }
      if ("monto_sospechoso".equalsIgnoreCase(key)) {
        p_monto_sospechoso = CPLib.GetProperties(p.getProperty(key));
      }
      if ("periodo".equalsIgnoreCase(key)) {
        p_periodo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("long_telefono".equalsIgnoreCase(key)) {
        p_long_telefono = CPLib.GetProperties(p.getProperty(key));
      }
      if ("long_min_tel".equalsIgnoreCase(key)) {
        p_long_min_tel = CPLib.GetProperties(p.getProperty(key));
      }
      if ("mon_min_sosp".equalsIgnoreCase(key)) {
        p_mon_min_sosp = CPLib.GetProperties(p.getProperty(key));
      }
      if ("modifica".equalsIgnoreCase(key)) {
        p_modifica = CPLib.GetProperties(p.getProperty(key));
      }
      if ("aci_pais".equalsIgnoreCase(key)) {
        p_aci_pais = CPLib.GetProperties(p.getProperty(key));
      }
      if ("bts_cve".equalsIgnoreCase(key)) {
        p_bts_cve = CPLib.GetProperties(p.getProperty(key));
      }
      if ("muestra_ben".equalsIgnoreCase(key)) {
        p_muestra_ben = CPLib.GetProperties(p.getProperty(key));
      }
      if ("obliga_ben".equalsIgnoreCase(key)) {
        p_obliga_ben = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pos".equalsIgnoreCase(key)) {
        p_pos = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pais_q".equalsIgnoreCase(key)) {
        p_pais_q = CPLib.GetProperties(p.getProperty(key));
      }
      if ("id_continente".equalsIgnoreCase(key)) {
        p_id_continente = CPLib.GetProperties(p.getProperty(key));
      }
      if ("nm_pai_italiano".equalsIgnoreCase(key)) {
        p_nm_pai_italiano = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EN".equalsIgnoreCase(key)) {
        p_EN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ES".equalsIgnoreCase(key)) {
        p_ES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IT".equalsIgnoreCase(key)) {
        p_IT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FR".equalsIgnoreCase(key)) {
        p_FR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cod_pais_equiv".equalsIgnoreCase(key)) {
        p_cod_pais_equiv = CPLib.GetProperties(p.getProperty(key));
      }
    }
    for ( i = 1; CPLib.le(i,Rows); i = i + (1)) {
      AppendBlank();
      String l_cKeyValue = null;
      l_cKeyValue = CPLib.GetProperty(l_Key,"",l_cKeyValue,i);
      Object l_KeyValue = l_cKeyValue;
      if ( ! (CPLib.IsNull(l_KeyValue))) {
        SetKey(l_KeyValue);
      }
      row.cod_pais = CPLib.GetProperty(p_cod_pais,"",0,i);
      row.id_divisa = CPLib.GetProperty(p_id_divisa,"","",i);
      row.nom_pais = CPLib.GetProperty(p_nom_pais,"","",i);
      row.fec_alta = CPLib.GetProperty(p_fec_alta,"",CPLib.NullDate(),i);
      row.status = CPLib.GetProperty(p_status,"","",i);
      row.fec_baja = CPLib.GetProperty(p_fec_baja,"",CPLib.NullDate(),i);
      row.fec_cambio = CPLib.GetProperty(p_fec_cambio,"",CPLib.NullDate(),i);
      row.nom_estado = CPLib.GetProperty(p_nom_estado,"","",i);
      row.con_edocta = CPLib.GetProperty(p_con_edocta,"",0,i);
      row.con_edocda = CPLib.GetProperty(p_con_edocda,"",0,i);
      row.monto_sospechoso = CPLib.GetProperty(p_monto_sospechoso,"",0,i);
      row.periodo = CPLib.GetProperty(p_periodo,"",0,i);
      row.long_telefono = CPLib.GetProperty(p_long_telefono,"",0,i);
      row.long_min_tel = CPLib.GetProperty(p_long_min_tel,"",0,i);
      row.mon_min_sosp = CPLib.GetProperty(p_mon_min_sosp,"",0,i);
      row.modifica = CPLib.GetProperty(p_modifica,"",0,i);
      row.aci_pais = CPLib.GetProperty(p_aci_pais,"",0,i);
      row.bts_cve = CPLib.GetProperty(p_bts_cve,"","",i);
      row.muestra_ben = CPLib.GetProperty(p_muestra_ben,"",0,i);
      row.obliga_ben = CPLib.GetProperty(p_obliga_ben,"","",i);
      row.pos = CPLib.GetProperty(p_pos,"",0,i);
      row.pais_q = CPLib.GetProperty(p_pais_q,"","",i);
      row.id_continente = CPLib.GetProperty(p_id_continente,"",0,i);
      row.nm_pai_italiano = CPLib.GetProperty(p_nm_pai_italiano,"","",i);
      row.EN = CPLib.GetProperty(p_EN,"","",i);
      row.ES = CPLib.GetProperty(p_ES,"","",i);
      row.IT = CPLib.GetProperty(p_IT,"","",i);
      row.FR = CPLib.GetProperty(p_FR,"","",i);
      row.cod_pais_equiv = CPLib.GetProperty(p_cod_pais_equiv,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_vt_paises)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_vt_paises();
  }
  protected String[] GetColumnNames() {
    return row.GetColumnNames();
  }
  protected String[] GetColumnTypes() {
    return row.GetColumnTypes();
  }
  public CPMemoryCursorRow CurrentRow() {
    return row;
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_vt_paises _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_vt_paises _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_vt_paises> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_vt_paises p_Row) {
    MemoryCursorRow_vt_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_paises();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_vt_paises p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_vt_paises();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
