// Definition generated from table decodenascita
public class MemoryCursor_decodenascita extends CPMemoryCursor {
  MemoryCursorRow_decodenascita row;
  MemoryCursorRow_decodenascita empty_row;
  public MemoryCursor_decodenascita() {
    empty_row = new MemoryCursorRow_decodenascita();
    row = empty_row;
  }
  public MemoryCursor_decodenascita(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_id;
    p_id = new java.util.Properties();
    java.util.Properties p_account;
    p_account = new java.util.Properties();
    java.util.Properties p_SIGLA;
    p_SIGLA = new java.util.Properties();
    java.util.Properties p_DESCRI;
    p_DESCRI = new java.util.Properties();
    java.util.Properties p_DATINI;
    p_DATINI = new java.util.Properties();
    java.util.Properties p_DATFIN;
    p_DATFIN = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("id".equalsIgnoreCase(key)) {
        p_id = CPLib.GetProperties(p.getProperty(key));
      }
      if ("account".equalsIgnoreCase(key)) {
        p_account = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SIGLA".equalsIgnoreCase(key)) {
        p_SIGLA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRI".equalsIgnoreCase(key)) {
        p_DESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATINI".equalsIgnoreCase(key)) {
        p_DATINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATFIN".equalsIgnoreCase(key)) {
        p_DATFIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
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
      row.id = CPLib.GetProperty(p_id,"",0,i);
      row.account = CPLib.GetProperty(p_account,"","",i);
      row.SIGLA = CPLib.GetProperty(p_SIGLA,"","",i);
      row.DESCRI = CPLib.GetProperty(p_DESCRI,"","",i);
      row.DATINI = CPLib.GetProperty(p_DATINI,"",CPLib.NullDate(),i);
      row.DATFIN = CPLib.GetProperty(p_DATFIN,"",CPLib.NullDate(),i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_decodenascita)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_decodenascita();
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
  public MemoryCursorRow_decodenascita _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_decodenascita _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_decodenascita> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_decodenascita p_Row) {
    MemoryCursorRow_decodenascita l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodenascita();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_decodenascita p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_decodenascita();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
