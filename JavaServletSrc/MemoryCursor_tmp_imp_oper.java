// Definition generated from table tmp_imp_oper
public class MemoryCursor_tmp_imp_oper extends CPMemoryCursor {
  MemoryCursorRow_tmp_imp_oper row;
  MemoryCursorRow_tmp_imp_oper empty_row;
  public MemoryCursor_tmp_imp_oper() {
    empty_row = new MemoryCursorRow_tmp_imp_oper();
    row = empty_row;
  }
  public MemoryCursor_tmp_imp_oper(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_FLAGFRAZ;
    p_FLAGFRAZ = new java.util.Properties();
    java.util.Properties p_CAUOPER;
    p_CAUOPER = new java.util.Properties();
    java.util.Properties p_CONNESCLI;
    p_CONNESCLI = new java.util.Properties();
    java.util.Properties p_CONNESREAL;
    p_CONNESREAL = new java.util.Properties();
    java.util.Properties p_CONNESBEN;
    p_CONNESBEN = new java.util.Properties();
    java.util.Properties p_DATAREG;
    p_DATAREG = new java.util.Properties();
    java.util.Properties p_STATOREG;
    p_STATOREG = new java.util.Properties();
    java.util.Properties p_DATARETT;
    p_DATARETT = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_IMPORTO;
    p_IMPORTO = new java.util.Properties();
    java.util.Properties p_CONTANTI;
    p_CONTANTI = new java.util.Properties();
    java.util.Properties p_MEZPAG;
    p_MEZPAG = new java.util.Properties();
    java.util.Properties p_PRESTAZ;
    p_PRESTAZ = new java.util.Properties();
    java.util.Properties p_POSIZ;
    p_POSIZ = new java.util.Properties();
    java.util.Properties p_RAGIO;
    p_RAGIO = new java.util.Properties();
    java.util.Properties p_MODSVOL;
    p_MODSVOL = new java.util.Properties();
    java.util.Properties p_AREAGEO;
    p_AREAGEO = new java.util.Properties();
    java.util.Properties p_TIPO;
    p_TIPO = new java.util.Properties();
    java.util.Properties p_AMMONT;
    p_AMMONT = new java.util.Properties();
    java.util.Properties p_DURAT;
    p_DURAT = new java.util.Properties();
    java.util.Properties p_RAREA;
    p_RAREA = new java.util.Properties();
    java.util.Properties p_RRAGIO;
    p_RRAGIO = new java.util.Properties();
    java.util.Properties p_RCOMP;
    p_RCOMP = new java.util.Properties();
    java.util.Properties p_RTIPO;
    p_RTIPO = new java.util.Properties();
    java.util.Properties p_RFREQ;
    p_RFREQ = new java.util.Properties();
    java.util.Properties p_RIMP;
    p_RIMP = new java.util.Properties();
    java.util.Properties p_CODABI;
    p_CODABI = new java.util.Properties();
    java.util.Properties p_CODCAB;
    p_CODCAB = new java.util.Properties();
    java.util.Properties p_CONNALTRO;
    p_CONNALTRO = new java.util.Properties();
    java.util.Properties p_IMPPROG;
    p_IMPPROG = new java.util.Properties();
    java.util.Properties p_DESPUNTO;
    p_DESPUNTO = new java.util.Properties();
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
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FLAGFRAZ".equalsIgnoreCase(key)) {
        p_FLAGFRAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAUOPER".equalsIgnoreCase(key)) {
        p_CAUOPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESCLI".equalsIgnoreCase(key)) {
        p_CONNESCLI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESREAL".equalsIgnoreCase(key)) {
        p_CONNESREAL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESBEN".equalsIgnoreCase(key)) {
        p_CONNESBEN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAREG".equalsIgnoreCase(key)) {
        p_DATAREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("STATOREG".equalsIgnoreCase(key)) {
        p_STATOREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATARETT".equalsIgnoreCase(key)) {
        p_DATARETT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO".equalsIgnoreCase(key)) {
        p_IMPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTANTI".equalsIgnoreCase(key)) {
        p_CONTANTI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MEZPAG".equalsIgnoreCase(key)) {
        p_MEZPAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PRESTAZ".equalsIgnoreCase(key)) {
        p_PRESTAZ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("POSIZ".equalsIgnoreCase(key)) {
        p_POSIZ = CPLib.GetProperties(p.getProperty(key));
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
      if ("TIPO".equalsIgnoreCase(key)) {
        p_TIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AMMONT".equalsIgnoreCase(key)) {
        p_AMMONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DURAT".equalsIgnoreCase(key)) {
        p_DURAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAREA".equalsIgnoreCase(key)) {
        p_RAREA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RRAGIO".equalsIgnoreCase(key)) {
        p_RRAGIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RCOMP".equalsIgnoreCase(key)) {
        p_RCOMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RTIPO".equalsIgnoreCase(key)) {
        p_RTIPO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RFREQ".equalsIgnoreCase(key)) {
        p_RFREQ = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RIMP".equalsIgnoreCase(key)) {
        p_RIMP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODABI".equalsIgnoreCase(key)) {
        p_CODABI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB".equalsIgnoreCase(key)) {
        p_CODCAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNALTRO".equalsIgnoreCase(key)) {
        p_CONNALTRO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPPROG".equalsIgnoreCase(key)) {
        p_IMPPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESPUNTO".equalsIgnoreCase(key)) {
        p_DESPUNTO = CPLib.GetProperties(p.getProperty(key));
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
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"","",i);
      row.FLAGFRAZ = CPLib.GetProperty(p_FLAGFRAZ,"","",i);
      row.CAUOPER = CPLib.GetProperty(p_CAUOPER,"","",i);
      row.CONNESCLI = CPLib.GetProperty(p_CONNESCLI,"","",i);
      row.CONNESREAL = CPLib.GetProperty(p_CONNESREAL,"","",i);
      row.CONNESBEN = CPLib.GetProperty(p_CONNESBEN,"","",i);
      row.DATAREG = CPLib.GetProperty(p_DATAREG,"","",i);
      row.STATOREG = CPLib.GetProperty(p_STATOREG,"","",i);
      row.DATARETT = CPLib.GetProperty(p_DATARETT,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.IMPORTO = CPLib.GetProperty(p_IMPORTO,"",0,i);
      row.CONTANTI = CPLib.GetProperty(p_CONTANTI,"",0,i);
      row.MEZPAG = CPLib.GetProperty(p_MEZPAG,"","",i);
      row.PRESTAZ = CPLib.GetProperty(p_PRESTAZ,"","",i);
      row.POSIZ = CPLib.GetProperty(p_POSIZ,"","",i);
      row.RAGIO = CPLib.GetProperty(p_RAGIO,"","",i);
      row.MODSVOL = CPLib.GetProperty(p_MODSVOL,"","",i);
      row.AREAGEO = CPLib.GetProperty(p_AREAGEO,"","",i);
      row.TIPO = CPLib.GetProperty(p_TIPO,"","",i);
      row.AMMONT = CPLib.GetProperty(p_AMMONT,"","",i);
      row.DURAT = CPLib.GetProperty(p_DURAT,"","",i);
      row.RAREA = CPLib.GetProperty(p_RAREA,"",0,i);
      row.RRAGIO = CPLib.GetProperty(p_RRAGIO,"",0,i);
      row.RCOMP = CPLib.GetProperty(p_RCOMP,"",0,i);
      row.RTIPO = CPLib.GetProperty(p_RTIPO,"",0,i);
      row.RFREQ = CPLib.GetProperty(p_RFREQ,"",0,i);
      row.RIMP = CPLib.GetProperty(p_RIMP,"",0,i);
      row.CODABI = CPLib.GetProperty(p_CODABI,"","",i);
      row.CODCAB = CPLib.GetProperty(p_CODCAB,"","",i);
      row.CONNALTRO = CPLib.GetProperty(p_CONNALTRO,"","",i);
      row.IMPPROG = CPLib.GetProperty(p_IMPPROG,"","",i);
      row.DESPUNTO = CPLib.GetProperty(p_DESPUNTO,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tmp_imp_oper)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tmp_imp_oper();
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
  public MemoryCursorRow_tmp_imp_oper _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tmp_imp_oper _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tmp_imp_oper> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tmp_imp_oper p_Row) {
    MemoryCursorRow_tmp_imp_oper l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tmp_imp_oper();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tmp_imp_oper p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tmp_imp_oper();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
