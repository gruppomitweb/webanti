// Definition generated from table opextrbo
public class MemoryCursor_opextrbo extends CPMemoryCursor {
  MemoryCursorRow_opextrbo row;
  MemoryCursorRow_opextrbo empty_row;
  public MemoryCursor_opextrbo() {
    empty_row = new MemoryCursorRow_opextrbo();
    row = empty_row;
  }
  public MemoryCursor_opextrbo(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_COLLEG;
    p_COLLEG = new java.util.Properties();
    java.util.Properties p_ANNO;
    p_ANNO = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_COINT;
    p_COINT = new java.util.Properties();
    java.util.Properties p_NOTE;
    p_NOTE = new java.util.Properties();
    java.util.Properties p_NUMPROG1;
    p_NUMPROG1 = new java.util.Properties();
    java.util.Properties p_RIFIMP;
    p_RIFIMP = new java.util.Properties();
    java.util.Properties p_IDFILE;
    p_IDFILE = new java.util.Properties();
    java.util.Properties p_PROGOPEX;
    p_PROGOPEX = new java.util.Properties();
    java.util.Properties p_SALDO;
    p_SALDO = new java.util.Properties();
    java.util.Properties p_QUANTITA;
    p_QUANTITA = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_UNIQUER;
    p_UNIQUER = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_OLDINTER;
    p_OLDINTER = new java.util.Properties();
    java.util.Properties p_DATAMODI;
    p_DATAMODI = new java.util.Properties();
    java.util.Properties p_INVIATO;
    p_INVIATO = new java.util.Properties();
    java.util.Properties p_DATAINVIO;
    p_DATAINVIO = new java.util.Properties();
    java.util.Properties p_ANNULLA;
    p_ANNULLA = new java.util.Properties();
    java.util.Properties p_DATAANNU;
    p_DATAANNU = new java.util.Properties();
    java.util.Properties p_OLDUNIQUE;
    p_OLDUNIQUE = new java.util.Properties();
    java.util.Properties p_DATAOLDUNI;
    p_DATAOLDUNI = new java.util.Properties();
    java.util.Properties p_IDESITO;
    p_IDESITO = new java.util.Properties();
    java.util.Properties p_CONNESOPER;
    p_CONNESOPER = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_INVSALDO;
    p_INVSALDO = new java.util.Properties();
    java.util.Properties p_DTSALDO;
    p_DTSALDO = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_INFORM;
    p_INFORM = new java.util.Properties();
    java.util.Properties p_NATURA;
    p_NATURA = new java.util.Properties();
    java.util.Properties p_FLGNOE;
    p_FLGNOE = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COLLEG".equalsIgnoreCase(key)) {
        p_COLLEG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNO".equalsIgnoreCase(key)) {
        p_ANNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COINT".equalsIgnoreCase(key)) {
        p_COINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOTE".equalsIgnoreCase(key)) {
        p_NOTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG1".equalsIgnoreCase(key)) {
        p_NUMPROG1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RIFIMP".equalsIgnoreCase(key)) {
        p_RIFIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILE".equalsIgnoreCase(key)) {
        p_IDFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGOPEX".equalsIgnoreCase(key)) {
        p_PROGOPEX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SALDO".equalsIgnoreCase(key)) {
        p_SALDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("QUANTITA".equalsIgnoreCase(key)) {
        p_QUANTITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("UNIQUER".equalsIgnoreCase(key)) {
        p_UNIQUER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDINTER".equalsIgnoreCase(key)) {
        p_OLDINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAMODI".equalsIgnoreCase(key)) {
        p_DATAMODI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INVIATO".equalsIgnoreCase(key)) {
        p_INVIATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINVIO".equalsIgnoreCase(key)) {
        p_DATAINVIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANNULLA".equalsIgnoreCase(key)) {
        p_ANNULLA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAANNU".equalsIgnoreCase(key)) {
        p_DATAANNU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDUNIQUE".equalsIgnoreCase(key)) {
        p_OLDUNIQUE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOLDUNI".equalsIgnoreCase(key)) {
        p_DATAOLDUNI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDESITO".equalsIgnoreCase(key)) {
        p_IDESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESOPER".equalsIgnoreCase(key)) {
        p_CONNESOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INVSALDO".equalsIgnoreCase(key)) {
        p_INVSALDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DTSALDO".equalsIgnoreCase(key)) {
        p_DTSALDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INFORM".equalsIgnoreCase(key)) {
        p_INFORM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATURA".equalsIgnoreCase(key)) {
        p_NATURA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGNOE".equalsIgnoreCase(key)) {
        p_FLGNOE = CPLib.GetProperties(p.getProperty(key));
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
      row.COLLEG = CPLib.GetProperty(p_COLLEG,"","",i);
      row.ANNO = CPLib.GetProperty(p_ANNO,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.COINT = CPLib.GetProperty(p_COINT,"","",i);
      row.NOTE = CPLib.GetProperty(p_NOTE,"","",i);
      row.NUMPROG1 = CPLib.GetProperty(p_NUMPROG1,"","",i);
      row.RIFIMP = CPLib.GetProperty(p_RIFIMP,"","",i);
      row.IDFILE = CPLib.GetProperty(p_IDFILE,"","",i);
      row.PROGOPEX = CPLib.GetProperty(p_PROGOPEX,"",0,i);
      row.SALDO = CPLib.GetProperty(p_SALDO,"",0,i);
      row.QUANTITA = CPLib.GetProperty(p_QUANTITA,"",0,i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.UNIQUER = CPLib.GetProperty(p_UNIQUER,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.OLDINTER = CPLib.GetProperty(p_OLDINTER,"","",i);
      row.DATAMODI = CPLib.GetProperty(p_DATAMODI,"",CPLib.NullDate(),i);
      row.INVIATO = CPLib.GetProperty(p_INVIATO,"",0,i);
      row.DATAINVIO = CPLib.GetProperty(p_DATAINVIO,"",CPLib.NullDate(),i);
      row.ANNULLA = CPLib.GetProperty(p_ANNULLA,"",0,i);
      row.DATAANNU = CPLib.GetProperty(p_DATAANNU,"",CPLib.NullDate(),i);
      row.OLDUNIQUE = CPLib.GetProperty(p_OLDUNIQUE,"","",i);
      row.DATAOLDUNI = CPLib.GetProperty(p_DATAOLDUNI,"",CPLib.NullDate(),i);
      row.IDESITO = CPLib.GetProperty(p_IDESITO,"","",i);
      row.CONNESOPER = CPLib.GetProperty(p_CONNESOPER,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.INVSALDO = CPLib.GetProperty(p_INVSALDO,"",0,i);
      row.DTSALDO = CPLib.GetProperty(p_DTSALDO,"",CPLib.NullDate(),i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"","",i);
      row.INFORM = CPLib.GetProperty(p_INFORM,"","",i);
      row.NATURA = CPLib.GetProperty(p_NATURA,"","",i);
      row.FLGNOE = CPLib.GetProperty(p_FLGNOE,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_opextrbo)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_opextrbo();
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
  public MemoryCursorRow_opextrbo _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_opextrbo _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_opextrbo> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_opextrbo p_Row) {
    MemoryCursorRow_opextrbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_opextrbo();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_opextrbo p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_opextrbo();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
