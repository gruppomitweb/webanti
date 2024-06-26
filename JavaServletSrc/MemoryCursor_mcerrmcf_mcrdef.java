// Definition generated from record definition mcerrmcf_mcrdef
public class MemoryCursor_mcerrmcf_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcerrmcf_mcrdef row;
  MemoryCursorRow_mcerrmcf_mcrdef empty_row;
  public MemoryCursor_mcerrmcf_mcrdef() {
    empty_row = new MemoryCursorRow_mcerrmcf_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcerrmcf_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_ERCODICE;
    p_ERCODICE = new java.util.Properties();
    java.util.Properties p_ERDESCRI;
    p_ERDESCRI = new java.util.Properties();
    java.util.Properties p_ERTESTO;
    p_ERTESTO = new java.util.Properties();
    java.util.Properties p_ERAZIONE;
    p_ERAZIONE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERCODICE".equalsIgnoreCase(key)) {
        p_ERCODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERDESCRI".equalsIgnoreCase(key)) {
        p_ERDESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERTESTO".equalsIgnoreCase(key)) {
        p_ERTESTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERAZIONE".equalsIgnoreCase(key)) {
        p_ERAZIONE = CPLib.GetProperties(p.getProperty(key));
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
      row.ERCODICE = CPLib.GetProperty(p_ERCODICE,"","",i);
      row.ERDESCRI = CPLib.GetProperty(p_ERDESCRI,"","",i);
      row.ERTESTO = CPLib.GetProperty(p_ERTESTO,"","",i);
      row.ERAZIONE = CPLib.GetProperty(p_ERAZIONE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcerrmcf_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcerrmcf_mcrdef();
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
  public MemoryCursorRow_mcerrmcf_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcerrmcf_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcerrmcf_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    MemoryCursorRow_mcerrmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcerrmcf_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcerrmcf_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
