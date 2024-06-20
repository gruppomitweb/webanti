// Definition generated from table tmp_cgo_crtc
public class MemoryCursor_tmp_cgo_crtc extends CPMemoryCursor {
  MemoryCursorRow_tmp_cgo_crtc row;
  MemoryCursorRow_tmp_cgo_crtc empty_row;
  public MemoryCursor_tmp_cgo_crtc() {
    empty_row = new MemoryCursorRow_tmp_cgo_crtc();
    row = empty_row;
  }
  public MemoryCursor_tmp_cgo_crtc(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODDIP;
    p_CODDIP = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_FLGCRTC;
    p_FLGCRTC = new java.util.Properties();
    java.util.Properties p_NUMDAYS;
    p_NUMDAYS = new java.util.Properties();
    java.util.Properties p_TIPCRTC;
    p_TIPCRTC = new java.util.Properties();
    java.util.Properties p_DESCDIP;
    p_DESCDIP = new java.util.Properties();
    java.util.Properties p_CITDIP;
    p_CITDIP = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIP".equalsIgnoreCase(key)) {
        p_CODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGCRTC".equalsIgnoreCase(key)) {
        p_FLGCRTC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDAYS".equalsIgnoreCase(key)) {
        p_NUMDAYS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPCRTC".equalsIgnoreCase(key)) {
        p_TIPCRTC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCDIP".equalsIgnoreCase(key)) {
        p_DESCDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CITDIP".equalsIgnoreCase(key)) {
        p_CITDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
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
      row.CODDIP = CPLib.GetProperty(p_CODDIP,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.FLGCRTC = CPLib.GetProperty(p_FLGCRTC,"","",i);
      row.NUMDAYS = CPLib.GetProperty(p_NUMDAYS,"",0,i);
      row.TIPCRTC = CPLib.GetProperty(p_TIPCRTC,"","",i);
      row.DESCDIP = CPLib.GetProperty(p_DESCDIP,"","",i);
      row.CITDIP = CPLib.GetProperty(p_CITDIP,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_cgo_crtc)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_cgo_crtc();
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
  public MemoryCursorRow_tmp_cgo_crtc _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_cgo_crtc _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_cgo_crtc> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_cgo_crtc p_Row) {
    MemoryCursorRow_tmp_cgo_crtc l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_cgo_crtc();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_cgo_crtc p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_cgo_crtc();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
