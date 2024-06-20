// Definition generated from table personbo_agg
public class MemoryCursor_personbo_agg extends CPMemoryCursor {
  MemoryCursorRow_personbo_agg row;
  MemoryCursorRow_personbo_agg empty_row;
  public MemoryCursor_personbo_agg() {
    empty_row = new MemoryCursorRow_personbo_agg();
    row = empty_row;
  }
  public MemoryCursor_personbo_agg(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_EMAIL;
    p_EMAIL = new java.util.Properties();
    java.util.Properties p_FLGEMAIL;
    p_FLGEMAIL = new java.util.Properties();
    java.util.Properties p_TELEFONO;
    p_TELEFONO = new java.util.Properties();
    java.util.Properties p_RDCODAUT;
    p_RDCODAUT = new java.util.Properties();
    java.util.Properties p_RDLOCAUT;
    p_RDLOCAUT = new java.util.Properties();
    java.util.Properties p_FLGBANCA;
    p_FLGBANCA = new java.util.Properties();
    java.util.Properties p_FLGVALIDO;
    p_FLGVALIDO = new java.util.Properties();
    java.util.Properties p_REGRES;
    p_REGRES = new java.util.Properties();
    java.util.Properties p_FLGBL;
    p_FLGBL = new java.util.Properties();
    java.util.Properties p_CLOCCUPA;
    p_CLOCCUPA = new java.util.Properties();
    java.util.Properties p_NUMTEL;
    p_NUMTEL = new java.util.Properties();
    java.util.Properties p_NAZIONE;
    p_NAZIONE = new java.util.Properties();
    java.util.Properties p_LASTOPER;
    p_LASTOPER = new java.util.Properties();
    java.util.Properties p_CODCLIEST;
    p_CODCLIEST = new java.util.Properties();
    java.util.Properties p_FLGANAVAL;
    p_FLGANAVAL = new java.util.Properties();
    java.util.Properties p_CLPRVDOM;
    p_CLPRVDOM = new java.util.Properties();
    java.util.Properties p_MITIG;
    p_MITIG = new java.util.Properties();
    java.util.Properties p_MITGDOC;
    p_MITGDOC = new java.util.Properties();
    java.util.Properties p_CATEG01;
    p_CATEG01 = new java.util.Properties();
    java.util.Properties p_CATEG02;
    p_CATEG02 = new java.util.Properties();
    java.util.Properties p_CATEG03;
    p_CATEG03 = new java.util.Properties();
    java.util.Properties p_CATEG04;
    p_CATEG04 = new java.util.Properties();
    java.util.Properties p_CATEG05;
    p_CATEG05 = new java.util.Properties();
    java.util.Properties p_CATEGORIA;
    p_CATEGORIA = new java.util.Properties();
    java.util.Properties p_FLGPREGIUD;
    p_FLGPREGIUD = new java.util.Properties();
    java.util.Properties p_FLGTRUST;
    p_FLGTRUST = new java.util.Properties();
    java.util.Properties p_FLGRISCHIO;
    p_FLGRISCHIO = new java.util.Properties();
    java.util.Properties p_FLGEQUIFIN;
    p_FLGEQUIFIN = new java.util.Properties();
    java.util.Properties p_FLGFALSADIC;
    p_FLGFALSADIC = new java.util.Properties();
    java.util.Properties p_FLGRICINF;
    p_FLGRICINF = new java.util.Properties();
    java.util.Properties p_WUGID;
    p_WUGID = new java.util.Properties();
    java.util.Properties p_WUNAZRILDOC;
    p_WUNAZRILDOC = new java.util.Properties();
    java.util.Properties p_WUCOGNOME;
    p_WUCOGNOME = new java.util.Properties();
    java.util.Properties p_WUNOME;
    p_WUNOME = new java.util.Properties();
    java.util.Properties p_WULUONAS;
    p_WULUONAS = new java.util.Properties();
    java.util.Properties p_NUMCEL;
    p_NUMCEL = new java.util.Properties();
    java.util.Properties p_PEC;
    p_PEC = new java.util.Properties();
    java.util.Properties p_REFERENTE;
    p_REFERENTE = new java.util.Properties();
    java.util.Properties p_CFOK;
    p_CFOK = new java.util.Properties();
    java.util.Properties p_CONALTO;
    p_CONALTO = new java.util.Properties();
    java.util.Properties p_APPALTO;
    p_APPALTO = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("EMAIL".equalsIgnoreCase(key)) {
        p_EMAIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGEMAIL".equalsIgnoreCase(key)) {
        p_FLGEMAIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TELEFONO".equalsIgnoreCase(key)) {
        p_TELEFONO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RDCODAUT".equalsIgnoreCase(key)) {
        p_RDCODAUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RDLOCAUT".equalsIgnoreCase(key)) {
        p_RDLOCAUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGBANCA".equalsIgnoreCase(key)) {
        p_FLGBANCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGVALIDO".equalsIgnoreCase(key)) {
        p_FLGVALIDO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("REGRES".equalsIgnoreCase(key)) {
        p_REGRES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGBL".equalsIgnoreCase(key)) {
        p_FLGBL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CLOCCUPA".equalsIgnoreCase(key)) {
        p_CLOCCUPA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMTEL".equalsIgnoreCase(key)) {
        p_NUMTEL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NAZIONE".equalsIgnoreCase(key)) {
        p_NAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("LASTOPER".equalsIgnoreCase(key)) {
        p_LASTOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCLIEST".equalsIgnoreCase(key)) {
        p_CODCLIEST = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGANAVAL".equalsIgnoreCase(key)) {
        p_FLGANAVAL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CLPRVDOM".equalsIgnoreCase(key)) {
        p_CLPRVDOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MITIG".equalsIgnoreCase(key)) {
        p_MITIG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MITGDOC".equalsIgnoreCase(key)) {
        p_MITGDOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEG01".equalsIgnoreCase(key)) {
        p_CATEG01 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEG02".equalsIgnoreCase(key)) {
        p_CATEG02 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEG03".equalsIgnoreCase(key)) {
        p_CATEG03 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEG04".equalsIgnoreCase(key)) {
        p_CATEG04 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEG05".equalsIgnoreCase(key)) {
        p_CATEG05 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CATEGORIA".equalsIgnoreCase(key)) {
        p_CATEGORIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGPREGIUD".equalsIgnoreCase(key)) {
        p_FLGPREGIUD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGTRUST".equalsIgnoreCase(key)) {
        p_FLGTRUST = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGRISCHIO".equalsIgnoreCase(key)) {
        p_FLGRISCHIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGEQUIFIN".equalsIgnoreCase(key)) {
        p_FLGEQUIFIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGFALSADIC".equalsIgnoreCase(key)) {
        p_FLGFALSADIC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGRICINF".equalsIgnoreCase(key)) {
        p_FLGRICINF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("WUGID".equalsIgnoreCase(key)) {
        p_WUGID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("WUNAZRILDOC".equalsIgnoreCase(key)) {
        p_WUNAZRILDOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("WUCOGNOME".equalsIgnoreCase(key)) {
        p_WUCOGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("WUNOME".equalsIgnoreCase(key)) {
        p_WUNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("WULUONAS".equalsIgnoreCase(key)) {
        p_WULUONAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMCEL".equalsIgnoreCase(key)) {
        p_NUMCEL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEC".equalsIgnoreCase(key)) {
        p_PEC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("REFERENTE".equalsIgnoreCase(key)) {
        p_REFERENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFOK".equalsIgnoreCase(key)) {
        p_CFOK = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONALTO".equalsIgnoreCase(key)) {
        p_CONALTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("APPALTO".equalsIgnoreCase(key)) {
        p_APPALTO = CPLib.GetProperties(p.getProperty(key));
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
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.EMAIL = CPLib.GetProperty(p_EMAIL,"","",i);
      row.FLGEMAIL = CPLib.GetProperty(p_FLGEMAIL,"","",i);
      row.TELEFONO = CPLib.GetProperty(p_TELEFONO,"","",i);
      row.RDCODAUT = CPLib.GetProperty(p_RDCODAUT,"","",i);
      row.RDLOCAUT = CPLib.GetProperty(p_RDLOCAUT,"","",i);
      row.FLGBANCA = CPLib.GetProperty(p_FLGBANCA,"","",i);
      row.FLGVALIDO = CPLib.GetProperty(p_FLGVALIDO,"","",i);
      row.REGRES = CPLib.GetProperty(p_REGRES,"","",i);
      row.FLGBL = CPLib.GetProperty(p_FLGBL,"","",i);
      row.CLOCCUPA = CPLib.GetProperty(p_CLOCCUPA,"",0,i);
      row.NUMTEL = CPLib.GetProperty(p_NUMTEL,"","",i);
      row.NAZIONE = CPLib.GetProperty(p_NAZIONE,"","",i);
      row.LASTOPER = CPLib.GetProperty(p_LASTOPER,"","",i);
      row.CODCLIEST = CPLib.GetProperty(p_CODCLIEST,"","",i);
      row.FLGANAVAL = CPLib.GetProperty(p_FLGANAVAL,"","",i);
      row.CLPRVDOM = CPLib.GetProperty(p_CLPRVDOM,"","",i);
      row.MITIG = CPLib.GetProperty(p_MITIG,"",0,i);
      row.MITGDOC = CPLib.GetProperty(p_MITGDOC,"","",i);
      row.CATEG01 = CPLib.GetProperty(p_CATEG01,"","",i);
      row.CATEG02 = CPLib.GetProperty(p_CATEG02,"","",i);
      row.CATEG03 = CPLib.GetProperty(p_CATEG03,"","",i);
      row.CATEG04 = CPLib.GetProperty(p_CATEG04,"","",i);
      row.CATEG05 = CPLib.GetProperty(p_CATEG05,"","",i);
      row.CATEGORIA = CPLib.GetProperty(p_CATEGORIA,"","",i);
      row.FLGPREGIUD = CPLib.GetProperty(p_FLGPREGIUD,"","",i);
      row.FLGTRUST = CPLib.GetProperty(p_FLGTRUST,"","",i);
      row.FLGRISCHIO = CPLib.GetProperty(p_FLGRISCHIO,"","",i);
      row.FLGEQUIFIN = CPLib.GetProperty(p_FLGEQUIFIN,"","",i);
      row.FLGFALSADIC = CPLib.GetProperty(p_FLGFALSADIC,"","",i);
      row.FLGRICINF = CPLib.GetProperty(p_FLGRICINF,"","",i);
      row.WUGID = CPLib.GetProperty(p_WUGID,"","",i);
      row.WUNAZRILDOC = CPLib.GetProperty(p_WUNAZRILDOC,"","",i);
      row.WUCOGNOME = CPLib.GetProperty(p_WUCOGNOME,"","",i);
      row.WUNOME = CPLib.GetProperty(p_WUNOME,"","",i);
      row.WULUONAS = CPLib.GetProperty(p_WULUONAS,"","",i);
      row.NUMCEL = CPLib.GetProperty(p_NUMCEL,"","",i);
      row.PEC = CPLib.GetProperty(p_PEC,"","",i);
      row.REFERENTE = CPLib.GetProperty(p_REFERENTE,"","",i);
      row.CFOK = CPLib.GetProperty(p_CFOK,"",0,i);
      row.CONALTO = CPLib.GetProperty(p_CONALTO,"",0,i);
      row.APPALTO = CPLib.GetProperty(p_APPALTO,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_personbo_agg)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_personbo_agg();
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
  public MemoryCursorRow_personbo_agg _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_personbo_agg _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_personbo_agg> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_personbo_agg p_Row) {
    MemoryCursorRow_personbo_agg l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_personbo_agg();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_personbo_agg p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_personbo_agg();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
