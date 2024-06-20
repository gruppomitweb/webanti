// Definition generated from record definition mcsaldiopx_mcrdef
public class MemoryCursor_mcsaldiopx_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcsaldiopx_mcrdef row;
  MemoryCursorRow_mcsaldiopx_mcrdef empty_row;
  public MemoryCursor_mcsaldiopx_mcrdef() {
    empty_row = new MemoryCursorRow_mcsaldiopx_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcsaldiopx_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_IDFILE;
    p_IDFILE = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_MACODICE;
    p_MACODICE = new java.util.Properties();
    java.util.Properties p_MAFLGNOX;
    p_MAFLGNOX = new java.util.Properties();
    java.util.Properties p_COLLEG;
    p_COLLEG = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILE".equalsIgnoreCase(key)) {
        p_IDFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACODICE".equalsIgnoreCase(key)) {
        p_MACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGNOX".equalsIgnoreCase(key)) {
        p_MAFLGNOX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COLLEG".equalsIgnoreCase(key)) {
        p_COLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
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
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.IDFILE = CPLib.GetProperty(p_IDFILE,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.MACODICE = CPLib.GetProperty(p_MACODICE,"","",i);
      row.MAFLGNOX = CPLib.GetProperty(p_MAFLGNOX,"","",i);
      row.COLLEG = CPLib.GetProperty(p_COLLEG,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcsaldiopx_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcsaldiopx_mcrdef();
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
  public MemoryCursorRow_mcsaldiopx_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcsaldiopx_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcsaldiopx_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    MemoryCursorRow_mcsaldiopx_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldiopx_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcsaldiopx_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcsaldiopx_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
