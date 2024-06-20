// Definition generated from record definition mccategorizzazione_mcrdef
public class MemoryCursor_mccategorizzazione_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccategorizzazione_mcrdef row;
  MemoryCursorRow_mccategorizzazione_mcrdef empty_row;
  public MemoryCursor_mccategorizzazione_mcrdef() {
    empty_row = new MemoryCursorRow_mccategorizzazione_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccategorizzazione_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODIST;
    p_CODIST = new java.util.Properties();
    java.util.Properties p_TIPOINT;
    p_TIPOINT = new java.util.Properties();
    java.util.Properties p_CODINT;
    p_CODINT = new java.util.Properties();
    java.util.Properties p_IDSOGG;
    p_IDSOGG = new java.util.Properties();
    java.util.Properties p_COD_TIPO_SOGG;
    p_COD_TIPO_SOGG = new java.util.Properties();
    java.util.Properties p_COD_STATO;
    p_COD_STATO = new java.util.Properties();
    java.util.Properties p_COD_SPEC_GIUR;
    p_COD_SPEC_GIUR = new java.util.Properties();
    java.util.Properties p_COD_SETT;
    p_COD_SETT = new java.util.Properties();
    java.util.Properties p_COD_RAMO;
    p_COD_RAMO = new java.util.Properties();
    java.util.Properties p_COD_NDG_GRUP_ECON;
    p_COD_NDG_GRUP_ECON = new java.util.Properties();
    java.util.Properties p_COD_ATECO;
    p_COD_ATECO = new java.util.Properties();
    java.util.Properties p_SEG_CAN_TERZI;
    p_SEG_CAN_TERZI = new java.util.Properties();
    java.util.Properties p_COD_TIT_EFFETTIVO;
    p_COD_TIT_EFFETTIVO = new java.util.Properties();
    java.util.Properties p_COD_COMP_RILE;
    p_COD_COMP_RILE = new java.util.Properties();
    java.util.Properties p_COD_SCOPO_RAPP;
    p_COD_SCOPO_RAPP = new java.util.Properties();
    java.util.Properties p_NDG_SOGG_PRIMARIO;
    p_NDG_SOGG_PRIMARIO = new java.util.Properties();
    java.util.Properties p_TIPO_RELAZIONE;
    p_TIPO_RELAZIONE = new java.util.Properties();
    java.util.Properties p_NAT_GIURIDICA;
    p_NAT_GIURIDICA = new java.util.Properties();
    java.util.Properties p_CATENA_CTRL;
    p_CATENA_CTRL = new java.util.Properties();
    java.util.Properties p_AMMONTARE;
    p_AMMONTARE = new java.util.Properties();
    java.util.Properties p_COD_FILIALE;
    p_COD_FILIALE = new java.util.Properties();
    java.util.Properties p_DESC_FILIALE;
    p_DESC_FILIALE = new java.util.Properties();
    java.util.Properties p_OPERATIVITA;
    p_OPERATIVITA = new java.util.Properties();
    java.util.Properties p_COMPORTAMENTO;
    p_COMPORTAMENTO = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODIST".equalsIgnoreCase(key)) {
        p_CODIST = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINT".equalsIgnoreCase(key)) {
        p_TIPOINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINT".equalsIgnoreCase(key)) {
        p_CODINT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDSOGG".equalsIgnoreCase(key)) {
        p_IDSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_TIPO_SOGG".equalsIgnoreCase(key)) {
        p_COD_TIPO_SOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_STATO".equalsIgnoreCase(key)) {
        p_COD_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_SPEC_GIUR".equalsIgnoreCase(key)) {
        p_COD_SPEC_GIUR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_SETT".equalsIgnoreCase(key)) {
        p_COD_SETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_RAMO".equalsIgnoreCase(key)) {
        p_COD_RAMO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_NDG_GRUP_ECON".equalsIgnoreCase(key)) {
        p_COD_NDG_GRUP_ECON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_ATECO".equalsIgnoreCase(key)) {
        p_COD_ATECO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEG_CAN_TERZI".equalsIgnoreCase(key)) {
        p_SEG_CAN_TERZI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_TIT_EFFETTIVO".equalsIgnoreCase(key)) {
        p_COD_TIT_EFFETTIVO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_COMP_RILE".equalsIgnoreCase(key)) {
        p_COD_COMP_RILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_SCOPO_RAPP".equalsIgnoreCase(key)) {
        p_COD_SCOPO_RAPP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDG_SOGG_PRIMARIO".equalsIgnoreCase(key)) {
        p_NDG_SOGG_PRIMARIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO_RELAZIONE".equalsIgnoreCase(key)) {
        p_TIPO_RELAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NAT_GIURIDICA".equalsIgnoreCase(key)) {
        p_NAT_GIURIDICA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATENA_CTRL".equalsIgnoreCase(key)) {
        p_CATENA_CTRL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AMMONTARE".equalsIgnoreCase(key)) {
        p_AMMONTARE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COD_FILIALE".equalsIgnoreCase(key)) {
        p_COD_FILIALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESC_FILIALE".equalsIgnoreCase(key)) {
        p_DESC_FILIALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPERATIVITA".equalsIgnoreCase(key)) {
        p_OPERATIVITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMPORTAMENTO".equalsIgnoreCase(key)) {
        p_COMPORTAMENTO = CPLib.GetProperties(p.getProperty(key));
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
      row.CODIST = CPLib.GetProperty(p_CODIST,"","",i);
      row.TIPOINT = CPLib.GetProperty(p_TIPOINT,"","",i);
      row.CODINT = CPLib.GetProperty(p_CODINT,"","",i);
      row.IDSOGG = CPLib.GetProperty(p_IDSOGG,"","",i);
      row.COD_TIPO_SOGG = CPLib.GetProperty(p_COD_TIPO_SOGG,"","",i);
      row.COD_STATO = CPLib.GetProperty(p_COD_STATO,"","",i);
      row.COD_SPEC_GIUR = CPLib.GetProperty(p_COD_SPEC_GIUR,"","",i);
      row.COD_SETT = CPLib.GetProperty(p_COD_SETT,"","",i);
      row.COD_RAMO = CPLib.GetProperty(p_COD_RAMO,"","",i);
      row.COD_NDG_GRUP_ECON = CPLib.GetProperty(p_COD_NDG_GRUP_ECON,"","",i);
      row.COD_ATECO = CPLib.GetProperty(p_COD_ATECO,"","",i);
      row.SEG_CAN_TERZI = CPLib.GetProperty(p_SEG_CAN_TERZI,"","",i);
      row.COD_TIT_EFFETTIVO = CPLib.GetProperty(p_COD_TIT_EFFETTIVO,"","",i);
      row.COD_COMP_RILE = CPLib.GetProperty(p_COD_COMP_RILE,"","",i);
      row.COD_SCOPO_RAPP = CPLib.GetProperty(p_COD_SCOPO_RAPP,"","",i);
      row.NDG_SOGG_PRIMARIO = CPLib.GetProperty(p_NDG_SOGG_PRIMARIO,"","",i);
      row.TIPO_RELAZIONE = CPLib.GetProperty(p_TIPO_RELAZIONE,"","",i);
      row.NAT_GIURIDICA = CPLib.GetProperty(p_NAT_GIURIDICA,"","",i);
      row.CATENA_CTRL = CPLib.GetProperty(p_CATENA_CTRL,"","",i);
      row.AMMONTARE = CPLib.GetProperty(p_AMMONTARE,"","",i);
      row.COD_FILIALE = CPLib.GetProperty(p_COD_FILIALE,"","",i);
      row.DESC_FILIALE = CPLib.GetProperty(p_DESC_FILIALE,"","",i);
      row.OPERATIVITA = CPLib.GetProperty(p_OPERATIVITA,"","",i);
      row.COMPORTAMENTO = CPLib.GetProperty(p_COMPORTAMENTO,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccategorizzazione_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccategorizzazione_mcrdef();
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
  public MemoryCursorRow_mccategorizzazione_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccategorizzazione_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccategorizzazione_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    MemoryCursorRow_mccategorizzazione_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccategorizzazione_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccategorizzazione_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccategorizzazione_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
