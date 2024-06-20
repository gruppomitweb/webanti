// Definition generated from record definition mcsoggettiall1_mcrdef
public class MemoryCursor_mcsoggettiall1_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcsoggettiall1_mcrdef row;
  MemoryCursorRow_mcsoggettiall1_mcrdef empty_row;
  public MemoryCursor_mcsoggettiall1_mcrdef() {
    empty_row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcsoggettiall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODTIPSOG;
    p_CODTIPSOG = new java.util.Properties();
    java.util.Properties p_NDG;
    p_NDG = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_NASCOMU;
    p_NASCOMU = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_STATO;
    p_STATO = new java.util.Properties();
    java.util.Properties p_SAE;
    p_SAE = new java.util.Properties();
    java.util.Properties p_ATECO;
    p_ATECO = new java.util.Properties();
    java.util.Properties p_SETSINT;
    p_SETSINT = new java.util.Properties();
    java.util.Properties p_NOSARA;
    p_NOSARA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODTIPSOG".equalsIgnoreCase(key)) {
        p_CODTIPSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDG".equalsIgnoreCase(key)) {
        p_NDG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMU".equalsIgnoreCase(key)) {
        p_NASCOMU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATO".equalsIgnoreCase(key)) {
        p_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SAE".equalsIgnoreCase(key)) {
        p_SAE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECO".equalsIgnoreCase(key)) {
        p_ATECO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETSINT".equalsIgnoreCase(key)) {
        p_SETSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOSARA".equalsIgnoreCase(key)) {
        p_NOSARA = CPLib.GetProperties(p.getProperty(key));
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
      row.CODTIPSOG = CPLib.GetProperty(p_CODTIPSOG,"","",i);
      row.NDG = CPLib.GetProperty(p_NDG,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.NASCOMU = CPLib.GetProperty(p_NASCOMU,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.STATO = CPLib.GetProperty(p_STATO,"","",i);
      row.SAE = CPLib.GetProperty(p_SAE,"","",i);
      row.ATECO = CPLib.GetProperty(p_ATECO,"","",i);
      row.SETSINT = CPLib.GetProperty(p_SETSINT,"","",i);
      row.NOSARA = CPLib.GetProperty(p_NOSARA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcsoggettiall1_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcsoggettiall1_mcrdef();
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
  public MemoryCursorRow_mcsoggettiall1_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcsoggettiall1_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcsoggettiall1_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettiall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcsoggettiall1_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
