// Definition generated from record definition mcanagrafiche_mcrdef
public class MemoryCursor_mcanagrafiche_mcrdef extends CPMemoryCursor {
  MemoryCursorRow_mcanagrafiche_mcrdef row;
  MemoryCursorRow_mcanagrafiche_mcrdef empty_row;
  public MemoryCursor_mcanagrafiche_mcrdef() {
    empty_row = new MemoryCursorRow_mcanagrafiche_mcrdef();
    row = empty_row;
  }
  public MemoryCursor_mcanagrafiche_mcrdef(java.util.Properties p,CPContext p_Ctx) {
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
    java.util.Properties p_CodiceCliente;
    p_CodiceCliente = new java.util.Properties();
    java.util.Properties p_CodiceFiscale;
    p_CodiceFiscale = new java.util.Properties();
    java.util.Properties p_Intestazione;
    p_Intestazione = new java.util.Properties();
    java.util.Properties p_NascitaOSede;
    p_NascitaOSede = new java.util.Properties();
    java.util.Properties p_DataDiNascita;
    p_DataDiNascita = new java.util.Properties();
    java.util.Properties p_Indirizzo;
    p_Indirizzo = new java.util.Properties();
    java.util.Properties p_CAP;
    p_CAP = new java.util.Properties();
    java.util.Properties p_CAB;
    p_CAB = new java.util.Properties();
    java.util.Properties p_Localita;
    p_Localita = new java.util.Properties();
    java.util.Properties p_Provincia;
    p_Provincia = new java.util.Properties();
    java.util.Properties p_Stato;
    p_Stato = new java.util.Properties();
    java.util.Properties p_TipoDocumento;
    p_TipoDocumento = new java.util.Properties();
    java.util.Properties p_NumeroDocumento;
    p_NumeroDocumento = new java.util.Properties();
    java.util.Properties p_DataRilascio;
    p_DataRilascio = new java.util.Properties();
    java.util.Properties p_AutoritaRilascio;
    p_AutoritaRilascio = new java.util.Properties();
    java.util.Properties p_SAE;
    p_SAE = new java.util.Properties();
    java.util.Properties p_RAE;
    p_RAE = new java.util.Properties();
    java.util.Properties p_Sesso;
    p_Sesso = new java.util.Properties();
    java.util.Properties p_SportelloCapofila;
    p_SportelloCapofila = new java.util.Properties();
    java.util.Properties p_CabCapofila;
    p_CabCapofila = new java.util.Properties();
    java.util.Properties p_DataCensimento;
    p_DataCensimento = new java.util.Properties();
    java.util.Properties p_TipoSoggetto;
    p_TipoSoggetto = new java.util.Properties();
    java.util.Properties p_SoggettoOccasionale;
    p_SoggettoOccasionale = new java.util.Properties();
    java.util.Properties p_Cognome;
    p_Cognome = new java.util.Properties();
    java.util.Properties p_Nome;
    p_Nome = new java.util.Properties();
    java.util.Properties p_ProvinciaNascita;
    p_ProvinciaNascita = new java.util.Properties();
    java.util.Properties p_StatoNascita;
    p_StatoNascita = new java.util.Properties();
    java.util.Properties p_FormaGiuridica;
    p_FormaGiuridica = new java.util.Properties();
    java.util.Properties p_DataCostituzione;
    p_DataCostituzione = new java.util.Properties();
    java.util.Properties p_Note;
    p_Note = new java.util.Properties();
    java.util.Properties p_DataRiferimento;
    p_DataRiferimento = new java.util.Properties();
    java.util.Properties p_FlagAsiloPolitico;
    p_FlagAsiloPolitico = new java.util.Properties();
    java.util.Properties p_PrevalenteAttivita;
    p_PrevalenteAttivita = new java.util.Properties();
    java.util.Properties p_ComportamentoTenuto;
    p_ComportamentoTenuto = new java.util.Properties();
    java.util.Properties p_ModalitaAcquisizione;
    p_ModalitaAcquisizione = new java.util.Properties();
    java.util.Properties p_PatrimonioIntermediario;
    p_PatrimonioIntermediario = new java.util.Properties();
    java.util.Properties p_CapacitaPatrimoniale;
    p_CapacitaPatrimoniale = new java.util.Properties();
    java.util.Properties p_Flag231;
    p_Flag231 = new java.util.Properties();
    java.util.Properties p_NazionalitaISO;
    p_NazionalitaISO = new java.util.Properties();
    java.util.Properties p_SocietaNonQuotata;
    p_SocietaNonQuotata = new java.util.Properties();
    java.util.Properties p_PrecedentiPenali;
    p_PrecedentiPenali = new java.util.Properties();
    java.util.Properties p_AffidabilitaFinanziaria;
    p_AffidabilitaFinanziaria = new java.util.Properties();
    java.util.Properties p_ProcedureConcorsuali;
    p_ProcedureConcorsuali = new java.util.Properties();
    java.util.Properties p_ProfiloRischio;
    p_ProfiloRischio = new java.util.Properties();
    java.util.Properties p_ATECO;
    p_ATECO = new java.util.Properties();
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
      if ("CodiceCliente".equalsIgnoreCase(key)) {
        p_CodiceCliente = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CodiceFiscale".equalsIgnoreCase(key)) {
        p_CodiceFiscale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Intestazione".equalsIgnoreCase(key)) {
        p_Intestazione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NascitaOSede".equalsIgnoreCase(key)) {
        p_NascitaOSede = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataDiNascita".equalsIgnoreCase(key)) {
        p_DataDiNascita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Indirizzo".equalsIgnoreCase(key)) {
        p_Indirizzo = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAP".equalsIgnoreCase(key)) {
        p_CAP = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CAB".equalsIgnoreCase(key)) {
        p_CAB = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Localita".equalsIgnoreCase(key)) {
        p_Localita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Provincia".equalsIgnoreCase(key)) {
        p_Provincia = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Stato".equalsIgnoreCase(key)) {
        p_Stato = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoDocumento".equalsIgnoreCase(key)) {
        p_TipoDocumento = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NumeroDocumento".equalsIgnoreCase(key)) {
        p_NumeroDocumento = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataRilascio".equalsIgnoreCase(key)) {
        p_DataRilascio = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AutoritaRilascio".equalsIgnoreCase(key)) {
        p_AutoritaRilascio = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SAE".equalsIgnoreCase(key)) {
        p_SAE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("RAE".equalsIgnoreCase(key)) {
        p_RAE = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Sesso".equalsIgnoreCase(key)) {
        p_Sesso = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SportelloCapofila".equalsIgnoreCase(key)) {
        p_SportelloCapofila = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CabCapofila".equalsIgnoreCase(key)) {
        p_CabCapofila = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataCensimento".equalsIgnoreCase(key)) {
        p_DataCensimento = CPLib.GetProperties(p.getProperty(key));
      }
      if ("TipoSoggetto".equalsIgnoreCase(key)) {
        p_TipoSoggetto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SoggettoOccasionale".equalsIgnoreCase(key)) {
        p_SoggettoOccasionale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Cognome".equalsIgnoreCase(key)) {
        p_Cognome = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Nome".equalsIgnoreCase(key)) {
        p_Nome = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProvinciaNascita".equalsIgnoreCase(key)) {
        p_ProvinciaNascita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("StatoNascita".equalsIgnoreCase(key)) {
        p_StatoNascita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FormaGiuridica".equalsIgnoreCase(key)) {
        p_FormaGiuridica = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataCostituzione".equalsIgnoreCase(key)) {
        p_DataCostituzione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Note".equalsIgnoreCase(key)) {
        p_Note = CPLib.GetProperties(p.getProperty(key));
      }
      if ("DataRiferimento".equalsIgnoreCase(key)) {
        p_DataRiferimento = CPLib.GetProperties(p.getProperty(key));
      }
      if ("FlagAsiloPolitico".equalsIgnoreCase(key)) {
        p_FlagAsiloPolitico = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PrevalenteAttivita".equalsIgnoreCase(key)) {
        p_PrevalenteAttivita = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ComportamentoTenuto".equalsIgnoreCase(key)) {
        p_ComportamentoTenuto = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ModalitaAcquisizione".equalsIgnoreCase(key)) {
        p_ModalitaAcquisizione = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PatrimonioIntermediario".equalsIgnoreCase(key)) {
        p_PatrimonioIntermediario = CPLib.GetProperties(p.getProperty(key));
      }
      if ("CapacitaPatrimoniale".equalsIgnoreCase(key)) {
        p_CapacitaPatrimoniale = CPLib.GetProperties(p.getProperty(key));
      }
      if ("Flag231".equalsIgnoreCase(key)) {
        p_Flag231 = CPLib.GetProperties(p.getProperty(key));
      }
      if ("NazionalitaISO".equalsIgnoreCase(key)) {
        p_NazionalitaISO = CPLib.GetProperties(p.getProperty(key));
      }
      if ("SocietaNonQuotata".equalsIgnoreCase(key)) {
        p_SocietaNonQuotata = CPLib.GetProperties(p.getProperty(key));
      }
      if ("PrecedentiPenali".equalsIgnoreCase(key)) {
        p_PrecedentiPenali = CPLib.GetProperties(p.getProperty(key));
      }
      if ("AffidabilitaFinanziaria".equalsIgnoreCase(key)) {
        p_AffidabilitaFinanziaria = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProcedureConcorsuali".equalsIgnoreCase(key)) {
        p_ProcedureConcorsuali = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ProfiloRischio".equalsIgnoreCase(key)) {
        p_ProfiloRischio = CPLib.GetProperties(p.getProperty(key));
      }
      if ("ATECO".equalsIgnoreCase(key)) {
        p_ATECO = CPLib.GetProperties(p.getProperty(key));
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
      row.CodiceCliente = CPLib.GetProperty(p_CodiceCliente,"","",i);
      row.CodiceFiscale = CPLib.GetProperty(p_CodiceFiscale,"","",i);
      row.Intestazione = CPLib.GetProperty(p_Intestazione,"","",i);
      row.NascitaOSede = CPLib.GetProperty(p_NascitaOSede,"","",i);
      row.DataDiNascita = CPLib.GetProperty(p_DataDiNascita,"","",i);
      row.Indirizzo = CPLib.GetProperty(p_Indirizzo,"","",i);
      row.CAP = CPLib.GetProperty(p_CAP,"","",i);
      row.CAB = CPLib.GetProperty(p_CAB,"","",i);
      row.Localita = CPLib.GetProperty(p_Localita,"","",i);
      row.Provincia = CPLib.GetProperty(p_Provincia,"","",i);
      row.Stato = CPLib.GetProperty(p_Stato,"","",i);
      row.TipoDocumento = CPLib.GetProperty(p_TipoDocumento,"","",i);
      row.NumeroDocumento = CPLib.GetProperty(p_NumeroDocumento,"","",i);
      row.DataRilascio = CPLib.GetProperty(p_DataRilascio,"","",i);
      row.AutoritaRilascio = CPLib.GetProperty(p_AutoritaRilascio,"","",i);
      row.SAE = CPLib.GetProperty(p_SAE,"","",i);
      row.RAE = CPLib.GetProperty(p_RAE,"","",i);
      row.Sesso = CPLib.GetProperty(p_Sesso,"","",i);
      row.SportelloCapofila = CPLib.GetProperty(p_SportelloCapofila,"","",i);
      row.CabCapofila = CPLib.GetProperty(p_CabCapofila,"","",i);
      row.DataCensimento = CPLib.GetProperty(p_DataCensimento,"","",i);
      row.TipoSoggetto = CPLib.GetProperty(p_TipoSoggetto,"","",i);
      row.SoggettoOccasionale = CPLib.GetProperty(p_SoggettoOccasionale,"","",i);
      row.Cognome = CPLib.GetProperty(p_Cognome,"","",i);
      row.Nome = CPLib.GetProperty(p_Nome,"","",i);
      row.ProvinciaNascita = CPLib.GetProperty(p_ProvinciaNascita,"","",i);
      row.StatoNascita = CPLib.GetProperty(p_StatoNascita,"","",i);
      row.FormaGiuridica = CPLib.GetProperty(p_FormaGiuridica,"","",i);
      row.DataCostituzione = CPLib.GetProperty(p_DataCostituzione,"","",i);
      row.Note = CPLib.GetProperty(p_Note,"","",i);
      row.DataRiferimento = CPLib.GetProperty(p_DataRiferimento,"","",i);
      row.FlagAsiloPolitico = CPLib.GetProperty(p_FlagAsiloPolitico,"","",i);
      row.PrevalenteAttivita = CPLib.GetProperty(p_PrevalenteAttivita,"","",i);
      row.ComportamentoTenuto = CPLib.GetProperty(p_ComportamentoTenuto,"","",i);
      row.ModalitaAcquisizione = CPLib.GetProperty(p_ModalitaAcquisizione,"","",i);
      row.PatrimonioIntermediario = CPLib.GetProperty(p_PatrimonioIntermediario,"","",i);
      row.CapacitaPatrimoniale = CPLib.GetProperty(p_CapacitaPatrimoniale,"","",i);
      row.Flag231 = CPLib.GetProperty(p_Flag231,"","",i);
      row.NazionalitaISO = CPLib.GetProperty(p_NazionalitaISO,"","",i);
      row.SocietaNonQuotata = CPLib.GetProperty(p_SocietaNonQuotata,"","",i);
      row.PrecedentiPenali = CPLib.GetProperty(p_PrecedentiPenali,"","",i);
      row.AffidabilitaFinanziaria = CPLib.GetProperty(p_AffidabilitaFinanziaria,"","",i);
      row.ProcedureConcorsuali = CPLib.GetProperty(p_ProcedureConcorsuali,"","",i);
      row.ProfiloRischio = CPLib.GetProperty(p_ProfiloRischio,"","",i);
      row.ATECO = CPLib.GetProperty(p_ATECO,"","",i);
    }
    if (CPLib.IsNull(p.getProperty("AtRow"))) {
      GoTop();
    } else {
      GoTo(CPLib.Val(p.getProperty("AtRow")));
    }
  }
  protected void SetCurrentRow(Object p_Row) {
    row = (MemoryCursorRow_mcanagrafiche_mcrdef)p_Row;
  }
  protected void SaveOnRow(Object p_Row) {
  }
  protected Object NewBlankRow() {
    return new MemoryCursorRow_mcanagrafiche_mcrdef();
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
  public MemoryCursorRow_mcanagrafiche_mcrdef _slice_(double p_nRow) {
    return super._slice_(p_nRow);
  }
  @SuppressWarnings("unchecked")
  public MemoryCursorRow_mcanagrafiche_mcrdef _get_(Object p_Key) {
    return super._get_(p_Key);
  }
  @SuppressWarnings("unchecked")
  public Iterable<MemoryCursorRow_mcanagrafiche_mcrdef> _iterable_() {
    return _iterable_(null,null);
  }
  public boolean AppendRow(MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Append(l_Row);
  }
  public boolean AppendRowWithKey(boolean p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(boolean p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(String p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(String p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(double p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(double p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Date p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(java.sql.Timestamp p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return super.InsertWithKey(p_Key,l_Row);
  }
  public boolean AppendRowWithKey(Object p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return AppendWithKey(p_Key,l_Row);
  }
  public boolean InsertRowWithKey(Object p_Key,MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return InsertWithKey(p_Key,l_Row);
  }
  public boolean InsertRow(MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_Row;
    if (CPLib.IsNull(p_Row)) {
      l_Row = null;
    } else {
      l_Row = new MemoryCursorRow_mcanagrafiche_mcrdef();
      l_Row.Copy(p_Row);
    }
    return Insert(l_Row);
  }
  public boolean CopyRow(MemoryCursorRow_mcanagrafiche_mcrdef p_Row) {
    if (CPLib.IsNull(p_Row)) {
      return false;
    } else if (CPLib.IsNull(this.row)) {
      this.row = new MemoryCursorRow_mcanagrafiche_mcrdef();
    }
    this.row.Copy(p_Row);
    return true;
  }
}
