// Definition generated from query qbe_wu_sblocco_vqr
public class MemoryCursor_qbe_wu_sblocco_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_wu_sblocco_vqr row;
  MemoryCursorRow_qbe_wu_sblocco_vqr empty_row;
  public MemoryCursor_qbe_wu_sblocco_vqr() {
    empty_row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_wu_sblocco_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TRXCODPRG;
    p_TRXCODPRG = new java.util.Properties();
    java.util.Properties p_TRXCODDIP;
    p_TRXCODDIP = new java.util.Properties();
    java.util.Properties p_TRXMTCN;
    p_TRXMTCN = new java.util.Properties();
    java.util.Properties p_TRXDATOPE;
    p_TRXDATOPE = new java.util.Properties();
    java.util.Properties p_TRXCOGNOM;
    p_TRXCOGNOM = new java.util.Properties();
    java.util.Properties p_TRXNOME;
    p_TRXNOME = new java.util.Properties();
    java.util.Properties p_TRXCODFIS;
    p_TRXCODFIS = new java.util.Properties();
    java.util.Properties p_TRXUTENTE;
    p_TRXUTENTE = new java.util.Properties();
    java.util.Properties p_fullname;
    p_fullname = new java.util.Properties();
    java.util.Properties p_TRXTINILAV;
    p_TRXTINILAV = new java.util.Properties();
    java.util.Properties p_TRXSCAEDT;
    p_TRXSCAEDT = new java.util.Properties();
    java.util.Properties p_SCADENZA;
    p_SCADENZA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODPRG".equalsIgnoreCase(key)) {
        p_TRXCODPRG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODDIP".equalsIgnoreCase(key)) {
        p_TRXCODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXMTCN".equalsIgnoreCase(key)) {
        p_TRXMTCN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXDATOPE".equalsIgnoreCase(key)) {
        p_TRXDATOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCOGNOM".equalsIgnoreCase(key)) {
        p_TRXCOGNOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXNOME".equalsIgnoreCase(key)) {
        p_TRXNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXCODFIS".equalsIgnoreCase(key)) {
        p_TRXCODFIS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXUTENTE".equalsIgnoreCase(key)) {
        p_TRXUTENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("fullname".equalsIgnoreCase(key)) {
        p_fullname = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXTINILAV".equalsIgnoreCase(key)) {
        p_TRXTINILAV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRXSCAEDT".equalsIgnoreCase(key)) {
        p_TRXSCAEDT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SCADENZA".equalsIgnoreCase(key)) {
        p_SCADENZA = CPLib.GetProperties(p.getProperty(key));
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
      row.TRXCODPRG = CPLib.GetProperty(p_TRXCODPRG,"",0,i);
      row.TRXCODDIP = CPLib.GetProperty(p_TRXCODDIP,"","",i);
      row.TRXMTCN = CPLib.GetProperty(p_TRXMTCN,"","",i);
      row.TRXDATOPE = CPLib.GetProperty(p_TRXDATOPE,"",CPLib.NullDate(),i);
      row.TRXCOGNOM = CPLib.GetProperty(p_TRXCOGNOM,"","",i);
      row.TRXNOME = CPLib.GetProperty(p_TRXNOME,"","",i);
      row.TRXCODFIS = CPLib.GetProperty(p_TRXCODFIS,"","",i);
      row.TRXUTENTE = CPLib.GetProperty(p_TRXUTENTE,"",0,i);
      row.fullname = CPLib.GetProperty(p_fullname,"","",i);
      row.TRXTINILAV = CPLib.GetProperty(p_TRXTINILAV,"",CPLib.NullDateTime(),i);
      row.TRXSCAEDT = CPLib.GetProperty(p_TRXSCAEDT,"",CPLib.NullDate(),i);
      row.SCADENZA = CPLib.GetProperty(p_SCADENZA,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_wu_sblocco_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_wu_sblocco_vqr();
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
  public MemoryCursorRow_qbe_wu_sblocco_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_wu_sblocco_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_wu_sblocco_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    MemoryCursorRow_qbe_wu_sblocco_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_wu_sblocco_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_wu_sblocco_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
