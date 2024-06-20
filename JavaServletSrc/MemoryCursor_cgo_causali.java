// Definition generated from table cgo_causali
public class MemoryCursor_cgo_causali extends CPMemoryCursor {
  MemoryCursorRow_cgo_causali row;
  MemoryCursorRow_cgo_causali empty_row;
  public MemoryCursor_cgo_causali() {
    empty_row = new MemoryCursorRow_cgo_causali();
    row = empty_row;
  }
  public MemoryCursor_cgo_causali(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CACODICE;
    p_CACODICE = new java.util.Properties();
    java.util.Properties p_CADESCRI;
    p_CADESCRI = new java.util.Properties();
    java.util.Properties p_CACODANA;
    p_CACODANA = new java.util.Properties();
    java.util.Properties p_CACODSIN;
    p_CACODSIN = new java.util.Properties();
    java.util.Properties p_CASEGNO;
    p_CASEGNO = new java.util.Properties();
    java.util.Properties p_CATIPOPE;
    p_CATIPOPE = new java.util.Properties();
    java.util.Properties p_CAFLGOPE;
    p_CAFLGOPE = new java.util.Properties();
    java.util.Properties p_CAFLGDIP;
    p_CAFLGDIP = new java.util.Properties();
    java.util.Properties p_CAFLGAUI;
    p_CAFLGAUI = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CACODICE".equalsIgnoreCase(key)) {
        p_CACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CADESCRI".equalsIgnoreCase(key)) {
        p_CADESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CACODANA".equalsIgnoreCase(key)) {
        p_CACODANA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CACODSIN".equalsIgnoreCase(key)) {
        p_CACODSIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASEGNO".equalsIgnoreCase(key)) {
        p_CASEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATIPOPE".equalsIgnoreCase(key)) {
        p_CATIPOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAFLGOPE".equalsIgnoreCase(key)) {
        p_CAFLGOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAFLGDIP".equalsIgnoreCase(key)) {
        p_CAFLGDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAFLGAUI".equalsIgnoreCase(key)) {
        p_CAFLGAUI = CPLib.GetProperties(p.getProperty(key));
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
      row.CACODICE = CPLib.GetProperty(p_CACODICE,"",0,i);
      row.CADESCRI = CPLib.GetProperty(p_CADESCRI,"","",i);
      row.CACODANA = CPLib.GetProperty(p_CACODANA,"","",i);
      row.CACODSIN = CPLib.GetProperty(p_CACODSIN,"","",i);
      row.CASEGNO = CPLib.GetProperty(p_CASEGNO,"","",i);
      row.CATIPOPE = CPLib.GetProperty(p_CATIPOPE,"","",i);
      row.CAFLGOPE = CPLib.GetProperty(p_CAFLGOPE,"","",i);
      row.CAFLGDIP = CPLib.GetProperty(p_CAFLGDIP,"","",i);
      row.CAFLGAUI = CPLib.GetProperty(p_CAFLGAUI,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_causali)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_causali();
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
  public MemoryCursorRow_cgo_causali _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_causali _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_causali> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_causali p_Row) {
    MemoryCursorRow_cgo_causali l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_causali();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_causali p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_causali();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
