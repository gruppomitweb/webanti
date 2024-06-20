// Definition generated from record definition mcsoggetti_mcrdef
public class MemoryCursor_mcsoggetti_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcsoggetti_mcrdef row;
  MemoryCursorRow_mcsoggetti_mcrdef empty_row;
  public MemoryCursor_mcsoggetti_mcrdef() {
    empty_row = new MemoryCursorRow_mcsoggetti_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcsoggetti_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_NASSTATO;
    p_NASSTATO = new java.util.Properties();
    java.util.Properties p_SOTGRUP;
    p_SOTGRUP = new java.util.Properties();
    java.util.Properties p_RAMOGRUP;
    p_RAMOGRUP = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
    java.util.Properties p_TIPODOC;
    p_TIPODOC = new java.util.Properties();
    java.util.Properties p_NUMDOCUM;
    p_NUMDOCUM = new java.util.Properties();
    java.util.Properties p_DATARILASC;
    p_DATARILASC = new java.util.Properties();
    java.util.Properties p_AUTRILASC;
    p_AUTRILASC = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_ATTIV;
    p_ATTIV = new java.util.Properties();
    java.util.Properties p_TIPINTER;
    p_TIPINTER = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
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
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOMICILIO".equalsIgnoreCase(key)) {
        p_DOMICILIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASSTATO".equalsIgnoreCase(key)) {
        p_NASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTGRUP".equalsIgnoreCase(key)) {
        p_SOTGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAMOGRUP".equalsIgnoreCase(key)) {
        p_RAMOGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPODOC".equalsIgnoreCase(key)) {
        p_TIPODOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDOCUM".equalsIgnoreCase(key)) {
        p_NUMDOCUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARILASC".equalsIgnoreCase(key)) {
        p_DATARILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AUTRILASC".equalsIgnoreCase(key)) {
        p_AUTRILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTIV".equalsIgnoreCase(key)) {
        p_ATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINTER".equalsIgnoreCase(key)) {
        p_TIPINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
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
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.SOTGRUP = CPLib.GetProperty(p_SOTGRUP,"","",i);
      row.RAMOGRUP = CPLib.GetProperty(p_RAMOGRUP,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"",CPLib.NullDate(),i);
      row.AUTRILASC = CPLib.GetProperty(p_AUTRILASC,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.ATTIV = CPLib.GetProperty(p_ATTIV,"","",i);
      row.TIPINTER = CPLib.GetProperty(p_TIPINTER,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcsoggetti_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcsoggetti_mcrdef();
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
  public MemoryCursorRow_mcsoggetti_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcsoggetti_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcsoggetti_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    MemoryCursorRow_mcsoggetti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggetti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcsoggetti_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcsoggetti_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
