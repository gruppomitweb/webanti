// Definition generated from table tbesielb
public class MemoryCursor_tbesielb extends CPMemoryCursor {
  MemoryCursorRow_tbesielb row;
  MemoryCursorRow_tbesielb empty_row;
  public MemoryCursor_tbesielb() {
    empty_row = new MemoryCursorRow_tbesielb();
    row = empty_row;
  }
  public MemoryCursor_tbesielb(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_EECODICE;
    p_EECODICE = new java.util.Properties();
    java.util.Properties p_EEDESCRI;
    p_EEDESCRI = new java.util.Properties();
    java.util.Properties p_EEAZIONE;
    p_EEAZIONE = new java.util.Properties();
    java.util.Properties p_EECOMMEN;
    p_EECOMMEN = new java.util.Properties();
    java.util.Properties p_EELETINI;
    p_EELETINI = new java.util.Properties();
    java.util.Properties p_EETIPESI;
    p_EETIPESI = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EECODICE".equalsIgnoreCase(key)) {
        p_EECODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EEDESCRI".equalsIgnoreCase(key)) {
        p_EEDESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EEAZIONE".equalsIgnoreCase(key)) {
        p_EEAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EECOMMEN".equalsIgnoreCase(key)) {
        p_EECOMMEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EELETINI".equalsIgnoreCase(key)) {
        p_EELETINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EETIPESI".equalsIgnoreCase(key)) {
        p_EETIPESI = CPLib.GetProperties(p.getProperty(key));
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
      row.EECODICE = CPLib.GetProperty(p_EECODICE,"","",i);
      row.EEDESCRI = CPLib.GetProperty(p_EEDESCRI,"","",i);
      row.EEAZIONE = CPLib.GetProperty(p_EEAZIONE,"","",i);
      row.EECOMMEN = CPLib.GetProperty(p_EECOMMEN,"","",i);
      row.EELETINI = CPLib.GetProperty(p_EELETINI,"","",i);
      row.EETIPESI = CPLib.GetProperty(p_EETIPESI,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbesielb)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbesielb();
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
  public MemoryCursorRow_tbesielb _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbesielb _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbesielb> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbesielb p_Row) {
    MemoryCursorRow_tbesielb l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbesielb();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbesielb p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbesielb();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
