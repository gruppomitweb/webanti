// Definition generated from query qbe_estrai_sv_all_ip_1_vqr
public class MemoryCursor_qbe_estrai_sv_all_ip_1_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr row;
  MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr empty_row;
  public MemoryCursor_qbe_estrai_sv_all_ip_1_vqr() {
    empty_row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_estrai_sv_all_ip_1_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_DESCRAP;
    p_DESCRAP = new java.util.Properties();
    java.util.Properties p_ANNO;
    p_ANNO = new java.util.Properties();
    java.util.Properties p_TRIMESTRE;
    p_TRIMESTRE = new java.util.Properties();
    java.util.Properties p_IMPORTO;
    p_IMPORTO = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_DATA_INI;
    p_DATA_INI = new java.util.Properties();
    java.util.Properties p_DATA_FIN;
    p_DATA_FIN = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRAP".equalsIgnoreCase(key)) {
        p_DESCRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNO".equalsIgnoreCase(key)) {
        p_ANNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TRIMESTRE".equalsIgnoreCase(key)) {
        p_TRIMESTRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO".equalsIgnoreCase(key)) {
        p_IMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_INI".equalsIgnoreCase(key)) {
        p_DATA_INI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_FIN".equalsIgnoreCase(key)) {
        p_DATA_FIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
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
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.DESCRAP = CPLib.GetProperty(p_DESCRAP,"","",i);
      row.ANNO = CPLib.GetProperty(p_ANNO,"","",i);
      row.TRIMESTRE = CPLib.GetProperty(p_TRIMESTRE,"","",i);
      row.IMPORTO = CPLib.GetProperty(p_IMPORTO,"",0,i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.DATA_INI = CPLib.GetProperty(p_DATA_INI,"",CPLib.NullDate(),i);
      row.DATA_FIN = CPLib.GetProperty(p_DATA_FIN,"",CPLib.NullDate(),i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"",CPLib.NullDate(),i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
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
  public MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
