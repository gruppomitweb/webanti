// Definition generated from record definition mcopevasp_mcrdef
public class MemoryCursor_mcopevasp_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcopevasp_mcrdef row;
  MemoryCursorRow_mcopevasp_mcrdef empty_row;
  public MemoryCursor_mcopevasp_mcrdef() {
    empty_row = new MemoryCursorRow_mcopevasp_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcopevasp_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODICE;
    p_CODICE = new java.util.Properties();
    java.util.Properties p_OPERAZIONI;
    p_OPERAZIONI = new java.util.Properties();
    java.util.Properties p_IMPORTO;
    p_IMPORTO = new java.util.Properties();
    java.util.Properties p_TOTIMPIN;
    p_TOTIMPIN = new java.util.Properties();
    java.util.Properties p_TOTIMPOUT;
    p_TOTIMPOUT = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE".equalsIgnoreCase(key)) {
        p_CODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAZIONI".equalsIgnoreCase(key)) {
        p_OPERAZIONI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO".equalsIgnoreCase(key)) {
        p_IMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTIMPIN".equalsIgnoreCase(key)) {
        p_TOTIMPIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTIMPOUT".equalsIgnoreCase(key)) {
        p_TOTIMPOUT = CPLib.GetProperties(p.getProperty(key));
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
      row.CODICE = CPLib.GetProperty(p_CODICE,"","",i);
      row.OPERAZIONI = CPLib.GetProperty(p_OPERAZIONI,"",0,i);
      row.IMPORTO = CPLib.GetProperty(p_IMPORTO,"",0,i);
      row.TOTIMPIN = CPLib.GetProperty(p_TOTIMPIN,"",0,i);
      row.TOTIMPOUT = CPLib.GetProperty(p_TOTIMPOUT,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcopevasp_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcopevasp_mcrdef();
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
  public MemoryCursorRow_mcopevasp_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcopevasp_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcopevasp_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    MemoryCursorRow_mcopevasp_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcopevasp_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcopevasp_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcopevasp_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
