// Definition generated from record definition mcpersonstorico_mcrdef
public class MemoryCursor_mcpersonstorico_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcpersonstorico_mcrdef row;
  MemoryCursorRow_mcpersonstorico_mcrdef empty_row;
  public MemoryCursor_mcpersonstorico_mcrdef() {
    empty_row = new MemoryCursorRow_mcpersonstorico_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcpersonstorico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_IDNASSTATO;
    p_IDNASSTATO = new java.util.Properties();
    java.util.Properties p_PIVA;
    p_PIVA = new java.util.Properties();
    java.util.Properties p_NOSARA;
    p_NOSARA = new java.util.Properties();
    java.util.Properties p_TIPOPERS;
    p_TIPOPERS = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDNASSTATO".equalsIgnoreCase(key)) {
        p_IDNASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PIVA".equalsIgnoreCase(key)) {
        p_PIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOSARA".equalsIgnoreCase(key)) {
        p_NOSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOPERS".equalsIgnoreCase(key)) {
        p_TIPOPERS = CPLib.GetProperties(p.getProperty(key));
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
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.IDNASSTATO = CPLib.GetProperty(p_IDNASSTATO,"","",i);
      row.PIVA = CPLib.GetProperty(p_PIVA,"","",i);
      row.NOSARA = CPLib.GetProperty(p_NOSARA,"","",i);
      row.TIPOPERS = CPLib.GetProperty(p_TIPOPERS,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcpersonstorico_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcpersonstorico_mcrdef();
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
  public MemoryCursorRow_mcpersonstorico_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcpersonstorico_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcpersonstorico_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    MemoryCursorRow_mcpersonstorico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonstorico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcpersonstorico_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcpersonstorico_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
