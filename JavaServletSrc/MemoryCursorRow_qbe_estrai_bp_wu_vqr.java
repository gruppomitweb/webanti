public class MemoryCursorRow_qbe_estrai_bp_wu_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_estrai_bp_wu_vqr() {
  }
  public MemoryCursorRow_qbe_estrai_bp_wu_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_estrai_bp_wu_vqr toBuild = new MemoryCursor_qbe_estrai_bp_wu_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_estrai_bp_wu_vqr toBuild = new MemoryCursor_qbe_estrai_bp_wu_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String SEGNO = "";
  String PROVINCIA1 = "";
  String PAESE = "";
  double IMPORTO = 0;
  double NUMOPE = 0;
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(SEGNO))) {
      return false;
    }
    if ( ! (CPLib.Empty(PROVINCIA1))) {
      return false;
    }
    if ( ! (CPLib.Empty(PAESE))) {
      return false;
    }
    if ( ! (CPLib.Empty(IMPORTO))) {
      return false;
    }
    if ( ! (CPLib.Empty(NUMOPE))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_estrai_bp_wu_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_estrai_bp_wu_vqr.this.SEGNO = copyAndCast(p_row.SEGNO);
      MemoryCursorRow_qbe_estrai_bp_wu_vqr.this.PROVINCIA1 = copyAndCast(p_row.PROVINCIA1);
      MemoryCursorRow_qbe_estrai_bp_wu_vqr.this.PAESE = copyAndCast(p_row.PAESE);
      MemoryCursorRow_qbe_estrai_bp_wu_vqr.this.IMPORTO = copyAndCast(p_row.IMPORTO);
      MemoryCursorRow_qbe_estrai_bp_wu_vqr.this.NUMOPE = copyAndCast(p_row.NUMOPE);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"SEGNO","PROVINCIA1","PAESE","IMPORTO","NUMOPE"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C","N","N"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Segno","Provincia","Stato","Importo","Operazioni"};
    return l_names;
  }
}
