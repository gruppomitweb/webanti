// Definition generated from record definition mcdaycases_mcrdef
public class MemoryCursor_mcdaycases_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcdaycases_mcrdef row;
  MemoryCursorRow_mcdaycases_mcrdef empty_row;
  public MemoryCursor_mcdaycases_mcrdef() {
    empty_row = new MemoryCursorRow_mcdaycases_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcdaycases_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_TOTTRX;
    p_TOTTRX = new java.util.Properties();
    java.util.Properties p_CASO_1;
    p_CASO_1 = new java.util.Properties();
    java.util.Properties p_CASO_2;
    p_CASO_2 = new java.util.Properties();
    java.util.Properties p_CASO_3;
    p_CASO_3 = new java.util.Properties();
    java.util.Properties p_CASO_4;
    p_CASO_4 = new java.util.Properties();
    java.util.Properties p_CASO_5;
    p_CASO_5 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTTRX".equalsIgnoreCase(key)) {
        p_TOTTRX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASO_1".equalsIgnoreCase(key)) {
        p_CASO_1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASO_2".equalsIgnoreCase(key)) {
        p_CASO_2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASO_3".equalsIgnoreCase(key)) {
        p_CASO_3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASO_4".equalsIgnoreCase(key)) {
        p_CASO_4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASO_5".equalsIgnoreCase(key)) {
        p_CASO_5 = CPLib.GetProperties(p.getProperty(key));
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
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.TOTTRX = CPLib.GetProperty(p_TOTTRX,"",0,i);
      row.CASO_1 = CPLib.GetProperty(p_CASO_1,"",0,i);
      row.CASO_2 = CPLib.GetProperty(p_CASO_2,"",0,i);
      row.CASO_3 = CPLib.GetProperty(p_CASO_3,"",0,i);
      row.CASO_4 = CPLib.GetProperty(p_CASO_4,"",0,i);
      row.CASO_5 = CPLib.GetProperty(p_CASO_5,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcdaycases_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcdaycases_mcrdef();
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
  public MemoryCursorRow_mcdaycases_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcdaycases_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcdaycases_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    MemoryCursorRow_mcdaycases_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdaycases_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcdaycases_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcdaycases_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
