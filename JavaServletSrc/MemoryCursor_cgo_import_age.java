// Definition generated from table cgo_import_age
public class MemoryCursor_cgo_import_age extends CPMemoryCursor {
  MemoryCursorRow_cgo_import_age row;
  MemoryCursorRow_cgo_import_age empty_row;
  public MemoryCursor_cgo_import_age() {
    empty_row = new MemoryCursorRow_cgo_import_age();
    row = empty_row;
  }
  public MemoryCursor_cgo_import_age(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_NUMOPE;
    p_NUMOPE = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_TIPODOC;
    p_TIPODOC = new java.util.Properties();
    java.util.Properties p_NUMDOCUM;
    p_NUMDOCUM = new java.util.Properties();
    java.util.Properties p_DATARILASC;
    p_DATARILASC = new java.util.Properties();
    java.util.Properties p_AUTRILASC;
    p_AUTRILASC = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_TIPINTER;
    p_TIPINTER = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties p_NASSTATO;
    p_NASSTATO = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_PEP;
    p_PEP = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_FLAGCONT;
    p_FLAGCONT = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_FLAGLIRE;
    p_FLAGLIRE = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_CACODICE;
    p_CACODICE = new java.util.Properties();
    java.util.Properties p_CADATAORA;
    p_CADATAORA = new java.util.Properties();
    java.util.Properties p_CAIDBIGLIETTO;
    p_CAIDBIGLIETTO = new java.util.Properties();
    java.util.Properties p_IBAN;
    p_IBAN = new java.util.Properties();
    java.util.Properties p_MEZPAGAM;
    p_MEZPAGAM = new java.util.Properties();
    java.util.Properties p_CGOFLGVLT;
    p_CGOFLGVLT = new java.util.Properties();
    java.util.Properties p_CGOFLGVNP;
    p_CGOFLGVNP = new java.util.Properties();
    java.util.Properties p_CGOTIPOPE;
    p_CGOTIPOPE = new java.util.Properties();
    java.util.Properties p_CAFLGOPE;
    p_CAFLGOPE = new java.util.Properties();
    java.util.Properties p_TIPOGIOCO;
    p_TIPOGIOCO = new java.util.Properties();
    java.util.Properties p_CODLOB;
    p_CODLOB = new java.util.Properties();
    java.util.Properties p_ASSEGNO;
    p_ASSEGNO = new java.util.Properties();
    java.util.Properties p_CADATIMP;
    p_CADATIMP = new java.util.Properties();
    java.util.Properties p_RDCODAUT;
    p_RDCODAUT = new java.util.Properties();
    java.util.Properties p_RDLOCAUT;
    p_RDLOCAUT = new java.util.Properties();
    java.util.Properties p_VLTPLAT;
    p_VLTPLAT = new java.util.Properties();
    java.util.Properties p_CC4CIFRE;
    p_CC4CIFRE = new java.util.Properties();
    java.util.Properties p_CCDATSCA;
    p_CCDATSCA = new java.util.Properties();
    java.util.Properties p_NUMTEL;
    p_NUMTEL = new java.util.Properties();
    java.util.Properties p_IDDOCALL;
    p_IDDOCALL = new java.util.Properties();
    java.util.Properties p_FLGDOCALL;
    p_FLGDOCALL = new java.util.Properties();
    java.util.Properties p_CCANNSCA;
    p_CCANNSCA = new java.util.Properties();
    java.util.Properties p_CCMESSCA;
    p_CCMESSCA = new java.util.Properties();
    java.util.Properties p_PEPDESCRI;
    p_PEPDESCRI = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMOPE".equalsIgnoreCase(key)) {
        p_NUMOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOMICILIO".equalsIgnoreCase(key)) {
        p_DOMICILIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPODOC".equalsIgnoreCase(key)) {
        p_TIPODOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMDOCUM".equalsIgnoreCase(key)) {
        p_NUMDOCUM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARILASC".equalsIgnoreCase(key)) {
        p_DATARILASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AUTRILASC".equalsIgnoreCase(key)) {
        p_AUTRILASC = CPLib.GetProperties(p.getProperty(key));
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
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPINTER".equalsIgnoreCase(key)) {
        p_TIPINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASSTATO".equalsIgnoreCase(key)) {
        p_NASSTATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEP".equalsIgnoreCase(key)) {
        p_PEP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGCONT".equalsIgnoreCase(key)) {
        p_FLAGCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGLIRE".equalsIgnoreCase(key)) {
        p_FLAGLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CACODICE".equalsIgnoreCase(key)) {
        p_CACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CADATAORA".equalsIgnoreCase(key)) {
        p_CADATAORA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAIDBIGLIETTO".equalsIgnoreCase(key)) {
        p_CAIDBIGLIETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IBAN".equalsIgnoreCase(key)) {
        p_IBAN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MEZPAGAM".equalsIgnoreCase(key)) {
        p_MEZPAGAM = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CGOFLGVLT".equalsIgnoreCase(key)) {
        p_CGOFLGVLT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CGOFLGVNP".equalsIgnoreCase(key)) {
        p_CGOFLGVNP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CGOTIPOPE".equalsIgnoreCase(key)) {
        p_CGOTIPOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAFLGOPE".equalsIgnoreCase(key)) {
        p_CAFLGOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOGIOCO".equalsIgnoreCase(key)) {
        p_TIPOGIOCO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODLOB".equalsIgnoreCase(key)) {
        p_CODLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ASSEGNO".equalsIgnoreCase(key)) {
        p_ASSEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CADATIMP".equalsIgnoreCase(key)) {
        p_CADATIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RDCODAUT".equalsIgnoreCase(key)) {
        p_RDCODAUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RDLOCAUT".equalsIgnoreCase(key)) {
        p_RDLOCAUT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VLTPLAT".equalsIgnoreCase(key)) {
        p_VLTPLAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CC4CIFRE".equalsIgnoreCase(key)) {
        p_CC4CIFRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CCDATSCA".equalsIgnoreCase(key)) {
        p_CCDATSCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMTEL".equalsIgnoreCase(key)) {
        p_NUMTEL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDDOCALL".equalsIgnoreCase(key)) {
        p_IDDOCALL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGDOCALL".equalsIgnoreCase(key)) {
        p_FLGDOCALL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CCANNSCA".equalsIgnoreCase(key)) {
        p_CCANNSCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CCMESSCA".equalsIgnoreCase(key)) {
        p_CCMESSCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEPDESCRI".equalsIgnoreCase(key)) {
        p_PEPDESCRI = CPLib.GetProperties(p.getProperty(key));
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
      row.NUMOPE = CPLib.GetProperty(p_NUMOPE,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"",CPLib.NullDate(),i);
      row.AUTRILASC = CPLib.GetProperty(p_AUTRILASC,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.TIPINTER = CPLib.GetProperty(p_TIPINTER,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
      row.NASSTATO = CPLib.GetProperty(p_NASSTATO,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
      row.PEP = CPLib.GetProperty(p_PEP,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.FLAGCONT = CPLib.GetProperty(p_FLAGCONT,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.FLAGLIRE = CPLib.GetProperty(p_FLAGLIRE,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.CACODICE = CPLib.GetProperty(p_CACODICE,"",0,i);
      row.CADATAORA = CPLib.GetProperty(p_CADATAORA,"",CPLib.NullDateTime(),i);
      row.CAIDBIGLIETTO = CPLib.GetProperty(p_CAIDBIGLIETTO,"","",i);
      row.IBAN = CPLib.GetProperty(p_IBAN,"","",i);
      row.MEZPAGAM = CPLib.GetProperty(p_MEZPAGAM,"","",i);
      row.CGOFLGVLT = CPLib.GetProperty(p_CGOFLGVLT,"","",i);
      row.CGOFLGVNP = CPLib.GetProperty(p_CGOFLGVNP,"","",i);
      row.CGOTIPOPE = CPLib.GetProperty(p_CGOTIPOPE,"","",i);
      row.CAFLGOPE = CPLib.GetProperty(p_CAFLGOPE,"","",i);
      row.TIPOGIOCO = CPLib.GetProperty(p_TIPOGIOCO,"","",i);
      row.CODLOB = CPLib.GetProperty(p_CODLOB,"","",i);
      row.ASSEGNO = CPLib.GetProperty(p_ASSEGNO,"","",i);
      row.CADATIMP = CPLib.GetProperty(p_CADATIMP,"",CPLib.NullDate(),i);
      row.RDCODAUT = CPLib.GetProperty(p_RDCODAUT,"","",i);
      row.RDLOCAUT = CPLib.GetProperty(p_RDLOCAUT,"","",i);
      row.VLTPLAT = CPLib.GetProperty(p_VLTPLAT,"","",i);
      row.CC4CIFRE = CPLib.GetProperty(p_CC4CIFRE,"","",i);
      row.CCDATSCA = CPLib.GetProperty(p_CCDATSCA,"","",i);
      row.NUMTEL = CPLib.GetProperty(p_NUMTEL,"","",i);
      row.IDDOCALL = CPLib.GetProperty(p_IDDOCALL,"","",i);
      row.FLGDOCALL = CPLib.GetProperty(p_FLGDOCALL,"","",i);
      row.CCANNSCA = CPLib.GetProperty(p_CCANNSCA,"",0,i);
      row.CCMESSCA = CPLib.GetProperty(p_CCMESSCA,"",0,i);
      row.PEPDESCRI = CPLib.GetProperty(p_PEPDESCRI,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_import_age)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_import_age();
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
  public MemoryCursorRow_cgo_import_age _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_import_age _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_import_age> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_import_age p_Row) {
    MemoryCursorRow_cgo_import_age l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_import_age();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_import_age p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_import_age();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
