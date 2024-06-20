// Definition generated from table sogopebo
public class MemoryCursor_sogopebo extends CPMemoryCursor {
  MemoryCursorRow_sogopebo row;
  MemoryCursorRow_sogopebo empty_row;
  public MemoryCursor_sogopebo() {
    empty_row = new MemoryCursorRow_sogopebo();
    row = empty_row;
  }
  public MemoryCursor_sogopebo(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDFILEBO;
    p_IDFILEBO = new java.util.Properties();
    java.util.Properties p_CPROWNUM;
    p_CPROWNUM = new java.util.Properties();
    java.util.Properties p_CODSOG;
    p_CODSOG = new java.util.Properties();
    java.util.Properties p_LEGAME;
    p_LEGAME = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_NUMCOL;
    p_NUMCOL = new java.util.Properties();
    java.util.Properties p_TIPOFILE;
    p_TIPOFILE = new java.util.Properties();
    java.util.Properties p_RAPCOL;
    p_RAPCOL = new java.util.Properties();
    java.util.Properties p_UCODE;
    p_UCODE = new java.util.Properties();
    java.util.Properties p_NUMIMP;
    p_NUMIMP = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILEBO".equalsIgnoreCase(key)) {
        p_IDFILEBO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CPROWNUM".equalsIgnoreCase(key)) {
        p_CPROWNUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODSOG".equalsIgnoreCase(key)) {
        p_CODSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LEGAME".equalsIgnoreCase(key)) {
        p_LEGAME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMCOL".equalsIgnoreCase(key)) {
        p_NUMCOL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOFILE".equalsIgnoreCase(key)) {
        p_TIPOFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPCOL".equalsIgnoreCase(key)) {
        p_RAPCOL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UCODE".equalsIgnoreCase(key)) {
        p_UCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMIMP".equalsIgnoreCase(key)) {
        p_NUMIMP = CPLib.GetProperties(p.getProperty(key));
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
      row.IDFILEBO = CPLib.GetProperty(p_IDFILEBO,"","",i);
      row.CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",0,i);
      row.CODSOG = CPLib.GetProperty(p_CODSOG,"","",i);
      row.LEGAME = CPLib.GetProperty(p_LEGAME,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.NUMCOL = CPLib.GetProperty(p_NUMCOL,"","",i);
      row.TIPOFILE = CPLib.GetProperty(p_TIPOFILE,"","",i);
      row.RAPCOL = CPLib.GetProperty(p_RAPCOL,"","",i);
      row.UCODE = CPLib.GetProperty(p_UCODE,"","",i);
      row.NUMIMP = CPLib.GetProperty(p_NUMIMP,"",CPLib.NullDateTime(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sogopebo)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sogopebo();
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
  public MemoryCursorRow_sogopebo _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sogopebo _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sogopebo> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sogopebo p_Row) {
    MemoryCursorRow_sogopebo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sogopebo();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sogopebo p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sogopebo();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
