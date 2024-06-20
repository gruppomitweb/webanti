// Definition generated from table sottovocea7
public class MemoryCursor_sottovocea7 extends CPMemoryCursor {
  MemoryCursorRow_sottovocea7 row;
  MemoryCursorRow_sottovocea7 empty_row;
  public MemoryCursor_sottovocea7() {
    empty_row = new MemoryCursorRow_sottovocea7();
    row = empty_row;
  }
  public MemoryCursor_sottovocea7(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_VOCE;
    p_VOCE = new java.util.Properties();
    java.util.Properties p_SOTTOVOCE;
    p_SOTTOVOCE = new java.util.Properties();
    java.util.Properties p_DESCRI;
    p_DESCRI = new java.util.Properties();
    java.util.Properties p_FLGRESID;
    p_FLGRESID = new java.util.Properties();
    java.util.Properties p_FLG00015;
    p_FLG00015 = new java.util.Properties();
    java.util.Properties p_FLG00016;
    p_FLG00016 = new java.util.Properties();
    java.util.Properties p_FLG01217;
    p_FLG01217 = new java.util.Properties();
    java.util.Properties p_FLG02147;
    p_FLG02147 = new java.util.Properties();
    java.util.Properties p_FLG02148;
    p_FLG02148 = new java.util.Properties();
    java.util.Properties p_FLG02149;
    p_FLG02149 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VOCE".equalsIgnoreCase(key)) {
        p_VOCE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTTOVOCE".equalsIgnoreCase(key)) {
        p_SOTTOVOCE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRI".equalsIgnoreCase(key)) {
        p_DESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGRESID".equalsIgnoreCase(key)) {
        p_FLGRESID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG00015".equalsIgnoreCase(key)) {
        p_FLG00015 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG00016".equalsIgnoreCase(key)) {
        p_FLG00016 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG01217".equalsIgnoreCase(key)) {
        p_FLG01217 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG02147".equalsIgnoreCase(key)) {
        p_FLG02147 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG02148".equalsIgnoreCase(key)) {
        p_FLG02148 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLG02149".equalsIgnoreCase(key)) {
        p_FLG02149 = CPLib.GetProperties(p.getProperty(key));
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
      row.VOCE = CPLib.GetProperty(p_VOCE,"","",i);
      row.SOTTOVOCE = CPLib.GetProperty(p_SOTTOVOCE,"","",i);
      row.DESCRI = CPLib.GetProperty(p_DESCRI,"","",i);
      row.FLGRESID = CPLib.GetProperty(p_FLGRESID,"","",i);
      row.FLG00015 = CPLib.GetProperty(p_FLG00015,"","",i);
      row.FLG00016 = CPLib.GetProperty(p_FLG00016,"","",i);
      row.FLG01217 = CPLib.GetProperty(p_FLG01217,"","",i);
      row.FLG02147 = CPLib.GetProperty(p_FLG02147,"","",i);
      row.FLG02148 = CPLib.GetProperty(p_FLG02148,"","",i);
      row.FLG02149 = CPLib.GetProperty(p_FLG02149,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sottovocea7)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sottovocea7();
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
  public MemoryCursorRow_sottovocea7 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sottovocea7 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sottovocea7> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sottovocea7 p_Row) {
    MemoryCursorRow_sottovocea7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sottovocea7();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sottovocea7 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sottovocea7();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
