// Definition generated from table tbvalute
public class MemoryCursor_tbvalute extends CPMemoryCursor {
  MemoryCursorRow_tbvalute row;
  MemoryCursorRow_tbvalute empty_row;
  public MemoryCursor_tbvalute() {
    empty_row = new MemoryCursorRow_tbvalute();
    row = empty_row;
  }
  public MemoryCursor_tbvalute(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODVAL;
    p_CODVAL = new java.util.Properties();
    java.util.Properties p_DESCRI;
    p_DESCRI = new java.util.Properties();
    java.util.Properties p_ISO;
    p_ISO = new java.util.Properties();
    java.util.Properties p_CAMBIO;
    p_CAMBIO = new java.util.Properties();
    java.util.Properties p_CAMBDAT;
    p_CAMBDAT = new java.util.Properties();
    java.util.Properties p_CAMBLIRA;
    p_CAMBLIRA = new java.util.Properties();
    java.util.Properties p_IDTBLS;
    p_IDTBLS = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODVAL".equalsIgnoreCase(key)) {
        p_CODVAL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRI".equalsIgnoreCase(key)) {
        p_DESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ISO".equalsIgnoreCase(key)) {
        p_ISO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAMBIO".equalsIgnoreCase(key)) {
        p_CAMBIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAMBDAT".equalsIgnoreCase(key)) {
        p_CAMBDAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAMBLIRA".equalsIgnoreCase(key)) {
        p_CAMBLIRA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDTBLS".equalsIgnoreCase(key)) {
        p_IDTBLS = CPLib.GetProperties(p.getProperty(key));
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
      row.CODVAL = CPLib.GetProperty(p_CODVAL,"","",i);
      row.DESCRI = CPLib.GetProperty(p_DESCRI,"","",i);
      row.ISO = CPLib.GetProperty(p_ISO,"","",i);
      row.CAMBIO = CPLib.GetProperty(p_CAMBIO,"",0,i);
      row.CAMBDAT = CPLib.GetProperty(p_CAMBDAT,"",0,i);
      row.CAMBLIRA = CPLib.GetProperty(p_CAMBLIRA,"",0,i);
      row.IDTBLS = CPLib.GetProperty(p_IDTBLS,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbvalute)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbvalute();
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
  public MemoryCursorRow_tbvalute _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbvalute _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbvalute> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbvalute p_Row) {
    MemoryCursorRow_tbvalute l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbvalute();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbvalute p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbvalute();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
