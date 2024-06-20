// Definition generated from table delegabo
public class MemoryCursor_delegabo extends CPMemoryCursor {
  MemoryCursorRow_delegabo row;
  MemoryCursorRow_delegabo empty_row;
  public MemoryCursor_delegabo() {
    empty_row = new MemoryCursorRow_delegabo();
    row = empty_row;
  }
  public MemoryCursor_delegabo(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_CPROWNUM;
    p_CPROWNUM = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_DESCINTER;
    p_DESCINTER = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_TIPOPERS;
    p_TIPOPERS = new java.util.Properties();
    java.util.Properties p_STATOREG;
    p_STATOREG = new java.util.Properties();
    java.util.Properties p_OPERAZMOD;
    p_OPERAZMOD = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties p_IDEREG;
    p_IDEREG = new java.util.Properties();
    java.util.Properties p_COLLEGAMEN;
    p_COLLEGAMEN = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_NUMPROG1;
    p_NUMPROG1 = new java.util.Properties();
    java.util.Properties p_NUMPROG2;
    p_NUMPROG2 = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_UCODE;
    p_UCODE = new java.util.Properties();
    java.util.Properties p_ABBINATO;
    p_ABBINATO = new java.util.Properties();
    java.util.Properties p_NOAGE;
    p_NOAGE = new java.util.Properties();
    java.util.Properties p_NUMIMP;
    p_NUMIMP = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CPROWNUM".equalsIgnoreCase(key)) {
        p_CPROWNUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCINTER".equalsIgnoreCase(key)) {
        p_DESCINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOPERS".equalsIgnoreCase(key)) {
        p_TIPOPERS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOREG".equalsIgnoreCase(key)) {
        p_STATOREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAZMOD".equalsIgnoreCase(key)) {
        p_OPERAZMOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDEREG".equalsIgnoreCase(key)) {
        p_IDEREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COLLEGAMEN".equalsIgnoreCase(key)) {
        p_COLLEGAMEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG1".equalsIgnoreCase(key)) {
        p_NUMPROG1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG2".equalsIgnoreCase(key)) {
        p_NUMPROG2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UCODE".equalsIgnoreCase(key)) {
        p_UCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABBINATO".equalsIgnoreCase(key)) {
        p_ABBINATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOAGE".equalsIgnoreCase(key)) {
        p_NOAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMIMP".equalsIgnoreCase(key)) {
        p_NUMIMP = CPLib.GetProperties(p.getProperty(key));
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
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",0,i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.DESCINTER = CPLib.GetProperty(p_DESCINTER,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.TIPOPERS = CPLib.GetProperty(p_TIPOPERS,"","",i);
      row.STATOREG = CPLib.GetProperty(p_STATOREG,"","",i);
      row.OPERAZMOD = CPLib.GetProperty(p_OPERAZMOD,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"",CPLib.NullDate(),i);
      row.IDEREG = CPLib.GetProperty(p_IDEREG,"","",i);
      row.COLLEGAMEN = CPLib.GetProperty(p_COLLEGAMEN,"","",i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.NUMPROG1 = CPLib.GetProperty(p_NUMPROG1,"","",i);
      row.NUMPROG2 = CPLib.GetProperty(p_NUMPROG2,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.UCODE = CPLib.GetProperty(p_UCODE,"","",i);
      row.ABBINATO = CPLib.GetProperty(p_ABBINATO,"",0,i);
      row.NOAGE = CPLib.GetProperty(p_NOAGE,"","",i);
      row.NUMIMP = CPLib.GetProperty(p_NUMIMP,"",CPLib.NullDateTime(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_delegabo)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_delegabo();
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
  public MemoryCursorRow_delegabo _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_delegabo _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_delegabo> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_delegabo p_Row) {
    MemoryCursorRow_delegabo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_delegabo();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_delegabo p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_delegabo();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
