// Definition generated from query qbe_setsin_vqr
public class MemoryCursor_qbe_setsin_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_setsin_vqr row;
  MemoryCursorRow_qbe_setsin_vqr empty_row;
  public MemoryCursor_qbe_setsin_vqr() {
    empty_row = new MemoryCursorRow_qbe_setsin_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_setsin_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_SETSINT;
    p_SETSINT = new java.util.Properties();
    java.util.Properties p_DESCRI;
    p_DESCRI = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_DAGRU1;
    p_DAGRU1 = new java.util.Properties();
    java.util.Properties p_AGRU1;
    p_AGRU1 = new java.util.Properties();
    java.util.Properties p_DAGRU2;
    p_DAGRU2 = new java.util.Properties();
    java.util.Properties p_AGRU2;
    p_AGRU2 = new java.util.Properties();
    java.util.Properties p_DAGRU3;
    p_DAGRU3 = new java.util.Properties();
    java.util.Properties p_AGRU3;
    p_AGRU3 = new java.util.Properties();
    java.util.Properties p_DAGRU4;
    p_DAGRU4 = new java.util.Properties();
    java.util.Properties p_AGRU4;
    p_AGRU4 = new java.util.Properties();
    java.util.Properties p_DAGRU5;
    p_DAGRU5 = new java.util.Properties();
    java.util.Properties p_AGRU5;
    p_AGRU5 = new java.util.Properties();
    java.util.Properties p_DAGRU6;
    p_DAGRU6 = new java.util.Properties();
    java.util.Properties p_AGRU6;
    p_AGRU6 = new java.util.Properties();
    java.util.Properties p_DASOT1;
    p_DASOT1 = new java.util.Properties();
    java.util.Properties p_ASOT1;
    p_ASOT1 = new java.util.Properties();
    java.util.Properties p_DASOT2;
    p_DASOT2 = new java.util.Properties();
    java.util.Properties p_ASOT2;
    p_ASOT2 = new java.util.Properties();
    java.util.Properties p_DASOT3;
    p_DASOT3 = new java.util.Properties();
    java.util.Properties p_ASOT3;
    p_ASOT3 = new java.util.Properties();
    java.util.Properties p_DASOT4;
    p_DASOT4 = new java.util.Properties();
    java.util.Properties p_ASOT4;
    p_ASOT4 = new java.util.Properties();
    java.util.Properties p_DASOT5;
    p_DASOT5 = new java.util.Properties();
    java.util.Properties p_ASOT5;
    p_ASOT5 = new java.util.Properties();
    java.util.Properties p_DASOT6;
    p_DASOT6 = new java.util.Properties();
    java.util.Properties p_ASOT6;
    p_ASOT6 = new java.util.Properties();
    java.util.Properties p_DASOT7;
    p_DASOT7 = new java.util.Properties();
    java.util.Properties p_ASOT7;
    p_ASOT7 = new java.util.Properties();
    java.util.Properties p_DASOT8;
    p_DASOT8 = new java.util.Properties();
    java.util.Properties p_ASOT8;
    p_ASOT8 = new java.util.Properties();
    java.util.Properties p_DASOT9;
    p_DASOT9 = new java.util.Properties();
    java.util.Properties p_ASOT9;
    p_ASOT9 = new java.util.Properties();
    java.util.Properties p_DASOT10;
    p_DASOT10 = new java.util.Properties();
    java.util.Properties p_ASOT10;
    p_ASOT10 = new java.util.Properties();
    java.util.Properties p_DASOT11;
    p_DASOT11 = new java.util.Properties();
    java.util.Properties p_ASOT11;
    p_ASOT11 = new java.util.Properties();
    java.util.Properties p_DASOT12;
    p_DASOT12 = new java.util.Properties();
    java.util.Properties p_ASOT12;
    p_ASOT12 = new java.util.Properties();
    java.util.Properties p_DAATE1;
    p_DAATE1 = new java.util.Properties();
    java.util.Properties p_AATE1;
    p_AATE1 = new java.util.Properties();
    java.util.Properties p_DAATE2;
    p_DAATE2 = new java.util.Properties();
    java.util.Properties p_AATE2;
    p_AATE2 = new java.util.Properties();
    java.util.Properties p_DAATE3;
    p_DAATE3 = new java.util.Properties();
    java.util.Properties p_AATE3;
    p_AATE3 = new java.util.Properties();
    java.util.Properties p_DAATE4;
    p_DAATE4 = new java.util.Properties();
    java.util.Properties p_AATE4;
    p_AATE4 = new java.util.Properties();
    java.util.Properties p_DAATE5;
    p_DAATE5 = new java.util.Properties();
    java.util.Properties p_AATE5;
    p_AATE5 = new java.util.Properties();
    java.util.Properties p_DAATE6;
    p_DAATE6 = new java.util.Properties();
    java.util.Properties p_AATE6;
    p_AATE6 = new java.util.Properties();
    java.util.Properties p_IDSETSIN;
    p_IDSETSIN = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETSINT".equalsIgnoreCase(key)) {
        p_SETSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRI".equalsIgnoreCase(key)) {
        p_DESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU1".equalsIgnoreCase(key)) {
        p_DAGRU1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU1".equalsIgnoreCase(key)) {
        p_AGRU1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU2".equalsIgnoreCase(key)) {
        p_DAGRU2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU2".equalsIgnoreCase(key)) {
        p_AGRU2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU3".equalsIgnoreCase(key)) {
        p_DAGRU3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU3".equalsIgnoreCase(key)) {
        p_AGRU3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU4".equalsIgnoreCase(key)) {
        p_DAGRU4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU4".equalsIgnoreCase(key)) {
        p_AGRU4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU5".equalsIgnoreCase(key)) {
        p_DAGRU5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU5".equalsIgnoreCase(key)) {
        p_AGRU5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAGRU6".equalsIgnoreCase(key)) {
        p_DAGRU6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGRU6".equalsIgnoreCase(key)) {
        p_AGRU6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT1".equalsIgnoreCase(key)) {
        p_DASOT1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT1".equalsIgnoreCase(key)) {
        p_ASOT1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT2".equalsIgnoreCase(key)) {
        p_DASOT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT2".equalsIgnoreCase(key)) {
        p_ASOT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT3".equalsIgnoreCase(key)) {
        p_DASOT3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT3".equalsIgnoreCase(key)) {
        p_ASOT3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT4".equalsIgnoreCase(key)) {
        p_DASOT4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT4".equalsIgnoreCase(key)) {
        p_ASOT4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT5".equalsIgnoreCase(key)) {
        p_DASOT5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT5".equalsIgnoreCase(key)) {
        p_ASOT5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT6".equalsIgnoreCase(key)) {
        p_DASOT6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT6".equalsIgnoreCase(key)) {
        p_ASOT6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT7".equalsIgnoreCase(key)) {
        p_DASOT7 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT7".equalsIgnoreCase(key)) {
        p_ASOT7 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT8".equalsIgnoreCase(key)) {
        p_DASOT8 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT8".equalsIgnoreCase(key)) {
        p_ASOT8 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT9".equalsIgnoreCase(key)) {
        p_DASOT9 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT9".equalsIgnoreCase(key)) {
        p_ASOT9 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT10".equalsIgnoreCase(key)) {
        p_DASOT10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT10".equalsIgnoreCase(key)) {
        p_ASOT10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT11".equalsIgnoreCase(key)) {
        p_DASOT11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT11".equalsIgnoreCase(key)) {
        p_ASOT11 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DASOT12".equalsIgnoreCase(key)) {
        p_DASOT12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASOT12".equalsIgnoreCase(key)) {
        p_ASOT12 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE1".equalsIgnoreCase(key)) {
        p_DAATE1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE1".equalsIgnoreCase(key)) {
        p_AATE1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE2".equalsIgnoreCase(key)) {
        p_DAATE2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE2".equalsIgnoreCase(key)) {
        p_AATE2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE3".equalsIgnoreCase(key)) {
        p_DAATE3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE3".equalsIgnoreCase(key)) {
        p_AATE3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE4".equalsIgnoreCase(key)) {
        p_DAATE4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE4".equalsIgnoreCase(key)) {
        p_AATE4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE5".equalsIgnoreCase(key)) {
        p_DAATE5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE5".equalsIgnoreCase(key)) {
        p_AATE5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAATE6".equalsIgnoreCase(key)) {
        p_DAATE6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AATE6".equalsIgnoreCase(key)) {
        p_AATE6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDSETSIN".equalsIgnoreCase(key)) {
        p_IDSETSIN = CPLib.GetProperties(p.getProperty(key));
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
      row.SETSINT = CPLib.GetProperty(p_SETSINT,"","",i);
      row.DESCRI = CPLib.GetProperty(p_DESCRI,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.DAGRU1 = CPLib.GetProperty(p_DAGRU1,"","",i);
      row.AGRU1 = CPLib.GetProperty(p_AGRU1,"","",i);
      row.DAGRU2 = CPLib.GetProperty(p_DAGRU2,"","",i);
      row.AGRU2 = CPLib.GetProperty(p_AGRU2,"","",i);
      row.DAGRU3 = CPLib.GetProperty(p_DAGRU3,"","",i);
      row.AGRU3 = CPLib.GetProperty(p_AGRU3,"","",i);
      row.DAGRU4 = CPLib.GetProperty(p_DAGRU4,"","",i);
      row.AGRU4 = CPLib.GetProperty(p_AGRU4,"","",i);
      row.DAGRU5 = CPLib.GetProperty(p_DAGRU5,"","",i);
      row.AGRU5 = CPLib.GetProperty(p_AGRU5,"","",i);
      row.DAGRU6 = CPLib.GetProperty(p_DAGRU6,"","",i);
      row.AGRU6 = CPLib.GetProperty(p_AGRU6,"","",i);
      row.DASOT1 = CPLib.GetProperty(p_DASOT1,"","",i);
      row.ASOT1 = CPLib.GetProperty(p_ASOT1,"","",i);
      row.DASOT2 = CPLib.GetProperty(p_DASOT2,"","",i);
      row.ASOT2 = CPLib.GetProperty(p_ASOT2,"","",i);
      row.DASOT3 = CPLib.GetProperty(p_DASOT3,"","",i);
      row.ASOT3 = CPLib.GetProperty(p_ASOT3,"","",i);
      row.DASOT4 = CPLib.GetProperty(p_DASOT4,"","",i);
      row.ASOT4 = CPLib.GetProperty(p_ASOT4,"","",i);
      row.DASOT5 = CPLib.GetProperty(p_DASOT5,"","",i);
      row.ASOT5 = CPLib.GetProperty(p_ASOT5,"","",i);
      row.DASOT6 = CPLib.GetProperty(p_DASOT6,"","",i);
      row.ASOT6 = CPLib.GetProperty(p_ASOT6,"","",i);
      row.DASOT7 = CPLib.GetProperty(p_DASOT7,"","",i);
      row.ASOT7 = CPLib.GetProperty(p_ASOT7,"","",i);
      row.DASOT8 = CPLib.GetProperty(p_DASOT8,"","",i);
      row.ASOT8 = CPLib.GetProperty(p_ASOT8,"","",i);
      row.DASOT9 = CPLib.GetProperty(p_DASOT9,"","",i);
      row.ASOT9 = CPLib.GetProperty(p_ASOT9,"","",i);
      row.DASOT10 = CPLib.GetProperty(p_DASOT10,"","",i);
      row.ASOT10 = CPLib.GetProperty(p_ASOT10,"","",i);
      row.DASOT11 = CPLib.GetProperty(p_DASOT11,"","",i);
      row.ASOT11 = CPLib.GetProperty(p_ASOT11,"","",i);
      row.DASOT12 = CPLib.GetProperty(p_DASOT12,"","",i);
      row.ASOT12 = CPLib.GetProperty(p_ASOT12,"","",i);
      row.DAATE1 = CPLib.GetProperty(p_DAATE1,"","",i);
      row.AATE1 = CPLib.GetProperty(p_AATE1,"","",i);
      row.DAATE2 = CPLib.GetProperty(p_DAATE2,"","",i);
      row.AATE2 = CPLib.GetProperty(p_AATE2,"","",i);
      row.DAATE3 = CPLib.GetProperty(p_DAATE3,"","",i);
      row.AATE3 = CPLib.GetProperty(p_AATE3,"","",i);
      row.DAATE4 = CPLib.GetProperty(p_DAATE4,"","",i);
      row.AATE4 = CPLib.GetProperty(p_AATE4,"","",i);
      row.DAATE5 = CPLib.GetProperty(p_DAATE5,"","",i);
      row.AATE5 = CPLib.GetProperty(p_AATE5,"","",i);
      row.DAATE6 = CPLib.GetProperty(p_DAATE6,"","",i);
      row.AATE6 = CPLib.GetProperty(p_AATE6,"","",i);
      row.IDSETSIN = CPLib.GetProperty(p_IDSETSIN,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_setsin_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_setsin_vqr();
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
  public MemoryCursorRow_qbe_setsin_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_setsin_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_setsin_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_setsin_vqr p_Row) {
    MemoryCursorRow_qbe_setsin_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_setsin_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_setsin_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_setsin_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
