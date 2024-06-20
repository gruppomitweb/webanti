// Definition generated from record definition mcrowserrori_mcrdef
public class MemoryCursor_mcrowserrori_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcrowserrori_mcrdef row;
  MemoryCursorRow_mcrowserrori_mcrdef empty_row;
  public MemoryCursor_mcrowserrori_mcrdef() {
    empty_row = new MemoryCursorRow_mcrowserrori_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcrowserrori_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_colonna01;
    p_colonna01 = new java.util.Properties();
    java.util.Properties p_colonna02;
    p_colonna02 = new java.util.Properties();
    java.util.Properties p_colonna03;
    p_colonna03 = new java.util.Properties();
    java.util.Properties p_colonna04;
    p_colonna04 = new java.util.Properties();
    java.util.Properties p_colonna05;
    p_colonna05 = new java.util.Properties();
    java.util.Properties p_colonna06;
    p_colonna06 = new java.util.Properties();
    java.util.Properties p_colonna07;
    p_colonna07 = new java.util.Properties();
    java.util.Properties p_colonna08;
    p_colonna08 = new java.util.Properties();
    java.util.Properties p_colonna09;
    p_colonna09 = new java.util.Properties();
    java.util.Properties p_colonna10;
    p_colonna10 = new java.util.Properties();
    java.util.Properties p_colonna11;
    p_colonna11 = new java.util.Properties();
    java.util.Properties p_colonna12;
    p_colonna12 = new java.util.Properties();
    java.util.Properties p_colonna13;
    p_colonna13 = new java.util.Properties();
    java.util.Properties p_colonna14;
    p_colonna14 = new java.util.Properties();
    java.util.Properties p_colonna15;
    p_colonna15 = new java.util.Properties();
    java.util.Properties p_colonna16;
    p_colonna16 = new java.util.Properties();
    java.util.Properties p_colonna17;
    p_colonna17 = new java.util.Properties();
    java.util.Properties p_colonna18;
    p_colonna18 = new java.util.Properties();
    java.util.Properties p_colonna19;
    p_colonna19 = new java.util.Properties();
    java.util.Properties p_colonna20;
    p_colonna20 = new java.util.Properties();
    java.util.Properties p_colonna21;
    p_colonna21 = new java.util.Properties();
    java.util.Properties p_colonna22;
    p_colonna22 = new java.util.Properties();
    java.util.Properties p_colonna23;
    p_colonna23 = new java.util.Properties();
    java.util.Properties p_colonna24;
    p_colonna24 = new java.util.Properties();
    java.util.Properties p_colonna25;
    p_colonna25 = new java.util.Properties();
    java.util.Properties p_colonna26;
    p_colonna26 = new java.util.Properties();
    java.util.Properties p_colonna27;
    p_colonna27 = new java.util.Properties();
    java.util.Properties p_colonna28;
    p_colonna28 = new java.util.Properties();
    java.util.Properties p_colonna29;
    p_colonna29 = new java.util.Properties();
    java.util.Properties p_colonna30;
    p_colonna30 = new java.util.Properties();
    java.util.Properties p_colonna31;
    p_colonna31 = new java.util.Properties();
    java.util.Properties p_colonna32;
    p_colonna32 = new java.util.Properties();
    java.util.Properties p_colonna33;
    p_colonna33 = new java.util.Properties();
    java.util.Properties p_colonna34;
    p_colonna34 = new java.util.Properties();
    java.util.Properties p_flgforza;
    p_flgforza = new java.util.Properties();
    java.util.Properties p_Errore;
    p_Errore = new java.util.Properties();
    java.util.Properties p_colonna35;
    p_colonna35 = new java.util.Properties();
    java.util.Properties p_colonna36;
    p_colonna36 = new java.util.Properties();
    java.util.Properties p_colonna37;
    p_colonna37 = new java.util.Properties();
    java.util.Properties p_colonna38;
    p_colonna38 = new java.util.Properties();
    java.util.Properties p_colonna39;
    p_colonna39 = new java.util.Properties();
    java.util.Properties p_colonna40;
    p_colonna40 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna01".equalsIgnoreCase(key)) {
        p_colonna01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna02".equalsIgnoreCase(key)) {
        p_colonna02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna03".equalsIgnoreCase(key)) {
        p_colonna03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna04".equalsIgnoreCase(key)) {
        p_colonna04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna05".equalsIgnoreCase(key)) {
        p_colonna05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna06".equalsIgnoreCase(key)) {
        p_colonna06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna07".equalsIgnoreCase(key)) {
        p_colonna07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna08".equalsIgnoreCase(key)) {
        p_colonna08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna09".equalsIgnoreCase(key)) {
        p_colonna09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna10".equalsIgnoreCase(key)) {
        p_colonna10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna11".equalsIgnoreCase(key)) {
        p_colonna11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna12".equalsIgnoreCase(key)) {
        p_colonna12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna13".equalsIgnoreCase(key)) {
        p_colonna13 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna14".equalsIgnoreCase(key)) {
        p_colonna14 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna15".equalsIgnoreCase(key)) {
        p_colonna15 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna16".equalsIgnoreCase(key)) {
        p_colonna16 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna17".equalsIgnoreCase(key)) {
        p_colonna17 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna18".equalsIgnoreCase(key)) {
        p_colonna18 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna19".equalsIgnoreCase(key)) {
        p_colonna19 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna20".equalsIgnoreCase(key)) {
        p_colonna20 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna21".equalsIgnoreCase(key)) {
        p_colonna21 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna22".equalsIgnoreCase(key)) {
        p_colonna22 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna23".equalsIgnoreCase(key)) {
        p_colonna23 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna24".equalsIgnoreCase(key)) {
        p_colonna24 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna25".equalsIgnoreCase(key)) {
        p_colonna25 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna26".equalsIgnoreCase(key)) {
        p_colonna26 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna27".equalsIgnoreCase(key)) {
        p_colonna27 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna28".equalsIgnoreCase(key)) {
        p_colonna28 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna29".equalsIgnoreCase(key)) {
        p_colonna29 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna30".equalsIgnoreCase(key)) {
        p_colonna30 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna31".equalsIgnoreCase(key)) {
        p_colonna31 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna32".equalsIgnoreCase(key)) {
        p_colonna32 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna33".equalsIgnoreCase(key)) {
        p_colonna33 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna34".equalsIgnoreCase(key)) {
        p_colonna34 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("flgforza".equalsIgnoreCase(key)) {
        p_flgforza = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Errore".equalsIgnoreCase(key)) {
        p_Errore = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna35".equalsIgnoreCase(key)) {
        p_colonna35 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna36".equalsIgnoreCase(key)) {
        p_colonna36 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna37".equalsIgnoreCase(key)) {
        p_colonna37 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna38".equalsIgnoreCase(key)) {
        p_colonna38 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna39".equalsIgnoreCase(key)) {
        p_colonna39 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("colonna40".equalsIgnoreCase(key)) {
        p_colonna40 = CPLib.GetProperties(p.getProperty(key));
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
      row.colonna01 = CPLib.GetProperty(p_colonna01,"","",i);
      row.colonna02 = CPLib.GetProperty(p_colonna02,"","",i);
      row.colonna03 = CPLib.GetProperty(p_colonna03,"","",i);
      row.colonna04 = CPLib.GetProperty(p_colonna04,"","",i);
      row.colonna05 = CPLib.GetProperty(p_colonna05,"","",i);
      row.colonna06 = CPLib.GetProperty(p_colonna06,"","",i);
      row.colonna07 = CPLib.GetProperty(p_colonna07,"","",i);
      row.colonna08 = CPLib.GetProperty(p_colonna08,"","",i);
      row.colonna09 = CPLib.GetProperty(p_colonna09,"",0,i);
      row.colonna10 = CPLib.GetProperty(p_colonna10,"","",i);
      row.colonna11 = CPLib.GetProperty(p_colonna11,"",0,i);
      row.colonna12 = CPLib.GetProperty(p_colonna12,"","",i);
      row.colonna13 = CPLib.GetProperty(p_colonna13,"","",i);
      row.colonna14 = CPLib.GetProperty(p_colonna14,"","",i);
      row.colonna15 = CPLib.GetProperty(p_colonna15,"","",i);
      row.colonna16 = CPLib.GetProperty(p_colonna16,"","",i);
      row.colonna17 = CPLib.GetProperty(p_colonna17,"","",i);
      row.colonna18 = CPLib.GetProperty(p_colonna18,"","",i);
      row.colonna19 = CPLib.GetProperty(p_colonna19,"","",i);
      row.colonna20 = CPLib.GetProperty(p_colonna20,"","",i);
      row.colonna21 = CPLib.GetProperty(p_colonna21,"","",i);
      row.colonna22 = CPLib.GetProperty(p_colonna22,"","",i);
      row.colonna23 = CPLib.GetProperty(p_colonna23,"","",i);
      row.colonna24 = CPLib.GetProperty(p_colonna24,"","",i);
      row.colonna25 = CPLib.GetProperty(p_colonna25,"","",i);
      row.colonna26 = CPLib.GetProperty(p_colonna26,"","",i);
      row.colonna27 = CPLib.GetProperty(p_colonna27,"","",i);
      row.colonna28 = CPLib.GetProperty(p_colonna28,"","",i);
      row.colonna29 = CPLib.GetProperty(p_colonna29,"","",i);
      row.colonna30 = CPLib.GetProperty(p_colonna30,"","",i);
      row.colonna31 = CPLib.GetProperty(p_colonna31,"","",i);
      row.colonna32 = CPLib.GetProperty(p_colonna32,"","",i);
      row.colonna33 = CPLib.GetProperty(p_colonna33,"","",i);
      row.colonna34 = CPLib.GetProperty(p_colonna34,"","",i);
      row.flgforza = CPLib.GetProperty(p_flgforza,"","",i);
      row.Errore = CPLib.GetProperty(p_Errore,"","",i);
      row.colonna35 = CPLib.GetProperty(p_colonna35,"","",i);
      row.colonna36 = CPLib.GetProperty(p_colonna36,"","",i);
      row.colonna37 = CPLib.GetProperty(p_colonna37,"","",i);
      row.colonna38 = CPLib.GetProperty(p_colonna38,"","",i);
      row.colonna39 = CPLib.GetProperty(p_colonna39,"","",i);
      row.colonna40 = CPLib.GetProperty(p_colonna40,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcrowserrori_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcrowserrori_mcrdef();
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
  public MemoryCursorRow_mcrowserrori_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcrowserrori_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcrowserrori_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    MemoryCursorRow_mcrowserrori_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrowserrori_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcrowserrori_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcrowserrori_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
