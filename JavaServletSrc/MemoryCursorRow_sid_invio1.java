public class MemoryCursorRow_sid_invio1 extends CPMemoryCursorRow {
  public MemoryCursorRow_sid_invio1() {
  }
  public MemoryCursorRow_sid_invio1(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sid_invio1 toBuild = new MemoryCursor_sid_invio1(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sid_invio1 toBuild = new MemoryCursor_sid_invio1();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINVIO1 = "";
  String RAPINVIO1 = "";
  String TPRINVIO1 = "";
  java.sql.Date INIINVIO1 = CPLib.NullDate();
  java.sql.Date FININVIO1 = CPLib.NullDate();
  String CABINVIO1 = "";
  String ESIINVIO1 = "";
  String TIPINVIO1 = "";
  String TPCINVIO1 = "";
  String UNIQUE1 = "";
  String FLGUNQ1 = "";
  java.sql.Date MODINVIO1 = CPLib.NullDate();
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(TPRINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(INIINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(FININVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(CABINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(ESIINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(TIPINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(TPCINVIO1))) {
      return false;
    }
    if ( ! (CPLib.Empty(UNIQUE1))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGUNQ1))) {
      return false;
    }
    if ( ! (CPLib.Empty(MODINVIO1))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sid_invio1 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sid_invio1.this.CODINVIO1 = copyAndCast(p_row.CODINVIO1);
      MemoryCursorRow_sid_invio1.this.RAPINVIO1 = copyAndCast(p_row.RAPINVIO1);
      MemoryCursorRow_sid_invio1.this.TPRINVIO1 = copyAndCast(p_row.TPRINVIO1);
      MemoryCursorRow_sid_invio1.this.INIINVIO1 = copyAndCast(p_row.INIINVIO1);
      MemoryCursorRow_sid_invio1.this.FININVIO1 = copyAndCast(p_row.FININVIO1);
      MemoryCursorRow_sid_invio1.this.CABINVIO1 = copyAndCast(p_row.CABINVIO1);
      MemoryCursorRow_sid_invio1.this.ESIINVIO1 = copyAndCast(p_row.ESIINVIO1);
      MemoryCursorRow_sid_invio1.this.TIPINVIO1 = copyAndCast(p_row.TIPINVIO1);
      MemoryCursorRow_sid_invio1.this.TPCINVIO1 = copyAndCast(p_row.TPCINVIO1);
      MemoryCursorRow_sid_invio1.this.UNIQUE1 = copyAndCast(p_row.UNIQUE1);
      MemoryCursorRow_sid_invio1.this.FLGUNQ1 = copyAndCast(p_row.FLGUNQ1);
      MemoryCursorRow_sid_invio1.this.MODINVIO1 = copyAndCast(p_row.MODINVIO1);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINVIO1","RAPINVIO1","TPRINVIO1","INIINVIO1","FININVIO1","CABINVIO1","ESIINVIO1","TIPINVIO1","TPCINVIO1","UNIQUE1","FLGUNQ1","MODINVIO1"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","D","D","C","C","C","C","C","C","D"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Invio","Codice Univio Rapporto","Tipo Rapporto","Data Inizio Rapporto","Data Fine Rapporto","Codice CAB","ID Esito Invio","Tipo Invio","Tipo Comunicazione","Codice Univoco","Nuovo COdice Univoco","Data Modifica"};
    return l_names;
  }
}
