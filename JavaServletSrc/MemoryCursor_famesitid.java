// Definition generated from table famesitid
public class MemoryCursor_famesitid extends CPMemoryCursor {
  MemoryCursorRow_famesitid row;
  MemoryCursorRow_famesitid empty_row;
  public MemoryCursor_famesitid() {
    empty_row = new MemoryCursorRow_famesitid();
    row = empty_row;
  }
  public MemoryCursor_famesitid(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_FADRAPPORTO;
    p_FADRAPPORTO = new java.util.Properties();
    java.util.Properties p_FADPROGR;
    p_FADPROGR = new java.util.Properties();
    java.util.Properties p_FADCODFIS;
    p_FADCODFIS = new java.util.Properties();
    java.util.Properties p_FADRUOLO;
    p_FADRUOLO = new java.util.Properties();
    java.util.Properties p_FADDATINI;
    p_FADDATINI = new java.util.Properties();
    java.util.Properties p_FADDATFIN;
    p_FADDATFIN = new java.util.Properties();
    java.util.Properties p_FADTERNA1;
    p_FADTERNA1 = new java.util.Properties();
    java.util.Properties p_FADTERNA2;
    p_FADTERNA2 = new java.util.Properties();
    java.util.Properties p_FADTERNA3;
    p_FADTERNA3 = new java.util.Properties();
    java.util.Properties p_FADCOGRAG;
    p_FADCOGRAG = new java.util.Properties();
    java.util.Properties p_FADNOME;
    p_FADNOME = new java.util.Properties();
    java.util.Properties p_FADSESSO;
    p_FADSESSO = new java.util.Properties();
    java.util.Properties p_FADDATNAS;
    p_FADDATNAS = new java.util.Properties();
    java.util.Properties p_FADNASSEL;
    p_FADNASSEL = new java.util.Properties();
    java.util.Properties p_FADPRVSEL;
    p_FADPRVSEL = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADRAPPORTO".equalsIgnoreCase(key)) {
        p_FADRAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADPROGR".equalsIgnoreCase(key)) {
        p_FADPROGR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADCODFIS".equalsIgnoreCase(key)) {
        p_FADCODFIS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADRUOLO".equalsIgnoreCase(key)) {
        p_FADRUOLO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADDATINI".equalsIgnoreCase(key)) {
        p_FADDATINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADDATFIN".equalsIgnoreCase(key)) {
        p_FADDATFIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADTERNA1".equalsIgnoreCase(key)) {
        p_FADTERNA1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADTERNA2".equalsIgnoreCase(key)) {
        p_FADTERNA2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADTERNA3".equalsIgnoreCase(key)) {
        p_FADTERNA3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADCOGRAG".equalsIgnoreCase(key)) {
        p_FADCOGRAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADNOME".equalsIgnoreCase(key)) {
        p_FADNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADSESSO".equalsIgnoreCase(key)) {
        p_FADSESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADDATNAS".equalsIgnoreCase(key)) {
        p_FADDATNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADNASSEL".equalsIgnoreCase(key)) {
        p_FADNASSEL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FADPRVSEL".equalsIgnoreCase(key)) {
        p_FADPRVSEL = CPLib.GetProperties(p.getProperty(key));
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
      row.FADRAPPORTO = CPLib.GetProperty(p_FADRAPPORTO,"","",i);
      row.FADPROGR = CPLib.GetProperty(p_FADPROGR,"",0,i);
      row.FADCODFIS = CPLib.GetProperty(p_FADCODFIS,"","",i);
      row.FADRUOLO = CPLib.GetProperty(p_FADRUOLO,"",0,i);
      row.FADDATINI = CPLib.GetProperty(p_FADDATINI,"",CPLib.NullDate(),i);
      row.FADDATFIN = CPLib.GetProperty(p_FADDATFIN,"",CPLib.NullDate(),i);
      row.FADTERNA1 = CPLib.GetProperty(p_FADTERNA1,"","",i);
      row.FADTERNA2 = CPLib.GetProperty(p_FADTERNA2,"",0,i);
      row.FADTERNA3 = CPLib.GetProperty(p_FADTERNA3,"","",i);
      row.FADCOGRAG = CPLib.GetProperty(p_FADCOGRAG,"","",i);
      row.FADNOME = CPLib.GetProperty(p_FADNOME,"","",i);
      row.FADSESSO = CPLib.GetProperty(p_FADSESSO,"","",i);
      row.FADDATNAS = CPLib.GetProperty(p_FADDATNAS,"",CPLib.NullDate(),i);
      row.FADNASSEL = CPLib.GetProperty(p_FADNASSEL,"","",i);
      row.FADPRVSEL = CPLib.GetProperty(p_FADPRVSEL,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_famesitid)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_famesitid();
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
  public MemoryCursorRow_famesitid _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_famesitid _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_famesitid> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_famesitid p_Row) {
    MemoryCursorRow_famesitid l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_famesitid();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_famesitid p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_famesitid();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
