// Definition generated from record definition mcrtraaua_mcrdef
public class MemoryCursor_mcrtraaua_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcrtraaua_mcrdef row;
  MemoryCursorRow_mcrtraaua_mcrdef empty_row;
  public MemoryCursor_mcrtraaua_mcrdef() {
    empty_row = new MemoryCursorRow_mcrtraaua_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcrtraaua_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
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
    java.util.Properties p_TIPODOC;
    p_TIPODOC = new java.util.Properties();
    java.util.Properties p_NUMDOCUM;
    p_NUMDOCUM = new java.util.Properties();
    java.util.Properties p_DATARILASC;
    p_DATARILASC = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_FLGCFVALIDO;
    p_FLGCFVALIDO = new java.util.Properties();
    java.util.Properties p_FLGCGFORMAT;
    p_FLGCGFORMAT = new java.util.Properties();
    java.util.Properties p_ERR01;
    p_ERR01 = new java.util.Properties();
    java.util.Properties p_ERR02;
    p_ERR02 = new java.util.Properties();
    java.util.Properties p_ERR03;
    p_ERR03 = new java.util.Properties();
    java.util.Properties p_ERR04;
    p_ERR04 = new java.util.Properties();
    java.util.Properties p_ERR05;
    p_ERR05 = new java.util.Properties();
    java.util.Properties p_ERR06;
    p_ERR06 = new java.util.Properties();
    java.util.Properties p_ERR07;
    p_ERR07 = new java.util.Properties();
    java.util.Properties p_ERR08;
    p_ERR08 = new java.util.Properties();
    java.util.Properties p_ERR09;
    p_ERR09 = new java.util.Properties();
    java.util.Properties p_ERR10;
    p_ERR10 = new java.util.Properties();
    java.util.Properties p_DOCTYPE;
    p_DOCTYPE = new java.util.Properties();
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
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
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
      if ("TIPODOC".equalsIgnoreCase(key)) {
        p_TIPODOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDOCUM".equalsIgnoreCase(key)) {
        p_NUMDOCUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARILASC".equalsIgnoreCase(key)) {
        p_DATARILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGCFVALIDO".equalsIgnoreCase(key)) {
        p_FLGCFVALIDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGCGFORMAT".equalsIgnoreCase(key)) {
        p_FLGCGFORMAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR01".equalsIgnoreCase(key)) {
        p_ERR01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR02".equalsIgnoreCase(key)) {
        p_ERR02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR03".equalsIgnoreCase(key)) {
        p_ERR03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR04".equalsIgnoreCase(key)) {
        p_ERR04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR05".equalsIgnoreCase(key)) {
        p_ERR05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR06".equalsIgnoreCase(key)) {
        p_ERR06 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR07".equalsIgnoreCase(key)) {
        p_ERR07 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR08".equalsIgnoreCase(key)) {
        p_ERR08 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR09".equalsIgnoreCase(key)) {
        p_ERR09 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ERR10".equalsIgnoreCase(key)) {
        p_ERR10 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOCTYPE".equalsIgnoreCase(key)) {
        p_DOCTYPE = CPLib.GetProperties(p.getProperty(key));
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
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"",CPLib.NullDate(),i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.FLGCFVALIDO = CPLib.GetProperty(p_FLGCFVALIDO,"","",i);
      row.FLGCGFORMAT = CPLib.GetProperty(p_FLGCGFORMAT,"","",i);
      row.ERR01 = CPLib.GetProperty(p_ERR01,"","",i);
      row.ERR02 = CPLib.GetProperty(p_ERR02,"","",i);
      row.ERR03 = CPLib.GetProperty(p_ERR03,"","",i);
      row.ERR04 = CPLib.GetProperty(p_ERR04,"","",i);
      row.ERR05 = CPLib.GetProperty(p_ERR05,"","",i);
      row.ERR06 = CPLib.GetProperty(p_ERR06,"","",i);
      row.ERR07 = CPLib.GetProperty(p_ERR07,"","",i);
      row.ERR08 = CPLib.GetProperty(p_ERR08,"","",i);
      row.ERR09 = CPLib.GetProperty(p_ERR09,"","",i);
      row.ERR10 = CPLib.GetProperty(p_ERR10,"","",i);
      row.DOCTYPE = CPLib.GetProperty(p_DOCTYPE,"","",i);
      row.LUOGONAS = CPLib.GetProperty(p_LUOGONAS,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcrtraaua_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcrtraaua_mcrdef();
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
  public MemoryCursorRow_mcrtraaua_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcrtraaua_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcrtraaua_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    MemoryCursorRow_mcrtraaua_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrtraaua_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcrtraaua_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcrtraaua_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
