// Definition generated from record definition mcoperazionico_mcrdef
public class MemoryCursor_mcoperazionico_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcoperazionico_mcrdef row;
  MemoryCursorRow_mcoperazionico_mcrdef empty_row;
  public MemoryCursor_mcoperazionico_mcrdef() {
    empty_row = new MemoryCursorRow_mcoperazionico_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcoperazionico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONTAOPE;
    p_CONTAOPE = new java.util.Properties();
    java.util.Properties p_CODICE_SEGNALANTE;
    p_CODICE_SEGNALANTE = new java.util.Properties();
    java.util.Properties p_DATA_CONTABILE;
    p_DATA_CONTABILE = new java.util.Properties();
    java.util.Properties p_ID_OPERAZIONE;
    p_ID_OPERAZIONE = new java.util.Properties();
    java.util.Properties p_DATA_CONT_OPERAZ;
    p_DATA_CONT_OPERAZ = new java.util.Properties();
    java.util.Properties p_TIPO_OPERAZIONE;
    p_TIPO_OPERAZIONE = new java.util.Properties();
    java.util.Properties p_SEGNO_OPERAZ;
    p_SEGNO_OPERAZ = new java.util.Properties();
    java.util.Properties p_COD_VALUTA;
    p_COD_VALUTA = new java.util.Properties();
    java.util.Properties p_IMPORTO_OPERAZ;
    p_IMPORTO_OPERAZ = new java.util.Properties();
    java.util.Properties p_IMPORTO_CONT;
    p_IMPORTO_CONT = new java.util.Properties();
    java.util.Properties p_CODICE_FILIALE;
    p_CODICE_FILIALE = new java.util.Properties();
    java.util.Properties p_UL_BANCARIA_CAB;
    p_UL_BANCARIA_CAB = new java.util.Properties();
    java.util.Properties p_COMUNE_ESEC;
    p_COMUNE_ESEC = new java.util.Properties();
    java.util.Properties p_CAT_RAPPORTO;
    p_CAT_RAPPORTO = new java.util.Properties();
    java.util.Properties p_NUMERO_RAPPORTO;
    p_NUMERO_RAPPORTO = new java.util.Properties();
    java.util.Properties p_FILIALE;
    p_FILIALE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTAOPE".equalsIgnoreCase(key)) {
        p_CONTAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_SEGNALANTE".equalsIgnoreCase(key)) {
        p_CODICE_SEGNALANTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_CONTABILE".equalsIgnoreCase(key)) {
        p_DATA_CONTABILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ID_OPERAZIONE".equalsIgnoreCase(key)) {
        p_ID_OPERAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_CONT_OPERAZ".equalsIgnoreCase(key)) {
        p_DATA_CONT_OPERAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO_OPERAZIONE".equalsIgnoreCase(key)) {
        p_TIPO_OPERAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO_OPERAZ".equalsIgnoreCase(key)) {
        p_SEGNO_OPERAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_VALUTA".equalsIgnoreCase(key)) {
        p_COD_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_OPERAZ".equalsIgnoreCase(key)) {
        p_IMPORTO_OPERAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_CONT".equalsIgnoreCase(key)) {
        p_IMPORTO_CONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_FILIALE".equalsIgnoreCase(key)) {
        p_CODICE_FILIALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UL_BANCARIA_CAB".equalsIgnoreCase(key)) {
        p_UL_BANCARIA_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_ESEC".equalsIgnoreCase(key)) {
        p_COMUNE_ESEC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAT_RAPPORTO".equalsIgnoreCase(key)) {
        p_CAT_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMERO_RAPPORTO".equalsIgnoreCase(key)) {
        p_NUMERO_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILIALE".equalsIgnoreCase(key)) {
        p_FILIALE = CPLib.GetProperties(p.getProperty(key));
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
      row.CONTAOPE = CPLib.GetProperty(p_CONTAOPE,"",0,i);
      row.CODICE_SEGNALANTE = CPLib.GetProperty(p_CODICE_SEGNALANTE,"","",i);
      row.DATA_CONTABILE = CPLib.GetProperty(p_DATA_CONTABILE,"","",i);
      row.ID_OPERAZIONE = CPLib.GetProperty(p_ID_OPERAZIONE,"",0,i);
      row.DATA_CONT_OPERAZ = CPLib.GetProperty(p_DATA_CONT_OPERAZ,"","",i);
      row.TIPO_OPERAZIONE = CPLib.GetProperty(p_TIPO_OPERAZIONE,"","",i);
      row.SEGNO_OPERAZ = CPLib.GetProperty(p_SEGNO_OPERAZ,"","",i);
      row.COD_VALUTA = CPLib.GetProperty(p_COD_VALUTA,"","",i);
      row.IMPORTO_OPERAZ = CPLib.GetProperty(p_IMPORTO_OPERAZ,"",0,i);
      row.IMPORTO_CONT = CPLib.GetProperty(p_IMPORTO_CONT,"",0,i);
      row.CODICE_FILIALE = CPLib.GetProperty(p_CODICE_FILIALE,"","",i);
      row.UL_BANCARIA_CAB = CPLib.GetProperty(p_UL_BANCARIA_CAB,"","",i);
      row.COMUNE_ESEC = CPLib.GetProperty(p_COMUNE_ESEC,"","",i);
      row.CAT_RAPPORTO = CPLib.GetProperty(p_CAT_RAPPORTO,"","",i);
      row.NUMERO_RAPPORTO = CPLib.GetProperty(p_NUMERO_RAPPORTO,"","",i);
      row.FILIALE = CPLib.GetProperty(p_FILIALE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcoperazionico_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcoperazionico_mcrdef();
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
  public MemoryCursorRow_mcoperazionico_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcoperazionico_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcoperazionico_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    MemoryCursorRow_mcoperazionico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazionico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcoperazionico_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcoperazionico_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
