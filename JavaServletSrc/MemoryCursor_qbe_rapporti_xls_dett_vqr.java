// Definition generated from query qbe_rapporti_xls_dett_vqr
public class MemoryCursor_qbe_rapporti_xls_dett_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_rapporti_xls_dett_vqr row;
  MemoryCursorRow_qbe_rapporti_xls_dett_vqr empty_row;
  public MemoryCursor_qbe_rapporti_xls_dett_vqr() {
    empty_row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_rapporti_xls_dett_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_DESCRAP;
    p_DESCRAP = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_SPLITCODE;
    p_SPLITCODE = new java.util.Properties();
    java.util.Properties p_SCOPO;
    p_SCOPO = new java.util.Properties();
    java.util.Properties p_NATURA;
    p_NATURA = new java.util.Properties();
    java.util.Properties p_DATAPROF;
    p_DATAPROF = new java.util.Properties();
    java.util.Properties p_RISGLOB;
    p_RISGLOB = new java.util.Properties();
    java.util.Properties p_DATAREVPROF;
    p_DATAREVPROF = new java.util.Properties();
    java.util.Properties p_CODICELR;
    p_CODICELR = new java.util.Properties();
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
      if ("DESCRAP".equalsIgnoreCase(key)) {
        p_DESCRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SPLITCODE".equalsIgnoreCase(key)) {
        p_SPLITCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SCOPO".equalsIgnoreCase(key)) {
        p_SCOPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATURA".equalsIgnoreCase(key)) {
        p_NATURA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAPROF".equalsIgnoreCase(key)) {
        p_DATAPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RISGLOB".equalsIgnoreCase(key)) {
        p_RISGLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAREVPROF".equalsIgnoreCase(key)) {
        p_DATAREVPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICELR".equalsIgnoreCase(key)) {
        p_CODICELR = CPLib.GetProperties(p.getProperty(key));
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
      row.DESCRAP = CPLib.GetProperty(p_DESCRAP,"","",i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.SPLITCODE = CPLib.GetProperty(p_SPLITCODE,"","",i);
      row.SCOPO = CPLib.GetProperty(p_SCOPO,"","",i);
      row.NATURA = CPLib.GetProperty(p_NATURA,"","",i);
      row.DATAPROF = CPLib.GetProperty(p_DATAPROF,"",CPLib.NullDate(),i);
      row.RISGLOB = CPLib.GetProperty(p_RISGLOB,"","",i);
      row.DATAREVPROF = CPLib.GetProperty(p_DATAREVPROF,"",CPLib.NullDate(),i);
      row.CODICELR = CPLib.GetProperty(p_CODICELR,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_rapporti_xls_dett_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
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
  public MemoryCursorRow_qbe_rapporti_xls_dett_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_rapporti_xls_dett_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_rapporti_xls_dett_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    MemoryCursorRow_qbe_rapporti_xls_dett_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_rapporti_xls_dett_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_rapporti_xls_dett_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
