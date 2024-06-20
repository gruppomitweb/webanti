// Definition generated from table cgo_tbtipgio
public class MemoryCursor_cgo_tbtipgio extends CPMemoryCursor {
  MemoryCursorRow_cgo_tbtipgio row;
  MemoryCursorRow_cgo_tbtipgio empty_row;
  public MemoryCursor_cgo_tbtipgio() {
    empty_row = new MemoryCursorRow_cgo_tbtipgio();
    row = empty_row;
  }
  public MemoryCursor_cgo_tbtipgio(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODTPGIO;
    p_CODTPGIO = new java.util.Properties();
    java.util.Properties p_DESTPGIO;
    p_DESTPGIO = new java.util.Properties();
    java.util.Properties p_SOGTPGIO;
    p_SOGTPGIO = new java.util.Properties();
    java.util.Properties p_DEFTPGIO;
    p_DEFTPGIO = new java.util.Properties();
    java.util.Properties p_EDTTPGIO;
    p_EDTTPGIO = new java.util.Properties();
    java.util.Properties p_EDTSPGIO;
    p_EDTSPGIO = new java.util.Properties();
    java.util.Properties p_DEFSPGIO;
    p_DEFSPGIO = new java.util.Properties();
    java.util.Properties p_FLGPLGIO;
    p_FLGPLGIO = new java.util.Properties();
    java.util.Properties p_FLGMLGIO;
    p_FLGMLGIO = new java.util.Properties();
    java.util.Properties p_MAGPAGGIO;
    p_MAGPAGGIO = new java.util.Properties();
    java.util.Properties p_MINPAGGIO;
    p_MINPAGGIO = new java.util.Properties();
    java.util.Properties p_NCOPAGGIO;
    p_NCOPAGGIO = new java.util.Properties();
    java.util.Properties p_FDC1OSGIO;
    p_FDC1OSGIO = new java.util.Properties();
    java.util.Properties p_FDC2OSGIO;
    p_FDC2OSGIO = new java.util.Properties();
    java.util.Properties p_FDC3OSGIO;
    p_FDC3OSGIO = new java.util.Properties();
    java.util.Properties p_FDC4OSGIO;
    p_FDC4OSGIO = new java.util.Properties();
    java.util.Properties p_FDC5OSGIO;
    p_FDC5OSGIO = new java.util.Properties();
    java.util.Properties p_FDC6OSGIO;
    p_FDC6OSGIO = new java.util.Properties();
    java.util.Properties p_FDC1SSGIO;
    p_FDC1SSGIO = new java.util.Properties();
    java.util.Properties p_FDC2SSGIO;
    p_FDC2SSGIO = new java.util.Properties();
    java.util.Properties p_FDC3SSGIO;
    p_FDC3SSGIO = new java.util.Properties();
    java.util.Properties p_FDC4SSGIO;
    p_FDC4SSGIO = new java.util.Properties();
    java.util.Properties p_FDC5SSGIO;
    p_FDC5SSGIO = new java.util.Properties();
    java.util.Properties p_FDC6SSGIO;
    p_FDC6SSGIO = new java.util.Properties();
    java.util.Properties p_FDC1ACGIO;
    p_FDC1ACGIO = new java.util.Properties();
    java.util.Properties p_FDC2ACGIO;
    p_FDC2ACGIO = new java.util.Properties();
    java.util.Properties p_FDC3ACGIO;
    p_FDC3ACGIO = new java.util.Properties();
    java.util.Properties p_FDC4ACGIO;
    p_FDC4ACGIO = new java.util.Properties();
    java.util.Properties p_FDC5ACGIO;
    p_FDC5ACGIO = new java.util.Properties();
    java.util.Properties p_FDC6ACGIO;
    p_FDC6ACGIO = new java.util.Properties();
    java.util.Properties p_FLTIPGIO;
    p_FLTIPGIO = new java.util.Properties();
    java.util.Properties p_FLGATTIVO;
    p_FLGATTIVO = new java.util.Properties();
    java.util.Properties p_IMPMINGIO;
    p_IMPMINGIO = new java.util.Properties();
    java.util.Properties p_IMPMINTOT;
    p_IMPMINTOT = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODTPGIO".equalsIgnoreCase(key)) {
        p_CODTPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESTPGIO".equalsIgnoreCase(key)) {
        p_DESTPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOGTPGIO".equalsIgnoreCase(key)) {
        p_SOGTPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DEFTPGIO".equalsIgnoreCase(key)) {
        p_DEFTPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EDTTPGIO".equalsIgnoreCase(key)) {
        p_EDTTPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EDTSPGIO".equalsIgnoreCase(key)) {
        p_EDTSPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DEFSPGIO".equalsIgnoreCase(key)) {
        p_DEFSPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGPLGIO".equalsIgnoreCase(key)) {
        p_FLGPLGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGMLGIO".equalsIgnoreCase(key)) {
        p_FLGMLGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAGPAGGIO".equalsIgnoreCase(key)) {
        p_MAGPAGGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MINPAGGIO".equalsIgnoreCase(key)) {
        p_MINPAGGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NCOPAGGIO".equalsIgnoreCase(key)) {
        p_NCOPAGGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC1OSGIO".equalsIgnoreCase(key)) {
        p_FDC1OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC2OSGIO".equalsIgnoreCase(key)) {
        p_FDC2OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC3OSGIO".equalsIgnoreCase(key)) {
        p_FDC3OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC4OSGIO".equalsIgnoreCase(key)) {
        p_FDC4OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC5OSGIO".equalsIgnoreCase(key)) {
        p_FDC5OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC6OSGIO".equalsIgnoreCase(key)) {
        p_FDC6OSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC1SSGIO".equalsIgnoreCase(key)) {
        p_FDC1SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC2SSGIO".equalsIgnoreCase(key)) {
        p_FDC2SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC3SSGIO".equalsIgnoreCase(key)) {
        p_FDC3SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC4SSGIO".equalsIgnoreCase(key)) {
        p_FDC4SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC5SSGIO".equalsIgnoreCase(key)) {
        p_FDC5SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC6SSGIO".equalsIgnoreCase(key)) {
        p_FDC6SSGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC1ACGIO".equalsIgnoreCase(key)) {
        p_FDC1ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC2ACGIO".equalsIgnoreCase(key)) {
        p_FDC2ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC3ACGIO".equalsIgnoreCase(key)) {
        p_FDC3ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC4ACGIO".equalsIgnoreCase(key)) {
        p_FDC4ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC5ACGIO".equalsIgnoreCase(key)) {
        p_FDC5ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FDC6ACGIO".equalsIgnoreCase(key)) {
        p_FDC6ACGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLTIPGIO".equalsIgnoreCase(key)) {
        p_FLTIPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGATTIVO".equalsIgnoreCase(key)) {
        p_FLGATTIVO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPMINGIO".equalsIgnoreCase(key)) {
        p_IMPMINGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPMINTOT".equalsIgnoreCase(key)) {
        p_IMPMINTOT = CPLib.GetProperties(p.getProperty(key));
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
      row.CODTPGIO = CPLib.GetProperty(p_CODTPGIO,"","",i);
      row.DESTPGIO = CPLib.GetProperty(p_DESTPGIO,"","",i);
      row.SOGTPGIO = CPLib.GetProperty(p_SOGTPGIO,"",0,i);
      row.DEFTPGIO = CPLib.GetProperty(p_DEFTPGIO,"","",i);
      row.EDTTPGIO = CPLib.GetProperty(p_EDTTPGIO,"","",i);
      row.EDTSPGIO = CPLib.GetProperty(p_EDTSPGIO,"","",i);
      row.DEFSPGIO = CPLib.GetProperty(p_DEFSPGIO,"","",i);
      row.FLGPLGIO = CPLib.GetProperty(p_FLGPLGIO,"","",i);
      row.FLGMLGIO = CPLib.GetProperty(p_FLGMLGIO,"","",i);
      row.MAGPAGGIO = CPLib.GetProperty(p_MAGPAGGIO,"",0,i);
      row.MINPAGGIO = CPLib.GetProperty(p_MINPAGGIO,"",0,i);
      row.NCOPAGGIO = CPLib.GetProperty(p_NCOPAGGIO,"",0,i);
      row.FDC1OSGIO = CPLib.GetProperty(p_FDC1OSGIO,"","",i);
      row.FDC2OSGIO = CPLib.GetProperty(p_FDC2OSGIO,"","",i);
      row.FDC3OSGIO = CPLib.GetProperty(p_FDC3OSGIO,"","",i);
      row.FDC4OSGIO = CPLib.GetProperty(p_FDC4OSGIO,"","",i);
      row.FDC5OSGIO = CPLib.GetProperty(p_FDC5OSGIO,"","",i);
      row.FDC6OSGIO = CPLib.GetProperty(p_FDC6OSGIO,"","",i);
      row.FDC1SSGIO = CPLib.GetProperty(p_FDC1SSGIO,"","",i);
      row.FDC2SSGIO = CPLib.GetProperty(p_FDC2SSGIO,"","",i);
      row.FDC3SSGIO = CPLib.GetProperty(p_FDC3SSGIO,"","",i);
      row.FDC4SSGIO = CPLib.GetProperty(p_FDC4SSGIO,"","",i);
      row.FDC5SSGIO = CPLib.GetProperty(p_FDC5SSGIO,"","",i);
      row.FDC6SSGIO = CPLib.GetProperty(p_FDC6SSGIO,"","",i);
      row.FDC1ACGIO = CPLib.GetProperty(p_FDC1ACGIO,"","",i);
      row.FDC2ACGIO = CPLib.GetProperty(p_FDC2ACGIO,"","",i);
      row.FDC3ACGIO = CPLib.GetProperty(p_FDC3ACGIO,"","",i);
      row.FDC4ACGIO = CPLib.GetProperty(p_FDC4ACGIO,"","",i);
      row.FDC5ACGIO = CPLib.GetProperty(p_FDC5ACGIO,"","",i);
      row.FDC6ACGIO = CPLib.GetProperty(p_FDC6ACGIO,"","",i);
      row.FLTIPGIO = CPLib.GetProperty(p_FLTIPGIO,"","",i);
      row.FLGATTIVO = CPLib.GetProperty(p_FLGATTIVO,"","",i);
      row.IMPMINGIO = CPLib.GetProperty(p_IMPMINGIO,"",0,i);
      row.IMPMINTOT = CPLib.GetProperty(p_IMPMINTOT,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_tbtipgio)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_tbtipgio();
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
  public MemoryCursorRow_cgo_tbtipgio _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_tbtipgio _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_tbtipgio> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_tbtipgio p_Row) {
    MemoryCursorRow_cgo_tbtipgio l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_tbtipgio();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_tbtipgio p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_tbtipgio();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
