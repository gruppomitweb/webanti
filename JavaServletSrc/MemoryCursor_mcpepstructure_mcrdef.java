// Definition generated from record definition mcpepstructure_mcrdef
public class MemoryCursor_mcpepstructure_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcpepstructure_mcrdef row;
  MemoryCursorRow_mcpepstructure_mcrdef empty_row;
  public MemoryCursor_mcpepstructure_mcrdef() {
    empty_row = new MemoryCursorRow_mcpepstructure_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcpepstructure_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_PEPCOG;
    p_PEPCOG = new java.util.Properties();
    java.util.Properties p_PEPNOM;
    p_PEPNOM = new java.util.Properties();
    java.util.Properties p_PEPNAS;
    p_PEPNAS = new java.util.Properties();
    java.util.Properties p_PEPMOR;
    p_PEPMOR = new java.util.Properties();
    java.util.Properties p_PEPCAT;
    p_PEPCAT = new java.util.Properties();
    java.util.Properties p_PEPLNAS;
    p_PEPLNAS = new java.util.Properties();
    java.util.Properties p_PEPPNAS;
    p_PEPPNAS = new java.util.Properties();
    java.util.Properties p_PEPPER;
    p_PEPPER = new java.util.Properties();
    java.util.Properties p_PEPINC;
    p_PEPINC = new java.util.Properties();
    java.util.Properties p_PEPTICKET;
    p_PEPTICKET = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPCOG".equalsIgnoreCase(key)) {
        p_PEPCOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPNOM".equalsIgnoreCase(key)) {
        p_PEPNOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPNAS".equalsIgnoreCase(key)) {
        p_PEPNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPMOR".equalsIgnoreCase(key)) {
        p_PEPMOR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPCAT".equalsIgnoreCase(key)) {
        p_PEPCAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPLNAS".equalsIgnoreCase(key)) {
        p_PEPLNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPPNAS".equalsIgnoreCase(key)) {
        p_PEPPNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPPER".equalsIgnoreCase(key)) {
        p_PEPPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPINC".equalsIgnoreCase(key)) {
        p_PEPINC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPTICKET".equalsIgnoreCase(key)) {
        p_PEPTICKET = CPLib.GetProperties(p.getProperty(key));
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
      row.PEPCOG = CPLib.GetProperty(p_PEPCOG,"","",i);
      row.PEPNOM = CPLib.GetProperty(p_PEPNOM,"","",i);
      row.PEPNAS = CPLib.GetProperty(p_PEPNAS,"",CPLib.NullDate(),i);
      row.PEPMOR = CPLib.GetProperty(p_PEPMOR,"",CPLib.NullDate(),i);
      row.PEPCAT = CPLib.GetProperty(p_PEPCAT,"","",i);
      row.PEPLNAS = CPLib.GetProperty(p_PEPLNAS,"","",i);
      row.PEPPNAS = CPLib.GetProperty(p_PEPPNAS,"","",i);
      row.PEPPER = CPLib.GetProperty(p_PEPPER,"",0,i);
      row.PEPINC = CPLib.GetProperty(p_PEPINC,"","",i);
      row.PEPTICKET = CPLib.GetProperty(p_PEPTICKET,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcpepstructure_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcpepstructure_mcrdef();
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
  public MemoryCursorRow_mcpepstructure_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcpepstructure_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcpepstructure_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    MemoryCursorRow_mcpepstructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpepstructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcpepstructure_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcpepstructure_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
