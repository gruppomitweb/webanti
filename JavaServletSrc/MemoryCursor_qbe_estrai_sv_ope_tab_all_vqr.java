// Definition generated from query qbe_estrai_sv_ope_tab_all_vqr
public class MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr row;
  MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr empty_row;
  public MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr() {
    empty_row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_estrai_sv_ope_tab_all_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_DESCRIZ;
    p_DESCRIZ = new java.util.Properties();
    java.util.Properties p_PROVINCIANEW;
    p_PROVINCIANEW = new java.util.Properties();
    java.util.Properties p_TIPOSV;
    p_TIPOSV = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_IMPOUT;
    p_IMPOUT = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIAOLD;
    p_PROVINCIAOLD = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_STATOREG;
    p_STATOREG = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties p_FLAGFRAUD;
    p_FLAGFRAUD = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRIZ".equalsIgnoreCase(key)) {
        p_DESCRIZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIANEW".equalsIgnoreCase(key)) {
        p_PROVINCIANEW = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSV".equalsIgnoreCase(key)) {
        p_TIPOSV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPOUT".equalsIgnoreCase(key)) {
        p_IMPOUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIAOLD".equalsIgnoreCase(key)) {
        p_PROVINCIAOLD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOREG".equalsIgnoreCase(key)) {
        p_STATOREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGFRAUD".equalsIgnoreCase(key)) {
        p_FLAGFRAUD = CPLib.GetProperties(p.getProperty(key));
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
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.DESCRIZ = CPLib.GetProperty(p_DESCRIZ,"","",i);
      row.PROVINCIANEW = CPLib.GetProperty(p_PROVINCIANEW,"","",i);
      row.TIPOSV = CPLib.GetProperty(p_TIPOSV,"","",i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.IMPOUT = CPLib.GetProperty(p_IMPOUT,"",0,i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIAOLD = CPLib.GetProperty(p_PROVINCIAOLD,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.STATOREG = CPLib.GetProperty(p_STATOREG,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"",CPLib.NullDate(),i);
      row.FLAGFRAUD = CPLib.GetProperty(p_FLAGFRAUD,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
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
  public MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_estrai_sv_ope_tab_all_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
