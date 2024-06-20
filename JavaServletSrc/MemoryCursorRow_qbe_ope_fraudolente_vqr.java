public class MemoryCursorRow_qbe_ope_fraudolente_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_ope_fraudolente_vqr() {
  }
  public MemoryCursorRow_qbe_ope_fraudolente_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_ope_fraudolente_vqr toBuild = new MemoryCursor_qbe_ope_fraudolente_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_ope_fraudolente_vqr toBuild = new MemoryCursor_qbe_ope_fraudolente_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String TIPO = "";
  String NUMPROG = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TIPO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_ope_fraudolente_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_ope_fraudolente_vqr.this.TIPO = copyAndCast(p_row.TIPO);
      MemoryCursorRow_qbe_ope_fraudolente_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TIPO","NUMPROG"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Fonte","Numero Progressivo"};
    return l_names;
  }
}
