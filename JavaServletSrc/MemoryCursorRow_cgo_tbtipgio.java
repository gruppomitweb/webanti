public class MemoryCursorRow_cgo_tbtipgio extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_tbtipgio() {
  }
  public MemoryCursorRow_cgo_tbtipgio(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_tbtipgio toBuild = new MemoryCursor_cgo_tbtipgio(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_tbtipgio toBuild = new MemoryCursor_cgo_tbtipgio();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODTPGIO = "";
  String DESTPGIO = "";
  double SOGTPGIO = 0;
  String DEFTPGIO = "";
  String EDTTPGIO = "";
  String EDTSPGIO = "";
  String DEFSPGIO = "";
  String FLGPLGIO = "";
  String FLGMLGIO = "";
  double MAGPAGGIO = 0;
  double MINPAGGIO = 0;
  double NCOPAGGIO = 0;
  String FDC1OSGIO = "";
  String FDC2OSGIO = "";
  String FDC3OSGIO = "";
  String FDC4OSGIO = "";
  String FDC5OSGIO = "";
  String FDC6OSGIO = "";
  String FDC1SSGIO = "";
  String FDC2SSGIO = "";
  String FDC3SSGIO = "";
  String FDC4SSGIO = "";
  String FDC5SSGIO = "";
  String FDC6SSGIO = "";
  String FDC1ACGIO = "";
  String FDC2ACGIO = "";
  String FDC3ACGIO = "";
  String FDC4ACGIO = "";
  String FDC5ACGIO = "";
  String FDC6ACGIO = "";
  String FLTIPGIO = "";
  String FLGATTIVO = "";
  double IMPMINGIO = 0;
  double IMPMINTOT = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODTPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESTPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(SOGTPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DEFTPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(EDTTPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(EDTSPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DEFSPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGPLGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGMLGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MAGPAGGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(MINPAGGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NCOPAGGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC1OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC2OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC3OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC4OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC5OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC6OSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC1SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC2SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC3SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC4SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC5SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC6SSGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC1ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC2ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC3ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC4ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC5ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FDC6ACGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLTIPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGATTIVO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPMINGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPMINTOT))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_tbtipgio p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_tbtipgio.this.CODTPGIO = copyAndCast(p_row.CODTPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.DESTPGIO = copyAndCast(p_row.DESTPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.SOGTPGIO = copyAndCast(p_row.SOGTPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.DEFTPGIO = copyAndCast(p_row.DEFTPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.EDTTPGIO = copyAndCast(p_row.EDTTPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.EDTSPGIO = copyAndCast(p_row.EDTSPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.DEFSPGIO = copyAndCast(p_row.DEFSPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FLGPLGIO = copyAndCast(p_row.FLGPLGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FLGMLGIO = copyAndCast(p_row.FLGMLGIO);
      MemoryCursorRow_cgo_tbtipgio.this.MAGPAGGIO = copyAndCast(p_row.MAGPAGGIO);
      MemoryCursorRow_cgo_tbtipgio.this.MINPAGGIO = copyAndCast(p_row.MINPAGGIO);
      MemoryCursorRow_cgo_tbtipgio.this.NCOPAGGIO = copyAndCast(p_row.NCOPAGGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC1OSGIO = copyAndCast(p_row.FDC1OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC2OSGIO = copyAndCast(p_row.FDC2OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC3OSGIO = copyAndCast(p_row.FDC3OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC4OSGIO = copyAndCast(p_row.FDC4OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC5OSGIO = copyAndCast(p_row.FDC5OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC6OSGIO = copyAndCast(p_row.FDC6OSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC1SSGIO = copyAndCast(p_row.FDC1SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC2SSGIO = copyAndCast(p_row.FDC2SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC3SSGIO = copyAndCast(p_row.FDC3SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC4SSGIO = copyAndCast(p_row.FDC4SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC5SSGIO = copyAndCast(p_row.FDC5SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC6SSGIO = copyAndCast(p_row.FDC6SSGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC1ACGIO = copyAndCast(p_row.FDC1ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC2ACGIO = copyAndCast(p_row.FDC2ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC3ACGIO = copyAndCast(p_row.FDC3ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC4ACGIO = copyAndCast(p_row.FDC4ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC5ACGIO = copyAndCast(p_row.FDC5ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FDC6ACGIO = copyAndCast(p_row.FDC6ACGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FLTIPGIO = copyAndCast(p_row.FLTIPGIO);
      MemoryCursorRow_cgo_tbtipgio.this.FLGATTIVO = copyAndCast(p_row.FLGATTIVO);
      MemoryCursorRow_cgo_tbtipgio.this.IMPMINGIO = copyAndCast(p_row.IMPMINGIO);
      MemoryCursorRow_cgo_tbtipgio.this.IMPMINTOT = copyAndCast(p_row.IMPMINTOT);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODTPGIO","DESTPGIO","SOGTPGIO","DEFTPGIO","EDTTPGIO","EDTSPGIO","DEFSPGIO","FLGPLGIO","FLGMLGIO","MAGPAGGIO","MINPAGGIO","NCOPAGGIO","FDC1OSGIO","FDC2OSGIO","FDC3OSGIO","FDC4OSGIO","FDC5OSGIO","FDC6OSGIO","FDC1SSGIO","FDC2SSGIO","FDC3SSGIO","FDC4SSGIO","FDC5SSGIO","FDC6SSGIO","FDC1ACGIO","FDC2ACGIO","FDC3ACGIO","FDC4ACGIO","FDC5ACGIO","FDC6ACGIO","FLTIPGIO","FLGATTIVO","IMPMINGIO","IMPMINTOT"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","N","C","C","C","C","C","C","N","N","N","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Tipo Gioco","Descrizione","Soglia pagamento Agenzia","Default Sopra Soglia","Abilita Modifica Sopra Soglia","Abilita Modifica Sotto Soglia","Default Sotto Soglia","Abilita Selezione Piattaforma","Inserimento Operazioni Multiple","N° Massimo Pagine Documento Unico o N° Max Documenti","N° Min. Pagine Documento Unico o N° Min Documenti","N° pagine Pagamento in contanti","Adeguata Verifica Sopra Soglia","Copia Biglietto","Codice Fiscale","Documento Riconoscimento","Copia Assegno Bancario","Obbligazione di pagamento","Adeguata Verifica Sotto Soglia","Copia Biglietto","Codice Fiscale","Documento Riconoscimento","Copia Assegno Bancario","Obbligazione di pagamento","Adeguata Verifica Sotto Soglia (Attivo se solo contanti)","Copia Biglietto  (Attivo se solo contanti)","Codice Fiscale  (Attivo se solo contanti)","Documento Riconoscimento  (Attivo se solo contanti)","Copia Assegno Bancario  (Attivo se solo contanti)","Obbligazione di pagamento  (Attivo se solo contanti)","V=VLT,A=Altro","Tipo Gioco Attivo","Importo minimo autovalidazione multiple","Importo Minimo Totale Multiple"};
    return l_names;
  }
}
