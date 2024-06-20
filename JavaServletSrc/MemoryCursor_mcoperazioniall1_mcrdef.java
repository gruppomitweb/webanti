// Definition generated from record definition mcoperazioniall1_mcrdef
public class MemoryCursor_mcoperazioniall1_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcoperazioniall1_mcrdef row;
  MemoryCursorRow_mcoperazioniall1_mcrdef empty_row;
  public MemoryCursor_mcoperazioniall1_mcrdef() {
    empty_row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcoperazioniall1_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_TIPOINTER;
    p_TIPOINTER = new java.util.Properties();
    java.util.Properties p_CODINTER;
    p_CODINTER = new java.util.Properties();
    java.util.Properties p_IDEREG;
    p_IDEREG = new java.util.Properties();
    java.util.Properties p_CODDIPE;
    p_CODDIPE = new java.util.Properties();
    java.util.Properties p_CABFIL;
    p_CABFIL = new java.util.Properties();
    java.util.Properties p_CABCOMU;
    p_CABCOMU = new java.util.Properties();
    java.util.Properties p_DESCCIT;
    p_DESCCIT = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_CODANA;
    p_CODANA = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_TOTCONT;
    p_TOTCONT = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_CODTIPSOGG;
    p_CODTIPSOGG = new java.util.Properties();
    java.util.Properties p_CONNESSOGG;
    p_CONNESSOGG = new java.util.Properties();
    java.util.Properties p_RAGSOGSOGG;
    p_RAGSOGSOGG = new java.util.Properties();
    java.util.Properties p_SESSOSOGG;
    p_SESSOSOGG = new java.util.Properties();
    java.util.Properties p_CODFISCSOGG;
    p_CODFISCSOGG = new java.util.Properties();
    java.util.Properties p_DATANASCSOGG;
    p_DATANASCSOGG = new java.util.Properties();
    java.util.Properties p_NASCOMUNSOGG;
    p_NASCOMUNSOGG = new java.util.Properties();
    java.util.Properties p_COMUNRESSOGG;
    p_COMUNRESSOGG = new java.util.Properties();
    java.util.Properties p_CABRESISOGG;
    p_CABRESISOGG = new java.util.Properties();
    java.util.Properties p_PAESESOGG;
    p_PAESESOGG = new java.util.Properties();
    java.util.Properties p_SAESOGG;
    p_SAESOGG = new java.util.Properties();
    java.util.Properties p_ATECOSOGG;
    p_ATECOSOGG = new java.util.Properties();
    java.util.Properties p_CONNESESE;
    p_CONNESESE = new java.util.Properties();
    java.util.Properties p_RAGSOGESE;
    p_RAGSOGESE = new java.util.Properties();
    java.util.Properties p_CODFISCESE;
    p_CODFISCESE = new java.util.Properties();
    java.util.Properties p_DATANASCESE;
    p_DATANASCESE = new java.util.Properties();
    java.util.Properties p_NASCCOMUNESE;
    p_NASCCOMUNESE = new java.util.Properties();
    java.util.Properties p_C_RAG;
    p_C_RAG = new java.util.Properties();
    java.util.Properties p_C_STA;
    p_C_STA = new java.util.Properties();
    java.util.Properties p_C_CAB;
    p_C_CAB = new java.util.Properties();
    java.util.Properties p_C_CTA;
    p_C_CTA = new java.util.Properties();
    java.util.Properties p_CODINT2;
    p_CODINT2 = new java.util.Properties();
    java.util.Properties p_DESCINTER;
    p_DESCINTER = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_CODCAB2;
    p_CODCAB2 = new java.util.Properties();
    java.util.Properties p_C_RAPPORTO;
    p_C_RAPPORTO = new java.util.Properties();
    java.util.Properties p_FILLER;
    p_FILLER = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TIPOINTER".equalsIgnoreCase(key)) {
        p_TIPOINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINTER".equalsIgnoreCase(key)) {
        p_CODINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDEREG".equalsIgnoreCase(key)) {
        p_IDEREG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODDIPE".equalsIgnoreCase(key)) {
        p_CODDIPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABFIL".equalsIgnoreCase(key)) {
        p_CABFIL = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABCOMU".equalsIgnoreCase(key)) {
        p_CABCOMU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCCIT".equalsIgnoreCase(key)) {
        p_DESCCIT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODANA".equalsIgnoreCase(key)) {
        p_CODANA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTCONT".equalsIgnoreCase(key)) {
        p_TOTCONT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODTIPSOGG".equalsIgnoreCase(key)) {
        p_CODTIPSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESSOGG".equalsIgnoreCase(key)) {
        p_CONNESSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOGSOGG".equalsIgnoreCase(key)) {
        p_RAGSOGSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SESSOSOGG".equalsIgnoreCase(key)) {
        p_SESSOSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISCSOGG".equalsIgnoreCase(key)) {
        p_CODFISCSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASCSOGG".equalsIgnoreCase(key)) {
        p_DATANASCSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCOMUNSOGG".equalsIgnoreCase(key)) {
        p_NASCOMUNSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("COMUNRESSOGG".equalsIgnoreCase(key)) {
        p_COMUNRESSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABRESISOGG".equalsIgnoreCase(key)) {
        p_CABRESISOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESESOGG".equalsIgnoreCase(key)) {
        p_PAESESOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SAESOGG".equalsIgnoreCase(key)) {
        p_SAESOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECOSOGG".equalsIgnoreCase(key)) {
        p_ATECOSOGG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CONNESESE".equalsIgnoreCase(key)) {
        p_CONNESESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAGSOGESE".equalsIgnoreCase(key)) {
        p_RAGSOGESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODFISCESE".equalsIgnoreCase(key)) {
        p_CODFISCESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATANASCESE".equalsIgnoreCase(key)) {
        p_DATANASCESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NASCCOMUNESE".equalsIgnoreCase(key)) {
        p_NASCCOMUNESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_RAG".equalsIgnoreCase(key)) {
        p_C_RAG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_STA".equalsIgnoreCase(key)) {
        p_C_STA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_CAB".equalsIgnoreCase(key)) {
        p_C_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_CTA".equalsIgnoreCase(key)) {
        p_C_CTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODINT2".equalsIgnoreCase(key)) {
        p_CODINT2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DESCINTER".equalsIgnoreCase(key)) {
        p_DESCINTER = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CODCAB2".equalsIgnoreCase(key)) {
        p_CODCAB2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("C_RAPPORTO".equalsIgnoreCase(key)) {
        p_C_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILLER".equalsIgnoreCase(key)) {
        p_FILLER = CPLib.GetProperties(p.getProperty(key));
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
      row.TIPOINTER = CPLib.GetProperty(p_TIPOINTER,"","",i);
      row.CODINTER = CPLib.GetProperty(p_CODINTER,"","",i);
      row.IDEREG = CPLib.GetProperty(p_IDEREG,"","",i);
      row.CODDIPE = CPLib.GetProperty(p_CODDIPE,"","",i);
      row.CABFIL = CPLib.GetProperty(p_CABFIL,"","",i);
      row.CABCOMU = CPLib.GetProperty(p_CABCOMU,"","",i);
      row.DESCCIT = CPLib.GetProperty(p_DESCCIT,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.CODANA = CPLib.GetProperty(p_CODANA,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.TOTCONT = CPLib.GetProperty(p_TOTCONT,"",0,i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.CODTIPSOGG = CPLib.GetProperty(p_CODTIPSOGG,"","",i);
      row.CONNESSOGG = CPLib.GetProperty(p_CONNESSOGG,"","",i);
      row.RAGSOGSOGG = CPLib.GetProperty(p_RAGSOGSOGG,"","",i);
      row.SESSOSOGG = CPLib.GetProperty(p_SESSOSOGG,"","",i);
      row.CODFISCSOGG = CPLib.GetProperty(p_CODFISCSOGG,"","",i);
      row.DATANASCSOGG = CPLib.GetProperty(p_DATANASCSOGG,"",CPLib.NullDate(),i);
      row.NASCOMUNSOGG = CPLib.GetProperty(p_NASCOMUNSOGG,"","",i);
      row.COMUNRESSOGG = CPLib.GetProperty(p_COMUNRESSOGG,"","",i);
      row.CABRESISOGG = CPLib.GetProperty(p_CABRESISOGG,"","",i);
      row.PAESESOGG = CPLib.GetProperty(p_PAESESOGG,"","",i);
      row.SAESOGG = CPLib.GetProperty(p_SAESOGG,"","",i);
      row.ATECOSOGG = CPLib.GetProperty(p_ATECOSOGG,"","",i);
      row.CONNESESE = CPLib.GetProperty(p_CONNESESE,"","",i);
      row.RAGSOGESE = CPLib.GetProperty(p_RAGSOGESE,"","",i);
      row.CODFISCESE = CPLib.GetProperty(p_CODFISCESE,"","",i);
      row.DATANASCESE = CPLib.GetProperty(p_DATANASCESE,"",CPLib.NullDate(),i);
      row.NASCCOMUNESE = CPLib.GetProperty(p_NASCCOMUNESE,"","",i);
      row.C_RAG = CPLib.GetProperty(p_C_RAG,"","",i);
      row.C_STA = CPLib.GetProperty(p_C_STA,"","",i);
      row.C_CAB = CPLib.GetProperty(p_C_CAB,"","",i);
      row.C_CTA = CPLib.GetProperty(p_C_CTA,"","",i);
      row.CODINT2 = CPLib.GetProperty(p_CODINT2,"","",i);
      row.DESCINTER = CPLib.GetProperty(p_DESCINTER,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.CODCAB2 = CPLib.GetProperty(p_CODCAB2,"","",i);
      row.C_RAPPORTO = CPLib.GetProperty(p_C_RAPPORTO,"","",i);
      row.FILLER = CPLib.GetProperty(p_FILLER,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcoperazioniall1_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcoperazioniall1_mcrdef();
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
  public MemoryCursorRow_mcoperazioniall1_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcoperazioniall1_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcoperazioniall1_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    MemoryCursorRow_mcoperazioniall1_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcoperazioniall1_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcoperazioniall1_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
