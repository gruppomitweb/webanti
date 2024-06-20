// Definition generated from table tipo9
public class MemoryCursor_tipo9 extends CPMemoryCursor {
  MemoryCursorRow_tipo9 row;
  MemoryCursorRow_tipo9 empty_row;
  public MemoryCursor_tipo9() {
    empty_row = new MemoryCursorRow_tipo9();
    row = empty_row;
  }
  public MemoryCursor_tipo9(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_C51;
    p_C51 = new java.util.Properties();
    java.util.Properties p_H11;
    p_H11 = new java.util.Properties();
    java.util.Properties p_H13;
    p_H13 = new java.util.Properties();
    java.util.Properties p_H14A;
    p_H14A = new java.util.Properties();
    java.util.Properties p_H14B;
    p_H14B = new java.util.Properties();
    java.util.Properties p_H14C;
    p_H14C = new java.util.Properties();
    java.util.Properties p_H15;
    p_H15 = new java.util.Properties();
    java.util.Properties p_H16;
    p_H16 = new java.util.Properties();
    java.util.Properties p_H17;
    p_H17 = new java.util.Properties();
    java.util.Properties p_H18;
    p_H18 = new java.util.Properties();
    java.util.Properties p_H19;
    p_H19 = new java.util.Properties();
    java.util.Properties p_H41;
    p_H41 = new java.util.Properties();
    java.util.Properties p_H42;
    p_H42 = new java.util.Properties();
    java.util.Properties p_H43;
    p_H43 = new java.util.Properties();
    java.util.Properties p_H44;
    p_H44 = new java.util.Properties();
    java.util.Properties p_H45;
    p_H45 = new java.util.Properties();
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
      if ("C51".equalsIgnoreCase(key)) {
        p_C51 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H11".equalsIgnoreCase(key)) {
        p_H11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H13".equalsIgnoreCase(key)) {
        p_H13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H14A".equalsIgnoreCase(key)) {
        p_H14A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H14B".equalsIgnoreCase(key)) {
        p_H14B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H14C".equalsIgnoreCase(key)) {
        p_H14C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H15".equalsIgnoreCase(key)) {
        p_H15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H16".equalsIgnoreCase(key)) {
        p_H16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H17".equalsIgnoreCase(key)) {
        p_H17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H18".equalsIgnoreCase(key)) {
        p_H18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H19".equalsIgnoreCase(key)) {
        p_H19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H41".equalsIgnoreCase(key)) {
        p_H41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H42".equalsIgnoreCase(key)) {
        p_H42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H43".equalsIgnoreCase(key)) {
        p_H43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H44".equalsIgnoreCase(key)) {
        p_H44 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("H45".equalsIgnoreCase(key)) {
        p_H45 = CPLib.GetProperties(p.getProperty(key));
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
      row.C51 = CPLib.GetProperty(p_C51,"","",i);
      row.H11 = CPLib.GetProperty(p_H11,"","",i);
      row.H13 = CPLib.GetProperty(p_H13,"","",i);
      row.H14A = CPLib.GetProperty(p_H14A,"","",i);
      row.H14B = CPLib.GetProperty(p_H14B,"","",i);
      row.H14C = CPLib.GetProperty(p_H14C,"","",i);
      row.H15 = CPLib.GetProperty(p_H15,"","",i);
      row.H16 = CPLib.GetProperty(p_H16,"","",i);
      row.H17 = CPLib.GetProperty(p_H17,"","",i);
      row.H18 = CPLib.GetProperty(p_H18,"",CPLib.NullDate(),i);
      row.H19 = CPLib.GetProperty(p_H19,"","",i);
      row.H41 = CPLib.GetProperty(p_H41,"","",i);
      row.H42 = CPLib.GetProperty(p_H42,"","",i);
      row.H43 = CPLib.GetProperty(p_H43,"",CPLib.NullDate(),i);
      row.H44 = CPLib.GetProperty(p_H44,"","",i);
      row.H45 = CPLib.GetProperty(p_H45,"","",i);
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
    row = (MemoryCursorRow_tipo9)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo9();
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
  public MemoryCursorRow_tipo9 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo9 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo9> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo9 p_Row) {
    MemoryCursorRow_tipo9 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo9();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo9 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo9();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
