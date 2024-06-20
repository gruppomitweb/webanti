// Definition generated from query qbe_estrai_sv_all_ip_2_a_vqr
public class MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr extends CPMemoryCursor {
  MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr row;
  MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr empty_row;
  public MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr() {
    empty_row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
    row = empty_row;
  }
  public MemoryCursor_qbe_estrai_sv_all_ip_2_a_vqr(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_IDBASE;
    p_IDBASE = new java.util.Properties();
    java.util.Properties p_RAPPORTO;
    p_RAPPORTO = new java.util.Properties();
    java.util.Properties p_TOTLIRE;
    p_TOTLIRE = new java.util.Properties();
    java.util.Properties p_DATAOPE;
    p_DATAOPE = new java.util.Properties();
    java.util.Properties p_SV58550;
    p_SV58550 = new java.util.Properties();
    java.util.Properties p_PAESE;
    p_PAESE = new java.util.Properties();
    java.util.Properties p_PROVINCIA;
    p_PROVINCIA = new java.util.Properties();
    java.util.Properties p_SV58550MA;
    p_SV58550MA = new java.util.Properties();
    java.util.Properties p_VALUTA;
    p_VALUTA = new java.util.Properties();
    java.util.Properties p_FONTE;
    p_FONTE = new java.util.Properties();
    java.util.Properties p_NUMPROG;
    p_NUMPROG = new java.util.Properties();
    java.util.Properties p_SEGNO;
    p_SEGNO = new java.util.Properties();
    java.util.Properties p_SV58724;
    p_SV58724 = new java.util.Properties();
    java.util.Properties p_SV58726SCA;
    p_SV58726SCA = new java.util.Properties();
    java.util.Properties p_SV58726SA;
    p_SV58726SA = new java.util.Properties();
    java.util.Properties p_SV58726PISP;
    p_SV58726PISP = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("IDBASE".equalsIgnoreCase(key)) {
        p_IDBASE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAPPORTO".equalsIgnoreCase(key)) {
        p_RAPPORTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TOTLIRE".equalsIgnoreCase(key)) {
        p_TOTLIRE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DATAOPE".equalsIgnoreCase(key)) {
        p_DATAOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58550".equalsIgnoreCase(key)) {
        p_SV58550 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PAESE".equalsIgnoreCase(key)) {
        p_PAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PROVINCIA".equalsIgnoreCase(key)) {
        p_PROVINCIA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58550MA".equalsIgnoreCase(key)) {
        p_SV58550MA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VALUTA".equalsIgnoreCase(key)) {
        p_VALUTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FONTE".equalsIgnoreCase(key)) {
        p_FONTE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NUMPROG".equalsIgnoreCase(key)) {
        p_NUMPROG = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SEGNO".equalsIgnoreCase(key)) {
        p_SEGNO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58724".equalsIgnoreCase(key)) {
        p_SV58724 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58726SCA".equalsIgnoreCase(key)) {
        p_SV58726SCA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58726SA".equalsIgnoreCase(key)) {
        p_SV58726SA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SV58726PISP".equalsIgnoreCase(key)) {
        p_SV58726PISP = CPLib.GetProperties(p.getProperty(key));
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
      row.IDBASE = CPLib.GetProperty(p_IDBASE,"","",i);
      row.RAPPORTO = CPLib.GetProperty(p_RAPPORTO,"","",i);
      row.TOTLIRE = CPLib.GetProperty(p_TOTLIRE,"",0,i);
      row.DATAOPE = CPLib.GetProperty(p_DATAOPE,"",CPLib.NullDate(),i);
      row.SV58550 = CPLib.GetProperty(p_SV58550,"","",i);
      row.PAESE = CPLib.GetProperty(p_PAESE,"","",i);
      row.PROVINCIA = CPLib.GetProperty(p_PROVINCIA,"","",i);
      row.SV58550MA = CPLib.GetProperty(p_SV58550MA,"","",i);
      row.VALUTA = CPLib.GetProperty(p_VALUTA,"","",i);
      row.FONTE = CPLib.GetProperty(p_FONTE,"","",i);
      row.NUMPROG = CPLib.GetProperty(p_NUMPROG,"","",i);
      row.SEGNO = CPLib.GetProperty(p_SEGNO,"","",i);
      row.SV58724 = CPLib.GetProperty(p_SV58724,"","",i);
      row.SV58726SCA = CPLib.GetProperty(p_SV58726SCA,"","",i);
      row.SV58726SA = CPLib.GetProperty(p_SV58726SA,"","",i);
      row.SV58726PISP = CPLib.GetProperty(p_SV58726PISP,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
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
  public MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_qbe_estrai_sv_all_ip_2_a_vqr();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
