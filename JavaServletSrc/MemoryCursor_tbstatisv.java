// Definition generated from table tbstatisv
public class MemoryCursor_tbstatisv extends CPMemoryCursor {
  MemoryCursorRow_tbstatisv row;
  MemoryCursorRow_tbstatisv empty_row;
  public MemoryCursor_tbstatisv() {
    empty_row = new MemoryCursorRow_tbstatisv();
    row = empty_row;
  }
  public MemoryCursor_tbstatisv(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODICENSV;
    p_CODICENSV = new java.util.Properties();
    java.util.Properties p_DENOMINAZIONE;
    p_DENOMINAZIONE = new java.util.Properties();
    java.util.Properties p_COD_BI;
    p_COD_BI = new java.util.Properties();
    java.util.Properties p_SIGLA;
    p_SIGLA = new java.util.Properties();
    java.util.Properties p_ISO;
    p_ISO = new java.util.Properties();
    java.util.Properties p_ISO2;
    p_ISO2 = new java.util.Properties();
    java.util.Properties p_INIZIO;
    p_INIZIO = new java.util.Properties();
    java.util.Properties p_FINE;
    p_FINE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICENSV".equalsIgnoreCase(key)) {
        p_CODICENSV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DENOMINAZIONE".equalsIgnoreCase(key)) {
        p_DENOMINAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_BI".equalsIgnoreCase(key)) {
        p_COD_BI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SIGLA".equalsIgnoreCase(key)) {
        p_SIGLA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ISO".equalsIgnoreCase(key)) {
        p_ISO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ISO2".equalsIgnoreCase(key)) {
        p_ISO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INIZIO".equalsIgnoreCase(key)) {
        p_INIZIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FINE".equalsIgnoreCase(key)) {
        p_FINE = CPLib.GetProperties(p.getProperty(key));
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
      row.CODICENSV = CPLib.GetProperty(p_CODICENSV,"","",i);
      row.DENOMINAZIONE = CPLib.GetProperty(p_DENOMINAZIONE,"","",i);
      row.COD_BI = CPLib.GetProperty(p_COD_BI,"","",i);
      row.SIGLA = CPLib.GetProperty(p_SIGLA,"","",i);
      row.ISO = CPLib.GetProperty(p_ISO,"","",i);
      row.ISO2 = CPLib.GetProperty(p_ISO2,"","",i);
      row.INIZIO = CPLib.GetProperty(p_INIZIO,"",CPLib.NullDate(),i);
      row.FINE = CPLib.GetProperty(p_FINE,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbstatisv)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbstatisv();
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
  public MemoryCursorRow_tbstatisv _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbstatisv _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbstatisv> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbstatisv p_Row) {
    MemoryCursorRow_tbstatisv l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbstatisv();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbstatisv p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbstatisv();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
