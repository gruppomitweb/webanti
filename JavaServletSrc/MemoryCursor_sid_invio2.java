// Definition generated from table sid_invio2
public class MemoryCursor_sid_invio2 extends CPMemoryCursor {
  MemoryCursorRow_sid_invio2 row;
  MemoryCursorRow_sid_invio2 empty_row;
  public MemoryCursor_sid_invio2() {
    empty_row = new MemoryCursorRow_sid_invio2();
    row = empty_row;
  }
  public MemoryCursor_sid_invio2(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINVIO2;
    p_CODINVIO2 = new java.util.Properties();
    java.util.Properties p_RAPINVIO2;
    p_RAPINVIO2 = new java.util.Properties();
    java.util.Properties p_APRINVIO2;
    p_APRINVIO2 = new java.util.Properties();
    java.util.Properties p_INIINVIO2;
    p_INIINVIO2 = new java.util.Properties();
    java.util.Properties p_FININVIO2;
    p_FININVIO2 = new java.util.Properties();
    java.util.Properties p_FCFINVIO2;
    p_FCFINVIO2 = new java.util.Properties();
    java.util.Properties p_CFSINVIO2;
    p_CFSINVIO2 = new java.util.Properties();
    java.util.Properties p_RUOINVIO2;
    p_RUOINVIO2 = new java.util.Properties();
    java.util.Properties p_COGINVIO2;
    p_COGINVIO2 = new java.util.Properties();
    java.util.Properties p_NOMINVIO2;
    p_NOMINVIO2 = new java.util.Properties();
    java.util.Properties p_SEXINVIO2;
    p_SEXINVIO2 = new java.util.Properties();
    java.util.Properties p_DNSINVIO2;
    p_DNSINVIO2 = new java.util.Properties();
    java.util.Properties p_CNSINVIO2;
    p_CNSINVIO2 = new java.util.Properties();
    java.util.Properties p_PNSINVIO2;
    p_PNSINVIO2 = new java.util.Properties();
    java.util.Properties p_RGSINVIO2;
    p_RGSINVIO2 = new java.util.Properties();
    java.util.Properties p_CSLINVIO2;
    p_CSLINVIO2 = new java.util.Properties();
    java.util.Properties p_PLSINVIO2;
    p_PLSINVIO2 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINVIO2".equalsIgnoreCase(key)) {
        p_CODINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPINVIO2".equalsIgnoreCase(key)) {
        p_RAPINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("APRINVIO2".equalsIgnoreCase(key)) {
        p_APRINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INIINVIO2".equalsIgnoreCase(key)) {
        p_INIINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FININVIO2".equalsIgnoreCase(key)) {
        p_FININVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FCFINVIO2".equalsIgnoreCase(key)) {
        p_FCFINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFSINVIO2".equalsIgnoreCase(key)) {
        p_CFSINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RUOINVIO2".equalsIgnoreCase(key)) {
        p_RUOINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGINVIO2".equalsIgnoreCase(key)) {
        p_COGINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOMINVIO2".equalsIgnoreCase(key)) {
        p_NOMINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEXINVIO2".equalsIgnoreCase(key)) {
        p_SEXINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DNSINVIO2".equalsIgnoreCase(key)) {
        p_DNSINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CNSINVIO2".equalsIgnoreCase(key)) {
        p_CNSINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PNSINVIO2".equalsIgnoreCase(key)) {
        p_PNSINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RGSINVIO2".equalsIgnoreCase(key)) {
        p_RGSINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CSLINVIO2".equalsIgnoreCase(key)) {
        p_CSLINVIO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PLSINVIO2".equalsIgnoreCase(key)) {
        p_PLSINVIO2 = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINVIO2 = CPLib.GetProperty(p_CODINVIO2,"","",i);
      row.RAPINVIO2 = CPLib.GetProperty(p_RAPINVIO2,"","",i);
      row.APRINVIO2 = CPLib.GetProperty(p_APRINVIO2,"",0,i);
      row.INIINVIO2 = CPLib.GetProperty(p_INIINVIO2,"",CPLib.NullDate(),i);
      row.FININVIO2 = CPLib.GetProperty(p_FININVIO2,"",CPLib.NullDate(),i);
      row.FCFINVIO2 = CPLib.GetProperty(p_FCFINVIO2,"",0,i);
      row.CFSINVIO2 = CPLib.GetProperty(p_CFSINVIO2,"","",i);
      row.RUOINVIO2 = CPLib.GetProperty(p_RUOINVIO2,"","",i);
      row.COGINVIO2 = CPLib.GetProperty(p_COGINVIO2,"","",i);
      row.NOMINVIO2 = CPLib.GetProperty(p_NOMINVIO2,"","",i);
      row.SEXINVIO2 = CPLib.GetProperty(p_SEXINVIO2,"","",i);
      row.DNSINVIO2 = CPLib.GetProperty(p_DNSINVIO2,"",CPLib.NullDate(),i);
      row.CNSINVIO2 = CPLib.GetProperty(p_CNSINVIO2,"","",i);
      row.PNSINVIO2 = CPLib.GetProperty(p_PNSINVIO2,"","",i);
      row.RGSINVIO2 = CPLib.GetProperty(p_RGSINVIO2,"","",i);
      row.CSLINVIO2 = CPLib.GetProperty(p_CSLINVIO2,"","",i);
      row.PLSINVIO2 = CPLib.GetProperty(p_PLSINVIO2,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sid_invio2)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sid_invio2();
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
  public MemoryCursorRow_sid_invio2 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sid_invio2 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sid_invio2> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sid_invio2 p_Row) {
    MemoryCursorRow_sid_invio2 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio2();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sid_invio2 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sid_invio2();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
