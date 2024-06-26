// Definition generated from record definition mcsaldi_mcrdef
public class MemoryCursor_mcsaldi_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcsaldi_mcrdef row;
  MemoryCursorRow_mcsaldi_mcrdef empty_row;
  public MemoryCursor_mcsaldi_mcrdef() {
    empty_row = new MemoryCursorRow_mcsaldi_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcsaldi_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_TIPOAG;
    p_TIPOAG = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_DESCRAP;
    p_DESCRAP = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_INVIATO;
    p_INVIATO = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_UNIQUECODE;
    p_UNIQUECODE = new java.util.Properties();
    java.util.Properties p_OLDINTER;
    p_OLDINTER = new java.util.Properties();
    java.util.Properties p_SALDO;
    p_SALDO = new java.util.Properties();
    java.util.Properties p_QUANTITA;
    p_QUANTITA = new java.util.Properties();
    java.util.Properties p_NATURA;
    p_NATURA = new java.util.Properties();
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
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOAG".equalsIgnoreCase(key)) {
        p_TIPOAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRAP".equalsIgnoreCase(key)) {
        p_DESCRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INVIATO".equalsIgnoreCase(key)) {
        p_INVIATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUECODE".equalsIgnoreCase(key)) {
        p_UNIQUECODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDINTER".equalsIgnoreCase(key)) {
        p_OLDINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SALDO".equalsIgnoreCase(key)) {
        p_SALDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("QUANTITA".equalsIgnoreCase(key)) {
        p_QUANTITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATURA".equalsIgnoreCase(key)) {
        p_NATURA = CPLib.GetProperties(p.getProperty(key));
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
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.TIPOAG = CPLib.GetProperty(p_TIPOAG,"","",i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.DESCRAP = CPLib.GetProperty(p_DESCRAP,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.INVIATO = CPLib.GetProperty(p_INVIATO,"",0,i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.UNIQUECODE = CPLib.GetProperty(p_UNIQUECODE,"","",i);
      row.OLDINTER = CPLib.GetProperty(p_OLDINTER,"","",i);
      row.SALDO = CPLib.GetProperty(p_SALDO,"",0,i);
      row.QUANTITA = CPLib.GetProperty(p_QUANTITA,"",0,i);
      row.NATURA = CPLib.GetProperty(p_NATURA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcsaldi_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcsaldi_mcrdef();
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
  public MemoryCursorRow_mcsaldi_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcsaldi_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcsaldi_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    MemoryCursorRow_mcsaldi_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsaldi_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcsaldi_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcsaldi_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
