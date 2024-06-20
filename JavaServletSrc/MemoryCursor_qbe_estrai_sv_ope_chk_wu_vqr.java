// Definition generated from query qbe_estrai_sv_ope_chk_wu_vqr
public class MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr row;
  MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr empty_row;
  public MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr() {
    empty_row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
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
    java.util.Properties p_PROVINCIA1;
    p_PROVINCIA1 = new java.util.Properties();
    java.util.Properties p_TIPOSV;
    p_TIPOSV = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_SOTGRUP;
    p_SOTGRUP = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_IMPOUT;
    p_IMPOUT = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_NASSTATO;
    p_NASSTATO = new java.util.Properties();
    java.util.Properties p_TIPINTER;
    p_TIPINTER = new java.util.Properties();
    java.util.Properties p_CITAGE;
    p_CITAGE = new java.util.Properties();
    java.util.Properties p_PAESERES;
    p_PAESERES = new java.util.Properties();
    java.util.Properties p_MTCN;
    p_MTCN = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
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
      if ("PROVINCIA1".equalsIgnoreCase(key)) {
        p_PROVINCIA1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSV".equalsIgnoreCase(key)) {
        p_TIPOSV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTGRUP".equalsIgnoreCase(key)) {
        p_SOTGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPOUT".equalsIgnoreCase(key)) {
        p_IMPOUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASSTATO".equalsIgnoreCase(key)) {
        p_NASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINTER".equalsIgnoreCase(key)) {
        p_TIPINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CITAGE".equalsIgnoreCase(key)) {
        p_CITAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESERES".equalsIgnoreCase(key)) {
        p_PAESERES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MTCN".equalsIgnoreCase(key)) {
        p_MTCN = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.DESCRIZ = CPLib.GetProperty(p_DESCRIZ,"","",i);
      row.PROVINCIA1 = CPLib.GetProperty(p_PROVINCIA1,"","",i);
      row.TIPOSV = CPLib.GetProperty(p_TIPOSV,"","",i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.SOTGRUP = CPLib.GetProperty(p_SOTGRUP,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.IMPOUT = CPLib.GetProperty(p_IMPOUT,"",0,i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.TIPINTER = CPLib.GetProperty(p_TIPINTER,"","",i);
      row.CITAGE = CPLib.GetProperty(p_CITAGE,"","",i);
      row.PAESERES = CPLib.GetProperty(p_PAESERES,"","",i);
      row.MTCN = CPLib.GetProperty(p_MTCN,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
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
  public MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
