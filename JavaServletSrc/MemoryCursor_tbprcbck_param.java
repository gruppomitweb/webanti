// Definition generated from table tbprcbck_param
public class MemoryCursor_tbprcbck_param extends CPMemoryCursor {
  MemoryCursorRow_tbprcbck_param row;
  MemoryCursorRow_tbprcbck_param empty_row;
  public MemoryCursor_tbprcbck_param() {
    empty_row = new MemoryCursorRow_tbprcbck_param();
    row = empty_row;
  }
  public MemoryCursor_tbprcbck_param(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_PPCODICE;
    p_PPCODICE = new java.util.Properties();
    java.util.Properties p_CPROWNUM;
    p_CPROWNUM = new java.util.Properties();
    java.util.Properties p_PPDESCRI;
    p_PPDESCRI = new java.util.Properties();
    java.util.Properties p_PPTIPPAR;
    p_PPTIPPAR = new java.util.Properties();
    java.util.Properties p_PPVALPAR;
    p_PPVALPAR = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PPCODICE".equalsIgnoreCase(key)) {
        p_PPCODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CPROWNUM".equalsIgnoreCase(key)) {
        p_CPROWNUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PPDESCRI".equalsIgnoreCase(key)) {
        p_PPDESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PPTIPPAR".equalsIgnoreCase(key)) {
        p_PPTIPPAR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PPVALPAR".equalsIgnoreCase(key)) {
        p_PPVALPAR = CPLib.GetProperties(p.getProperty(key));
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
      row.PPCODICE = CPLib.GetProperty(p_PPCODICE,"",0,i);
      row.CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",0,i);
      row.PPDESCRI = CPLib.GetProperty(p_PPDESCRI,"","",i);
      row.PPTIPPAR = CPLib.GetProperty(p_PPTIPPAR,"","",i);
      row.PPVALPAR = CPLib.GetProperty(p_PPVALPAR,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbprcbck_param)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbprcbck_param();
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
  public MemoryCursorRow_tbprcbck_param _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbprcbck_param _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbprcbck_param> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbprcbck_param p_Row) {
    MemoryCursorRow_tbprcbck_param l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbprcbck_param();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbprcbck_param p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbprcbck_param();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
