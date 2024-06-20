public class MemoryCursorRow_cgo_vlt_report extends CPMemoryCursorRow {
  public MemoryCursorRow_cgo_vlt_report() {
  }
  public MemoryCursorRow_cgo_vlt_report(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_cgo_vlt_report toBuild = new MemoryCursor_cgo_vlt_report(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_cgo_vlt_report toBuild = new MemoryCursor_cgo_vlt_report();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double VLTREP_IDPROG = 0;
  String VLTREP_AAMSSALA = "";
  String VLTREP_CODCONC = "";
  String VLTREP_CODPLAT = "";
  String VLTREP_AAMSVLT = "";
  String VLTREP_IDTICKET = "";
  double VLTREP_VALNOM = 0;
  java.sql.Date VLTREP_DATAEMI = CPLib.NullDate();
  java.sql.Date VLTREP_DATACONV = CPLib.NullDate();
  double VLTREP_IMPBET = 0;
  double VLTREP_GROSWIN = 0;
  double VLTREP_NETWIN = 0;
  double VLTREP_TOTALE = 0;
  double VLTREP_RAPPORTO1 = 0;
  double VLTREP_RAPPORTO2 = 0;
  double VLTREP_RAPPORTO3 = 0;
  String VLTREP_TICKET_BC = "";
  String VLTREP_ORIGINE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(VLTREP_IDPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_AAMSSALA))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_CODCONC))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_CODPLAT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_AAMSVLT))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_IDTICKET))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_VALNOM))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_DATAEMI))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_DATACONV))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_IMPBET))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_GROSWIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_NETWIN))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_TOTALE))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_RAPPORTO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_RAPPORTO2))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_RAPPORTO3))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_TICKET_BC))) {
      return false;
    }
    if ( ! (CPLib.Empty(VLTREP_ORIGINE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_cgo_vlt_report p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_IDPROG = copyAndCast(p_row.VLTREP_IDPROG);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_AAMSSALA = copyAndCast(p_row.VLTREP_AAMSSALA);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_CODCONC = copyAndCast(p_row.VLTREP_CODCONC);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_CODPLAT = copyAndCast(p_row.VLTREP_CODPLAT);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_AAMSVLT = copyAndCast(p_row.VLTREP_AAMSVLT);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_IDTICKET = copyAndCast(p_row.VLTREP_IDTICKET);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_VALNOM = copyAndCast(p_row.VLTREP_VALNOM);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_DATAEMI = copyAndCast(p_row.VLTREP_DATAEMI);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_DATACONV = copyAndCast(p_row.VLTREP_DATACONV);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_IMPBET = copyAndCast(p_row.VLTREP_IMPBET);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_GROSWIN = copyAndCast(p_row.VLTREP_GROSWIN);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_NETWIN = copyAndCast(p_row.VLTREP_NETWIN);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_TOTALE = copyAndCast(p_row.VLTREP_TOTALE);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_RAPPORTO1 = copyAndCast(p_row.VLTREP_RAPPORTO1);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_RAPPORTO2 = copyAndCast(p_row.VLTREP_RAPPORTO2);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_RAPPORTO3 = copyAndCast(p_row.VLTREP_RAPPORTO3);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_TICKET_BC = copyAndCast(p_row.VLTREP_TICKET_BC);
      MemoryCursorRow_cgo_vlt_report.this.VLTREP_ORIGINE = copyAndCast(p_row.VLTREP_ORIGINE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"VLTREP_IDPROG","VLTREP_AAMSSALA","VLTREP_CODCONC","VLTREP_CODPLAT","VLTREP_AAMSVLT","VLTREP_IDTICKET","VLTREP_VALNOM","VLTREP_DATAEMI","VLTREP_DATACONV","VLTREP_IMPBET","VLTREP_GROSWIN","VLTREP_NETWIN","VLTREP_TOTALE","VLTREP_RAPPORTO1","VLTREP_RAPPORTO2","VLTREP_RAPPORTO3","VLTREP_TICKET_BC","VLTREP_ORIGINE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","C","C","C","C","C","N","D","D","N","N","N","N","N","N","N","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Progressivo di inserimento","Codice AAMS Sala","Codice Concessione","Codice Piattaforma","Codice AAMS VLT","ID TICKET","Valore Nominale","Data/Ora Emissione","Data/Ora Convalida","Importo Giocate","Vincita Totale Lorda","Vincita Totale Netta","Importo Totale Introdotto","Rapporto BET su IN","Rapporto BET su PAID","Rapporto WIN su PAID","Ticket Bar Code","Emesso - Convalidato"};
    return l_names;
  }
}
