// Definition generated from record definition mcpersonbo_mcrdef
public class MemoryCursor_mcpersonbo_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcpersonbo_mcrdef row;
  MemoryCursorRow_mcpersonbo_mcrdef empty_row;
  public MemoryCursor_mcpersonbo_mcrdef() {
    empty_row = new MemoryCursorRow_mcpersonbo_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcpersonbo_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_DATANASC;
    p_DATANASC = new java.util.Properties();
    java.util.Properties p_NASCOMUN;
    p_NASCOMUN = new java.util.Properties();
    java.util.Properties p_SOTGRUP;
    p_SOTGRUP = new java.util.Properties();
    java.util.Properties p_RAMGRUP;
    p_RAMGRUP = new java.util.Properties();
    java.util.Properties p_SETTSINT;
    p_SETTSINT = new java.util.Properties();
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
    java.util.Properties p_PARTIVA;
    p_PARTIVA = new java.util.Properties();
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties p_DATAVAR;
    p_DATAVAR = new java.util.Properties();
    java.util.Properties p_COGNOME;
    p_COGNOME = new java.util.Properties();
    java.util.Properties p_NOME;
    p_NOME = new java.util.Properties();
    java.util.Properties p_DOCFILE;
    p_DOCFILE = new java.util.Properties();
    java.util.Properties p_PROVNAS;
    p_PROVNAS = new java.util.Properties();
    java.util.Properties p_CFESTERO;
    p_CFESTERO = new java.util.Properties();
    java.util.Properties p_SPECIE;
    p_SPECIE = new java.util.Properties();
    java.util.Properties p_COMPORT;
    p_COMPORT = new java.util.Properties();
    java.util.Properties p_ATTIV;
    p_ATTIV = new java.util.Properties();
    java.util.Properties p_AREAGEO;
    p_AREAGEO = new java.util.Properties();
    java.util.Properties p_RNATGIU;
    p_RNATGIU = new java.util.Properties();
    java.util.Properties p_RCOMP;
    p_RCOMP = new java.util.Properties();
    java.util.Properties p_RATTIV;
    p_RATTIV = new java.util.Properties();
    java.util.Properties p_RAREA;
    p_RAREA = new java.util.Properties();
    java.util.Properties p_PEP;
    p_PEP = new java.util.Properties();
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_DATAVARAGE;
    p_DATAVARAGE = new java.util.Properties();
    java.util.Properties p_FATCA;
    p_FATCA = new java.util.Properties();
    java.util.Properties p_TIN;
    p_TIN = new java.util.Properties();
    java.util.Properties p_ODB;
    p_ODB = new java.util.Properties();
    java.util.Properties p_TELEF;
    p_TELEF = new java.util.Properties();
    java.util.Properties p_TIPOORO;
    p_TIPOORO = new java.util.Properties();
    java.util.Properties p_CODORO;
    p_CODORO = new java.util.Properties();
    java.util.Properties p_NOTIT;
    p_NOTIT = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
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
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASC".equalsIgnoreCase(key)) {
        p_DATANASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUN".equalsIgnoreCase(key)) {
        p_NASCOMUN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SOTGRUP".equalsIgnoreCase(key)) {
        p_SOTGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAMGRUP".equalsIgnoreCase(key)) {
        p_RAMGRUP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTSINT".equalsIgnoreCase(key)) {
        p_SETTSINT = CPLib.GetProperties(p.getProperty(key));
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
      if ("PARTIVA".equalsIgnoreCase(key)) {
        p_PARTIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVAR".equalsIgnoreCase(key)) {
        p_DATAVAR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COGNOME".equalsIgnoreCase(key)) {
        p_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOME".equalsIgnoreCase(key)) {
        p_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOCFILE".equalsIgnoreCase(key)) {
        p_DOCFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVNAS".equalsIgnoreCase(key)) {
        p_PROVNAS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CFESTERO".equalsIgnoreCase(key)) {
        p_CFESTERO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SPECIE".equalsIgnoreCase(key)) {
        p_SPECIE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMPORT".equalsIgnoreCase(key)) {
        p_COMPORT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATTIV".equalsIgnoreCase(key)) {
        p_ATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AREAGEO".equalsIgnoreCase(key)) {
        p_AREAGEO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RNATGIU".equalsIgnoreCase(key)) {
        p_RNATGIU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RCOMP".equalsIgnoreCase(key)) {
        p_RCOMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RATTIV".equalsIgnoreCase(key)) {
        p_RATTIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAREA".equalsIgnoreCase(key)) {
        p_RAREA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEP".equalsIgnoreCase(key)) {
        p_PEP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVARAGE".equalsIgnoreCase(key)) {
        p_DATAVARAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FATCA".equalsIgnoreCase(key)) {
        p_FATCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIN".equalsIgnoreCase(key)) {
        p_TIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ODB".equalsIgnoreCase(key)) {
        p_ODB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TELEF".equalsIgnoreCase(key)) {
        p_TELEF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOORO".equalsIgnoreCase(key)) {
        p_TIPOORO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODORO".equalsIgnoreCase(key)) {
        p_CODORO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NOTIT".equalsIgnoreCase(key)) {
        p_NOTIT = CPLib.GetProperties(p.getProperty(key));
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
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"",CPLib.NullDate(),i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.SOTGRUP = CPLib.GetProperty(p_SOTGRUP,"","",i);
      row.RAMGRUP = CPLib.GetProperty(p_RAMGRUP,"","",i);
      row.SETTSINT = CPLib.GetProperty(p_SETTSINT,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"",CPLib.NullDate(),i);
      row.AUTRILASC = CPLib.GetProperty(p_AUTRILASC,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.PARTIVA = CPLib.GetProperty(p_PARTIVA,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"",CPLib.NullDate(),i);
      row.DATAVAR = CPLib.GetProperty(p_DATAVAR,"",CPLib.NullDate(),i);
      row.COGNOME = CPLib.GetProperty(p_COGNOME,"","",i);
      row.NOME = CPLib.GetProperty(p_NOME,"","",i);
      row.DOCFILE = CPLib.GetProperty(p_DOCFILE,"","",i);
      row.PROVNAS = CPLib.GetProperty(p_PROVNAS,"","",i);
      row.CFESTERO = CPLib.GetProperty(p_CFESTERO,"",0,i);
      row.SPECIE = CPLib.GetProperty(p_SPECIE,"","",i);
      row.COMPORT = CPLib.GetProperty(p_COMPORT,"","",i);
      row.ATTIV = CPLib.GetProperty(p_ATTIV,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.RNATGIU = CPLib.GetProperty(p_RNATGIU,"",0,i);
      row.RCOMP = CPLib.GetProperty(p_RCOMP,"",0,i);
      row.RATTIV = CPLib.GetProperty(p_RATTIV,"",0,i);
      row.RAREA = CPLib.GetProperty(p_RAREA,"",0,i);
      row.PEP = CPLib.GetProperty(p_PEP,"","",i);
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.DATAVARAGE = CPLib.GetProperty(p_DATAVARAGE,"",CPLib.NullDate(),i);
      row.FATCA = CPLib.GetProperty(p_FATCA,"","",i);
      row.TIN = CPLib.GetProperty(p_TIN,"","",i);
      row.ODB = CPLib.GetProperty(p_ODB,"","",i);
      row.TELEF = CPLib.GetProperty(p_TELEF,"","",i);
      row.TIPOORO = CPLib.GetProperty(p_TIPOORO,"","",i);
      row.CODORO = CPLib.GetProperty(p_CODORO,"","",i);
      row.NOTIT = CPLib.GetProperty(p_NOTIT,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcpersonbo_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcpersonbo_mcrdef();
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
  public MemoryCursorRow_mcpersonbo_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcpersonbo_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcpersonbo_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    MemoryCursorRow_mcpersonbo_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcpersonbo_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcpersonbo_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcpersonbo_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
