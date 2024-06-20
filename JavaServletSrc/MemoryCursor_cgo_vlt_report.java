// Definition generated from table cgo_vlt_report
public class MemoryCursor_cgo_vlt_report extends CPMemoryCursor {
  MemoryCursorRow_cgo_vlt_report row;
  MemoryCursorRow_cgo_vlt_report empty_row;
  public MemoryCursor_cgo_vlt_report() {
    empty_row = new MemoryCursorRow_cgo_vlt_report();
    row = empty_row;
  }
  public MemoryCursor_cgo_vlt_report(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_VLTREP_IDPROG;
    p_VLTREP_IDPROG = new java.util.Properties();
    java.util.Properties p_VLTREP_AAMSSALA;
    p_VLTREP_AAMSSALA = new java.util.Properties();
    java.util.Properties p_VLTREP_CODCONC;
    p_VLTREP_CODCONC = new java.util.Properties();
    java.util.Properties p_VLTREP_CODPLAT;
    p_VLTREP_CODPLAT = new java.util.Properties();
    java.util.Properties p_VLTREP_AAMSVLT;
    p_VLTREP_AAMSVLT = new java.util.Properties();
    java.util.Properties p_VLTREP_IDTICKET;
    p_VLTREP_IDTICKET = new java.util.Properties();
    java.util.Properties p_VLTREP_VALNOM;
    p_VLTREP_VALNOM = new java.util.Properties();
    java.util.Properties p_VLTREP_DATAEMI;
    p_VLTREP_DATAEMI = new java.util.Properties();
    java.util.Properties p_VLTREP_DATACONV;
    p_VLTREP_DATACONV = new java.util.Properties();
    java.util.Properties p_VLTREP_IMPBET;
    p_VLTREP_IMPBET = new java.util.Properties();
    java.util.Properties p_VLTREP_GROSWIN;
    p_VLTREP_GROSWIN = new java.util.Properties();
    java.util.Properties p_VLTREP_NETWIN;
    p_VLTREP_NETWIN = new java.util.Properties();
    java.util.Properties p_VLTREP_TOTALE;
    p_VLTREP_TOTALE = new java.util.Properties();
    java.util.Properties p_VLTREP_RAPPORTO1;
    p_VLTREP_RAPPORTO1 = new java.util.Properties();
    java.util.Properties p_VLTREP_RAPPORTO2;
    p_VLTREP_RAPPORTO2 = new java.util.Properties();
    java.util.Properties p_VLTREP_RAPPORTO3;
    p_VLTREP_RAPPORTO3 = new java.util.Properties();
    java.util.Properties p_VLTREP_TICKET_BC;
    p_VLTREP_TICKET_BC = new java.util.Properties();
    java.util.Properties p_VLTREP_ORIGINE;
    p_VLTREP_ORIGINE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_IDPROG".equalsIgnoreCase(key)) {
        p_VLTREP_IDPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_AAMSSALA".equalsIgnoreCase(key)) {
        p_VLTREP_AAMSSALA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_CODCONC".equalsIgnoreCase(key)) {
        p_VLTREP_CODCONC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_CODPLAT".equalsIgnoreCase(key)) {
        p_VLTREP_CODPLAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_AAMSVLT".equalsIgnoreCase(key)) {
        p_VLTREP_AAMSVLT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_IDTICKET".equalsIgnoreCase(key)) {
        p_VLTREP_IDTICKET = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_VALNOM".equalsIgnoreCase(key)) {
        p_VLTREP_VALNOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_DATAEMI".equalsIgnoreCase(key)) {
        p_VLTREP_DATAEMI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_DATACONV".equalsIgnoreCase(key)) {
        p_VLTREP_DATACONV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_IMPBET".equalsIgnoreCase(key)) {
        p_VLTREP_IMPBET = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_GROSWIN".equalsIgnoreCase(key)) {
        p_VLTREP_GROSWIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_NETWIN".equalsIgnoreCase(key)) {
        p_VLTREP_NETWIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_TOTALE".equalsIgnoreCase(key)) {
        p_VLTREP_TOTALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_RAPPORTO1".equalsIgnoreCase(key)) {
        p_VLTREP_RAPPORTO1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_RAPPORTO2".equalsIgnoreCase(key)) {
        p_VLTREP_RAPPORTO2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_RAPPORTO3".equalsIgnoreCase(key)) {
        p_VLTREP_RAPPORTO3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_TICKET_BC".equalsIgnoreCase(key)) {
        p_VLTREP_TICKET_BC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTREP_ORIGINE".equalsIgnoreCase(key)) {
        p_VLTREP_ORIGINE = CPLib.GetProperties(p.getProperty(key));
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
      row.VLTREP_IDPROG = CPLib.GetProperty(p_VLTREP_IDPROG,"",0,i);
      row.VLTREP_AAMSSALA = CPLib.GetProperty(p_VLTREP_AAMSSALA,"","",i);
      row.VLTREP_CODCONC = CPLib.GetProperty(p_VLTREP_CODCONC,"","",i);
      row.VLTREP_CODPLAT = CPLib.GetProperty(p_VLTREP_CODPLAT,"","",i);
      row.VLTREP_AAMSVLT = CPLib.GetProperty(p_VLTREP_AAMSVLT,"","",i);
      row.VLTREP_IDTICKET = CPLib.GetProperty(p_VLTREP_IDTICKET,"","",i);
      row.VLTREP_VALNOM = CPLib.GetProperty(p_VLTREP_VALNOM,"",0,i);
      row.VLTREP_DATAEMI = CPLib.GetProperty(p_VLTREP_DATAEMI,"",CPLib.NullDate(),i);
      row.VLTREP_DATACONV = CPLib.GetProperty(p_VLTREP_DATACONV,"",CPLib.NullDate(),i);
      row.VLTREP_IMPBET = CPLib.GetProperty(p_VLTREP_IMPBET,"",0,i);
      row.VLTREP_GROSWIN = CPLib.GetProperty(p_VLTREP_GROSWIN,"",0,i);
      row.VLTREP_NETWIN = CPLib.GetProperty(p_VLTREP_NETWIN,"",0,i);
      row.VLTREP_TOTALE = CPLib.GetProperty(p_VLTREP_TOTALE,"",0,i);
      row.VLTREP_RAPPORTO1 = CPLib.GetProperty(p_VLTREP_RAPPORTO1,"",0,i);
      row.VLTREP_RAPPORTO2 = CPLib.GetProperty(p_VLTREP_RAPPORTO2,"",0,i);
      row.VLTREP_RAPPORTO3 = CPLib.GetProperty(p_VLTREP_RAPPORTO3,"",0,i);
      row.VLTREP_TICKET_BC = CPLib.GetProperty(p_VLTREP_TICKET_BC,"","",i);
      row.VLTREP_ORIGINE = CPLib.GetProperty(p_VLTREP_ORIGINE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_vlt_report)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_vlt_report();
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
  public MemoryCursorRow_cgo_vlt_report _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_vlt_report _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_vlt_report> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_vlt_report p_Row) {
    MemoryCursorRow_cgo_vlt_report l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vlt_report();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_vlt_report p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_vlt_report();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
