// Definition generated from table cgo_telematico
public class MemoryCursor_cgo_telematico extends CPMemoryCursor {
  MemoryCursorRow_cgo_telematico row;
  MemoryCursorRow_cgo_telematico empty_row;
  public MemoryCursor_cgo_telematico() {
    empty_row = new MemoryCursorRow_cgo_telematico();
    row = empty_row;
  }
  public MemoryCursor_cgo_telematico(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_SNAINUMOPE;
    p_SNAINUMOPE = new java.util.Properties();
    java.util.Properties p_ENV;
    p_ENV = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_CACODICE;
    p_CACODICE = new java.util.Properties();
    java.util.Properties p_CADATAORA;
    p_CADATAORA = new java.util.Properties();
    java.util.Properties p_CAIDBIGLIETTO;
    p_CAIDBIGLIETTO = new java.util.Properties();
    java.util.Properties p_CSMF_COD;
    p_CSMF_COD = new java.util.Properties();
    java.util.Properties p_NUM_CONC;
    p_NUM_CONC = new java.util.Properties();
    java.util.Properties p_P_VEND;
    p_P_VEND = new java.util.Properties();
    java.util.Properties p_IPCOLLEG;
    p_IPCOLLEG = new java.util.Properties();
    java.util.Properties p_ORACOLLEG;
    p_ORACOLLEG = new java.util.Properties();
    java.util.Properties p_DUCOLLEG;
    p_DUCOLLEG = new java.util.Properties();
    java.util.Properties p_IBAN;
    p_IBAN = new java.util.Properties();
    java.util.Properties p_MEZPAGAM;
    p_MEZPAGAM = new java.util.Properties();
    java.util.Properties p_TIPOGIOCO;
    p_TIPOGIOCO = new java.util.Properties();
    java.util.Properties p_CODLOB;
    p_CODLOB = new java.util.Properties();
    java.util.Properties p_CATIPGIO;
    p_CATIPGIO = new java.util.Properties();
    java.util.Properties p_CATIPCON;
    p_CATIPCON = new java.util.Properties();
    java.util.Properties p_CAPV_COD;
    p_CAPV_COD = new java.util.Properties();
    java.util.Properties p_VPCODICE;
    p_VPCODICE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SNAINUMOPE".equalsIgnoreCase(key)) {
        p_SNAINUMOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ENV".equalsIgnoreCase(key)) {
        p_ENV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CACODICE".equalsIgnoreCase(key)) {
        p_CACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CADATAORA".equalsIgnoreCase(key)) {
        p_CADATAORA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAIDBIGLIETTO".equalsIgnoreCase(key)) {
        p_CAIDBIGLIETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CSMF_COD".equalsIgnoreCase(key)) {
        p_CSMF_COD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUM_CONC".equalsIgnoreCase(key)) {
        p_NUM_CONC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("P_VEND".equalsIgnoreCase(key)) {
        p_P_VEND = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IPCOLLEG".equalsIgnoreCase(key)) {
        p_IPCOLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ORACOLLEG".equalsIgnoreCase(key)) {
        p_ORACOLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DUCOLLEG".equalsIgnoreCase(key)) {
        p_DUCOLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IBAN".equalsIgnoreCase(key)) {
        p_IBAN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MEZPAGAM".equalsIgnoreCase(key)) {
        p_MEZPAGAM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOGIOCO".equalsIgnoreCase(key)) {
        p_TIPOGIOCO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODLOB".equalsIgnoreCase(key)) {
        p_CODLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATIPGIO".equalsIgnoreCase(key)) {
        p_CATIPGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATIPCON".equalsIgnoreCase(key)) {
        p_CATIPCON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAPV_COD".equalsIgnoreCase(key)) {
        p_CAPV_COD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPCODICE".equalsIgnoreCase(key)) {
        p_VPCODICE = CPLib.GetProperties(p.getProperty(key));
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
      row.SNAINUMOPE = CPLib.GetProperty(p_SNAINUMOPE,"","",i);
      row.ENV = CPLib.GetProperty(p_ENV,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.CACODICE = CPLib.GetProperty(p_CACODICE,"",0,i);
      row.CADATAORA = CPLib.GetProperty(p_CADATAORA,"",CPLib.NullDateTime(),i);
      row.CAIDBIGLIETTO = CPLib.GetProperty(p_CAIDBIGLIETTO,"","",i);
      row.CSMF_COD = CPLib.GetProperty(p_CSMF_COD,"",0,i);
      row.NUM_CONC = CPLib.GetProperty(p_NUM_CONC,"",0,i);
      row.P_VEND = CPLib.GetProperty(p_P_VEND,"",0,i);
      row.IPCOLLEG = CPLib.GetProperty(p_IPCOLLEG,"","",i);
      row.ORACOLLEG = CPLib.GetProperty(p_ORACOLLEG,"",CPLib.NullDateTime(),i);
      row.DUCOLLEG = CPLib.GetProperty(p_DUCOLLEG,"",0,i);
      row.IBAN = CPLib.GetProperty(p_IBAN,"","",i);
      row.MEZPAGAM = CPLib.GetProperty(p_MEZPAGAM,"","",i);
      row.TIPOGIOCO = CPLib.GetProperty(p_TIPOGIOCO,"","",i);
      row.CODLOB = CPLib.GetProperty(p_CODLOB,"","",i);
      row.CATIPGIO = CPLib.GetProperty(p_CATIPGIO,"",0,i);
      row.CATIPCON = CPLib.GetProperty(p_CATIPCON,"",0,i);
      row.CAPV_COD = CPLib.GetProperty(p_CAPV_COD,"",0,i);
      row.VPCODICE = CPLib.GetProperty(p_VPCODICE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_telematico)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_telematico();
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
  public MemoryCursorRow_cgo_telematico _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_telematico _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_telematico> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_telematico p_Row) {
    MemoryCursorRow_cgo_telematico l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_telematico();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_telematico p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_telematico();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
