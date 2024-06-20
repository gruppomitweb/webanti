// Definition generated from table detta7
public class MemoryCursor_detta7 extends CPMemoryCursor {
  MemoryCursorRow_detta7 row;
  MemoryCursorRow_detta7 empty_row;
  public MemoryCursor_detta7() {
    empty_row = new MemoryCursorRow_detta7();
    row = empty_row;
  }
  public MemoryCursor_detta7(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_ANNO;
    p_ANNO = new java.util.Properties();
    java.util.Properties p_SEMESTRE;
    p_SEMESTRE = new java.util.Properties();
    java.util.Properties p_CPROWNUM;
    p_CPROWNUM = new java.util.Properties();
    java.util.Properties p_VOCE;
    p_VOCE = new java.util.Properties();
    java.util.Properties p_SOTTOVOCE;
    p_SOTTOVOCE = new java.util.Properties();
    java.util.Properties p_RESID;
    p_RESID = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_STATO;
    p_STATO = new java.util.Properties();
    java.util.Properties p_VAL01217;
    p_VAL01217 = new java.util.Properties();
    java.util.Properties p_VAL02147;
    p_VAL02147 = new java.util.Properties();
    java.util.Properties p_VAL02148;
    p_VAL02148 = new java.util.Properties();
    java.util.Properties p_VAL02149;
    p_VAL02149 = new java.util.Properties();
    java.util.Properties p_DATAEFF;
    p_DATAEFF = new java.util.Properties();
    java.util.Properties p_IMPORTO;
    p_IMPORTO = new java.util.Properties();
    java.util.Properties p_IDBASEA7;
    p_IDBASEA7 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNO".equalsIgnoreCase(key)) {
        p_ANNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEMESTRE".equalsIgnoreCase(key)) {
        p_SEMESTRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CPROWNUM".equalsIgnoreCase(key)) {
        p_CPROWNUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VOCE".equalsIgnoreCase(key)) {
        p_VOCE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTTOVOCE".equalsIgnoreCase(key)) {
        p_SOTTOVOCE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RESID".equalsIgnoreCase(key)) {
        p_RESID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATO".equalsIgnoreCase(key)) {
        p_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VAL01217".equalsIgnoreCase(key)) {
        p_VAL01217 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VAL02147".equalsIgnoreCase(key)) {
        p_VAL02147 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VAL02148".equalsIgnoreCase(key)) {
        p_VAL02148 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VAL02149".equalsIgnoreCase(key)) {
        p_VAL02149 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAEFF".equalsIgnoreCase(key)) {
        p_DATAEFF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO".equalsIgnoreCase(key)) {
        p_IMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASEA7".equalsIgnoreCase(key)) {
        p_IDBASEA7 = CPLib.GetProperties(p.getProperty(key));
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
      row.ANNO = CPLib.GetProperty(p_ANNO,"","",i);
      row.SEMESTRE = CPLib.GetProperty(p_SEMESTRE,"","",i);
      row.CPROWNUM = CPLib.GetProperty(p_CPROWNUM,"",0,i);
      row.VOCE = CPLib.GetProperty(p_VOCE,"","",i);
      row.SOTTOVOCE = CPLib.GetProperty(p_SOTTOVOCE,"","",i);
      row.RESID = CPLib.GetProperty(p_RESID,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.STATO = CPLib.GetProperty(p_STATO,"","",i);
      row.VAL01217 = CPLib.GetProperty(p_VAL01217,"","",i);
      row.VAL02147 = CPLib.GetProperty(p_VAL02147,"","",i);
      row.VAL02148 = CPLib.GetProperty(p_VAL02148,"",CPLib.NullDate(),i);
      row.VAL02149 = CPLib.GetProperty(p_VAL02149,"","",i);
      row.DATAEFF = CPLib.GetProperty(p_DATAEFF,"",CPLib.NullDate(),i);
      row.IMPORTO = CPLib.GetProperty(p_IMPORTO,"",0,i);
      row.IDBASEA7 = CPLib.GetProperty(p_IDBASEA7,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_detta7)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_detta7();
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
  public MemoryCursorRow_detta7 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_detta7 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_detta7> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_detta7 p_Row) {
    MemoryCursorRow_detta7 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_detta7();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_detta7 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_detta7();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
