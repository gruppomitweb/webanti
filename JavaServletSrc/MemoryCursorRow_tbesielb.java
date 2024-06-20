public class MemoryCursorRow_tbesielb extends CPMemoryCursorRow {
  public MemoryCursorRow_tbesielb() {
  }
  public MemoryCursorRow_tbesielb(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_tbesielb toBuild = new MemoryCursor_tbesielb(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_tbesielb toBuild = new MemoryCursor_tbesielb();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String EECODICE = "";
  String EEDESCRI = "";
  String EEAZIONE = "";
  String EECOMMEN = "";
  String EELETINI = "";
  String EETIPESI = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(EECODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(EEDESCRI))) {
      return false;
    }
    if ( ! (CPLib.Empty(EEAZIONE))) {
      return false;
    }
    if ( ! (CPLib.Empty(EECOMMEN))) {
      return false;
    }
    if ( ! (CPLib.Empty(EELETINI))) {
      return false;
    }
    if ( ! (CPLib.Empty(EETIPESI))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_tbesielb p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_tbesielb.this.EECODICE = copyAndCast(p_row.EECODICE);
      MemoryCursorRow_tbesielb.this.EEDESCRI = copyAndCast(p_row.EEDESCRI);
      MemoryCursorRow_tbesielb.this.EEAZIONE = copyAndCast(p_row.EEAZIONE);
      MemoryCursorRow_tbesielb.this.EECOMMEN = copyAndCast(p_row.EECOMMEN);
      MemoryCursorRow_tbesielb.this.EELETINI = copyAndCast(p_row.EELETINI);
      MemoryCursorRow_tbesielb.this.EETIPESI = copyAndCast(p_row.EETIPESI);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"EECODICE","EEDESCRI","EEAZIONE","EECOMMEN","EELETINI","EETIPESI"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Errore","Descrizione","Azione","Commento","Lettera Iniziale","Tipo Esito"};
    return l_names;
  }
}
