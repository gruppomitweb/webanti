// Definition generated from table tbcauana
public class MemoryCursor_tbcauana extends CPMemoryCursor {
  MemoryCursorRow_tbcauana row;
  MemoryCursorRow_tbcauana empty_row;
  public MemoryCursor_tbcauana() {
    empty_row = new MemoryCursorRow_tbcauana();
    row = empty_row;
  }
  public MemoryCursor_tbcauana(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_idbase;
    p_idbase = new java.util.Properties();
    java.util.Properties p_DESCRI;
    p_DESCRI = new java.util.Properties();
    java.util.Properties p_CODCAU;
    p_CODCAU = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_CAUSINT;
    p_CAUSINT = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties p_VALPERINT;
    p_VALPERINT = new java.util.Properties();
    java.util.Properties p_DATINI;
    p_DATINI = new java.util.Properties();
    java.util.Properties p_FLGINTER;
    p_FLGINTER = new java.util.Properties();
    java.util.Properties p_MITBASE;
    p_MITBASE = new java.util.Properties();
    java.util.Properties p_USEBASE;
    p_USEBASE = new java.util.Properties();
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
      if ("idbase".equalsIgnoreCase(key)) {
        p_idbase = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRI".equalsIgnoreCase(key)) {
        p_DESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAU".equalsIgnoreCase(key)) {
        p_CODCAU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAUSINT".equalsIgnoreCase(key)) {
        p_CAUSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALPERINT".equalsIgnoreCase(key)) {
        p_VALPERINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATINI".equalsIgnoreCase(key)) {
        p_DATINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGINTER".equalsIgnoreCase(key)) {
        p_FLGINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MITBASE".equalsIgnoreCase(key)) {
        p_MITBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("USEBASE".equalsIgnoreCase(key)) {
        p_USEBASE = CPLib.GetProperties(p.getProperty(key));
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
      row.idbase = CPLib.GetProperty(p_idbase,"","",i);
      row.DESCRI = CPLib.GetProperty(p_DESCRI,"","",i);
      row.CODCAU = CPLib.GetProperty(p_CODCAU,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.CAUSINT = CPLib.GetProperty(p_CAUSINT,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
      row.VALPERINT = CPLib.GetProperty(p_VALPERINT,"","",i);
      row.DATINI = CPLib.GetProperty(p_DATINI,"",CPLib.NullDate(),i);
      row.FLGINTER = CPLib.GetProperty(p_FLGINTER,"","",i);
      row.MITBASE = CPLib.GetProperty(p_MITBASE,"","",i);
      row.USEBASE = CPLib.GetProperty(p_USEBASE,"","",i);
      row.NOSARA = CPLib.GetProperty(p_NOSARA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbcauana)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbcauana();
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
  public MemoryCursorRow_tbcauana _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbcauana _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbcauana> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbcauana p_Row) {
    MemoryCursorRow_tbcauana l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbcauana();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbcauana p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbcauana();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
