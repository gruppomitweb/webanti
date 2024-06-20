// Definition generated from table tbcitta
public class MemoryCursor_tbcitta extends CPMemoryCursor {
  MemoryCursorRow_tbcitta row;
  MemoryCursorRow_tbcitta empty_row;
  public MemoryCursor_tbcitta() {
    empty_row = new MemoryCursorRow_tbcitta();
    row = empty_row;
  }
  public MemoryCursor_tbcitta(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_CITTA;
    p_CITTA = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_PROV;
    p_PROV = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_PKTBSTATI;
    p_PKTBSTATI = new java.util.Properties();
    java.util.Properties p_SIGLA;
    p_SIGLA = new java.util.Properties();
    java.util.Properties p_PREF;
    p_PREF = new java.util.Properties();
    java.util.Properties p_IDTBLS;
    p_IDTBLS = new java.util.Properties();
    java.util.Properties p_IDCITTA;
    p_IDCITTA = new java.util.Properties();
    java.util.Properties p_IDISTAT;
    p_IDISTAT = new java.util.Properties();
    java.util.Properties p_IDREGIO;
    p_IDREGIO = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFIN;
    p_DATAFIN = new java.util.Properties();
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
      if ("CITTA".equalsIgnoreCase(key)) {
        p_CITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROV".equalsIgnoreCase(key)) {
        p_PROV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PKTBSTATI".equalsIgnoreCase(key)) {
        p_PKTBSTATI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SIGLA".equalsIgnoreCase(key)) {
        p_SIGLA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PREF".equalsIgnoreCase(key)) {
        p_PREF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDTBLS".equalsIgnoreCase(key)) {
        p_IDTBLS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDCITTA".equalsIgnoreCase(key)) {
        p_IDCITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDISTAT".equalsIgnoreCase(key)) {
        p_IDISTAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDREGIO".equalsIgnoreCase(key)) {
        p_IDREGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFIN".equalsIgnoreCase(key)) {
        p_DATAFIN = CPLib.GetProperties(p.getProperty(key));
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
      row.CITTA = CPLib.GetProperty(p_CITTA,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.PROV = CPLib.GetProperty(p_PROV,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.PKTBSTATI = CPLib.GetProperty(p_PKTBSTATI,"","",i);
      row.SIGLA = CPLib.GetProperty(p_SIGLA,"","",i);
      row.PREF = CPLib.GetProperty(p_PREF,"","",i);
      row.IDTBLS = CPLib.GetProperty(p_IDTBLS,"","",i);
      row.IDCITTA = CPLib.GetProperty(p_IDCITTA,"","",i);
      row.IDISTAT = CPLib.GetProperty(p_IDISTAT,"","",i);
      row.IDREGIO = CPLib.GetProperty(p_IDREGIO,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFIN = CPLib.GetProperty(p_DATAFIN,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbcitta)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbcitta();
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
  public MemoryCursorRow_tbcitta _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbcitta _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbcitta> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbcitta p_Row) {
    MemoryCursorRow_tbcitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcitta();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbcitta p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbcitta();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
