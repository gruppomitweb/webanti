// Definition generated from table tbtipreg
public class MemoryCursor_tbtipreg extends CPMemoryCursor {
  MemoryCursorRow_tbtipreg row;
  MemoryCursorRow_tbtipreg empty_row;
  public MemoryCursor_tbtipreg() {
    empty_row = new MemoryCursorRow_tbtipreg();
    row = empty_row;
  }
  public MemoryCursor_tbtipreg(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODICE;
    p_CODICE = new java.util.Properties();
    java.util.Properties p_DES1;
    p_DES1 = new java.util.Properties();
    java.util.Properties p_DES2;
    p_DES2 = new java.util.Properties();
    java.util.Properties p_TIPREG;
    p_TIPREG = new java.util.Properties();
    java.util.Properties p_OPERAZIO;
    p_OPERAZIO = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
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
      if ("DES1".equalsIgnoreCase(key)) {
        p_DES1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DES2".equalsIgnoreCase(key)) {
        p_DES2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPREG".equalsIgnoreCase(key)) {
        p_TIPREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAZIO".equalsIgnoreCase(key)) {
        p_OPERAZIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
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
      row.DES1 = CPLib.GetProperty(p_DES1,"","",i);
      row.DES2 = CPLib.GetProperty(p_DES2,"","",i);
      row.TIPREG = CPLib.GetProperty(p_TIPREG,"","",i);
      row.OPERAZIO = CPLib.GetProperty(p_OPERAZIO,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbtipreg)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbtipreg();
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
  public MemoryCursorRow_tbtipreg _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbtipreg _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbtipreg> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbtipreg p_Row) {
    MemoryCursorRow_tbtipreg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbtipreg();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbtipreg p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbtipreg();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
