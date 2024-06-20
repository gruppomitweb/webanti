// Definition generated from table vt_mit_citta
public class MemoryCursor_vt_mit_citta extends CPMemoryCursor {
  MemoryCursorRow_vt_mit_citta row;
  MemoryCursorRow_vt_mit_citta empty_row;
  public MemoryCursor_vt_mit_citta() {
    empty_row = new MemoryCursorRow_vt_mit_citta();
    row = empty_row;
  }
  public MemoryCursor_vt_mit_citta(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_cab;
    p_cab = new java.util.Properties();
    java.util.Properties p_citta;
    p_citta = new java.util.Properties();
    java.util.Properties p_prov;
    p_prov = new java.util.Properties();
    java.util.Properties p_cap;
    p_cap = new java.util.Properties();
    java.util.Properties p_pktbstati;
    p_pktbstati = new java.util.Properties();
    java.util.Properties p_sigla;
    p_sigla = new java.util.Properties();
    java.util.Properties p_pref;
    p_pref = new java.util.Properties();
    java.util.Properties p_cod_ciudad_sitrop;
    p_cod_ciudad_sitrop = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cab".equalsIgnoreCase(key)) {
        p_cab = CPLib.GetProperties(p.getProperty(key));
      }
      if ("citta".equalsIgnoreCase(key)) {
        p_citta = CPLib.GetProperties(p.getProperty(key));
      }
      if ("prov".equalsIgnoreCase(key)) {
        p_prov = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cap".equalsIgnoreCase(key)) {
        p_cap = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pktbstati".equalsIgnoreCase(key)) {
        p_pktbstati = CPLib.GetProperties(p.getProperty(key));
      }
      if ("sigla".equalsIgnoreCase(key)) {
        p_sigla = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pref".equalsIgnoreCase(key)) {
        p_pref = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cod_ciudad_sitrop".equalsIgnoreCase(key)) {
        p_cod_ciudad_sitrop = CPLib.GetProperties(p.getProperty(key));
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
      row.cab = CPLib.GetProperty(p_cab,"","",i);
      row.citta = CPLib.GetProperty(p_citta,"","",i);
      row.prov = CPLib.GetProperty(p_prov,"","",i);
      row.cap = CPLib.GetProperty(p_cap,"","",i);
      row.pktbstati = CPLib.GetProperty(p_pktbstati,"","",i);
      row.sigla = CPLib.GetProperty(p_sigla,"","",i);
      row.pref = CPLib.GetProperty(p_pref,"","",i);
      row.cod_ciudad_sitrop = CPLib.GetProperty(p_cod_ciudad_sitrop,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_vt_mit_citta)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_vt_mit_citta();
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
  public MemoryCursorRow_vt_mit_citta _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_vt_mit_citta _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_vt_mit_citta> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_vt_mit_citta p_Row) {
    MemoryCursorRow_vt_mit_citta l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_vt_mit_citta();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_vt_mit_citta p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_vt_mit_citta();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
