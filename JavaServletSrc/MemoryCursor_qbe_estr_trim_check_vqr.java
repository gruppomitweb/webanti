// Definition generated from query qbe_estr_trim_check_vqr
public class MemoryCursor_qbe_estr_trim_check_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_estr_trim_check_vqr row;
  MemoryCursorRow_qbe_estr_trim_check_vqr empty_row;
  public MemoryCursor_qbe_estr_trim_check_vqr() {
    empty_row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_estr_trim_check_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_TIPOSOGGETTO;
    p_TIPOSOGGETTO = new java.util.Properties();
    java.util.Properties p_RAPSEGNA;
    p_RAPSEGNA = new java.util.Properties();
    java.util.Properties p_CODICEGLN;
    p_CODICEGLN = new java.util.Properties();
    java.util.Properties p_ABIINTER;
    p_ABIINTER = new java.util.Properties();
    java.util.Properties p_ABIPROPR;
    p_ABIPROPR = new java.util.Properties();
    java.util.Properties p_TIPOATTIV;
    p_TIPOATTIV = new java.util.Properties();
    java.util.Properties p_GLNALTRASC;
    p_GLNALTRASC = new java.util.Properties();
    java.util.Properties p_GLNALTROSOG;
    p_GLNALTROSOG = new java.util.Properties();
    java.util.Properties p_CODCLICON;
    p_CODCLICON = new java.util.Properties();
    java.util.Properties p_CODCOMCON;
    p_CODCOMCON = new java.util.Properties();
    java.util.Properties p_ATECO_CON;
    p_ATECO_CON = new java.util.Properties();
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_ATTIV;
    p_ATTIV = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
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
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSOGGETTO".equalsIgnoreCase(key)) {
        p_TIPOSOGGETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPSEGNA".equalsIgnoreCase(key)) {
        p_RAPSEGNA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICEGLN".equalsIgnoreCase(key)) {
        p_CODICEGLN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABIINTER".equalsIgnoreCase(key)) {
        p_ABIINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABIPROPR".equalsIgnoreCase(key)) {
        p_ABIPROPR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOATTIV".equalsIgnoreCase(key)) {
        p_TIPOATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("GLNALTRASC".equalsIgnoreCase(key)) {
        p_GLNALTRASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("GLNALTROSOG".equalsIgnoreCase(key)) {
        p_GLNALTROSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCLICON".equalsIgnoreCase(key)) {
        p_CODCLICON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCOMCON".equalsIgnoreCase(key)) {
        p_CODCOMCON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECO_CON".equalsIgnoreCase(key)) {
        p_ATECO_CON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTIV".equalsIgnoreCase(key)) {
        p_ATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
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
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.TIPOSOGGETTO = CPLib.GetProperty(p_TIPOSOGGETTO,"","",i);
      row.RAPSEGNA = CPLib.GetProperty(p_RAPSEGNA,"","",i);
      row.CODICEGLN = CPLib.GetProperty(p_CODICEGLN,"","",i);
      row.ABIINTER = CPLib.GetProperty(p_ABIINTER,"","",i);
      row.ABIPROPR = CPLib.GetProperty(p_ABIPROPR,"","",i);
      row.TIPOATTIV = CPLib.GetProperty(p_TIPOATTIV,"","",i);
      row.GLNALTRASC = CPLib.GetProperty(p_GLNALTRASC,"","",i);
      row.GLNALTROSOG = CPLib.GetProperty(p_GLNALTROSOG,"","",i);
      row.CODCLICON = CPLib.GetProperty(p_CODCLICON,"","",i);
      row.CODCOMCON = CPLib.GetProperty(p_CODCOMCON,"","",i);
      row.ATECO_CON = CPLib.GetProperty(p_ATECO_CON,"","",i);
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.ATTIV = CPLib.GetProperty(p_ATTIV,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.NATURA = CPLib.GetProperty(p_NATURA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_estr_trim_check_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_estr_trim_check_vqr();
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
  public MemoryCursorRow_qbe_estr_trim_check_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_estr_trim_check_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_estr_trim_check_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    MemoryCursorRow_qbe_estr_trim_check_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_estr_trim_check_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_estr_trim_check_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
