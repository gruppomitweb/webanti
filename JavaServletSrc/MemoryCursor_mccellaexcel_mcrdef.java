// Definition generated from record definition mccellaexcel_mcrdef
public class MemoryCursor_mccellaexcel_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccellaexcel_mcrdef row;
  MemoryCursorRow_mccellaexcel_mcrdef empty_row;
  public MemoryCursor_mccellaexcel_mcrdef() {
    empty_row = new MemoryCursorRow_mccellaexcel_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccellaexcel_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_stringa;
    p_stringa = new java.util.Properties();
    java.util.Properties p_numeric;
    p_numeric = new java.util.Properties();
    java.util.Properties p_date;
    p_date = new java.util.Properties();
    java.util.Properties p_datetime;
    p_datetime = new java.util.Properties();
    java.util.Properties p_logic;
    p_logic = new java.util.Properties();
    java.util.Properties p_memo;
    p_memo = new java.util.Properties();
    java.util.Properties p_riga;
    p_riga = new java.util.Properties();
    java.util.Properties p_colonna;
    p_colonna = new java.util.Properties();
    java.util.Properties p_cellType;
    p_cellType = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("stringa".equalsIgnoreCase(key)) {
        p_stringa = CPLib.GetProperties(p.getProperty(key));
      }
      if ("numeric".equalsIgnoreCase(key)) {
        p_numeric = CPLib.GetProperties(p.getProperty(key));
      }
      if ("date".equalsIgnoreCase(key)) {
        p_date = CPLib.GetProperties(p.getProperty(key));
      }
      if ("datetime".equalsIgnoreCase(key)) {
        p_datetime = CPLib.GetProperties(p.getProperty(key));
      }
      if ("logic".equalsIgnoreCase(key)) {
        p_logic = CPLib.GetProperties(p.getProperty(key));
      }
      if ("memo".equalsIgnoreCase(key)) {
        p_memo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("riga".equalsIgnoreCase(key)) {
        p_riga = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna".equalsIgnoreCase(key)) {
        p_colonna = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cellType".equalsIgnoreCase(key)) {
        p_cellType = CPLib.GetProperties(p.getProperty(key));
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
      row.stringa = CPLib.GetProperty(p_stringa,"","",i);
      row.numeric = CPLib.GetProperty(p_numeric,"",0,i);
      row.date = CPLib.GetProperty(p_date,"",CPLib.NullDate(),i);
      row.datetime = CPLib.GetProperty(p_datetime,"",CPLib.NullDateTime(),i);
      row.logic = CPLib.GetProperty(p_logic,"",false,i);
      row.memo = CPLib.GetProperty(p_memo,"","",i);
      row.riga = CPLib.GetProperty(p_riga,"",0,i);
      row.colonna = CPLib.GetProperty(p_colonna,"",0,i);
      row.cellType = CPLib.GetProperty(p_cellType,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccellaexcel_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccellaexcel_mcrdef();
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
  public MemoryCursorRow_mccellaexcel_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccellaexcel_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccellaexcel_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    MemoryCursorRow_mccellaexcel_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccellaexcel_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccellaexcel_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccellaexcel_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
