// Definition generated from record definition mcestraisv_clienti_mcrdef
public class MemoryCursor_mcestraisv_clienti_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcestraisv_clienti_mcrdef row;
  MemoryCursorRow_mcestraisv_clienti_mcrdef empty_row;
  public MemoryCursor_mcestraisv_clienti_mcrdef() {
    empty_row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcestraisv_clienti_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODCLI;
    p_CODCLI = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_PARTIVA;
    p_PARTIVA = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_CAPNASC;
    p_CAPNASC = new java.util.Properties();
    java.util.Properties p_COMUNASC;
    p_COMUNASC = new java.util.Properties();
    java.util.Properties p_PROVNASC;
    p_PROVNASC = new java.util.Properties();
    java.util.Properties p_PAESENASC;
    p_PAESENASC = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_INDRESID;
    p_INDRESID = new java.util.Properties();
    java.util.Properties p_CAPRESID;
    p_CAPRESID = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_INDDOMIC;
    p_INDDOMIC = new java.util.Properties();
    java.util.Properties p_CAPDOMIC;
    p_CAPDOMIC = new java.util.Properties();
    java.util.Properties p_DESCDOM;
    p_DESCDOM = new java.util.Properties();
    java.util.Properties p_PROVDOM;
    p_PROVDOM = new java.util.Properties();
    java.util.Properties p_PAESEDOM;
    p_PAESEDOM = new java.util.Properties();
    java.util.Properties p_SPECIE;
    p_SPECIE = new java.util.Properties();
    java.util.Properties p_TELEF;
    p_TELEF = new java.util.Properties();
    java.util.Properties p_FAX;
    p_FAX = new java.util.Properties();
    java.util.Properties p_EMAIL;
    p_EMAIL = new java.util.Properties();
    java.util.Properties p_SVGRUPPO;
    p_SVGRUPPO = new java.util.Properties();
    java.util.Properties p_SVT01118;
    p_SVT01118 = new java.util.Properties();
    java.util.Properties p_SVPMI;
    p_SVPMI = new java.util.Properties();
    java.util.Properties p_NUMCR;
    p_NUMCR = new java.util.Properties();
    java.util.Properties p_SVT00353;
    p_SVT00353 = new java.util.Properties();
    java.util.Properties p_SVT00011;
    p_SVT00011 = new java.util.Properties();
    java.util.Properties p_CLINVREN;
    p_CLINVREN = new java.util.Properties();
    java.util.Properties p_SVTIPOSCAD;
    p_SVTIPOSCAD = new java.util.Properties();
    java.util.Properties p_SVTIPOINAD;
    p_SVTIPOINAD = new java.util.Properties();
    java.util.Properties p_SVT00353GA;
    p_SVT00353GA = new java.util.Properties();
    java.util.Properties p_CCIAA;
    p_CCIAA = new java.util.Properties();
    java.util.Properties p_LEI;
    p_LEI = new java.util.Properties();
    java.util.Properties p_NDG;
    p_NDG = new java.util.Properties();
    java.util.Properties p_PROV;
    p_PROV = new java.util.Properties();
    java.util.Properties p_SAE;
    p_SAE = new java.util.Properties();
    java.util.Properties p_ATECO;
    p_ATECO = new java.util.Properties();
    java.util.Properties p_STATO;
    p_STATO = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCLI".equalsIgnoreCase(key)) {
        p_CODCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PARTIVA".equalsIgnoreCase(key)) {
        p_PARTIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAPNASC".equalsIgnoreCase(key)) {
        p_CAPNASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNASC".equalsIgnoreCase(key)) {
        p_COMUNASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVNASC".equalsIgnoreCase(key)) {
        p_PROVNASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESENASC".equalsIgnoreCase(key)) {
        p_PAESENASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INDRESID".equalsIgnoreCase(key)) {
        p_INDRESID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAPRESID".equalsIgnoreCase(key)) {
        p_CAPRESID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("INDDOMIC".equalsIgnoreCase(key)) {
        p_INDDOMIC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAPDOMIC".equalsIgnoreCase(key)) {
        p_CAPDOMIC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCDOM".equalsIgnoreCase(key)) {
        p_DESCDOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVDOM".equalsIgnoreCase(key)) {
        p_PROVDOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESEDOM".equalsIgnoreCase(key)) {
        p_PAESEDOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SPECIE".equalsIgnoreCase(key)) {
        p_SPECIE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TELEF".equalsIgnoreCase(key)) {
        p_TELEF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FAX".equalsIgnoreCase(key)) {
        p_FAX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EMAIL".equalsIgnoreCase(key)) {
        p_EMAIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVGRUPPO".equalsIgnoreCase(key)) {
        p_SVGRUPPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVT01118".equalsIgnoreCase(key)) {
        p_SVT01118 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVPMI".equalsIgnoreCase(key)) {
        p_SVPMI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMCR".equalsIgnoreCase(key)) {
        p_NUMCR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVT00353".equalsIgnoreCase(key)) {
        p_SVT00353 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVT00011".equalsIgnoreCase(key)) {
        p_SVT00011 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CLINVREN".equalsIgnoreCase(key)) {
        p_CLINVREN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVTIPOSCAD".equalsIgnoreCase(key)) {
        p_SVTIPOSCAD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVTIPOINAD".equalsIgnoreCase(key)) {
        p_SVTIPOINAD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SVT00353GA".equalsIgnoreCase(key)) {
        p_SVT00353GA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CCIAA".equalsIgnoreCase(key)) {
        p_CCIAA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LEI".equalsIgnoreCase(key)) {
        p_LEI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NDG".equalsIgnoreCase(key)) {
        p_NDG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROV".equalsIgnoreCase(key)) {
        p_PROV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SAE".equalsIgnoreCase(key)) {
        p_SAE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECO".equalsIgnoreCase(key)) {
        p_ATECO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATO".equalsIgnoreCase(key)) {
        p_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
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
      row.CODCLI = CPLib.GetProperty(p_CODCLI,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.PARTIVA = CPLib.GetProperty(p_PARTIVA,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.CAPNASC = CPLib.GetProperty(p_CAPNASC,"","",i);
      row.COMUNASC = CPLib.GetProperty(p_COMUNASC,"","",i);
      row.PROVNASC = CPLib.GetProperty(p_PROVNASC,"","",i);
      row.PAESENASC = CPLib.GetProperty(p_PAESENASC,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.INDRESID = CPLib.GetProperty(p_INDRESID,"","",i);
      row.CAPRESID = CPLib.GetProperty(p_CAPRESID,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.INDDOMIC = CPLib.GetProperty(p_INDDOMIC,"","",i);
      row.CAPDOMIC = CPLib.GetProperty(p_CAPDOMIC,"","",i);
      row.DESCDOM = CPLib.GetProperty(p_DESCDOM,"","",i);
      row.PROVDOM = CPLib.GetProperty(p_PROVDOM,"","",i);
      row.PAESEDOM = CPLib.GetProperty(p_PAESEDOM,"","",i);
      row.SPECIE = CPLib.GetProperty(p_SPECIE,"","",i);
      row.TELEF = CPLib.GetProperty(p_TELEF,"","",i);
      row.FAX = CPLib.GetProperty(p_FAX,"","",i);
      row.EMAIL = CPLib.GetProperty(p_EMAIL,"","",i);
      row.SVGRUPPO = CPLib.GetProperty(p_SVGRUPPO,"","",i);
      row.SVT01118 = CPLib.GetProperty(p_SVT01118,"","",i);
      row.SVPMI = CPLib.GetProperty(p_SVPMI,"",0,i);
      row.NUMCR = CPLib.GetProperty(p_NUMCR,"","",i);
      row.SVT00353 = CPLib.GetProperty(p_SVT00353,"","",i);
      row.SVT00011 = CPLib.GetProperty(p_SVT00011,"","",i);
      row.CLINVREN = CPLib.GetProperty(p_CLINVREN,"","",i);
      row.SVTIPOSCAD = CPLib.GetProperty(p_SVTIPOSCAD,"","",i);
      row.SVTIPOINAD = CPLib.GetProperty(p_SVTIPOINAD,"","",i);
      row.SVT00353GA = CPLib.GetProperty(p_SVT00353GA,"","",i);
      row.CCIAA = CPLib.GetProperty(p_CCIAA,"","",i);
      row.LEI = CPLib.GetProperty(p_LEI,"","",i);
      row.NDG = CPLib.GetProperty(p_NDG,"","",i);
      row.PROV = CPLib.GetProperty(p_PROV,"","",i);
      row.SAE = CPLib.GetProperty(p_SAE,"","",i);
      row.ATECO = CPLib.GetProperty(p_ATECO,"","",i);
      row.STATO = CPLib.GetProperty(p_STATO,"","",i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcestraisv_clienti_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcestraisv_clienti_mcrdef();
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
  public MemoryCursorRow_mcestraisv_clienti_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcestraisv_clienti_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcestraisv_clienti_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    MemoryCursorRow_mcestraisv_clienti_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcestraisv_clienti_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
