// Definition generated from table tbmacage
public class MemoryCursor_tbmacage extends CPMemoryCursor {
  MemoryCursorRow_tbmacage row;
  MemoryCursorRow_tbmacage empty_row;
  public MemoryCursor_tbmacage() {
    empty_row = new MemoryCursorRow_tbmacage();
    row = empty_row;
  }
  public MemoryCursor_tbmacage(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_MACODICE;
    p_MACODICE = new java.util.Properties();
    java.util.Properties p_MADESCRI;
    p_MADESCRI = new java.util.Properties();
    java.util.Properties p_MAFLGRAP;
    p_MAFLGRAP = new java.util.Properties();
    java.util.Properties p_MAFLGOPE;
    p_MAFLGOPE = new java.util.Properties();
    java.util.Properties p_MAFLGBON;
    p_MAFLGBON = new java.util.Properties();
    java.util.Properties p_MAFLGCKR;
    p_MAFLGCKR = new java.util.Properties();
    java.util.Properties p_MAFLGASR;
    p_MAFLGASR = new java.util.Properties();
    java.util.Properties p_MAFLGNOX;
    p_MAFLGNOX = new java.util.Properties();
    java.util.Properties p_MADIPSTD;
    p_MADIPSTD = new java.util.Properties();
    java.util.Properties p_MANAIDWU;
    p_MANAIDWU = new java.util.Properties();
    java.util.Properties p_MAFLGCHKDAT;
    p_MAFLGCHKDAT = new java.util.Properties();
    java.util.Properties p_MAFLGACT;
    p_MAFLGACT = new java.util.Properties();
    java.util.Properties p_MARESSDEF;
    p_MARESSDEF = new java.util.Properties();
    java.util.Properties p_MAFLGAUA;
    p_MAFLGAUA = new java.util.Properties();
    java.util.Properties p_MADATINI;
    p_MADATINI = new java.util.Properties();
    java.util.Properties p_MADATFIN;
    p_MADATFIN = new java.util.Properties();
    java.util.Properties p_MAFISGIU;
    p_MAFISGIU = new java.util.Properties();
    java.util.Properties p_MADATMOD;
    p_MADATMOD = new java.util.Properties();
    java.util.Properties p_MATIPAGE;
    p_MATIPAGE = new java.util.Properties();
    java.util.Properties p_MACODFIS;
    p_MACODFIS = new java.util.Properties();
    java.util.Properties p_MACOGNOME;
    p_MACOGNOME = new java.util.Properties();
    java.util.Properties p_MANOME;
    p_MANOME = new java.util.Properties();
    java.util.Properties p_MARESPAESE;
    p_MARESPAESE = new java.util.Properties();
    java.util.Properties p_MARESIND;
    p_MARESIND = new java.util.Properties();
    java.util.Properties p_MARESNCIV;
    p_MARESNCIV = new java.util.Properties();
    java.util.Properties p_MARESCITTA;
    p_MARESCITTA = new java.util.Properties();
    java.util.Properties p_MARESPRV;
    p_MARESPRV = new java.util.Properties();
    java.util.Properties p_MARESCAP;
    p_MARESCAP = new java.util.Properties();
    java.util.Properties p_MADOMPAESE;
    p_MADOMPAESE = new java.util.Properties();
    java.util.Properties p_MADOMIND;
    p_MADOMIND = new java.util.Properties();
    java.util.Properties p_MADOMNCIV;
    p_MADOMNCIV = new java.util.Properties();
    java.util.Properties p_MADOMCITTA;
    p_MADOMCITTA = new java.util.Properties();
    java.util.Properties p_MADOMPRV;
    p_MADOMPRV = new java.util.Properties();
    java.util.Properties p_MADOMCAP;
    p_MADOMCAP = new java.util.Properties();
    java.util.Properties p_MAFLGCOMPL;
    p_MAFLGCOMPL = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACODICE".equalsIgnoreCase(key)) {
        p_MACODICE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADESCRI".equalsIgnoreCase(key)) {
        p_MADESCRI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGRAP".equalsIgnoreCase(key)) {
        p_MAFLGRAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGOPE".equalsIgnoreCase(key)) {
        p_MAFLGOPE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGBON".equalsIgnoreCase(key)) {
        p_MAFLGBON = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGCKR".equalsIgnoreCase(key)) {
        p_MAFLGCKR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGASR".equalsIgnoreCase(key)) {
        p_MAFLGASR = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGNOX".equalsIgnoreCase(key)) {
        p_MAFLGNOX = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADIPSTD".equalsIgnoreCase(key)) {
        p_MADIPSTD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MANAIDWU".equalsIgnoreCase(key)) {
        p_MANAIDWU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGCHKDAT".equalsIgnoreCase(key)) {
        p_MAFLGCHKDAT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGACT".equalsIgnoreCase(key)) {
        p_MAFLGACT = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESSDEF".equalsIgnoreCase(key)) {
        p_MARESSDEF = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGAUA".equalsIgnoreCase(key)) {
        p_MAFLGAUA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADATINI".equalsIgnoreCase(key)) {
        p_MADATINI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADATFIN".equalsIgnoreCase(key)) {
        p_MADATFIN = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFISGIU".equalsIgnoreCase(key)) {
        p_MAFISGIU = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADATMOD".equalsIgnoreCase(key)) {
        p_MADATMOD = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MATIPAGE".equalsIgnoreCase(key)) {
        p_MATIPAGE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACODFIS".equalsIgnoreCase(key)) {
        p_MACODFIS = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MACOGNOME".equalsIgnoreCase(key)) {
        p_MACOGNOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MANOME".equalsIgnoreCase(key)) {
        p_MANOME = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESPAESE".equalsIgnoreCase(key)) {
        p_MARESPAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESIND".equalsIgnoreCase(key)) {
        p_MARESIND = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESNCIV".equalsIgnoreCase(key)) {
        p_MARESNCIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESCITTA".equalsIgnoreCase(key)) {
        p_MARESCITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESPRV".equalsIgnoreCase(key)) {
        p_MARESPRV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MARESCAP".equalsIgnoreCase(key)) {
        p_MARESCAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMPAESE".equalsIgnoreCase(key)) {
        p_MADOMPAESE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMIND".equalsIgnoreCase(key)) {
        p_MADOMIND = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMNCIV".equalsIgnoreCase(key)) {
        p_MADOMNCIV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMCITTA".equalsIgnoreCase(key)) {
        p_MADOMCITTA = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMPRV".equalsIgnoreCase(key)) {
        p_MADOMPRV = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MADOMCAP".equalsIgnoreCase(key)) {
        p_MADOMCAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("MAFLGCOMPL".equalsIgnoreCase(key)) {
        p_MAFLGCOMPL = CPLib.GetProperties(p.getProperty(key));
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
      row.MACODICE = CPLib.GetProperty(p_MACODICE,"","",i);
      row.MADESCRI = CPLib.GetProperty(p_MADESCRI,"","",i);
      row.MAFLGRAP = CPLib.GetProperty(p_MAFLGRAP,"","",i);
      row.MAFLGOPE = CPLib.GetProperty(p_MAFLGOPE,"","",i);
      row.MAFLGBON = CPLib.GetProperty(p_MAFLGBON,"","",i);
      row.MAFLGCKR = CPLib.GetProperty(p_MAFLGCKR,"","",i);
      row.MAFLGASR = CPLib.GetProperty(p_MAFLGASR,"","",i);
      row.MAFLGNOX = CPLib.GetProperty(p_MAFLGNOX,"","",i);
      row.MADIPSTD = CPLib.GetProperty(p_MADIPSTD,"","",i);
      row.MANAIDWU = CPLib.GetProperty(p_MANAIDWU,"","",i);
      row.MAFLGCHKDAT = CPLib.GetProperty(p_MAFLGCHKDAT,"","",i);
      row.MAFLGACT = CPLib.GetProperty(p_MAFLGACT,"","",i);
      row.MARESSDEF = CPLib.GetProperty(p_MARESSDEF,"","",i);
      row.MAFLGAUA = CPLib.GetProperty(p_MAFLGAUA,"","",i);
      row.MADATINI = CPLib.GetProperty(p_MADATINI,"",CPLib.NullDate(),i);
      row.MADATFIN = CPLib.GetProperty(p_MADATFIN,"",CPLib.NullDate(),i);
      row.MAFISGIU = CPLib.GetProperty(p_MAFISGIU,"","",i);
      row.MADATMOD = CPLib.GetProperty(p_MADATMOD,"",CPLib.NullDate(),i);
      row.MATIPAGE = CPLib.GetProperty(p_MATIPAGE,"","",i);
      row.MACODFIS = CPLib.GetProperty(p_MACODFIS,"","",i);
      row.MACOGNOME = CPLib.GetProperty(p_MACOGNOME,"","",i);
      row.MANOME = CPLib.GetProperty(p_MANOME,"","",i);
      row.MARESPAESE = CPLib.GetProperty(p_MARESPAESE,"","",i);
      row.MARESIND = CPLib.GetProperty(p_MARESIND,"","",i);
      row.MARESNCIV = CPLib.GetProperty(p_MARESNCIV,"","",i);
      row.MARESCITTA = CPLib.GetProperty(p_MARESCITTA,"","",i);
      row.MARESPRV = CPLib.GetProperty(p_MARESPRV,"","",i);
      row.MARESCAP = CPLib.GetProperty(p_MARESCAP,"","",i);
      row.MADOMPAESE = CPLib.GetProperty(p_MADOMPAESE,"","",i);
      row.MADOMIND = CPLib.GetProperty(p_MADOMIND,"","",i);
      row.MADOMNCIV = CPLib.GetProperty(p_MADOMNCIV,"","",i);
      row.MADOMCITTA = CPLib.GetProperty(p_MADOMCITTA,"","",i);
      row.MADOMPRV = CPLib.GetProperty(p_MADOMPRV,"","",i);
      row.MADOMCAP = CPLib.GetProperty(p_MADOMCAP,"","",i);
      row.MAFLGCOMPL = CPLib.GetProperty(p_MAFLGCOMPL,"",0,i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_tbmacage)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_tbmacage();
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
  public MemoryCursorRow_tbmacage _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_tbmacage _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_tbmacage> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_tbmacage p_Row) {
    MemoryCursorRow_tbmacage l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_tbmacage();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_tbmacage p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_tbmacage();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
