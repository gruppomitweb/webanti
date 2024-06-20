public class MemoryCursorRow_cgo_soggetti extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_soggetti() {
  }
  public MemoryCursorRow_cgo_soggetti(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_soggetti toBuild = new MemoryCursor_cgo_soggetti(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_soggetti toBuild = new MemoryCursor_cgo_soggetti();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String COGNOME = "";
  String NOME = "";
  String DOMICILIO = "";
  String DESCCIT = "";
  String PROVINCIA = "";
  String PAESE = "";
  String CAP = "";
  java.sql.Date DATANASC = CPLib.NullDate();
  String NASCOMUN = "";
  String NASSTATO = "";
  String NASPROV = "";
  String SESSO = "";
  String TIPODOC = "";
  String NUMDOCUM = "";
  java.sql.Date DATARILASC = CPLib.NullDate();
  java.sql.Date DATAVALI = CPLib.NullDate();
  String AUTRILASC = "";
  double CFESTERO = 0;
  String PEP = "";
  String FLGLIGHT = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(DOMICILIO))) {
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
    if ( ! (CPLib.Empty(DATANASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASCOMUN))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASSTATO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NASPROV))) {
      return false;
    }
    if ( ! (CPLib.Empty(SESSO))) {
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
    if ( ! (CPLib.Empty(DATAVALI))) {
      return false;
    }
    if ( ! (CPLib.Empty(AUTRILASC))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFESTERO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PEP))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGLIGHT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_soggetti p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_soggetti.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_cgo_soggetti.this.COGNOME = copyAndCast(p_row.COGNOME);
      MemoryCursorRow_cgo_soggetti.this.NOME = copyAndCast(p_row.NOME);
      MemoryCursorRow_cgo_soggetti.this.DOMICILIO = copyAndCast(p_row.DOMICILIO);
      MemoryCursorRow_cgo_soggetti.this.DESCCIT = copyAndCast(p_row.DESCCIT);
      MemoryCursorRow_cgo_soggetti.this.PROVINCIA = copyAndCast(p_row.PROVINCIA);
      MemoryCursorRow_cgo_soggetti.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_cgo_soggetti.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_cgo_soggetti.this.DATANASC = copyAndCast(p_row.DATANASC);
      MemoryCursorRow_cgo_soggetti.this.NASCOMUN = copyAndCast(p_row.NASCOMUN);
      MemoryCursorRow_cgo_soggetti.this.NASSTATO = copyAndCast(p_row.NASSTATO);
      MemoryCursorRow_cgo_soggetti.this.NASPROV = copyAndCast(p_row.NASPROV);
      MemoryCursorRow_cgo_soggetti.this.SESSO = copyAndCast(p_row.SESSO);
      MemoryCursorRow_cgo_soggetti.this.TIPODOC = copyAndCast(p_row.TIPODOC);
      MemoryCursorRow_cgo_soggetti.this.NUMDOCUM = copyAndCast(p_row.NUMDOCUM);
      MemoryCursorRow_cgo_soggetti.this.DATARILASC = copyAndCast(p_row.DATARILASC);
      MemoryCursorRow_cgo_soggetti.this.DATAVALI = copyAndCast(p_row.DATAVALI);
      MemoryCursorRow_cgo_soggetti.this.AUTRILASC = copyAndCast(p_row.AUTRILASC);
      MemoryCursorRow_cgo_soggetti.this.CFESTERO = copyAndCast(p_row.CFESTERO);
      MemoryCursorRow_cgo_soggetti.this.PEP = copyAndCast(p_row.PEP);
      MemoryCursorRow_cgo_soggetti.this.FLGLIGHT = copyAndCast(p_row.FLGLIGHT);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","COGNOME","NOME","DOMICILIO","DESCCIT","PROVINCIA","PAESE","CAP","DATANASC","NASCOMUN","NASSTATO","NASPROV","SESSO","TIPODOC","NUMDOCUM","DATARILASC","DATAVALI","AUTRILASC","CFESTERO","PEP","FLGLIGHT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C","C","C","D","C","C","C","C","C","C","D","D","C","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Collegamento (Codice Fiscale)","Cognome","Nome","Indirizzo","Città","Provincia","Stato","CAP","Data Nascita","Luogo di Nascita","Stato di nascita","Provincia di nascita (EE se nato estero)","Sesso","Tipo Documento","Numero Doc.","Data Rilascio Doc.","","Autorità di rilascio","Codice Fiscale Estero","Persona Politicamente Esposta","Riconoscimento Senza Documento"};
    return l_names;
  }
}
