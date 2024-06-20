// Definition generated from table processi
public class MemoryCursor_processi extends CPMemoryCursor {
  MemoryCursorRow_processi row;
  MemoryCursorRow_processi empty_row;
  public MemoryCursor_processi() {
    empty_row = new MemoryCursorRow_processi();
    row = empty_row;
  }
  public MemoryCursor_processi(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_PR_TIPO;
    p_PR_TIPO = new java.util.Properties();
    java.util.Properties p_PRCODICE;
    p_PRCODICE = new java.util.Properties();
    java.util.Properties p_PRDESCRI;
    p_PRDESCRI = new java.util.Properties();
    java.util.Properties p_PRDOSTART;
    p_PRDOSTART = new java.util.Properties();
    java.util.Properties p_PRDOSTOP;
    p_PRDOSTOP = new java.util.Properties();
    java.util.Properties p_PRESITO;
    p_PRESITO = new java.util.Properties();
    java.util.Properties p_PRFILEOUT;
    p_PRFILEOUT = new java.util.Properties();
    java.util.Properties p_PTRIPOOUT;
    p_PTRIPOOUT = new java.util.Properties();
    java.util.Properties p_PRGMSGSTA;
    p_PRGMSGSTA = new java.util.Properties();
    java.util.Properties p_PRNOMEFILE;
    p_PRNOMEFILE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PR_TIPO".equalsIgnoreCase(key)) {
        p_PR_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRCODICE".equalsIgnoreCase(key)) {
        p_PRCODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRDESCRI".equalsIgnoreCase(key)) {
        p_PRDESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRDOSTART".equalsIgnoreCase(key)) {
        p_PRDOSTART = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRDOSTOP".equalsIgnoreCase(key)) {
        p_PRDOSTOP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRESITO".equalsIgnoreCase(key)) {
        p_PRESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRFILEOUT".equalsIgnoreCase(key)) {
        p_PRFILEOUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PTRIPOOUT".equalsIgnoreCase(key)) {
        p_PTRIPOOUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRGMSGSTA".equalsIgnoreCase(key)) {
        p_PRGMSGSTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRNOMEFILE".equalsIgnoreCase(key)) {
        p_PRNOMEFILE = CPLib.GetProperties(p.getProperty(key));
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
      row.PR_TIPO = CPLib.GetProperty(p_PR_TIPO,"","",i);
      row.PRCODICE = CPLib.GetProperty(p_PRCODICE,"","",i);
      row.PRDESCRI = CPLib.GetProperty(p_PRDESCRI,"","",i);
      row.PRDOSTART = CPLib.GetProperty(p_PRDOSTART,"",CPLib.NullDateTime(),i);
      row.PRDOSTOP = CPLib.GetProperty(p_PRDOSTOP,"",CPLib.NullDateTime(),i);
      row.PRESITO = CPLib.GetProperty(p_PRESITO,"","",i);
      row.PRFILEOUT = CPLib.GetProperty(p_PRFILEOUT,"","",i);
      row.PTRIPOOUT = CPLib.GetProperty(p_PTRIPOOUT,"","",i);
      row.PRGMSGSTA = CPLib.GetProperty(p_PRGMSGSTA,"","",i);
      row.PRNOMEFILE = CPLib.GetProperty(p_PRNOMEFILE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_processi)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_processi();
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
  public MemoryCursorRow_processi _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_processi _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_processi> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_processi p_Row) {
    MemoryCursorRow_processi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_processi();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_processi p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_processi();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
