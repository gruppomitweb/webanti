// Definition generated from table cgo_vltplat
public class MemoryCursor_cgo_vltplat extends CPMemoryCursor {
  MemoryCursorRow_cgo_vltplat row;
  MemoryCursorRow_cgo_vltplat empty_row;
  public MemoryCursor_cgo_vltplat() {
    empty_row = new MemoryCursorRow_cgo_vltplat();
    row = empty_row;
  }
  public MemoryCursor_cgo_vltplat(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_VPCODICE;
    p_VPCODICE = new java.util.Properties();
    java.util.Properties p_VPDESCRI;
    p_VPDESCRI = new java.util.Properties();
    java.util.Properties p_VPFLGATT;
    p_VPFLGATT = new java.util.Properties();
    java.util.Properties p_VPIDAAMS;
    p_VPIDAAMS = new java.util.Properties();
    java.util.Properties p_VPCODPIAT;
    p_VPCODPIAT = new java.util.Properties();
    java.util.Properties p_VPSIGLAPIAT;
    p_VPSIGLAPIAT = new java.util.Properties();
    java.util.Properties p_VPPROVENIENZA;
    p_VPPROVENIENZA = new java.util.Properties();
    java.util.Properties p_VPVLTCODPLAT;
    p_VPVLTCODPLAT = new java.util.Properties();
    java.util.Properties p_VPFLGCRYPTO;
    p_VPFLGCRYPTO = new java.util.Properties();
    java.util.Properties p_VFPKAYCRYPTO;
    p_VFPKAYCRYPTO = new java.util.Properties();
    java.util.Properties p_VPDIRFILE;
    p_VPDIRFILE = new java.util.Properties();
    java.util.Properties p_VPFILEINTESTA1;
    p_VPFILEINTESTA1 = new java.util.Properties();
    java.util.Properties p_VPFFILESPERATOR1;
    p_VPFFILESPERATOR1 = new java.util.Properties();
    java.util.Properties p_VPFILEFORDATA1;
    p_VPFILEFORDATA1 = new java.util.Properties();
    java.util.Properties p_VPPREFFILE1;
    p_VPPREFFILE1 = new java.util.Properties();
    java.util.Properties p_VPFILEINTESTA2;
    p_VPFILEINTESTA2 = new java.util.Properties();
    java.util.Properties p_VPFFILESPERATOR2;
    p_VPFFILESPERATOR2 = new java.util.Properties();
    java.util.Properties p_VPFILEFORDATA2;
    p_VPFILEFORDATA2 = new java.util.Properties();
    java.util.Properties p_VPPREFFILE2;
    p_VPPREFFILE2 = new java.util.Properties();
    java.util.Properties p_VPFILEINTESTA3;
    p_VPFILEINTESTA3 = new java.util.Properties();
    java.util.Properties p_VPFFILESPERATOR3;
    p_VPFFILESPERATOR3 = new java.util.Properties();
    java.util.Properties p_VPFILEFORDATA3;
    p_VPFILEFORDATA3 = new java.util.Properties();
    java.util.Properties p_VPPREFFILE3;
    p_VPPREFFILE3 = new java.util.Properties();
    java.util.Properties p_VPFLGPRESUF1;
    p_VPFLGPRESUF1 = new java.util.Properties();
    java.util.Properties p_VPFLGPRESUF2;
    p_VPFLGPRESUF2 = new java.util.Properties();
    java.util.Properties p_VPFLGPRESUF3;
    p_VPFLGPRESUF3 = new java.util.Properties();
    java.util.Properties p_VPFLGCONVERSION;
    p_VPFLGCONVERSION = new java.util.Properties();
    java.util.Properties p_VFPFLAGIMPORT;
    p_VFPFLAGIMPORT = new java.util.Properties();
    java.util.Properties p_VFPTIPOFILE1;
    p_VFPTIPOFILE1 = new java.util.Properties();
    java.util.Properties p_VFPTIPOFILE2;
    p_VFPTIPOFILE2 = new java.util.Properties();
    java.util.Properties p_VFPTIPOFILE3;
    p_VFPTIPOFILE3 = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPCODICE".equalsIgnoreCase(key)) {
        p_VPCODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPDESCRI".equalsIgnoreCase(key)) {
        p_VPDESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGATT".equalsIgnoreCase(key)) {
        p_VPFLGATT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPIDAAMS".equalsIgnoreCase(key)) {
        p_VPIDAAMS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPCODPIAT".equalsIgnoreCase(key)) {
        p_VPCODPIAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPSIGLAPIAT".equalsIgnoreCase(key)) {
        p_VPSIGLAPIAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPPROVENIENZA".equalsIgnoreCase(key)) {
        p_VPPROVENIENZA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPVLTCODPLAT".equalsIgnoreCase(key)) {
        p_VPVLTCODPLAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGCRYPTO".equalsIgnoreCase(key)) {
        p_VPFLGCRYPTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VFPKAYCRYPTO".equalsIgnoreCase(key)) {
        p_VFPKAYCRYPTO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPDIRFILE".equalsIgnoreCase(key)) {
        p_VPDIRFILE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEINTESTA1".equalsIgnoreCase(key)) {
        p_VPFILEINTESTA1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFFILESPERATOR1".equalsIgnoreCase(key)) {
        p_VPFFILESPERATOR1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEFORDATA1".equalsIgnoreCase(key)) {
        p_VPFILEFORDATA1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPPREFFILE1".equalsIgnoreCase(key)) {
        p_VPPREFFILE1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEINTESTA2".equalsIgnoreCase(key)) {
        p_VPFILEINTESTA2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFFILESPERATOR2".equalsIgnoreCase(key)) {
        p_VPFFILESPERATOR2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEFORDATA2".equalsIgnoreCase(key)) {
        p_VPFILEFORDATA2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPPREFFILE2".equalsIgnoreCase(key)) {
        p_VPPREFFILE2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEINTESTA3".equalsIgnoreCase(key)) {
        p_VPFILEINTESTA3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFFILESPERATOR3".equalsIgnoreCase(key)) {
        p_VPFFILESPERATOR3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFILEFORDATA3".equalsIgnoreCase(key)) {
        p_VPFILEFORDATA3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPPREFFILE3".equalsIgnoreCase(key)) {
        p_VPPREFFILE3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGPRESUF1".equalsIgnoreCase(key)) {
        p_VPFLGPRESUF1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGPRESUF2".equalsIgnoreCase(key)) {
        p_VPFLGPRESUF2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGPRESUF3".equalsIgnoreCase(key)) {
        p_VPFLGPRESUF3 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VPFLGCONVERSION".equalsIgnoreCase(key)) {
        p_VPFLGCONVERSION = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VFPFLAGIMPORT".equalsIgnoreCase(key)) {
        p_VFPFLAGIMPORT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VFPTIPOFILE1".equalsIgnoreCase(key)) {
        p_VFPTIPOFILE1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VFPTIPOFILE2".equalsIgnoreCase(key)) {
        p_VFPTIPOFILE2 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("VFPTIPOFILE3".equalsIgnoreCase(key)) {
        p_VFPTIPOFILE3 = CPLib.GetProperties(p.getProperty(key));
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
      row.VPCODICE = CPLib.GetProperty(p_VPCODICE,"","",i);
      row.VPDESCRI = CPLib.GetProperty(p_VPDESCRI,"","",i);
      row.VPFLGATT = CPLib.GetProperty(p_VPFLGATT,"","",i);
      row.VPIDAAMS = CPLib.GetProperty(p_VPIDAAMS,"","",i);
      row.VPCODPIAT = CPLib.GetProperty(p_VPCODPIAT,"",0,i);
      row.VPSIGLAPIAT = CPLib.GetProperty(p_VPSIGLAPIAT,"","",i);
      row.VPPROVENIENZA = CPLib.GetProperty(p_VPPROVENIENZA,"","",i);
      row.VPVLTCODPLAT = CPLib.GetProperty(p_VPVLTCODPLAT,"",0,i);
      row.VPFLGCRYPTO = CPLib.GetProperty(p_VPFLGCRYPTO,"","",i);
      row.VFPKAYCRYPTO = CPLib.GetProperty(p_VFPKAYCRYPTO,"","",i);
      row.VPDIRFILE = CPLib.GetProperty(p_VPDIRFILE,"","",i);
      row.VPFILEINTESTA1 = CPLib.GetProperty(p_VPFILEINTESTA1,"","",i);
      row.VPFFILESPERATOR1 = CPLib.GetProperty(p_VPFFILESPERATOR1,"","",i);
      row.VPFILEFORDATA1 = CPLib.GetProperty(p_VPFILEFORDATA1,"","",i);
      row.VPPREFFILE1 = CPLib.GetProperty(p_VPPREFFILE1,"","",i);
      row.VPFILEINTESTA2 = CPLib.GetProperty(p_VPFILEINTESTA2,"","",i);
      row.VPFFILESPERATOR2 = CPLib.GetProperty(p_VPFFILESPERATOR2,"","",i);
      row.VPFILEFORDATA2 = CPLib.GetProperty(p_VPFILEFORDATA2,"","",i);
      row.VPPREFFILE2 = CPLib.GetProperty(p_VPPREFFILE2,"","",i);
      row.VPFILEINTESTA3 = CPLib.GetProperty(p_VPFILEINTESTA3,"","",i);
      row.VPFFILESPERATOR3 = CPLib.GetProperty(p_VPFFILESPERATOR3,"","",i);
      row.VPFILEFORDATA3 = CPLib.GetProperty(p_VPFILEFORDATA3,"","",i);
      row.VPPREFFILE3 = CPLib.GetProperty(p_VPPREFFILE3,"","",i);
      row.VPFLGPRESUF1 = CPLib.GetProperty(p_VPFLGPRESUF1,"","",i);
      row.VPFLGPRESUF2 = CPLib.GetProperty(p_VPFLGPRESUF2,"","",i);
      row.VPFLGPRESUF3 = CPLib.GetProperty(p_VPFLGPRESUF3,"","",i);
      row.VPFLGCONVERSION = CPLib.GetProperty(p_VPFLGCONVERSION,"","",i);
      row.VFPFLAGIMPORT = CPLib.GetProperty(p_VFPFLAGIMPORT,"","",i);
      row.VFPTIPOFILE1 = CPLib.GetProperty(p_VFPTIPOFILE1,"","",i);
      row.VFPTIPOFILE2 = CPLib.GetProperty(p_VFPTIPOFILE2,"","",i);
      row.VFPTIPOFILE3 = CPLib.GetProperty(p_VFPTIPOFILE3,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_cgo_vltplat)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_cgo_vltplat();
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
  public MemoryCursorRow_cgo_vltplat _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_cgo_vltplat _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_cgo_vltplat> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_cgo_vltplat p_Row) {
    MemoryCursorRow_cgo_vltplat l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_cgo_vltplat();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_cgo_vltplat p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_cgo_vltplat();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
