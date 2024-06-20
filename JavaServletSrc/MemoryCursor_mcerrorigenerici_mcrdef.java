// Definition generated from record definition mcerrorigenerici_mcrdef
public class MemoryCursor_mcerrorigenerici_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcerrorigenerici_mcrdef row;
  MemoryCursorRow_mcerrorigenerici_mcrdef empty_row;
  public MemoryCursor_mcerrorigenerici_mcrdef() {
    empty_row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcerrorigenerici_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_field1;
    p_field1 = new java.util.Properties();
    java.util.Properties p_field2;
    p_field2 = new java.util.Properties();
    java.util.Properties p_field3;
    p_field3 = new java.util.Properties();
    java.util.Properties p_field4;
    p_field4 = new java.util.Properties();
    java.util.Properties p_field5;
    p_field5 = new java.util.Properties();
    java.util.Properties p_field6;
    p_field6 = new java.util.Properties();
    java.util.Properties p_field7;
    p_field7 = new java.util.Properties();
    java.util.Properties p_field8;
    p_field8 = new java.util.Properties();
    java.util.Properties p_field9;
    p_field9 = new java.util.Properties();
    java.util.Properties p_field10;
    p_field10 = new java.util.Properties();
    java.util.Properties p_field11;
    p_field11 = new java.util.Properties();
    java.util.Properties p_field12;
    p_field12 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field1".equalsIgnoreCase(key)) {
        p_field1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field2".equalsIgnoreCase(key)) {
        p_field2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field3".equalsIgnoreCase(key)) {
        p_field3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field4".equalsIgnoreCase(key)) {
        p_field4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field5".equalsIgnoreCase(key)) {
        p_field5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field6".equalsIgnoreCase(key)) {
        p_field6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field7".equalsIgnoreCase(key)) {
        p_field7 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field8".equalsIgnoreCase(key)) {
        p_field8 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field9".equalsIgnoreCase(key)) {
        p_field9 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field10".equalsIgnoreCase(key)) {
        p_field10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field11".equalsIgnoreCase(key)) {
        p_field11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("field12".equalsIgnoreCase(key)) {
        p_field12 = CPLib.GetProperties(p.getProperty(key));
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
      row.field1 = CPLib.GetProperty(p_field1,"","",i);
      row.field2 = CPLib.GetProperty(p_field2,"","",i);
      row.field3 = CPLib.GetProperty(p_field3,"","",i);
      row.field4 = CPLib.GetProperty(p_field4,"","",i);
      row.field5 = CPLib.GetProperty(p_field5,"","",i);
      row.field6 = CPLib.GetProperty(p_field6,"","",i);
      row.field7 = CPLib.GetProperty(p_field7,"","",i);
      row.field8 = CPLib.GetProperty(p_field8,"","",i);
      row.field9 = CPLib.GetProperty(p_field9,"","",i);
      row.field10 = CPLib.GetProperty(p_field10,"","",i);
      row.field11 = CPLib.GetProperty(p_field11,"","",i);
      row.field12 = CPLib.GetProperty(p_field12,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcerrorigenerici_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcerrorigenerici_mcrdef();
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
  public MemoryCursorRow_mcerrorigenerici_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcerrorigenerici_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcerrorigenerici_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    MemoryCursorRow_mcerrorigenerici_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcerrorigenerici_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcerrorigenerici_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
