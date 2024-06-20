// Definition generated from record definition mcxlsritmcf_mcrdef
public class MemoryCursor_mcxlsritmcf_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcxlsritmcf_mcrdef row;
  MemoryCursorRow_mcxlsritmcf_mcrdef empty_row;
  public MemoryCursor_mcxlsritmcf_mcrdef() {
    empty_row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcxlsritmcf_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_NDG;
    p_NDG = new java.util.Properties();
    java.util.Properties p_CODFSC;
    p_CODFSC = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_DATNASC;
    p_DATNASC = new java.util.Properties();
    java.util.Properties p_NASCOD;
    p_NASCOD = new java.util.Properties();
    java.util.Properties p_NASNOM;
    p_NASNOM = new java.util.Properties();
    java.util.Properties p_NASPRV;
    p_NASPRV = new java.util.Properties();
    java.util.Properties p_CODRIT;
    p_CODRIT = new java.util.Properties();
    java.util.Properties p_DESRIT;
    p_DESRIT = new java.util.Properties();
    java.util.Properties p_CODFSCAGE;
    p_CODFSCAGE = new java.util.Properties();
    java.util.Properties p_COGNOMEAGE;
    p_COGNOMEAGE = new java.util.Properties();
    java.util.Properties p_NOMEAGE;
    p_NOMEAGE = new java.util.Properties();
    java.util.Properties p_SESSOAGE;
    p_SESSOAGE = new java.util.Properties();
    java.util.Properties p_DATNASCAGE;
    p_DATNASCAGE = new java.util.Properties();
    java.util.Properties p_NASNOMAGE;
    p_NASNOMAGE = new java.util.Properties();
    java.util.Properties p_NASPRVAGE;
    p_NASPRVAGE = new java.util.Properties();
    java.util.Properties p_CODFSCAUI;
    p_CODFSCAUI = new java.util.Properties();
    java.util.Properties p_COGNOMEAUI;
    p_COGNOMEAUI = new java.util.Properties();
    java.util.Properties p_NOMEAUI;
    p_NOMEAUI = new java.util.Properties();
    java.util.Properties p_SESSOAUI;
    p_SESSOAUI = new java.util.Properties();
    java.util.Properties p_DATNASCAUI;
    p_DATNASCAUI = new java.util.Properties();
    java.util.Properties p_NASNOMAUI;
    p_NASNOMAUI = new java.util.Properties();
    java.util.Properties p_NASPRVAUI;
    p_NASPRVAUI = new java.util.Properties();
    java.util.Properties p_TIPDOCAUI;
    p_TIPDOCAUI = new java.util.Properties();
    java.util.Properties p_NUMDOCAUI;
    p_NUMDOCAUI = new java.util.Properties();
    java.util.Properties p_AUTRILAUI;
    p_AUTRILAUI = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDG".equalsIgnoreCase(key)) {
        p_NDG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFSC".equalsIgnoreCase(key)) {
        p_CODFSC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATNASC".equalsIgnoreCase(key)) {
        p_DATNASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOD".equalsIgnoreCase(key)) {
        p_NASCOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASNOM".equalsIgnoreCase(key)) {
        p_NASNOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASPRV".equalsIgnoreCase(key)) {
        p_NASPRV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODRIT".equalsIgnoreCase(key)) {
        p_CODRIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESRIT".equalsIgnoreCase(key)) {
        p_DESRIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFSCAGE".equalsIgnoreCase(key)) {
        p_CODFSCAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOMEAGE".equalsIgnoreCase(key)) {
        p_COGNOMEAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOMEAGE".equalsIgnoreCase(key)) {
        p_NOMEAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSOAGE".equalsIgnoreCase(key)) {
        p_SESSOAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATNASCAGE".equalsIgnoreCase(key)) {
        p_DATNASCAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASNOMAGE".equalsIgnoreCase(key)) {
        p_NASNOMAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASPRVAGE".equalsIgnoreCase(key)) {
        p_NASPRVAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFSCAUI".equalsIgnoreCase(key)) {
        p_CODFSCAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOMEAUI".equalsIgnoreCase(key)) {
        p_COGNOMEAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOMEAUI".equalsIgnoreCase(key)) {
        p_NOMEAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSOAUI".equalsIgnoreCase(key)) {
        p_SESSOAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATNASCAUI".equalsIgnoreCase(key)) {
        p_DATNASCAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASNOMAUI".equalsIgnoreCase(key)) {
        p_NASNOMAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASPRVAUI".equalsIgnoreCase(key)) {
        p_NASPRVAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPDOCAUI".equalsIgnoreCase(key)) {
        p_TIPDOCAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDOCAUI".equalsIgnoreCase(key)) {
        p_NUMDOCAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AUTRILAUI".equalsIgnoreCase(key)) {
        p_AUTRILAUI = CPLib.GetProperties(p.getProperty(key));
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
      row.NDG = CPLib.GetProperty(p_NDG,"","",i);
      row.CODFSC = CPLib.GetProperty(p_CODFSC,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.DATNASC = CPLib.GetProperty(p_DATNASC,"","",i);
      row.NASCOD = CPLib.GetProperty(p_NASCOD,"","",i);
      row.NASNOM = CPLib.GetProperty(p_NASNOM,"","",i);
      row.NASPRV = CPLib.GetProperty(p_NASPRV,"","",i);
      row.CODRIT = CPLib.GetProperty(p_CODRIT,"","",i);
      row.DESRIT = CPLib.GetProperty(p_DESRIT,"","",i);
      row.CODFSCAGE = CPLib.GetProperty(p_CODFSCAGE,"","",i);
      row.COGNOMEAGE = CPLib.GetProperty(p_COGNOMEAGE,"","",i);
      row.NOMEAGE = CPLib.GetProperty(p_NOMEAGE,"","",i);
      row.SESSOAGE = CPLib.GetProperty(p_SESSOAGE,"","",i);
      row.DATNASCAGE = CPLib.GetProperty(p_DATNASCAGE,"","",i);
      row.NASNOMAGE = CPLib.GetProperty(p_NASNOMAGE,"","",i);
      row.NASPRVAGE = CPLib.GetProperty(p_NASPRVAGE,"","",i);
      row.CODFSCAUI = CPLib.GetProperty(p_CODFSCAUI,"","",i);
      row.COGNOMEAUI = CPLib.GetProperty(p_COGNOMEAUI,"","",i);
      row.NOMEAUI = CPLib.GetProperty(p_NOMEAUI,"","",i);
      row.SESSOAUI = CPLib.GetProperty(p_SESSOAUI,"","",i);
      row.DATNASCAUI = CPLib.GetProperty(p_DATNASCAUI,"","",i);
      row.NASNOMAUI = CPLib.GetProperty(p_NASNOMAUI,"","",i);
      row.NASPRVAUI = CPLib.GetProperty(p_NASPRVAUI,"","",i);
      row.TIPDOCAUI = CPLib.GetProperty(p_TIPDOCAUI,"","",i);
      row.NUMDOCAUI = CPLib.GetProperty(p_NUMDOCAUI,"","",i);
      row.AUTRILAUI = CPLib.GetProperty(p_AUTRILAUI,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcxlsritmcf_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcxlsritmcf_mcrdef();
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
  public MemoryCursorRow_mcxlsritmcf_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcxlsritmcf_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcxlsritmcf_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    MemoryCursorRow_mcxlsritmcf_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcxlsritmcf_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcxlsritmcf_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
