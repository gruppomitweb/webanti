// Definition generated from record definition mccrimestructure_mcrdef
public class MemoryCursor_mccrimestructure_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccrimestructure_mcrdef row;
  MemoryCursorRow_mccrimestructure_mcrdef empty_row;
  public MemoryCursor_mccrimestructure_mcrdef() {
    empty_row = new MemoryCursorRow_mccrimestructure_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccrimestructure_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_annoDelibera;
    p_annoDelibera = new java.util.Properties();
    java.util.Properties p_attinenza;
    p_attinenza = new java.util.Properties();
    java.util.Properties p_chiaveArticolo;
    p_chiaveArticolo = new java.util.Properties();
    java.util.Properties p_cognomeNome;
    p_cognomeNome = new java.util.Properties();
    java.util.Properties p_dataNascita;
    p_dataNascita = new java.util.Properties();
    java.util.Properties p_luogoNascita;
    p_luogoNascita = new java.util.Properties();
    java.util.Properties p_dataPubblicazione;
    p_dataPubblicazione = new java.util.Properties();
    java.util.Properties p_edizione;
    p_edizione = new java.util.Properties();
    java.util.Properties p_fonte;
    p_fonte = new java.util.Properties();
    java.util.Properties p_origine;
    p_origine = new java.util.Properties();
    java.util.Properties p_percentuale;
    p_percentuale = new java.util.Properties();
    java.util.Properties p_oggetto;
    p_oggetto = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("annoDelibera".equalsIgnoreCase(key)) {
        p_annoDelibera = CPLib.GetProperties(p.getProperty(key));
      }
      if ("attinenza".equalsIgnoreCase(key)) {
        p_attinenza = CPLib.GetProperties(p.getProperty(key));
      }
      if ("chiaveArticolo".equalsIgnoreCase(key)) {
        p_chiaveArticolo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("cognomeNome".equalsIgnoreCase(key)) {
        p_cognomeNome = CPLib.GetProperties(p.getProperty(key));
      }
      if ("dataNascita".equalsIgnoreCase(key)) {
        p_dataNascita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("luogoNascita".equalsIgnoreCase(key)) {
        p_luogoNascita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("dataPubblicazione".equalsIgnoreCase(key)) {
        p_dataPubblicazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("edizione".equalsIgnoreCase(key)) {
        p_edizione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("fonte".equalsIgnoreCase(key)) {
        p_fonte = CPLib.GetProperties(p.getProperty(key));
      }
      if ("origine".equalsIgnoreCase(key)) {
        p_origine = CPLib.GetProperties(p.getProperty(key));
      }
      if ("percentuale".equalsIgnoreCase(key)) {
        p_percentuale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("oggetto".equalsIgnoreCase(key)) {
        p_oggetto = CPLib.GetProperties(p.getProperty(key));
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
      row.annoDelibera = CPLib.GetProperty(p_annoDelibera,"",0,i);
      row.attinenza = CPLib.GetProperty(p_attinenza,"",0,i);
      row.chiaveArticolo = CPLib.GetProperty(p_chiaveArticolo,"","",i);
      row.cognomeNome = CPLib.GetProperty(p_cognomeNome,"","",i);
      row.dataNascita = CPLib.GetProperty(p_dataNascita,"",CPLib.NullDate(),i);
      row.luogoNascita = CPLib.GetProperty(p_luogoNascita,"","",i);
      row.dataPubblicazione = CPLib.GetProperty(p_dataPubblicazione,"",CPLib.NullDate(),i);
      row.edizione = CPLib.GetProperty(p_edizione,"","",i);
      row.fonte = CPLib.GetProperty(p_fonte,"","",i);
      row.origine = CPLib.GetProperty(p_origine,"","",i);
      row.percentuale = CPLib.GetProperty(p_percentuale,"",0,i);
      row.oggetto = CPLib.GetProperty(p_oggetto,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccrimestructure_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccrimestructure_mcrdef();
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
  public MemoryCursorRow_mccrimestructure_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccrimestructure_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccrimestructure_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    MemoryCursorRow_mccrimestructure_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccrimestructure_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccrimestructure_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccrimestructure_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
