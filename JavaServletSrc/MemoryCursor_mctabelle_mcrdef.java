// Definition generated from record definition mctabelle_mcrdef
public class MemoryCursor_mctabelle_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mctabelle_mcrdef row;
  MemoryCursorRow_mctabelle_mcrdef empty_row;
  public MemoryCursor_mctabelle_mcrdef() {
    empty_row = new MemoryCursorRow_mctabelle_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mctabelle_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p__clientiope;
    p__clientiope = new java.util.Properties();
    java.util.Properties p__sogopebo;
    p__sogopebo = new java.util.Properties();
    java.util.Properties p__beneficope;
    p__beneficope = new java.util.Properties();
    java.util.Properties p__terzistiope;
    p__terzistiope = new java.util.Properties();
    java.util.Properties p__clientifrz;
    p__clientifrz = new java.util.Properties();
    java.util.Properties p__sogopefbo;
    p__sogopefbo = new java.util.Properties();
    java.util.Properties p__terzistifrz;
    p__terzistifrz = new java.util.Properties();
    java.util.Properties p__beneficfrz;
    p__beneficfrz = new java.util.Properties();
    java.util.Properties p__xperazbo;
    p__xperazbo = new java.util.Properties();
    java.util.Properties p__xlientiope;
    p__xlientiope = new java.util.Properties();
    java.util.Properties p__xogopebo;
    p__xogopebo = new java.util.Properties();
    java.util.Properties p__xeneficope;
    p__xeneficope = new java.util.Properties();
    java.util.Properties p__xerzistiope;
    p__xerzistiope = new java.util.Properties();
    java.util.Properties p__xraziobo;
    p__xraziobo = new java.util.Properties();
    java.util.Properties p__xlientifrz;
    p__xlientifrz = new java.util.Properties();
    java.util.Properties p__xogopefbo;
    p__xogopefbo = new java.util.Properties();
    java.util.Properties p__xerzistifrz;
    p__xerzistifrz = new java.util.Properties();
    java.util.Properties p__xeneficfrz;
    p__xeneficfrz = new java.util.Properties();
    java.util.Properties p__rapopebo;
    p__rapopebo = new java.util.Properties();
    java.util.Properties p__soginfo;
    p__soginfo = new java.util.Properties();
    java.util.Properties p__intestbo;
    p__intestbo = new java.util.Properties();
    java.util.Properties p__delegabo;
    p__delegabo = new java.util.Properties();
    java.util.Properties p__fiduciabo;
    p__fiduciabo = new java.util.Properties();
    java.util.Properties p__garantbo;
    p__garantbo = new java.util.Properties();
    java.util.Properties p__xapopebo;
    p__xapopebo = new java.util.Properties();
    java.util.Properties p__xoginfo;
    p__xoginfo = new java.util.Properties();
    java.util.Properties p__xntestbo;
    p__xntestbo = new java.util.Properties();
    java.util.Properties p__xelegabo;
    p__xelegabo = new java.util.Properties();
    java.util.Properties p__xiduciabo;
    p__xiduciabo = new java.util.Properties();
    java.util.Properties p__xarantbo;
    p__xarantbo = new java.util.Properties();
    java.util.Properties p__rapotit;
    p__rapotit = new java.util.Properties();
    java.util.Properties p__intestit;
    p__intestit = new java.util.Properties();
    java.util.Properties p__xapotit;
    p__xapotit = new java.util.Properties();
    java.util.Properties p__xntestit;
    p__xntestit = new java.util.Properties();
    java.util.Properties p__japopebo;
    p__japopebo = new java.util.Properties();
    java.util.Properties p__jntestbo;
    p__jntestbo = new java.util.Properties();
    java.util.Properties p__jelegabo;
    p__jelegabo = new java.util.Properties();
    java.util.Properties p__jarantbo;
    p__jarantbo = new java.util.Properties();
    java.util.Properties p__japotit;
    p__japotit = new java.util.Properties();
    java.util.Properties p__jntestit;
    p__jntestit = new java.util.Properties();
    java.util.Properties p__jperazbo;
    p__jperazbo = new java.util.Properties();
    java.util.Properties p__kperazbo;
    p__kperazbo = new java.util.Properties();
    java.util.Properties p__opextrbo;
    p__opextrbo = new java.util.Properties();
    java.util.Properties p__wperazbo;
    p__wperazbo = new java.util.Properties();
    java.util.Properties p__wlientiope;
    p__wlientiope = new java.util.Properties();
    java.util.Properties p__wogopebo;
    p__wogopebo = new java.util.Properties();
    java.util.Properties p__weneficope;
    p__weneficope = new java.util.Properties();
    java.util.Properties p__werzistiope;
    p__werzistiope = new java.util.Properties();
    java.util.Properties p__wraziobo;
    p__wraziobo = new java.util.Properties();
    java.util.Properties p__wlientifrz;
    p__wlientifrz = new java.util.Properties();
    java.util.Properties p__wogopefbo;
    p__wogopefbo = new java.util.Properties();
    java.util.Properties p__weneficfrz;
    p__weneficfrz = new java.util.Properties();
    java.util.Properties p__werzistifrz;
    p__werzistifrz = new java.util.Properties();
    java.util.Properties p__wapopebo;
    p__wapopebo = new java.util.Properties();
    java.util.Properties p__woginfo;
    p__woginfo = new java.util.Properties();
    java.util.Properties p__wntestbo;
    p__wntestbo = new java.util.Properties();
    java.util.Properties p__welegabo;
    p__welegabo = new java.util.Properties();
    java.util.Properties p__widuciabo;
    p__widuciabo = new java.util.Properties();
    java.util.Properties p__warantbo;
    p__warantbo = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_clientiope".equalsIgnoreCase(key)) {
        p__clientiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_sogopebo".equalsIgnoreCase(key)) {
        p__sogopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_beneficope".equalsIgnoreCase(key)) {
        p__beneficope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_terzistiope".equalsIgnoreCase(key)) {
        p__terzistiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_clientifrz".equalsIgnoreCase(key)) {
        p__clientifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_sogopefbo".equalsIgnoreCase(key)) {
        p__sogopefbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_terzistifrz".equalsIgnoreCase(key)) {
        p__terzistifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_beneficfrz".equalsIgnoreCase(key)) {
        p__beneficfrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xperazbo".equalsIgnoreCase(key)) {
        p__xperazbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xlientiope".equalsIgnoreCase(key)) {
        p__xlientiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xogopebo".equalsIgnoreCase(key)) {
        p__xogopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xeneficope".equalsIgnoreCase(key)) {
        p__xeneficope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xerzistiope".equalsIgnoreCase(key)) {
        p__xerzistiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xraziobo".equalsIgnoreCase(key)) {
        p__xraziobo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xlientifrz".equalsIgnoreCase(key)) {
        p__xlientifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xogopefbo".equalsIgnoreCase(key)) {
        p__xogopefbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xerzistifrz".equalsIgnoreCase(key)) {
        p__xerzistifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xeneficfrz".equalsIgnoreCase(key)) {
        p__xeneficfrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_rapopebo".equalsIgnoreCase(key)) {
        p__rapopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_soginfo".equalsIgnoreCase(key)) {
        p__soginfo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_intestbo".equalsIgnoreCase(key)) {
        p__intestbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_delegabo".equalsIgnoreCase(key)) {
        p__delegabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_fiduciabo".equalsIgnoreCase(key)) {
        p__fiduciabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_garantbo".equalsIgnoreCase(key)) {
        p__garantbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xapopebo".equalsIgnoreCase(key)) {
        p__xapopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xoginfo".equalsIgnoreCase(key)) {
        p__xoginfo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xntestbo".equalsIgnoreCase(key)) {
        p__xntestbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xelegabo".equalsIgnoreCase(key)) {
        p__xelegabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xiduciabo".equalsIgnoreCase(key)) {
        p__xiduciabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xarantbo".equalsIgnoreCase(key)) {
        p__xarantbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_rapotit".equalsIgnoreCase(key)) {
        p__rapotit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_intestit".equalsIgnoreCase(key)) {
        p__intestit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xapotit".equalsIgnoreCase(key)) {
        p__xapotit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_xntestit".equalsIgnoreCase(key)) {
        p__xntestit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_japopebo".equalsIgnoreCase(key)) {
        p__japopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_jntestbo".equalsIgnoreCase(key)) {
        p__jntestbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_jelegabo".equalsIgnoreCase(key)) {
        p__jelegabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_jarantbo".equalsIgnoreCase(key)) {
        p__jarantbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_japotit".equalsIgnoreCase(key)) {
        p__japotit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_jntestit".equalsIgnoreCase(key)) {
        p__jntestit = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_jperazbo".equalsIgnoreCase(key)) {
        p__jperazbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_kperazbo".equalsIgnoreCase(key)) {
        p__kperazbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_opextrbo".equalsIgnoreCase(key)) {
        p__opextrbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wperazbo".equalsIgnoreCase(key)) {
        p__wperazbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wlientiope".equalsIgnoreCase(key)) {
        p__wlientiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wogopebo".equalsIgnoreCase(key)) {
        p__wogopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_weneficope".equalsIgnoreCase(key)) {
        p__weneficope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_werzistiope".equalsIgnoreCase(key)) {
        p__werzistiope = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wraziobo".equalsIgnoreCase(key)) {
        p__wraziobo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wlientifrz".equalsIgnoreCase(key)) {
        p__wlientifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wogopefbo".equalsIgnoreCase(key)) {
        p__wogopefbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_weneficfrz".equalsIgnoreCase(key)) {
        p__weneficfrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_werzistifrz".equalsIgnoreCase(key)) {
        p__werzistifrz = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wapopebo".equalsIgnoreCase(key)) {
        p__wapopebo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_woginfo".equalsIgnoreCase(key)) {
        p__woginfo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_wntestbo".equalsIgnoreCase(key)) {
        p__wntestbo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_welegabo".equalsIgnoreCase(key)) {
        p__welegabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_widuciabo".equalsIgnoreCase(key)) {
        p__widuciabo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("_warantbo".equalsIgnoreCase(key)) {
        p__warantbo = CPLib.GetProperties(p.getProperty(key));
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
      row._clientiope = CPLib.GetProperty(p__clientiope,"",false,i);
      row._sogopebo = CPLib.GetProperty(p__sogopebo,"",false,i);
      row._beneficope = CPLib.GetProperty(p__beneficope,"",false,i);
      row._terzistiope = CPLib.GetProperty(p__terzistiope,"",false,i);
      row._clientifrz = CPLib.GetProperty(p__clientifrz,"",false,i);
      row._sogopefbo = CPLib.GetProperty(p__sogopefbo,"",false,i);
      row._terzistifrz = CPLib.GetProperty(p__terzistifrz,"",false,i);
      row._beneficfrz = CPLib.GetProperty(p__beneficfrz,"",false,i);
      row._xperazbo = CPLib.GetProperty(p__xperazbo,"",false,i);
      row._xlientiope = CPLib.GetProperty(p__xlientiope,"",false,i);
      row._xogopebo = CPLib.GetProperty(p__xogopebo,"",false,i);
      row._xeneficope = CPLib.GetProperty(p__xeneficope,"",false,i);
      row._xerzistiope = CPLib.GetProperty(p__xerzistiope,"",false,i);
      row._xraziobo = CPLib.GetProperty(p__xraziobo,"",false,i);
      row._xlientifrz = CPLib.GetProperty(p__xlientifrz,"",false,i);
      row._xogopefbo = CPLib.GetProperty(p__xogopefbo,"",false,i);
      row._xerzistifrz = CPLib.GetProperty(p__xerzistifrz,"",false,i);
      row._xeneficfrz = CPLib.GetProperty(p__xeneficfrz,"",false,i);
      row._rapopebo = CPLib.GetProperty(p__rapopebo,"",false,i);
      row._soginfo = CPLib.GetProperty(p__soginfo,"",false,i);
      row._intestbo = CPLib.GetProperty(p__intestbo,"",false,i);
      row._delegabo = CPLib.GetProperty(p__delegabo,"",false,i);
      row._fiduciabo = CPLib.GetProperty(p__fiduciabo,"",false,i);
      row._garantbo = CPLib.GetProperty(p__garantbo,"",false,i);
      row._xapopebo = CPLib.GetProperty(p__xapopebo,"",false,i);
      row._xoginfo = CPLib.GetProperty(p__xoginfo,"",false,i);
      row._xntestbo = CPLib.GetProperty(p__xntestbo,"",false,i);
      row._xelegabo = CPLib.GetProperty(p__xelegabo,"",false,i);
      row._xiduciabo = CPLib.GetProperty(p__xiduciabo,"",false,i);
      row._xarantbo = CPLib.GetProperty(p__xarantbo,"",false,i);
      row._rapotit = CPLib.GetProperty(p__rapotit,"",false,i);
      row._intestit = CPLib.GetProperty(p__intestit,"",false,i);
      row._xapotit = CPLib.GetProperty(p__xapotit,"",false,i);
      row._xntestit = CPLib.GetProperty(p__xntestit,"",false,i);
      row._japopebo = CPLib.GetProperty(p__japopebo,"",false,i);
      row._jntestbo = CPLib.GetProperty(p__jntestbo,"",false,i);
      row._jelegabo = CPLib.GetProperty(p__jelegabo,"",false,i);
      row._jarantbo = CPLib.GetProperty(p__jarantbo,"",false,i);
      row._japotit = CPLib.GetProperty(p__japotit,"",false,i);
      row._jntestit = CPLib.GetProperty(p__jntestit,"",false,i);
      row._jperazbo = CPLib.GetProperty(p__jperazbo,"",false,i);
      row._kperazbo = CPLib.GetProperty(p__kperazbo,"",false,i);
      row._opextrbo = CPLib.GetProperty(p__opextrbo,"",false,i);
      row._wperazbo = CPLib.GetProperty(p__wperazbo,"",false,i);
      row._wlientiope = CPLib.GetProperty(p__wlientiope,"",false,i);
      row._wogopebo = CPLib.GetProperty(p__wogopebo,"",false,i);
      row._weneficope = CPLib.GetProperty(p__weneficope,"",false,i);
      row._werzistiope = CPLib.GetProperty(p__werzistiope,"",false,i);
      row._wraziobo = CPLib.GetProperty(p__wraziobo,"",false,i);
      row._wlientifrz = CPLib.GetProperty(p__wlientifrz,"",false,i);
      row._wogopefbo = CPLib.GetProperty(p__wogopefbo,"",false,i);
      row._weneficfrz = CPLib.GetProperty(p__weneficfrz,"",false,i);
      row._werzistifrz = CPLib.GetProperty(p__werzistifrz,"",false,i);
      row._wapopebo = CPLib.GetProperty(p__wapopebo,"",false,i);
      row._woginfo = CPLib.GetProperty(p__woginfo,"",false,i);
      row._wntestbo = CPLib.GetProperty(p__wntestbo,"",false,i);
      row._welegabo = CPLib.GetProperty(p__welegabo,"",false,i);
      row._widuciabo = CPLib.GetProperty(p__widuciabo,"",false,i);
      row._warantbo = CPLib.GetProperty(p__warantbo,"",false,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mctabelle_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mctabelle_mcrdef();
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
  public MemoryCursorRow_mctabelle_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mctabelle_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mctabelle_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mctabelle_mcrdef p_Row) {
    MemoryCursorRow_mctabelle_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mctabelle_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mctabelle_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mctabelle_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
