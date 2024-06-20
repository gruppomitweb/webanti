// Definition generated from table vt_regiones
public class MemoryCursor_vt_regiones extends CPMemoryCursor {
  MemoryCursorRow_vt_regiones row;
  MemoryCursorRow_vt_regiones empty_row;
  public MemoryCursor_vt_regiones() {
    empty_row = new MemoryCursorRow_vt_regiones();
    row = empty_row;
  }
  public MemoryCursor_vt_regiones(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_id_region;
    p_id_region = new java.util.Properties();
    java.util.Properties p_region;
    p_region = new java.util.Properties();
    java.util.Properties p_id_regional;
    p_id_regional = new java.util.Properties();
    java.util.Properties p_codice_MIT;
    p_codice_MIT = new java.util.Properties();
    java.util.Properties p_cod_pais;
    p_cod_pais = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("id_region".equalsIgnoreCase(key)) {
        p_id_region = CPLib.GetProperties(p.getProperty(key));
      }
      if ("region".equalsIgnoreCase(key)) {
        p_region = CPLib.GetProperties(p.getProperty(key));
      }
      if ("id_regional".equalsIgnoreCase(key)) {
        p_id_regional = CPLib.GetProperties(p.getProperty(key));
      }
      if ("codice_MIT".equalsIgnoreCase(key)) {
        p_codice_MIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cod_pais".equalsIgnoreCase(key)) {
        p_cod_pais = CPLib.GetProperties(p.getProperty(key));
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
      row.id_region = CPLib.GetProperty(p_id_region,"",0,i);
      row.region = CPLib.GetProperty(p_region,"","",i);
      row.id_regional = CPLib.GetProperty(p_id_regional,"",0,i);
      row.codice_MIT = CPLib.GetProperty(p_codice_MIT,"","",i);
      row.cod_pais = CPLib.GetProperty(p_cod_pais,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_vt_regiones)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_vt_regiones();
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
  public MemoryCursorRow_vt_regiones _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_vt_regiones _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_vt_regiones> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_vt_regiones p_Row) {
    MemoryCursorRow_vt_regiones l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_regiones();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_vt_regiones p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_vt_regiones();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
