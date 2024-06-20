// Definition generated from table tipo2_3
public class MemoryCursor_tipo2_3 extends CPMemoryCursor {
  MemoryCursorRow_tipo2_3 row;
  MemoryCursorRow_tipo2_3 empty_row;
  public MemoryCursor_tipo2_3() {
    empty_row = new MemoryCursorRow_tipo2_3();
    row = empty_row;
  }
  public MemoryCursor_tipo2_3(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_C11;
    p_C11 = new java.util.Properties();
    java.util.Properties p_D11;
    p_D11 = new java.util.Properties();
    java.util.Properties p_D13;
    p_D13 = new java.util.Properties();
    java.util.Properties p_D14A;
    p_D14A = new java.util.Properties();
    java.util.Properties p_D14B;
    p_D14B = new java.util.Properties();
    java.util.Properties p_D14C;
    p_D14C = new java.util.Properties();
    java.util.Properties p_D15;
    p_D15 = new java.util.Properties();
    java.util.Properties p_D16;
    p_D16 = new java.util.Properties();
    java.util.Properties p_D17;
    p_D17 = new java.util.Properties();
    java.util.Properties p_D18;
    p_D18 = new java.util.Properties();
    java.util.Properties p_D19;
    p_D19 = new java.util.Properties();
    java.util.Properties p_D21;
    p_D21 = new java.util.Properties();
    java.util.Properties p_D22;
    p_D22 = new java.util.Properties();
    java.util.Properties p_D23;
    p_D23 = new java.util.Properties();
    java.util.Properties p_D31;
    p_D31 = new java.util.Properties();
    java.util.Properties p_D32;
    p_D32 = new java.util.Properties();
    java.util.Properties p_D41;
    p_D41 = new java.util.Properties();
    java.util.Properties p_D42;
    p_D42 = new java.util.Properties();
    java.util.Properties p_D43;
    p_D43 = new java.util.Properties();
    java.util.Properties p_D44;
    p_D44 = new java.util.Properties();
    java.util.Properties p_D45;
    p_D45 = new java.util.Properties();
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
      if ("C11".equalsIgnoreCase(key)) {
        p_C11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D11".equalsIgnoreCase(key)) {
        p_D11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D13".equalsIgnoreCase(key)) {
        p_D13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D14A".equalsIgnoreCase(key)) {
        p_D14A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D14B".equalsIgnoreCase(key)) {
        p_D14B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D14C".equalsIgnoreCase(key)) {
        p_D14C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D15".equalsIgnoreCase(key)) {
        p_D15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D16".equalsIgnoreCase(key)) {
        p_D16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D17".equalsIgnoreCase(key)) {
        p_D17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D18".equalsIgnoreCase(key)) {
        p_D18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D19".equalsIgnoreCase(key)) {
        p_D19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D21".equalsIgnoreCase(key)) {
        p_D21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D22".equalsIgnoreCase(key)) {
        p_D22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D23".equalsIgnoreCase(key)) {
        p_D23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D31".equalsIgnoreCase(key)) {
        p_D31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D32".equalsIgnoreCase(key)) {
        p_D32 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D41".equalsIgnoreCase(key)) {
        p_D41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D42".equalsIgnoreCase(key)) {
        p_D42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D43".equalsIgnoreCase(key)) {
        p_D43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D44".equalsIgnoreCase(key)) {
        p_D44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("D45".equalsIgnoreCase(key)) {
        p_D45 = CPLib.GetProperties(p.getProperty(key));
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
      row.C11 = CPLib.GetProperty(p_C11,"","",i);
      row.D11 = CPLib.GetProperty(p_D11,"","",i);
      row.D13 = CPLib.GetProperty(p_D13,"","",i);
      row.D14A = CPLib.GetProperty(p_D14A,"","",i);
      row.D14B = CPLib.GetProperty(p_D14B,"","",i);
      row.D14C = CPLib.GetProperty(p_D14C,"","",i);
      row.D15 = CPLib.GetProperty(p_D15,"","",i);
      row.D16 = CPLib.GetProperty(p_D16,"","",i);
      row.D17 = CPLib.GetProperty(p_D17,"","",i);
      row.D18 = CPLib.GetProperty(p_D18,"",CPLib.NullDate(),i);
      row.D19 = CPLib.GetProperty(p_D19,"","",i);
      row.D21 = CPLib.GetProperty(p_D21,"","",i);
      row.D22 = CPLib.GetProperty(p_D22,"","",i);
      row.D23 = CPLib.GetProperty(p_D23,"","",i);
      row.D31 = CPLib.GetProperty(p_D31,"","",i);
      row.D32 = CPLib.GetProperty(p_D32,"","",i);
      row.D41 = CPLib.GetProperty(p_D41,"","",i);
      row.D42 = CPLib.GetProperty(p_D42,"","",i);
      row.D43 = CPLib.GetProperty(p_D43,"",CPLib.NullDate(),i);
      row.D44 = CPLib.GetProperty(p_D44,"","",i);
      row.D45 = CPLib.GetProperty(p_D45,"","",i);
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
    row = (MemoryCursorRow_tipo2_3)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo2_3();
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
  public MemoryCursorRow_tipo2_3 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo2_3 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo2_3> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo2_3 p_Row) {
    MemoryCursorRow_tipo2_3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo2_3();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo2_3 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo2_3();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
