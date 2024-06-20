// Definition generated from table sid_invio
public class MemoryCursor_sid_invio extends CPMemoryCursor {
  MemoryCursorRow_sid_invio row;
  MemoryCursorRow_sid_invio empty_row;
  public MemoryCursor_sid_invio() {
    empty_row = new MemoryCursorRow_sid_invio();
    row = empty_row;
  }
  public MemoryCursor_sid_invio(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINVIO;
    p_CODINVIO = new java.util.Properties();
    java.util.Properties p_TIPINVIO;
    p_TIPINVIO = new java.util.Properties();
    java.util.Properties p_TPCINVIO;
    p_TPCINVIO = new java.util.Properties();
    java.util.Properties p_DATINVIO;
    p_DATINVIO = new java.util.Properties();
    java.util.Properties p_ANNINVIO;
    p_ANNINVIO = new java.util.Properties();
    java.util.Properties p_MESINVIO;
    p_MESINVIO = new java.util.Properties();
    java.util.Properties p_PRTINVIO;
    p_PRTINVIO = new java.util.Properties();
    java.util.Properties p_FLEINVIO;
    p_FLEINVIO = new java.util.Properties();
    java.util.Properties p_FL1INVIO;
    p_FL1INVIO = new java.util.Properties();
    java.util.Properties p_FL2INVIO;
    p_FL2INVIO = new java.util.Properties();
    java.util.Properties p_FLGINVIO;
    p_FLGINVIO = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINVIO".equalsIgnoreCase(key)) {
        p_CODINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINVIO".equalsIgnoreCase(key)) {
        p_TIPINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TPCINVIO".equalsIgnoreCase(key)) {
        p_TPCINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATINVIO".equalsIgnoreCase(key)) {
        p_DATINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNINVIO".equalsIgnoreCase(key)) {
        p_ANNINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MESINVIO".equalsIgnoreCase(key)) {
        p_MESINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRTINVIO".equalsIgnoreCase(key)) {
        p_PRTINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLEINVIO".equalsIgnoreCase(key)) {
        p_FLEINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FL1INVIO".equalsIgnoreCase(key)) {
        p_FL1INVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FL2INVIO".equalsIgnoreCase(key)) {
        p_FL2INVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGINVIO".equalsIgnoreCase(key)) {
        p_FLGINVIO = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINVIO = CPLib.GetProperty(p_CODINVIO,"","",i);
      row.TIPINVIO = CPLib.GetProperty(p_TIPINVIO,"","",i);
      row.TPCINVIO = CPLib.GetProperty(p_TPCINVIO,"","",i);
      row.DATINVIO = CPLib.GetProperty(p_DATINVIO,"",CPLib.NullDate(),i);
      row.ANNINVIO = CPLib.GetProperty(p_ANNINVIO,"","",i);
      row.MESINVIO = CPLib.GetProperty(p_MESINVIO,"","",i);
      row.PRTINVIO = CPLib.GetProperty(p_PRTINVIO,"","",i);
      row.FLEINVIO = CPLib.GetProperty(p_FLEINVIO,"","",i);
      row.FL1INVIO = CPLib.GetProperty(p_FL1INVIO,"","",i);
      row.FL2INVIO = CPLib.GetProperty(p_FL2INVIO,"","",i);
      row.FLGINVIO = CPLib.GetProperty(p_FLGINVIO,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sid_invio)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sid_invio();
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
  public MemoryCursorRow_sid_invio _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sid_invio _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sid_invio> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sid_invio p_Row) {
    MemoryCursorRow_sid_invio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sid_invio p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sid_invio();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
