// Definition generated from table tipo4
public class MemoryCursor_tipo4 extends CPMemoryCursor {
  MemoryCursorRow_tipo4 row;
  MemoryCursorRow_tipo4 empty_row;
  public MemoryCursor_tipo4() {
    empty_row = new MemoryCursorRow_tipo4();
    row = empty_row;
  }
  public MemoryCursor_tipo4(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_C21;
    p_C21 = new java.util.Properties();
    java.util.Properties p_E11;
    p_E11 = new java.util.Properties();
    java.util.Properties p_E13;
    p_E13 = new java.util.Properties();
    java.util.Properties p_E14A;
    p_E14A = new java.util.Properties();
    java.util.Properties p_E14B;
    p_E14B = new java.util.Properties();
    java.util.Properties p_E14C;
    p_E14C = new java.util.Properties();
    java.util.Properties p_E15;
    p_E15 = new java.util.Properties();
    java.util.Properties p_E16;
    p_E16 = new java.util.Properties();
    java.util.Properties p_E17;
    p_E17 = new java.util.Properties();
    java.util.Properties p_E18;
    p_E18 = new java.util.Properties();
    java.util.Properties p_E19;
    p_E19 = new java.util.Properties();
    java.util.Properties p_E41;
    p_E41 = new java.util.Properties();
    java.util.Properties p_E42;
    p_E42 = new java.util.Properties();
    java.util.Properties p_E43;
    p_E43 = new java.util.Properties();
    java.util.Properties p_E44;
    p_E44 = new java.util.Properties();
    java.util.Properties p_E45;
    p_E45 = new java.util.Properties();
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
      if ("C21".equalsIgnoreCase(key)) {
        p_C21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E11".equalsIgnoreCase(key)) {
        p_E11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E13".equalsIgnoreCase(key)) {
        p_E13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E14A".equalsIgnoreCase(key)) {
        p_E14A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E14B".equalsIgnoreCase(key)) {
        p_E14B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E14C".equalsIgnoreCase(key)) {
        p_E14C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E15".equalsIgnoreCase(key)) {
        p_E15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E16".equalsIgnoreCase(key)) {
        p_E16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E17".equalsIgnoreCase(key)) {
        p_E17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E18".equalsIgnoreCase(key)) {
        p_E18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E19".equalsIgnoreCase(key)) {
        p_E19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E41".equalsIgnoreCase(key)) {
        p_E41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E42".equalsIgnoreCase(key)) {
        p_E42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E43".equalsIgnoreCase(key)) {
        p_E43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E44".equalsIgnoreCase(key)) {
        p_E44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("E45".equalsIgnoreCase(key)) {
        p_E45 = CPLib.GetProperties(p.getProperty(key));
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
      row.C21 = CPLib.GetProperty(p_C21,"","",i);
      row.E11 = CPLib.GetProperty(p_E11,"","",i);
      row.E13 = CPLib.GetProperty(p_E13,"","",i);
      row.E14A = CPLib.GetProperty(p_E14A,"","",i);
      row.E14B = CPLib.GetProperty(p_E14B,"","",i);
      row.E14C = CPLib.GetProperty(p_E14C,"","",i);
      row.E15 = CPLib.GetProperty(p_E15,"","",i);
      row.E16 = CPLib.GetProperty(p_E16,"","",i);
      row.E17 = CPLib.GetProperty(p_E17,"","",i);
      row.E18 = CPLib.GetProperty(p_E18,"",CPLib.NullDate(),i);
      row.E19 = CPLib.GetProperty(p_E19,"","",i);
      row.E41 = CPLib.GetProperty(p_E41,"","",i);
      row.E42 = CPLib.GetProperty(p_E42,"","",i);
      row.E43 = CPLib.GetProperty(p_E43,"",CPLib.NullDate(),i);
      row.E44 = CPLib.GetProperty(p_E44,"","",i);
      row.E45 = CPLib.GetProperty(p_E45,"","",i);
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
    row = (MemoryCursorRow_tipo4)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo4();
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
  public MemoryCursorRow_tipo4 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo4 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo4> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo4 p_Row) {
    MemoryCursorRow_tipo4 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo4();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo4 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo4();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
