public class MemoryCursorRow_qbe_trasffra_controllo_totale_vqr extends CPMemoryCursorRow {
  public MemoryCursorRow_qbe_trasffra_controllo_totale_vqr() {
  }
  public MemoryCursorRow_qbe_trasffra_controllo_totale_vqr(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_qbe_trasffra_controllo_totale_vqr toBuild = new MemoryCursor_qbe_trasffra_controllo_totale_vqr(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_qbe_trasffra_controllo_totale_vqr toBuild = new MemoryCursor_qbe_trasffra_controllo_totale_vqr();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String NUMPROG = "";
  String RIFIMP = "";
  String INFORM = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(NUMPROG))) {
      return false;
    }
    if ( ! (CPLib.Empty(RIFIMP))) {
      return false;
    }
    if ( ! (CPLib.Empty(INFORM))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_qbe_trasffra_controllo_totale_vqr p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_qbe_trasffra_controllo_totale_vqr.this.NUMPROG = copyAndCast(p_row.NUMPROG);
      MemoryCursorRow_qbe_trasffra_controllo_totale_vqr.this.RIFIMP = copyAndCast(p_row.RIFIMP);
      MemoryCursorRow_qbe_trasffra_controllo_totale_vqr.this.INFORM = copyAndCast(p_row.INFORM);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"NUMPROG","RIFIMP","INFORM"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"C","C","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Numero Progressivo","Riferimento 1","Riferimento 2"};
    return l_names;
  }
}
