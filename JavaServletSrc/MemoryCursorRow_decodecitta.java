public class MemoryCursorRow_decodecitta extends CPMemoryCursorRow {
  public MemoryCursorRow_decodecitta() {
  }
  public MemoryCursorRow_decodecitta(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_decodecitta toBuild = new MemoryCursor_decodecitta(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_decodecitta toBuild = new MemoryCursor_decodecitta();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double ID = 0;
  String IDBASE = "";
  String CITTAMIT = "";
  String CAB = "";
  String PROV = "";
  String CAPMIT = "";
  String PKTBSTATI = "";
  String SIGLA = "";
  String PREF = "";
  String IDTBLS = "";
  String CITTA = "";
  String PR = "";
  String CATASTALE = "";
  String CAP = "";
  String REGIONE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(ID))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITTAMIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAB))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROV))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAPMIT))) {
      return false;
    }
    if ( ! (CPLib.Empty(PKTBSTATI))) {
      return false;
    }
    if ( ! (CPLib.Empty(SIGLA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PREF))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDTBLS))) {
      return false;
    }
    if ( ! (CPLib.Empty(CITTA))) {
      return false;
    }
    if ( ! (CPLib.Empty(PR))) {
      return false;
    }
    if ( ! (CPLib.Empty(CATASTALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAP))) {
      return false;
    }
    if ( ! (CPLib.Empty(REGIONE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_decodecitta p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_decodecitta.this.ID = copyAndCast(p_row.ID);
      MemoryCursorRow_decodecitta.this.IDBASE = copyAndCast(p_row.IDBASE);
      MemoryCursorRow_decodecitta.this.CITTAMIT = copyAndCast(p_row.CITTAMIT);
      MemoryCursorRow_decodecitta.this.CAB = copyAndCast(p_row.CAB);
      MemoryCursorRow_decodecitta.this.PROV = copyAndCast(p_row.PROV);
      MemoryCursorRow_decodecitta.this.CAPMIT = copyAndCast(p_row.CAPMIT);
      MemoryCursorRow_decodecitta.this.PKTBSTATI = copyAndCast(p_row.PKTBSTATI);
      MemoryCursorRow_decodecitta.this.SIGLA = copyAndCast(p_row.SIGLA);
      MemoryCursorRow_decodecitta.this.PREF = copyAndCast(p_row.PREF);
      MemoryCursorRow_decodecitta.this.IDTBLS = copyAndCast(p_row.IDTBLS);
      MemoryCursorRow_decodecitta.this.CITTA = copyAndCast(p_row.CITTA);
      MemoryCursorRow_decodecitta.this.PR = copyAndCast(p_row.PR);
      MemoryCursorRow_decodecitta.this.CATASTALE = copyAndCast(p_row.CATASTALE);
      MemoryCursorRow_decodecitta.this.CAP = copyAndCast(p_row.CAP);
      MemoryCursorRow_decodecitta.this.REGIONE = copyAndCast(p_row.REGIONE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"ID","IDBASE","CITTAMIT","CAB","PROV","CAPMIT","PKTBSTATI","SIGLA","PREF","IDTBLS","CITTA","PR","CATASTALE","CAP","REGIONE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C","C","C","C","C","C","C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"","Codice","Località","CAB","Provincia","CAP","Stato","Sigla","Prefisso Telefonico","","Città","","","","Regione"};
    return l_names;
  }
}
