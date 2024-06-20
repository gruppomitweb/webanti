public class MemoryCursorRow_qbe_sv_idp_rapporti_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_sv_idp_rapporti_vqr() {
  }
  public MemoryCursorRow_qbe_sv_idp_rapporti_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_sv_idp_rapporti_vqr toBuild = new MemoryCursor_qbe_sv_idp_rapporti_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_sv_idp_rapporti_vqr toBuild = new MemoryCursor_qbe_sv_idp_rapporti_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String RAPPORTO = "";
  String DESCRAP = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(RAPPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(DESCRAP))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_sv_idp_rapporti_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_sv_idp_rapporti_vqr.this.RAPPORTO = copyAndCast(p_row.RAPPORTO);
      MemoryCursorRow_qbe_sv_idp_rapporti_vqr.this.DESCRAP = copyAndCast(p_row.DESCRAP);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"RAPPORTO","DESCRAP"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Rapporto (Copia della testata)","Descrizione"};
    return l_names;
  }
}
