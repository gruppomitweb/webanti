// Definition generated from record definition mcdatistru_mcrdef
public class MemoryCursor_mcdatistru_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcdatistru_mcrdef row;
  MemoryCursorRow_mcdatistru_mcrdef empty_row;
  public MemoryCursor_mcdatistru_mcrdef() {
    empty_row = new MemoryCursorRow_mcdatistru_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcdatistru_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_colonna1;
    p_colonna1 = new java.util.Properties();
    java.util.Properties p_colonna2;
    p_colonna2 = new java.util.Properties();
    java.util.Properties p_colonna3;
    p_colonna3 = new java.util.Properties();
    java.util.Properties p_colonna4;
    p_colonna4 = new java.util.Properties();
    java.util.Properties p_colonna5;
    p_colonna5 = new java.util.Properties();
    java.util.Properties p_colonna6;
    p_colonna6 = new java.util.Properties();
    java.util.Properties p_colonna7;
    p_colonna7 = new java.util.Properties();
    java.util.Properties p_colonna8;
    p_colonna8 = new java.util.Properties();
    java.util.Properties p_colonna9;
    p_colonna9 = new java.util.Properties();
    java.util.Properties p_colonna10;
    p_colonna10 = new java.util.Properties();
    java.util.Properties p_colonna11;
    p_colonna11 = new java.util.Properties();
    java.util.Properties p_colonna12;
    p_colonna12 = new java.util.Properties();
    java.util.Properties p_colonna13;
    p_colonna13 = new java.util.Properties();
    java.util.Properties p_colonna14;
    p_colonna14 = new java.util.Properties();
    java.util.Properties p_colonna15;
    p_colonna15 = new java.util.Properties();
    java.util.Properties p_colonna16;
    p_colonna16 = new java.util.Properties();
    java.util.Properties p_colonna17;
    p_colonna17 = new java.util.Properties();
    java.util.Properties p_colonna18;
    p_colonna18 = new java.util.Properties();
    java.util.Properties p_colonna19;
    p_colonna19 = new java.util.Properties();
    java.util.Properties p_colonna20;
    p_colonna20 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna1".equalsIgnoreCase(key)) {
        p_colonna1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna2".equalsIgnoreCase(key)) {
        p_colonna2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna3".equalsIgnoreCase(key)) {
        p_colonna3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna4".equalsIgnoreCase(key)) {
        p_colonna4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna5".equalsIgnoreCase(key)) {
        p_colonna5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna6".equalsIgnoreCase(key)) {
        p_colonna6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna7".equalsIgnoreCase(key)) {
        p_colonna7 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna8".equalsIgnoreCase(key)) {
        p_colonna8 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna9".equalsIgnoreCase(key)) {
        p_colonna9 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna10".equalsIgnoreCase(key)) {
        p_colonna10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna11".equalsIgnoreCase(key)) {
        p_colonna11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna12".equalsIgnoreCase(key)) {
        p_colonna12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna13".equalsIgnoreCase(key)) {
        p_colonna13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna14".equalsIgnoreCase(key)) {
        p_colonna14 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna15".equalsIgnoreCase(key)) {
        p_colonna15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna16".equalsIgnoreCase(key)) {
        p_colonna16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna17".equalsIgnoreCase(key)) {
        p_colonna17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna18".equalsIgnoreCase(key)) {
        p_colonna18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna19".equalsIgnoreCase(key)) {
        p_colonna19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna20".equalsIgnoreCase(key)) {
        p_colonna20 = CPLib.GetProperties(p.getProperty(key));
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
      row.colonna1 = CPLib.GetProperty(p_colonna1,"","",i);
      row.colonna2 = CPLib.GetProperty(p_colonna2,"","",i);
      row.colonna3 = CPLib.GetProperty(p_colonna3,"","",i);
      row.colonna4 = CPLib.GetProperty(p_colonna4,"","",i);
      row.colonna5 = CPLib.GetProperty(p_colonna5,"","",i);
      row.colonna6 = CPLib.GetProperty(p_colonna6,"","",i);
      row.colonna7 = CPLib.GetProperty(p_colonna7,"","",i);
      row.colonna8 = CPLib.GetProperty(p_colonna8,"","",i);
      row.colonna9 = CPLib.GetProperty(p_colonna9,"","",i);
      row.colonna10 = CPLib.GetProperty(p_colonna10,"","",i);
      row.colonna11 = CPLib.GetProperty(p_colonna11,"","",i);
      row.colonna12 = CPLib.GetProperty(p_colonna12,"","",i);
      row.colonna13 = CPLib.GetProperty(p_colonna13,"","",i);
      row.colonna14 = CPLib.GetProperty(p_colonna14,"","",i);
      row.colonna15 = CPLib.GetProperty(p_colonna15,"","",i);
      row.colonna16 = CPLib.GetProperty(p_colonna16,"","",i);
      row.colonna17 = CPLib.GetProperty(p_colonna17,"","",i);
      row.colonna18 = CPLib.GetProperty(p_colonna18,"","",i);
      row.colonna19 = CPLib.GetProperty(p_colonna19,"","",i);
      row.colonna20 = CPLib.GetProperty(p_colonna20,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcdatistru_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcdatistru_mcrdef();
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
  public MemoryCursorRow_mcdatistru_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcdatistru_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcdatistru_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    MemoryCursorRow_mcdatistru_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcdatistru_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcdatistru_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcdatistru_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
