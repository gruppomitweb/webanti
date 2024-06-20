// Definition generated from table tipo6
public class MemoryCursor_tipo6 extends CPMemoryCursor {
  MemoryCursorRow_tipo6 row;
  MemoryCursorRow_tipo6 empty_row;
  public MemoryCursor_tipo6() {
    empty_row = new MemoryCursorRow_tipo6();
    row = empty_row;
  }
  public MemoryCursor_tipo6(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_C41;
    p_C41 = new java.util.Properties();
    java.util.Properties p_G11;
    p_G11 = new java.util.Properties();
    java.util.Properties p_G13;
    p_G13 = new java.util.Properties();
    java.util.Properties p_G14A;
    p_G14A = new java.util.Properties();
    java.util.Properties p_G14B;
    p_G14B = new java.util.Properties();
    java.util.Properties p_G14C;
    p_G14C = new java.util.Properties();
    java.util.Properties p_G15;
    p_G15 = new java.util.Properties();
    java.util.Properties p_G16;
    p_G16 = new java.util.Properties();
    java.util.Properties p_G17;
    p_G17 = new java.util.Properties();
    java.util.Properties p_G18;
    p_G18 = new java.util.Properties();
    java.util.Properties p_G19;
    p_G19 = new java.util.Properties();
    java.util.Properties p_G41;
    p_G41 = new java.util.Properties();
    java.util.Properties p_G42;
    p_G42 = new java.util.Properties();
    java.util.Properties p_G43;
    p_G43 = new java.util.Properties();
    java.util.Properties p_G44;
    p_G44 = new java.util.Properties();
    java.util.Properties p_G45;
    p_G45 = new java.util.Properties();
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
      if ("C41".equalsIgnoreCase(key)) {
        p_C41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G11".equalsIgnoreCase(key)) {
        p_G11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G13".equalsIgnoreCase(key)) {
        p_G13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G14A".equalsIgnoreCase(key)) {
        p_G14A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G14B".equalsIgnoreCase(key)) {
        p_G14B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G14C".equalsIgnoreCase(key)) {
        p_G14C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G15".equalsIgnoreCase(key)) {
        p_G15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G16".equalsIgnoreCase(key)) {
        p_G16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G17".equalsIgnoreCase(key)) {
        p_G17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G18".equalsIgnoreCase(key)) {
        p_G18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G19".equalsIgnoreCase(key)) {
        p_G19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G41".equalsIgnoreCase(key)) {
        p_G41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G42".equalsIgnoreCase(key)) {
        p_G42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G43".equalsIgnoreCase(key)) {
        p_G43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G44".equalsIgnoreCase(key)) {
        p_G44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("G45".equalsIgnoreCase(key)) {
        p_G45 = CPLib.GetProperties(p.getProperty(key));
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
      row.C41 = CPLib.GetProperty(p_C41,"","",i);
      row.G11 = CPLib.GetProperty(p_G11,"","",i);
      row.G13 = CPLib.GetProperty(p_G13,"","",i);
      row.G14A = CPLib.GetProperty(p_G14A,"","",i);
      row.G14B = CPLib.GetProperty(p_G14B,"","",i);
      row.G14C = CPLib.GetProperty(p_G14C,"","",i);
      row.G15 = CPLib.GetProperty(p_G15,"","",i);
      row.G16 = CPLib.GetProperty(p_G16,"","",i);
      row.G17 = CPLib.GetProperty(p_G17,"","",i);
      row.G18 = CPLib.GetProperty(p_G18,"",CPLib.NullDate(),i);
      row.G19 = CPLib.GetProperty(p_G19,"","",i);
      row.G41 = CPLib.GetProperty(p_G41,"","",i);
      row.G42 = CPLib.GetProperty(p_G42,"","",i);
      row.G43 = CPLib.GetProperty(p_G43,"",CPLib.NullDate(),i);
      row.G44 = CPLib.GetProperty(p_G44,"","",i);
      row.G45 = CPLib.GetProperty(p_G45,"","",i);
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
    row = (MemoryCursorRow_tipo6)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo6();
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
  public MemoryCursorRow_tipo6 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo6 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo6> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo6 p_Row) {
    MemoryCursorRow_tipo6 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo6();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo6 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo6();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
