// Definition generated from record definition mcfamiglia_mcrdef
public class MemoryCursor_mcfamiglia_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcfamiglia_mcrdef row;
  MemoryCursorRow_mcfamiglia_mcrdef empty_row;
  public MemoryCursor_mcfamiglia_mcrdef() {
    empty_row = new MemoryCursorRow_mcfamiglia_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcfamiglia_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPOSOG;
    p_TIPOSOG = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_LUONAS;
    p_LUONAS = new java.util.Properties();
    java.util.Properties p_DATNAS;
    p_DATNAS = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_SEDELEG;
    p_SEDELEG = new java.util.Properties();
    java.util.Properties p_PROVLEG;
    p_PROVLEG = new java.util.Properties();
    java.util.Properties p_PROVNAS;
    p_PROVNAS = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_ORIGINE;
    p_ORIGINE = new java.util.Properties();
    java.util.Properties p_MATCH;
    p_MATCH = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSOG".equalsIgnoreCase(key)) {
        p_TIPOSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LUONAS".equalsIgnoreCase(key)) {
        p_LUONAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATNAS".equalsIgnoreCase(key)) {
        p_DATNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEDELEG".equalsIgnoreCase(key)) {
        p_SEDELEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVLEG".equalsIgnoreCase(key)) {
        p_PROVLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVNAS".equalsIgnoreCase(key)) {
        p_PROVNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ORIGINE".equalsIgnoreCase(key)) {
        p_ORIGINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MATCH".equalsIgnoreCase(key)) {
        p_MATCH = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPOSOG = CPLib.GetProperty(p_TIPOSOG,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.LUONAS = CPLib.GetProperty(p_LUONAS,"","",i);
      row.DATNAS = CPLib.GetProperty(p_DATNAS,"",CPLib.NullDate(),i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.SEDELEG = CPLib.GetProperty(p_SEDELEG,"","",i);
      row.PROVLEG = CPLib.GetProperty(p_PROVLEG,"","",i);
      row.PROVNAS = CPLib.GetProperty(p_PROVNAS,"","",i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
      row.ORIGINE = CPLib.GetProperty(p_ORIGINE,"","",i);
      row.MATCH = CPLib.GetProperty(p_MATCH,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcfamiglia_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcfamiglia_mcrdef();
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
  public MemoryCursorRow_mcfamiglia_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcfamiglia_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcfamiglia_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    MemoryCursorRow_mcfamiglia_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcfamiglia_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcfamiglia_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcfamiglia_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
