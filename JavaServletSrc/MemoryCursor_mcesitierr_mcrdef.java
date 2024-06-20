// Definition generated from record definition mcesitierr_mcrdef
public class MemoryCursor_mcesitierr_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcesitierr_mcrdef row;
  MemoryCursorRow_mcesitierr_mcrdef empty_row;
  public MemoryCursor_mcesitierr_mcrdef() {
    empty_row = new MemoryCursorRow_mcesitierr_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcesitierr_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_UNIQUECODE;
    p_UNIQUECODE = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_NDGSOG;
    p_NDGSOG = new java.util.Properties();
    java.util.Properties p_ERRMSG;
    p_ERRMSG = new java.util.Properties();
    java.util.Properties p_DATOMIT;
    p_DATOMIT = new java.util.Properties();
    java.util.Properties p_DATOAGE;
    p_DATOAGE = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUECODE".equalsIgnoreCase(key)) {
        p_UNIQUECODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDGSOG".equalsIgnoreCase(key)) {
        p_NDGSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERRMSG".equalsIgnoreCase(key)) {
        p_ERRMSG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATOMIT".equalsIgnoreCase(key)) {
        p_DATOMIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATOAGE".equalsIgnoreCase(key)) {
        p_DATOAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
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
      row.UNIQUECODE = CPLib.GetProperty(p_UNIQUECODE,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.NDGSOG = CPLib.GetProperty(p_NDGSOG,"","",i);
      row.ERRMSG = CPLib.GetProperty(p_ERRMSG,"","",i);
      row.DATOMIT = CPLib.GetProperty(p_DATOMIT,"","",i);
      row.DATOAGE = CPLib.GetProperty(p_DATOAGE,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcesitierr_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcesitierr_mcrdef();
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
  public MemoryCursorRow_mcesitierr_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcesitierr_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcesitierr_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    MemoryCursorRow_mcesitierr_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcesitierr_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcesitierr_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcesitierr_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
