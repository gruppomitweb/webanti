// Definition generated from table anadip
public class MemoryCursor_anadip extends CPMemoryCursor {
  MemoryCursorRow_anadip row;
  MemoryCursorRow_anadip empty_row;
  public MemoryCursor_anadip() {
    empty_row = new MemoryCursorRow_anadip();
    row = empty_row;
  }
  public MemoryCursor_anadip(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CODDIP;
    p_CODDIP = new java.util.Properties();
    java.util.Properties p_DESCRIZ;
    p_DESCRIZ = new java.util.Properties();
    java.util.Properties p_IDCITTA;
    p_IDCITTA = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_AGENTE;
    p_AGENTE = new java.util.Properties();
    java.util.Properties p_MACROAGENTE;
    p_MACROAGENTE = new java.util.Properties();
    java.util.Properties p_TERMINALID;
    p_TERMINALID = new java.util.Properties();
    java.util.Properties p_DOMICILIO;
    p_DOMICILIO = new java.util.Properties();
    java.util.Properties p_TELEFONO;
    p_TELEFONO = new java.util.Properties();
    java.util.Properties p_CODLOC;
    p_CODLOC = new java.util.Properties();
    java.util.Properties p_ABICABSARA;
    p_ABICABSARA = new java.util.Properties();
    java.util.Properties p_NUOVO;
    p_NUOVO = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_AGACCODE;
    p_AGACCODE = new java.util.Properties();
    java.util.Properties p_NAZAGENTE;
    p_NAZAGENTE = new java.util.Properties();
    java.util.Properties p_OPXSOSCLI;
    p_OPXSOSCLI = new java.util.Properties();
    java.util.Properties p_OPXSOSAGE;
    p_OPXSOSAGE = new java.util.Properties();
    java.util.Properties p_VALCOMPL;
    p_VALCOMPL = new java.util.Properties();
    java.util.Properties p_ANOMOPER;
    p_ANOMOPER = new java.util.Properties();
    java.util.Properties p_AGEREGIO;
    p_AGEREGIO = new java.util.Properties();
    java.util.Properties p_FLGATT;
    p_FLGATT = new java.util.Properties();
    java.util.Properties p_CODAGE;
    p_CODAGE = new java.util.Properties();
    java.util.Properties p_TIPOSV;
    p_TIPOSV = new java.util.Properties();
    java.util.Properties p_FLGNOAUA;
    p_FLGNOAUA = new java.util.Properties();
    java.util.Properties p_FLGWUPOS;
    p_FLGWUPOS = new java.util.Properties();
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
    java.util.Properties p_CAB2;
    p_CAB2 = new java.util.Properties();
    java.util.Properties p_RISGLOB;
    p_RISGLOB = new java.util.Properties();
    java.util.Properties p_DATAPROF;
    p_DATAPROF = new java.util.Properties();
    java.util.Properties p_CODICEAAMS;
    p_CODICEAAMS = new java.util.Properties();
    java.util.Properties p_CONCESSIONE;
    p_CONCESSIONE = new java.util.Properties();
    java.util.Properties p_CODFISC;
    p_CODFISC = new java.util.Properties();
    java.util.Properties p_PARTIVA;
    p_PARTIVA = new java.util.Properties();
    java.util.Properties p_TIPOAGENTE;
    p_TIPOAGENTE = new java.util.Properties();
    java.util.Properties p_NUMCIVICO;
    p_NUMCIVICO = new java.util.Properties();
    java.util.Properties p_DATAINI;
    p_DATAINI = new java.util.Properties();
    java.util.Properties p_DATAFINE;
    p_DATAFINE = new java.util.Properties();
    java.util.Properties p_SERRIMDEN;
    p_SERRIMDEN = new java.util.Properties();
    java.util.Properties p_FLGCOMPL;
    p_FLGCOMPL = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIP".equalsIgnoreCase(key)) {
        p_CODDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCRIZ".equalsIgnoreCase(key)) {
        p_DESCRIZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDCITTA".equalsIgnoreCase(key)) {
        p_IDCITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGENTE".equalsIgnoreCase(key)) {
        p_AGENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACROAGENTE".equalsIgnoreCase(key)) {
        p_MACROAGENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TERMINALID".equalsIgnoreCase(key)) {
        p_TERMINALID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DOMICILIO".equalsIgnoreCase(key)) {
        p_DOMICILIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TELEFONO".equalsIgnoreCase(key)) {
        p_TELEFONO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODLOC".equalsIgnoreCase(key)) {
        p_CODLOC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABICABSARA".equalsIgnoreCase(key)) {
        p_ABICABSARA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUOVO".equalsIgnoreCase(key)) {
        p_NUOVO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGACCODE".equalsIgnoreCase(key)) {
        p_AGACCODE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NAZAGENTE".equalsIgnoreCase(key)) {
        p_NAZAGENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPXSOSCLI".equalsIgnoreCase(key)) {
        p_OPXSOSCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OPXSOSAGE".equalsIgnoreCase(key)) {
        p_OPXSOSAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALCOMPL".equalsIgnoreCase(key)) {
        p_VALCOMPL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ANOMOPER".equalsIgnoreCase(key)) {
        p_ANOMOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AGEREGIO".equalsIgnoreCase(key)) {
        p_AGEREGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGATT".equalsIgnoreCase(key)) {
        p_FLGATT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODAGE".equalsIgnoreCase(key)) {
        p_CODAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOSV".equalsIgnoreCase(key)) {
        p_TIPOSV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGNOAUA".equalsIgnoreCase(key)) {
        p_FLGNOAUA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGWUPOS".equalsIgnoreCase(key)) {
        p_FLGWUPOS = CPLib.GetProperties(p.getProperty(key));
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
      if ("CAB2".equalsIgnoreCase(key)) {
        p_CAB2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RISGLOB".equalsIgnoreCase(key)) {
        p_RISGLOB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAPROF".equalsIgnoreCase(key)) {
        p_DATAPROF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICEAAMS".equalsIgnoreCase(key)) {
        p_CODICEAAMS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONCESSIONE".equalsIgnoreCase(key)) {
        p_CONCESSIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISC".equalsIgnoreCase(key)) {
        p_CODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PARTIVA".equalsIgnoreCase(key)) {
        p_PARTIVA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOAGENTE".equalsIgnoreCase(key)) {
        p_TIPOAGENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMCIVICO".equalsIgnoreCase(key)) {
        p_NUMCIVICO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAINI".equalsIgnoreCase(key)) {
        p_DATAINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAFINE".equalsIgnoreCase(key)) {
        p_DATAFINE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SERRIMDEN".equalsIgnoreCase(key)) {
        p_SERRIMDEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLGCOMPL".equalsIgnoreCase(key)) {
        p_FLGCOMPL = CPLib.GetProperties(p.getProperty(key));
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
      row.CODDIP = CPLib.GetProperty(p_CODDIP,"","",i);
      row.DESCRIZ = CPLib.GetProperty(p_DESCRIZ,"","",i);
      row.IDCITTA = CPLib.GetProperty(p_IDCITTA,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.AGENTE = CPLib.GetProperty(p_AGENTE,"","",i);
      row.MACROAGENTE = CPLib.GetProperty(p_MACROAGENTE,"","",i);
      row.TERMINALID = CPLib.GetProperty(p_TERMINALID,"","",i);
      row.DOMICILIO = CPLib.GetProperty(p_DOMICILIO,"","",i);
      row.TELEFONO = CPLib.GetProperty(p_TELEFONO,"","",i);
      row.CODLOC = CPLib.GetProperty(p_CODLOC,"","",i);
      row.ABICABSARA = CPLib.GetProperty(p_ABICABSARA,"","",i);
      row.NUOVO = CPLib.GetProperty(p_NUOVO,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.AGACCODE = CPLib.GetProperty(p_AGACCODE,"","",i);
      row.NAZAGENTE = CPLib.GetProperty(p_NAZAGENTE,"","",i);
      row.OPXSOSCLI = CPLib.GetProperty(p_OPXSOSCLI,"",0,i);
      row.OPXSOSAGE = CPLib.GetProperty(p_OPXSOSAGE,"",0,i);
      row.VALCOMPL = CPLib.GetProperty(p_VALCOMPL,"","",i);
      row.ANOMOPER = CPLib.GetProperty(p_ANOMOPER,"","",i);
      row.AGEREGIO = CPLib.GetProperty(p_AGEREGIO,"","",i);
      row.FLGATT = CPLib.GetProperty(p_FLGATT,"","",i);
      row.CODAGE = CPLib.GetProperty(p_CODAGE,"","",i);
      row.TIPOSV = CPLib.GetProperty(p_TIPOSV,"","",i);
      row.FLGNOAUA = CPLib.GetProperty(p_FLGNOAUA,"","",i);
      row.FLGWUPOS = CPLib.GetProperty(p_FLGWUPOS,"","",i);
      row.CATEG01 = CPLib.GetProperty(p_CATEG01,"","",i);
      row.CATEG02 = CPLib.GetProperty(p_CATEG02,"","",i);
      row.CATEG03 = CPLib.GetProperty(p_CATEG03,"","",i);
      row.CATEG04 = CPLib.GetProperty(p_CATEG04,"","",i);
      row.CATEG05 = CPLib.GetProperty(p_CATEG05,"","",i);
      row.CATEGORIA = CPLib.GetProperty(p_CATEGORIA,"","",i);
      row.CAB2 = CPLib.GetProperty(p_CAB2,"","",i);
      row.RISGLOB = CPLib.GetProperty(p_RISGLOB,"","",i);
      row.DATAPROF = CPLib.GetProperty(p_DATAPROF,"",CPLib.NullDate(),i);
      row.CODICEAAMS = CPLib.GetProperty(p_CODICEAAMS,"","",i);
      row.CONCESSIONE = CPLib.GetProperty(p_CONCESSIONE,"","",i);
      row.CODFISC = CPLib.GetProperty(p_CODFISC,"","",i);
      row.PARTIVA = CPLib.GetProperty(p_PARTIVA,"","",i);
      row.TIPOAGENTE = CPLib.GetProperty(p_TIPOAGENTE,"","",i);
      row.NUMCIVICO = CPLib.GetProperty(p_NUMCIVICO,"","",i);
      row.DATAINI = CPLib.GetProperty(p_DATAINI,"",CPLib.NullDate(),i);
      row.DATAFINE = CPLib.GetProperty(p_DATAFINE,"",CPLib.NullDate(),i);
      row.SERRIMDEN = CPLib.GetProperty(p_SERRIMDEN,"","",i);
      row.FLGCOMPL = CPLib.GetProperty(p_FLGCOMPL,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_anadip)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_anadip();
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
  public MemoryCursorRow_anadip _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_anadip _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_anadip> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_anadip p_Row) {
    MemoryCursorRow_anadip l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_anadip();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_anadip p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_anadip();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
