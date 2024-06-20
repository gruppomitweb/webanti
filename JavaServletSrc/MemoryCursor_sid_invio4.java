// Definition generated from table sid_invio4
public class MemoryCursor_sid_invio4 extends CPMemoryCursor {
  MemoryCursorRow_sid_invio4 row;
  MemoryCursorRow_sid_invio4 empty_row;
  public MemoryCursor_sid_invio4() {
    empty_row = new MemoryCursorRow_sid_invio4();
    row = empty_row;
  }
  public MemoryCursor_sid_invio4(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINVIO4;
    p_CODINVIO4 = new java.util.Properties();
    java.util.Properties p_RAPINVIO4;
    p_RAPINVIO4 = new java.util.Properties();
    java.util.Properties p_NRPINVIO4;
    p_NRPINVIO4 = new java.util.Properties();
    java.util.Properties p_IDEINVIO4;
    p_IDEINVIO4 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINVIO4".equalsIgnoreCase(key)) {
        p_CODINVIO4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPINVIO4".equalsIgnoreCase(key)) {
        p_RAPINVIO4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NRPINVIO4".equalsIgnoreCase(key)) {
        p_NRPINVIO4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDEINVIO4".equalsIgnoreCase(key)) {
        p_IDEINVIO4 = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINVIO4 = CPLib.GetProperty(p_CODINVIO4,"","",i);
      row.RAPINVIO4 = CPLib.GetProperty(p_RAPINVIO4,"","",i);
      row.NRPINVIO4 = CPLib.GetProperty(p_NRPINVIO4,"","",i);
      row.IDEINVIO4 = CPLib.GetProperty(p_IDEINVIO4,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sid_invio4)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sid_invio4();
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
  public MemoryCursorRow_sid_invio4 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sid_invio4 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sid_invio4> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sid_invio4 p_Row) {
    MemoryCursorRow_sid_invio4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio4();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sid_invio4 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sid_invio4();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
