public class MemoryCursorRow_qbe_iremit_ope_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_iremit_ope_vqr() {
  }
  public MemoryCursorRow_qbe_iremit_ope_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_iremit_ope_vqr toBuild = new MemoryCursor_qbe_iremit_ope_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_iremit_ope_vqr toBuild = new MemoryCursor_qbe_iremit_ope_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NUMPROG = "";
  String IDBASE = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(IDBASE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_iremit_ope_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_iremit_ope_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_iremit_ope_vqr.this.IDBASE = copyAndCast(p_row.IDBASE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMPROG","IDBASE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Numero Progressivo","Idbase"};
    return l_names;
  }
}
