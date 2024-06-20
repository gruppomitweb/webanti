// Definition generated from record definition mcrilievisara_mcrdef
public class MemoryCursor_mcrilievisara_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcrilievisara_mcrdef row;
  MemoryCursorRow_mcrilievisara_mcrdef empty_row;
  public MemoryCursor_mcrilievisara_mcrdef() {
    empty_row = new MemoryCursorRow_mcrilievisara_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcrilievisara_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_ID;
    p_ID = new java.util.Properties();
    java.util.Properties p_MOTIVO;
    p_MOTIVO = new java.util.Properties();
    java.util.Properties p_TIPOLOGIA;
    p_TIPOLOGIA = new java.util.Properties();
    java.util.Properties p_CAUSALE_AGGREGATA;
    p_CAUSALE_AGGREGATA = new java.util.Properties();
    java.util.Properties p_CAUSALE_AGGREGATA_ERR;
    p_CAUSALE_AGGREGATA_ERR = new java.util.Properties();
    java.util.Properties p_CODICE_INTERNO_DIP;
    p_CODICE_INTERNO_DIP = new java.util.Properties();
    java.util.Properties p_CODICE_INTERNO_DIP_ERR;
    p_CODICE_INTERNO_DIP_ERR = new java.util.Properties();
    java.util.Properties p_CODICE_SEGNALANTE;
    p_CODICE_SEGNALANTE = new java.util.Properties();
    java.util.Properties p_CODICE_SEGNALANTE_ERR;
    p_CODICE_SEGNALANTE_ERR = new java.util.Properties();
    java.util.Properties p_CODICE_VALUTA;
    p_CODICE_VALUTA = new java.util.Properties();
    java.util.Properties p_CODICE_VALUTA_ERR;
    p_CODICE_VALUTA_ERR = new java.util.Properties();
    java.util.Properties p_COMUNE_CONTROPARTE;
    p_COMUNE_CONTROPARTE = new java.util.Properties();
    java.util.Properties p_COMUNE_CONTROPARTE_ERR;
    p_COMUNE_CONTROPARTE_ERR = new java.util.Properties();
    java.util.Properties p_COMUNE_INTERM_CTRP;
    p_COMUNE_INTERM_CTRP = new java.util.Properties();
    java.util.Properties p_COMUNE_INTERM_CTRP_ERR;
    p_COMUNE_INTERM_CTRP_ERR = new java.util.Properties();
    java.util.Properties p_COMUNE_DIP;
    p_COMUNE_DIP = new java.util.Properties();
    java.util.Properties p_COMUNE_DIP_ERR;
    p_COMUNE_DIP_ERR = new java.util.Properties();
    java.util.Properties p_COMUNE_RES_CLIENTE;
    p_COMUNE_RES_CLIENTE = new java.util.Properties();
    java.util.Properties p_COMUNE_RES_CLIENTE_ERR;
    p_COMUNE_RES_CLIENTE_ERR = new java.util.Properties();
    java.util.Properties p_DATA_RIFERIMENTO;
    p_DATA_RIFERIMENTO = new java.util.Properties();
    java.util.Properties p_DATA_RIFERIMENTO_ERR;
    p_DATA_RIFERIMENTO_ERR = new java.util.Properties();
    java.util.Properties p_PAESE_CONTROPARTE;
    p_PAESE_CONTROPARTE = new java.util.Properties();
    java.util.Properties p_PAESE_CONTROPARTE_ERR;
    p_PAESE_CONTROPARTE_ERR = new java.util.Properties();
    java.util.Properties p_PAESE_INTERM_CTRP;
    p_PAESE_INTERM_CTRP = new java.util.Properties();
    java.util.Properties p_PAESE_INTERM_CTRP_ERR;
    p_PAESE_INTERM_CTRP_ERR = new java.util.Properties();
    java.util.Properties p_PAESE_RES_CLIENTE;
    p_PAESE_RES_CLIENTE = new java.util.Properties();
    java.util.Properties p_PAESE_RES_CLIENTE_ERR;
    p_PAESE_RES_CLIENTE_ERR = new java.util.Properties();
    java.util.Properties p_SEGNO_MONETARIO;
    p_SEGNO_MONETARIO = new java.util.Properties();
    java.util.Properties p_SEGNO_MONETARIO_ERR;
    p_SEGNO_MONETARIO_ERR = new java.util.Properties();
    java.util.Properties p_SETTORIZ_SINT_ECON;
    p_SETTORIZ_SINT_ECON = new java.util.Properties();
    java.util.Properties p_SETTORIZ_SINT_ECON_ERR;
    p_SETTORIZ_SINT_ECON_ERR = new java.util.Properties();
    java.util.Properties p_TIPO_SEGNALANTE;
    p_TIPO_SEGNALANTE = new java.util.Properties();
    java.util.Properties p_TIPO_SEGNALANTE_ERR;
    p_TIPO_SEGNALANTE_ERR = new java.util.Properties();
    java.util.Properties p_IMPORTO_TOT;
    p_IMPORTO_TOT = new java.util.Properties();
    java.util.Properties p_IMPORTO_TOT_ERR;
    p_IMPORTO_TOT_ERR = new java.util.Properties();
    java.util.Properties p_IMPORTO_TOT_CONTANTI;
    p_IMPORTO_TOT_CONTANTI = new java.util.Properties();
    java.util.Properties p_IMPORTO_TOT_CONTANTI_ERR;
    p_IMPORTO_TOT_CONTANTI_ERR = new java.util.Properties();
    java.util.Properties p_NUMERO_OPER_CONT;
    p_NUMERO_OPER_CONT = new java.util.Properties();
    java.util.Properties p_NUMERO_OPER_CONT_ERR;
    p_NUMERO_OPER_CONT_ERR = new java.util.Properties();
    java.util.Properties p_NUMERO_TOT_OPER;
    p_NUMERO_TOT_OPER = new java.util.Properties();
    java.util.Properties p_NUMERO_TOT_OPER_ERR;
    p_NUMERO_TOT_OPER_ERR = new java.util.Properties();
    java.util.Properties p_ABICAB_SPORTELLO;
    p_ABICAB_SPORTELLO = new java.util.Properties();
    java.util.Properties p_ABICAB_SPORTELLO_ERR;
    p_ABICAB_SPORTELLO_ERR = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ID".equalsIgnoreCase(key)) {
        p_ID = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MOTIVO".equalsIgnoreCase(key)) {
        p_MOTIVO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOLOGIA".equalsIgnoreCase(key)) {
        p_TIPOLOGIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAUSALE_AGGREGATA".equalsIgnoreCase(key)) {
        p_CAUSALE_AGGREGATA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAUSALE_AGGREGATA_ERR".equalsIgnoreCase(key)) {
        p_CAUSALE_AGGREGATA_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_INTERNO_DIP".equalsIgnoreCase(key)) {
        p_CODICE_INTERNO_DIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_INTERNO_DIP_ERR".equalsIgnoreCase(key)) {
        p_CODICE_INTERNO_DIP_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_SEGNALANTE".equalsIgnoreCase(key)) {
        p_CODICE_SEGNALANTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_SEGNALANTE_ERR".equalsIgnoreCase(key)) {
        p_CODICE_SEGNALANTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_VALUTA".equalsIgnoreCase(key)) {
        p_CODICE_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODICE_VALUTA_ERR".equalsIgnoreCase(key)) {
        p_CODICE_VALUTA_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_CONTROPARTE".equalsIgnoreCase(key)) {
        p_COMUNE_CONTROPARTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_CONTROPARTE_ERR".equalsIgnoreCase(key)) {
        p_COMUNE_CONTROPARTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_INTERM_CTRP".equalsIgnoreCase(key)) {
        p_COMUNE_INTERM_CTRP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_INTERM_CTRP_ERR".equalsIgnoreCase(key)) {
        p_COMUNE_INTERM_CTRP_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_DIP".equalsIgnoreCase(key)) {
        p_COMUNE_DIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_DIP_ERR".equalsIgnoreCase(key)) {
        p_COMUNE_DIP_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_RES_CLIENTE".equalsIgnoreCase(key)) {
        p_COMUNE_RES_CLIENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNE_RES_CLIENTE_ERR".equalsIgnoreCase(key)) {
        p_COMUNE_RES_CLIENTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_RIFERIMENTO".equalsIgnoreCase(key)) {
        p_DATA_RIFERIMENTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATA_RIFERIMENTO_ERR".equalsIgnoreCase(key)) {
        p_DATA_RIFERIMENTO_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_CONTROPARTE".equalsIgnoreCase(key)) {
        p_PAESE_CONTROPARTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_CONTROPARTE_ERR".equalsIgnoreCase(key)) {
        p_PAESE_CONTROPARTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_INTERM_CTRP".equalsIgnoreCase(key)) {
        p_PAESE_INTERM_CTRP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_INTERM_CTRP_ERR".equalsIgnoreCase(key)) {
        p_PAESE_INTERM_CTRP_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_RES_CLIENTE".equalsIgnoreCase(key)) {
        p_PAESE_RES_CLIENTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE_RES_CLIENTE_ERR".equalsIgnoreCase(key)) {
        p_PAESE_RES_CLIENTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO_MONETARIO".equalsIgnoreCase(key)) {
        p_SEGNO_MONETARIO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO_MONETARIO_ERR".equalsIgnoreCase(key)) {
        p_SEGNO_MONETARIO_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTORIZ_SINT_ECON".equalsIgnoreCase(key)) {
        p_SETTORIZ_SINT_ECON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SETTORIZ_SINT_ECON_ERR".equalsIgnoreCase(key)) {
        p_SETTORIZ_SINT_ECON_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO_SEGNALANTE".equalsIgnoreCase(key)) {
        p_TIPO_SEGNALANTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPO_SEGNALANTE_ERR".equalsIgnoreCase(key)) {
        p_TIPO_SEGNALANTE_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_TOT".equalsIgnoreCase(key)) {
        p_IMPORTO_TOT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_TOT_ERR".equalsIgnoreCase(key)) {
        p_IMPORTO_TOT_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_TOT_CONTANTI".equalsIgnoreCase(key)) {
        p_IMPORTO_TOT_CONTANTI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IMPORTO_TOT_CONTANTI_ERR".equalsIgnoreCase(key)) {
        p_IMPORTO_TOT_CONTANTI_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMERO_OPER_CONT".equalsIgnoreCase(key)) {
        p_NUMERO_OPER_CONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMERO_OPER_CONT_ERR".equalsIgnoreCase(key)) {
        p_NUMERO_OPER_CONT_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMERO_TOT_OPER".equalsIgnoreCase(key)) {
        p_NUMERO_TOT_OPER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMERO_TOT_OPER_ERR".equalsIgnoreCase(key)) {
        p_NUMERO_TOT_OPER_ERR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABICAB_SPORTELLO".equalsIgnoreCase(key)) {
        p_ABICAB_SPORTELLO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ABICAB_SPORTELLO_ERR".equalsIgnoreCase(key)) {
        p_ABICAB_SPORTELLO_ERR = CPLib.GetProperties(p.getProperty(key));
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
      row.ID = CPLib.GetProperty(p_ID,"","",i);
      row.MOTIVO = CPLib.GetProperty(p_MOTIVO,"","",i);
      row.TIPOLOGIA = CPLib.GetProperty(p_TIPOLOGIA,"","",i);
      row.CAUSALE_AGGREGATA = CPLib.GetProperty(p_CAUSALE_AGGREGATA,"","",i);
      row.CAUSALE_AGGREGATA_ERR = CPLib.GetProperty(p_CAUSALE_AGGREGATA_ERR,"","",i);
      row.CODICE_INTERNO_DIP = CPLib.GetProperty(p_CODICE_INTERNO_DIP,"","",i);
      row.CODICE_INTERNO_DIP_ERR = CPLib.GetProperty(p_CODICE_INTERNO_DIP_ERR,"","",i);
      row.CODICE_SEGNALANTE = CPLib.GetProperty(p_CODICE_SEGNALANTE,"","",i);
      row.CODICE_SEGNALANTE_ERR = CPLib.GetProperty(p_CODICE_SEGNALANTE_ERR,"","",i);
      row.CODICE_VALUTA = CPLib.GetProperty(p_CODICE_VALUTA,"","",i);
      row.CODICE_VALUTA_ERR = CPLib.GetProperty(p_CODICE_VALUTA_ERR,"","",i);
      row.COMUNE_CONTROPARTE = CPLib.GetProperty(p_COMUNE_CONTROPARTE,"","",i);
      row.COMUNE_CONTROPARTE_ERR = CPLib.GetProperty(p_COMUNE_CONTROPARTE_ERR,"","",i);
      row.COMUNE_INTERM_CTRP = CPLib.GetProperty(p_COMUNE_INTERM_CTRP,"","",i);
      row.COMUNE_INTERM_CTRP_ERR = CPLib.GetProperty(p_COMUNE_INTERM_CTRP_ERR,"","",i);
      row.COMUNE_DIP = CPLib.GetProperty(p_COMUNE_DIP,"","",i);
      row.COMUNE_DIP_ERR = CPLib.GetProperty(p_COMUNE_DIP_ERR,"","",i);
      row.COMUNE_RES_CLIENTE = CPLib.GetProperty(p_COMUNE_RES_CLIENTE,"","",i);
      row.COMUNE_RES_CLIENTE_ERR = CPLib.GetProperty(p_COMUNE_RES_CLIENTE_ERR,"","",i);
      row.DATA_RIFERIMENTO = CPLib.GetProperty(p_DATA_RIFERIMENTO,"",CPLib.NullDate(),i);
      row.DATA_RIFERIMENTO_ERR = CPLib.GetProperty(p_DATA_RIFERIMENTO_ERR,"","",i);
      row.PAESE_CONTROPARTE = CPLib.GetProperty(p_PAESE_CONTROPARTE,"","",i);
      row.PAESE_CONTROPARTE_ERR = CPLib.GetProperty(p_PAESE_CONTROPARTE_ERR,"","",i);
      row.PAESE_INTERM_CTRP = CPLib.GetProperty(p_PAESE_INTERM_CTRP,"","",i);
      row.PAESE_INTERM_CTRP_ERR = CPLib.GetProperty(p_PAESE_INTERM_CTRP_ERR,"","",i);
      row.PAESE_RES_CLIENTE = CPLib.GetProperty(p_PAESE_RES_CLIENTE,"","",i);
      row.PAESE_RES_CLIENTE_ERR = CPLib.GetProperty(p_PAESE_RES_CLIENTE_ERR,"","",i);
      row.SEGNO_MONETARIO = CPLib.GetProperty(p_SEGNO_MONETARIO,"","",i);
      row.SEGNO_MONETARIO_ERR = CPLib.GetProperty(p_SEGNO_MONETARIO_ERR,"","",i);
      row.SETTORIZ_SINT_ECON = CPLib.GetProperty(p_SETTORIZ_SINT_ECON,"","",i);
      row.SETTORIZ_SINT_ECON_ERR = CPLib.GetProperty(p_SETTORIZ_SINT_ECON_ERR,"","",i);
      row.TIPO_SEGNALANTE = CPLib.GetProperty(p_TIPO_SEGNALANTE,"","",i);
      row.TIPO_SEGNALANTE_ERR = CPLib.GetProperty(p_TIPO_SEGNALANTE_ERR,"","",i);
      row.IMPORTO_TOT = CPLib.GetProperty(p_IMPORTO_TOT,"",0,i);
      row.IMPORTO_TOT_ERR = CPLib.GetProperty(p_IMPORTO_TOT_ERR,"","",i);
      row.IMPORTO_TOT_CONTANTI = CPLib.GetProperty(p_IMPORTO_TOT_CONTANTI,"",0,i);
      row.IMPORTO_TOT_CONTANTI_ERR = CPLib.GetProperty(p_IMPORTO_TOT_CONTANTI_ERR,"","",i);
      row.NUMERO_OPER_CONT = CPLib.GetProperty(p_NUMERO_OPER_CONT,"",0,i);
      row.NUMERO_OPER_CONT_ERR = CPLib.GetProperty(p_NUMERO_OPER_CONT_ERR,"","",i);
      row.NUMERO_TOT_OPER = CPLib.GetProperty(p_NUMERO_TOT_OPER,"",0,i);
      row.NUMERO_TOT_OPER_ERR = CPLib.GetProperty(p_NUMERO_TOT_OPER_ERR,"","",i);
      row.ABICAB_SPORTELLO = CPLib.GetProperty(p_ABICAB_SPORTELLO,"","",i);
      row.ABICAB_SPORTELLO_ERR = CPLib.GetProperty(p_ABICAB_SPORTELLO_ERR,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcrilievisara_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcrilievisara_mcrdef();
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
  public MemoryCursorRow_mcrilievisara_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcrilievisara_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcrilievisara_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    MemoryCursorRow_mcrilievisara_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcrilievisara_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcrilievisara_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcrilievisara_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
