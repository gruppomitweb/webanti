// Definition generated from table tipo5
public class MemoryCursor_tipo5 extends CPMemoryCursor {
  MemoryCursorRow_tipo5 row;
  MemoryCursorRow_tipo5 empty_row;
  public MemoryCursor_tipo5() {
    empty_row = new MemoryCursorRow_tipo5();
    row = empty_row;
  }
  public MemoryCursor_tipo5(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_A01A;
    p_A01A = new java.util.Properties();
    java.util.Properties p_A01B;
    p_A01B = new java.util.Properties();
    java.util.Properties p_A02;
    p_A02 = new java.util.Properties();
    java.util.Properties p_A03;
    p_A03 = new java.util.Properties();
    java.util.Properties p_C31;
    p_C31 = new java.util.Properties();
    java.util.Properties p_F11;
    p_F11 = new java.util.Properties();
    java.util.Properties p_F13;
    p_F13 = new java.util.Properties();
    java.util.Properties p_F14A;
    p_F14A = new java.util.Properties();
    java.util.Properties p_F14B;
    p_F14B = new java.util.Properties();
    java.util.Properties p_F14C;
    p_F14C = new java.util.Properties();
    java.util.Properties p_F15;
    p_F15 = new java.util.Properties();
    java.util.Properties p_F16;
    p_F16 = new java.util.Properties();
    java.util.Properties p_F31;
    p_F31 = new java.util.Properties();
    java.util.Properties p_PROG;
    p_PROG = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A01A".equalsIgnoreCase(key)) {
        p_A01A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A01B".equalsIgnoreCase(key)) {
        p_A01B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A02".equalsIgnoreCase(key)) {
        p_A02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A03".equalsIgnoreCase(key)) {
        p_A03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C31".equalsIgnoreCase(key)) {
        p_C31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F11".equalsIgnoreCase(key)) {
        p_F11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F13".equalsIgnoreCase(key)) {
        p_F13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F14A".equalsIgnoreCase(key)) {
        p_F14A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F14B".equalsIgnoreCase(key)) {
        p_F14B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F14C".equalsIgnoreCase(key)) {
        p_F14C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F15".equalsIgnoreCase(key)) {
        p_F15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F16".equalsIgnoreCase(key)) {
        p_F16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("F31".equalsIgnoreCase(key)) {
        p_F31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROG".equalsIgnoreCase(key)) {
        p_PROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
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
      row.A01A = CPLib.GetProperty(p_A01A,"","",i);
      row.A01B = CPLib.GetProperty(p_A01B,"","",i);
      row.A02 = CPLib.GetProperty(p_A02,"","",i);
      row.A03 = CPLib.GetProperty(p_A03,"","",i);
      row.C31 = CPLib.GetProperty(p_C31,"","",i);
      row.F11 = CPLib.GetProperty(p_F11,"","",i);
      row.F13 = CPLib.GetProperty(p_F13,"","",i);
      row.F14A = CPLib.GetProperty(p_F14A,"","",i);
      row.F14B = CPLib.GetProperty(p_F14B,"","",i);
      row.F14C = CPLib.GetProperty(p_F14C,"","",i);
      row.F15 = CPLib.GetProperty(p_F15,"","",i);
      row.F16 = CPLib.GetProperty(p_F16,"","",i);
      row.F31 = CPLib.GetProperty(p_F31,"","",i);
      row.PROG = CPLib.GetProperty(p_PROG,"",0,i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tipo5)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo5();
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
  public MemoryCursorRow_tipo5 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo5 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo5> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo5 p_Row) {
    MemoryCursorRow_tipo5 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo5();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo5 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo5();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
