// Definition generated from table sid_invio3
public class MemoryCursor_sid_invio3 extends CPMemoryCursor {
  MemoryCursorRow_sid_invio3 row;
  MemoryCursorRow_sid_invio3 empty_row;
  public MemoryCursor_sid_invio3() {
    empty_row = new MemoryCursorRow_sid_invio3();
    row = empty_row;
  }
  public MemoryCursor_sid_invio3(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINVIO3;
    p_CODINVIO3 = new java.util.Properties();
    java.util.Properties p_RAPINVIO3;
    p_RAPINVIO3 = new java.util.Properties();
    java.util.Properties p_TPRINVIO3;
    p_TPRINVIO3 = new java.util.Properties();
    java.util.Properties p_ANNINVIO3;
    p_ANNINVIO3 = new java.util.Properties();
    java.util.Properties p_VALINVIO3;
    p_VALINVIO3 = new java.util.Properties();
    java.util.Properties p_NATINVIO3;
    p_NATINVIO3 = new java.util.Properties();
    java.util.Properties p_IM1INVIO3;
    p_IM1INVIO3 = new java.util.Properties();
    java.util.Properties p_FI1INVIO3;
    p_FI1INVIO3 = new java.util.Properties();
    java.util.Properties p_IM2INVIO3;
    p_IM2INVIO3 = new java.util.Properties();
    java.util.Properties p_FI2INVIO3;
    p_FI2INVIO3 = new java.util.Properties();
    java.util.Properties p_IM3INVIO3;
    p_IM3INVIO3 = new java.util.Properties();
    java.util.Properties p_FI3INVIO3;
    p_FI3INVIO3 = new java.util.Properties();
    java.util.Properties p_IM4INVIO3;
    p_IM4INVIO3 = new java.util.Properties();
    java.util.Properties p_FI4INVIO3;
    p_FI4INVIO3 = new java.util.Properties();
    java.util.Properties p_IM5INVIO3;
    p_IM5INVIO3 = new java.util.Properties();
    java.util.Properties p_FI5INVIO3;
    p_FI5INVIO3 = new java.util.Properties();
    java.util.Properties p_IM6INVIO3;
    p_IM6INVIO3 = new java.util.Properties();
    java.util.Properties p_FI6INVIO3;
    p_FI6INVIO3 = new java.util.Properties();
    java.util.Properties p_UNIQUE3;
    p_UNIQUE3 = new java.util.Properties();
    java.util.Properties p_FLGUNQ3;
    p_FLGUNQ3 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINVIO3".equalsIgnoreCase(key)) {
        p_CODINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPINVIO3".equalsIgnoreCase(key)) {
        p_RAPINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TPRINVIO3".equalsIgnoreCase(key)) {
        p_TPRINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNINVIO3".equalsIgnoreCase(key)) {
        p_ANNINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALINVIO3".equalsIgnoreCase(key)) {
        p_VALINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATINVIO3".equalsIgnoreCase(key)) {
        p_NATINVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM1INVIO3".equalsIgnoreCase(key)) {
        p_IM1INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI1INVIO3".equalsIgnoreCase(key)) {
        p_FI1INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM2INVIO3".equalsIgnoreCase(key)) {
        p_IM2INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI2INVIO3".equalsIgnoreCase(key)) {
        p_FI2INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM3INVIO3".equalsIgnoreCase(key)) {
        p_IM3INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI3INVIO3".equalsIgnoreCase(key)) {
        p_FI3INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM4INVIO3".equalsIgnoreCase(key)) {
        p_IM4INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI4INVIO3".equalsIgnoreCase(key)) {
        p_FI4INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM5INVIO3".equalsIgnoreCase(key)) {
        p_IM5INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI5INVIO3".equalsIgnoreCase(key)) {
        p_FI5INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IM6INVIO3".equalsIgnoreCase(key)) {
        p_IM6INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FI6INVIO3".equalsIgnoreCase(key)) {
        p_FI6INVIO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUE3".equalsIgnoreCase(key)) {
        p_UNIQUE3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGUNQ3".equalsIgnoreCase(key)) {
        p_FLGUNQ3 = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINVIO3 = CPLib.GetProperty(p_CODINVIO3,"","",i);
      row.RAPINVIO3 = CPLib.GetProperty(p_RAPINVIO3,"","",i);
      row.TPRINVIO3 = CPLib.GetProperty(p_TPRINVIO3,"","",i);
      row.ANNINVIO3 = CPLib.GetProperty(p_ANNINVIO3,"",0,i);
      row.VALINVIO3 = CPLib.GetProperty(p_VALINVIO3,"","",i);
      row.NATINVIO3 = CPLib.GetProperty(p_NATINVIO3,"","",i);
      row.IM1INVIO3 = CPLib.GetProperty(p_IM1INVIO3,"",0,i);
      row.FI1INVIO3 = CPLib.GetProperty(p_FI1INVIO3,"",0,i);
      row.IM2INVIO3 = CPLib.GetProperty(p_IM2INVIO3,"",0,i);
      row.FI2INVIO3 = CPLib.GetProperty(p_FI2INVIO3,"",0,i);
      row.IM3INVIO3 = CPLib.GetProperty(p_IM3INVIO3,"",0,i);
      row.FI3INVIO3 = CPLib.GetProperty(p_FI3INVIO3,"",0,i);
      row.IM4INVIO3 = CPLib.GetProperty(p_IM4INVIO3,"",0,i);
      row.FI4INVIO3 = CPLib.GetProperty(p_FI4INVIO3,"",0,i);
      row.IM5INVIO3 = CPLib.GetProperty(p_IM5INVIO3,"",0,i);
      row.FI5INVIO3 = CPLib.GetProperty(p_FI5INVIO3,"",0,i);
      row.IM6INVIO3 = CPLib.GetProperty(p_IM6INVIO3,"",0,i);
      row.FI6INVIO3 = CPLib.GetProperty(p_FI6INVIO3,"",0,i);
      row.UNIQUE3 = CPLib.GetProperty(p_UNIQUE3,"","",i);
      row.FLGUNQ3 = CPLib.GetProperty(p_FLGUNQ3,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_sid_invio3)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_sid_invio3();
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
  public MemoryCursorRow_sid_invio3 _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_sid_invio3 _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_sid_invio3> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_sid_invio3 p_Row) {
    MemoryCursorRow_sid_invio3 l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_sid_invio3();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_sid_invio3 p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_sid_invio3();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
