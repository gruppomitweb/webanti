public class MemoryCursorRow_mcanagrafiche_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mcanagrafiche_mcrdef() {
  }
  public MemoryCursorRow_mcanagrafiche_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mcanagrafiche_mcrdef toBuild = new MemoryCursor_mcanagrafiche_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mcanagrafiche_mcrdef toBuild = new MemoryCursor_mcanagrafiche_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CodiceIstituto = "";
  String DataElaborazione = "";
  String CodiceCliente = "";
  String CodiceFiscale = "";
  String Intestazione = "";
  String NascitaOSede = "";
  String DataDiNascita = "";
  String Indirizzo = "";
  String CAP = "";
  String CAB = "";
  String Localita = "";
  String Provincia = "";
  String Stato = "";
  String TipoDocumento = "";
  String NumeroDocumento = "";
  String DataRilascio = "";
  String AutoritaRilascio = "";
  String SAE = "";
  String RAE = "";
  String Sesso = "";
  String SportelloCapofila = "";
  String CabCapofila = "";
  String DataCensimento = "";
  String TipoSoggetto = "";
  String SoggettoOccasionale = "";
  String Cognome = "";
  String Nome = "";
  String ProvinciaNascita = "";
  String StatoNascita = "";
  String FormaGiuridica = "";
  String DataCostituzione = "";
  String Note = "";
  String DataRiferimento = "";
  String FlagAsiloPolitico = "";
  String PrevalenteAttivita = "";
  String ComportamentoTenuto = "";
  String ModalitaAcquisizione = "";
  String PatrimonioIntermediario = "";
  String CapacitaPatrimoniale = "";
  String Flag231 = "";
  String NazionalitaISO = "";
  String SocietaNonQuotata = "";
  String PrecedentiPenali = "";
  String AffidabilitaFinanziaria = "";
  String ProcedureConcorsuali = "";
  String ProfiloRischio = "";
  String ATECO = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CodiceIstituto))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataElaborazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceCliente))) {
      return false;
    }
    if ( ! (CPLib.Empty(CodiceFiscale))) {
      return false;
    }
    if ( ! (CPLib.Empty(Intestazione))) {
      return false;
    }
    if ( ! (CPLib.Empty(NascitaOSede))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataDiNascita))) {
      return false;
    }
    if ( ! (CPLib.Empty(Indirizzo))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(Localita))) {
      return false;
    }
    if ( ! (CPLib.Empty(Provincia))) {
      return false;
    }
    if ( ! (CPLib.Empty(Stato))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoDocumento))) {
      return false;
    }
    if ( ! (CPLib.Empty(NumeroDocumento))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataRilascio))) {
      return false;
    }
    if ( ! (CPLib.Empty(AutoritaRilascio))) {
      return false;
    }
    if ( ! (CPLib.Empty(SAE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAE))) {
      return false;
    }
    if ( ! (CPLib.Empty(Sesso))) {
      return false;
    }
    if ( ! (CPLib.Empty(SportelloCapofila))) {
      return false;
    }
    if ( ! (CPLib.Empty(CabCapofila))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataCensimento))) {
      return false;
    }
    if ( ! (CPLib.Empty(TipoSoggetto))) {
      return false;
    }
    if ( ! (CPLib.Empty(SoggettoOccasionale))) {
      return false;
    }
    if ( ! (CPLib.Empty(Cognome))) {
      return false;
    }
    if ( ! (CPLib.Empty(Nome))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProvinciaNascita))) {
      return false;
    }
    if ( ! (CPLib.Empty(StatoNascita))) {
      return false;
    }
    if ( ! (CPLib.Empty(FormaGiuridica))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataCostituzione))) {
      return false;
    }
    if ( ! (CPLib.Empty(Note))) {
      return false;
    }
    if ( ! (CPLib.Empty(DataRiferimento))) {
      return false;
    }
    if ( ! (CPLib.Empty(FlagAsiloPolitico))) {
      return false;
    }
    if ( ! (CPLib.Empty(PrevalenteAttivita))) {
      return false;
    }
    if ( ! (CPLib.Empty(ComportamentoTenuto))) {
      return false;
    }
    if ( ! (CPLib.Empty(ModalitaAcquisizione))) {
      return false;
    }
    if ( ! (CPLib.Empty(PatrimonioIntermediario))) {
      return false;
    }
    if ( ! (CPLib.Empty(CapacitaPatrimoniale))) {
      return false;
    }
    if ( ! (CPLib.Empty(Flag231))) {
      return false;
    }
    if ( ! (CPLib.Empty(NazionalitaISO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SocietaNonQuotata))) {
      return false;
    }
    if ( ! (CPLib.Empty(PrecedentiPenali))) {
      return false;
    }
    if ( ! (CPLib.Empty(AffidabilitaFinanziaria))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProcedureConcorsuali))) {
      return false;
    }
    if ( ! (CPLib.Empty(ProfiloRischio))) {
      return false;
    }
    if ( ! (CPLib.Empty(ATECO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mcanagrafiche_mcrdef p_row) {
    MemoryCursorRow_mcanagrafiche_mcrdef l_row = new MemoryCursorRow_mcanagrafiche_mcrdef();
    CopyOperation<MemoryCursorRow_mcanagrafiche_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CodiceIstituto = l_row.CodiceIstituto;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataElaborazione = l_row.DataElaborazione;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CodiceCliente = l_row.CodiceCliente;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CodiceFiscale = l_row.CodiceFiscale;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Intestazione = l_row.Intestazione;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.NascitaOSede = l_row.NascitaOSede;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataDiNascita = l_row.DataDiNascita;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Indirizzo = l_row.Indirizzo;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CAP = l_row.CAP;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CAB = l_row.CAB;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Localita = l_row.Localita;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Provincia = l_row.Provincia;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Stato = l_row.Stato;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.TipoDocumento = l_row.TipoDocumento;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.NumeroDocumento = l_row.NumeroDocumento;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataRilascio = l_row.DataRilascio;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.AutoritaRilascio = l_row.AutoritaRilascio;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.SAE = l_row.SAE;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.RAE = l_row.RAE;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Sesso = l_row.Sesso;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.SportelloCapofila = l_row.SportelloCapofila;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CabCapofila = l_row.CabCapofila;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataCensimento = l_row.DataCensimento;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.TipoSoggetto = l_row.TipoSoggetto;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.SoggettoOccasionale = l_row.SoggettoOccasionale;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Cognome = l_row.Cognome;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Nome = l_row.Nome;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ProvinciaNascita = l_row.ProvinciaNascita;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.StatoNascita = l_row.StatoNascita;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.FormaGiuridica = l_row.FormaGiuridica;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataCostituzione = l_row.DataCostituzione;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Note = l_row.Note;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.DataRiferimento = l_row.DataRiferimento;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.FlagAsiloPolitico = l_row.FlagAsiloPolitico;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.PrevalenteAttivita = l_row.PrevalenteAttivita;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ComportamentoTenuto = l_row.ComportamentoTenuto;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ModalitaAcquisizione = l_row.ModalitaAcquisizione;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.PatrimonioIntermediario = l_row.PatrimonioIntermediario;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.CapacitaPatrimoniale = l_row.CapacitaPatrimoniale;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.Flag231 = l_row.Flag231;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.NazionalitaISO = l_row.NazionalitaISO;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.SocietaNonQuotata = l_row.SocietaNonQuotata;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.PrecedentiPenali = l_row.PrecedentiPenali;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.AffidabilitaFinanziaria = l_row.AffidabilitaFinanziaria;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ProcedureConcorsuali = l_row.ProcedureConcorsuali;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ProfiloRischio = l_row.ProfiloRischio;
      MemoryCursorRow_mcanagrafiche_mcrdef.this.ATECO = l_row.ATECO;
    }
  }
  protected CopyOperation<MemoryCursorRow_mcanagrafiche_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mcanagrafiche_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mcanagrafiche_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mcanagrafiche_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mcanagrafiche_mcrdef p_From,MemoryCursorRow_mcanagrafiche_mcrdef p_To) {
        p_To.CodiceIstituto = copyAndCast(p_From.CodiceIstituto);
        p_To.DataElaborazione = copyAndCast(p_From.DataElaborazione);
        p_To.CodiceCliente = copyAndCast(p_From.CodiceCliente);
        p_To.CodiceFiscale = copyAndCast(p_From.CodiceFiscale);
        p_To.Intestazione = copyAndCast(p_From.Intestazione);
        p_To.NascitaOSede = copyAndCast(p_From.NascitaOSede);
        p_To.DataDiNascita = copyAndCast(p_From.DataDiNascita);
        p_To.Indirizzo = copyAndCast(p_From.Indirizzo);
        p_To.CAP = copyAndCast(p_From.CAP);
        p_To.CAB = copyAndCast(p_From.CAB);
        p_To.Localita = copyAndCast(p_From.Localita);
        p_To.Provincia = copyAndCast(p_From.Provincia);
        p_To.Stato = copyAndCast(p_From.Stato);
        p_To.TipoDocumento = copyAndCast(p_From.TipoDocumento);
        p_To.NumeroDocumento = copyAndCast(p_From.NumeroDocumento);
        p_To.DataRilascio = copyAndCast(p_From.DataRilascio);
        p_To.AutoritaRilascio = copyAndCast(p_From.AutoritaRilascio);
        p_To.SAE = copyAndCast(p_From.SAE);
        p_To.RAE = copyAndCast(p_From.RAE);
        p_To.Sesso = copyAndCast(p_From.Sesso);
        p_To.SportelloCapofila = copyAndCast(p_From.SportelloCapofila);
        p_To.CabCapofila = copyAndCast(p_From.CabCapofila);
        p_To.DataCensimento = copyAndCast(p_From.DataCensimento);
        p_To.TipoSoggetto = copyAndCast(p_From.TipoSoggetto);
        p_To.SoggettoOccasionale = copyAndCast(p_From.SoggettoOccasionale);
        p_To.Cognome = copyAndCast(p_From.Cognome);
        p_To.Nome = copyAndCast(p_From.Nome);
        p_To.ProvinciaNascita = copyAndCast(p_From.ProvinciaNascita);
        p_To.StatoNascita = copyAndCast(p_From.StatoNascita);
        p_To.FormaGiuridica = copyAndCast(p_From.FormaGiuridica);
        p_To.DataCostituzione = copyAndCast(p_From.DataCostituzione);
        p_To.Note = copyAndCast(p_From.Note);
        p_To.DataRiferimento = copyAndCast(p_From.DataRiferimento);
        p_To.FlagAsiloPolitico = copyAndCast(p_From.FlagAsiloPolitico);
        p_To.PrevalenteAttivita = copyAndCast(p_From.PrevalenteAttivita);
        p_To.ComportamentoTenuto = copyAndCast(p_From.ComportamentoTenuto);
        p_To.ModalitaAcquisizione = copyAndCast(p_From.ModalitaAcquisizione);
        p_To.PatrimonioIntermediario = copyAndCast(p_From.PatrimonioIntermediario);
        p_To.CapacitaPatrimoniale = copyAndCast(p_From.CapacitaPatrimoniale);
        p_To.Flag231 = copyAndCast(p_From.Flag231);
        p_To.NazionalitaISO = copyAndCast(p_From.NazionalitaISO);
        p_To.SocietaNonQuotata = copyAndCast(p_From.SocietaNonQuotata);
        p_To.PrecedentiPenali = copyAndCast(p_From.PrecedentiPenali);
        p_To.AffidabilitaFinanziaria = copyAndCast(p_From.AffidabilitaFinanziaria);
        p_To.ProcedureConcorsuali = copyAndCast(p_From.ProcedureConcorsuali);
        p_To.ProfiloRischio = copyAndCast(p_From.ProfiloRischio);
        p_To.ATECO = copyAndCast(p_From.ATECO);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CodiceIstituto","DataElaborazione","CodiceCliente","CodiceFiscale","Intestazione","NascitaOSede","DataDiNascita","Indirizzo","CAP","CAB","Localita","Provincia","Stato","TipoDocumento","NumeroDocumento","DataRilascio","AutoritaRilascio","SAE","RAE","Sesso","SportelloCapofila","CabCapofila","DataCensimento","TipoSoggetto","SoggettoOccasionale","Cognome","Nome","ProvinciaNascita","StatoNascita","FormaGiuridica","DataCostituzione","Note","DataRiferimento","FlagAsiloPolitico","PrevalenteAttivita","ComportamentoTenuto","ModalitaAcquisizione","PatrimonioIntermediario","CapacitaPatrimoniale","Flag231","NazionalitaISO","SocietaNonQuotata","PrecedentiPenali","AffidabilitaFinanziaria","ProcedureConcorsuali","ProfiloRischio","ATECO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice istituto","Data Elaborazione (AAAAMMGG)","Codice Cliente Collegato","Codice Fiscale","Intestazione (Ragione Sociale)","Luogo di Nascita o Sede","Data di Nascita","Indirizzo","C.A.P.","C.A.B.","Localita","Provincia","Stato","Tipo documento","Numero documento","Data rilascio","Autorità, località rilascio","Sottogruppo Attività Economica","Ramo/gruppo Attività Economica","Sesso","Sportello capofila","Cab dello sportello capofila","Data censimento anagrafico","Tipo soggetto (persona fisica o giuridica)","Soggetto occasionale","Cognome","Nome","Provincia di nascita","Stato di nascita","Forma giuridica","Data costituzione persona giuridica","Note","Data riferimento","Flag richiedente asilo politico","Prevalente attività svolta","Comportamento tenuto","Modalità di acquisizione del cliente","Patrimonio presso intermediario","Capacità patrimoniale del cliente al di fuori dell'intermediario","Flag 231","Nazionalità (codice ISO)","Società non quotata appartenente a gruppi quotati","Precedenti penali (persone fisiche)","Affidabilità finanziaria (persone fisiche)","Sottoposizione procedure concorsuali (persone giuridiche)","Profilo di Rischio","Codifica dell attività economica (ATECO 2007)"};
    return l_names;
  }
}
