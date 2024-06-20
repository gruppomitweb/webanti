// Definition generated from table tmp_saldi
public class MemoryCursor_tmp_saldi extends CPMemoryCursor {
  MemoryCursorRow_tmp_saldi row;
  MemoryCursorRow_tmp_saldi empty_row;
  public MemoryCursor_tmp_saldi() {
    empty_row = new MemoryCursorRow_tmp_saldi();
    row = empty_row;
  }
  public MemoryCursor_tmp_saldi(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPODAT;
    p_TIPODAT = new java.util.Properties();
    java.util.Properties p_PROGR;
    p_PROGR = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_DESCRAP;
    p_DESCRAP = new java.util.Properties();
    java.util.Properties p_CODRAP;
    p_CODRAP = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_IMP1;
    p_IMP1 = new java.util.Properties();
    java.util.Properties p_IMP2;
    p_IMP2 = new java.util.Properties();
    java.util.Properties p_IMP3;
    p_IMP3 = new java.util.Properties();
    java.util.Properties p_IMP4;
    p_IMP4 = new java.util.Properties();
    java.util.Properties p_NUM;
    p_NUM = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_IDESITO;
    p_IDESITO = new java.util.Properties();
    java.util.Properties p_PROGR2;
    p_PROGR2 = new java.util.Properties();
    java.util.Properties p_IDFILE;
    p_IDFILE = new java.util.Properties();
    java.util.Properties p_IDPROG;
    p_IDPROG = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_OLDINTER;
    p_OLDINTER = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_TERNAFILE;
    p_TERNAFILE = new java.util.Properties();
    java.util.Properties p_TERNAPROG;
    p_TERNAPROG = new java.util.Properties();
    java.util.Properties p_CONNESINT;
    p_CONNESINT = new java.util.Properties();
    java.util.Properties p_PROGGEN;
    p_PROGGEN = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPODAT".equalsIgnoreCase(key)) {
        p_TIPODAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGR".equalsIgnoreCase(key)) {
        p_PROGR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRAP".equalsIgnoreCase(key)) {
        p_DESCRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODRAP".equalsIgnoreCase(key)) {
        p_CODRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMP1".equalsIgnoreCase(key)) {
        p_IMP1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMP2".equalsIgnoreCase(key)) {
        p_IMP2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMP3".equalsIgnoreCase(key)) {
        p_IMP3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMP4".equalsIgnoreCase(key)) {
        p_IMP4 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUM".equalsIgnoreCase(key)) {
        p_NUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDESITO".equalsIgnoreCase(key)) {
        p_IDESITO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGR2".equalsIgnoreCase(key)) {
        p_PROGR2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDFILE".equalsIgnoreCase(key)) {
        p_IDFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDPROG".equalsIgnoreCase(key)) {
        p_IDPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OLDINTER".equalsIgnoreCase(key)) {
        p_OLDINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TERNAFILE".equalsIgnoreCase(key)) {
        p_TERNAFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TERNAPROG".equalsIgnoreCase(key)) {
        p_TERNAPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESINT".equalsIgnoreCase(key)) {
        p_CONNESINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROGGEN".equalsIgnoreCase(key)) {
        p_PROGGEN = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPODAT = CPLib.GetProperty(p_TIPODAT,"","",i);
      row.PROGR = CPLib.GetProperty(p_PROGR,"","",i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.DESCRAP = CPLib.GetProperty(p_DESCRAP,"","",i);
      row.CODRAP = CPLib.GetProperty(p_CODRAP,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.IMP1 = CPLib.GetProperty(p_IMP1,"","",i);
      row.IMP2 = CPLib.GetProperty(p_IMP2,"","",i);
      row.IMP3 = CPLib.GetProperty(p_IMP3,"","",i);
      row.IMP4 = CPLib.GetProperty(p_IMP4,"","",i);
      row.NUM = CPLib.GetProperty(p_NUM,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.IDESITO = CPLib.GetProperty(p_IDESITO,"","",i);
      row.PROGR2 = CPLib.GetProperty(p_PROGR2,"","",i);
      row.IDFILE = CPLib.GetProperty(p_IDFILE,"","",i);
      row.IDPROG = CPLib.GetProperty(p_IDPROG,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.OLDINTER = CPLib.GetProperty(p_OLDINTER,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.TERNAFILE = CPLib.GetProperty(p_TERNAFILE,"","",i);
      row.TERNAPROG = CPLib.GetProperty(p_TERNAPROG,"","",i);
      row.CONNESINT = CPLib.GetProperty(p_CONNESINT,"","",i);
      row.PROGGEN = CPLib.GetProperty(p_PROGGEN,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_saldi)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_saldi();
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
  public MemoryCursorRow_tmp_saldi _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_saldi _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_saldi> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_saldi p_Row) {
    MemoryCursorRow_tmp_saldi l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_saldi();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_saldi p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_saldi();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
