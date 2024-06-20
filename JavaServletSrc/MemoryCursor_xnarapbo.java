// Definition generated from table xnarapbo
public class MemoryCursor_xnarapbo extends CPMemoryCursor {
  MemoryCursorRow_xnarapbo row;
  MemoryCursorRow_xnarapbo empty_row;
  public MemoryCursor_xnarapbo() {
    empty_row = new MemoryCursorRow_xnarapbo();
    row = empty_row;
  }
  public MemoryCursor_xnarapbo(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_DESCRAP;
    p_DESCRAP = new java.util.Properties();
    java.util.Properties p_TIPORAP;
    p_TIPORAP = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_CONTINUA;
    p_CONTINUA = new java.util.Properties();
    java.util.Properties p_TIPOAG;
    p_TIPOAG = new java.util.Properties();
    java.util.Properties p_DOCFILE;
    p_DOCFILE = new java.util.Properties();
    java.util.Properties p_NOPROT;
    p_NOPROT = new java.util.Properties();
    java.util.Properties p_TIPMOD;
    p_TIPMOD = new java.util.Properties();
    java.util.Properties p_DATAMOD;
    p_DATAMOD = new java.util.Properties();
    java.util.Properties p_IDRAPPORTO;
    p_IDRAPPORTO = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_RAGIO;
    p_RAGIO = new java.util.Properties();
    java.util.Properties p_MODSVOL;
    p_MODSVOL = new java.util.Properties();
    java.util.Properties p_AREAGEO;
    p_AREAGEO = new java.util.Properties();
    java.util.Properties p_SCOPO;
    p_SCOPO = new java.util.Properties();
    java.util.Properties p_NATURA;
    p_NATURA = new java.util.Properties();
    java.util.Properties p_RTIPO;
    p_RTIPO = new java.util.Properties();
    java.util.Properties p_RCOMP;
    p_RCOMP = new java.util.Properties();
    java.util.Properties p_RIMP;
    p_RIMP = new java.util.Properties();
    java.util.Properties p_RFREQ;
    p_RFREQ = new java.util.Properties();
    java.util.Properties p_RRAGIO;
    p_RRAGIO = new java.util.Properties();
    java.util.Properties p_RAREA;
    p_RAREA = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_PRGIMPRAP;
    p_PRGIMPRAP = new java.util.Properties();
    java.util.Properties p_AMMONT;
    p_AMMONT = new java.util.Properties();
    java.util.Properties p_DURAT;
    p_DURAT = new java.util.Properties();
    java.util.Properties p_IMPAPE;
    p_IMPAPE = new java.util.Properties();
    java.util.Properties p_IMPCHIU;
    p_IMPCHIU = new java.util.Properties();
    java.util.Properties p_SPLITCODE;
    p_SPLITCODE = new java.util.Properties();
    java.util.Properties p_MACODICE;
    p_MACODICE = new java.util.Properties();
    java.util.Properties p_CODDIP;
    p_CODDIP = new java.util.Properties();
    java.util.Properties p_STATORAP;
    p_STATORAP = new java.util.Properties();
    java.util.Properties p_CASTATOC;
    p_CASTATOC = new java.util.Properties();
    java.util.Properties p_CASTATOM;
    p_CASTATOM = new java.util.Properties();
    java.util.Properties p_CODICELR;
    p_CODICELR = new java.util.Properties();
    java.util.Properties p_CADSTATO;
    p_CADSTATO = new java.util.Properties();
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
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_DAC6;
    p_DAC6 = new java.util.Properties();
    java.util.Properties p_FLAGDAC6;
    p_FLAGDAC6 = new java.util.Properties();
    java.util.Properties p_IBAN;
    p_IBAN = new java.util.Properties();
    java.util.Properties p_CODOGG;
    p_CODOGG = new java.util.Properties();
    java.util.Properties p_RISGLOB;
    p_RISGLOB = new java.util.Properties();
    java.util.Properties p_DATAPROF;
    p_DATAPROF = new java.util.Properties();
    java.util.Properties p_DATAREVPROF;
    p_DATAREVPROF = new java.util.Properties();
    java.util.Properties p_NUMIMP;
    p_NUMIMP = new java.util.Properties();
    java.util.Properties p_ISOAGE;
    p_ISOAGE = new java.util.Properties();
    java.util.Properties p_NOCANC;
    p_NOCANC = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRAP".equalsIgnoreCase(key)) {
        p_DESCRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPORAP".equalsIgnoreCase(key)) {
        p_TIPORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTINUA".equalsIgnoreCase(key)) {
        p_CONTINUA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOAG".equalsIgnoreCase(key)) {
        p_TIPOAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOCFILE".equalsIgnoreCase(key)) {
        p_DOCFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOPROT".equalsIgnoreCase(key)) {
        p_NOPROT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPMOD".equalsIgnoreCase(key)) {
        p_TIPMOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAMOD".equalsIgnoreCase(key)) {
        p_DATAMOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDRAPPORTO".equalsIgnoreCase(key)) {
        p_IDRAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGIO".equalsIgnoreCase(key)) {
        p_RAGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MODSVOL".equalsIgnoreCase(key)) {
        p_MODSVOL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AREAGEO".equalsIgnoreCase(key)) {
        p_AREAGEO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SCOPO".equalsIgnoreCase(key)) {
        p_SCOPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATURA".equalsIgnoreCase(key)) {
        p_NATURA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RTIPO".equalsIgnoreCase(key)) {
        p_RTIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RCOMP".equalsIgnoreCase(key)) {
        p_RCOMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RIMP".equalsIgnoreCase(key)) {
        p_RIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RFREQ".equalsIgnoreCase(key)) {
        p_RFREQ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RRAGIO".equalsIgnoreCase(key)) {
        p_RRAGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAREA".equalsIgnoreCase(key)) {
        p_RAREA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRGIMPRAP".equalsIgnoreCase(key)) {
        p_PRGIMPRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AMMONT".equalsIgnoreCase(key)) {
        p_AMMONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DURAT".equalsIgnoreCase(key)) {
        p_DURAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPAPE".equalsIgnoreCase(key)) {
        p_IMPAPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPCHIU".equalsIgnoreCase(key)) {
        p_IMPCHIU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SPLITCODE".equalsIgnoreCase(key)) {
        p_SPLITCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACODICE".equalsIgnoreCase(key)) {
        p_MACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIP".equalsIgnoreCase(key)) {
        p_CODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATORAP".equalsIgnoreCase(key)) {
        p_STATORAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASTATOC".equalsIgnoreCase(key)) {
        p_CASTATOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CASTATOM".equalsIgnoreCase(key)) {
        p_CASTATOM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICELR".equalsIgnoreCase(key)) {
        p_CODICELR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CADSTATO".equalsIgnoreCase(key)) {
        p_CADSTATO = CPLib.GetProperties(p.getProperty(key));
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
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DAC6".equalsIgnoreCase(key)) {
        p_DAC6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGDAC6".equalsIgnoreCase(key)) {
        p_FLAGDAC6 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IBAN".equalsIgnoreCase(key)) {
        p_IBAN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODOGG".equalsIgnoreCase(key)) {
        p_CODOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RISGLOB".equalsIgnoreCase(key)) {
        p_RISGLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAPROF".equalsIgnoreCase(key)) {
        p_DATAPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAREVPROF".equalsIgnoreCase(key)) {
        p_DATAREVPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMIMP".equalsIgnoreCase(key)) {
        p_NUMIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ISOAGE".equalsIgnoreCase(key)) {
        p_ISOAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOCANC".equalsIgnoreCase(key)) {
        p_NOCANC = CPLib.GetProperties(p.getProperty(key));
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
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.DESCRAP = CPLib.GetProperty(p_DESCRAP,"","",i);
      row.TIPORAP = CPLib.GetProperty(p_TIPORAP,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.CONTINUA = CPLib.GetProperty(p_CONTINUA,"","",i);
      row.TIPOAG = CPLib.GetProperty(p_TIPOAG,"","",i);
      row.DOCFILE = CPLib.GetProperty(p_DOCFILE,"","",i);
      row.NOPROT = CPLib.GetProperty(p_NOPROT,"",0,i);
      row.TIPMOD = CPLib.GetProperty(p_TIPMOD,"","",i);
      row.DATAMOD = CPLib.GetProperty(p_DATAMOD,"",CPLib.NullDate(),i);
      row.IDRAPPORTO = CPLib.GetProperty(p_IDRAPPORTO,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.RAGIO = CPLib.GetProperty(p_RAGIO,"","",i);
      row.MODSVOL = CPLib.GetProperty(p_MODSVOL,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.SCOPO = CPLib.GetProperty(p_SCOPO,"","",i);
      row.NATURA = CPLib.GetProperty(p_NATURA,"","",i);
      row.RTIPO = CPLib.GetProperty(p_RTIPO,"",0,i);
      row.RCOMP = CPLib.GetProperty(p_RCOMP,"",0,i);
      row.RIMP = CPLib.GetProperty(p_RIMP,"",0,i);
      row.RFREQ = CPLib.GetProperty(p_RFREQ,"",0,i);
      row.RRAGIO = CPLib.GetProperty(p_RRAGIO,"",0,i);
      row.RAREA = CPLib.GetProperty(p_RAREA,"",0,i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.PRGIMPRAP = CPLib.GetProperty(p_PRGIMPRAP,"",0,i);
      row.AMMONT = CPLib.GetProperty(p_AMMONT,"","",i);
      row.DURAT = CPLib.GetProperty(p_DURAT,"","",i);
      row.IMPAPE = CPLib.GetProperty(p_IMPAPE,"",0,i);
      row.IMPCHIU = CPLib.GetProperty(p_IMPCHIU,"",0,i);
      row.SPLITCODE = CPLib.GetProperty(p_SPLITCODE,"","",i);
      row.MACODICE = CPLib.GetProperty(p_MACODICE,"","",i);
      row.CODDIP = CPLib.GetProperty(p_CODDIP,"","",i);
      row.STATORAP = CPLib.GetProperty(p_STATORAP,"","",i);
      row.CASTATOC = CPLib.GetProperty(p_CASTATOC,"",0,i);
      row.CASTATOM = CPLib.GetProperty(p_CASTATOM,"",0,i);
      row.CODICELR = CPLib.GetProperty(p_CODICELR,"","",i);
      row.CADSTATO = CPLib.GetProperty(p_CADSTATO,"",CPLib.NullDate(),i);
      row.MITIG = CPLib.GetProperty(p_MITIG,"",0,i);
      row.MITGDOC = CPLib.GetProperty(p_MITGDOC,"","",i);
      row.CATEG01 = CPLib.GetProperty(p_CATEG01,"","",i);
      row.CATEG02 = CPLib.GetProperty(p_CATEG02,"","",i);
      row.CATEG03 = CPLib.GetProperty(p_CATEG03,"","",i);
      row.CATEG04 = CPLib.GetProperty(p_CATEG04,"","",i);
      row.CATEG05 = CPLib.GetProperty(p_CATEG05,"","",i);
      row.CATEGORIA = CPLib.GetProperty(p_CATEGORIA,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.DAC6 = CPLib.GetProperty(p_DAC6,"","",i);
      row.FLAGDAC6 = CPLib.GetProperty(p_FLAGDAC6,"",0,i);
      row.IBAN = CPLib.GetProperty(p_IBAN,"","",i);
      row.CODOGG = CPLib.GetProperty(p_CODOGG,"","",i);
      row.RISGLOB = CPLib.GetProperty(p_RISGLOB,"","",i);
      row.DATAPROF = CPLib.GetProperty(p_DATAPROF,"",CPLib.NullDate(),i);
      row.DATAREVPROF = CPLib.GetProperty(p_DATAREVPROF,"",CPLib.NullDate(),i);
      row.NUMIMP = CPLib.GetProperty(p_NUMIMP,"",CPLib.NullDateTime(),i);
      row.ISOAGE = CPLib.GetProperty(p_ISOAGE,"","",i);
      row.NOCANC = CPLib.GetProperty(p_NOCANC,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_xnarapbo)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_xnarapbo();
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
  public MemoryCursorRow_xnarapbo _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_xnarapbo _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_xnarapbo> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_xnarapbo p_Row) {
    MemoryCursorRow_xnarapbo l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_xnarapbo();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_xnarapbo p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_xnarapbo();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
