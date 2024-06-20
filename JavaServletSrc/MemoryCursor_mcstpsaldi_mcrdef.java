// Definition generated from record definition mcstpsaldi_mcrdef
public class MemoryCursor_mcstpsaldi_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcstpsaldi_mcrdef row;
  MemoryCursorRow_mcstpsaldi_mcrdef empty_row;
  public MemoryCursor_mcstpsaldi_mcrdef() {
    empty_row = new MemoryCursorRow_mcstpsaldi_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcstpsaldi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_CONNESINT;
    p_CONNESINT = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_IDEREG;
    p_IDEREG = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_UNIQUE;
    p_UNIQUE = new java.util.Properties();
    java.util.Properties p_ANNO;
    p_ANNO = new java.util.Properties();
    java.util.Properties p_SALDO;
    p_SALDO = new java.util.Properties();
    java.util.Properties p_QUANTITA;
    p_QUANTITA = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESINT".equalsIgnoreCase(key)) {
        p_CONNESINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDEREG".equalsIgnoreCase(key)) {
        p_IDEREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUE".equalsIgnoreCase(key)) {
        p_UNIQUE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNO".equalsIgnoreCase(key)) {
        p_ANNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SALDO".equalsIgnoreCase(key)) {
        p_SALDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("QUANTITA".equalsIgnoreCase(key)) {
        p_QUANTITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.CONNESINT = CPLib.GetProperty(p_CONNESINT,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.IDEREG = CPLib.GetProperty(p_IDEREG,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.UNIQUE = CPLib.GetProperty(p_UNIQUE,"","",i);
      row.ANNO = CPLib.GetProperty(p_ANNO,"","",i);
      row.SALDO = CPLib.GetProperty(p_SALDO,"",0,i);
      row.QUANTITA = CPLib.GetProperty(p_QUANTITA,"",0,i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcstpsaldi_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcstpsaldi_mcrdef();
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
  public MemoryCursorRow_mcstpsaldi_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcstpsaldi_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcstpsaldi_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcstpsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcstpsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcstpsaldi_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcstpsaldi_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
