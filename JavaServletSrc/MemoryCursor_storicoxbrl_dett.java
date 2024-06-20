// Definition generated from table storicoxbrl_dett
public class MemoryCursor_storicoxbrl_dett extends CPMemoryCursor {
  MemoryCursorRow_storicoxbrl_dett row;
  MemoryCursorRow_storicoxbrl_dett empty_row;
  public MemoryCursor_storicoxbrl_dett() {
    empty_row = new MemoryCursorRow_storicoxbrl_dett();
    row = empty_row;
  }
  public MemoryCursor_storicoxbrl_dett(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_ANNORIF;
    p_ANNORIF = new java.util.Properties();
    java.util.Properties p_MESERIF;
    p_MESERIF = new java.util.Properties();
    java.util.Properties p_PROGRIF;
    p_PROGRIF = new java.util.Properties();
    java.util.Properties p_TIPOPE;
    p_TIPOPE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_CODVOC;
    p_CODVOC = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_CODINTDIP;
    p_CODINTDIP = new java.util.Properties();
    java.util.Properties p_ABICABDIP;
    p_ABICABDIP = new java.util.Properties();
    java.util.Properties p_CODCABDIP;
    p_CODCABDIP = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_PERPAESE;
    p_PERPAESE = new java.util.Properties();
    java.util.Properties p_PERCAB;
    p_PERCAB = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
    java.util.Properties p_CONNESBEN;
    p_CONNESBEN = new java.util.Properties();
    java.util.Properties p_PAESECP;
    p_PAESECP = new java.util.Properties();
    java.util.Properties p_CODCABCP;
    p_CODCABCP = new java.util.Properties();
    java.util.Properties p_INTCONTRO;
    p_INTCONTRO = new java.util.Properties();
    java.util.Properties p_PAESEICP;
    p_PAESEICP = new java.util.Properties();
    java.util.Properties p_CABICP;
    p_CABICP = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNORIF".equalsIgnoreCase(key)) {
        p_ANNORIF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MESERIF".equalsIgnoreCase(key)) {
        p_MESERIF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGRIF".equalsIgnoreCase(key)) {
        p_PROGRIF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOPE".equalsIgnoreCase(key)) {
        p_TIPOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
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
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
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
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PERPAESE".equalsIgnoreCase(key)) {
        p_PERPAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PERCAB".equalsIgnoreCase(key)) {
        p_PERCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESBEN".equalsIgnoreCase(key)) {
        p_CONNESBEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESECP".equalsIgnoreCase(key)) {
        p_PAESECP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCABCP".equalsIgnoreCase(key)) {
        p_CODCABCP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INTCONTRO".equalsIgnoreCase(key)) {
        p_INTCONTRO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESEICP".equalsIgnoreCase(key)) {
        p_PAESEICP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABICP".equalsIgnoreCase(key)) {
        p_CABICP = CPLib.GetProperties(p.getProperty(key));
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
      row.ANNORIF = CPLib.GetProperty(p_ANNORIF,"","",i);
      row.MESERIF = CPLib.GetProperty(p_MESERIF,"","",i);
      row.PROGRIF = CPLib.GetProperty(p_PROGRIF,"","",i);
      row.TIPOPE = CPLib.GetProperty(p_TIPOPE,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.CODVOC = CPLib.GetProperty(p_CODVOC,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.CODINTDIP = CPLib.GetProperty(p_CODINTDIP,"","",i);
      row.ABICABDIP = CPLib.GetProperty(p_ABICABDIP,"","",i);
      row.CODCABDIP = CPLib.GetProperty(p_CODCABDIP,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.PERPAESE = CPLib.GetProperty(p_PERPAESE,"","",i);
      row.PERCAB = CPLib.GetProperty(p_PERCAB,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.CONNESBEN = CPLib.GetProperty(p_CONNESBEN,"","",i);
      row.PAESECP = CPLib.GetProperty(p_PAESECP,"","",i);
      row.CODCABCP = CPLib.GetProperty(p_CODCABCP,"","",i);
      row.INTCONTRO = CPLib.GetProperty(p_INTCONTRO,"","",i);
      row.PAESEICP = CPLib.GetProperty(p_PAESEICP,"","",i);
      row.CABICP = CPLib.GetProperty(p_CABICP,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_storicoxbrl_dett)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_storicoxbrl_dett();
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
  public MemoryCursorRow_storicoxbrl_dett _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_storicoxbrl_dett _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_storicoxbrl_dett> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_storicoxbrl_dett p_Row) {
    MemoryCursorRow_storicoxbrl_dett l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_storicoxbrl_dett();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_storicoxbrl_dett p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_storicoxbrl_dett();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
