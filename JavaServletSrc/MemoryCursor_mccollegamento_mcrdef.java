// Definition generated from record definition mccollegamento_mcrdef
public class MemoryCursor_mccollegamento_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccollegamento_mcrdef row;
  MemoryCursorRow_mccollegamento_mcrdef empty_row;
  public MemoryCursor_mccollegamento_mcrdef() {
    empty_row = new MemoryCursorRow_mccollegamento_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccollegamento_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CodiceIstituto;
    p_CodiceIstituto = new java.util.Properties();
    java.util.Properties p_DataElaborazione;
    p_DataElaborazione = new java.util.Properties();
    java.util.Properties p_ProceduraOrigine;
    p_ProceduraOrigine = new java.util.Properties();
    java.util.Properties p_NumeroElettronicoOperante;
    p_NumeroElettronicoOperante = new java.util.Properties();
    java.util.Properties p_SottoNumeroOperazione;
    p_SottoNumeroOperazione = new java.util.Properties();
    java.util.Properties p_CodiceCliente;
    p_CodiceCliente = new java.util.Properties();
    java.util.Properties p_RuoloCliente;
    p_RuoloCliente = new java.util.Properties();
    java.util.Properties p_EsecutoreOperazione;
    p_EsecutoreOperazione = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceIstituto".equalsIgnoreCase(key)) {
        p_CodiceIstituto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataElaborazione".equalsIgnoreCase(key)) {
        p_DataElaborazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProceduraOrigine".equalsIgnoreCase(key)) {
        p_ProceduraOrigine = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumeroElettronicoOperante".equalsIgnoreCase(key)) {
        p_NumeroElettronicoOperante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SottoNumeroOperazione".equalsIgnoreCase(key)) {
        p_SottoNumeroOperazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceCliente".equalsIgnoreCase(key)) {
        p_CodiceCliente = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RuoloCliente".equalsIgnoreCase(key)) {
        p_RuoloCliente = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EsecutoreOperazione".equalsIgnoreCase(key)) {
        p_EsecutoreOperazione = CPLib.GetProperties(p.getProperty(key));
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
      row.CodiceIstituto = CPLib.GetProperty(p_CodiceIstituto,"","",i);
      row.DataElaborazione = CPLib.GetProperty(p_DataElaborazione,"","",i);
      row.ProceduraOrigine = CPLib.GetProperty(p_ProceduraOrigine,"","",i);
      row.NumeroElettronicoOperante = CPLib.GetProperty(p_NumeroElettronicoOperante,"","",i);
      row.SottoNumeroOperazione = CPLib.GetProperty(p_SottoNumeroOperazione,"","",i);
      row.CodiceCliente = CPLib.GetProperty(p_CodiceCliente,"","",i);
      row.RuoloCliente = CPLib.GetProperty(p_RuoloCliente,"","",i);
      row.EsecutoreOperazione = CPLib.GetProperty(p_EsecutoreOperazione,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccollegamento_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccollegamento_mcrdef();
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
  public MemoryCursorRow_mccollegamento_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccollegamento_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccollegamento_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    MemoryCursorRow_mccollegamento_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccollegamento_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccollegamento_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccollegamento_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
