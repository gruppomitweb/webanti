// Definition generated from table cassandra_aefaminvio
public class MemoryCursor_cassandra_aefaminvio extends CPMemoryCursor {
  MemoryCursorRow_cassandra_aefaminvio row;
  MemoryCursorRow_cassandra_aefaminvio empty_row;
  public MemoryCursor_cassandra_aefaminvio() {
    empty_row = new MemoryCursorRow_cassandra_aefaminvio();
    row = empty_row;
  }
  public MemoryCursor_cassandra_aefaminvio(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_IDIDBASE;
    p_IDIDBASE = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_TIPOINVIO;
    p_TIPOINVIO = new java.util.Properties();
    java.util.Properties p_ANNO;
    p_ANNO = new java.util.Properties();
    java.util.Properties p_MESE;
    p_MESE = new java.util.Properties();
    java.util.Properties p_TIPOCOM;
    p_TIPOCOM = new java.util.Properties();
    java.util.Properties p_OLDDATA;
    p_OLDDATA = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_NOMEFILE;
    p_NOMEFILE = new java.util.Properties();
    java.util.Properties p_FILEINV1;
    p_FILEINV1 = new java.util.Properties();
    java.util.Properties p_FILEINV2;
    p_FILEINV2 = new java.util.Properties();
    java.util.Properties p_PROG;
    p_PROG = new java.util.Properties();
    java.util.Properties p_PROTOCOLLO;
    p_PROTOCOLLO = new java.util.Properties();
    java.util.Properties p_CODERROR;
    p_CODERROR = new java.util.Properties();
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
      if ("IDIDBASE".equalsIgnoreCase(key)) {
        p_IDIDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINVIO".equalsIgnoreCase(key)) {
        p_TIPOINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNO".equalsIgnoreCase(key)) {
        p_ANNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MESE".equalsIgnoreCase(key)) {
        p_MESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOCOM".equalsIgnoreCase(key)) {
        p_TIPOCOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDDATA".equalsIgnoreCase(key)) {
        p_OLDDATA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOMEFILE".equalsIgnoreCase(key)) {
        p_NOMEFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILEINV1".equalsIgnoreCase(key)) {
        p_FILEINV1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILEINV2".equalsIgnoreCase(key)) {
        p_FILEINV2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROG".equalsIgnoreCase(key)) {
        p_PROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROTOCOLLO".equalsIgnoreCase(key)) {
        p_PROTOCOLLO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODERROR".equalsIgnoreCase(key)) {
        p_CODERROR = CPLib.GetProperties(p.getProperty(key));
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
      row.IDIDBASE = CPLib.GetProperty(p_IDIDBASE,"","",i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.TIPOINVIO = CPLib.GetProperty(p_TIPOINVIO,"","",i);
      row.ANNO = CPLib.GetProperty(p_ANNO,"","",i);
      row.MESE = CPLib.GetProperty(p_MESE,"","",i);
      row.TIPOCOM = CPLib.GetProperty(p_TIPOCOM,"","",i);
      row.OLDDATA = CPLib.GetProperty(p_OLDDATA,"",CPLib.NullDate(),i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.NOMEFILE = CPLib.GetProperty(p_NOMEFILE,"","",i);
      row.FILEINV1 = CPLib.GetProperty(p_FILEINV1,"","",i);
      row.FILEINV2 = CPLib.GetProperty(p_FILEINV2,"","",i);
      row.PROG = CPLib.GetProperty(p_PROG,"",0,i);
      row.PROTOCOLLO = CPLib.GetProperty(p_PROTOCOLLO,"","",i);
      row.CODERROR = CPLib.GetProperty(p_CODERROR,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cassandra_aefaminvio)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cassandra_aefaminvio();
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
  public MemoryCursorRow_cassandra_aefaminvio _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cassandra_aefaminvio _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cassandra_aefaminvio> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cassandra_aefaminvio p_Row) {
    MemoryCursorRow_cassandra_aefaminvio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cassandra_aefaminvio();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cassandra_aefaminvio p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cassandra_aefaminvio();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
