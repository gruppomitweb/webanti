// Definition generated from table decodecitta
public class MemoryCursor_decodecitta extends CPMemoryCursor {
  MemoryCursorRow_decodecitta row;
  MemoryCursorRow_decodecitta empty_row;
  public MemoryCursor_decodecitta() {
    empty_row = new MemoryCursorRow_decodecitta();
    row = empty_row;
  }
  public MemoryCursor_decodecitta(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_ID;
    p_ID = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_CITTAMIT;
    p_CITTAMIT = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_PROV;
    p_PROV = new java.util.Properties();
    java.util.Properties p_CAPMIT;
    p_CAPMIT = new java.util.Properties();
    java.util.Properties p_PKTBSTATI;
    p_PKTBSTATI = new java.util.Properties();
    java.util.Properties p_SIGLA;
    p_SIGLA = new java.util.Properties();
    java.util.Properties p_PREF;
    p_PREF = new java.util.Properties();
    java.util.Properties p_IDTBLS;
    p_IDTBLS = new java.util.Properties();
    java.util.Properties p_CITTA;
    p_CITTA = new java.util.Properties();
    java.util.Properties p_PR;
    p_PR = new java.util.Properties();
    java.util.Properties p_CATASTALE;
    p_CATASTALE = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_REGIONE;
    p_REGIONE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ID".equalsIgnoreCase(key)) {
        p_ID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CITTAMIT".equalsIgnoreCase(key)) {
        p_CITTAMIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROV".equalsIgnoreCase(key)) {
        p_PROV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAPMIT".equalsIgnoreCase(key)) {
        p_CAPMIT = CPLib.GetProperties(p.getProperty(key));
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
      if ("CITTA".equalsIgnoreCase(key)) {
        p_CITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PR".equalsIgnoreCase(key)) {
        p_PR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATASTALE".equalsIgnoreCase(key)) {
        p_CATASTALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("REGIONE".equalsIgnoreCase(key)) {
        p_REGIONE = CPLib.GetProperties(p.getProperty(key));
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
      row.ID = CPLib.GetProperty(p_ID,"",0,i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.CITTAMIT = CPLib.GetProperty(p_CITTAMIT,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.PROV = CPLib.GetProperty(p_PROV,"","",i);
      row.CAPMIT = CPLib.GetProperty(p_CAPMIT,"","",i);
      row.PKTBSTATI = CPLib.GetProperty(p_PKTBSTATI,"","",i);
      row.SIGLA = CPLib.GetProperty(p_SIGLA,"","",i);
      row.PREF = CPLib.GetProperty(p_PREF,"","",i);
      row.IDTBLS = CPLib.GetProperty(p_IDTBLS,"","",i);
      row.CITTA = CPLib.GetProperty(p_CITTA,"","",i);
      row.PR = CPLib.GetProperty(p_PR,"","",i);
      row.CATASTALE = CPLib.GetProperty(p_CATASTALE,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.REGIONE = CPLib.GetProperty(p_REGIONE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_decodecitta)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_decodecitta();
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
  public MemoryCursorRow_decodecitta _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_decodecitta _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_decodecitta> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_decodecitta p_Row) {
    MemoryCursorRow_decodecitta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_decodecitta();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_decodecitta p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_decodecitta();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
