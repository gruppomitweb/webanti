public class MemoryCursorRow_cgo_telematico extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_telematico() {
  }
  public MemoryCursorRow_cgo_telematico(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_telematico toBuild = new MemoryCursor_cgo_telematico(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_telematico toBuild = new MemoryCursor_cgo_telematico();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SNAINUMOPE = "";
  String ENV = "";
  String CODDIPE = "";
  String RAPPORTO = "";
  double TOTLIRE = 0;
  double CACODICE = 0;
  java.sql.Timestamp CADATAORA = CPLib.NullDateTime();
  String CAIDBIGLIETTO = "";
  double CSMF_COD = 0;
  double NUM_CONC = 0;
  double P_VEND = 0;
  String IPCOLLEG = "";
  java.sql.Timestamp ORACOLLEG = CPLib.NullDateTime();
  double DUCOLLEG = 0;
  String IBAN = "";
  String MEZPAGAM = "";
  String TIPOGIOCO = "";
  String CODLOB = "";
  double CATIPGIO = 0;
  double CATIPCON = 0;
  double CAPV_COD = 0;
  String VPCODICE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SNAINUMOPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(ENV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODDIPE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(TOTLIRE))) {
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
    if ( ! (CPLib.Empty(CSMF_COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUM_CONC))) {
      return false;
    }
    if ( ! (CPLib.Empty(P_VEND))) {
      return false;
    }
    if ( ! (CPLib.Empty(IPCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(ORACOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(DUCOLLEG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IBAN))) {
      return false;
    }
    if ( ! (CPLib.Empty(MEZPAGAM))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPOGIOCO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODLOB))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATIPGIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATIPCON))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAPV_COD))) {
      return false;
    }
    if ( ! (CPLib.Empty(VPCODICE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_telematico p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_telematico.this.SNAINUMOPE = copyAndCast(p_row.SNAINUMOPE);
      MemoryCursorRow_cgo_telematico.this.ENV = copyAndCast(p_row.ENV);
      MemoryCursorRow_cgo_telematico.this.CODDIPE = copyAndCast(p_row.CODDIPE);
      MemoryCursorRow_cgo_telematico.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_cgo_telematico.this.TOTLIRE = copyAndCast(p_row.TOTLIRE);
      MemoryCursorRow_cgo_telematico.this.CACODICE = copyAndCast(p_row.CACODICE);
      MemoryCursorRow_cgo_telematico.this.CADATAORA = copyAndCast(p_row.CADATAORA);
      MemoryCursorRow_cgo_telematico.this.CAIDBIGLIETTO = copyAndCast(p_row.CAIDBIGLIETTO);
      MemoryCursorRow_cgo_telematico.this.CSMF_COD = copyAndCast(p_row.CSMF_COD);
      MemoryCursorRow_cgo_telematico.this.NUM_CONC = copyAndCast(p_row.NUM_CONC);
      MemoryCursorRow_cgo_telematico.this.P_VEND = copyAndCast(p_row.P_VEND);
      MemoryCursorRow_cgo_telematico.this.IPCOLLEG = copyAndCast(p_row.IPCOLLEG);
      MemoryCursorRow_cgo_telematico.this.ORACOLLEG = copyAndCast(p_row.ORACOLLEG);
      MemoryCursorRow_cgo_telematico.this.DUCOLLEG = copyAndCast(p_row.DUCOLLEG);
      MemoryCursorRow_cgo_telematico.this.IBAN = copyAndCast(p_row.IBAN);
      MemoryCursorRow_cgo_telematico.this.MEZPAGAM = copyAndCast(p_row.MEZPAGAM);
      MemoryCursorRow_cgo_telematico.this.TIPOGIOCO = copyAndCast(p_row.TIPOGIOCO);
      MemoryCursorRow_cgo_telematico.this.CODLOB = copyAndCast(p_row.CODLOB);
      MemoryCursorRow_cgo_telematico.this.CATIPGIO = copyAndCast(p_row.CATIPGIO);
      MemoryCursorRow_cgo_telematico.this.CATIPCON = copyAndCast(p_row.CATIPCON);
      MemoryCursorRow_cgo_telematico.this.CAPV_COD = copyAndCast(p_row.CAPV_COD);
      MemoryCursorRow_cgo_telematico.this.VPCODICE = copyAndCast(p_row.VPCODICE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SNAINUMOPE","ENV","CODDIPE","RAPPORTO","TOTLIRE","CACODICE","CADATAORA","CAIDBIGLIETTO","CSMF_COD","NUM_CONC","P_VEND","IPCOLLEG","ORACOLLEG","DUCOLLEG","IBAN","MEZPAGAM","TIPOGIOCO","CODLOB","CATIPGIO","CATIPCON","CAPV_COD","VPCODICE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","N","N","T","C","N","N","N","C","T","N","C","C","C","C","N","N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"N° Operazione","Web - Agenzia","Codice Dipendenza","Rapporto Collegato","Totale Operazione","Codice Causale","Data e Ora Movimento","ID BIGLIETTO","","","Punto Vendita","IP Collegamento","Inizio Collegamento","Durata Collegamento","IBAN","","Tipo gioco","Line of business","Tipo Gioco","Tipo Concessione","PV_COD","Piattaforma"};
    return l_names;
  }
}
