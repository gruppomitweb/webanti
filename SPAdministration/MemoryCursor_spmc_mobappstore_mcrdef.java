// Definition generated from record definition spmc_mobappstore_mcrdef
public class MemoryCursor_spmc_mobappstore_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_spmc_mobappstore_mcrdef row;
  MemoryCursorRow_spmc_mobappstore_mcrdef empty_row;
  public MemoryCursor_spmc_mobappstore_mcrdef() {
    empty_row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_spmc_mobappstore_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_oa__code;
    p_oa__code = new java.util.Properties();
    java.util.Properties p_oaapptitle;
    p_oaapptitle = new java.util.Properties();
    java.util.Properties p_oaapplogo;
    p_oaapplogo = new java.util.Properties();
    java.util.Properties p_oaappmenu;
    p_oaappmenu = new java.util.Properties();
    java.util.Properties p_oareserved;
    p_oareserved = new java.util.Properties();
    java.util.Properties p_oaappchecksum;
    p_oaappchecksum = new java.util.Properties();
    java.util.Properties p_oatoadmin;
    p_oatoadmin = new java.util.Properties();
    java.util.Properties p_oaapptype;
    p_oaapptype = new java.util.Properties();
    java.util.Properties p_oaapppublished;
    p_oaapppublished = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oa__code".equalsIgnoreCase(key)) {
        p_oa__code = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaapptitle".equalsIgnoreCase(key)) {
        p_oaapptitle = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaapplogo".equalsIgnoreCase(key)) {
        p_oaapplogo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaappmenu".equalsIgnoreCase(key)) {
        p_oaappmenu = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oareserved".equalsIgnoreCase(key)) {
        p_oareserved = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaappchecksum".equalsIgnoreCase(key)) {
        p_oaappchecksum = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oatoadmin".equalsIgnoreCase(key)) {
        p_oatoadmin = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaapptype".equalsIgnoreCase(key)) {
        p_oaapptype = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oaapppublished".equalsIgnoreCase(key)) {
        p_oaapppublished = CPLib.GetProperties(p.getProperty(key));
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
      row.oa__code = CPLib.GetProperty(p_oa__code,"","",i);
      row.oaapptitle = CPLib.GetProperty(p_oaapptitle,"","",i);
      row.oaapplogo = CPLib.GetProperty(p_oaapplogo,"","",i);
      row.oaappmenu = CPLib.GetProperty(p_oaappmenu,"","",i);
      row.oareserved = CPLib.GetProperty(p_oareserved,"","",i);
      row.oaappchecksum = CPLib.GetProperty(p_oaappchecksum,"","",i);
      row.oatoadmin = CPLib.GetProperty(p_oatoadmin,"",0,i);
      row.oaapptype = CPLib.GetProperty(p_oaapptype,"",0,i);
      row.oaapppublished = CPLib.GetProperty(p_oaapppublished,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_spmc_mobappstore_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_spmc_mobappstore_mcrdef();
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
  public MemoryCursorRow_spmc_mobappstore_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_spmc_mobappstore_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_spmc_mobappstore_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    MemoryCursorRow_spmc_mobappstore_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_spmc_mobappstore_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_spmc_mobappstore_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
