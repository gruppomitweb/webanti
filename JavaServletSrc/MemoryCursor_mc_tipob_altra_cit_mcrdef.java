// Definition generated from record definition mc_tipob_altra_cit_mcrdef
public class MemoryCursor_mc_tipob_altra_cit_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mc_tipob_altra_cit_mcrdef row;
  MemoryCursorRow_mc_tipob_altra_cit_mcrdef empty_row;
  public MemoryCursor_mc_tipob_altra_cit_mcrdef() {
    empty_row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mc_tipob_altra_cit_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_KEY;
    p_KEY = new java.util.Properties();
    java.util.Properties p_GNL;
    p_GNL = new java.util.Properties();
    java.util.Properties p_ISTAT;
    p_ISTAT = new java.util.Properties();
    java.util.Properties p_GNLCIT;
    p_GNLCIT = new java.util.Properties();
    java.util.Properties p_GNLCITSALA;
    p_GNLCITSALA = new java.util.Properties();
    java.util.Properties p_ABI_P;
    p_ABI_P = new java.util.Properties();
    java.util.Properties p_BM5;
    p_BM5 = new java.util.Properties();
    java.util.Properties p_BM10;
    p_BM10 = new java.util.Properties();
    java.util.Properties p_BM20;
    p_BM20 = new java.util.Properties();
    java.util.Properties p_BM50;
    p_BM50 = new java.util.Properties();
    java.util.Properties p_BM100;
    p_BM100 = new java.util.Properties();
    java.util.Properties p_BM200;
    p_BM200 = new java.util.Properties();
    java.util.Properties p_BM500;
    p_BM500 = new java.util.Properties();
    java.util.Properties p_NUM_OPE;
    p_NUM_OPE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("KEY".equalsIgnoreCase(key)) {
        p_KEY = CPLib.GetProperties(p.getProperty(key));
      }
      if ("GNL".equalsIgnoreCase(key)) {
        p_GNL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ISTAT".equalsIgnoreCase(key)) {
        p_ISTAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("GNLCIT".equalsIgnoreCase(key)) {
        p_GNLCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("GNLCITSALA".equalsIgnoreCase(key)) {
        p_GNLCITSALA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABI_P".equalsIgnoreCase(key)) {
        p_ABI_P = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM5".equalsIgnoreCase(key)) {
        p_BM5 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM10".equalsIgnoreCase(key)) {
        p_BM10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM20".equalsIgnoreCase(key)) {
        p_BM20 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM50".equalsIgnoreCase(key)) {
        p_BM50 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM100".equalsIgnoreCase(key)) {
        p_BM100 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM200".equalsIgnoreCase(key)) {
        p_BM200 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("BM500".equalsIgnoreCase(key)) {
        p_BM500 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUM_OPE".equalsIgnoreCase(key)) {
        p_NUM_OPE = CPLib.GetProperties(p.getProperty(key));
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
      row.KEY = CPLib.GetProperty(p_KEY,"","",i);
      row.GNL = CPLib.GetProperty(p_GNL,"","",i);
      row.ISTAT = CPLib.GetProperty(p_ISTAT,"","",i);
      row.GNLCIT = CPLib.GetProperty(p_GNLCIT,"","",i);
      row.GNLCITSALA = CPLib.GetProperty(p_GNLCITSALA,"","",i);
      row.ABI_P = CPLib.GetProperty(p_ABI_P,"","",i);
      row.BM5 = CPLib.GetProperty(p_BM5,"",0,i);
      row.BM10 = CPLib.GetProperty(p_BM10,"",0,i);
      row.BM20 = CPLib.GetProperty(p_BM20,"",0,i);
      row.BM50 = CPLib.GetProperty(p_BM50,"",0,i);
      row.BM100 = CPLib.GetProperty(p_BM100,"",0,i);
      row.BM200 = CPLib.GetProperty(p_BM200,"",0,i);
      row.BM500 = CPLib.GetProperty(p_BM500,"",0,i);
      row.NUM_OPE = CPLib.GetProperty(p_NUM_OPE,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mc_tipob_altra_cit_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
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
  public MemoryCursorRow_mc_tipob_altra_cit_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mc_tipob_altra_cit_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mc_tipob_altra_cit_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    MemoryCursorRow_mc_tipob_altra_cit_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mc_tipob_altra_cit_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mc_tipob_altra_cit_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
