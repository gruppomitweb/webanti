// Definition generated from record definition mca7_mcrdef
public class MemoryCursor_mca7_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mca7_mcrdef row;
  MemoryCursorRow_mca7_mcrdef empty_row;
  public MemoryCursor_mca7_mcrdef() {
    empty_row = new MemoryCursorRow_mca7_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mca7_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDFENOMENO;
    p_IDFENOMENO = new java.util.Properties();
    java.util.Properties p_IMPORTO;
    p_IMPORTO = new java.util.Properties();
    java.util.Properties p_DURATA;
    p_DURATA = new java.util.Properties();
    java.util.Properties p_DIVISA;
    p_DIVISA = new java.util.Properties();
    java.util.Properties p_RESIDENZA;
    p_RESIDENZA = new java.util.Properties();
    java.util.Properties p_ATTR0;
    p_ATTR0 = new java.util.Properties();
    java.util.Properties p_DATO0;
    p_DATO0 = new java.util.Properties();
    java.util.Properties p_ATTR1;
    p_ATTR1 = new java.util.Properties();
    java.util.Properties p_DATO1;
    p_DATO1 = new java.util.Properties();
    java.util.Properties p_ATTR2;
    p_ATTR2 = new java.util.Properties();
    java.util.Properties p_DATO2;
    p_DATO2 = new java.util.Properties();
    java.util.Properties p_ATTR3;
    p_ATTR3 = new java.util.Properties();
    java.util.Properties p_DATO3;
    p_DATO3 = new java.util.Properties();
    java.util.Properties p_ATTR4;
    p_ATTR4 = new java.util.Properties();
    java.util.Properties p_DATO4;
    p_DATO4 = new java.util.Properties();
    java.util.Properties p_ATTR5;
    p_ATTR5 = new java.util.Properties();
    java.util.Properties p_DATO5;
    p_DATO5 = new java.util.Properties();
    java.util.Properties p_ATTR6;
    p_ATTR6 = new java.util.Properties();
    java.util.Properties p_DATO6;
    p_DATO6 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFENOMENO".equalsIgnoreCase(key)) {
        p_IDFENOMENO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO".equalsIgnoreCase(key)) {
        p_IMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DURATA".equalsIgnoreCase(key)) {
        p_DURATA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DIVISA".equalsIgnoreCase(key)) {
        p_DIVISA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RESIDENZA".equalsIgnoreCase(key)) {
        p_RESIDENZA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR0".equalsIgnoreCase(key)) {
        p_ATTR0 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO0".equalsIgnoreCase(key)) {
        p_DATO0 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR1".equalsIgnoreCase(key)) {
        p_ATTR1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO1".equalsIgnoreCase(key)) {
        p_DATO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR2".equalsIgnoreCase(key)) {
        p_ATTR2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO2".equalsIgnoreCase(key)) {
        p_DATO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR3".equalsIgnoreCase(key)) {
        p_ATTR3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO3".equalsIgnoreCase(key)) {
        p_DATO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR4".equalsIgnoreCase(key)) {
        p_ATTR4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO4".equalsIgnoreCase(key)) {
        p_DATO4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR5".equalsIgnoreCase(key)) {
        p_ATTR5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO5".equalsIgnoreCase(key)) {
        p_DATO5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTR6".equalsIgnoreCase(key)) {
        p_ATTR6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATO6".equalsIgnoreCase(key)) {
        p_DATO6 = CPLib.GetProperties(p.getProperty(key));
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
      row.IDFENOMENO = CPLib.GetProperty(p_IDFENOMENO,"","",i);
      row.IMPORTO = CPLib.GetProperty(p_IMPORTO,"",0,i);
      row.DURATA = CPLib.GetProperty(p_DURATA,"","",i);
      row.DIVISA = CPLib.GetProperty(p_DIVISA,"","",i);
      row.RESIDENZA = CPLib.GetProperty(p_RESIDENZA,"","",i);
      row.ATTR0 = CPLib.GetProperty(p_ATTR0,"","",i);
      row.DATO0 = CPLib.GetProperty(p_DATO0,"","",i);
      row.ATTR1 = CPLib.GetProperty(p_ATTR1,"","",i);
      row.DATO1 = CPLib.GetProperty(p_DATO1,"","",i);
      row.ATTR2 = CPLib.GetProperty(p_ATTR2,"","",i);
      row.DATO2 = CPLib.GetProperty(p_DATO2,"","",i);
      row.ATTR3 = CPLib.GetProperty(p_ATTR3,"","",i);
      row.DATO3 = CPLib.GetProperty(p_DATO3,"","",i);
      row.ATTR4 = CPLib.GetProperty(p_ATTR4,"","",i);
      row.DATO4 = CPLib.GetProperty(p_DATO4,"","",i);
      row.ATTR5 = CPLib.GetProperty(p_ATTR5,"","",i);
      row.DATO5 = CPLib.GetProperty(p_DATO5,"","",i);
      row.ATTR6 = CPLib.GetProperty(p_ATTR6,"","",i);
      row.DATO6 = CPLib.GetProperty(p_DATO6,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mca7_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mca7_mcrdef();
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
  public MemoryCursorRow_mca7_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mca7_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mca7_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mca7_mcrdef p_Row) {
    MemoryCursorRow_mca7_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mca7_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mca7_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mca7_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
