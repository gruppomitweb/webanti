// Definition generated from record definition mcsoggettico_mcrdef
public class MemoryCursor_mcsoggettico_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcsoggettico_mcrdef row;
  MemoryCursorRow_mcsoggettico_mcrdef empty_row;
  public MemoryCursor_mcsoggettico_mcrdef() {
    empty_row = new MemoryCursorRow_mcsoggettico_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcsoggettico_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CONTASOGG;
    p_CONTASOGG = new java.util.Properties();
    java.util.Properties p_CODICE_SEGNALANTE;
    p_CODICE_SEGNALANTE = new java.util.Properties();
    java.util.Properties p_DATA_CONTABILE;
    p_DATA_CONTABILE = new java.util.Properties();
    java.util.Properties p_ID_OPERAZIONE;
    p_ID_OPERAZIONE = new java.util.Properties();
    java.util.Properties p_PROG_SOGGETTO;
    p_PROG_SOGGETTO = new java.util.Properties();
    java.util.Properties p_CODICE_TIPO_SOGGETTO;
    p_CODICE_TIPO_SOGGETTO = new java.util.Properties();
    java.util.Properties p_NATURA_GIURIDICA;
    p_NATURA_GIURIDICA = new java.util.Properties();
    java.util.Properties p_CODICE_FISCALE;
    p_CODICE_FISCALE = new java.util.Properties();
    java.util.Properties p_SGRP_ATTIVITA_EC;
    p_SGRP_ATTIVITA_EC = new java.util.Properties();
    java.util.Properties p_CODICE_ATECO;
    p_CODICE_ATECO = new java.util.Properties();
    java.util.Properties p_NPF_DENOMINAZIONE;
    p_NPF_DENOMINAZIONE = new java.util.Properties();
    java.util.Properties p_NPF_SEDELEG_IND_COMUNE;
    p_NPF_SEDELEG_IND_COMUNE = new java.util.Properties();
    java.util.Properties p_NPF_SEDELEG_IND_STATO;
    p_NPF_SEDELEG_IND_STATO = new java.util.Properties();
    java.util.Properties p_PF_NOME;
    p_PF_NOME = new java.util.Properties();
    java.util.Properties p_PF_COGNOME;
    p_PF_COGNOME = new java.util.Properties();
    java.util.Properties p_PF_SESSO;
    p_PF_SESSO = new java.util.Properties();
    java.util.Properties p_PF_DATANASCITA;
    p_PF_DATANASCITA = new java.util.Properties();
    java.util.Properties p_PF_STATONASCITA;
    p_PF_STATONASCITA = new java.util.Properties();
    java.util.Properties p_PF_COMUNENASCITA;
    p_PF_COMUNENASCITA = new java.util.Properties();
    java.util.Properties p_PF_IND_COMUNE;
    p_PF_IND_COMUNE = new java.util.Properties();
    java.util.Properties p_PF_IND_STATO;
    p_PF_IND_STATO = new java.util.Properties();
    java.util.Properties p_PF_POLITIC_ESPOSTA;
    p_PF_POLITIC_ESPOSTA = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONTASOGG".equalsIgnoreCase(key)) {
        p_CONTASOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_SEGNALANTE".equalsIgnoreCase(key)) {
        p_CODICE_SEGNALANTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_CONTABILE".equalsIgnoreCase(key)) {
        p_DATA_CONTABILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ID_OPERAZIONE".equalsIgnoreCase(key)) {
        p_ID_OPERAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROG_SOGGETTO".equalsIgnoreCase(key)) {
        p_PROG_SOGGETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_TIPO_SOGGETTO".equalsIgnoreCase(key)) {
        p_CODICE_TIPO_SOGGETTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NATURA_GIURIDICA".equalsIgnoreCase(key)) {
        p_NATURA_GIURIDICA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_FISCALE".equalsIgnoreCase(key)) {
        p_CODICE_FISCALE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SGRP_ATTIVITA_EC".equalsIgnoreCase(key)) {
        p_SGRP_ATTIVITA_EC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_ATECO".equalsIgnoreCase(key)) {
        p_CODICE_ATECO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NPF_DENOMINAZIONE".equalsIgnoreCase(key)) {
        p_NPF_DENOMINAZIONE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NPF_SEDELEG_IND_COMUNE".equalsIgnoreCase(key)) {
        p_NPF_SEDELEG_IND_COMUNE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NPF_SEDELEG_IND_STATO".equalsIgnoreCase(key)) {
        p_NPF_SEDELEG_IND_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_NOME".equalsIgnoreCase(key)) {
        p_PF_NOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_COGNOME".equalsIgnoreCase(key)) {
        p_PF_COGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_SESSO".equalsIgnoreCase(key)) {
        p_PF_SESSO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_DATANASCITA".equalsIgnoreCase(key)) {
        p_PF_DATANASCITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_STATONASCITA".equalsIgnoreCase(key)) {
        p_PF_STATONASCITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_COMUNENASCITA".equalsIgnoreCase(key)) {
        p_PF_COMUNENASCITA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_IND_COMUNE".equalsIgnoreCase(key)) {
        p_PF_IND_COMUNE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_IND_STATO".equalsIgnoreCase(key)) {
        p_PF_IND_STATO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PF_POLITIC_ESPOSTA".equalsIgnoreCase(key)) {
        p_PF_POLITIC_ESPOSTA = CPLib.GetProperties(p.getProperty(key));
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
      row.CONTASOGG = CPLib.GetProperty(p_CONTASOGG,"",0,i);
      row.CODICE_SEGNALANTE = CPLib.GetProperty(p_CODICE_SEGNALANTE,"","",i);
      row.DATA_CONTABILE = CPLib.GetProperty(p_DATA_CONTABILE,"","",i);
      row.ID_OPERAZIONE = CPLib.GetProperty(p_ID_OPERAZIONE,"",0,i);
      row.PROG_SOGGETTO = CPLib.GetProperty(p_PROG_SOGGETTO,"",0,i);
      row.CODICE_TIPO_SOGGETTO = CPLib.GetProperty(p_CODICE_TIPO_SOGGETTO,"","",i);
      row.NATURA_GIURIDICA = CPLib.GetProperty(p_NATURA_GIURIDICA,"","",i);
      row.CODICE_FISCALE = CPLib.GetProperty(p_CODICE_FISCALE,"","",i);
      row.SGRP_ATTIVITA_EC = CPLib.GetProperty(p_SGRP_ATTIVITA_EC,"","",i);
      row.CODICE_ATECO = CPLib.GetProperty(p_CODICE_ATECO,"","",i);
      row.NPF_DENOMINAZIONE = CPLib.GetProperty(p_NPF_DENOMINAZIONE,"","",i);
      row.NPF_SEDELEG_IND_COMUNE = CPLib.GetProperty(p_NPF_SEDELEG_IND_COMUNE,"","",i);
      row.NPF_SEDELEG_IND_STATO = CPLib.GetProperty(p_NPF_SEDELEG_IND_STATO,"","",i);
      row.PF_NOME = CPLib.GetProperty(p_PF_NOME,"","",i);
      row.PF_COGNOME = CPLib.GetProperty(p_PF_COGNOME,"","",i);
      row.PF_SESSO = CPLib.GetProperty(p_PF_SESSO,"","",i);
      row.PF_DATANASCITA = CPLib.GetProperty(p_PF_DATANASCITA,"","",i);
      row.PF_STATONASCITA = CPLib.GetProperty(p_PF_STATONASCITA,"","",i);
      row.PF_COMUNENASCITA = CPLib.GetProperty(p_PF_COMUNENASCITA,"","",i);
      row.PF_IND_COMUNE = CPLib.GetProperty(p_PF_IND_COMUNE,"","",i);
      row.PF_IND_STATO = CPLib.GetProperty(p_PF_IND_STATO,"","",i);
      row.PF_POLITIC_ESPOSTA = CPLib.GetProperty(p_PF_POLITIC_ESPOSTA,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcsoggettico_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcsoggettico_mcrdef();
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
  public MemoryCursorRow_mcsoggettico_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcsoggettico_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcsoggettico_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    MemoryCursorRow_mcsoggettico_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcsoggettico_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcsoggettico_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcsoggettico_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
