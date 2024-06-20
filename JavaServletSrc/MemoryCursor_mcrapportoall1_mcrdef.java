// Definition generated from record definition mcrapportoall1_mcrdef
public class MemoryCursor_mcrapportoall1_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcrapportoall1_mcrdef row;
  MemoryCursorRow_mcrapportoall1_mcrdef empty_row;
  public MemoryCursor_mcrapportoall1_mcrdef() {
    empty_row = new MemoryCursorRow_mcrapportoall1_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcrapportoall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPOINTER;
    p_TIPOINTER = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_CODFIL;
    p_CODFIL = new java.util.Properties();
    java.util.Properties p_CABFIL;
    p_CABFIL = new java.util.Properties();
    java.util.Properties p_DATAPERT;
    p_DATAPERT = new java.util.Properties();
    java.util.Properties p_DATACHIU;
    p_DATACHIU = new java.util.Properties();
    java.util.Properties p_TIPORAPP;
    p_TIPORAPP = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_NDG;
    p_NDG = new java.util.Properties();
    java.util.Properties p_DATAINISOGG;
    p_DATAINISOGG = new java.util.Properties();
    java.util.Properties p_DATAFINSOGG;
    p_DATAFINSOGG = new java.util.Properties();
    java.util.Properties p_TIPOSOGG;
    p_TIPOSOGG = new java.util.Properties();
    java.util.Properties p_NDGSOGG;
    p_NDGSOGG = new java.util.Properties();
    java.util.Properties p_RAGSOG;
    p_RAGSOG = new java.util.Properties();
    java.util.Properties p_SESSOSOGG;
    p_SESSOSOGG = new java.util.Properties();
    java.util.Properties p_CODFISCSOGG;
    p_CODFISCSOGG = new java.util.Properties();
    java.util.Properties p_DATANASCSOGG;
    p_DATANASCSOGG = new java.util.Properties();
    java.util.Properties p_COMUNASCSOGG;
    p_COMUNASCSOGG = new java.util.Properties();
    java.util.Properties p_DENOMSOGG;
    p_DENOMSOGG = new java.util.Properties();
    java.util.Properties p_COMUNRESSOGG;
    p_COMUNRESSOGG = new java.util.Properties();
    java.util.Properties p_STATOSOGG;
    p_STATOSOGG = new java.util.Properties();
    java.util.Properties p_SAESOGG;
    p_SAESOGG = new java.util.Properties();
    java.util.Properties p_FILLER;
    p_FILLER = new java.util.Properties();
    java.util.Properties p_ATECOSOGG;
    p_ATECOSOGG = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINTER".equalsIgnoreCase(key)) {
        p_TIPOINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFIL".equalsIgnoreCase(key)) {
        p_CODFIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABFIL".equalsIgnoreCase(key)) {
        p_CABFIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAPERT".equalsIgnoreCase(key)) {
        p_DATAPERT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATACHIU".equalsIgnoreCase(key)) {
        p_DATACHIU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAPP".equalsIgnoreCase(key)) {
        p_TIPORAPP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDG".equalsIgnoreCase(key)) {
        p_NDG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINISOGG".equalsIgnoreCase(key)) {
        p_DATAINISOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINSOGG".equalsIgnoreCase(key)) {
        p_DATAFINSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSOGG".equalsIgnoreCase(key)) {
        p_TIPOSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDGSOGG".equalsIgnoreCase(key)) {
        p_NDGSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOG".equalsIgnoreCase(key)) {
        p_RAGSOG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSOSOGG".equalsIgnoreCase(key)) {
        p_SESSOSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISCSOGG".equalsIgnoreCase(key)) {
        p_CODFISCSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASCSOGG".equalsIgnoreCase(key)) {
        p_DATANASCSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNASCSOGG".equalsIgnoreCase(key)) {
        p_COMUNASCSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DENOMSOGG".equalsIgnoreCase(key)) {
        p_DENOMSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNRESSOGG".equalsIgnoreCase(key)) {
        p_COMUNRESSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOSOGG".equalsIgnoreCase(key)) {
        p_STATOSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SAESOGG".equalsIgnoreCase(key)) {
        p_SAESOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILLER".equalsIgnoreCase(key)) {
        p_FILLER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECOSOGG".equalsIgnoreCase(key)) {
        p_ATECOSOGG = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPOINTER = CPLib.GetProperty(p_TIPOINTER,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.CODFIL = CPLib.GetProperty(p_CODFIL,"","",i);
      row.CABFIL = CPLib.GetProperty(p_CABFIL,"","",i);
      row.DATAPERT = CPLib.GetProperty(p_DATAPERT,"",CPLib.NullDate(),i);
      row.DATACHIU = CPLib.GetProperty(p_DATACHIU,"",CPLib.NullDate(),i);
      row.TIPORAPP = CPLib.GetProperty(p_TIPORAPP,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.NDG = CPLib.GetProperty(p_NDG,"","",i);
      row.DATAINISOGG = CPLib.GetProperty(p_DATAINISOGG,"",CPLib.NullDate(),i);
      row.DATAFINSOGG = CPLib.GetProperty(p_DATAFINSOGG,"",CPLib.NullDate(),i);
      row.TIPOSOGG = CPLib.GetProperty(p_TIPOSOGG,"","",i);
      row.NDGSOGG = CPLib.GetProperty(p_NDGSOGG,"","",i);
      row.RAGSOG = CPLib.GetProperty(p_RAGSOG,"","",i);
      row.SESSOSOGG = CPLib.GetProperty(p_SESSOSOGG,"","",i);
      row.CODFISCSOGG = CPLib.GetProperty(p_CODFISCSOGG,"","",i);
      row.DATANASCSOGG = CPLib.GetProperty(p_DATANASCSOGG,"",CPLib.NullDate(),i);
      row.COMUNASCSOGG = CPLib.GetProperty(p_COMUNASCSOGG,"","",i);
      row.DENOMSOGG = CPLib.GetProperty(p_DENOMSOGG,"","",i);
      row.COMUNRESSOGG = CPLib.GetProperty(p_COMUNRESSOGG,"","",i);
      row.STATOSOGG = CPLib.GetProperty(p_STATOSOGG,"","",i);
      row.SAESOGG = CPLib.GetProperty(p_SAESOGG,"","",i);
      row.FILLER = CPLib.GetProperty(p_FILLER,"","",i);
      row.ATECOSOGG = CPLib.GetProperty(p_ATECOSOGG,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcrapportoall1_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcrapportoall1_mcrdef();
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
  public MemoryCursorRow_mcrapportoall1_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcrapportoall1_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcrapportoall1_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    MemoryCursorRow_mcrapportoall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrapportoall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcrapportoall1_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcrapportoall1_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
