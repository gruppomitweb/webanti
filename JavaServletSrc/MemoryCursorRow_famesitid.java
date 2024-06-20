public class MemoryCursorRow_famesitid extends CPMemoryCursorRow {
  public MemoryCursorRow_famesitid() {
  }
  public MemoryCursorRow_famesitid(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_famesitid toBuild = new MemoryCursor_famesitid(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_famesitid toBuild = new MemoryCursor_famesitid();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String FADRAPPORTO = "";
  double FADPROGR = 0;
  String FADCODFIS = "";
  double FADRUOLO = 0;
  java.sql.Date FADDATINI = CPLib.NullDate();
  java.sql.Date FADDATFIN = CPLib.NullDate();
  String FADTERNA1 = "";
  double FADTERNA2 = 0;
  String FADTERNA3 = "";
  String FADCOGRAG = "";
  String FADNOME = "";
  String FADSESSO = "";
  java.sql.Date FADDATNAS = CPLib.NullDate();
  String FADNASSEL = "";
  String FADPRVSEL = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(FADRAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADPROGR))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADCODFIS))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADRUOLO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADDATINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADDATFIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADTERNA1))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADTERNA2))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADTERNA3))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADCOGRAG))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADNOME))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADSESSO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADDATNAS))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADNASSEL))) {
      return false;
    }
    if ( ! (CPLib.Empty(FADPRVSEL))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_famesitid p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_famesitid.this.FADRAPPORTO = copyAndCast(p_row.FADRAPPORTO);
      MemoryCursorRow_famesitid.this.FADPROGR = copyAndCast(p_row.FADPROGR);
      MemoryCursorRow_famesitid.this.FADCODFIS = copyAndCast(p_row.FADCODFIS);
      MemoryCursorRow_famesitid.this.FADRUOLO = copyAndCast(p_row.FADRUOLO);
      MemoryCursorRow_famesitid.this.FADDATINI = copyAndCast(p_row.FADDATINI);
      MemoryCursorRow_famesitid.this.FADDATFIN = copyAndCast(p_row.FADDATFIN);
      MemoryCursorRow_famesitid.this.FADTERNA1 = copyAndCast(p_row.FADTERNA1);
      MemoryCursorRow_famesitid.this.FADTERNA2 = copyAndCast(p_row.FADTERNA2);
      MemoryCursorRow_famesitid.this.FADTERNA3 = copyAndCast(p_row.FADTERNA3);
      MemoryCursorRow_famesitid.this.FADCOGRAG = copyAndCast(p_row.FADCOGRAG);
      MemoryCursorRow_famesitid.this.FADNOME = copyAndCast(p_row.FADNOME);
      MemoryCursorRow_famesitid.this.FADSESSO = copyAndCast(p_row.FADSESSO);
      MemoryCursorRow_famesitid.this.FADDATNAS = copyAndCast(p_row.FADDATNAS);
      MemoryCursorRow_famesitid.this.FADNASSEL = copyAndCast(p_row.FADNASSEL);
      MemoryCursorRow_famesitid.this.FADPRVSEL = copyAndCast(p_row.FADPRVSEL);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"FADRAPPORTO","FADPROGR","FADCODFIS","FADRUOLO","FADDATINI","FADDATFIN","FADTERNA1","FADTERNA2","FADTERNA3","FADCOGRAG","FADNOME","FADSESSO","FADDATNAS","FADNASSEL","FADPRVSEL"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","N","D","D","C","N","C","C","C","C","D","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Rapporto","Progressivo Anagrafica","Codice Fiscale Soggetto Collegato","Ruolo Soggetto","Data Inizio presenza nel rapporto","Data fine presenza rapporto","Terna Primo Valore","Terna Valore 2","Terna Valore 3","Cognome Soggetto o Ragione Sociale","Nome Soggetto","Sesso","Data di nascita","Luogo di nascita / Sede Legale","Provincia Nascita / Sede Legale"};
    return l_names;
  }
}
