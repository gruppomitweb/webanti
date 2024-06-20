// Definition generated from table vt_mit_paises
public class MemoryCursor_vt_mit_paises extends CPMemoryCursor {
  MemoryCursorRow_vt_mit_paises row;
  MemoryCursorRow_vt_mit_paises empty_row;
  public MemoryCursor_vt_mit_paises() {
    empty_row = new MemoryCursorRow_vt_mit_paises();
    row = empty_row;
  }
  public MemoryCursor_vt_mit_paises(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_cod_pais;
    p_cod_pais = new java.util.Properties();
    java.util.Properties p_cod_comune;
    p_cod_comune = new java.util.Properties();
    java.util.Properties p_cod_mit;
    p_cod_mit = new java.util.Properties();
    java.util.Properties p_pais_q;
    p_pais_q = new java.util.Properties();
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
      if ("cod_comune".equalsIgnoreCase(key)) {
        p_cod_comune = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cod_mit".equalsIgnoreCase(key)) {
        p_cod_mit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pais_q".equalsIgnoreCase(key)) {
        p_pais_q = CPLib.GetProperties(p.getProperty(key));
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
      row.cod_comune = CPLib.GetProperty(p_cod_comune,"","",i);
      row.cod_mit = CPLib.GetProperty(p_cod_mit,"","",i);
      row.pais_q = CPLib.GetProperty(p_pais_q,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_vt_mit_paises)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_vt_mit_paises();
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
  public MemoryCursorRow_vt_mit_paises _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_vt_mit_paises _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_vt_mit_paises> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_vt_mit_paises p_Row) {
    MemoryCursorRow_vt_mit_paises l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_paises();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_vt_mit_paises p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_vt_mit_paises();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
