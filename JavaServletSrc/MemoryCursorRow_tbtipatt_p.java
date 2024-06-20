public class MemoryCursorRow_tbtipatt_p extends CPMemoryCursorRow {
  public MemoryCursorRow_tbtipatt_p() {
  }
  public MemoryCursorRow_tbtipatt_p(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbtipatt_p toBuild = new MemoryCursor_tbtipatt_p(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbtipatt_p toBuild = new MemoryCursor_tbtipatt_p();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CODICE = "";
  double RISCHIO = 0;
  String FLGPERS = "";
  double FLGALTO = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(RISCHIO))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGPERS))) {
      return false;
    }
    if ( ! (CPLib.Empty(FLGALTO))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbtipatt_p p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbtipatt_p.this.CODICE = copyAndCast(p_row.CODICE);
      MemoryCursorRow_tbtipatt_p.this.RISCHIO = copyAndCast(p_row.RISCHIO);
      MemoryCursorRow_tbtipatt_p.this.FLGPERS = copyAndCast(p_row.FLGPERS);
      MemoryCursorRow_tbtipatt_p.this.FLGALTO = copyAndCast(p_row.FLGALTO);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CODICE","RISCHIO","FLGPERS","FLGALTO"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","N","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice","Indice Rischio","Valore Personalizzato","Attività ad alto rischio"};
    return l_names;
  }
}
