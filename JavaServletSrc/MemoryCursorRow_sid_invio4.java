public class MemoryCursorRow_sid_invio4 extends CPMemoryCursorRow {
  public MemoryCursorRow_sid_invio4() {
  }
  public MemoryCursorRow_sid_invio4(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_sid_invio4 toBuild = new MemoryCursor_sid_invio4(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_sid_invio4 toBuild = new MemoryCursor_sid_invio4();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODINVIO4 = "";
  String RAPINVIO4 = "";
  String NRPINVIO4 = "";
  String IDEINVIO4 = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODINVIO4))) {
      return false;
    }
    if ( ! (CPLib.Empty(RAPINVIO4))) {
      return false;
    }
    if ( ! (CPLib.Empty(NRPINVIO4))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDEINVIO4))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_sid_invio4 p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_sid_invio4.this.CODINVIO4 = copyAndCast(p_row.CODINVIO4);
      MemoryCursorRow_sid_invio4.this.RAPINVIO4 = copyAndCast(p_row.RAPINVIO4);
      MemoryCursorRow_sid_invio4.this.NRPINVIO4 = copyAndCast(p_row.NRPINVIO4);
      MemoryCursorRow_sid_invio4.this.IDEINVIO4 = copyAndCast(p_row.IDEINVIO4);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODINVIO4","RAPINVIO4","NRPINVIO4","IDEINVIO4"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Invio","Codice Univoco Rapporto","Nuovo Codice Univoco Rapporto","Invio Esito"};
    return l_names;
  }
}
