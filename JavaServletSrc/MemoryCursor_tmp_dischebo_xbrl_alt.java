// Definition generated from table tmp_dischebo_xbrl_alt
public class MemoryCursor_tmp_dischebo_xbrl_alt extends CPMemoryCursor {
  MemoryCursorRow_tmp_dischebo_xbrl_alt row;
  MemoryCursorRow_tmp_dischebo_xbrl_alt empty_row;
  public MemoryCursor_tmp_dischebo_xbrl_alt() {
    empty_row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
    row = empty_row;
  }
  public MemoryCursor_tmp_dischebo_xbrl_alt(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODINTDIP;
    p_CODINTDIP = new java.util.Properties();
    java.util.Properties p_ABICABDIP;
    p_ABICABDIP = new java.util.Properties();
    java.util.Properties p_CODCABDIP;
    p_CODCABDIP = new java.util.Properties();
    java.util.Properties p_PERPAESE;
    p_PERPAESE = new java.util.Properties();
    java.util.Properties p_PERCAB;
    p_PERCAB = new java.util.Properties();
    java.util.Properties p_CODVOC;
    p_CODVOC = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
    java.util.Properties p_PAESECP;
    p_PAESECP = new java.util.Properties();
    java.util.Properties p_CODCABCP;
    p_CODCABCP = new java.util.Properties();
    java.util.Properties p_PAESEICP;
    p_PAESEICP = new java.util.Properties();
    java.util.Properties p_CABICP;
    p_CABICP = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_OPERAZIONI;
    p_OPERAZIONI = new java.util.Properties();
    java.util.Properties p_CONTANTI;
    p_CONTANTI = new java.util.Properties();
    java.util.Properties p_N_ITA;
    p_N_ITA = new java.util.Properties();
    java.util.Properties p_N_EXT;
    p_N_EXT = new java.util.Properties();
    java.util.Properties p_N_ALT;
    p_N_ALT = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTDIP".equalsIgnoreCase(key)) {
        p_CODINTDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABICABDIP".equalsIgnoreCase(key)) {
        p_ABICABDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCABDIP".equalsIgnoreCase(key)) {
        p_CODCABDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PERPAESE".equalsIgnoreCase(key)) {
        p_PERPAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PERCAB".equalsIgnoreCase(key)) {
        p_PERCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODVOC".equalsIgnoreCase(key)) {
        p_CODVOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESECP".equalsIgnoreCase(key)) {
        p_PAESECP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCABCP".equalsIgnoreCase(key)) {
        p_CODCABCP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESEICP".equalsIgnoreCase(key)) {
        p_PAESEICP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABICP".equalsIgnoreCase(key)) {
        p_CABICP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERAZIONI".equalsIgnoreCase(key)) {
        p_OPERAZIONI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTANTI".equalsIgnoreCase(key)) {
        p_CONTANTI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("N_ITA".equalsIgnoreCase(key)) {
        p_N_ITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("N_EXT".equalsIgnoreCase(key)) {
        p_N_EXT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("N_ALT".equalsIgnoreCase(key)) {
        p_N_ALT = CPLib.GetProperties(p.getProperty(key));
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
      row.CODINTDIP = CPLib.GetProperty(p_CODINTDIP,"","",i);
      row.ABICABDIP = CPLib.GetProperty(p_ABICABDIP,"","",i);
      row.CODCABDIP = CPLib.GetProperty(p_CODCABDIP,"","",i);
      row.PERPAESE = CPLib.GetProperty(p_PERPAESE,"","",i);
      row.PERCAB = CPLib.GetProperty(p_PERCAB,"","",i);
      row.CODVOC = CPLib.GetProperty(p_CODVOC,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.PAESECP = CPLib.GetProperty(p_PAESECP,"","",i);
      row.CODCABCP = CPLib.GetProperty(p_CODCABCP,"","",i);
      row.PAESEICP = CPLib.GetProperty(p_PAESEICP,"","",i);
      row.CABICP = CPLib.GetProperty(p_CABICP,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.OPERAZIONI = CPLib.GetProperty(p_OPERAZIONI,"",0,i);
      row.CONTANTI = CPLib.GetProperty(p_CONTANTI,"",0,i);
      row.N_ITA = CPLib.GetProperty(p_N_ITA,"",0,i);
      row.N_EXT = CPLib.GetProperty(p_N_EXT,"",0,i);
      row.N_ALT = CPLib.GetProperty(p_N_ALT,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_dischebo_xbrl_alt)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_dischebo_xbrl_alt();
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
  public MemoryCursorRow_tmp_dischebo_xbrl_alt _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_dischebo_xbrl_alt _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_dischebo_xbrl_alt> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    MemoryCursorRow_tmp_dischebo_xbrl_alt l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_dischebo_xbrl_alt p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_dischebo_xbrl_alt();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
