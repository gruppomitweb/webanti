public class MemoryCursorRow_sid_invio2 extends CPMemoryCursorRow {
  public MemoryCursorRow_sid_invio2() {
  }
  public MemoryCursorRow_sid_invio2(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sid_invio2 toBuild = new MemoryCursor_sid_invio2(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sid_invio2 toBuild = new MemoryCursor_sid_invio2();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINVIO2 = "";
  String RAPINVIO2 = "";
  double APRINVIO2 = 0;
  java.sql.Date INIINVIO2 = CPLib.NullDate();
  java.sql.Date FININVIO2 = CPLib.NullDate();
  double FCFINVIO2 = 0;
  String CFSINVIO2 = "";
  String RUOINVIO2 = "";
  String COGINVIO2 = "";
  String NOMINVIO2 = "";
  String SEXINVIO2 = "";
  java.sql.Date DNSINVIO2 = CPLib.NullDate();
  String CNSINVIO2 = "";
  String PNSINVIO2 = "";
  String RGSINVIO2 = "";
  String CSLINVIO2 = "";
  String PLSINVIO2 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(APRINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(INIINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(FININVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(FCFINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CFSINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RUOINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(COGINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(NOMINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(SEXINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(DNSINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CNSINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PNSINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(RGSINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(CSLINVIO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(PLSINVIO2))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sid_invio2 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sid_invio2.this.CODINVIO2 = copyAndCast(p_row.CODINVIO2);
      MemoryCursorRow_sid_invio2.this.RAPINVIO2 = copyAndCast(p_row.RAPINVIO2);
      MemoryCursorRow_sid_invio2.this.APRINVIO2 = copyAndCast(p_row.APRINVIO2);
      MemoryCursorRow_sid_invio2.this.INIINVIO2 = copyAndCast(p_row.INIINVIO2);
      MemoryCursorRow_sid_invio2.this.FININVIO2 = copyAndCast(p_row.FININVIO2);
      MemoryCursorRow_sid_invio2.this.FCFINVIO2 = copyAndCast(p_row.FCFINVIO2);
      MemoryCursorRow_sid_invio2.this.CFSINVIO2 = copyAndCast(p_row.CFSINVIO2);
      MemoryCursorRow_sid_invio2.this.RUOINVIO2 = copyAndCast(p_row.RUOINVIO2);
      MemoryCursorRow_sid_invio2.this.COGINVIO2 = copyAndCast(p_row.COGINVIO2);
      MemoryCursorRow_sid_invio2.this.NOMINVIO2 = copyAndCast(p_row.NOMINVIO2);
      MemoryCursorRow_sid_invio2.this.SEXINVIO2 = copyAndCast(p_row.SEXINVIO2);
      MemoryCursorRow_sid_invio2.this.DNSINVIO2 = copyAndCast(p_row.DNSINVIO2);
      MemoryCursorRow_sid_invio2.this.CNSINVIO2 = copyAndCast(p_row.CNSINVIO2);
      MemoryCursorRow_sid_invio2.this.PNSINVIO2 = copyAndCast(p_row.PNSINVIO2);
      MemoryCursorRow_sid_invio2.this.RGSINVIO2 = copyAndCast(p_row.RGSINVIO2);
      MemoryCursorRow_sid_invio2.this.CSLINVIO2 = copyAndCast(p_row.CSLINVIO2);
      MemoryCursorRow_sid_invio2.this.PLSINVIO2 = copyAndCast(p_row.PLSINVIO2);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINVIO2","RAPINVIO2","APRINVIO2","INIINVIO2","FININVIO2","FCFINVIO2","CFSINVIO2","RUOINVIO2","COGINVIO2","NOMINVIO2","SEXINVIO2","DNSINVIO2","CNSINVIO2","PNSINVIO2","RGSINVIO2","CSLINVIO2","PLSINVIO2"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","N","D","D","N","C","C","C","C","C","D","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Invio","Codice Univio Rapporto","Progressivo Anagrafica","Data Inizio Rapporto","Data Fine Rapporto","Flag Codice Fiscale","Codice Fiscale","Codice Ruolo","Cognome","Nome","Sesso (M/F)","Data Di Nascita","Luogo di Nascita","Provincia di Nascita","Ragione Sociale","Comune Sede Legale","Provincia Sede Legale"};
    return l_names;
  }
}
