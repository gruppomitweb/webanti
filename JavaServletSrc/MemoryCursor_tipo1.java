// Definition generated from table tipo1
public class MemoryCursor_tipo1 extends CPMemoryCursor {
  MemoryCursorRow_tipo1 row;
  MemoryCursorRow_tipo1 empty_row;
  public MemoryCursor_tipo1() {
    empty_row = new MemoryCursorRow_tipo1();
    row = empty_row;
  }
  public MemoryCursor_tipo1(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_A11;
    p_A11 = new java.util.Properties();
    java.util.Properties p_A12A;
    p_A12A = new java.util.Properties();
    java.util.Properties p_A12B;
    p_A12B = new java.util.Properties();
    java.util.Properties p_A12C;
    p_A12C = new java.util.Properties();
    java.util.Properties p_A21;
    p_A21 = new java.util.Properties();
    java.util.Properties p_A22;
    p_A22 = new java.util.Properties();
    java.util.Properties p_A23;
    p_A23 = new java.util.Properties();
    java.util.Properties p_A24;
    p_A24 = new java.util.Properties();
    java.util.Properties p_A25;
    p_A25 = new java.util.Properties();
    java.util.Properties p_A31A;
    p_A31A = new java.util.Properties();
    java.util.Properties p_A31B;
    p_A31B = new java.util.Properties();
    java.util.Properties p_A32;
    p_A32 = new java.util.Properties();
    java.util.Properties p_A33A;
    p_A33A = new java.util.Properties();
    java.util.Properties p_A33B;
    p_A33B = new java.util.Properties();
    java.util.Properties p_A33C;
    p_A33C = new java.util.Properties();
    java.util.Properties p_A34;
    p_A34 = new java.util.Properties();
    java.util.Properties p_A41;
    p_A41 = new java.util.Properties();
    java.util.Properties p_A42;
    p_A42 = new java.util.Properties();
    java.util.Properties p_A43;
    p_A43 = new java.util.Properties();
    java.util.Properties p_A51;
    p_A51 = new java.util.Properties();
    java.util.Properties p_A52;
    p_A52 = new java.util.Properties();
    java.util.Properties p_A53;
    p_A53 = new java.util.Properties();
    java.util.Properties p_A54A;
    p_A54A = new java.util.Properties();
    java.util.Properties p_A54B;
    p_A54B = new java.util.Properties();
    java.util.Properties p_A54C;
    p_A54C = new java.util.Properties();
    java.util.Properties p_B11;
    p_B11 = new java.util.Properties();
    java.util.Properties p_B12;
    p_B12 = new java.util.Properties();
    java.util.Properties p_B13;
    p_B13 = new java.util.Properties();
    java.util.Properties p_B14;
    p_B14 = new java.util.Properties();
    java.util.Properties p_B15;
    p_B15 = new java.util.Properties();
    java.util.Properties p_PROG;
    p_PROG = new java.util.Properties();
    java.util.Properties p_TMOV;
    p_TMOV = new java.util.Properties();
    java.util.Properties p_PRGANTI;
    p_PRGANTI = new java.util.Properties();
    java.util.Properties p_FONTE;
    p_FONTE = new java.util.Properties();
    java.util.Properties p_A52L;
    p_A52L = new java.util.Properties();
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
      if ("A11".equalsIgnoreCase(key)) {
        p_A11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A12A".equalsIgnoreCase(key)) {
        p_A12A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A12B".equalsIgnoreCase(key)) {
        p_A12B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A12C".equalsIgnoreCase(key)) {
        p_A12C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A21".equalsIgnoreCase(key)) {
        p_A21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A22".equalsIgnoreCase(key)) {
        p_A22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A23".equalsIgnoreCase(key)) {
        p_A23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A24".equalsIgnoreCase(key)) {
        p_A24 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A25".equalsIgnoreCase(key)) {
        p_A25 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A31A".equalsIgnoreCase(key)) {
        p_A31A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A31B".equalsIgnoreCase(key)) {
        p_A31B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A32".equalsIgnoreCase(key)) {
        p_A32 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A33A".equalsIgnoreCase(key)) {
        p_A33A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A33B".equalsIgnoreCase(key)) {
        p_A33B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A33C".equalsIgnoreCase(key)) {
        p_A33C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A34".equalsIgnoreCase(key)) {
        p_A34 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A41".equalsIgnoreCase(key)) {
        p_A41 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A42".equalsIgnoreCase(key)) {
        p_A42 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A43".equalsIgnoreCase(key)) {
        p_A43 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A51".equalsIgnoreCase(key)) {
        p_A51 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A52".equalsIgnoreCase(key)) {
        p_A52 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A53".equalsIgnoreCase(key)) {
        p_A53 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A54A".equalsIgnoreCase(key)) {
        p_A54A = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A54B".equalsIgnoreCase(key)) {
        p_A54B = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A54C".equalsIgnoreCase(key)) {
        p_A54C = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B11".equalsIgnoreCase(key)) {
        p_B11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B12".equalsIgnoreCase(key)) {
        p_B12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B13".equalsIgnoreCase(key)) {
        p_B13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B14".equalsIgnoreCase(key)) {
        p_B14 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B15".equalsIgnoreCase(key)) {
        p_B15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROG".equalsIgnoreCase(key)) {
        p_PROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TMOV".equalsIgnoreCase(key)) {
        p_TMOV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRGANTI".equalsIgnoreCase(key)) {
        p_PRGANTI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FONTE".equalsIgnoreCase(key)) {
        p_FONTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("A52L".equalsIgnoreCase(key)) {
        p_A52L = CPLib.GetProperties(p.getProperty(key));
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
      row.A11 = CPLib.GetProperty(p_A11,"","",i);
      row.A12A = CPLib.GetProperty(p_A12A,"","",i);
      row.A12B = CPLib.GetProperty(p_A12B,"","",i);
      row.A12C = CPLib.GetProperty(p_A12C,"","",i);
      row.A21 = CPLib.GetProperty(p_A21,"",CPLib.NullDate(),i);
      row.A22 = CPLib.GetProperty(p_A22,"","",i);
      row.A23 = CPLib.GetProperty(p_A23,"","",i);
      row.A24 = CPLib.GetProperty(p_A24,"","",i);
      row.A25 = CPLib.GetProperty(p_A25,"","",i);
      row.A31A = CPLib.GetProperty(p_A31A,"","",i);
      row.A31B = CPLib.GetProperty(p_A31B,"","",i);
      row.A32 = CPLib.GetProperty(p_A32,"","",i);
      row.A33A = CPLib.GetProperty(p_A33A,"","",i);
      row.A33B = CPLib.GetProperty(p_A33B,"","",i);
      row.A33C = CPLib.GetProperty(p_A33C,"","",i);
      row.A34 = CPLib.GetProperty(p_A34,"","",i);
      row.A41 = CPLib.GetProperty(p_A41,"","",i);
      row.A42 = CPLib.GetProperty(p_A42,"","",i);
      row.A43 = CPLib.GetProperty(p_A43,"","",i);
      row.A51 = CPLib.GetProperty(p_A51,"",CPLib.NullDate(),i);
      row.A52 = CPLib.GetProperty(p_A52,"","",i);
      row.A53 = CPLib.GetProperty(p_A53,"","",i);
      row.A54A = CPLib.GetProperty(p_A54A,"","",i);
      row.A54B = CPLib.GetProperty(p_A54B,"",CPLib.NullDate(),i);
      row.A54C = CPLib.GetProperty(p_A54C,"","",i);
      row.B11 = CPLib.GetProperty(p_B11,"","",i);
      row.B12 = CPLib.GetProperty(p_B12,"","",i);
      row.B13 = CPLib.GetProperty(p_B13,"","",i);
      row.B14 = CPLib.GetProperty(p_B14,"",0,i);
      row.B15 = CPLib.GetProperty(p_B15,"",0,i);
      row.PROG = CPLib.GetProperty(p_PROG,"",0,i);
      row.TMOV = CPLib.GetProperty(p_TMOV,"","",i);
      row.PRGANTI = CPLib.GetProperty(p_PRGANTI,"","",i);
      row.FONTE = CPLib.GetProperty(p_FONTE,"","",i);
      row.A52L = CPLib.GetProperty(p_A52L,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tipo1)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tipo1();
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
  public MemoryCursorRow_tipo1 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tipo1 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tipo1> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tipo1 p_Row) {
    MemoryCursorRow_tipo1 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tipo1();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tipo1 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tipo1();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
