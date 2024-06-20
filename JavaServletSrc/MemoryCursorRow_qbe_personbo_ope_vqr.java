public class MemoryCursorRow_qbe_personbo_ope_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_personbo_ope_vqr() {
  }
  public MemoryCursorRow_qbe_personbo_ope_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_personbo_ope_vqr toBuild = new MemoryCursor_qbe_personbo_ope_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_personbo_ope_vqr toBuild = new MemoryCursor_qbe_personbo_ope_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String CONNES = "";
  String CODFISC = "";
  String PARTIVA = "";
  double CAUSALE = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(CONNES))) {
      return false;
    }
    if ( ! (CPLib.Empty(CODFISC))) {
      return false;
    }
    if ( ! (CPLib.Empty(PARTIVA))) {
      return false;
    }
    if ( ! (CPLib.Empty(CAUSALE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_personbo_ope_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_personbo_ope_vqr.this.CONNES = copyAndCast(p_row.CONNES);
      MemoryCursorRow_qbe_personbo_ope_vqr.this.CODFISC = copyAndCast(p_row.CODFISC);
      MemoryCursorRow_qbe_personbo_ope_vqr.this.PARTIVA = copyAndCast(p_row.PARTIVA);
      MemoryCursorRow_qbe_personbo_ope_vqr.this.CAUSALE = copyAndCast(p_row.CAUSALE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"CONNES","CODFISC","PARTIVA","CAUSALE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Codice Cliente","Codice Fiscale","Partita IVA","Causale Default per prestazioni"};
    return l_names;
  }
}
