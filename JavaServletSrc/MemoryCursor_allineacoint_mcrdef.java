// Definition generated from record definition allineacoint_mcrdef
public class MemoryCursor_allineacoint_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_allineacoint_mcrdef row;
  MemoryCursorRow_allineacoint_mcrdef empty_row;
  public MemoryCursor_allineacoint_mcrdef() {
    empty_row = new MemoryCursorRow_allineacoint_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_allineacoint_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_SCELTO_new;
    p_SCELTO_new = new java.util.Properties();
    java.util.Properties p_SCELTO_old;
    p_SCELTO_old = new java.util.Properties();
    java.util.Properties p_NEWRAPPORTO_new;
    p_NEWRAPPORTO_new = new java.util.Properties();
    java.util.Properties p_NEWRAPPORTO_OLD;
    p_NEWRAPPORTO_OLD = new java.util.Properties();
    java.util.Properties p_ps_rowstatus;
    p_ps_rowstatus = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SCELTO_new".equalsIgnoreCase(key)) {
        p_SCELTO_new = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SCELTO_old".equalsIgnoreCase(key)) {
        p_SCELTO_old = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NEWRAPPORTO_new".equalsIgnoreCase(key)) {
        p_NEWRAPPORTO_new = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NEWRAPPORTO_OLD".equalsIgnoreCase(key)) {
        p_NEWRAPPORTO_OLD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ps_rowstatus".equalsIgnoreCase(key)) {
        p_ps_rowstatus = CPLib.GetProperties(p.getProperty(key));
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
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.SCELTO_new = CPLib.GetProperty(p_SCELTO_new,"",0,i);
      row.SCELTO_old = CPLib.GetProperty(p_SCELTO_old,"",0,i);
      row.NEWRAPPORTO_new = CPLib.GetProperty(p_NEWRAPPORTO_new,"","",i);
      row.NEWRAPPORTO_OLD = CPLib.GetProperty(p_NEWRAPPORTO_OLD,"","",i);
      row.ps_rowstatus = CPLib.GetProperty(p_ps_rowstatus,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_allineacoint_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_allineacoint_mcrdef();
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
  public MemoryCursorRow_allineacoint_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_allineacoint_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_allineacoint_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_allineacoint_mcrdef p_Row) {
    MemoryCursorRow_allineacoint_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_allineacoint_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_allineacoint_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_allineacoint_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
