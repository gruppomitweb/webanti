// Definition generated from query qbe_rtra_aua_1_vqr
public class MemoryCursor_qbe_rtra_aua_1_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_rtra_aua_1_vqr row;
  MemoryCursorRow_qbe_rtra_aua_1_vqr empty_row;
  public MemoryCursor_qbe_rtra_aua_1_vqr() {
    empty_row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_rtra_aua_1_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_NASSTATO;
    p_NASSTATO = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_LUOGONAS;
    p_LUOGONAS = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASSTATO".equalsIgnoreCase(key)) {
        p_NASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LUOGONAS".equalsIgnoreCase(key)) {
        p_LUOGONAS = CPLib.GetProperties(p.getProperty(key));
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
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.LUOGONAS = CPLib.GetProperty(p_LUOGONAS,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_rtra_aua_1_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_rtra_aua_1_vqr();
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
  public MemoryCursorRow_qbe_rtra_aua_1_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_rtra_aua_1_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_rtra_aua_1_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    MemoryCursorRow_qbe_rtra_aua_1_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_rtra_aua_1_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
