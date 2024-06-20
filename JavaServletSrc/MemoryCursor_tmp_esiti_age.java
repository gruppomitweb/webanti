// Definition generated from table tmp_esiti_age
public class MemoryCursor_tmp_esiti_age extends CPMemoryCursor {
  MemoryCursorRow_tmp_esiti_age row;
  MemoryCursorRow_tmp_esiti_age empty_row;
  public MemoryCursor_tmp_esiti_age() {
    empty_row = new MemoryCursorRow_tmp_esiti_age();
    row = empty_row;
  }
  public MemoryCursor_tmp_esiti_age(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_PROT;
    p_PROT = new java.util.Properties();
    java.util.Properties p_INFO;
    p_INFO = new java.util.Properties();
    java.util.Properties p_NFILE;
    p_NFILE = new java.util.Properties();
    java.util.Properties p_IDFILE;
    p_IDFILE = new java.util.Properties();
    java.util.Properties p_PROGREC;
    p_PROGREC = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_COD;
    p_COD = new java.util.Properties();
    java.util.Properties p_SOTTCOD;
    p_SOTTCOD = new java.util.Properties();
    java.util.Properties p_IDESITO;
    p_IDESITO = new java.util.Properties();
    java.util.Properties p_DESCRICOD;
    p_DESCRICOD = new java.util.Properties();
    java.util.Properties p_DESCRISCOD;
    p_DESCRISCOD = new java.util.Properties();
    java.util.Properties p_TIPOESITO;
    p_TIPOESITO = new java.util.Properties();
    java.util.Properties p_CODDIP;
    p_CODDIP = new java.util.Properties();
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_IMPOPE;
    p_IMPOPE = new java.util.Properties();
    java.util.Properties p_NUMOPE;
    p_NUMOPE = new java.util.Properties();
    java.util.Properties p_IDB;
    p_IDB = new java.util.Properties();
    java.util.Properties p_CRIGA;
    p_CRIGA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROT".equalsIgnoreCase(key)) {
        p_PROT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INFO".equalsIgnoreCase(key)) {
        p_INFO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NFILE".equalsIgnoreCase(key)) {
        p_NFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILE".equalsIgnoreCase(key)) {
        p_IDFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGREC".equalsIgnoreCase(key)) {
        p_PROGREC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD".equalsIgnoreCase(key)) {
        p_COD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTTCOD".equalsIgnoreCase(key)) {
        p_SOTTCOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDESITO".equalsIgnoreCase(key)) {
        p_IDESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRICOD".equalsIgnoreCase(key)) {
        p_DESCRICOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRISCOD".equalsIgnoreCase(key)) {
        p_DESCRISCOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOESITO".equalsIgnoreCase(key)) {
        p_TIPOESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIP".equalsIgnoreCase(key)) {
        p_CODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPOPE".equalsIgnoreCase(key)) {
        p_IMPOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMOPE".equalsIgnoreCase(key)) {
        p_NUMOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDB".equalsIgnoreCase(key)) {
        p_IDB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CRIGA".equalsIgnoreCase(key)) {
        p_CRIGA = CPLib.GetProperties(p.getProperty(key));
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
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.PROT = CPLib.GetProperty(p_PROT,"","",i);
      row.INFO = CPLib.GetProperty(p_INFO,"","",i);
      row.NFILE = CPLib.GetProperty(p_NFILE,"","",i);
      row.IDFILE = CPLib.GetProperty(p_IDFILE,"","",i);
      row.PROGREC = CPLib.GetProperty(p_PROGREC,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"",0,i);
      row.COD = CPLib.GetProperty(p_COD,"","",i);
      row.SOTTCOD = CPLib.GetProperty(p_SOTTCOD,"","",i);
      row.IDESITO = CPLib.GetProperty(p_IDESITO,"","",i);
      row.DESCRICOD = CPLib.GetProperty(p_DESCRICOD,"","",i);
      row.DESCRISCOD = CPLib.GetProperty(p_DESCRISCOD,"","",i);
      row.TIPOESITO = CPLib.GetProperty(p_TIPOESITO,"","",i);
      row.CODDIP = CPLib.GetProperty(p_CODDIP,"","",i);
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.IMPOPE = CPLib.GetProperty(p_IMPOPE,"",0,i);
      row.NUMOPE = CPLib.GetProperty(p_NUMOPE,"","",i);
      row.IDB = CPLib.GetProperty(p_IDB,"","",i);
      row.CRIGA = CPLib.GetProperty(p_CRIGA,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_esiti_age)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_esiti_age();
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
  public MemoryCursorRow_tmp_esiti_age _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_esiti_age _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_esiti_age> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_esiti_age p_Row) {
    MemoryCursorRow_tmp_esiti_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_esiti_age();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_esiti_age p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_esiti_age();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
