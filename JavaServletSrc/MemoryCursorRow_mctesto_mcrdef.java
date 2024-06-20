public class MemoryCursorRow_mctesto_mcrdef extends CPMemoryCursorRow {
  public MemoryCursorRow_mctesto_mcrdef() {
  }
  public MemoryCursorRow_mctesto_mcrdef(java.util.Properties p,CPContext p_Ctx) {
    MemoryCursor_mctesto_mcrdef toBuild = new MemoryCursor_mctesto_mcrdef(p,p_Ctx);
    Copy(toBuild.row);
  }
  public CPMemoryCursor AsMemoryCursor() {
    MemoryCursor_mctesto_mcrdef toBuild = new MemoryCursor_mctesto_mcrdef();
    // Utilizza Append per preservare l'identita' del valore di ritorno di una funzione che e' anche parametro
    toBuild.Append(this);
    return toBuild;
  }
  String testo = "";
  public boolean IsEmpty() {
    if ( ! (CPLib.Empty(testo))) {
      return false;
    }
    return true;
  }
  void Copy(MemoryCursorRow_mctesto_mcrdef p_row) {
    MemoryCursorRow_mctesto_mcrdef l_row = new MemoryCursorRow_mctesto_mcrdef();
    CopyOperation<MemoryCursorRow_mctesto_mcrdef> l_Operation = CopyOperator(null,null);
    l_Operation.m_RealTarget = this;
    if (l_Operation.CopyRowIfApplicable(l_row,p_row)) {
      MemoryCursorRow_mctesto_mcrdef.this.testo = l_row.testo;
    }
  }
  protected CopyOperation<MemoryCursorRow_mctesto_mcrdef> CopyOperator(CopyOperation<?> p_From,MemoryCursorRow_mctesto_mcrdef p_To) {
    CopyOperation<MemoryCursorRow_mctesto_mcrdef> l_Operation;
    l_Operation = new CopyOperation<MemoryCursorRow_mctesto_mcrdef>(p_From) {
      void CopyDeep(MemoryCursorRow_mctesto_mcrdef p_From,MemoryCursorRow_mctesto_mcrdef p_To) {
        p_To.testo = copyAndCast(p_From.testo);
      }
    };
    return l_Operation;
  }
  public String[] GetColumnNames() {
    String[] l_names;
    l_names=new String[]{"testo"};
    return l_names;
  }
  public String[] GetColumnTypes() {
    String[] l_names;
    l_names=new String[]{"M"};
    return l_names;
  }
  public String[] GetColumnDescriptions() {
    String[] l_names;
    l_names=new String[]{"Testo da scrivere"};
    return l_names;
  }
}
