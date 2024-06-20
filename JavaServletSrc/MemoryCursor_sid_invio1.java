// Definition generated from table sid_invio1
public class MemoryCursor_sid_invio1 extends CPMemoryCursor {
  MemoryCursorRow_sid_invio1 row;
  MemoryCursorRow_sid_invio1 empty_row;
  public MemoryCursor_sid_invio1() {
    empty_row = new MemoryCursorRow_sid_invio1();
    row = empty_row;
  }
  public MemoryCursor_sid_invio1(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINVIO1;
    p_CODINVIO1 = new java.util.Properties();
    java.util.Properties p_RAPINVIO1;
    p_RAPINVIO1 = new java.util.Properties();
    java.util.Properties p_TPRINVIO1;
    p_TPRINVIO1 = new java.util.Properties();
    java.util.Properties p_INIINVIO1;
    p_INIINVIO1 = new java.util.Properties();
    java.util.Properties p_FININVIO1;
    p_FININVIO1 = new java.util.Properties();
    java.util.Properties p_CABINVIO1;
    p_CABINVIO1 = new java.util.Properties();
    java.util.Properties p_ESIINVIO1;
    p_ESIINVIO1 = new java.util.Properties();
    java.util.Properties p_TIPINVIO1;
    p_TIPINVIO1 = new java.util.Properties();
    java.util.Properties p_TPCINVIO1;
    p_TPCINVIO1 = new java.util.Properties();
    java.util.Properties p_UNIQUE1;
    p_UNIQUE1 = new java.util.Properties();
    java.util.Properties p_FLGUNQ1;
    p_FLGUNQ1 = new java.util.Properties();
    java.util.Properties p_MODINVIO1;
    p_MODINVIO1 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINVIO1".equalsIgnoreCase(key)) {
        p_CODINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPINVIO1".equalsIgnoreCase(key)) {
        p_RAPINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TPRINVIO1".equalsIgnoreCase(key)) {
        p_TPRINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INIINVIO1".equalsIgnoreCase(key)) {
        p_INIINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FININVIO1".equalsIgnoreCase(key)) {
        p_FININVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABINVIO1".equalsIgnoreCase(key)) {
        p_CABINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ESIINVIO1".equalsIgnoreCase(key)) {
        p_ESIINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINVIO1".equalsIgnoreCase(key)) {
        p_TIPINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TPCINVIO1".equalsIgnoreCase(key)) {
        p_TPCINVIO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUE1".equalsIgnoreCase(key)) {
        p_UNIQUE1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGUNQ1".equalsIgnoreCase(key)) {
        p_FLGUNQ1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MODINVIO1".equalsIgnoreCase(key)) {
        p_MODINVIO1 = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINVIO1 = CPLib.GetProperty(p_CODINVIO1,"","",i);
      row.RAPINVIO1 = CPLib.GetProperty(p_RAPINVIO1,"","",i);
      row.TPRINVIO1 = CPLib.GetProperty(p_TPRINVIO1,"","",i);
      row.INIINVIO1 = CPLib.GetProperty(p_INIINVIO1,"",CPLib.NullDate(),i);
      row.FININVIO1 = CPLib.GetProperty(p_FININVIO1,"",CPLib.NullDate(),i);
      row.CABINVIO1 = CPLib.GetProperty(p_CABINVIO1,"","",i);
      row.ESIINVIO1 = CPLib.GetProperty(p_ESIINVIO1,"","",i);
      row.TIPINVIO1 = CPLib.GetProperty(p_TIPINVIO1,"","",i);
      row.TPCINVIO1 = CPLib.GetProperty(p_TPCINVIO1,"","",i);
      row.UNIQUE1 = CPLib.GetProperty(p_UNIQUE1,"","",i);
      row.FLGUNQ1 = CPLib.GetProperty(p_FLGUNQ1,"","",i);
      row.MODINVIO1 = CPLib.GetProperty(p_MODINVIO1,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sid_invio1)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sid_invio1();
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
  public MemoryCursorRow_sid_invio1 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sid_invio1 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sid_invio1> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sid_invio1 p_Row) {
    MemoryCursorRow_sid_invio1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio1();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sid_invio1 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sid_invio1();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
