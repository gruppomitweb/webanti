// Definition generated from record definition mcparametri_mcrdef
public class MemoryCursor_mcparametri_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcparametri_mcrdef row;
  MemoryCursorRow_mcparametri_mcrdef empty_row;
  public MemoryCursor_mcparametri_mcrdef() {
    empty_row = new MemoryCursorRow_mcparametri_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcparametri_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_pTipo;
    p_pTipo = new java.util.Properties();
    java.util.Properties p_w_dadata;
    p_w_dadata = new java.util.Properties();
    java.util.Properties p_w_adata;
    p_w_adata = new java.util.Properties();
    java.util.Properties p_w_cdadata;
    p_w_cdadata = new java.util.Properties();
    java.util.Properties p_w_c_adata;
    p_w_c_adata = new java.util.Properties();
    java.util.Properties p_w_cDIP;
    p_w_cDIP = new java.util.Properties();
    java.util.Properties p_w_xdesdip;
    p_w_xdesdip = new java.util.Properties();
    java.util.Properties p_w_ragosc;
    p_w_ragosc = new java.util.Properties();
    java.util.Properties p_w_citnas;
    p_w_citnas = new java.util.Properties();
    java.util.Properties p_w_stanas;
    p_w_stanas = new java.util.Properties();
    java.util.Properties p_w_datnas;
    p_w_datnas = new java.util.Properties();
    java.util.Properties p_w_cMTCN;
    p_w_cMTCN = new java.util.Properties();
    java.util.Properties p_w_cCODFISC;
    p_w_cCODFISC = new java.util.Properties();
    java.util.Properties p_w_ragben;
    p_w_ragben = new java.util.Properties();
    java.util.Properties p_w_staben;
    p_w_staben = new java.util.Properties();
    java.util.Properties p_w_codmag;
    p_w_codmag = new java.util.Properties();
    java.util.Properties p_w_connes;
    p_w_connes = new java.util.Properties();
    java.util.Properties p_w_nomefile;
    p_w_nomefile = new java.util.Properties();
    java.util.Properties p_w_tipofile;
    p_w_tipofile = new java.util.Properties();
    java.util.Properties p_w_flgsto;
    p_w_flgsto = new java.util.Properties();
    java.util.Properties p_w_tipoout;
    p_w_tipoout = new java.util.Properties();
    java.util.Properties p_w_opesel;
    p_w_opesel = new java.util.Properties();
    java.util.Properties p_w_frzsel;
    p_w_frzsel = new java.util.Properties();
    java.util.Properties p_w_attive;
    p_w_attive = new java.util.Properties();
    java.util.Properties p_w_destfold;
    p_w_destfold = new java.util.Properties();
    java.util.Properties p_w_flgmese;
    p_w_flgmese = new java.util.Properties();
    java.util.Properties p_w_flgncf;
    p_w_flgncf = new java.util.Properties();
    java.util.Properties p_w_flgsegno;
    p_w_flgsegno = new java.util.Properties();
    java.util.Properties p_w_lststa;
    p_w_lststa = new java.util.Properties();
    java.util.Properties p_w_lstprv;
    p_w_lstprv = new java.util.Properties();
    java.util.Properties p_w_importo;
    p_w_importo = new java.util.Properties();
    java.util.Properties p_w_storico;
    p_w_storico = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("pTipo".equalsIgnoreCase(key)) {
        p_pTipo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_dadata".equalsIgnoreCase(key)) {
        p_w_dadata = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_adata".equalsIgnoreCase(key)) {
        p_w_adata = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_cdadata".equalsIgnoreCase(key)) {
        p_w_cdadata = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_c_adata".equalsIgnoreCase(key)) {
        p_w_c_adata = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_cDIP".equalsIgnoreCase(key)) {
        p_w_cDIP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_xdesdip".equalsIgnoreCase(key)) {
        p_w_xdesdip = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_ragosc".equalsIgnoreCase(key)) {
        p_w_ragosc = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_citnas".equalsIgnoreCase(key)) {
        p_w_citnas = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_stanas".equalsIgnoreCase(key)) {
        p_w_stanas = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_datnas".equalsIgnoreCase(key)) {
        p_w_datnas = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_cMTCN".equalsIgnoreCase(key)) {
        p_w_cMTCN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_cCODFISC".equalsIgnoreCase(key)) {
        p_w_cCODFISC = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_ragben".equalsIgnoreCase(key)) {
        p_w_ragben = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_staben".equalsIgnoreCase(key)) {
        p_w_staben = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_codmag".equalsIgnoreCase(key)) {
        p_w_codmag = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_connes".equalsIgnoreCase(key)) {
        p_w_connes = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_nomefile".equalsIgnoreCase(key)) {
        p_w_nomefile = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_tipofile".equalsIgnoreCase(key)) {
        p_w_tipofile = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_flgsto".equalsIgnoreCase(key)) {
        p_w_flgsto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_tipoout".equalsIgnoreCase(key)) {
        p_w_tipoout = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_opesel".equalsIgnoreCase(key)) {
        p_w_opesel = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_frzsel".equalsIgnoreCase(key)) {
        p_w_frzsel = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_attive".equalsIgnoreCase(key)) {
        p_w_attive = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_destfold".equalsIgnoreCase(key)) {
        p_w_destfold = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_flgmese".equalsIgnoreCase(key)) {
        p_w_flgmese = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_flgncf".equalsIgnoreCase(key)) {
        p_w_flgncf = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_flgsegno".equalsIgnoreCase(key)) {
        p_w_flgsegno = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_lststa".equalsIgnoreCase(key)) {
        p_w_lststa = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_lstprv".equalsIgnoreCase(key)) {
        p_w_lstprv = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_importo".equalsIgnoreCase(key)) {
        p_w_importo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("w_storico".equalsIgnoreCase(key)) {
        p_w_storico = CPLib.GetProperties(p.getProperty(key));
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
      row.pTipo = CPLib.GetProperty(p_pTipo,"","",i);
      row.w_dadata = CPLib.GetProperty(p_w_dadata,"",CPLib.NullDate(),i);
      row.w_adata = CPLib.GetProperty(p_w_adata,"",CPLib.NullDate(),i);
      row.w_cdadata = CPLib.GetProperty(p_w_cdadata,"","",i);
      row.w_c_adata = CPLib.GetProperty(p_w_c_adata,"","",i);
      row.w_cDIP = CPLib.GetProperty(p_w_cDIP,"","",i);
      row.w_xdesdip = CPLib.GetProperty(p_w_xdesdip,"","",i);
      row.w_ragosc = CPLib.GetProperty(p_w_ragosc,"","",i);
      row.w_citnas = CPLib.GetProperty(p_w_citnas,"","",i);
      row.w_stanas = CPLib.GetProperty(p_w_stanas,"","",i);
      row.w_datnas = CPLib.GetProperty(p_w_datnas,"",CPLib.NullDate(),i);
      row.w_cMTCN = CPLib.GetProperty(p_w_cMTCN,"","",i);
      row.w_cCODFISC = CPLib.GetProperty(p_w_cCODFISC,"","",i);
      row.w_ragben = CPLib.GetProperty(p_w_ragben,"","",i);
      row.w_staben = CPLib.GetProperty(p_w_staben,"","",i);
      row.w_codmag = CPLib.GetProperty(p_w_codmag,"","",i);
      row.w_connes = CPLib.GetProperty(p_w_connes,"","",i);
      row.w_nomefile = CPLib.GetProperty(p_w_nomefile,"","",i);
      row.w_tipofile = CPLib.GetProperty(p_w_tipofile,"","",i);
      row.w_flgsto = CPLib.GetProperty(p_w_flgsto,"","",i);
      row.w_tipoout = CPLib.GetProperty(p_w_tipoout,"","",i);
      row.w_opesel = CPLib.GetProperty(p_w_opesel,"","",i);
      row.w_frzsel = CPLib.GetProperty(p_w_frzsel,"","",i);
      row.w_attive = CPLib.GetProperty(p_w_attive,"","",i);
      row.w_destfold = CPLib.GetProperty(p_w_destfold,"","",i);
      row.w_flgmese = CPLib.GetProperty(p_w_flgmese,"","",i);
      row.w_flgncf = CPLib.GetProperty(p_w_flgncf,"","",i);
      row.w_flgsegno = CPLib.GetProperty(p_w_flgsegno,"","",i);
      row.w_lststa = CPLib.GetProperty(p_w_lststa,"","",i);
      row.w_lstprv = CPLib.GetProperty(p_w_lstprv,"","",i);
      row.w_importo = CPLib.GetProperty(p_w_importo,"",0,i);
      row.w_storico = CPLib.GetProperty(p_w_storico,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcparametri_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcparametri_mcrdef();
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
  public MemoryCursorRow_mcparametri_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcparametri_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcparametri_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcparametri_mcrdef p_Row) {
    MemoryCursorRow_mcparametri_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcparametri_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcparametri_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcparametri_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
