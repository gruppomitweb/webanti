public class MemoryCursorRow_cgo_import_age extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_import_age() {
  }
  public MemoryCursorRow_cgo_import_age(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_import_age toBuild = new MemoryCursor_cgo_import_age(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_import_age toBuild = new MemoryCursor_cgo_import_age();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NUMOPE = "";
  String CODFISC = "";
  String CODCAB = "";
  String RAGSOC = "";
  String DOMICILIO = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  String AUTRILASC = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  String TIPINTER = "";
  String SESSO = "";
  java.sql.Date DATAVALI = CPLib.NullDate();
  String NASSTATO = "";
  String NOME = "";
  String COGNOME = "";
  double CFESTERO = 0;
  String PEP = "";
  java.sql.Date DATAOPE = CPLib.NullDate();
  String CODDIPE = "";
  String FLAGCONT = "";
  String RAPPORTO = "";
  String FLAGLIRE = "";
  String VALUTA = "";
  String SEGNO = "";
  double TOTLIRE = 0;
  double TOTCONT = 0;
  String CONNESCLI = "";
  double CACODICE = 0;
  java.sql.Timestamp CADATAORA = CPLib.NullDateTime();
  String CAIDBIGLIETTO = "";
  String IBAN = "";
  String MEZPAGAM = "";
  String CGOFLGVLT = "";
  String CGOFLGVNP = "";
  String CGOTIPOPE = "";
  String CAFLGOPE = "";
  String TIPOGIOCO = "";
  String CODLOB = "";
  String ASSEGNO = "";
  java.sql.Date CADATIMP = CPLib.NullDate();
  String RDCODAUT = "";
  String RDLOCAUT = "";
  String VLTPLAT = "";
  String CC4CIFRE = "";
  String CCDATSCA = "";
  String NUMTEL = "";
  String IDDOCALL = "";
  String FLGDOCALL = "";
  double CCANNSCA = 0;
  double CCMESSCA = 0;
  String PEPDESCRI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODCAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAGSOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPODOC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMDOCUM))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATARILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTRILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCCIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINTER))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEP))) {
      return false;
    }
    if ( ! (CPLib.Empty(DATAOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLAGLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VALUTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTCONT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CONNESCLI))) {
      return false;
    }
    if ( ! (CPLib.Empty(CACODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CADATAORA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAIDBIGLIETTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IBAN))) {
      return false;
    }
    if ( ! (CPLib.Empty(MEZPAGAM))) {
      return false;
    }
    if ( ! (CPLib.Empty(CGOFLGVLT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CGOFLGVNP))) {
      return false;
    }
    if ( ! (CPLib.Empty(CGOTIPOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAFLGOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOGIOCO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(ASSEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CADATIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(RDCODAUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(RDLOCAUT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTPLAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CC4CIFRE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CCDATSCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMTEL))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDDOCALL))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGDOCALL))) {
      return false;
    }
    if ( ! (CPLib.Empty(CCANNSCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CCMESSCA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEPDESCRI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_import_age p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_import_age.this.NUMOPE = copyAndCast(p_row.NUMOPE);
      MemoryCursorRow_cgo_import_age.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_cgo_import_age.this.CODCAB = copyAndCast(p_row.CODCAB);
      MemoryCursorRow_cgo_import_age.this.RAGSOC = copyAndCast(p_row.RAGSOC);
      MemoryCursorRow_cgo_import_age.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_cgo_import_age.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_cgo_import_age.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_cgo_import_age.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_cgo_import_age.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_cgo_import_age.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_cgo_import_age.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_cgo_import_age.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_cgo_import_age.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_cgo_import_age.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_cgo_import_age.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_cgo_import_age.this.TIPINTER = copyAndCast(p_row.TIPINTER);
      MemoryCursorRow_cgo_import_age.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_cgo_import_age.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_cgo_import_age.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_cgo_import_age.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_cgo_import_age.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_cgo_import_age.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_cgo_import_age.this.PEP = copyAndCast(p_row.PEP);
      MemoryCursorRow_cgo_import_age.this.DATAOPE = copyAndCast(p_row.DATAOPE);
      MemoryCursorRow_cgo_import_age.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_cgo_import_age.this.FLAGCONT = copyAndCast(p_row.FLAGCONT);
      MemoryCursorRow_cgo_import_age.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_cgo_import_age.this.FLAGLIRE = copyAndCast(p_row.FLAGLIRE);
      MemoryCursorRow_cgo_import_age.this.VALUTA = copyAndCast(p_row.VALUTA);
      MemoryCursorRow_cgo_import_age.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_cgo_import_age.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_cgo_import_age.this.TOTCONT = copyAndCast(p_row.TOTCONT);
      MemoryCursorRow_cgo_import_age.this.CONNESCLI = copyAndCast(p_row.CONNESCLI);
      MemoryCursorRow_cgo_import_age.this.CACODICE = copyAndCast(p_row.CACODICE);
      MemoryCursorRow_cgo_import_age.this.CADATAORA = copyAndCast(p_row.CADATAORA);
      MemoryCursorRow_cgo_import_age.this.CAIDBIGLIETTO = copyAndCast(p_row.CAIDBIGLIETTO);
      MemoryCursorRow_cgo_import_age.this.IBAN = copyAndCast(p_row.IBAN);
      MemoryCursorRow_cgo_import_age.this.MEZPAGAM = copyAndCast(p_row.MEZPAGAM);
      MemoryCursorRow_cgo_import_age.this.CGOFLGVLT = copyAndCast(p_row.CGOFLGVLT);
      MemoryCursorRow_cgo_import_age.this.CGOFLGVNP = copyAndCast(p_row.CGOFLGVNP);
      MemoryCursorRow_cgo_import_age.this.CGOTIPOPE = copyAndCast(p_row.CGOTIPOPE);
      MemoryCursorRow_cgo_import_age.this.CAFLGOPE = copyAndCast(p_row.CAFLGOPE);
      MemoryCursorRow_cgo_import_age.this.TIPOGIOCO = copyAndCast(p_row.TIPOGIOCO);
      MemoryCursorRow_cgo_import_age.this.CODLOB = copyAndCast(p_row.CODLOB);
      MemoryCursorRow_cgo_import_age.this.ASSEGNO = copyAndCast(p_row.ASSEGNO);
      MemoryCursorRow_cgo_import_age.this.CADATIMP = copyAndCast(p_row.CADATIMP);
      MemoryCursorRow_cgo_import_age.this.RDCODAUT = copyAndCast(p_row.RDCODAUT);
      MemoryCursorRow_cgo_import_age.this.RDLOCAUT = copyAndCast(p_row.RDLOCAUT);
      MemoryCursorRow_cgo_import_age.this.VLTPLAT = copyAndCast(p_row.VLTPLAT);
      MemoryCursorRow_cgo_import_age.this.CC4CIFRE = copyAndCast(p_row.CC4CIFRE);
      MemoryCursorRow_cgo_import_age.this.CCDATSCA = copyAndCast(p_row.CCDATSCA);
      MemoryCursorRow_cgo_import_age.this.NUMTEL = copyAndCast(p_row.NUMTEL);
      MemoryCursorRow_cgo_import_age.this.IDDOCALL = copyAndCast(p_row.IDDOCALL);
      MemoryCursorRow_cgo_import_age.this.FLGDOCALL = copyAndCast(p_row.FLGDOCALL);
      MemoryCursorRow_cgo_import_age.this.CCANNSCA = copyAndCast(p_row.CCANNSCA);
      MemoryCursorRow_cgo_import_age.this.CCMESSCA = copyAndCast(p_row.CCMESSCA);
      MemoryCursorRow_cgo_import_age.this.PEPDESCRI = copyAndCast(p_row.PEPDESCRI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMOPE","CODFISC","CODCAB","RAGSOC","DOMICILIO","DATANASC","NASCOMUN","TIPODOC","NUMDOCUM","DATARILASC","AUTRILASC","DESCCIT","PROVINCIA","PAESE","CAP","TIPINTER","SESSO","DATAVALI","NASSTATO","NOME","COGNOME","CFESTERO","PEP","DATAOPE","CODDIPE","FLAGCONT","RAPPORTO","FLAGLIRE","VALUTA","SEGNO","TOTLIRE","TOTCONT","CONNESCLI","CACODICE","CADATAORA","CAIDBIGLIETTO","IBAN","MEZPAGAM","CGOFLGVLT","CGOFLGVNP","CGOTIPOPE","CAFLGOPE","TIPOGIOCO","CODLOB","ASSEGNO","CADATIMP","RDCODAUT","RDLOCAUT","VLTPLAT","CC4CIFRE","CCDATSCA","NUMTEL","IDDOCALL","FLGDOCALL","CCANNSCA","CCMESSCA","PEPDESCRI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","D","C","C","C","D","C","C","C","C","C","C","C","D","C","C","C","N","C","D","C","C","C","C","C","C","N","N","C","N","T","C","C","C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","C","C","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"N° Operazione","Codice Fiscale","CAB","Ragione Sociale","Indirizzo","Data Nascita","Luogo di Nascita","Tipo Documento","Numero Doc.","Data Rilascio Doc.","Autorità di rilascio","Città","Provincia","Stato","CAP","Provincia Nascita","Sesso","Fine Validità Documento","Stato di nascita","Nome","Cognome","Codice Fiscale Estero","Persona Politicamente Esposta","Data Operazione","Codice Dipendenza","Contanti (S/N)","Rapporto Collegato","Lire Euro Valuta","Divisa","Segno","Totale Operazione","di cui contanti","Codice Cliente Occasionale","Codice Causale","Data e Ora Movimento","ID BIGLIETTO","IBAN per Bonifici","Bonifico - Altro mezzo","Tipo Pagamento VLT","Pagamento Vincite prenotate","A=Agenzia - V=VLT","Tipo Registrazione","Tipo gioco","Line of business","Assegno","Data Import","Codice Autorità Rilascio","Luogo Autorità Rilascio","Piattaforma VLT","Ultime Cifre Carta di Credito","Carta Di Credito Scadenza","Numero Telefono","ID Collegamento Documenti","Flag Documentazione Completa","Carta Di Credito Scadenza","Mese Scadenza","Descrizione PEP"};
    return l_names;
  }
}
