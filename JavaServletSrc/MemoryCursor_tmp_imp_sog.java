// Definition generated from table tmp_imp_sog
public class MemoryCursor_tmp_imp_sog extends CPMemoryCursor {
  MemoryCursorRow_tmp_imp_sog row;
  MemoryCursorRow_tmp_imp_sog empty_row;
  public MemoryCursor_tmp_imp_sog() {
    empty_row = new MemoryCursorRow_tmp_imp_sog();
    row = empty_row;
  }
  public MemoryCursor_tmp_imp_sog(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPOOPER;
    p_TIPOOPER = new java.util.Properties();
    java.util.Properties p_CODSTUDIO;
    p_CODSTUDIO = new java.util.Properties();
    java.util.Properties p_TIPOIDEN;
    p_TIPOIDEN = new java.util.Properties();
    java.util.Properties p_CONNES;
    p_CONNES = new java.util.Properties();
    java.util.Properties p_DATAIDENT;
    p_DATAIDENT = new java.util.Properties();
    java.util.Properties p_RAGSOC;
    p_RAGSOC = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
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
    java.util.Properties p_SESSO;
    p_SESSO = new java.util.Properties();
    java.util.Properties p_STATOREG;
    p_STATOREG = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties p_DATAVALI;
    p_DATAVALI = new java.util.Properties();
    java.util.Properties p_PROVNASC;
    p_PROVNASC = new java.util.Properties();
    java.util.Properties p_RESPINS;
    p_RESPINS = new java.util.Properties();
    java.util.Properties p_CODCLI;
    p_CODCLI = new java.util.Properties();
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
    java.util.Properties p_RAPSEGNA;
    p_RAPSEGNA = new java.util.Properties();
    java.util.Properties p_PIVA;
    p_PIVA = new java.util.Properties();
    java.util.Properties p_PEP;
    p_PEP = new java.util.Properties();
    java.util.Properties p_TIPSOG;
    p_TIPSOG = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOOPER".equalsIgnoreCase(key)) {
        p_TIPOOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODSTUDIO".equalsIgnoreCase(key)) {
        p_CODSTUDIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOIDEN".equalsIgnoreCase(key)) {
        p_TIPOIDEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNES".equalsIgnoreCase(key)) {
        p_CONNES = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAIDENT".equalsIgnoreCase(key)) {
        p_DATAIDENT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOC".equalsIgnoreCase(key)) {
        p_RAGSOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOMICILIO".equalsIgnoreCase(key)) {
        p_DOMICILIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
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
      if ("SESSO".equalsIgnoreCase(key)) {
        p_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOREG".equalsIgnoreCase(key)) {
        p_STATOREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAVALI".equalsIgnoreCase(key)) {
        p_DATAVALI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVNASC".equalsIgnoreCase(key)) {
        p_PROVNASC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RESPINS".equalsIgnoreCase(key)) {
        p_RESPINS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCLI".equalsIgnoreCase(key)) {
        p_CODCLI = CPLib.GetProperties(p.getProperty(key));
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
      if ("RAPSEGNA".equalsIgnoreCase(key)) {
        p_RAPSEGNA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PIVA".equalsIgnoreCase(key)) {
        p_PIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PEP".equalsIgnoreCase(key)) {
        p_PEP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPSOG".equalsIgnoreCase(key)) {
        p_TIPSOG = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPOOPER = CPLib.GetProperty(p_TIPOOPER,"","",i);
      row.CODSTUDIO = CPLib.GetProperty(p_CODSTUDIO,"","",i);
      row.TIPOIDEN = CPLib.GetProperty(p_TIPOIDEN,"","",i);
      row.CONNES = CPLib.GetProperty(p_CONNES,"","",i);
      row.DATAIDENT = CPLib.GetProperty(p_DATAIDENT,"","",i);
      row.RAGSOC = CPLib.GetProperty(p_RAGSOC,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.DATANASC = CPLib.GetProperty(p_DATANASC,"","",i);
      row.NASCOMUN = CPLib.GetProperty(p_NASCOMUN,"","",i);
      row.TIPODOC = CPLib.GetProperty(p_TIPODOC,"","",i);
      row.NUMDOCUM = CPLib.GetProperty(p_NUMDOCUM,"","",i);
      row.DATARILASC = CPLib.GetProperty(p_DATARILASC,"","",i);
      row.AUTRILASC = CPLib.GetProperty(p_AUTRILASC,"","",i);
      row.SESSO = CPLib.GetProperty(p_SESSO,"","",i);
      row.STATOREG = CPLib.GetProperty(p_STATOREG,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"","",i);
      row.DATAVALI = CPLib.GetProperty(p_DATAVALI,"","",i);
      row.PROVNASC = CPLib.GetProperty(p_PROVNASC,"","",i);
      row.RESPINS = CPLib.GetProperty(p_RESPINS,"","",i);
      row.CODCLI = CPLib.GetProperty(p_CODCLI,"","",i);
      row.SPECIE = CPLib.GetProperty(p_SPECIE,"","",i);
      row.COMPORT = CPLib.GetProperty(p_COMPORT,"","",i);
      row.ATTIV = CPLib.GetProperty(p_ATTIV,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.RNATGIU = CPLib.GetProperty(p_RNATGIU,"",0,i);
      row.RCOMP = CPLib.GetProperty(p_RCOMP,"",0,i);
      row.RATTIV = CPLib.GetProperty(p_RATTIV,"",0,i);
      row.RAREA = CPLib.GetProperty(p_RAREA,"",0,i);
      row.RAPSEGNA = CPLib.GetProperty(p_RAPSEGNA,"","",i);
      row.PIVA = CPLib.GetProperty(p_PIVA,"","",i);
      row.PEP = CPLib.GetProperty(p_PEP,"","",i);
      row.TIPSOG = CPLib.GetProperty(p_TIPSOG,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_imp_sog)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_imp_sog();
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
  public MemoryCursorRow_tmp_imp_sog _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_imp_sog _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_imp_sog> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_imp_sog p_Row) {
    MemoryCursorRow_tmp_imp_sog l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_sog();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_imp_sog p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_imp_sog();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
