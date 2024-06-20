// Definition generated from record definition mccorpo_oam_mcrdef
public class MemoryCursor_mccorpo_oam_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccorpo_oam_mcrdef row;
  MemoryCursorRow_mccorpo_oam_mcrdef empty_row;
  public MemoryCursor_mccorpo_oam_mcrdef() {
    empty_row = new MemoryCursorRow_mccorpo_oam_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccorpo_oam_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_B01;
    p_B01 = new java.util.Properties();
    java.util.Properties p_B02;
    p_B02 = new java.util.Properties();
    java.util.Properties p_B03;
    p_B03 = new java.util.Properties();
    java.util.Properties p_B04;
    p_B04 = new java.util.Properties();
    java.util.Properties p_B05;
    p_B05 = new java.util.Properties();
    java.util.Properties p_B06;
    p_B06 = new java.util.Properties();
    java.util.Properties p_B07;
    p_B07 = new java.util.Properties();
    java.util.Properties p_B08;
    p_B08 = new java.util.Properties();
    java.util.Properties p_B09;
    p_B09 = new java.util.Properties();
    java.util.Properties p_B10;
    p_B10 = new java.util.Properties();
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
    java.util.Properties p_B16;
    p_B16 = new java.util.Properties();
    java.util.Properties p_B17;
    p_B17 = new java.util.Properties();
    java.util.Properties p_B18;
    p_B18 = new java.util.Properties();
    java.util.Properties p_B19;
    p_B19 = new java.util.Properties();
    java.util.Properties p_B20;
    p_B20 = new java.util.Properties();
    java.util.Properties p_B21;
    p_B21 = new java.util.Properties();
    java.util.Properties p_B22;
    p_B22 = new java.util.Properties();
    java.util.Properties p_B23;
    p_B23 = new java.util.Properties();
    java.util.Properties p_B24;
    p_B24 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B01".equalsIgnoreCase(key)) {
        p_B01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B02".equalsIgnoreCase(key)) {
        p_B02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B03".equalsIgnoreCase(key)) {
        p_B03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B04".equalsIgnoreCase(key)) {
        p_B04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B05".equalsIgnoreCase(key)) {
        p_B05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B06".equalsIgnoreCase(key)) {
        p_B06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B07".equalsIgnoreCase(key)) {
        p_B07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B08".equalsIgnoreCase(key)) {
        p_B08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B09".equalsIgnoreCase(key)) {
        p_B09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B10".equalsIgnoreCase(key)) {
        p_B10 = CPLib.GetProperties(p.getProperty(key));
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
      if ("B16".equalsIgnoreCase(key)) {
        p_B16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B17".equalsIgnoreCase(key)) {
        p_B17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B18".equalsIgnoreCase(key)) {
        p_B18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B19".equalsIgnoreCase(key)) {
        p_B19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B20".equalsIgnoreCase(key)) {
        p_B20 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B21".equalsIgnoreCase(key)) {
        p_B21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B22".equalsIgnoreCase(key)) {
        p_B22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B23".equalsIgnoreCase(key)) {
        p_B23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("B24".equalsIgnoreCase(key)) {
        p_B24 = CPLib.GetProperties(p.getProperty(key));
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
      row.B01 = CPLib.GetProperty(p_B01,"","",i);
      row.B02 = CPLib.GetProperty(p_B02,"",0,i);
      row.B03 = CPLib.GetProperty(p_B03,"","",i);
      row.B04 = CPLib.GetProperty(p_B04,"","",i);
      row.B05 = CPLib.GetProperty(p_B05,"","",i);
      row.B06 = CPLib.GetProperty(p_B06,"","",i);
      row.B07 = CPLib.GetProperty(p_B07,"",CPLib.NullDate(),i);
      row.B08 = CPLib.GetProperty(p_B08,"","",i);
      row.B09 = CPLib.GetProperty(p_B09,"","",i);
      row.B10 = CPLib.GetProperty(p_B10,"","",i);
      row.B11 = CPLib.GetProperty(p_B11,"","",i);
      row.B12 = CPLib.GetProperty(p_B12,"","",i);
      row.B13 = CPLib.GetProperty(p_B13,"","",i);
      row.B14 = CPLib.GetProperty(p_B14,"",CPLib.NullDate(),i);
      row.B15 = CPLib.GetProperty(p_B15,"","",i);
      row.B16 = CPLib.GetProperty(p_B16,"","",i);
      row.B17 = CPLib.GetProperty(p_B17,"",CPLib.NullDate(),i);
      row.B18 = CPLib.GetProperty(p_B18,"","",i);
      row.B19 = CPLib.GetProperty(p_B19,"","",i);
      row.B20 = CPLib.GetProperty(p_B20,"","",i);
      row.B21 = CPLib.GetProperty(p_B21,"",0,i);
      row.B22 = CPLib.GetProperty(p_B22,"",0,i);
      row.B23 = CPLib.GetProperty(p_B23,"",0,i);
      row.B24 = CPLib.GetProperty(p_B24,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccorpo_oam_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccorpo_oam_mcrdef();
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
  public MemoryCursorRow_mccorpo_oam_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccorpo_oam_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccorpo_oam_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    MemoryCursorRow_mccorpo_oam_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccorpo_oam_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccorpo_oam_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccorpo_oam_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
