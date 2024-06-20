public class MemoryCursorRow_wutrxchk_cases extends CPMemoryCursorRow {
  public MemoryCursorRow_wutrxchk_cases() {
  }
  public MemoryCursorRow_wutrxchk_cases(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_wutrxchk_cases toBuild = new MemoryCursor_wutrxchk_cases(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_wutrxchk_cases toBuild = new MemoryCursor_wutrxchk_cases();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  double TRXCODICE = 0;
  double TRXCODCASE = 0;
  String TRXNQUERY = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(TRXCODICE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXCODCASE))) {
      return false;
    }
    if ( ! (CPLib.Empty(TRXNQUERY))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_wutrxchk_cases p_row) {
    if ( ! (CPLib.IsNull(p_row) || p_row.equals(this))) {
      MemoryCursorRow_wutrxchk_cases.this.TRXCODICE = copyAndCast(p_row.TRXCODICE);
      MemoryCursorRow_wutrxchk_cases.this.TRXCODCASE = copyAndCast(p_row.TRXCODCASE);
      MemoryCursorRow_wutrxchk_cases.this.TRXNQUERY = copyAndCast(p_row.TRXNQUERY);
    }
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"TRXCODICE","TRXCODCASE","TRXNQUERY"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"N","N","C"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Numero transazione","Caso","Tipo Query da lanciare"};
    return l_names;
  }
}
