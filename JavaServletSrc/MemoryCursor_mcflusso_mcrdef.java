// Definition generated from record definition mcflusso_mcrdef
public class MemoryCursor_mcflusso_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcflusso_mcrdef row;
  MemoryCursorRow_mcflusso_mcrdef empty_row;
  public MemoryCursor_mcflusso_mcrdef() {
    empty_row = new MemoryCursorRow_mcflusso_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcflusso_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    AppendData(p,p_Ctx);
  }
  public void AppendData(java.util.Properties p,CPContext p_Ctx) {
    int i = 0;
    double Rows = 0;
    Rows = CPLib.Val(p.getProperty("Rows"));
    java.util.Properties p_CodiceIstituto;
    p_CodiceIstituto = new java.util.Properties();
    java.util.Properties p_DataElaborazione;
    p_DataElaborazione = new java.util.Properties();
    java.util.Properties p_ProceduraOrigine;
    p_ProceduraOrigine = new java.util.Properties();
    java.util.Properties p_NumeroElettronicoOperante;
    p_NumeroElettronicoOperante = new java.util.Properties();
    java.util.Properties p_SottoNumeroOperazione;
    p_SottoNumeroOperazione = new java.util.Properties();
    java.util.Properties p_TipoRegistrazione;
    p_TipoRegistrazione = new java.util.Properties();
    java.util.Properties p_DataOperazione;
    p_DataOperazione = new java.util.Properties();
    java.util.Properties p_FilialeOperante;
    p_FilialeOperante = new java.util.Properties();
    java.util.Properties p_CodiceOperatore;
    p_CodiceOperatore = new java.util.Properties();
    java.util.Properties p_TerminaleOperante;
    p_TerminaleOperante = new java.util.Properties();
    java.util.Properties p_Transazione;
    p_Transazione = new java.util.Properties();
    java.util.Properties p_OperazioneCassa;
    p_OperazioneCassa = new java.util.Properties();
    java.util.Properties p_CausaleInterna;
    p_CausaleInterna = new java.util.Properties();
    java.util.Properties p_CodiceCausale;
    p_CodiceCausale = new java.util.Properties();
    java.util.Properties p_FlagContanti;
    p_FlagContanti = new java.util.Properties();
    java.util.Properties p_ImportoTotale;
    p_ImportoTotale = new java.util.Properties();
    java.util.Properties p_ImportoContante;
    p_ImportoContante = new java.util.Properties();
    java.util.Properties p_Segno;
    p_Segno = new java.util.Properties();
    java.util.Properties p_CodiceDivisa;
    p_CodiceDivisa = new java.util.Properties();
    java.util.Properties p_NumeroRapporto;
    p_NumeroRapporto = new java.util.Properties();
    java.util.Properties p_TipoRapportoAUI;
    p_TipoRapportoAUI = new java.util.Properties();
    java.util.Properties p_FormaTecnica;
    p_FormaTecnica = new java.util.Properties();
    java.util.Properties p_TipoRapportoIntermediario;
    p_TipoRapportoIntermediario = new java.util.Properties();
    java.util.Properties p_CABSportello;
    p_CABSportello = new java.util.Properties();
    java.util.Properties p_Note;
    p_Note = new java.util.Properties();
    java.util.Properties p_FlagSaggio;
    p_FlagSaggio = new java.util.Properties();
    java.util.Properties p_FlagPostRep;
    p_FlagPostRep = new java.util.Properties();
    java.util.Properties p_FILLER1;
    p_FILLER1 = new java.util.Properties();
    java.util.Properties p_Ragionevolezza;
    p_Ragionevolezza = new java.util.Properties();
    java.util.Properties p_Tipologia;
    p_Tipologia = new java.util.Properties();
    java.util.Properties p_Motivazione;
    p_Motivazione = new java.util.Properties();
    java.util.Properties p_NaturaScopo;
    p_NaturaScopo = new java.util.Properties();
    java.util.Properties p_TipoVerifica;
    p_TipoVerifica = new java.util.Properties();
    java.util.Properties p_ObbTitolareEff;
    p_ObbTitolareEff = new java.util.Properties();
    java.util.Properties p_SocFiduciaria;
    p_SocFiduciaria = new java.util.Properties();
    java.util.Properties p_NumeroOperazione;
    p_NumeroOperazione = new java.util.Properties();
    java.util.Properties p_ImportoFineMese;
    p_ImportoFineMese = new java.util.Properties();
    java.util.Properties p_FlagObbFiduciante;
    p_FlagObbFiduciante = new java.util.Properties();
    java.util.Properties p_FlagObbNumOpeLegame;
    p_FlagObbNumOpeLegame = new java.util.Properties();
    java.util.Properties p_NumOpeLegame;
    p_NumOpeLegame = new java.util.Properties();
    java.util.Properties l_Key;
    l_Key = new java.util.Properties();
    java.util.Enumeration e = p.propertyNames();
    String key;
    while (e.hasMoreElements()) {
      key = (String)e.nextElement();
      if ("Key".equalsIgnoreCase(key)) {
        l_Key = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceIstituto".equalsIgnoreCase(key)) {
        p_CodiceIstituto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataElaborazione".equalsIgnoreCase(key)) {
        p_DataElaborazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProceduraOrigine".equalsIgnoreCase(key)) {
        p_ProceduraOrigine = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumeroElettronicoOperante".equalsIgnoreCase(key)) {
        p_NumeroElettronicoOperante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SottoNumeroOperazione".equalsIgnoreCase(key)) {
        p_SottoNumeroOperazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoRegistrazione".equalsIgnoreCase(key)) {
        p_TipoRegistrazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataOperazione".equalsIgnoreCase(key)) {
        p_DataOperazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FilialeOperante".equalsIgnoreCase(key)) {
        p_FilialeOperante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceOperatore".equalsIgnoreCase(key)) {
        p_CodiceOperatore = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TerminaleOperante".equalsIgnoreCase(key)) {
        p_TerminaleOperante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Transazione".equalsIgnoreCase(key)) {
        p_Transazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("OperazioneCassa".equalsIgnoreCase(key)) {
        p_OperazioneCassa = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CausaleInterna".equalsIgnoreCase(key)) {
        p_CausaleInterna = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceCausale".equalsIgnoreCase(key)) {
        p_CodiceCausale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagContanti".equalsIgnoreCase(key)) {
        p_FlagContanti = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ImportoTotale".equalsIgnoreCase(key)) {
        p_ImportoTotale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ImportoContante".equalsIgnoreCase(key)) {
        p_ImportoContante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Segno".equalsIgnoreCase(key)) {
        p_Segno = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceDivisa".equalsIgnoreCase(key)) {
        p_CodiceDivisa = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumeroRapporto".equalsIgnoreCase(key)) {
        p_NumeroRapporto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoRapportoAUI".equalsIgnoreCase(key)) {
        p_TipoRapportoAUI = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FormaTecnica".equalsIgnoreCase(key)) {
        p_FormaTecnica = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoRapportoIntermediario".equalsIgnoreCase(key)) {
        p_TipoRapportoIntermediario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CABSportello".equalsIgnoreCase(key)) {
        p_CABSportello = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Note".equalsIgnoreCase(key)) {
        p_Note = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagSaggio".equalsIgnoreCase(key)) {
        p_FlagSaggio = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagPostRep".equalsIgnoreCase(key)) {
        p_FlagPostRep = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FILLER1".equalsIgnoreCase(key)) {
        p_FILLER1 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Ragionevolezza".equalsIgnoreCase(key)) {
        p_Ragionevolezza = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Tipologia".equalsIgnoreCase(key)) {
        p_Tipologia = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Motivazione".equalsIgnoreCase(key)) {
        p_Motivazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NaturaScopo".equalsIgnoreCase(key)) {
        p_NaturaScopo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoVerifica".equalsIgnoreCase(key)) {
        p_TipoVerifica = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ObbTitolareEff".equalsIgnoreCase(key)) {
        p_ObbTitolareEff = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SocFiduciaria".equalsIgnoreCase(key)) {
        p_SocFiduciaria = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumeroOperazione".equalsIgnoreCase(key)) {
        p_NumeroOperazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ImportoFineMese".equalsIgnoreCase(key)) {
        p_ImportoFineMese = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagObbFiduciante".equalsIgnoreCase(key)) {
        p_FlagObbFiduciante = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagObbNumOpeLegame".equalsIgnoreCase(key)) {
        p_FlagObbNumOpeLegame = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumOpeLegame".equalsIgnoreCase(key)) {
        p_NumOpeLegame = CPLib.GetProperties(p.getProperty(key));
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
      row.CodiceIstituto = CPLib.GetProperty(p_CodiceIstituto,"","",i);
      row.DataElaborazione = CPLib.GetProperty(p_DataElaborazione,"","",i);
      row.ProceduraOrigine = CPLib.GetProperty(p_ProceduraOrigine,"","",i);
      row.NumeroElettronicoOperante = CPLib.GetProperty(p_NumeroElettronicoOperante,"","",i);
      row.SottoNumeroOperazione = CPLib.GetProperty(p_SottoNumeroOperazione,"","",i);
      row.TipoRegistrazione = CPLib.GetProperty(p_TipoRegistrazione,"","",i);
      row.DataOperazione = CPLib.GetProperty(p_DataOperazione,"","",i);
      row.FilialeOperante = CPLib.GetProperty(p_FilialeOperante,"","",i);
      row.CodiceOperatore = CPLib.GetProperty(p_CodiceOperatore,"","",i);
      row.TerminaleOperante = CPLib.GetProperty(p_TerminaleOperante,"","",i);
      row.Transazione = CPLib.GetProperty(p_Transazione,"","",i);
      row.OperazioneCassa = CPLib.GetProperty(p_OperazioneCassa,"","",i);
      row.CausaleInterna = CPLib.GetProperty(p_CausaleInterna,"","",i);
      row.CodiceCausale = CPLib.GetProperty(p_CodiceCausale,"","",i);
      row.FlagContanti = CPLib.GetProperty(p_FlagContanti,"","",i);
      row.ImportoTotale = CPLib.GetProperty(p_ImportoTotale,"",0,i);
      row.ImportoContante = CPLib.GetProperty(p_ImportoContante,"",0,i);
      row.Segno = CPLib.GetProperty(p_Segno,"","",i);
      row.CodiceDivisa = CPLib.GetProperty(p_CodiceDivisa,"","",i);
      row.NumeroRapporto = CPLib.GetProperty(p_NumeroRapporto,"","",i);
      row.TipoRapportoAUI = CPLib.GetProperty(p_TipoRapportoAUI,"","",i);
      row.FormaTecnica = CPLib.GetProperty(p_FormaTecnica,"","",i);
      row.TipoRapportoIntermediario = CPLib.GetProperty(p_TipoRapportoIntermediario,"","",i);
      row.CABSportello = CPLib.GetProperty(p_CABSportello,"","",i);
      row.Note = CPLib.GetProperty(p_Note,"","",i);
      row.FlagSaggio = CPLib.GetProperty(p_FlagSaggio,"","",i);
      row.FlagPostRep = CPLib.GetProperty(p_FlagPostRep,"","",i);
      row.FILLER1 = CPLib.GetProperty(p_FILLER1,"","",i);
      row.Ragionevolezza = CPLib.GetProperty(p_Ragionevolezza,"","",i);
      row.Tipologia = CPLib.GetProperty(p_Tipologia,"","",i);
      row.Motivazione = CPLib.GetProperty(p_Motivazione,"","",i);
      row.NaturaScopo = CPLib.GetProperty(p_NaturaScopo,"","",i);
      row.TipoVerifica = CPLib.GetProperty(p_TipoVerifica,"","",i);
      row.ObbTitolareEff = CPLib.GetProperty(p_ObbTitolareEff,"","",i);
      row.SocFiduciaria = CPLib.GetProperty(p_SocFiduciaria,"","",i);
      row.NumeroOperazione = CPLib.GetProperty(p_NumeroOperazione,"","",i);
      row.ImportoFineMese = CPLib.GetProperty(p_ImportoFineMese,"",0,i);
      row.FlagObbFiduciante = CPLib.GetProperty(p_FlagObbFiduciante,"","",i);
      row.FlagObbNumOpeLegame = CPLib.GetProperty(p_FlagObbNumOpeLegame,"","",i);
      row.NumOpeLegame = CPLib.GetProperty(p_NumOpeLegame,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcflusso_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcflusso_mcrdef();
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
  public MemoryCursorRow_mcflusso_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcflusso_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcflusso_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcflusso_mcrdef p_Row) {
    MemoryCursorRow_mcflusso_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcflusso_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcflusso_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcflusso_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
