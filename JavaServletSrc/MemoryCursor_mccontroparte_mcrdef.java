// Definition generated from record definition mccontroparte_mcrdef
public class MemoryCursor_mccontroparte_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mccontroparte_mcrdef row;
  MemoryCursorRow_mccontroparte_mcrdef empty_row;
  public MemoryCursor_mccontroparte_mcrdef() {
    empty_row = new MemoryCursorRow_mccontroparte_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mccontroparte_mcrdef(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_TipoRapportoBeneficiario;
    p_TipoRapportoBeneficiario = new java.util.Properties();
    java.util.Properties p_CodiceBeneficiario;
    p_CodiceBeneficiario = new java.util.Properties();
    java.util.Properties p_CodiceRapporto;
    p_CodiceRapporto = new java.util.Properties();
    java.util.Properties p_NomeBeneficiario;
    p_NomeBeneficiario = new java.util.Properties();
    java.util.Properties p_IndirizzoBeneficiario;
    p_IndirizzoBeneficiario = new java.util.Properties();
    java.util.Properties p_CapBeneficiario;
    p_CapBeneficiario = new java.util.Properties();
    java.util.Properties p_CabBeneficiario;
    p_CabBeneficiario = new java.util.Properties();
    java.util.Properties p_LocalitaBeneficiario;
    p_LocalitaBeneficiario = new java.util.Properties();
    java.util.Properties p_ProvinciaBeneficiario;
    p_ProvinciaBeneficiario = new java.util.Properties();
    java.util.Properties p_StatoBeneficiario;
    p_StatoBeneficiario = new java.util.Properties();
    java.util.Properties p_TipoIntermediario;
    p_TipoIntermediario = new java.util.Properties();
    java.util.Properties p_CodiceIntermediario;
    p_CodiceIntermediario = new java.util.Properties();
    java.util.Properties p_CodiceStatoBanca;
    p_CodiceStatoBanca = new java.util.Properties();
    java.util.Properties p_CabBanca;
    p_CabBanca = new java.util.Properties();
    java.util.Properties p_ComuneBanca;
    p_ComuneBanca = new java.util.Properties();
    java.util.Properties p_ProvinciaBanca;
    p_ProvinciaBanca = new java.util.Properties();
    java.util.Properties p_DescrizioneIntermediario;
    p_DescrizioneIntermediario = new java.util.Properties();
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
      if ("TipoRapportoBeneficiario".equalsIgnoreCase(key)) {
        p_TipoRapportoBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceBeneficiario".equalsIgnoreCase(key)) {
        p_CodiceBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceRapporto".equalsIgnoreCase(key)) {
        p_CodiceRapporto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NomeBeneficiario".equalsIgnoreCase(key)) {
        p_NomeBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IndirizzoBeneficiario".equalsIgnoreCase(key)) {
        p_IndirizzoBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CapBeneficiario".equalsIgnoreCase(key)) {
        p_CapBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CabBeneficiario".equalsIgnoreCase(key)) {
        p_CabBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LocalitaBeneficiario".equalsIgnoreCase(key)) {
        p_LocalitaBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProvinciaBeneficiario".equalsIgnoreCase(key)) {
        p_ProvinciaBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("StatoBeneficiario".equalsIgnoreCase(key)) {
        p_StatoBeneficiario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoIntermediario".equalsIgnoreCase(key)) {
        p_TipoIntermediario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceIntermediario".equalsIgnoreCase(key)) {
        p_CodiceIntermediario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceStatoBanca".equalsIgnoreCase(key)) {
        p_CodiceStatoBanca = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CabBanca".equalsIgnoreCase(key)) {
        p_CabBanca = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ComuneBanca".equalsIgnoreCase(key)) {
        p_ComuneBanca = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProvinciaBanca".equalsIgnoreCase(key)) {
        p_ProvinciaBanca = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DescrizioneIntermediario".equalsIgnoreCase(key)) {
        p_DescrizioneIntermediario = CPLib.GetProperties(p.getProperty(key));
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
      row.TipoRapportoBeneficiario = CPLib.GetProperty(p_TipoRapportoBeneficiario,"","",i);
      row.CodiceBeneficiario = CPLib.GetProperty(p_CodiceBeneficiario,"","",i);
      row.CodiceRapporto = CPLib.GetProperty(p_CodiceRapporto,"","",i);
      row.NomeBeneficiario = CPLib.GetProperty(p_NomeBeneficiario,"","",i);
      row.IndirizzoBeneficiario = CPLib.GetProperty(p_IndirizzoBeneficiario,"","",i);
      row.CapBeneficiario = CPLib.GetProperty(p_CapBeneficiario,"","",i);
      row.CabBeneficiario = CPLib.GetProperty(p_CabBeneficiario,"","",i);
      row.LocalitaBeneficiario = CPLib.GetProperty(p_LocalitaBeneficiario,"","",i);
      row.ProvinciaBeneficiario = CPLib.GetProperty(p_ProvinciaBeneficiario,"","",i);
      row.StatoBeneficiario = CPLib.GetProperty(p_StatoBeneficiario,"","",i);
      row.TipoIntermediario = CPLib.GetProperty(p_TipoIntermediario,"","",i);
      row.CodiceIntermediario = CPLib.GetProperty(p_CodiceIntermediario,"","",i);
      row.CodiceStatoBanca = CPLib.GetProperty(p_CodiceStatoBanca,"","",i);
      row.CabBanca = CPLib.GetProperty(p_CabBanca,"","",i);
      row.ComuneBanca = CPLib.GetProperty(p_ComuneBanca,"","",i);
      row.ProvinciaBanca = CPLib.GetProperty(p_ProvinciaBanca,"","",i);
      row.DescrizioneIntermediario = CPLib.GetProperty(p_DescrizioneIntermediario,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mccontroparte_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mccontroparte_mcrdef();
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
  public MemoryCursorRow_mccontroparte_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mccontroparte_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mccontroparte_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    MemoryCursorRow_mccontroparte_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mccontroparte_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mccontroparte_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mccontroparte_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
